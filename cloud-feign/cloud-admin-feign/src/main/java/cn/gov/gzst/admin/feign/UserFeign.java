package cn.gov.gzst.admin.feign;


import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.fallback.UserFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户数据调用
 */
@FeignClient(name = "cloud-admin", fallback = UserFeignFallback.class)
public interface UserFeign {

    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return User
     */
    @RequestMapping("/userApi/findByUsername/{username}")
    User findByUsername(@PathVariable("username") String username);

    /**
     * 通过绑定用户Id查询
     *
     * @param id 绑定用户Id
     * @return
     */
    @RequestMapping("/userApi/findByUserId/{id}")
    User findByUserId(@PathVariable("id") String id);

    /**
     * 检查用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/userApi/checkUser/{username}/{password}")
    Boolean checkUser(@PathVariable("username")String username, @PathVariable("password")String password);

    /**
     * 查询用户权限，为其模块提供权限控制支持
     * @param id
     * @return
     */
    @PostMapping("/userApi/findAuthes/{id}")
    List<SecAuthority> findByAuthById(@PathVariable("id")String id);

    @PostMapping("/userApi/findListByIds")
    List<User> findListByIds(String[] ids);
}
