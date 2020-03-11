package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.entity.Guestbook;
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
 * @title: 栏目管理数据库控制层接口
 * @description: 栏目管理数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:40
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface CategoryMapper extends BaseTreeMapper<Category> {
 List<Category> selectList(Page<Category> page, @Param("ew") Wrapper<Category> wrapper);
}