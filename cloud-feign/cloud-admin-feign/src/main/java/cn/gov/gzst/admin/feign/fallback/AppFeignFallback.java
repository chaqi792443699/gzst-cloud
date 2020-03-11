package cn.gov.gzst.admin.feign.fallback;


import cn.gov.gzst.admin.bean.App;
import cn.gov.gzst.admin.feign.AppFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
@Component
public class AppFeignFallback implements AppFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Boolean checkClientId(String clientId) {
        logger.error("调用{}异常:{}", "checkClientId", clientId);
        return null;
    }

    @Override
    public Boolean checkClientSecret(String clientSecret) {
        logger.error("调用{}异常:{}", "checkClientSecret", clientSecret);
        return null;
    }

    @Override
    public List<App> listAvalable() {
        logger.error("调用{}异常:{}", "listAvalible", "没有数据");
        return null;
    }

    @Override
    public App findByAppKey(String appKey) {
        logger.error("调用{}异常:{}", "findByAppKey", appKey);
        return null;
    }
}
