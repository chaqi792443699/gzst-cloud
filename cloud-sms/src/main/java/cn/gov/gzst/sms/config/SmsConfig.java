package cn.gov.gzst.sms.config;

import cn.gov.gzst.common.utils.sms.sender.HuyiSmsSender;
import cn.gov.gzst.common.utils.sms.sender.SmsSender;
import cn.gov.gzst.sms.common.disruptor.SmsDao;
import cn.gov.gzst.sms.common.disruptor.SmsHelper;
import cn.gov.gzst.sms.dao.SmsDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.modules.config
 * @title:
 * @description: 短信发送配置
 * @author: jianliaoliang
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Configuration
public class SmsConfig {

    @Bean
    public SmsDao smsDao(){
        SmsDao smsDao=  new SmsDaoImpl();
        return smsDao;
    }

    @Bean
    public SmsSender smsSender(){
        SmsSender smsSender=  new HuyiSmsSender();
        return smsSender;
    }

    @Bean
    public SmsHelper smsHelper(SmsDao smsDao,SmsSender smsSender){
        SmsHelper smsHelper=  new SmsHelper();
        smsHelper.setHandlerCount(1);
        smsHelper.setBufferSize(1024);
        smsHelper.setSmsDao(smsDao);
        smsHelper.setSmsSender(smsSender);
        return smsHelper;
    }

}
