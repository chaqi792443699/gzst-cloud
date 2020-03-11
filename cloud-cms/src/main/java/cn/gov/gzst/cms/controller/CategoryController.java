package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.Article;
import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.service.IArticleService;
import cn.gov.gzst.cms.service.ICategoryService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.helper.VueTreeHelper;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 栏目/分类管理
 */

@RestController
@RequestMapping("category")
public class CategoryController extends BaseBeanController<Category> {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IArticleService articleService;
    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
    private void ajaxList(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<Category> entityWrapper = new EntityWrapper<Category>(entityClass);
        entityWrapper.setTableAlias("t.");
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword);
        }
        List<Category> treeNodeList = categoryService.selectTreeList(entityWrapper);
        List<VueTreeHelper.VueTreeNode> vueTreeNodes = VueTreeHelper.create().sort(treeNodeList,"id,name,mid,type,alias,thumb,description,count,listorder,parentId,parentIds,remarks");
        String content = JSON.toJSONString(vueTreeNodes);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Category entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Category entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Category entity, HttpServletRequest request, HttpServletResponse response,
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
                categoryService.insert(entity);
            } else {
                categoryService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * 获取分类数据
     * @param id
     * @return
     */
    @GetMapping("{id}/get")
    public Category find(@PathVariable("id") String id) {
        return categoryService.selectById(id);
    }

    @GetMapping("{id}/delete")
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            //检查栏目中的文章
            if(articleService.selectCount(new EntityWrapper<Article>().eq("cid",id))>0)
            {
                responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败，请先删除该栏目下面的文章");
            }else{
                categoryService.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    /**
     * 通过tag获取栏目信息
     *
     * @param tag
     * @return
     */
    @GetMapping("{tag}/info")
    public ResponseResult info(@PathVariable("tag") String tag) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        try {
            Category category = categoryService.selectOne(new EntityWrapper<Category>().eq("alias",tag));
            if(category!=null){
                responseResult.putObject(category,"id,name,content,thumb,description");
            }else{
                responseResult.fail(ResponseError.NORMAL_ERROR,"tag不可用");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 通过获取栏目的子栏目信息
     *
     * @param cid
     * @return
     */
    @GetMapping("{cid}/son")
    public ResponseResult son(@PathVariable("cid") String cid) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("子栏目获取成功");
        try {
            List<Category> categoryList = categoryService.selectList(new EntityWrapper<Category>().eq("parent_id",cid));
            responseResult.put("data",categoryList);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 通过获取tag的子栏目信息
     *
     * @param tag
     * @return
     */
    @GetMapping("{tag}/tagson")
    public ResponseResult tagson(@PathVariable("tag") String tag) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("子栏目获取成功");
        try {
            Category category = categoryService.selectOne(new EntityWrapper<Category>().eq("alias",tag));
            if(category!=null) {
                List<Category> categoryList = categoryService.selectList(new EntityWrapper<Category>().eq("parent_id", category.getId()));
                responseResult.put("data", categoryList);
            }else{
                responseResult.fail(ResponseError.NORMAL_ERROR,"没有对应tag数据，请添加");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 根据站点获取栏目数据列表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("{siteId}/listBySiteId")
    private void selectList(@PathVariable("siteId") String siteId,HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<Category> entityWrapper = new EntityWrapper<Category>(entityClass);
        // entityWrapper.setTableAlias("t.");
        entityWrapper.eq("site_id",siteId);
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword);
        }

        // List<Category> treeNodeList = categoryService.selectTreeList(entityWrapper);
        List<Category>  categoryList = categoryService.selectList(entityWrapper);
        List<VueTreeHelper.VueTreeNode> vueTreeNodes = VueTreeHelper.create().sort(categoryList);
        String content = JSON.toJSONString(vueTreeNodes);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据id判断栏目子集或者父级兄弟级
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("{id}/categoryList")
    private List<Map<String,Object>> selectMenu(@PathVariable("id") String id,HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        List<Map<String,Object>> dataList = new ArrayList<>();
        Map<String,Object> categoryMap =null;
        List<Category> list = null;
        Category category = categoryService.selectById(id);
        EntityWrapper<Category> entityWrapper = new EntityWrapper<Category>();
        if(category!=null){
            if(category.getParentId()!=null){
                Category parentCategory = categoryService.selectById(category.getParentId());
                categoryMap = JSON.parseObject(JSON.toJSONString(parentCategory),Map.class);
                entityWrapper.eq("parent_id",category.getParentId());
                entityWrapper.orderBy("listorder",true);
                list = categoryService.selectList(entityWrapper);
                categoryMap.put("list",list);
                dataList.add(categoryMap);
            }else {
                categoryMap = JSON.parseObject(JSON.toJSONString(category),Map.class);
                entityWrapper.eq("parent_id",category.getId());
                list = categoryService.selectList(entityWrapper);
                categoryMap.put("list",list);
                dataList.add(categoryMap);
            }
        }
        return dataList;
    }


    /**
     * 通过栏目id获取栏目信息
     *
     * @param id
     * @return
     */
    @GetMapping("{id}/categoryContent")
    public ResponseResult categoryContent(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取成功");
        try {
            Category category = categoryService.selectOne(new EntityWrapper<Category>().eq("id",id));
            responseResult.putObject(category,"id,name,thumb,description,content");
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    /**
     * 树列表
     *
     * @param id
     * @return
     */
    @GetMapping("nodes/get")
    public void findParentNodes(@RequestParam(value = "id", defaultValue = "") String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<Category> entityWrapper = new EntityWrapper<>(Category.class);
        entityWrapper.orderBy("parent_ids");
        entityWrapper.orderBy("listorder");
        String category = request.getParameter("category");
        String keyword = request.getParameter("keyword");
        if (!StringUtils.isEmpty(category)) {
            entityWrapper.eq("category",category);
        }
        if (StringUtils.isEmpty(id)) {
            if (StringUtils.isEmpty(keyword)) {
                entityWrapper.andNew().isNull("parent_id").or().eq("parent_id", "");
            }
        } else {
            entityWrapper.eq("parent_id", id);
        }
        String extId = request.getParameter("extId");
        if (!StringUtils.isEmpty(extId)) {
            entityWrapper.ne("id", extId);
        }
        if (!StringUtils.isEmpty(keyword)) {
            entityWrapper.like("name",keyword);
        }
        List<Category> dataList = categoryService.selectList(entityWrapper);
        try {
            dataList = categoryService.formatNodes(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(Category.class, new String[]{"id","name","userPost","parentId","mid",
                "parentIds", "level", "parents", "listorder","siteId","type","alias",
                "description","seoTitle","seoKeywords","seoDescription","indexTpl","listTpl","showTpl",
                "hasChildren", "content","remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }
}