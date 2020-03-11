package cn.gov.gzst.email.feign;


import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.email.feign.fallback.EmailFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.feign
 * @title:
 * @description: 发送短信
 * @author: jianliaoliang
 * @date: 2018/3/29 9:28
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@FeignClient(name = "cloud-email", fallback = EmailFeignFallback.class)
public interface EmailFeign {

    @PostMapping(value = "/send")
    public ResponseResult send(@RequestParam("email") String email, @RequestParam("code") String code, @RequestParam("datas") Map<String, Object> datas);

}
