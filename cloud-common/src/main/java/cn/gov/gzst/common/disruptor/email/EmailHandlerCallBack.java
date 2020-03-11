package cn.gov.gzst.common.disruptor.email;

import cn.gov.gzst.common.utils.email.EmailResult;

public interface EmailHandlerCallBack {
    public void onResult(EmailResult emailResult);
}