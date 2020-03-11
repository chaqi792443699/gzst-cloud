package cn.gov.gzst.cms.controller;

import cn.gov.gzst.cms.entity.SiteRoleUser;
import cn.gov.gzst.cms.service.ISiteRoleUserService;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
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
 * @title: cms_site_role_user控制器
 * @description: cms_site_role_user控制器
 * @author: wuzhengjun
 * @date: 2018-11-23 09:15:43
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("siteroleuser")
public class SiteRoleUserController extends BaseBeanController<SiteRoleUser> {

    @Autowired
    private ISiteRoleUserService siteRoleUserService;


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
        EntityWrapper<SiteRoleUser> entityWrapper = new EntityWrapper<SiteRoleUser>(entityClass);
        //加入条件
        pageBean= siteRoleUserService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(SiteRoleUser entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(SiteRoleUser entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(SiteRoleUser entity, HttpServletRequest request, HttpServletResponse response,
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
            EntityWrapper<SiteRoleUser> entityWrapper = new EntityWrapper<SiteRoleUser>(entityClass);
            entityWrapper.eq("site_id",entity.getSiteId());
            entityWrapper.eq("user_id",entity.getUserId());
            List<SiteRoleUser> list = siteRoleUserService.selectList(entityWrapper);
            if(list.size()>0){
                siteRoleUserService.delete(entityWrapper);
                String roleId = entity.getRoleId();
                if(!StringUtils.isEmpty(roleId)){
                    String rids[] = roleId.split(",");
                    for(String rid:rids){
                        SiteRoleUser siteRoleUser = new SiteRoleUser();
                        siteRoleUser.setRoleId(rid);
                        siteRoleUser.setId(StringUtils.randomUUID());
                        siteRoleUser.setSiteId(entity.getSiteId());
                        siteRoleUser.setUserId(entity.getUserId());
                        siteRoleUserService.insert(siteRoleUser);
                    }
                }
            }else {
                String roleId = entity.getRoleId();
                if(!StringUtils.isEmpty(roleId)){
                    String rids[] = roleId.split(",");
                    for(String rid:rids){
                        SiteRoleUser siteRoleUser = new SiteRoleUser();
                        siteRoleUser.setRoleId(rid);
                        siteRoleUser.setId(StringUtils.randomUUID());
                        siteRoleUser.setSiteId(entity.getSiteId());
                        siteRoleUser.setUserId(entity.getUserId());
                        siteRoleUserService.insert(siteRoleUser);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @GetMapping("delete")
    public ResponseResult delete(SiteRoleUser entity) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        EntityWrapper<SiteRoleUser> entityWrapper = new EntityWrapper<SiteRoleUser>(entityClass);
        entityWrapper.eq("site_id",entity.getSiteId());
        entityWrapper.eq("user_id",entity.getUserId());
        try {
            siteRoleUserService.deleteBySiteAndUser(entityWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    @RequestMapping(value = "{siteId}/list", method = { RequestMethod.GET, RequestMethod.POST })
    private void s(
            @PathVariable("siteId") String siteId,
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
        EntityWrapper<SiteRoleUser> entityWrapper = new EntityWrapper<SiteRoleUser>(entityClass);
        entityWrapper.eq("site_id",siteId);
        //加入条件
        pageBean= siteRoleUserService.selectList(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

}