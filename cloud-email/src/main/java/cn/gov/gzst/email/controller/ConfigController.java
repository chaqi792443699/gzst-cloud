package cn.gov.gzst.email.controller;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.common.utils.EmailResult;
import cn.gov.gzst.email.common.utils.EmailSender;
import cn.gov.gzst.email.service.IConfigService;
import cn.gov.gzst.email.entity.Config;
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

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.controller
 * @title: 邮件配置控制器
 * @description: 邮件配置控制器
 * @author: jianliaoliang
 * @date: 2018-04-24 11:16:31
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("config")
public class ConfigController extends BaseBeanController<Config> {

    @Autowired
    private IConfigService configService;

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
        EntityWrapper<Config> entityWrapper = new EntityWrapper<Config>(entityClass);
        //加入条件
        String name=request.getParameter("name");
        if (!StringUtils.isEmpty(name)){
            entityWrapper.like("name",name);
        }
        pageBean= configService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("test")
    public ResponseResult test(Config config, @RequestParam("receive_user") String receiveUser,
                                 HttpServletRequest request, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("测试发送成功");
        try{
            EmailResult emailResult = EmailSender.newEmailSender().send(config.toEmailConfig(),receiveUser,
                    config.getName()+"配置测试！", config.getName()+"配置正常，可以使用！");
            if (!emailResult.isSuccess()){
                responseResult.fail(ResponseError.NORMAL_ERROR,"配置有问题，请检查配置！");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"配置有问题，请检查配置！");
        }
        return responseResult;
    }

    @PostMapping("create")
    public ResponseResult create(Config entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(Config entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(Config entity, HttpServletRequest request, HttpServletResponse response,
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
                configService.insert(entity);
            } else {
                configService.insertOrUpdate(entity);
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
            configService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

}