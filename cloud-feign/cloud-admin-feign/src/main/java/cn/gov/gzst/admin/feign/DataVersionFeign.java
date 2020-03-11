package cn.gov.gzst.admin.feign;

import cn.gov.gzst.admin.bean.DataVersion;
import cn.gov.gzst.admin.feign.fallback.DataVersionFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.feign
 * @title:
 * @description: 远程调用
 * @author: jianliaoliang
 * @date: 2018/3/26 16:38
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@FeignClient(name = "cloud-admin", fallback = DataVersionFeignFallback.class)
public interface DataVersionFeign {

    @PostMapping("data/version/{businessKey}/{businessType}/addVersion")
    DataVersion addVersion(@RequestParam("jsonData") String jsonData,
                           @PathVariable("businessKey") String businessKey,
                           @PathVariable("businessType") String businessType);

    @GetMapping("data/version/{businessKey}/{businessType}/newest")
    DataVersion getNewestDataVersion(@PathVariable("businessKey")  String businessKey,
                                        @PathVariable("businessType")  String businessType);

    @GetMapping("data/version/{businessKey}/{businessType}/{version}")
    DataVersion getDataVersion(@PathVariable("businessKey") String businessKey,
                                  @PathVariable("businessType") String businessType,
                                  @PathVariable("version") String version);
}
