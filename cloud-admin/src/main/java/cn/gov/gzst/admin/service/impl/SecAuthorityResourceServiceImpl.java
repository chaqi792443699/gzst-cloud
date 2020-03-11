package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SecAuthorityResource;
import cn.gov.gzst.admin.mapper.SecAuthorityResourceMapper;
import cn.gov.gzst.admin.service.ISecAuthorityResourceService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Transactional
@Service("SecAuthorityResourceService")
public class SecAuthorityResourceServiceImpl extends CommonServiceImpl<SecAuthorityResourceMapper, SecAuthorityResource> implements ISecAuthorityResourceService {

}
