package cn.gov.gzst.sms.common.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 
 * All rights Reserved, Designed By www.gzst.gov.cn
 * 
 * @title: LongEventFactory.java
 * @package cn.gov.gzst.sms.common.disruptor.sms
 * @description: 定义事件工厂
 * @author: jianliaoliang
 * @date: 2017年6月7日 下午11:18:32
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public class SmsEventFactory implements EventFactory<SmsEvent> {
	public SmsEvent newInstance() {
		return new SmsEvent();
	}
}