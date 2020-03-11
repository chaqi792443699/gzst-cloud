package cn.gov.gzst.sms.controller.api;

import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.utils.PhoneFormatCheckUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.security.Md5Utils;
import cn.gov.gzst.common.utils.sms.data.SmsResult;
import cn.gov.gzst.sms.common.Constants;
import cn.gov.gzst.sms.common.bean.ResponseError;
import cn.gov.gzst.sms.service.ISmsSendService;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 短信发送接口
 */
@Controller
@RequestMapping("smsApi")
public class SmsSendApiController extends BaseController {
    @Autowired
    private ISmsSendService smsSendService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 短信发送
     * 暂时不验证客户端
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult user(@RequestParam("phone") String phone, @RequestParam("code") String code,
                               HttpServletRequest request) {
        ResponseResult apiResult = new ResponseResult();
        try {
            if (StringUtils.isEmpty(phone)) {
                apiResult.fail(ResponseError.MSG_SMS_PHONE_ISNULL);
                return apiResult;
            }
            if (StringUtils.isEmpty(code)) {
                apiResult.fail(ResponseError.MSG_SMS_CODE_ISNULL);
                return apiResult;
            }
            String data = request.getParameter("data");
            if (StringUtils.isEmpty(data)) {
                data = "";
            }
            SmsResult smsResult = new SmsResult();
            //检查phone
            if (!PhoneFormatCheckUtils.isPhoneLegal(phone)) {
                apiResult.fail(ResponseError.MSG_SMS_INVALID_PHONE);
                return apiResult;
            }
            //检查五分钟内是否有相同的短信发送
            String strHash = "FIVE_M_" + Md5Utils.hash(phone + code + StringUtils.join(data));
            Boolean isSend = (Boolean) redisTemplate.opsForValue().get(strHash);
            if (isSend != null && isSend) {
                apiResult.fail(ResponseError.MSG_SMS_NOT_REPEAT);
                return apiResult;
            }

            //同一手机号验证码短信发送超出5条
            //检查五分钟内是否有相同的短信发送
            String sameHash = "SAME_M_" + Md5Utils.hash(phone + code + StringUtils.join(data));
            Integer sendNumber = (Integer) redisTemplate.opsForValue().get(sameHash);
            if (sendNumber == null) {
                sendNumber = 0;
            }
            if (sendNumber > 5) {
                apiResult.fail(ResponseError.MSG_SMS_SAME_REPEAT);
                return apiResult;
            }

            String[] datas = {};
            if (!StringUtils.isEmpty(data)) {
                datas = data.split(",");
            }
            if (!StringUtils.isEmpty(phone) && !StringUtils.isEmpty(code)) {
                //第三方平台需要一个短信的编码，便于后期业务处理
                String smsid = smsSendService.sendAsyncSmsByCode(phone, code, datas);
                apiResult.put("smsid", smsid);
            }
            //设置重新发送限制
            redisTemplate.opsForValue().set(strHash, Boolean.TRUE, Constants.PHONE_EXPIRES_IN);
            //设置发送数量限制
            redisTemplate.opsForValue().set(sameHash, sendNumber, Constants.PHONE_SAME_CODE_EXPIRES_IN);
        } catch (Exception e) {
            apiResult.fail(ResponseError.MSG_SMS_NET_FAILE);
        }
        return apiResult;
    }

    @RequestMapping(value = "/sendSmsByCode", method = RequestMethod.POST)
    @ResponseBody
    @Login(action = Action.Skip)
    public ResponseResult sendSmsByCode(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("短信发送成功");
        try {
            String phone = request.getParameter("phone");
            String code = request.getParameter("code");
            String data = request.getParameter("data");
            SmsResult smsResult = null;
            if (!StringUtils.isEmpty(data)) {
                String[] datas = data.split(",");
                smsResult = smsSendService.sendSyncSmsByCode(phone, code, datas);
            } else {
                smsResult = smsSendService.sendSyncSmsByCode(phone, code);
            }

            if (!smsResult.isSuccess()) {
                responseResult.fail(0,"短信发送失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(0,"短信发送失败");
        }
        return responseResult;
    }

    @RequestMapping(value = "/massSendSmsByCode", method = RequestMethod.POST)
    @ResponseBody
    @Login(action = Action.Skip)
    public ResponseResult massSendSmsByCode(@RequestParam("phone") String phone, @RequestParam("code") String code, @RequestParam("data") String data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("短信发送成功");
        try {
            String[] phones = phone.split(",");
            for (String phoneItem : phones) {
                if (!StringUtils.isEmpty(data)) {
                    String[] datas = data.split(",");
                    smsSendService.sendAsyncSmsByCode(phoneItem, code, datas);
                } else {
                    smsSendService.sendAsyncSmsByCode(phoneItem, code);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(0,"短信发送失败");
        }
        return responseResult;
    }
}