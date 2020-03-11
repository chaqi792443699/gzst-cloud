package cn.gov.gzst.admin.feign;


import cn.gov.gzst.admin.bean.Tree;
import cn.gov.gzst.admin.feign.fallback.TreeFeignFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.expert.feign
 * @title:
 * @description: 字典查询
 * @author: jianliaoliang
 * @date: 2018/5/29 11:53
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@FeignClient(name = "cloud-admin", fallback = TreeFeignFallback.class)
public interface TreeFeign {

    @GetMapping(value = "/tree/{code}/treeList")
    public List<Tree> treeList(@PathVariable("code") String code);
}
