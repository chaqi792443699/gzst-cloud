package cn.gov.gzst.email.common.disruptor;

import cn.gov.gzst.email.common.utils.EmailConfig;
import java.io.Serializable;
import java.util.Map;

public class EmailData implements Serializable {
	private String email;
	private String subject = "";
	private String content;
	private String code;
	private Map<String,Object> datas;
	private EmailConfig config;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

	public EmailConfig getConfig() {
		return config;
	}

	public void setConfig(EmailConfig config) {
		this.config = config;
	}
}
