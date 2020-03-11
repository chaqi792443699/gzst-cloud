package cn.gov.gzst.activiti.controller;

import cn.gov.gzst.activiti.service.IProcessService;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.utils.ComplexPropertyPreFilter;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti.controller
 * @title:
 * @description: 流程定义相关
 * @author: jianliaoliang
 * @date: 2018/4/19 16:47
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@Controller
@RequestMapping(value = "process")
public class ProcessController extends BaseController {

    @Autowired
    private IProcessService processService;


    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     * 流程定义列表
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST })
    public void modelList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "category",defaultValue ="" ) String category, HttpServletRequest request, HttpServletResponse response) {
        //流程列表列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page<Object[]> pageBean = processService.processList(
                new Page<Object[]>(page,limit), category);
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";//设置日期格式
        ComplexPropertyPreFilter filter = new ComplexPropertyPreFilter();
        filter.addIncludeFilter(ProcessDefinition.class,"id","category","key","name","version","resourceName","diagramResourceName","deploymentId","suspended");
        filter.addIncludeFilter(Deployment.class,"deploymentTime");
        String content = JSON.toJSONString(pageBean,filter);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     * 运行中的实例列表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "running", method = { RequestMethod.GET, RequestMethod.POST })
    public void runningList(String procInsId, String procDefKey,@RequestParam("page") Integer page, @RequestParam("limit") Integer limit, @RequestParam(value = "category",defaultValue ="" ) String category, HttpServletRequest request, HttpServletResponse response) {
        //文章列表
        if (page == null){
            page=1;
        }
        if (limit==null){
            limit=20;
        }
        Page<ProcessInstance> pageBean = processService.runningList(new Page<ProcessInstance>(page,limit), procInsId, procDefKey);
        String content = JSON.toJSONString(pageBean);
        StringUtils.printJson(response, content);
    }

    /**
     * 读取资源，通过部署ID
     *
     * @param procDefId
     * @param proInsId
     * @param resType
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "resource/read")
    public void resourceRead(String procDefId, String proInsId, String resType, HttpServletResponse response) throws Exception {
        InputStream resourceAsStream = processService.resourceRead(procDefId, proInsId, resType);
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }

    /**
     * 部署流程 - 保存
     * @param file
     * @return
     */
    @RequestMapping(value = "/deploy", method=RequestMethod.POST)
    @ResponseBody
    public ResponseResult deploy(String category, MultipartFile file) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("部署成功");
        try {
            String fileName = file.getOriginalFilename();
            if (StringUtils.isBlank(fileName)){
                responseResult.fail(ResponseError.NORMAL_ERROR,"请选择要部署的流程文件");
            }else{
                String message = processService.deploy(category, file);
                responseResult.ok(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"部署失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }


    /**
     * 挂起、激活流程实例
     */
    @RequestMapping(value = "{procDefId}/update/{state}")
    @ResponseBody
    public ResponseResult updateState(@PathVariable("procDefId") String procDefId,@PathVariable("state") String state) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("操作成功");
        try {
            String message = processService.updateState(state, procDefId);
            responseResult.ok(message);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"操作失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * 将部署的流程转换为模型
     *
     * @param procDefId
     * @return
     * @throws UnsupportedEncodingException
     * @throws XMLStreamException
     */
    @RequestMapping(value = "/convert/{procDefId}/toModel")
    @ResponseBody
    public ResponseResult convertToModel(@PathVariable("procDefId") String procDefId) throws UnsupportedEncodingException, XMLStreamException {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("转换模型成功");
        try {
            org.activiti.engine.repository.Model modelData = processService.convertToModel(procDefId);
            responseResult.put("modelId",modelData.getId());
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"操作失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * 导出图片文件到硬盘
     */
    @RequestMapping(value = "export/diagrams")
    @ResponseBody
    public List<String> exportDiagrams(@Value("#{APP_PROP['activiti.export.diagram.path']}") String exportDir) throws IOException {
        List<String> files = processService.exportDiagrams(exportDir);;
        return files;
    }

    /**
     * 删除部署的流程，级联删除流程实例
     * @param deploymentId 流程部署ID
     */
    @RequestMapping(value = "{deploymentId}/delete")
    @ResponseBody
    public ResponseResult delete(@PathVariable("deploymentId") String deploymentId) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            //判断删除

            processService.deleteDeployment(deploymentId);
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * 删除流程实例
     * @param procInsId 流程实例ID
     * @param reason 删除原因
     */
    @RequestMapping(value = "{procInsId}/deleteProcIns")
    @ResponseBody
    public ResponseResult deleteProcIns(@PathVariable("procInsId") String procInsId, String reason) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.ok("删除成功");
        try {
            if (StringUtils.isBlank(reason)){
                responseResult.fail(ResponseError.NORMAL_ERROR, "请填写删除原因");
            }else{
                processService.deleteProcIns(procInsId, reason);
                responseResult.ok("删除流程实例成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"删除失败!<br />原因:" + e.getMessage());
        }
        return responseResult;
    }
}

