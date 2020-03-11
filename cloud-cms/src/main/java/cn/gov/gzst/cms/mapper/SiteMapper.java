package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Site;
import cn.gov.gzst.cms.entity.Slide;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.mapper
 * @title: cms_site数据库控制层接口
 * @description: cms_site数据库控制层接口
 * @author: 吴正军
 * @date: 2018-10-29 17:32:14
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface SiteMapper extends BaseMapper<Site> {
 List<Site> selectList(Page<Site> page, @Param("ew") Wrapper<Site> wrapper);

}