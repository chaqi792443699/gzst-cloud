package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.IArticleService;
import cn.gov.gzst.cms.entity.Article;
import cn.gov.gzst.cms.mapper.ArticleMapper;
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
* @title: 文章管理服务实现
* @description: 文章管理服务实现
* @author: jianliaoliang
* @date: 2018-05-02 09:35:29
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("articleService")
public class ArticleServiceImpl  extends CommonServiceImpl<ArticleMapper,Article> implements  IArticleService {

    @Override
    public Page<Article> selectList(Page<Article> page, @Param("ew") Wrapper<Article> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectList(page,wrapper));
        return page;
    }

    @Override
    public Page<Article> ArticleListBysiteId(Page<Article> page,@Param("ew") Wrapper<Article> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.ArticleListBysiteId(page,wrapper));
        return page;
    }
}