package cn.gov.gzst.sms.common.sms.receiver;

import cn.gov.gzst.sms.common.sms.data.GetReplyResult;

import java.util.Map;

/**
 * 短信发射器
 * 
 * @author jianliaoliang
 *
 */
public abstract class SmsReceiver  {
	/**
	 * 初始化配置
	 */
	public abstract void init();

	public abstract GetReplyResult reply();

	public abstract GetReplyResult reply(Map<String,String> config);

}
