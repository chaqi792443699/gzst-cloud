package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.admin.entity.SecAuthorityResource;
import cn.gov.gzst.admin.entity.SecRoleAuthority;
import cn.gov.gzst.admin.mapper.SecAuthorityMapper;
import cn.gov.gzst.admin.service.ISecAuthorityResourceService;
import cn.gov.gzst.admin.service.ISecAuthorityService;
import cn.gov.gzst.admin.service.ISecRoleAuthorityService;
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
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Transactional
@Service("SecAuthorityService")
public class SecAuthorityServiceImpl extends CommonServiceImpl<SecAuthorityMapper, SecAuthority> implements ISecAuthorityService {

    @Autowired
    private ISecAuthorityResourceService secAuthorityResourceService;

    @Autowired
    private ISecRoleAuthorityService secRoleAuthorityService;

    @Override
    public boolean updateResources(String id, String[] resourceIds) {
        EntityWrapper<SecAuthorityResource> wrapper = new EntityWrapper<>(SecAuthorityResource.class);
        wrapper.eq("authority_id",id);
        List<SecAuthorityResource> oldResources = secAuthorityResourceService.selectList(wrapper);
        List<String> ids = new ArrayList<String>();
        for (SecAuthorityResource oldResource : oldResources) {
            ids.add(oldResource.getId());
        }
        if (ids.size() > 0) {
            secAuthorityResourceService.deleteBatchIds(ids);
        }
        List<SecAuthorityResource> resources = new ArrayList<SecAuthorityResource>();
        for (String resourceId : resourceIds) {
            SecAuthorityResource secAuthorityResource = new SecAuthorityResource();
            secAuthorityResource.setAuthorityId(id);
            secAuthorityResource.setResourceId(resourceId);
            resources.add(secAuthorityResource);
        }
        if (resources.size() > 0) {
            return secAuthorityResourceService.insertBatch(resources);
        } else {
            return true;
        }
    }

    @Override
    public List<SecAuthority> listByRoleId(String roleId) {
        if (StringUtils.isEmpty(roleId)) {
            return null;
        }
        EntityWrapper<SecRoleAuthority> wrapper = new EntityWrapper<>(SecRoleAuthority.class);
        wrapper.eq("role_id",roleId);
        List<SecRoleAuthority> secRoleAuthorities = secRoleAuthorityService.selectList(wrapper);
        List<String> ids = new ArrayList<String>();
        for (SecRoleAuthority secRoleAuthority : secRoleAuthorities) {
            ids.add(secRoleAuthority.getAuthorityId());
        }
        if (ids.size() > 0) {
            return selectBatchIds(ids);
        }
        return null;
    }
}
