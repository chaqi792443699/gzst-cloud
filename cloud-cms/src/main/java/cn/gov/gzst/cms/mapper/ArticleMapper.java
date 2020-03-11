package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Article;
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
 * @title: 文章管理数据库控制层接口
 * @description: 文章管理数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:29
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
 List<Article> selectList(Page<Article> page, @Param("ew") Wrapper<Article> wrapper);
 List<Article> ArticleListBysiteId(Page<Article> page, @Param("ew") Wrapper<Article> wrapper);

}