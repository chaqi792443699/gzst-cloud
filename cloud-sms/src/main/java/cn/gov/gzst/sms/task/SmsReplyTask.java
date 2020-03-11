package cn.gov.gzst.sms.task;


import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.DateUtils;
import cn.gov.gzst.sms.service.ISmsConfigService;
import cn.gov.gzst.sms.service.ISmsReplyLogService;
import cn.gov.gzst.sms.service.ISmsSendLogService;
import cn.gov.gzst.sms.common.sms.data.GetReplyResult;
import cn.gov.gzst.sms.common.sms.receiver.HuyiSmsReceiver;
import cn.gov.gzst.sms.common.sms.receiver.SmsReceiver;
import cn.gov.gzst.sms.entity.SmsConfig;
import cn.gov.gzst.sms.entity.SmsReplyLog;
import cn.gov.gzst.sms.entity.SmsSendLog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信回复任务
 */
@Component("smsReplyTask")
public class SmsReplyTask {

	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
    ISmsReplyLogService smsReplyLogService;
	@Autowired
	ISmsSendLogService smsSendLogService;
	@Autowired
	ISmsConfigService configService;
	//private JmsTemplate jmsTemplate= SpringContextHolder.getBean("jmsTopicTemplate");//通过@Qualifier修饰符来注入对应的bean
	private Boolean isRun=Boolean.FALSE;
	private SmsReceiver smsReceiver;
	/**
	 * 重新回复请求
	 */
	@PostConstruct
	public  void initReplyTask(){
		smsReceiver = new HuyiSmsReceiver();
		smsReceiver.init();
		//找到是否回复的记录
		List<SmsReplyLog> smsReplyLogList=smsReplyLogService
				.selectList(new EntityWrapper<SmsReplyLog>(SmsReplyLog.class)
						.eq("dealFlag",SmsReplyLog.SMS_REPLY_DEAL_IN)
				);
		//恢复处理
		for (SmsReplyLog smsReplyLog:smsReplyLogList) {
			try {
				send("sms_reply_destination", smsReplyLog);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 检查回复并写入到日志中
	 */
	@Scheduled(fixedRate = 10000)
	public void run() {
		log.info(" 短信回复日志运行开始......................................" + (new Date()));
		if (!isRun) {
			isRun=Boolean.TRUE;
			try {
				List<SmsConfig> smsConfigList=configService.selectList(new EntityWrapper<SmsConfig>());
				Map<String,String> config=new HashMap<String,String>();
				GetReplyResult getReplyResult = null;
				for (SmsConfig smsConfig: smsConfigList) {
					config.put("api_id",smsConfig.getAppId());
					config.put("api_key",smsConfig.getAppKey());
					getReplyResult = smsReceiver.reply(config);
					for (GetReplyResult.MsgInfo msgInfo : getReplyResult) {
						String smsId = msgInfo.getSmsid();
						SmsSendLog smsSendLog = smsSendLogService.selectOne(new EntityWrapper<SmsSendLog>(SmsSendLog.class).eq("smsid", smsId));
						if (smsSendLog != null) {
							SmsReplyLog smsReplyLog = new SmsReplyLog();
							smsReplyLog.setSmsid(smsSendLog.getSendSmsid());
							smsReplyLog.setSendSmsid(smsSendLog.getSendSmsid());
							smsReplyLog.setAppId(smsSendLog.getAppId());
							smsReplyLog.setContent(msgInfo.getContent());
							smsReplyLog.setPhone(msgInfo.getPhone());
							smsReplyLog.setReplyDate(DateUtils.parseDate(msgInfo.getDate()));
							smsReplyLog.setDealFlag(SmsReplyLog.SMS_REPLY_DEAL_IN);
							smsReplyLog.setTryNum(0);
							smsReplyLog.setDelFlag("1");
							smsReplyLogService.save(smsReplyLog);
							//通知其他App服务更新
							send("sms_reply_destination", smsReplyLog);
						}
					}
				}
				//检查重试
				chenkRetry();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				isRun=Boolean.FALSE;
			}
		}
	}

	/**
	 * 定时任务定时检查任务
	 */
	public void chenkRetry() {
		//找到是否回复的记录
		List<SmsReplyLog> smsReplyLogList=smsReplyLogService
				.selectList(new EntityWrapper<SmsReplyLog>(SmsReplyLog.class)
						.eq("dealFlag",SmsReplyLog.SMS_REPLY_DEAL_FAIL).lt("tryNum",3)
				);
		//恢复处理
		for (SmsReplyLog smsReplyLog:smsReplyLogList) {
			try {
				//通知其他App服务更新
				//表示响应成功！
				if (smsReplyLog.getTryNum() == null) {
					smsReplyLog.setTryNum(0);
				}
				smsReplyLog.setTryNum(smsReplyLog.getTryNum() + 1);
				smsReplyLog.setDealFlag(SmsReplyLog.SMS_REPLY_DEAL_IN);
				smsReplyLogService.saveOrUpdate(smsReplyLog);
				send("sms_reply_destination", smsReplyLog);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 发送短信更新消息
	 * @param queueName 队列名称
	 * @param smsReplyLog 消息内容
	 */
	public void send(String queueName,final SmsReplyLog smsReplyLog){
		/*jmsTemplate.send(queueName, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(smsReplyLog);
			}
		});*/
	}
}
