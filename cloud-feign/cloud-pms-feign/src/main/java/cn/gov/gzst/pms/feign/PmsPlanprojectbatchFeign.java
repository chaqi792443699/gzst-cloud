package cn.gov.gzst.pms.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cloud-pms",fallback = PmsPlanprojectbatchFeign.class)
public interface PmsPlanprojectbatchFeign {

    @GetMapping("pmsPlanprojectbatch/getAnnually")
    public List getAnnually();
}
