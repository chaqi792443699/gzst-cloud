package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Site;
import cn.gov.gzst.cms.entity.SiteRoleUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.mapper
 * @title: cms_site_role_user数据库控制层接口
 * @description: cms_site_role_user数据库控制层接口
 * @author: wuzhengjun
 * @date: 2018-11-23 09:15:43
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface SiteRoleUserMapper extends BaseMapper<SiteRoleUser> {
 List<SiteRoleUser> selectList(Page<SiteRoleUser> page, @Param("ew") Wrapper<SiteRoleUser> wrapper);

 List<Map> getRoles(@Param("ew") Wrapper<SiteRoleUser> wrapper);

 void deleteBySiteAndUser(@Param("ew") Wrapper<SiteRoleUser> wrapper);
}