package cn.gov.gzst.admin.controller;


import cn.gov.gzst.admin.entity.SecResource;
import cn.gov.gzst.admin.service.ISecResourceService;
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
 * 资源表 前端控制器
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Controller
@RequestMapping("sec-resource")
public class SecResourceController extends BaseBeanController<SecResource> {
    @Autowired
    private ISecResourceService secResourceService;


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
        EntityWrapper<SecResource> entityWrapper = new EntityWrapper<>(SecResource.class);
        entityWrapper.orderBy("name");
        entityWrapper.eq("1","1");
        String keywords = request.getParameter("keywords");
        String type = request.getParameter("type");
        String sceneId = request.getParameter("sceneId");
        if (!StringUtils.isEmpty(type)) {
            entityWrapper.eq("type",type);
        }
        if (!StringUtils.isEmpty(sceneId)) {
            entityWrapper.eq("sceneId",sceneId);
        }
        if (!StringUtils.isEmpty(keywords)){
                entityWrapper.andNew().like("name",keywords);
                entityWrapper.or().like("source",keywords);
        }
        pageBean= secResourceService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,source,type,sceneId");
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
    public SecResource find(@PathVariable("id") String id){
        return secResourceService.selectById(id);
    }


    //创建
    @PostMapping("create")
    @ResponseBody
    public ResponseResult create(SecResource entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
     }

    //修改
    @PostMapping("{id}/update")
    @ResponseBody
    public ResponseResult update(SecResource entity, BindingResult result,
                HttpServletRequest request, HttpServletResponse response) {
            return doSave(entity, request, response, result);
    }

     //保存
    @PostMapping("/save")
    @ResponseBody
    public ResponseResult doSave(SecResource entity, HttpServletRequest request,
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
                    secResourceService.insert(entity);
                } else {
                    secResourceService.insertOrUpdate(entity);
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
                secResourceService.deleteById(id);
           } catch (Exception e) {
               e.printStackTrace();
               responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
           }
           return responseResult;
    }

    @GetMapping("{authorityId}/listResources")
    public void listResources(@PathVariable("authorityId") String authorityId,HttpServletRequest request,
                              HttpServletResponse response){
        List<SecResource> resources = secResourceService.listByAuthorityId(authorityId);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,name,source");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(resources,filter);
        StringUtils.printJson(response,content);
    }
}
