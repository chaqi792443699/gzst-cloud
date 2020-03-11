package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Slide;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.cms.entity.Article;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service
* @title: 文章管理服务接口
* @description: 文章管理服务接口
* @author: jianliaoliang
* @date: 2018-05-02 09:35:29
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface IArticleService extends ICommonService<Article> {
    Page<Article> selectList(Page<Article> page, @Param("ew") Wrapper<Article> wrapper);
    Page<Article> ArticleListBysiteId(Page<Article> page, @Param("ew") Wrapper<Article> wrapper);
}