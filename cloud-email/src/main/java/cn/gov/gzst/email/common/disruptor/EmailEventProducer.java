package cn.gov.gzst.email.common.disruptor;

import cn.gov.gzst.email.common.utils.EmailConfig;
import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 *
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: LongEventProducer.java
 * @package cn.gov.gzst.email.common.disruptor.email
 * @description: 内容生产者
 * @author: jianliaoliang
 * @date: 2017年6月7日 下午11:19:15
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class EmailEventProducer {
	private static Logger logger = LoggerFactory.getLogger(EmailEventProducer.class);
	private final RingBuffer<EmailEvent> ringBuffer;
	private EmailDao emailDao;

	public EmailEventProducer(RingBuffer<EmailEvent> ringBuffer, EmailDao emailDao) {
		this.ringBuffer = ringBuffer;
		this.emailDao = emailDao;
	}

	private String sendEmail(String eventId,EmailData emailData, EmailHandlerCallBack callBack) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		try {
			//发送
			if (emailDao != null) {
				emailDao.doSend(eventId, emailData);
			}
			// 写入数据
			EmailEvent emailEvent = ringBuffer.get(sequence);
			emailEvent.setId(eventId);
			emailEvent.setEmailData(emailData);
			emailEvent.setHandlerCallBack(callBack);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
		return eventId;
	}

	public String sendEmail(String eventId,String code,Map<String,Object> datas, String email, String subject, String content,EmailConfig config) {
		return sendEmail(eventId,code,datas,email,subject,content,config,null);
	}

	public String sendEmail(String eventId,String code,Map<String,Object> datas, String email, String subject, String content, EmailConfig config, EmailHandlerCallBack callBack) {
		EmailData emailData = new EmailData();
		emailData.setEmail(email);
		emailData.setCode(code);
		emailData.setSubject(subject);
		emailData.setContent(content);
		emailData.setDatas(datas);
		emailData.setConfig(config);
		return sendEmail(eventId,emailData, callBack);
	}
}