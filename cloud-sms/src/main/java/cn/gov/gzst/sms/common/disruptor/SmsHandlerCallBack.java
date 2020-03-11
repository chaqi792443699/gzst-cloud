package cn.gov.gzst.sms.common.disruptor;

import cn.gov.gzst.common.utils.sms.data.SmsResult;

import java.io.Serializable;

public interface SmsHandlerCallBack extends Serializable {
    public void onResult(SmsResult smsResult);
}
