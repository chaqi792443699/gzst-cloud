package cn.gov.gzst.email.config;

import cn.gov.gzst.email.common.disruptor.EmailDao;
import cn.gov.gzst.email.common.disruptor.EmailHelper;
import cn.gov.gzst.email.dao.EmailDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.modules.config
 * @title:
 * @description: 邮件发送配置
 * @author: jianliaoliang
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Configuration
public class EmailConfig {

    @Bean
    public EmailDao emailDao(){
        EmailDao emailDao=  new EmailDaoImpl();
        return emailDao;
    }

    @Bean
    public EmailHelper emailHelper(EmailDao emailDao){
        EmailHelper emailHelper=  new EmailHelper();
        emailHelper.setHandlerCount(1);
        emailHelper.setBufferSize(1024);
        emailHelper.setEmailDao(emailDao);
        return emailHelper;
    }

}
