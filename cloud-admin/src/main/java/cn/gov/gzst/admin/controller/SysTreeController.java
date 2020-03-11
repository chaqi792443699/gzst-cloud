package cn.gov.gzst.admin.controller;


import cn.gov.gzst.admin.entity.SysTreeGroup;
import cn.gov.gzst.admin.service.ISysTreeGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.gov.gzst.admin.entity.SysTree;
import cn.gov.gzst.admin.service.ISysTreeService;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-06
 */
@Controller
@RequestMapping("tree")
public class SysTreeController extends BaseBeanController<SysTree> {
    @Autowired
    private ISysTreeService sysTreeService;

    @Autowired
    private ISysTreeGroupService sysTreeGroupService;

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
        EntityWrapper<SysTree> entityWrapper = new EntityWrapper<>(SysTree.class);
        entityWrapper.orderBy("code");
        entityWrapper.orderBy("parent_ids");
        //加入条件
        String keyword = request.getParameter("keyword");
        String gid = request.getParameter("gid");
        if (!StringUtils.isEmpty(gid) && !StringUtils.isEmpty(keyword)) {
            entityWrapper.eq("gid", gid).andNew().like("name", keyword).or().like("code", keyword);
        } else if (!StringUtils.isEmpty(gid)) {
            entityWrapper.eq("gid", gid);
        }
        pageBean = sysTreeService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,gid,name,code,parentId,parentIds,sort,createBy,createDate,updateBy,updateDate,delFlag,remarks");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获得应用程序配置
     *
     * @param id
     * @return
     */
    @GetMapping("{id}/get")
    @ResponseBody
    public SysTree find(@PathVariable("id") String id) {
        return sysTreeService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(SysTree entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(SysTree entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(SysTree entity, HttpServletRequest request,
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
                sysTreeService.insert(entity);
            } else {
                sysTreeService.insertOrUpdate(entity);
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
            sysTreeService.deleteById(id);
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
                                @RequestParam(value = "groupCode", defaultValue = "") String groupCode,
                                @RequestParam(value = "extCode", defaultValue = "") String extCode,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<SysTree> entityWrapper = new EntityWrapper<>(SysTree.class);
        entityWrapper.orderBy("code");
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
        String extId = request.getParameter("extId");
        if (!StringUtils.isEmpty(extId)) {
            entityWrapper.ne("id", extId);
        }
        if (!StringUtils.isEmpty(extCode)) {
            entityWrapper.ne("code", extCode);
        }
        String gid = request.getParameter("gid");
        // 若有code，以groupCode为主找到组id
        if (!StringUtils.isEmpty(groupCode)) {
            EntityWrapper<SysTreeGroup> wrapper = new EntityWrapper<>(SysTreeGroup.class);
            wrapper.eq("code",groupCode);
            SysTreeGroup treeGroup = this.sysTreeGroupService.selectOne(wrapper);
            if (treeGroup != null) {
                gid = treeGroup.getId();
            }
        }
        if (!StringUtils.isEmpty(gid) && !StringUtils.isEmpty(keyword)) {
            entityWrapper.andNew().eq("gid", gid).like("name", keyword).or().like("code", keyword);
        } else if (!StringUtils.isEmpty(gid)) {
            entityWrapper.andNew().eq("gid", gid);
        }
        List<SysTree> dataList = sysTreeService.selectList(entityWrapper);
        try {
            dataList = sysTreeService.formatTreeNodes(dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(SysTree.class, new String[]{"id", "gid", "name", "code", "parentId", "parentIds", "level", "parents", "sort", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 获取树节点展示值
     * @param code
     * @param groupCode
     * @param request
     * @param response
     */
    @GetMapping("nodes/value/get")
    @ResponseBody
    public String findNodeValue(@RequestParam(value = "code", defaultValue = "") String code,
                                @RequestParam(value = "groupCode", defaultValue = "") String groupCode,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        EntityWrapper<SysTree> entityWrapper = new EntityWrapper<>(SysTree.class);
        entityWrapper.eq("code",code);
        String gid = request.getParameter("gid");
        // 若有code，以groupCode为主找到组id
        if (!StringUtils.isEmpty(groupCode)) {
            EntityWrapper<SysTreeGroup> wrapper = new EntityWrapper<>(SysTreeGroup.class);
            wrapper.eq("code",groupCode);
            SysTreeGroup treeGroup = this.sysTreeGroupService.selectOne(wrapper);
            if (treeGroup != null) {
                gid = treeGroup.getId();
            }
        }
        entityWrapper.eq("gid", gid);
        SysTree tree = sysTreeService.selectOne(entityWrapper);
        String value = sysTreeService.getValue(tree);
        return value;
    }

    /**
     * 针对树组件的值回显
     * @param codes
     * @param groupCode
     * @param request
     * @param response
     * @return
     */
    @GetMapping("nodes/values/get")
    @ResponseBody
    public String findNodeValues(@RequestParam(value = "codes", defaultValue = "") String[] codes,
                                @RequestParam(value = "groupCode", defaultValue = "") String groupCode,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        if (codes == null) {
            return "";
        }
        String value = sysTreeService.getValues(groupCode,codes);
        return value;
    }

    /**
     * 根据分组编码查找该分组所有树
     * @param groupCode
     * @param request
     * @param response
     */
    @GetMapping("nodes/fetch")
    public void findTreeNodes(@RequestParam(value = "groupCode", defaultValue = "") String groupCode,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        List<SysTree> dataList = sysTreeService.findTrees(groupCode);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addIncludeFilter(SysTree.class, new String[]{"id", "gid", "name", "code", "parentId", "parentIds", "level", "parents", "sort","children", "hasChildren", "remarks"});
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(dataList, filter);
        StringUtils.printJson(response, content);
    }
}
