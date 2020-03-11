package cn.gov.gzst.email.common.disruptor;

import cn.gov.gzst.email.common.utils.EmailResult;
import cn.gov.gzst.email.common.utils.EmailConfig;
import cn.gov.gzst.email.common.utils.EmailSender;
import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EmailHelper {
	private int handlerCount = 1;
	private int bufferSize = 1024;
	private Disruptor<EmailEvent> disruptor;
	private EmailEventProducer emailEventProducer;
	private EmailDao emailDao = null;

	public EmailHelper() {

	}

	public EmailHelper(int handlerCount, int bufferSize) {
		this.handlerCount = handlerCount;
		this.bufferSize = bufferSize;
	}

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void start() {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		EmailEventFactory factory = new EmailEventFactory();

		// Specify the size of the ring buffer, must be power of 2.

		// Construct the Disruptor
		// 单线程模式，获取额外的性能
		disruptor = new Disruptor<EmailEvent>(factory, bufferSize, executor, ProducerType.SINGLE,
				new YieldingWaitStrategy());
		List<EmailHandler> emailHandlers = new ArrayList<>();
		for (int i = 0; i < handlerCount; i++) {
			emailHandlers.add(new EmailHandler(emailDao));
		}
		disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
		// 多个消费者，每个消费者竞争消费不同数据
		disruptor.handleEventsWithWorkerPool(emailHandlers.toArray(new EmailHandler[emailHandlers.size()]));
		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<EmailEvent> ringBuffer = disruptor.getRingBuffer();
		emailEventProducer = new EmailEventProducer(ringBuffer, emailDao);

		if (emailDao != null) {
			emailDao.doStart();
		}
	}

	/**
	 * 停止
	 */
	public void shutdown() {
		doHalt();
		if (emailDao != null) {
			emailDao.doShutdown();
		}
	}

	private void doHalt() {
		disruptor.halt();
	}

	public String sendAsyncEmail(String eventId,String code,Map<String,Object> datas,String email, String subject,String content, EmailConfig config) {
		return emailEventProducer.sendEmail(eventId,code,datas,email,subject, content,config);
	}

	public String sendAsyncEmail(String eventId,String code,Map<String,Object> datas, String email, String subject,String content,EmailConfig config,EmailHandlerCallBack callBack) {
		return emailEventProducer.sendEmail(eventId,code,datas,email,subject, content, config,callBack);
	}


	public EmailResult sendSyncEmail(String eventId, String code,Map<String,Object> datas, String email,String subject,String content, EmailConfig config) {
		// 异步的时候发送短信日志
		EmailData emailData = new EmailData();
		emailData.setEmail(email);
		emailData.setContent(content);
		emailData.setConfig(config);
		emailData.setCode(code);
		emailData.setDatas(datas);
		// 写入数据
		EmailEvent emailEvent = new EmailEvent();
		emailEvent.setId(eventId);
		emailEvent.setEmailData(emailData);
		if (emailDao != null) {
			emailDao.doSend(eventId, emailData);
		}
		EmailSender emailSender=new EmailSender();
		EmailResult emailResult = emailSender.send(config,email,subject,content);
		if (emailDao != null) {
			emailDao.doResult(eventId, emailData, emailResult);
		}
		return emailResult;
	}

	public int getHandlerCount() {
		return handlerCount;
	}

	public void setHandlerCount(int handlerCount) {
		this.handlerCount = handlerCount;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public EmailDao getEmailDao() {
		return emailDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

}