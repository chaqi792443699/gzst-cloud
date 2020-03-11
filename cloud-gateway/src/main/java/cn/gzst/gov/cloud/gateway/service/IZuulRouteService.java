package cn.gzst.gov.cloud.gateway.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gzst.gov.cloud.gateway.entity.ZuulRoute;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gzst.gov.cloud.gateway.service.impl
 * @title:
 * @description: Zuul路由接口
 * @author: jianliaoliang
 * @date: 2018/4/6 11:20
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public interface IZuulRouteService   extends ICommonService<ZuulRoute> {

    /**
     * 刷新路由
     */
    public void refreshRoute();

}
