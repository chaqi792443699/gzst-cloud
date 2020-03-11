package cn.gov.gzst.email.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.email.service.ISendLogService;
import cn.gov.gzst.email.entity.SendLog;
import cn.gov.gzst.email.mapper.SendLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.email.service.impl
* @title: 发送日志服务实现
* @description: 发送日志服务实现
* @author: jianliaoliang
* @date: 2018-04-24 11:24:16
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("sendlogService")
public class SendLogServiceImpl  extends CommonServiceImpl<SendLogMapper,SendLog> implements  ISendLogService {

    @Override
    public boolean retrySend(List<? extends Serializable> idList) {
        List<SendLog>  smsSendLogList=new ArrayList<SendLog>();
        for (Serializable id: idList) {
            SendLog sendLog=selectById(id);
            sendLog.setTryNum(0);
            sendLog.setStatus(SendLog.EMAIL_SEND_STATUS_FAIL);
            smsSendLogList.add(sendLog);
        }
        insertOrUpdateBatch(smsSendLogList);
        return false;
    }

}