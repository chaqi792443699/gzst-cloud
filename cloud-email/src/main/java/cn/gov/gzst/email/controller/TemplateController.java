package cn.gov.gzst.email.controller;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.filter.xss.JsonUnXssFilter;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.service.ITemplateService;
import cn.gov.gzst.email.entity.Template;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.controller
 * @title: 邮件模板控制器
 * @description: 邮件模板控制器
 * @author: jianliaoliang
 * @date: 2018-04-24 11:19:30
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("template")
public class TemplateController extends BaseBeanController<Template> {

    @Autowired
    private ITemplateService templateService;


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
        EntityWrapper<Template> entityWrapper = new EntityWrapper<Template>(entityClass);
        //加入条件
        //名称
        String name=request.getParameter("name");
        if (!StringUtils.isEmpty(name)){
            entityWrapper.like("name",name);
        }
        //编码
        String code=request.getParameter("code");
        if (!StringUtils.isEmpty(code)){
            entityWrapper.eq("code",code);
        }
        //所属应用
        String appId=request.getParameter("appId");
        if (!StringUtils.isEmpty(appId)){
            entityWrapper.eq("appId",appId);
        }
        //签名配置
        String configId=request.getParameter("configId");
        if (!StringUtils.isEmpty(configId)){
            entityWrapper.eq("configId",configId);
        }
        pageBean= templateService.selectPage(pageBean,entityWrapper);
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        String content = JSON.toJSONString(pageBean,jsonUnFilter);
        content=StringEscapeUtils.unescapeHtml(content);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Template entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Template entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Template entity, HttpServletRequest request, HttpServletResponse response,
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
                String templateCode=StringUtils.randomString(10);
                entity.setCode(templateCode);
                templateService.insert(entity);
            } else {
                templateService.insertOrUpdate(entity);
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
            templateService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

}