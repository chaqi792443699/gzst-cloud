package cn.gov.gzst.admin.feign;


import cn.gov.gzst.admin.bean.App;
import cn.gov.gzst.admin.config.FeignConfiguration;
import cn.gov.gzst.admin.feign.fallback.AppFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  @description: 应用程序工具类
 */
@FeignClient(name = "cloud-admin", fallback = AppFeignFallback.class,configuration = FeignConfiguration.class)
public interface AppFeign {

    @RequestMapping(value = "/app/checkClientId/{clientId}")
    public Boolean checkClientId(@PathVariable("clientId") String clientId);

    @RequestMapping(value = "/app/checkClientSecret/{clientSecret}")
    public Boolean checkClientSecret(@PathVariable("clientSecret")  String clientSecret);

    @GetMapping("/app/list/avalable")
    public List<App> listAvalable();

    @GetMapping("/app/{appKey}")
    public App findByAppKey(@RequestParam("appKey") String appKey);

}
