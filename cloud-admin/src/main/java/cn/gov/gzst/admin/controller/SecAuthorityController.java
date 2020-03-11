package cn.gov.gzst.admin.controller;


import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.admin.service.ISecAuthorityService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Controller
@RequestMapping("sec-authority")
public class SecAuthorityController extends BaseBeanController<SecAuthority> {
    @Autowired
    private ISecAuthorityService secAuthorityService;

    /**
    * 查找列表
    * @param page
     * @param limit
    * @return
    */
    @GetMapping("list")
    public void ajaxList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
    HttpServletResponse response){
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<SecAuthority> entityWrapper = new EntityWrapper<>(SecAuthority.class);
        entityWrapper.orderBy("scene_id");
        String sceneId = request.getParameter("sceneId");
        String keywords = request.getParameter("keywords");
        if (!StringUtils.isEmpty(sceneId)) {
            entityWrapper.eq("scene_id",sceneId);
        }
        if (!StringUtils.isEmpty(keywords)){
                entityWrapper.or().like("name",keywords);
                entityWrapper.or().like("remark",keywords);
        }
        pageBean= secAuthorityService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,sceneId,remark");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response,content);
     }

    /**
     * 获得应用程序配置
     * @param id
     * @return
    */
    @GetMapping("{id}/get")
    @ResponseBody
    public SecAuthority find(@PathVariable("id") String id){
        return secAuthorityService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(SecAuthority entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(SecAuthority entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    public ResponseResult doSave(SecAuthority entity, HttpServletRequest request,
                HttpServletResponse response,BindingResult result) {
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
                    secAuthorityService.insert(entity);
                } else {
                    secAuthorityService.insertOrUpdate(entity);
                }
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
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
                secAuthorityService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }

    @PostMapping("{id}/updateResources")
    @ResponseBody
    public ResponseResult updateResources(@PathVariable("id") String id,String[] resourceIds, HttpServletRequest request,
                              HttpServletResponse response){
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("更新权限成功");
        boolean flag = secAuthorityService.updateResources(id,resourceIds);
        if (!flag) {
            responseResult.fail(999,"更新失败");
        }
        return responseResult;
    }

    @GetMapping("{roleId}/listAuthorities")
    public void listAuthorities(@PathVariable("roleId") String roleId,HttpServletRequest request,
                              HttpServletResponse response){
        List<SecAuthority> secAuthorities = secAuthorityService.listByRoleId(roleId);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,sceneId,remark");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(secAuthorities,filter);
        StringUtils.printJson(response,content);
    }
}
