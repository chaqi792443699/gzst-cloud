package cn.gov.gzst.sms.common.disruptor;

import cn.gov.gzst.common.utils.sms.data.SmsTemplate;
import com.lmax.disruptor.RingBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By www.gzst.gov.cn
 * 
 * @title: LongEventProducer.java
 * @package cn.gov.gzst.sms.common.disruptor.sms
 * @description: 内容生产者
 * @author: jianliaoliang
 * @date: 2017年6月7日 下午11:19:15
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class SmsEventProducer {
	private static Logger logger = LoggerFactory.getLogger(SmsEventProducer.class);
	private final RingBuffer<SmsEvent> ringBuffer;
	private SmsDao smsDao;

	public SmsEventProducer(RingBuffer<SmsEvent> ringBuffer, SmsDao smsDao) {
		this.ringBuffer = ringBuffer;
		this.smsDao = smsDao;
	}

	private String sendSms(String eventId,SmsData smsData, SmsHandlerCallBack callBack) {
		// 获取下一个序号
		long sequence = ringBuffer.next();
		try {
			//发送
			if (smsDao != null) {
				smsDao.doSend(eventId, smsData);
			}
			// 写入数据
			SmsEvent smsEvent = ringBuffer.get(sequence);
			smsEvent.setId(eventId);
			smsEvent.setSmsData(smsData);
			smsEvent.setHandlerCallBack(callBack);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		} finally {
			// 通知消费者该资源可以消费了
			ringBuffer.publish(sequence);
		}
		return eventId;
	}

	private String sendSms(String eventId,SmsData smsData) {
		return sendSms(eventId,smsData, null);
	}

	public String sendSms(String eventId,String phone, SmsTemplate smsTemplate,Map<String,String> config, String... datas) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		smsData.setConfig(config);
		return sendSms(eventId,smsData);
	}

	public String sendSms(String eventId, String phone, SmsTemplate smsTemplate, Map<String,String> config, SmsHandlerCallBack callBack, String... datas) {
		SmsData smsData = new SmsData();
		smsData.setPhone(phone);
		smsData.setSmsTemplate(smsTemplate);
		smsData.setDatas(datas);
		smsData.setConfig(config);
		return sendSms(eventId,smsData, callBack);
	}
}