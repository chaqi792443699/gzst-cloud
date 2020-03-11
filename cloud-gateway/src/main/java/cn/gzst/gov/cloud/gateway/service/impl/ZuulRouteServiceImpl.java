package cn.gzst.gov.cloud.gateway.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gzst.gov.cloud.gateway.entity.ZuulRoute;
import cn.gzst.gov.cloud.gateway.mapper.ZuulRouteMapper;
import cn.gzst.gov.cloud.gateway.service.IZuulRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 刷新网关
 */
@Transactional
@Service("zuulRouteService")
public class ZuulRouteServiceImpl extends CommonServiceImpl<ZuulRouteMapper,ZuulRoute> implements IZuulRouteService {

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    RouteLocator routeLocator;

    public void refreshRoute() {
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }
}
