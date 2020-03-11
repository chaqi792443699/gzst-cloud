package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.SiteRoleUser;
import cn.gov.gzst.cms.entity.Slide;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.cms.service.ISiteService;
import cn.gov.gzst.cms.entity.Site;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @title: cms_site控制器
 * @description: cms_site控制器
 * @author: 吴正军
 * @date: 2018-10-29 17:32:14
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("site")
public class SiteController extends BaseBeanController<Site> {

    @Autowired
    private ISiteService siteService;

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
        EntityWrapper<Site> entityWrapper = new EntityWrapper<Site>(entityClass);
        String keyword=request.getParameter("keyword");
        if (!StringUtils.isEmpty(keyword)){
            entityWrapper.like("name",keyword);
        }
        //加入条件
        pageBean= siteService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Site entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Site entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Site entity, HttpServletRequest request, HttpServletResponse response,
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
                siteService.insert(entity);
            } else {
                siteService.insertOrUpdate(entity);
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
            siteService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }
    /**
     * 通过角色查站点
     * parem
     * **/
    @GetMapping("{userId}/siteList")
    public void selectListBySiteId(
                                   @PathVariable("userId") String userId,
                                   HttpServletResponse response,
                                   HttpServletRequest request){
        EntityWrapper<Site> entityWrapper = new EntityWrapper<Site>(entityClass);
        entityWrapper.eq("user_id",userId);
        //加入条件
        List<Site> siteList = siteService.selectList(entityWrapper);
        String content = JSON.toJSONString(siteList);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "siteList", method = { RequestMethod.GET, RequestMethod.POST })
    private void s(
            @RequestParam("page") Integer page, @RequestParam("limit") Integer limit, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Site> entityWrapper = new EntityWrapper<Site>(entityClass);
        //加入条件
        pageBean= siteService.selectList(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

}