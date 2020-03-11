package cn.gov.gzst.admin.controller;


import cn.gov.gzst.admin.entity.Route;
import cn.gov.gzst.admin.entity.SysMenu;
import cn.gov.gzst.admin.entity.SysScene;
import cn.gov.gzst.admin.service.ISysSceneService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.admin.entity.SysMenu;
import cn.gov.gzst.admin.service.ISysMenuService;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import cn.gov.gzst.common.common.controller.BaseBeanController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-16
 */
@Controller
@RequestMapping("menu")
public class SysMenuController extends BaseBeanController<SysMenu> {
    @Autowired
    private ISysMenuService sysMenuService;

    @Autowired
    private ISysSceneService sysSceneService;
    /**
     * 查找列表
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("list")
    public void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                         HttpServletResponse response) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<SysMenu> entityWrapper = new EntityWrapper<>(SysMenu.class);
        entityWrapper.orderBy("sort");
        entityWrapper.orderBy("parent_ids");
        //加入条件
        String keyword = request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)) {
            entityWrapper.like("name", keyword).or().like("remarks", keyword);
        }
        pageBean = sysMenuService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(SysMenu.class, new String[]{"id","name","title","sourceId","path","component","icon","redirect","hidden","requireAuth","cacheable","sceneId","parentId", "parentIds", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获得菜单数据
     *
     * @param id
     * @return
     */
    @GetMapping("{id}/get")
    @ResponseBody
    public SysMenu find(@PathVariable("id") String id) {
        return sysMenuService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(SysMenu entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(SysMenu entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(SysMenu entity, HttpServletRequest request,
                                 HttpServletResponse response, BindingResult result) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("保存成功");
        if (hasError(entity, result)) {
            // 错误提示
            String errorMsg = errorMsg(result);
            if (!StringUtils.isEmpty(errorMsg)) {
                responseResult.fail(ResponseError.NORMAL_ERROR, errorMsg);
            } else {
                responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败");
            }
        }
        try {
            if (ObjectUtils.isNullOrEmpty(entity.getId())) {
                sysMenuService.insert(entity);
            } else {
                sysMenuService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!原因:" + e.getMessage());
        }
        return responseResult;
    }

    //删除
    @GetMapping("{id}/delete")
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            sysMenuService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }

    /**
     * 查找列表
     *
     * @param id
     * @return
     */
    @GetMapping("nodes/get")
    public void findParentNodes(@RequestParam(value = "id", defaultValue = "") String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<SysMenu> entityWrapper = new EntityWrapper<>(SysMenu.class);
        entityWrapper.orderBy("parent_ids");
        entityWrapper.orderBy("sort");
        String keyword = request.getParameter("keyword");
        if (StringUtils.isEmpty(id)) {
            if (StringUtils.isEmpty(keyword)) {
                entityWrapper.andNew().isNull("parent_id").or().eq("parent_id", "");
            }
        } else {
            entityWrapper.eq("parent_id", id);
        }
        if (!StringUtils.isEmpty(keyword)) {
            entityWrapper.like("name",keyword);
        }
        String extId = request.getParameter("extId");
        if (!StringUtils.isEmpty(extId)) {
            entityWrapper.ne("id", extId);
        }
        List<SysMenu> dataList = sysMenuService.selectList(entityWrapper);
        try {
            dataList = sysMenuService.formatNodes(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(SysMenu.class, new String[]{"id","name","title","sourceId","path","component","icon","redirect","hidden","requireAuth","cacheable","sceneId","parentId", "parentIds", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获取路由
     * @param module
     * @param request
     * @param response
     */
    @GetMapping("route/list")
    public void findRoutes(@RequestParam(value = "module", defaultValue = "") String module,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<SysScene> wrapper = new EntityWrapper<>(SysScene.class);
        wrapper.eq("code",module);
        SysScene sysScene = this.sysSceneService.selectOne(wrapper);
        List<Route> routeList = this.sysMenuService.findRoutes(sysScene);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(SysMenu.class, new String[]{"id","name","title","sourceId","path","component","icon","redirect","hidden","requireAuth","cacheable","sceneId","parentId", "parentIds", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(routeList, filter);
        StringUtils.printJson(response, content);
    }

}
