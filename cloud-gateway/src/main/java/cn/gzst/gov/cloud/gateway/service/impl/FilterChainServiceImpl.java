package cn.gzst.gov.cloud.gateway.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gzst.gov.cloud.gateway.service.IFilterChainService;
import cn.gzst.gov.cloud.gateway.entity.FilterChain;
import cn.gzst.gov.cloud.gateway.mapper.FilterChainMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gzst.gov.cloud.gateway.service.impl
* @title: 拦截链路服务实现
* @description: 拦截链路服务实现
* @author: jianliaoliang
* @date: 2018-04-27 09:37:02
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("filterchainService")
public class FilterChainServiceImpl  extends CommonServiceImpl<FilterChainMapper,FilterChain> implements  IFilterChainService {

}