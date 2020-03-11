package cn.gov.gzst.sms.controller;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.sms.service.ISmsReplyLogService;
import cn.gov.gzst.sms.entity.SmsReplyLog;
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
 * @Title: 短信回复日志
 * @Description: 短信回复日志
 * @author jianliaoliang
 * @date 2017-10-10 16:23:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("replylog")
public class SmsReplyLogController extends BaseBeanController<SmsReplyLog> {

    @Autowired
    private ISmsReplyLogService smsReplyLogService;

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
        EntityWrapper<SmsReplyLog> entityWrapper = new EntityWrapper<SmsReplyLog>(entityClass);
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
        pageBean= smsReplyLogService.selectPage(pageBean,entityWrapper);
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter("id,phone,smsid,sendSmsid,content,replyDate,dealFlag,appId,tryNum,appName");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        JSON.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//设置日期格式
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response, content);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult create(SmsReplyLog entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult update(SmsReplyLog entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doSave(SmsReplyLog entity, HttpServletRequest request, HttpServletResponse response,
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
                smsReplyLogService.insert(entity);
            } else {
                smsReplyLogService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult delete(@PathVariable("id") String id) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            smsReplyLogService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return responseResult;
    }

    @RequestMapping(value = "retryReply", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseResult retryReply(@RequestParam(value = "ids", required = false) String[] ids) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("重发队列添加成功");
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            smsReplyLogService.retryReply(idList);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"重发队列添加失败");
        }
        return responseResult;
    }
}
