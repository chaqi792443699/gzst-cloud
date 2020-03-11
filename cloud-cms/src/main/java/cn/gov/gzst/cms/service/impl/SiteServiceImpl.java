package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.ISiteService;
import cn.gov.gzst.cms.entity.Site;
import cn.gov.gzst.cms.mapper.SiteMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: cms_site服务实现
* @description: cms_site服务实现
* @author: 吴正军
* @date: 2018-10-29 17:32:14
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("siteService")
public class SiteServiceImpl  extends CommonServiceImpl<SiteMapper,Site> implements  ISiteService {

    @Override
    public Page<Site> selectList(Page<Site> page, @Param("ew") Wrapper<Site> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectList(page,wrapper));
        return page;
    }
}