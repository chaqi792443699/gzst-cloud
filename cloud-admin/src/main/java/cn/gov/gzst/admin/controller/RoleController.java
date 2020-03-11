package cn.gov.gzst.admin.controller;


import cn.gov.gzst.admin.common.bean.ResponseError;
import cn.gov.gzst.admin.entity.Role;
import cn.gov.gzst.admin.service.IRoleService;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController extends BaseBeanController<Role> {

    @Autowired
    private IRoleService roleService;

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Permission(value = "ROLE_LIST")
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    private void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 20;
        }
        Page pageBean = new Page(page, limit);
        EntityWrapper<Role> entityWrapper = new EntityWrapper<Role>(entityClass);
        entityWrapper.orderBy("scene_id");
        entityWrapper.orderBy("sort", false);
        //加入条件
        String sceneId = request.getParameter("sceneId");
        if (!StringUtils.isEmpty(sceneId)) {
            entityWrapper.eq("scene_id", sceneId);
        }
        String code = request.getParameter("code");
        if (!StringUtils.isEmpty(code)) {
            entityWrapper.like("code", code);
        }
        String name = request.getParameter("name");
        if (!StringUtils.isEmpty(name)) {
            entityWrapper.like("name", name);
        }
        pageBean = roleService.selectPage(pageBean, entityWrapper);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,name,code,remarks,type,sceneId,enabled,sort");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean, filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "all/list", method = {RequestMethod.GET})
    @ResponseBody
    private List<Role> fetchRoles(HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        EntityWrapper<Role> entityWrapper = new EntityWrapper<Role>(entityClass);
        entityWrapper.orderBy("createDate", false);
        List<Role> roles = roleService.selectList(entityWrapper);
        return roles;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(Role entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(Role entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doSave(Role entity, HttpServletRequest request, HttpServletResponse response,
                                 BindingResult result) {
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
                roleService.insert(entity);
            } else {
                roleService.insertOrUpdate(entity);
                roleService.updateLinks(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            roleService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "删除失败");
        }
        return responseResult;
    }

    /**
     * 通过用户ID获得角色
     *
     * @param uid
     * @return
     */
    @PostMapping(value = "{uid}/findListByUserId")
    public List<Role> findListByUserId(@PathVariable("uid") String uid) {
        try {
            return roleService.findListByUserId(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/cmsRole")
    public ResponseResult selectCmsRole(HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("获取cms角色成功");
        try {
            List<Role> roleList = roleService.selectList(new EntityWrapper<Role>().eq("is_cms", "1"));
            String content = JSON.toJSONString(roleList);
            StringUtils.printJson(response, content);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR, "获取失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @PostMapping("{id}/updateAuthorities")
    @ResponseBody
    public ResponseResult updateAuthorities(@PathVariable("id") String id, String[] authorityIds, HttpServletRequest request,
                                            HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("更新角色成功");
        boolean flag = roleService.updateAuthorities(id, authorityIds);
        if (!flag) {
            responseResult.fail(999, "更新失败");
        }
        return responseResult;
    }

    @GetMapping("{sceneId}/{userId}/list")
    public void listRolesBySceneAndUser(@PathVariable("sceneId") String sceneId, @PathVariable("userId") String userId,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        List<Role> roles = roleService.findListBySceneAndUser(sceneId, userId);
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter("id,name,code,remarks,type,sceneId,enabled,sort");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(roles, filter);
        StringUtils.printJson(response, content);
    }

    @GetMapping("{userId}/{sceneId}/{roleId}/assign")
    @ResponseBody
    public ResponseResult assignRole(@PathVariable("userId") String userId, @PathVariable("sceneId") String sceneId, @PathVariable("roleId") String roleId,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("分配角色成功");
        Boolean flag = roleService.assignRole(userId, sceneId, roleId);
        if (!flag) {
            responseResult.fail(999, "分配角色失败");
        }
        return responseResult;
    }

    @GetMapping("{userId}/{sceneId}/{roleId}/revoke")
    @ResponseBody
    public ResponseResult revokeRole(@PathVariable("userId") String userId, @PathVariable("sceneId") String sceneId, @PathVariable("roleId") String roleId,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("回收角色成功");
        Boolean flag = roleService.revokeRole(userId, sceneId, roleId);
        if (!flag) {
            responseResult.fail(999, "回收失败");
        }
        return responseResult;
    }
}