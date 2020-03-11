package cn.gov.gzst.sms.service;

import cn.gov.gzst.common.utils.sms.data.SmsResult;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 *
 */
public interface ISmsSendService {

	/**
	 * 
	 * @title: sendAsyncSmsByCode
	 * @description: 通过模版编码发送短信
	 * @param phone
	 * @param code
	 * @param datas
	 * @return
	 */
	public String sendAsyncSmsByCode(String phone, String code, String... datas);

	/**
	 *
	 * @title: sendAsyncSmsByCode
	 * @description: 通过模版编码发送短信
	 * @param phone
	 * @param code
	 * @param datas
	 * @return
	 */
	public String sendRetryAsyncSmsByCode(String eventId, String phone, String code, String... datas);

	/**
	 *
	 * @title: sendSyncSmsByCode
	 * @description: 通过模版编码发送短信
	 * @param phone
	 * @param code
	 * @param datas
	 * @return
	 */
	public SmsResult sendSyncSmsByCode(String phone, String code, String... datas);

	/**
	 *
	 * @title: sendAsyncSmsByCode
	 * @description: 通过模版编码发送短信
	 * @param phone
	 * @param code
	 * @param datas
	 * @return
	 */
	public SmsResult sendRetrySyncSmsByCode(String eventId, String phone, String code, String... datas);

}
