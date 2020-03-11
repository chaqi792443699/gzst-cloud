package cn.gov.gzst.admin.mapper;

import cn.gov.gzst.admin.entity.Org;
import cn.gov.gzst.common.common.mapper.BaseTreeMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseTreeMapper<Org> {
	
	/**
	 * 
	 * @title: findListByUserId
	 * @description: 通过用户查找组织机构
	 * @param userId
	 * @return
	 * @return: List<Org>
	 */
	List<Org> findListByUserId(String userId);
}