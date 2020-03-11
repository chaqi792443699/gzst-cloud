package cn.gov.gzst.sms.common.disruptor;

import cn.gov.gzst.common.utils.sms.data.SmsResult;

/**
 * 
 * All rights Reserved, Designed By www.gzst.gov.cn
 * 
 * @title: SmsDao.java
 * @package cn.gov.gzst.sms.common.disruptor.sms
 * @description: 短信dao
 * @author: jianliaoliang
 * @date: 2017年6月8日 上午8:42:47
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 * 
 */
public interface SmsDao {
	/**
	 * 
	 * @title: doStart
	 * @description:初始化回调
	 * @return: void
	 */
	public void doStart();

	/**
	 * 
	 * @title: doShutdown
	 * @description:关闭
	 * @return: void
	 */
	public void doShutdown();

	/**
	 * 
	 * @title: doShutdown
	 * @description:发送短信
	 * @return: void
	 */
	public void doSend(String eventId, SmsData smsData);

	/**
	 * 
	 * @title: doShutdown
	 * @description:响应
	 * @return: void
	 */
	public void doResult(String eventId, SmsData smsData, SmsResult smsResult);
}