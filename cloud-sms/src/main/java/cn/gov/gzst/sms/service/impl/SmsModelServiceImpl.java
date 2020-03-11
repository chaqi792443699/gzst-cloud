package cn.gov.gzst.sms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.sms.service.ISmsModelService;
import cn.gov.gzst.sms.entity.SmsModel;
import cn.gov.gzst.sms.mapper.SmsModelMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@Transactional
@Service("smsModelService")
public class SmsModelServiceImpl extends CommonServiceImpl<SmsModelMapper, SmsModel> implements ISmsModelService {
    @Override
    public Page<SmsModel> selectPage(Page<SmsModel> page) {
        Page<SmsModel> pageBean=super.selectPage(page);

        return pageBean;
    }
}
