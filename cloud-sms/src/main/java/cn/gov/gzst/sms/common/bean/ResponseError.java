package cn.gov.gzst.sms.common.bean;

/**
 * 返回错误
 */
public class ResponseError extends cn.gov.gzst.common.bean.ResponseError {

    public static final int MSG_SMS_SEND_FAILE=400001; //短信发送失败
    public static final int MSG_SMS_PHONE_ISNULL=400002; //手机号码为空
    public static final int MSG_SMS_CODE_ISNULL=400003; //发送短信编码为空
    public static final int MSG_SMS_NET_FAILE=400004; //短信发送网络异常
    public static final int MSG_SMS_INVALID_PHONE=400005; //手机号码非法
    public static final int MSG_SMS_INVALID_CODE=400006; //短信编码非法
    public static final int MSG_SMS_NOT_REPEAT=400007; //5分钟内禁止重发发送
    public static final int MSG_SMS_SAME_REPEAT=400008; //5分钟内禁止重发发送
}
