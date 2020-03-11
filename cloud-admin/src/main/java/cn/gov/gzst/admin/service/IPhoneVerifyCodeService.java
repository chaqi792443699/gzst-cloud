package cn.gov.gzst.admin.service;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @title:
 * @description: 验证码服务
 */
public interface IPhoneVerifyCodeService {

    public void setRedisTemplate(RedisTemplate redisTemplate);
    /**
     * 生成验证码
     * @param phone 手机号码
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String phone, String businessKey);

    /**
     * 生成验证码
     * @param phone 手机号码
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String phone, String businessKey, long expiresIn);

    /**
     * 生成验证码
     * @param phone 手机号码
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String phone, String templateCode, String businessKey, long expiresIn);

    /**
     * 验证验证码
     * @param phone 手机号码
     * @param businessKey 保证业务编码唯一
     * @param verificationCode 验证码
     * @return
     */
    public Boolean verifyCode(String phone, String businessKey, String verificationCode);
}
