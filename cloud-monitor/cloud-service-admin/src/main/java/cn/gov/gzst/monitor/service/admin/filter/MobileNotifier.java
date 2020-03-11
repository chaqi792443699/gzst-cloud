package cn.gov.gzst.monitor.service.admin.filter;

import cn.gov.gzst.common.utils.DateUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.sms.SmsManager;
import cn.gov.gzst.common.utils.sms.data.SmsResult;
import cn.gov.gzst.common.utils.sms.data.SmsTemplate;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.config
 * @title:
 * @description: 服务下线短信通知
 * @author: jianliaoliang
 * @date: 2018/3/11 16:01
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class MobileNotifier extends AbstractStatusChangeNotifier {

    @Value("${spring.boot.admin.notify.sms.to}")
    private String sendToPhone = "";

    @Value("${spring.sms.huyi.api_id}")
    private String apiId = "";

    @Value("${spring.sms.huyi.api_key}")
    private String apiKey = "";

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public static final String STATUS_CHANGE = "STATUS_CHANGE";

    /**
     * 判断是否通知
     *
     * @param event 事件
     * @return 是、否
     */
    @Override
    protected boolean shouldNotify(ClientApplicationEvent event) {
        boolean shouldNotify = false;
        if (STATUS_CHANGE.equals(event.getType())
                && event.getApplication().getStatusInfo().isOffline()
                || event.getApplication().getStatusInfo().isDown()) {
            shouldNotify = true;
        }
        return shouldNotify;
    }

    /**
     * 通知逻辑
     *
     * @param event 事件
     * @throws Exception 异常
     */
    @Override
    protected void doNotify(ClientApplicationEvent event) {
        if (event instanceof ClientApplicationStatusChangedEvent) {
            logger.info("Application {} ({}) is {}", event.getApplication().getName(),
                    event.getApplication().getId(), ((ClientApplicationStatusChangedEvent) event).getTo().getStatus());
            String text = String.format("应用:%s 服务ID:%s 下线，时间：%s", event.getApplication().getName(), event.getApplication().getId(), DateUtils.formatDateTime(event.getTimestamp()).toString());
            SmsTemplate smsTemplate = SmsTemplate.newTemplateByContent(text);
            //使用
            Map<String,String> config=new HashMap<String,String>();
            config.put("api_id",apiId);
            config.put("api_key",apiKey);
            if (!StringUtils.isEmpty(sendToPhone)) {
                SmsResult smsResult = SmsManager.getSmsManager().getSmsSender().send(sendToPhone, smsTemplate, config);
                if (smsResult != null) {
                    logger.info("短信发送状态 {}", smsResult.getMsg());
                }
            }
        } else {
            logger.info("Application {} ({}) {}", event.getApplication().getName(),
                    event.getApplication().getId(), event.getType());
        }
    }

}