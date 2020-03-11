package cn.gov.gzst.email.controller;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.service.ISendLogService;
import cn.gov.gzst.email.entity.SendLog;
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
 * @package cn.gov.gzst.email.controller
 * @title: 发送日志控制器
 * @description: 发送日志控制器
 * @author: jianliaoliang
 * @date: 2018-04-24 11:24:16
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@RestController
@RequestMapping("sendlog")
public class SendLogController extends BaseBeanController<SendLog> {

    @Autowired
    private ISendLogService sendLogService;


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
        EntityWrapper<SendLog> entityWrapper = new EntityWrapper<SendLog>(entityClass);
        //加入条件
        entityWrapper.orderBy("responseDate",false);
        //所属应用
        String appId=request.getParameter("appId");
        if (!StringUtils.isEmpty(appId)){
            entityWrapper.eq("appId",appId);
        }
        //手机号码
        String phone=request.getParameter("phone");
        if (!StringUtils.isEmpty(phone)){
            entityWrapper.eq("phone",phone);
        }
        //发送状态
        String status=request.getParameter("status");
        if (!StringUtils.isEmpty(status)){
            entityWrapper.eq("status",status);
        }
        pageBean= sendLogService.selectPage(pageBean,entityWrapper);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    @PostMapping("create")
    public ResponseResult create(SendLog entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public ResponseResult update(SendLog entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public ResponseResult doSave(SendLog entity, HttpServletRequest request, HttpServletResponse response,
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
                sendLogService.insert(entity);
            } else {
                sendLogService.insertOrUpdate(entity);
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
            sendLogService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    @RequestMapping(value = "retrySend", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseResult retrySend(@RequestParam(value = "ids", required = false) String[] ids) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("重发队列添加成功");
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            sendLogService.retrySend(idList);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"重发队列添加失败");
        }
        return responseResult;
    }
}