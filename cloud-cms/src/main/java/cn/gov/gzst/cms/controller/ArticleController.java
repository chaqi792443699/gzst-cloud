package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.service.ICategoryService;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.filter.xss.JsonUnXssFilter;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.cms.service.IArticleService;
import cn.gov.gzst.cms.entity.Article;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.controller
 * @title: 文章管理控制器
 * @description: 文章管理控制器
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:29
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("article")
public class ArticleController extends BaseBeanController<Article> {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICategoryService categoryService;


    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
    private void list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response,@RequestParam(value = "back",defaultValue = "false") Boolean back,
                      @RequestParam(value = "thumb",defaultValue = "false") Boolean thumb) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=6;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Article> entityWrapper = new EntityWrapper<Article>(entityClass);
        //加入条件
        //栏目id
        String cid=request.getParameter("cid");
        //栏目标签
        String catTag=request.getParameter("cat_tag");
        String siteId = request.getParameter("siteId");
        if (!StringUtils.isEmpty(catTag)){
            Category category=categoryService.selectOne(new EntityWrapper<Category>().eq("alias",catTag).eq("site_id",siteId));
            if (category!=null){
                cid = category.getId();
            }
        }
        if (!StringUtils.isEmpty(cid)) {
            entityWrapper.eq("cid", cid);
        }
        //标题
        String title=request.getParameter("title");
        if (!StringUtils.isEmpty(title)){
            entityWrapper.like("title",title);
        }
        //是否只获取缩略图
/*        if(thumb){
            entityWrapper.isNotNull("thumb");
        }*/
        //排序
        //排序方式
        String orderBy=request.getParameter("order_by");
        entityWrapper.orderBy("dateline",false);
/*        if (!StringUtils.isEmpty(orderBy)) {
            entityWrapper.orderBy(orderBy);
        }else{
            if (back) {
                entityWrapper.orderBy("dateline", false);
            }else{
                entityWrapper.orderBy("listorder", false);
            }
        }*/
        if (!back) {
            entityWrapper.eq("ifShow", "1");
        }
        //JSON返回处理
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        String content = "";
        if (back){
            pageBean= articleService.selectPage(pageBean,entityWrapper);
            content = JSON.toJSONString(pageBean,jsonUnFilter);
        }else{
            pageBean= articleService.selectPage(pageBean,entityWrapper);
            PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,cid,title,keywords,description,thumb,author,source,dateline,content");
            SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
            content = JSON.toJSONString(pageBean,filter);
        }
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "articleListByCid",method = {RequestMethod.GET,RequestMethod.POST})
    public void articleList(@RequestParam("page") Integer page,@RequestParam("limit") Integer limit,
                            HttpServletResponse response,HttpServletRequest request){
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=6;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Article> entityWrapper = new EntityWrapper<Article>(entityClass);
        String cid = request.getParameter("cid");
        entityWrapper.eq("cid",cid);
        entityWrapper.orderBy("dateline",false);
        pageBean =  articleService.selectList(pageBean,entityWrapper);
        //JSON返回处理
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        String  content = JSON.toJSONString(pageBean,jsonUnFilter);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Article entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Article entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Article entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("保存成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR,errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败");
            }
        }
        try {
            if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                entity.setDelFlag("1");
                articleService.insert(entity);
            } else {
                articleService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @GetMapping("{id}/delete")
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            articleService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    @GetMapping("{id}/info")
    public ResponseResult info(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        try {
            Article article=articleService.selectById(id);
            responseResult.putObject(article,"id,cid,title,keywords,description,content,thumb,author,source,dateline");
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    @GetMapping("{id}/articleInfoByCid")
    public ResponseResult articleInfo(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        try {
            Article article=articleService.selectOne(new EntityWrapper<Article>().eq("cid",id));
            responseResult.putObject(article,"id,cid,title,keywords,description,content,thumb,author,source,dateline");
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 根据站点id获取文章列表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("{siteId}/list")
    private void selectList(
            @PathVariable("siteId") String siteId,
            @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
            HttpServletResponse response,@RequestParam(value = "back",defaultValue = "false") Boolean back,
            @RequestParam(value = "thumb",defaultValue = "false") Boolean thumb) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Article> entityWrapper = new EntityWrapper<Article>(entityClass);
        entityWrapper.eq("site_id",siteId);
        //加入条件
        //栏目
        String cid=request.getParameter("cid");
        if (!StringUtils.isEmpty(cid)) {
            entityWrapper.eq("cid", cid);
        }
        //获取栏目
        String catTag=request.getParameter("cat_tag");
        if (!StringUtils.isEmpty(catTag)){
            Category category=categoryService.selectOne(new EntityWrapper<Category>().eq("alias",catTag));
            if (category!=null){
                cid = category.getId();
            }
        }
        //标题
        String title=request.getParameter("title");
        if (!StringUtils.isEmpty(title)){
            entityWrapper.like("title",title);
        }
        //是否只获取缩略图
        if(thumb){
            entityWrapper.isNotNull("thumb");
        }
        //排序
        //排序方式
        String orderBy=request.getParameter("order_by");
        if (!StringUtils.isEmpty(orderBy)) {
            entityWrapper.orderBy(orderBy);
        }else{
            if (back) {
                entityWrapper.orderBy("dateline", false);
            }else{
                entityWrapper.orderBy("listorder", false);
            }
        }
        if (!back) {
            entityWrapper.eq("ifShow", "1");
        }
        //JSON返回处理
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        String content = "";
        if (back){
            pageBean= articleService.ArticleListBysiteId(pageBean,entityWrapper);
            content = JSON.toJSONString(pageBean,jsonUnFilter);
        }else{
            pageBean= articleService.ArticleListBysiteId(pageBean,entityWrapper);
            PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,cid,title,keywords,description,thumb,author,source,dateline");
            SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
            content = JSON.toJSONString(pageBean,filter);
        }
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("article/tags")
    private  List<Map<String,Object>> articleListByTag(
            @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=6;
        }
        Page pageBean = new Page(page,limit);
        String tags = request.getParameter("tags");
        // String tags="newsInformation,partyConstruction,culturalConstruction,notice";
        String tag[] = tags.split(",");
        List<Map<String,Object>> dataList=new ArrayList<>();
        Map<String,Object> categoryMap = null;
        for(String tg:tag){
            //获取栏目
            if (!StringUtils.isEmpty(tg)){
                Category category=categoryService.selectOne(new EntityWrapper<Category>().eq("alias",tg));
                categoryMap = JSON.parseObject(JSON.toJSONString(category),Map.class);
                if (category!=null){
                    EntityWrapper<Article> entityWrapper = new EntityWrapper<Article>(entityClass);
                    String cid = category.getId();
                    entityWrapper.eq("cid",cid);
                    entityWrapper.orderBy("dateline",false);
                    // pageBean = articleService.selectList(pageBean,entityWrapper);
                    pageBean =  articleService.selectPage(pageBean,entityWrapper);
                    List<Article> list = pageBean.getRecords();
                    categoryMap.put("articleList",list);
                    dataList.add(categoryMap);
                }
            }
        }
        return dataList;
    }
}