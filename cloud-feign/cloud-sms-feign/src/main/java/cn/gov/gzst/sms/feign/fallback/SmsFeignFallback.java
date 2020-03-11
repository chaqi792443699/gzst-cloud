package cn.gov.gzst.sms.feign.fallback;


import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.sms.feign.SmsFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.feign.fallback
 * @title:
 * @description:
 * @author: jianliaoliang
 * @date: 2018/3/26 16:41
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@Component("smsFeign")
public class SmsFeignFallback implements SmsFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ResponseResult massSendSmsByCode(String phone, String code, String datas) {
        logger.error("调用{}异常:{}", "send","phone");
        return null;
    }
}
