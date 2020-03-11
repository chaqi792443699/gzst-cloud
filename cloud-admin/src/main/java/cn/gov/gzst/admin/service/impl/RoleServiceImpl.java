package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Role;
import cn.gov.gzst.admin.entity.SecRoleAuthority;
import cn.gov.gzst.admin.entity.SysUserRole;
import cn.gov.gzst.admin.mapper.RoleMapper;
import cn.gov.gzst.admin.service.IRoleService;
import cn.gov.gzst.admin.service.ISecRoleAuthorityService;
import cn.gov.gzst.admin.service.ISysUserRoleService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("roleService")
public class RoleServiceImpl extends CommonServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired
	private ISecRoleAuthorityService secRoleAuthorityService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@Override
	public List<Role> findListBySouceId(String sourceId) {
		return baseMapper.findListBySourceId(sourceId);
	}

	@Override
	public List<Role> findListByUserId(String userid) {
		return baseMapper.findRoleByUserId(userid);
	}

	@Override
	public List<String> findRoleCodeUid(Wrapper wrapper) {
		return baseMapper.findRoleCodeUid(wrapper);
	}

	@Override
	public boolean updateAuthorities(String id, String[] authorityIds) {
		EntityWrapper<SecRoleAuthority> wrapper = new EntityWrapper<>(SecRoleAuthority.class);
		wrapper.eq("role_id",id);
		List<SecRoleAuthority> oldAuthorities = secRoleAuthorityService.selectList(wrapper);
		List<String> ids = new ArrayList<String>();
		for (SecRoleAuthority secRoleAuthority : oldAuthorities) {
			ids.add(secRoleAuthority.getId());
		}
		if (ids.size() > 0) {
			secRoleAuthorityService.deleteBatchIds(ids);
		}
		List<SecRoleAuthority> secRoleAuthorities = new ArrayList<SecRoleAuthority>();
		for (String authorityId : authorityIds) {
			SecRoleAuthority secRoleAuthority = new SecRoleAuthority();
			secRoleAuthority.setRoleId(id);
			secRoleAuthority.setAuthorityId(authorityId);
			secRoleAuthorities.add(secRoleAuthority);
		}
		if (secRoleAuthorities.size() > 0) {
			return secRoleAuthorityService.insertBatch(secRoleAuthorities);
		} else {
			return true;
		}
	}

	@Override
	public List<Role> findListBySceneAndUser(String sceneId, String userId) {
		List<Role> roles = new ArrayList<Role>();
		EntityWrapper<SysUserRole> wrapper1 = new EntityWrapper<>(SysUserRole.class);
		if (!StringUtils.isEmpty(sceneId)) {
			wrapper1.eq("scene_id",sceneId);
		}
		wrapper1.eq("user_id",userId);
		List<SysUserRole> sysUserRoles = sysUserRoleService.selectList(wrapper1);
		List<String> roleIds = new ArrayList<String>();
		for (SysUserRole sysUserRole : sysUserRoles) {
			roleIds.add(sysUserRole.getRoleId());
		}
		if (roleIds.size() > 0) {
			roles = this.selectBatchIds(roleIds);
		}
		return roles;
	}


	@Override
	public boolean assignRole(String userId, String sceneId, String roleId) {
		EntityWrapper<SysUserRole> wrapper1 = new EntityWrapper<>(SysUserRole.class);
		wrapper1.eq("scene_id",sceneId).eq("user_id",userId).eq("role_id",roleId);
		List<SysUserRole> sysUserRoles = sysUserRoleService.selectList(wrapper1);
		List<String> ids = new ArrayList<>();
		for (SysUserRole sysUserRole : sysUserRoles) {
			ids.add(sysUserRole.getId());
		}
		if (ids.size() > 0) {
			sysUserRoleService.deleteBatchIds(ids);
		}
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(userId);
		sysUserRole.setSceneId(sceneId);
		sysUserRole.setRoleId(roleId);
		Boolean flag = sysUserRoleService.insert(sysUserRole);
		return flag;
	}

	@Override
	public boolean revokeRole(String userId, String sceneId, String roleId) {
		EntityWrapper<SysUserRole> wrapper = new EntityWrapper<>(SysUserRole.class);
		wrapper.eq("user_id",userId).eq("scene_id",sceneId).eq("role_id",roleId);
		Boolean flag = sysUserRoleService.delete(wrapper);
		return flag;
	}

	/**
	 * 更新角色关系
	 * @param role
	 */
	@Override
	public void updateLinks(Role role) {
		String roleId = role.getId();
		EntityWrapper<SysUserRole> wrapper = new EntityWrapper<>(SysUserRole.class);
		wrapper.eq("role_id",roleId);
		List<SysUserRole> userRoles = this.sysUserRoleService.selectList(wrapper);
		for (SysUserRole userRole : userRoles) {
			userRole.setSceneId(role.getSceneId());
		}
		this.sysUserRoleService.updateBatchById(userRoles);
	}
}
