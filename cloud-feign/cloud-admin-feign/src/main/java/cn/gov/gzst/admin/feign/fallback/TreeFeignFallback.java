package cn.gov.gzst.admin.feign.fallback;


import cn.gov.gzst.admin.bean.Tree;
import cn.gov.gzst.admin.feign.TreeFeign;
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
@Component("treeFeign")
public class TreeFeignFallback implements TreeFeign {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Tree> treeList(String code) {
        return null;
    }
}
