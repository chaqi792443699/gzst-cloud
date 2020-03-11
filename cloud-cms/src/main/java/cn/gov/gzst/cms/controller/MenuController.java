package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.Menu;
import cn.gov.gzst.cms.service.ICategoryService;
import cn.gov.gzst.cms.service.IMenuService;
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
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.controller
 * @title: cms_menu控制器
 * @description: cms_menu控制器
 * @author: wuzhengjun
 * @date: 2018-11-20 10:36:36
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("menu")
public class MenuController extends BaseBeanController<Menu> {

    @Autowired
    private IMenuService menuService;

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
    private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(entityClass);
        //加入条件
        pageBean= menuService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Menu entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Menu entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    /**
     * 获取菜单数据
     * @param id
     * @return
     */
    @GetMapping("{id}/get")
    public Menu find(@PathVariable("id") String id) {
        return menuService.selectById(id);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Menu entity, HttpServletRequest request, HttpServletResponse response,
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
                menuService.insert(entity);
            } else {
                menuService.insertOrUpdate(entity);
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
            if(menuService.selectCount(new EntityWrapper<Menu>().eq("parent_id",id))>0){
                responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败，请先删除该菜单下子菜单");
            }else {
                menuService.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/listBySiteId")
    private void selectList(
            @RequestParam("siteId") String siteId,HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(entityClass);
        entityWrapper.setTableAlias("t.");
        entityWrapper.eq("t.site_id",siteId);
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword);
        }
        entityWrapper.orderBy("sort");
        List<Menu> treeNodeList = menuService.selectTreeList(entityWrapper);
        List<VueTreeHelper.VueTreeNode> vueTreeNodes = VueTreeHelper.create().sort(treeNodeList,"id,name,alias,icon,description,type,position,blank,status,url,sort");
        String content = JSON.toJSONString(vueTreeNodes);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("{siteId}/listBySiteId")
    private void selectMenuList(
            @PathVariable("siteId") String siteId,HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(entityClass);
        entityWrapper.setTableAlias("t.");
        entityWrapper.eq("t.site_id",siteId);
        //加入条件
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword);
        }
        entityWrapper.orderBy("sort");
        List<Menu> treeNodeList = menuService.selectTreeList(entityWrapper);
        List<VueTreeHelper.VueTreeNode> vueTreeNodes = VueTreeHelper.create().sort(treeNodeList,"id,name,alias,icon,description,position,type,blank,status,url,sort");
        String content = JSON.toJSONString(vueTreeNodes);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("{id}/menuList")
    private void selectMenu(@PathVariable("id") String id,HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(entityClass);
        entityWrapper.setTableAlias("t.");
        entityWrapper.eq("t.parent_id",id);
        //加入条件
        entityWrapper.orderBy("sort");
        List<Menu> treeNodeList = menuService.selectTreeList(entityWrapper);
        String content = JSON.toJSONString(treeNodeList);
        StringUtils.printJson(response, content);
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
        EntityWrapper<Menu> entityWrapper = new EntityWrapper<>(Menu.class);
        entityWrapper.orderBy("parent_ids");
        entityWrapper.orderBy("sort");
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
        List<Menu> dataList = menuService.selectList(entityWrapper);
        try {
            dataList = menuService.formatNodes(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(Menu.class, new String[]{"id","name","alias","parentId","url",
                "parentIds", "level", "parents", "sort","siteId","type","status",
                "description","hasChildren"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }
}