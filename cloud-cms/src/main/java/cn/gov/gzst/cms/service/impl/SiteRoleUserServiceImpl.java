package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.ISiteRoleUserService;
import cn.gov.gzst.cms.entity.SiteRoleUser;
import cn.gov.gzst.cms.mapper.SiteRoleUserMapper;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: cms_site_role_user服务实现
* @description: cms_site_role_user服务实现
* @author: wuzhengjun
* @date: 2018-11-23 09:15:43
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("siteroleuserService")
public class SiteRoleUserServiceImpl  extends CommonServiceImpl<SiteRoleUserMapper,SiteRoleUser> implements  ISiteRoleUserService {
    @Override
    public Page<SiteRoleUser> selectList(Page<SiteRoleUser> page, @Param("ew") Wrapper<SiteRoleUser> wrapper) {
        wrapper.eq("1", "1");
        Page<SiteRoleUser> pages = page.setRecords(baseMapper.selectList(page,wrapper));
        List<SiteRoleUser> list = pages.getRecords();
        for(SiteRoleUser entity:list){
            EntityWrapper<SiteRoleUser> entityWrapper = new EntityWrapper<SiteRoleUser>();
            entityWrapper.eq("site_id",entity.getSiteId());
            entityWrapper.eq("user_id",entity.getUserId());
            List<Map> maps = baseMapper.getRoles(entityWrapper);
            String roleid = "";
            String rolename = "";
            for (Map map:maps){
                if(StringUtils.isEmpty(roleid)){
                    roleid = map.get("role_id").toString();
                }else{
                    roleid += "," + map.get("role_id").toString();
                }
                if(StringUtils.isEmpty(rolename)){
                    rolename = map.get("rolename").toString();
                }else{
                    rolename += "," + map.get("rolename").toString();
                }
            }
            entity.setRoleIds(roleid);
            entity.setRolename(rolename);
        }
        return page;
    }

    @Override
    public void deleteBySiteAndUser(@Param("ew") Wrapper<SiteRoleUser> wrapper) {
        baseMapper.deleteBySiteAndUser(wrapper);
    }
}