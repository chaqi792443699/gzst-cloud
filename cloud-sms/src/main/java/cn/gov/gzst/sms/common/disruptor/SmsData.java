package cn.gov.gzst.sms.common.disruptor;

import cn.gov.gzst.common.utils.sms.data.SmsTemplate;

import java.io.Serializable;
import java.util.Map;

@SuppressWarnings("serial")
public class SmsData implements Serializable {
	private String phone;
	private SmsTemplate smsTemplate;
	private Map<String,String> config;
	private String[] datas;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public SmsTemplate getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(SmsTemplate smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public String[] getDatas() {
		return datas;
	}

	public void setDatas(String[] datas) {
		this.datas = datas;
	}

	public Map<String, String> getConfig() {
		return config;
	}

	public void setConfig(Map<String, String> config) {
		this.config = config;
	}
}
