package cn.gov.gzst.email.common.disruptor;

import cn.gov.gzst.email.common.utils.EmailResult;

public interface EmailHandlerCallBack {
    public void onResult(EmailResult emailResult);
}