package cn.gov.gzst.email.common.disruptor;

/**
 * 
 * All rights Reserved, Designed By www.gzst.gov.cn
 * 
 * @title: LongEvent.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 内容传递
 * @author: jianliaoliang
 * @date: 2017年6月7日 下午11:17:40
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class EmailEvent {
	private EmailData emailData;
	private String id;
	private EmailHandlerCallBack handlerCallBack;

	public EmailHandlerCallBack getHandlerCallBack() {
		return handlerCallBack;
	}

	public void setHandlerCallBack(EmailHandlerCallBack handlerCallBack) {
		this.handlerCallBack = handlerCallBack;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmailData getEmailData() {
		return emailData;
	}

	public void setEmailData(EmailData emailData) {
		this.emailData = emailData;
	}



}