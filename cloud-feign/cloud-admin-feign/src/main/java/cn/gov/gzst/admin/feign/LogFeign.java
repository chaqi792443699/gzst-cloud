package cn.gov.gzst.admin.feign;


import cn.gov.gzst.admin.bean.Log;
import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.fallback.LogFeignFallback;
import cn.gov.gzst.admin.feign.fallback.UserFeignFallback;
import cn.gov.gzst.common.bean.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.ga.LocaleNames_ga;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;

/**
 * 用户数据调用
 */
@FeignClient(name = "cloud-admin", fallback = LogFeignFallback.class)
public interface LogFeign {

    /**
     * 记录日志
     * @return
     */
    @RequestMapping(value = "/logApi/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    void save(Log log);

}
