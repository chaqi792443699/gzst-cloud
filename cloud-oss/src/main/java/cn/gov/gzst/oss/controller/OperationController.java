package cn.gov.gzst.oss.controller;

import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.oss.entity.Attachment;
import cn.gov.gzst.oss.service.IAttachmentService;
import cn.gov.gzst.oss.utils.OssUtils;
import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.net.URL;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 * @description: 附件显示
 * @author: jianliaoliang
 */
@RestController
public class  OperationController extends BaseBeanController<Attachment> {

    @Autowired
    private IAttachmentService attachmentService;

    /**
     *
     * @title: ajaxUpload
     * @description: 文件上传
     * @return
     * @return: AjaxUploadResponse
     */
    @GetMapping("/get/{id}")
    public ResponseResult get(@PathVariable("id") String fileId) {
        ResponseResult responseResult = new ResponseResult();
        try {
            Attachment attachment = attachmentService.selectById(fileId);
            if (attachment!=null) {
                responseResult.putObject(attachment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseResult.fail(ResponseError.NORMAL_ERROR,"获取失败");
        }
        return responseResult;
    }

    @GetMapping("/show/{id}")
    public Object show(@PathVariable("id") String fileId) {
        ResponseResult responseResult = new ResponseResult();
        if(StringUtils.isEmpty(fileId)) {
            responseResult.fail(ResponseError.NORMAL_ERROR,"文件不存在");
            return responseResult;
        }
        try {
            Attachment attachment = attachmentService.selectById(fileId);
            if (attachment!=null) {
                //从URL中识别
                URL url = new URL(attachment.getFilePath());
                byte[] file = IOUtils.toByteArray(url);
                HttpHeaders headers = new HttpHeaders();
                String contentType=attachment.getContentType();
                if (StringUtils.isEmpty(contentType)){
                    contentType = OssUtils.getContentType(file);
                    attachment.setContentType(contentType);
                    attachmentService.saveOrUpdate(attachment);
                }
                headers.setContentType(MediaType.valueOf(contentType));
                return new HttpEntity<>(file, headers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        responseResult.fail(ResponseError.NORMAL_ERROR,"文件不存在");
        return responseResult;
    }

    @GetMapping("/down/{id}")
    public Object getImgByConvert(@PathVariable("id") String fileId) {
        ResponseResult responseResult = new ResponseResult();
        if(StringUtils.isEmpty(fileId)) {
            responseResult.fail(ResponseError.NORMAL_ERROR,"文件不存在");
            return responseResult;
        }
        try {
            Attachment attachment = attachmentService.selectById(fileId);
            if (attachment!=null) {
                //从URL中识别
                URL url = new URL(attachment.getFilePath());
                byte[] file = IOUtils.toByteArray(url);
                HttpHeaders headers = new HttpHeaders();
                String contentType=attachment.getContentType();
                if (StringUtils.isEmpty(contentType)){
                    contentType = OssUtils.getContentType(file);
                    attachment.setContentType(contentType);
                    attachmentService.saveOrUpdate(attachment);
                }
                if (!StringUtils.isEmpty(attachment.getFileName())) {
                    String fileExtension = attachment.getFileExtension();
                    headers.setContentType(MediaType.valueOf(contentType));
                    headers.setContentLength(attachment.getFileSize());
                    String filename = new String(attachment.getFileName().getBytes("UTF-8"), "ISO8859-1");
                    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=\"" + filename+"."+fileExtension + "\"");
                }
                return new HttpEntity<>(file, headers);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        responseResult.fail(ResponseError.NORMAL_ERROR,"文件不存在");
        return responseResult;
    }

}