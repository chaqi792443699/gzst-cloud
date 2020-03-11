package cn.gov.gzst.pms.common.bean;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sms.common.bean
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/4/24 9:50
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class ResponseError extends cn.gov.gzst.common.bean.ResponseError {

    public static final int MSG_EMAIL_SEND_FAILE=500001; //邮箱发送失败
    public static final int MSG_EMAIL_EMAIL_ISNULL=500002; //EMAIL号码为空
    public static final int MSG_EMAIL_CODE_ISNULL=500003; //发送邮箱编码为空
    public static final int MSG_EMAIL_NET_FAILE=500004; //邮箱发送网络异常
    public static final int MSG_EMAIL_INVALID_PHONE=500005; //邮箱号码非法
}
