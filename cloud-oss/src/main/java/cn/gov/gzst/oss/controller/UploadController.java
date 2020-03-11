package cn.gov.gzst.oss.controller;

import cn.gov.gzst.common.bean.ResponseError;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.controller.BaseController;
import cn.gov.gzst.common.utils.MessageUtils;
import cn.gov.gzst.oss.common.exception.FileNameLengthLimitExceededException;
import cn.gov.gzst.oss.common.exception.InvalidExtensionException;
import cn.gov.gzst.oss.entity.Attachment;
import cn.gov.gzst.oss.helper.AttachmentHelper;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 附件管理控制器
 * @author: jianliaoliang
 */

@RestController
public class UploadController extends BaseController{

    @Autowired
    private AttachmentHelper attachmentHelper;
    /**
     *
     * @title: ajaxUpload
     * @description: 文件上传
     * @param request
     * @param response
     * @return
     * @return: AjaxUploadResponse
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult upload(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain");
        ResponseResult responseResult = new ResponseResult();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> ite = multiRequest.getFileNames();
            while (ite.hasNext()) {
                MultipartFile file = multiRequest.getFile(ite.next());
                try {
                    Attachment attachment = attachmentHelper.upload(request, file);
                    attachmentList.add(attachment);
                    continue;
                } catch (IOException e) {
                    responseResult.fail(ResponseError.NORMAL_ERROR,MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (InvalidExtensionException e) {
                    responseResult.fail(ResponseError.NORMAL_ERROR,MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (FileUploadBase.FileSizeLimitExceededException e) {
                    responseResult.fail(ResponseError.NORMAL_ERROR,MessageUtils.getMessage("upload.server.error"));
                    continue;
                } catch (FileNameLengthLimitExceededException e) {
                    responseResult.fail(ResponseError.NORMAL_ERROR,MessageUtils.getMessage("upload.server.error"));
                    continue;
                }
            }
            responseResult.put("attachment_list",attachmentList);
        }
        return responseResult;
    }

}