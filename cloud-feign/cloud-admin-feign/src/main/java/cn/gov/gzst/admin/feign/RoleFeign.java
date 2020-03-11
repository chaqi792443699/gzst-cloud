package cn.gov.gzst.admin.feign;

import cn.gov.gzst.admin.bean.Role;
import cn.gov.gzst.admin.feign.fallback.RoleFallback;
import cn.gov.gzst.admin.feign.fallback.UserFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@FeignClient(name = "cloud-admin", fallback = RoleFallback.class)
public interface RoleFeign {

    /**
     * 通过查询用户
     *
     * @param uid 用户
     * @return List<Role>
     */
    @PostMapping(value = "/role/{uid}/findListByUserId")
    public List<Role> findListByUserId(@PathVariable("uid") String uid);
}
