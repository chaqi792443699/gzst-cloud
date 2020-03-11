package cn.gov.gzst.admin.feign.fallback;


import cn.gov.gzst.admin.bean.Enterprise;
import cn.gov.gzst.admin.feign.EnterpriseFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
@Component("enterpriseFeign")
public class EnterpriseFeignFallback implements EnterpriseFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Enterprise findById(String id) {
        logger.error("调用{}异常:{}", "findById",id);
        return null;
    }

    @Override
    public String findByName(String name) {
        logger.error("调用{}异常:{}", "findByIdcard",name);
        return null;
    }
}
