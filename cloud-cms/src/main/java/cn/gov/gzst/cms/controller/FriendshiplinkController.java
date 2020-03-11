package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.cms.service.IFriendshiplinkService;
import cn.gov.gzst.cms.entity.Friendshiplink;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.mybatisplus.plugins.Page;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
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
 * @title: cms_friendshiplink控制器
 * @description: cms_friendshiplink控制器
 * @author: wuzhengjun
 * @date: 2018-11-16 11:12:39
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("friendshiplink")
public class FriendshiplinkController extends BaseBeanController<Friendshiplink> {

    @Autowired
    private IFriendshiplinkService friendshiplinkService;


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
        //友情链接列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Friendshiplink> entityWrapper = new EntityWrapper<Friendshiplink>(entityClass);
        //加入条件
        pageBean= friendshiplinkService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(Friendshiplink entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Friendshiplink entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Friendshiplink entity, HttpServletRequest request, HttpServletResponse response,
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
                friendshiplinkService.insert(entity);
            } else {
                friendshiplinkService.insertOrUpdate(entity);
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
            friendshiplinkService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    /**
     * 通过获取栏目的子栏目信息
     *
     * @param siteId
     * @return
     */
    @GetMapping("{siteId}/linkList")
    public void son(@PathVariable("siteId") String siteId,@RequestParam("page") Integer page,
                              @RequestParam("limit") Integer limit,
                              HttpServletResponse response) {
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page pageBean = new Page(page,limit);
        EntityWrapper<Friendshiplink> entityWrapper = new EntityWrapper<Friendshiplink>(entityClass);
        entityWrapper.eq("site_id",siteId);
        //加入条件
        pageBean= friendshiplinkService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }
}