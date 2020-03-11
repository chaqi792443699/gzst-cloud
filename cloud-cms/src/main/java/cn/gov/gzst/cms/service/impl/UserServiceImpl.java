package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.common.service.ISSOPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements ISSOPermissionService {

	@Autowired
	private UserFeign userFeign;

	@Override
	public List<String> getAuthorities(String userId) {
		List<SecAuthority> authorities = userFeign.findByAuthById(userId);
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
