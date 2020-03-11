package cn.gzst.gov.cloud.gateway.mapper;

import cn.gzst.gov.cloud.gateway.entity.FilterChain;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gzst.gov.cloud.gateway.mapper
 * @title: 拦截链路数据库控制层接口
 * @description: 拦截链路数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-04-27 09:37:02
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface FilterChainMapper extends BaseMapper<FilterChain> {
    
}