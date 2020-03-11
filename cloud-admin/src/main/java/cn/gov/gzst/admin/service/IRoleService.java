package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.Role;
import cn.gov.gzst.common.common.service.ICommonService;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2014-12-20 21:33:15
 * @version V1.0
 *
 */
public interface IRoleService extends ICommonService<Role> {

	List<Role> findListBySouceId(String sourceId);
	/**
	 * 通过用户ID查找角色
	 */
	List<Role> findListByUserId(String userid);

	/**
	 * 通过用户ID查找角色
	 */
	List<String> findRoleCodeUid(Wrapper wrapper);

	/**
	 * 更新角色的权限
	 * @param id
	 * @param authorityIds
	 * @return
	 */
	boolean updateAuthorities(String id,String[] authorityIds);

	/**
	 * 通过场景、用户查询角色列表
	 * @param sceneId
	 * @param userId
	 * @return
	 */
	List<Role> findListBySceneAndUser(String sceneId, String userId);

	/**
	 * 分配角色给用户
	 * @param userId
	 * @param sceneId
	 * @param roleId
	 * @return
	 */
	boolean assignRole(String userId,String sceneId,String roleId);

	/**
	 * 回收角色
	 * @param userId
	 * @param sceneId
	 * @param roleId
	 * @return
	 */
	boolean revokeRole(String userId,String sceneId,String roleId);


	/**
	 * 更新角色对应的关系
	 * @param role
	 */
	void updateLinks(Role role);

}
