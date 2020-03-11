package cn.gov.gzst.sms.dao;

import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.sms.data.SmsResult;
import cn.gov.gzst.sms.service.ISmsSendLogService;
import cn.gov.gzst.sms.service.ISmsModelService;
import cn.gov.gzst.sms.common.disruptor.SmsDao;
import cn.gov.gzst.sms.common.disruptor.SmsData;
import cn.gov.gzst.sms.entity.SmsSendLog;
import cn.gov.gzst.sms.entity.SmsModel;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 *
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: SmsDaoIml.java
 * @package cn.gov.gzst.admin.sms.dao
 * @description: 短信信息返回
 * @author: jianliaoliang
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class SmsDaoImpl implements SmsDao {
	@Autowired
	private ISmsSendLogService smsSendLogService;
	@Autowired
	private ISmsModelService smsModelService;
	private static Logger logger = LoggerFactory.getLogger(SmsDaoImpl.class);

	@Override
	public void doStart() {

	}

	@Override
	public void doSend(String eventId, SmsData smsData) {
		try {
			SmsSendLog smsSendLog = smsSendLogService.selectById(eventId);
			if (smsSendLog==null) {
				smsSendLog=new SmsSendLog();
			}
			String modelId = smsData.getSmsTemplate().getTemplateId();
			SmsModel smsModelEntity = smsModelService
					.selectOne(new EntityWrapper<SmsModel>().eq("code", modelId));
			if (smsModelEntity != null) {
				if (StringUtils.isEmpty(smsSendLog.getId())) {
					smsSendLog.setId(eventId);
					smsSendLog.setSendSmsid(eventId);
					smsSendLog.setAppId(smsModelEntity.getAppId());
					// 这里需要处理modelId
					String templateContent = StringEscapeUtils.unescapeHtml4(smsModelEntity.getTemplateContent());
					String content = cn.gov.gzst.common.utils.sms.sender.StringUtils.getSmsContent(templateContent,smsData.getDatas());
					smsSendLog.setContent(content);
					smsSendLog.setTemplateId(smsModelEntity.getId());
					smsSendLog.setPhone(smsData.getPhone());
					smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_IN);
					smsSendLog.setTryNum(0);
					smsSendLog.setSendCode(smsModelEntity.getCode());
					smsSendLog.setSendData(StringUtils.join(smsData.getDatas(),","));
					smsSendLogService.insert(smsSendLog);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	@Override
	public void doResult(String eventId, SmsData smsData, SmsResult smsResult) {
		try {
			SmsSendLog smsSendLog = smsSendLogService.selectById(eventId);
			smsSendLog.setCode(smsResult.getCode());
			smsSendLog.setMsg(smsResult.getMsg());
			smsSendLog.setSmsid(smsResult.getSmsid());
			if (smsResult.isSuccess()) {
				smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_SUCCESS);
			} else {
				smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_FAIL);
			}
			smsSendLog.setResponseDate(new Date());
			smsSendLogService.saveOrUpdate(smsSendLog);
		}catch (Exception e){
			logger.error(e.getMessage(),e);
		}
	}

	@Override
	public void doShutdown() {

	}

}