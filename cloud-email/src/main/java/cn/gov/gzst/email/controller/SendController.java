package cn.gov.gzst.email.controller;

import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.utils.EmailFormatCheckUtils;
import cn.gov.gzst.email.common.bean.ResponseError;
import cn.gov.gzst.email.service.ISendService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @title 邮件发送
 * @description 邮件发送
 */
@Controller
@RequestMapping("send")
public class SendController extends BaseController {
    @Autowired
    private ISendService sendService;

    /**
     * 邮件发送
     * 暂时不验证客户端
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult user(@RequestParam("email") String email, @RequestParam("code") String code,
                               @RequestParam(value = "datas", required = false) Map<String, Object> datas, HttpServletRequest request) {
        ResponseResult apiResult = new ResponseResult();
        try {
            if (StringUtils.isEmpty(email)) {
                apiResult.fail(ResponseError.MSG_EMAIL_EMAIL_ISNULL);
                return apiResult;
            }
            if (StringUtils.isEmpty(code)) {
                apiResult.fail(ResponseError.MSG_EMAIL_CODE_ISNULL);
                return apiResult;
            }
			/*//检查提交的客户端id是否正确
			if (!oAuthService.checkClientId(clientId)) {
				return apiResult.fail( ResponseError.INVALID_CLIENT);
			}
			// 检查客户端安全KEY是否正确
			if (!oAuthService.checkClientSecret(clientSecret)) {
				apiResult.fail(ResponseError.INVALID_CLIENT_SECRET);
				return apiResult;
			}*/
            //检查EMAIL
            if (!EmailFormatCheckUtils.isEmailLegal(email)) {
                apiResult.fail(ResponseError.MSG_EMAIL_INVALID_PHONE);
                return apiResult;
            }

            if (datas == null) {
                datas = Maps.newHashMap();
            }
            if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(code)) {
                sendService.sendAsyncEmailByCode(email, code, datas);
            }
        } catch (Exception e) {
            apiResult.fail(ResponseError.MSG_EMAIL_NET_FAILE);
        }
        return apiResult;
    }

    @RequestMapping(value = "/massSendEmailByCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult massSendEmailByCode(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("邮件发送成功");
        try {
            String email = request.getParameter("email");
            String code = request.getParameter("code");
            String data = request.getParameter("data");
            String[] emails = email.split(",");
            Map<String, Object> datas = null;
            for (String emailItem : emails) {
                if (!StringUtils.isEmpty(data)) {
                    datas = JSONObject.parseObject(data);
                    sendService.sendAsyncEmailByCode(emailItem, code, datas);
                } else {
                    sendService.sendAsyncEmailByCode(emailItem, code);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "邮件发送失败");
        }
        return responseResult;
    }
}