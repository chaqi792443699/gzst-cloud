package cn.gov.gzst.common.utils.sms.sender;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.gov.gzst.common.utils.sms.sender.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.gov.gzst.common.utils.PropertiesUtil;
import cn.gov.gzst.common.utils.sms.data.SmsResult;
import cn.gov.gzst.common.utils.sms.data.SmsTemplate;
import cn.gov.gzst.common.utils.sms.sender.huyi.HuyiRestSDK;

/**
 * 互亿无线
 * 
 * @author jianliaoliang
 *
 */
public class HuyiSmsSender extends SmsSender {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private HuyiRestSDK huyiRestSDK;
	private Map<String,HuyiRestSDK> huyiRestSDKMap=new HashMap<String, HuyiRestSDK>();
	private String isOpen;

	public HuyiSmsSender() {
		try {
			init();
		} catch (Exception e) {

		}
	}

	@Override
	public void init() {
		PropertiesUtil p = new PropertiesUtil(getConfigname());
		String serverUrl = p.getString("sms.server.url");
		String accountName = p.getString("sms.account.apiid");
		String accountPassword = p.getString("sms.account.apikey");
		isOpen=p.getString("sms.isopen");
		huyiRestSDK = new HuyiRestSDK();
		huyiRestSDK.init(serverUrl);
		huyiRestSDK.setAccount(accountName, accountPassword);
	}

	@Override
	public SmsResult send(String phone, SmsTemplate smsTemplate, String... datas) {
			return send(phone,smsTemplate,null,datas);
	}

	public SmsResult send(String phone, SmsTemplate smsTemplate, Map<String, String> config, String... datas) {
		SmsResult smsResult = new SmsResult();
		String[] phones = phone.split(",");
		for (String singlePhone : phones) {
			smsResult = sendSingle(singlePhone, smsTemplate,config, datas);
		}
		return smsResult;
	}

	private SmsResult sendSingle(String phone, SmsTemplate smsTemplate, Map<String, String> config,String... datas) {
		Map<String, Object> result = null;
		if (!org.apache.commons.lang.StringUtils.isEmpty(isOpen) && isOpen.equals("1")) {
			try {
				// 这里需要处理templateId
				String templateContent = StringEscapeUtils.unescapeHtml4(smsTemplate.getTemplateContent());
				String content = StringUtils.getSmsContent(templateContent,datas);
				if (config==null){
					result = huyiRestSDK.sendMsg(phone, content);
				}else{
					result = getRestSDKByConfig(config).sendMsg(phone, content);
				}
				logger.info("HuyiRestSDK result=" + result);
				if ("2".equals(result.get("code"))) {
					// 正常返回输出data包体信息（map）
					Set<String> keySet = result.keySet();
					for (String key : keySet) {
						Object object = result.get(key);
						logger.info(key + " = " + object);
					}
				} else {
					// 异常返回输出错误码和错误信息
					logger.error("错误码=" + result.get("code") + " 错误信息= " + result.get("msg"));
				}
			}catch (IllegalArgumentException e){
				result = new HashMap<String, Object>();
				result.put("code", "99");
				result.put("msg", "发送短信提交的参数不对");
				result.put("smsid", "");
			}catch (Exception e){
				result = new HashMap<String, Object>();
				result.put("code", "99");
				result.put("msg", "位置异常");
				result.put("smsid", "");
			}
		}else {
			result = new HashMap<String, Object>();
			result.put("code", "2");
			result.put("msg", "测试发送 ");
			result.put("smsid", "test");
		}
		return mapToResult(result);
	}

	private HuyiRestSDK getRestSDKByConfig(Map<String, String> config){
		PropertiesUtil p = new PropertiesUtil(getConfigname());
		String serverUrl = p.getString("sms.server.url");
		String accountName =config.get("api_id");
		String accountPassword =config.get("api_key");
		isOpen=p.getString("sms.isopen");
		HuyiRestSDK huyiRestSDK = null;
		if (huyiRestSDKMap.containsKey(accountName)){
			huyiRestSDK=huyiRestSDKMap.get(accountName);
		}else{
			huyiRestSDK=new HuyiRestSDK();
			huyiRestSDK.init(serverUrl);
			huyiRestSDK.setAccount(accountName, accountPassword);
			huyiRestSDKMap.put(accountName,huyiRestSDK);
		}
		return huyiRestSDK;
	}

	private SmsResult mapToResult(Map<String, Object> result) {
		SmsResult requestResult = new SmsResult();
		requestResult.setSuccess(Boolean.FALSE);
		requestResult.setSenderName(name());
		if (result != null) {
			requestResult.setCode(result.get("code") + "");
			requestResult.setMsg(result.get("msg") + "");
			requestResult.setSmsid(result.get("smsid") + "");
			if ("2".equals(result.get("code"))) {
				requestResult.setSuccess(Boolean.TRUE);
			}
		}
		return requestResult;
	}

	@Override
	protected String name() {
		return "HUYI";
	}

}
