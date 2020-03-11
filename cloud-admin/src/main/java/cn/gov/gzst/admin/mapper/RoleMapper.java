package cn.gov.gzst.admin.mapper;


import cn.gov.gzst.admin.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	/**
	 * 
	 * @title: findRoleByUserId   
	 * @description: 通过用户查找角色
	 * @param userId
	 * @return      
	 * @return: List<Role>
	 */
	List<Role> findRoleByUserId(String userId);

	/**
	 *
	 * @title: findRoleCodeUid
	 * @description: 查找角色用户列表
	 * @param wrapper
	 * @return
	 * @return: List<String>
	 */
	List<String> findRoleCodeUid(@Param("ew") Wrapper wrapper);

	/**
	 * 根据资源ID获取该资源归属的角色
	 * @param sourceId
	 * @return
	 */
	List<Role> findListBySourceId(String sourceId);
}
