package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.entity.Menu;
import cn.gov.gzst.common.common.mapper.BaseTreeMapper;
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
 * @title: cms_menu数据库控制层接口
 * @description: cms_menu数据库控制层接口
 * @author: wuzhengjun
 * @date: 2018-11-20 10:36:36
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface MenuMapper extends BaseTreeMapper<Menu> {
 List<Menu> selectList(Page<Menu> page, @Param("ew") Wrapper<Menu> wrapper);

}