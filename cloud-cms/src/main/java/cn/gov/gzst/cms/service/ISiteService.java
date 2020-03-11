package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Slide;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.cms.entity.Site;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service
* @title: cms_site服务接口
* @description: cms_site服务接口
* @author: 吴正军
* @date: 2018-10-29 17:32:14
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface ISiteService extends ICommonService<Site> {
    Page<Site> selectList(Page<Site> page, @Param("ew") Wrapper<Site> wrapper);
}