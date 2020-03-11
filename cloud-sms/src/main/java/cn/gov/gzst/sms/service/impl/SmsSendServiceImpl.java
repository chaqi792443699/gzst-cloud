package cn.gov.gzst.sms.service.impl;

import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.sms.data.SmsResult;
import cn.gov.gzst.sms.service.ISmsConfigService;
import cn.gov.gzst.sms.service.ISmsSendService;
import cn.gov.gzst.sms.service.ISmsModelService;
import cn.gov.gzst.sms.common.disruptor.SmsHelper;
import cn.gov.gzst.sms.entity.SmsConfig;
import cn.gov.gzst.sms.entity.SmsModel;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: 短信发送
 * @Description: 短信发送服务
 */
@Transactional
@Service("smsSendService")
public class SmsSendServiceImpl implements ISmsSendService {
    @Autowired
    private ISmsModelService smsModelService;
    @Autowired
    private ISmsConfigService smsConfigService;

    @Autowired
    private SmsHelper smsHelper;

    @Override
    public String sendAsyncSmsByCode(String phone, String code, String... datas) {
        return sendRetryAsyncSmsByCode(StringUtils.randomUUID(), phone, code, datas);
    }

    @Override
    public String sendRetryAsyncSmsByCode(String eventId, String phone, String code, String... datas) {
        SmsModel smsTemplate = smsModelService.selectOne(new EntityWrapper<SmsModel>().eq("code", code));
        String templateContent = smsTemplate.getTemplateContent();
        String templateId = smsTemplate.getTemplateId();
        cn.gov.gzst.common.utils.sms.data.SmsTemplate template = cn.gov.gzst.common.utils.sms.data.SmsTemplate.newTemplate(templateId, templateContent);
        //设置配置
        Map<String, String> config = null;
        if (!StringUtils.isEmpty(smsTemplate.getConfigId())) {
            config = new HashMap<String, String>();
            SmsConfig smsConfig = smsConfigService.selectById(smsTemplate.getConfigId());
            config.put("api_id", smsConfig.getAppId());
            config.put("api_key", smsConfig.getAppKey());
        }
        String smsid = smsHelper.sendAsyncSms(eventId, phone, template, config, datas);
        return smsid;
    }

    @Override
    public SmsResult sendSyncSmsByCode(String phone, String code, String... datas) {
        return sendRetrySyncSmsByCode(StringUtils.randomUUID(), phone, code, datas);
    }

    @Override
    public SmsResult sendRetrySyncSmsByCode(String eventId, String phone, String code, String... datas) {
        SmsModel smsTemplate = smsModelService.selectOne(new EntityWrapper<SmsModel>().eq("code", code));
        String templateContent = smsTemplate.getTemplateContent();
        String templateId = smsTemplate.getTemplateId();
        cn.gov.gzst.common.utils.sms.data.SmsTemplate template = cn.gov.gzst.common.utils.sms.data.SmsTemplate.newTemplate(templateId, templateContent);
        //设置配置
        Map<String, String> config = null;
        if (!StringUtils.isEmpty(smsTemplate.getConfigId())) {
            config = new HashMap<String, String>();
            SmsConfig smsConfig = smsConfigService.selectById(smsTemplate.getConfigId());
            config.put("api_id", smsConfig.getAppId());
            config.put("api_key", smsConfig.getAppKey());
        }
        return smsHelper.sendSyncSms(eventId, phone, template, config, datas);
    }

}
