package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.common.constant.Constants;
import cn.gov.gzst.admin.service.IEmailVerifyCodeService;
import cn.gov.gzst.common.utils.Md5Utils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.feign.EmailFeign;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.service.impl
 * @title:
 * @description: 验证码服务
 * @author: jianliaoliang
 * @date: 2018/4/21 13:33
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@Service("emailVerifyCodeService")
public class EmailVerifyCodeServiceImpl implements IEmailVerifyCodeService {

    @Autowired
    private RedisTemplate redisTemplate;
    private final static  String VERIFICATION_CODE_PRE="VERIFICATION_EMAIL_CODE_PRE_";
    private final static Integer DEFAULT_EXPIRESIN = 10*60; //默认十分钟
    @Autowired
    private EmailFeign emailFeign;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String generateCode(String email, String businessKey) {
        return generateCode(email,businessKey,DEFAULT_EXPIRESIN);
    }

    @Override
    public String generateCode(String email, String businessKey, long expiresIn) {
        return generateCode(email, Constants.DEFAULT_EMAIL_VERIFY_TEMPLATE_CODE,businessKey,expiresIn);
    }

    @Override
    public String generateCode(String email, String templateCode, String businessKey, long expiresIn) {
        String key=getKey(email,businessKey);
        String verificationCode=getKey(email,businessKey);
        redisTemplate.opsForValue().set(key, verificationCode, expiresIn, TimeUnit.SECONDS);
        try {
            //发送邮件
            Map<String,Object> datas = Maps.newHashMap();
            datas.put("code",verificationCode);
            emailFeign.send(email,templateCode,datas);
        }catch (Exception e){}
        return verificationCode;
    }

    @Override
    public Boolean verifyCode(String email, String businessKey, String verificationCode) {
        String key=getKey(email,businessKey);
        try {
            return redisTemplate.opsForValue().get(key) != null;
        }catch (Exception e){
            throw new RuntimeException("验证码过期");
        }
    }

    /**
     * 生成 key
     * @param email
     * @param businessKey
     * @return
     */
    private String getKey(String email, String businessKey){
        String key=email+businessKey;
        String hashKey = Md5Utils.hash(key);
        return VERIFICATION_CODE_PRE+hashKey;
    }

    /**
     * 生成验证码
     * @return
     */
    private String getVerificationCode(){
        String verificationCode= StringUtils.randomNumber(5);
        return verificationCode;
    }
}
