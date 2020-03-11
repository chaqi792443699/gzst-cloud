package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Role;
import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.admin.entity.SysUserRole;
import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.admin.mapper.UserMapper;
import cn.gov.gzst.admin.service.*;
import cn.gov.gzst.common.common.service.ISSOPermissionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl extends CommonServiceImpl<UserMapper, User> implements IUserService, ISSOPermissionService {
	@Autowired
	PasswordHelper passwordHelper;
	@Autowired
	private IRoleService roleService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@Autowired
	private ISecAuthorityService secAuthorityService;

	@Override
	public void changePassword(String userid, String newPassword) {
		User user = selectById(userid);
		if (user != null) {
			user.setPassword(newPassword);
			passwordHelper.encryptPassword(user);
		}
		insertOrUpdate(user);
	}

	@Override
	public User findByUsername(String username) {
		if (StringUtils.isEmpty(username)) {
			return null;
		}
		EntityWrapper<User> ew = new EntityWrapper<>(User.class);
		ew.eq("user_name", username)
				.or().eq("certi_num",username)
				.or().eq("mobile",username);
		User user = selectOne(ew);
		return user;
	}

	@Override
	public List<Role> findRoleById(String sceneId, String userId) {
		List<Role> roles = new ArrayList<Role>();
		if (StringUtils.isEmpty(userId)) {
			return roles;
		}
		User user = selectById(userId);
		if (user != null) {
			roles = roleService.findListBySceneAndUser(sceneId,user.getId());
		}
		return roles;
	}

	@Override
	public List<SecAuthority> findAuthById(String sceneId, String userId) {
		List<SecAuthority> authorities = new ArrayList<SecAuthority>();
		if (StringUtils.isEmpty(userId)) {
			return authorities;
		}
		User user = selectById(userId);
		if (user != null) {
			List<Role> roles = roleService.findListBySceneAndUser(sceneId,user.getId());
			if (roles != null) {
				for (Role role : roles) {
					List<SecAuthority> tempList = secAuthorityService.listByRoleId(role.getId());
					if (tempList != null && tempList.size() > 0) {
						authorities.addAll(tempList);
					}
				}
			}
		}
		return authorities;
	}

	@Override
	public User findByUserId(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		User user = selectById(id);
		if (user != null) {
			List<Role> roles = this.findRoleById(null,user.getId());
			List<SecAuthority> authorities = this.findAuthById(null,user.getId());
			user.setRoles(roles);
			user.setAuthorities(authorities);
		}
		return user;
	}

	@Override
	public Boolean checkUser(String username, String password) {
		User user=findByUsername(username);
		if (user==null){
			return Boolean.FALSE;
		}
		String newPassword=passwordHelper.encryptPassword(user.getUsername(),password,user.getSalt());
		if (newPassword.equals(user.getPassword())){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public boolean insert(User user) {
		//账号重复
		if (selectCount(new EntityWrapper<User>().eq("user_name",user.getUsername()))>0){
			throw new RuntimeException("账号重复");
		}
		//检查身份证号码重复
		if (selectCount(new EntityWrapper<User>().eq("certi_num",user.getCertiNum()))>0){
			throw new RuntimeException("身份证号码重复");
		}
		//检查手机号码
		if (selectCount(new EntityWrapper<User>().eq("mobile",user.getMobile()))>0){
			throw new RuntimeException("手机号码重复");
		}
		passwordHelper.encryptPassword(user);
		return super.insert(user);
	}

	@Override
	public boolean insertOrUpdate(User user) {
		//账号重复
		if (selectCount(new EntityWrapper<User>().ne("id",user.getId()).eq("user_name",user.getUsername()))>0){
			throw new RuntimeException("账号重复");
		}
		//检查身份证号码重复
		if (selectCount(new EntityWrapper<User>().ne("id",user.getId()).eq("certi_num",user.getCertiNum()))>0){
			throw new RuntimeException("身份证号码重复");
		}
		//检查手机号码
		if (selectCount(new EntityWrapper<User>().ne("id",user.getId()).eq("mobile",user.getMobile()))>0){
			throw new RuntimeException("手机号码重复");
		}
		if (!StringUtils.isEmpty(user.getRepassword())) {
			passwordHelper.encryptPassword(user);
		}
		return super.insertOrUpdate(user);
	}

	@Override
	public boolean deleteById(Serializable id) {
		// 删除角色关联
		EntityWrapper<SysUserRole> wrapper = new EntityWrapper<SysUserRole>(SysUserRole.class);
		wrapper.eq("user_id",id);
		this.sysUserRoleService.delete(wrapper);
		return super.deleteById(id);
	}

	@Override
	public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
		for (Object id : idList) {
			this.deleteById((Serializable) id);
		}
		return true;
	}


	private String getFullPDivision(String locationCode){
		int length = locationCode.length();
		switch (length){
			case 2:
				locationCode=locationCode+"0000";
				break;
			case 4:
				locationCode=locationCode+"00";
				break;
			case 6:
				locationCode=locationCode;
				break;
		}
		return locationCode;
	}

	private int getPDivisionLength(String locationCode){
		int pLength = 0;
		int length = locationCode.length();
		switch (length){
			case 9:
				pLength=6;
				break;
			case 6:
				pLength=4;
				break;
			case 4:
				pLength=2;
				break;
			case 2:
				pLength=0;
				break;
		}
		return pLength;
	}

	@Override
	public List<String> getAuthorities(String userId) {
		List<SecAuthority> authorities = this.findAuthById(null,userId);
		List<String> authes = new ArrayList<String>();
		for (SecAuthority authority : authorities) {
			authes.add(authority.getName());
		}
		return authes;
	}

	@Override
	public List<String> getResources(String userId) {
		return null;
	}
}
