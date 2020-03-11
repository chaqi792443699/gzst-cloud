package cn.gov.gzst.pms.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cloud-pms",fallback = PmsDepartmentFeign.class)
public interface PmsDepartmentFeign {

    @GetMapping("pmsDepartment/getDeptList")
    public List getDeptList();
}
