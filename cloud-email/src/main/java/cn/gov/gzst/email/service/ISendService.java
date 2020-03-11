package cn.gov.gzst.email.service;


import cn.gov.gzst.email.common.utils.EmailResult;
import java.util.Map;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jianliaoliang
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
public interface ISendService {

	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @return
	 */
	public String sendAsyncEmailByCode(String email, String code);

	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public String sendAsyncEmailByCode(String email, String code, Map<String,Object> datas);
	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @return
	 */
	public String sendRetryAsyncEmailByCode(String eventId, String email, String code);

	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public String sendRetryAsyncEmailByCode(String eventId, String email, String code, Map<String,Object>  datas);

	/**
	 *
	 * @title: sendSyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @return
	 */
	public EmailResult sendSyncEmailByCode(String email, String code);

	/**
	 *
	 * @title: sendSyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public EmailResult sendSyncEmailByCode(String email, String code, Map<String,Object>  datas);

	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @return
	 */
	public EmailResult sendRetrySyncEmailByCode(String eventId, String email, String code);


	/**
	 *
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送短信
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public EmailResult sendRetrySyncEmailByCode(String eventId, String email, String code, Map<String,Object>  datas);

}
