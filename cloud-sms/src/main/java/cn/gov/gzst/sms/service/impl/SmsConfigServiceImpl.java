package cn.gov.gzst.sms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.sms.service.ISmsConfigService;
import cn.gov.gzst.sms.entity.SmsConfig;
import cn.gov.gzst.sms.mapper.SmsConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 短信配置
 * @Description: 短信配置
 * @author jianliaoliang
 * @date 2018-02-06 16:12:28
 * @version V1.0   
 *
 */
@Transactional
@Service("smsConfigService")
public class SmsConfigServiceImpl  extends CommonServiceImpl<SmsConfigMapper,SmsConfig> implements  ISmsConfigService {

}
