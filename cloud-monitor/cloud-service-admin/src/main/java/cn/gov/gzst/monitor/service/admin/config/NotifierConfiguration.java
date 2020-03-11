package cn.gov.gzst.monitor.service.admin.config;

import cn.gov.gzst.monitor.service.admin.filter.MobileNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * @author lengleng
 * @date 2018/1/25
 *  监控提醒配置
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

    //服务上线或者下线都通知
    private String[] reminderStatuses = { "DOWN" };

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier(Notifier mobileNotifier) {
        RemindingNotifier remindingNotifier = new RemindingNotifier(mobileNotifier);
        //设定时间，5分钟提醒一次
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5));
        //设定监控服务状态，状态改变为给定值的时候提醒
        remindingNotifier.setReminderStatuses(reminderStatuses);
        return remindingNotifier;
    }

    @Bean
    public MobileNotifier mobileNotifier(){
        MobileNotifier mobileNotifier=new MobileNotifier();
        return  mobileNotifier;
    }

    /*@Scheduled(fixedRate = 60_000L)
    public void remind(RemindingNotifier remindingNotifier) {
        remindingNotifier.sendReminders();
    }*/


}