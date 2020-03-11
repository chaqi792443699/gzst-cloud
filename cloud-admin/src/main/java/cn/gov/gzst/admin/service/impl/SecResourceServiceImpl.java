package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SecAuthorityResource;
import cn.gov.gzst.admin.entity.SecResource;
import cn.gov.gzst.admin.mapper.SecResourceMapper;
import cn.gov.gzst.admin.service.ISecAuthorityResourceService;
import cn.gov.gzst.admin.service.ISecResourceService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Transactional
@Service("SecResourceService")
public class SecResourceServiceImpl extends CommonServiceImpl<SecResourceMapper, SecResource> implements ISecResourceService {

    @Autowired
    private ISecAuthorityResourceService secAuthorityResourceService;
    @Override
    public List<SecResource> listByAuthorityId(String authorityId) {
        if (StringUtils.isEmpty(authorityId)) {
            return null;
        }
        EntityWrapper<SecAuthorityResource> wrapper = new EntityWrapper<>(SecAuthorityResource.class);
        wrapper.eq("authority_id",authorityId);
        List<SecAuthorityResource> secAuthorityResources = secAuthorityResourceService.selectList(wrapper);
        EntityWrapper<SecResource> wrapperResource = new EntityWrapper<>(SecResource.class);
        List<String> ids = new ArrayList<String>();
        for (SecAuthorityResource secAuthorityResource : secAuthorityResources) {
            ids.add(secAuthorityResource.getResourceId());
        }
        if (ids.size() > 0) {
            return selectBatchIds(ids);
        }
        return null;
    }
}
