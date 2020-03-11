package cn.gov.gzst.oss.common.bean;

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
public class ResponseError extends cn.gov.gzst.common.bean.ResponseError {

    public static final int VERIFICATIONCODE_GET_ERROR= 300001; //验证获取失败

    public static final int VERIFICATIONCODE_VERIFY_ERROR= 300002; //验证验证失败

    public static final int GET_USERINFO_ERROR=300003;//获取用户信息失败

    public static final int USER_REGISTER_ERROR=300004;//用户注册失败

    public static final int IDCARD_FRONT_RECOGNIZE_FAIL=300005;//身份证正面识别失败

    public static final int IDCARD_BACK_RECOGNIZE_FAIL=300006;//身份证反面识别失败

    public static final int IDCARD_SUBMIT_FAIL=300007;//身份证认证提交失败

    public static final int IDCARD_AUDIT_FAIL=300008;//身份证认证审核失败

    public static final int BUSINESS_LICENSE_RECOGNIZE_FAIL=300009;//身份证反面识别失败

    public static final int ENTERPRISE_SUBMIT_FAIL=300010;//企业认证提交失败

    public static final int ENTERPRISE_AUDIT_FAIL=300011;//企业认证审核失败
}
