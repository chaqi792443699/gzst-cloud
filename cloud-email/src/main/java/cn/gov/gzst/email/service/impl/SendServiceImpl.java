package cn.gov.gzst.email.service.impl;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.common.disruptor.EmailHelper;
import cn.gov.gzst.email.common.utils.EmailResult;
import cn.gov.gzst.email.entity.Config;
import cn.gov.gzst.email.entity.Template;
import cn.gov.gzst.email.service.IConfigService;
import cn.gov.gzst.email.service.ISendService;
import cn.gov.gzst.email.service.ITemplateService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 邮件发送服务
 * @Description: 邮件发送服务
 *
 */
@Transactional
@Service("emailSendService")
public class SendServiceImpl implements ISendService {
	@Autowired
	private ITemplateService templateService;
	@Autowired
	private IConfigService smsConfigService;

	@Autowired
	private EmailHelper emailHelper;

	@Override
	public String sendAsyncEmailByCode(String email, String code) {
		return sendAsyncEmailByCode(email,code,new HashMap<String,Object>());
	}

	@Override
	public String sendAsyncEmailByCode(String email, String code, Map<String,Object> datas) {
		return sendRetryAsyncEmailByCode(StringUtils.randomUUID(),email,code,datas);
	}

	@Override
	public String sendRetryAsyncEmailByCode(String eventId, String email, String code) {
		return sendRetryAsyncEmailByCode(eventId,email,code,new HashMap<String,Object>());
	}

	@Override
	public String sendRetryAsyncEmailByCode(String eventId, String email, String code, Map<String,Object> datas) {
		Template template = templateService.selectOne(new EntityWrapper<Template>().eq("code", code));
		String templateContent = parseContent(StringEscapeUtils.unescapeHtml(template.getTemplateContent()),datas);
		String templateSubject = parseContent(StringEscapeUtils.unescapeHtml(template.getTemplateSubject()),datas);
		//设置配置
		Config config = smsConfigService.selectById(template.getConfigId());
		return emailHelper.sendAsyncEmail(eventId,code,datas,email,templateSubject,templateContent,config.toEmailConfig());
	}

	@Override
	public EmailResult sendSyncEmailByCode(String email, String code) {
		return sendSyncEmailByCode(email,code,new HashMap<String,Object>());
	}

	@Override
	public EmailResult sendSyncEmailByCode(String email, String code, Map<String,Object> datas) {
		return sendRetrySyncEmailByCode(StringUtils.randomUUID(),email,code,datas);
	}

	@Override
	public EmailResult sendRetrySyncEmailByCode(String eventId, String email, String code) {
		return sendRetrySyncEmailByCode(eventId,email,code,new HashMap<String,Object>());
	}

	@Override
	public EmailResult sendRetrySyncEmailByCode(String eventId, String email, String code, Map<String,Object> datas) {
		Template template = templateService.selectOne(new EntityWrapper<Template>().eq("code", code));
		String templateContent = parseContent(StringEscapeUtils.unescapeHtml(template.getTemplateContent()),datas);
		String templateSubject = parseContent(StringEscapeUtils.unescapeHtml(template.getTemplateSubject()),datas);
		//设置配置
		Config config = smsConfigService.selectById(template.getConfigId());
		return emailHelper.sendSyncEmail(eventId,code,datas,email,templateSubject,templateContent,config.toEmailConfig());
	}


	private String parseContent(String content,Map<String, Object> dataMap) {
		try {
			String tempname = StringUtils.hashKeyForDisk(content);
			Configuration configuration = new Configuration();
			configuration.setNumberFormat("#");
			StringTemplateLoader stringLoader = new StringTemplateLoader();
			stringLoader.putTemplate(tempname, content);
			freemarker.template.Template template = new freemarker.template.Template(tempname, new StringReader(content));
			StringWriter stringWriter = new StringWriter();
			template.process(dataMap, stringWriter);
			configuration.setTemplateLoader(stringLoader);
			content = stringWriter.toString();
		}catch (Exception e) {
		   e.printStackTrace();
		   throw new RuntimeException("模板解析失败");
		}
		return content;
	}
}
