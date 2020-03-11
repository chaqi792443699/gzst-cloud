package cn.gov.gzst.sms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.sms.service.ISmsReplyLogService;
import cn.gov.gzst.sms.entity.SmsReplyLog;
import cn.gov.gzst.sms.mapper.SmsReplyLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: 短信回复日志
 * @Description: 短信回复日志
 * @author jianliaoliang
 * @date 2017-10-10 16:23:09
 * @version V1.0   
 *
 */
@Transactional
@Service("smsReplyLogService")
public class SmsReplyLogServiceImpl  extends CommonServiceImpl<SmsReplyLogMapper,SmsReplyLog> implements  ISmsReplyLogService {

    @Override
    public boolean retryReply(List<? extends Serializable> idList) {
        List<SmsReplyLog>  smsReplyLogList=new ArrayList<SmsReplyLog>();
        for (Serializable id: idList) {
            SmsReplyLog smsReplyLog=selectById(id);
            smsReplyLog.setTryNum(0);
            smsReplyLog.setDealFlag(SmsReplyLog.SMS_REPLY_DEAL_FAIL);
            smsReplyLogList.add(smsReplyLog);
        }
        insertOrUpdateBatch(smsReplyLogList);
        return false;
    }
}
