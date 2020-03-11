package cn.gov.gzst.email.common.utils;

import cn.gov.gzst.common.utils.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *  邮件发送
 */
public class EmailSender extends HtmlEmail {

	public static EmailSender newEmailSender() {
		return new EmailSender();
	}

	private void initConfig(EmailConfig emailConfig) throws EmailException {
		// 初始化配置
		setHostName(emailConfig.getSmtpHost());
		setSmtpPort(emailConfig.getSmtpPort());
		if (emailConfig.getAuthAble()) {
			setAuthenticator(new DefaultAuthenticator(emailConfig.getAuthUsername(),
					emailConfig.getAuthPassword()));
		}
		Boolean ssl = emailConfig.getSmtpOpenSsl();
		if (ssl) {
			setSSLOnConnect(true);
		}
		// 设置主题的字符集为UTF-8
		setCharset("UTF-8");
		setFrom(emailConfig.getSenderUsername(), emailConfig.getSenderAlias());
	}

	public EmailResult send(EmailConfig emailConfig,String email, String subject, String content) {
		try {
			initConfig(emailConfig);
			addTo(email);
			if (!StringUtils.isEmpty(subject)) {
				setSubject(subject);
			}
			setHtmlMsg(content);
			send();
			return EmailResult.success("发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			return EmailResult.fail("发送失败");
		}
	}

}
