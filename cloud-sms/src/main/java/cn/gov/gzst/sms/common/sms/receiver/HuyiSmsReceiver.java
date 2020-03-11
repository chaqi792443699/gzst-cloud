package cn.gov.gzst.sms.common.sms.receiver;

import cn.gov.gzst.common.utils.PropertiesUtil;
import cn.gov.gzst.common.utils.sms.sender.huyi.HuyiRestSDK;
import cn.gov.gzst.sms.common.sms.data.GetReplyResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 互亿无线
 * 
 * @author jianliaoliang
 *
 */
public class HuyiSmsReceiver extends SmsReceiver {
	public static final String DEFAULT_CONFIG_FILE = "sms.properties";
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private HuyiRestSDK huyiRestSDK;
	private Map<String,HuyiRestSDK> huyiRestSDKMap=new HashMap<String, HuyiRestSDK>();
	private static HuyiSmsReceiver huyiSmsReceiver = new HuyiSmsReceiver();
	private String isOpen = "1";

	public static HuyiSmsReceiver getReceiver() {
		if (huyiSmsReceiver == null) {
			huyiSmsReceiver = new HuyiSmsReceiver();
		}
		return huyiSmsReceiver;
	}

	public HuyiSmsReceiver() {
		try {
			init();
		} catch (Exception e) {

		}
	}

	@Override
	public void init() {
		PropertiesUtil p = new PropertiesUtil(DEFAULT_CONFIG_FILE);
		String serverUrl = p.getString("sms.server.url");
		String accountName = p.getString("sms.account.apiid");
		String accountPassword = p.getString("sms.account.apikey");
		isOpen=p.getString("sms.isopen");
		huyiRestSDK = new HuyiRestSDK();
		huyiRestSDK.init(serverUrl);
		huyiRestSDK.setAccount(accountName, accountPassword);
	}


	private GetReplyResult mapToResult(Map<String, Object> result) {
		GetReplyResult getReplyResult = new GetReplyResult();
		getReplyResult.setSuccess(Boolean.FALSE);
		getReplyResult.setSmsReceiverName(getName());
		if (result != null) {
			if (result.get("msg")!=null) {
				getReplyResult.setCode(result.get("code") + "");
				getReplyResult.setMsg(result.get("msg") + "");
			}
			if ("2".equals(result.get("code"))) {
				getReplyResult.setSuccess(Boolean.TRUE);
			}
		}
		return getReplyResult;
	}

	public String getName() {
		return "HUYI";
	}

	@Override
	public GetReplyResult reply() {
		return reply(null);
	}

	@Override
	public GetReplyResult reply(Map<String, String> config) {
		Map<String, Object> result = null;
		if (!StringUtils.isEmpty(isOpen) && isOpen.equals("1")) {
			if (config==null){
				result = huyiRestSDK.getReply();
			}else{
				result = getRestSDKByConfig(config).getReply();
			}
			logger.info("SDKTestSendTemplateSMS result=" + result);
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
				// throw new SendException("错误码=" + result.get("code") + " 错误信息=
				// " +
				// result.get("msg"));
			}
		} else {
			result = new HashMap<String, Object>();
			result.put("code", "2");
			//result.put("msg", "测试发送 ");
			//result.put("smsid", "test");
		}
		return mapToResult(result);
	}

	private HuyiRestSDK getRestSDKByConfig(Map<String, String> config){
		PropertiesUtil p = new PropertiesUtil(DEFAULT_CONFIG_FILE);
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

	public static void main(String[] args) {
		SmsReceiver smsReceiver = new HuyiSmsReceiver();
		smsReceiver.init();
		GetReplyResult getReplyResult = smsReceiver.reply();
		for (GetReplyResult.MsgInfo msgInfo : getReplyResult) {
			System.out.println("电话:" + msgInfo.getPhone());
			System.out.println("内容:" + msgInfo.getContent());
			System.out.println("时间:" + msgInfo.getDate());
			System.out.println("发送的模版ID:" + msgInfo.getSmsid());
		}
	}
}
