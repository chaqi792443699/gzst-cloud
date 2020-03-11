package cn.gov.gzst.admin.feign.fallback;

import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.UserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.feign.fallback
 * @title:
 * @description:
 * @author: jianliaoliang
 * @date: 2018/3/26 16:41
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class UserFeignFallback implements UserFeign{
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public User findByUsername(@PathVariable("username") String username) {
        return null;
    }

    @Override
    public Boolean checkUser(String username, String password) {
        logger.error("调用{}异常:{}", "checkUser", "");
        return false;
    }

    @Override
    public User findByUserId(String id) {
        return null;
    }

    @Override
    public List<SecAuthority> findByAuthById(String id) {
        logger.error("调用{}异常:{}", "findByAuthById", "");
        return null;
    }

    @Override
    public List<User> findListByIds(String[] ids) {
        logger.error("调用{}异常:{}", "findListByIds", "");
        return null;
    }
}
