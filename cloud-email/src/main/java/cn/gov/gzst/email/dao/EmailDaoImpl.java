package cn.gov.gzst.email.dao;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.common.disruptor.EmailDao;
import cn.gov.gzst.email.common.disruptor.EmailData;
import cn.gov.gzst.email.common.utils.EmailResult;
import cn.gov.gzst.email.entity.SendLog;
import cn.gov.gzst.email.entity.Template;
import cn.gov.gzst.email.service.ISendLogService;
import cn.gov.gzst.email.service.ITemplateService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 *
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: EmailDaoIml.java
 * @package cn.gov.gzst.admin.sms.dao
 * @description: 短信信息返回
 * @author: jianliaoliang
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class EmailDaoImpl implements EmailDao {

    @Autowired
    private ISendLogService sendLogService;

    @Autowired
    private ITemplateService templateService;

    private static Logger logger = LoggerFactory.getLogger(EmailDaoImpl.class);

    @Override
    public void doStart() {

    }

    @Override
    public void doSend(String eventId, EmailData emailData) {
        try {
            SendLog sendLog = sendLogService.selectById(eventId);
            if (sendLog==null) {
                sendLog=new SendLog();
            }
            Template template = templateService
                    .selectOne(new EntityWrapper<Template>().eq("code", emailData.getCode()));
            if (template != null) {
                if (StringUtils.isEmpty(sendLog.getId())) {
                    sendLog.setId(eventId);
                    // 这里需要处理templateId
                    sendLog.setAppId(template.getAppId());
                    sendLog.setSendCode(emailData.getCode());
                    sendLog.setSendData(JSON.toJSONString(emailData.getDatas()));
                    sendLog.setSubject(emailData.getSubject());
                    sendLog.setContent(emailData.getContent());
                    sendLog.setEmail(emailData.getEmail());
                    sendLog.setStatus(SendLog.EMAIL_SEND_STATUS_IN);
                    sendLog.setTryNum(0);
                    sendLogService.insert(sendLog);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }

    @Override
    public void doResult(String eventId, EmailData emailData, EmailResult smsResult) {
        try {
            SendLog sendLog = sendLogService.selectById(eventId);
            //sendLog.setCode(smsResult.getCode());
            sendLog.setMsg(smsResult.getMsg());
            if (smsResult.isSuccess()) {
                sendLog.setStatus(SendLog.EMAIL_SEND_STATUS_SUCCESS);
            } else {
                sendLog.setStatus(SendLog.EMAIL_SEND_STATUS_FAIL);
            }
            sendLog.setResponseDate(new Date());
            sendLogService.saveOrUpdate(sendLog);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    @Override
    public void doShutdown() {

    }

}