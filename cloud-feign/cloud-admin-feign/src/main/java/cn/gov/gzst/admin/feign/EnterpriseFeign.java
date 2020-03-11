package cn.gov.gzst.admin.feign;


import cn.gov.gzst.admin.bean.Enterprise;
import cn.gov.gzst.admin.feign.fallback.EnterpriseFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@FeignClient(name = "cloud-admin", fallback = EnterpriseFeignFallback.class)
public interface EnterpriseFeign {

    /**
     * 通过查询用户
     *
     * @param id 用户、手机、邮箱
     * @return User
     */
    @RequestMapping("/enterprise/findById/{id}")
    Enterprise findById(@PathVariable("id") String id);

    @RequestMapping("/enterprise/findByName/{name}")
    String findByName(@PathVariable("name") String name);
}
