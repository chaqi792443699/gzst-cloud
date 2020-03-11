package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.common.constant.Constants;
import cn.gov.gzst.admin.service.IPhoneVerifyCodeService;
import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.utils.Md5Utils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.sms.feign.SmsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @title:
 * @description: 验证码服务
 */
@Service("phoneVerificationCodeService")
public class PhoneVerifyCodeServiceImpl implements IPhoneVerifyCodeService {

    @Autowired
    private RedisTemplate redisTemplate;
    private final static String VERIFICATION_CODE_PRE = "VERIFICATION_PHONE_CODE_PRE_";
    private final static Integer DEFAULT_EXPIRESIN = 10 * 60; //默认十分钟
    @Autowired
    private SmsFeign smsFeign;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String generateCode(String phone, String businessKey) {
        return generateCode(phone, businessKey, DEFAULT_EXPIRESIN);
    }

    @Override
    public String generateCode(String phone, String businessKey, long expiresIn) {
        return generateCode(phone, Constants.DEFAULT_SMS_VERIFY_TEMPLATE_CODE, businessKey, expiresIn);
    }

    @Override
    public String generateCode(String phone, String templateCode, String businessKey, long expiresIn) {
        String key = getKey(phone, businessKey);
        String verificationCode = getVerificationCode();
        redisTemplate.opsForValue().set(key, verificationCode, expiresIn, TimeUnit.SECONDS);
        try {
            //发送短信
            smsFeign.massSendSmsByCode(phone, templateCode, verificationCode);
        } catch (Exception e) {
            throw new RuntimeException("发送失败");
        }
        return verificationCode;
    }

    @Override
    public Boolean verifyCode(String phone, String businessKey, String verificationCode) {
        String key = getKey(phone, businessKey);
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value == null || StringUtils.isEmpty(verificationCode)) {
                return false;
            } else {
                return verificationCode.equals(value.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("验证码过期");
        }
    }

    /**
     * 生成 key
     *
     * @param phone
     * @param businessKey
     * @return
     */
    private String getKey(String phone, String businessKey) {
        String key = phone + businessKey;
        String hashKey = Md5Utils.hash(key);
        return VERIFICATION_CODE_PRE + hashKey;
    }

    /**
     * 生成验证码
     *
     * @return
     */
    private String getVerificationCode() {
        String verificationCode = StringUtils.randomNumber(5);
        return verificationCode;
    }
}
