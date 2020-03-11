package cn.gov.gzst.admin.service;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * All rights Reserved, Designed By www.dataact.cn
 * @description: 验证码服务
 */
public interface IEmailVerifyCodeService {

    public void setRedisTemplate(RedisTemplate redisTemplate);
    /**
     * 生成验证码
     * @param email 邮箱地址
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String email, String businessKey);

    /**
     * 生成验证码
     * @param email 邮箱地址
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String email, String businessKey, long expiresIn);

    /**
     * 生成验证码
     * @param email 邮箱地址
     * @param businessKey 保证业务编码唯一
     * @return
     */
    public String generateCode(String email, String templateCode, String businessKey, long expiresIn);


    /**
     * 验证验证码
     * @param email 邮箱地址
     * @param businessKey 保证业务编码唯一
     * @param verificationCode 验证码
     * @return
     */
    public Boolean verifyCode(String email, String businessKey, String verificationCode);
}
