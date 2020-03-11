package cn.gov.gzst.sms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.sms.service.ISmsSendLogService;
import cn.gov.gzst.sms.entity.SmsSendLog;
import cn.gov.gzst.sms.mapper.SmsSendLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0   
 *
 */
@Transactional
@Service("smsSendLogService")
public class SmsSendLogServiceImpl  extends CommonServiceImpl<SmsSendLogMapper,SmsSendLog> implements  ISmsSendLogService {

    @Override
    public boolean retrySend(List<? extends Serializable> idList) {
        List<SmsSendLog>  smsSendLogList=new ArrayList<SmsSendLog>();
        for (Serializable id: idList) {
            SmsSendLog smsSendLog=selectById(id);
            smsSendLog.setTryNum(0);
            smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_FAIL);
            smsSendLogList.add(smsSendLog);
        }
        insertOrUpdateBatch(smsSendLogList);
        return false;
    }
}
