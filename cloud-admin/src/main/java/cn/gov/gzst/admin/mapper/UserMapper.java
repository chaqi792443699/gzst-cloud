package cn.gov.gzst.admin.mapper;

import cn.gov.gzst.admin.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	/**
	 * 
	 * @title: selectEnterpriseRoleUid
	 * @description: 查找用户列表
	 * @param wrapper
	 * @return
	 * @return: List<User>
	 */
	List<String> selectEnterpriseRoleUid(@Param("ew") Wrapper<User> wrapper);
}