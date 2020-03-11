package cn.gzst.gov.cloud.gateway.mapper;

import cn.gzst.gov.cloud.gateway.entity.ZuulRoute;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网关路由mapper
 */
@Mapper
public interface ZuulRouteMapper extends BaseMapper<ZuulRoute> {

}