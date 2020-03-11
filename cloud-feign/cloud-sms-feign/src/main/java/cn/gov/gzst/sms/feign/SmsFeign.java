package cn.gov.gzst.sms.feign;


import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.sms.feign.fallback.SmsFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @title:
 * @description: 发送短信
 */
@FeignClient(name = "cloud-sms", fallback = SmsFeignFallback.class)
public interface SmsFeign {

    @PostMapping(value = "/smsApi/massSendSmsByCode")
    public ResponseResult massSendSmsByCode(@RequestParam("phone") String phone, @RequestParam("code") String code, @RequestParam("data") String data);

}
