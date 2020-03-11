package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Site;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.cms.entity.SiteRoleUser;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service
* @title: cms_site_role_user服务接口
* @description: cms_site_role_user服务接口
* @author: wuzhengjun
* @date: 2018-11-23 09:15:43
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface ISiteRoleUserService extends ICommonService<SiteRoleUser> {
    Page<SiteRoleUser> selectList(Page<SiteRoleUser> page, @Param("ew") Wrapper<SiteRoleUser> wrapper);
    void deleteBySiteAndUser(@Param("ew") Wrapper<SiteRoleUser> wrapper);

}