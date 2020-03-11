package cn.gzst.gov.cloud.gateway.response;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.api.oauth.common.error
 * @title:
 * @description: 错误代码表
 * @author: jianliaoliang
 * @date: 2018/1/8 15:17
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class ResponseError extends cn.gov.gzst.sso.common.bean.ResponseError{
    public static final int TOKEN_IS_NULL = 200001; //TOKEN为空
    public static final int AUTHENTICATION_FAIL = 200002;//认证失败
    public static final int INVALID_ACCESS_TOKEN = 200003;//TOKEN非法
    public static final int EXPIRED_ACCESS_TOKEN = 200004;//TOKEN过期
}
