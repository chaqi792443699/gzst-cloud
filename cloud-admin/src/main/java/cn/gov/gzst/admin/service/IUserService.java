package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.Role;
import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.admin.entity.User;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 *
 * @title: IUserService.java
 * @description: 用户服务接口
 * @author: jianliaoliang
 *
 */
public interface IUserService extends ICommonService<User> {
	/**
	 * 修改密码
	 *
	 * @param newPassword
	 */
	void changePassword(String userid, String newPassword);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	User findByUserId(String id);

	/**
	 * 检查用户
	 * @param username
	 * @param password
	 * @return
	 */
	Boolean checkUser(String username, String password);


	/**
	 * 查询角色清单 通过用户ID
	 * @param sceneId
	 * @param userId
	 * @return
	 */
	List<Role> findRoleById(String sceneId,String userId);

	/**
	 * 查询权限清单 通过用户ID
	 * @param sceneId
	 * @param userId
	 * @return
	 */
	List<SecAuthority> findAuthById(String sceneId,String userId);
}
