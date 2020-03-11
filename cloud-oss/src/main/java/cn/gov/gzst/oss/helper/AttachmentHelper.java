package cn.gov.gzst.oss.helper;

import cn.gov.gzst.common.utils.IpUtils;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.security.UserUtils;
import cn.gov.gzst.oss.common.OSSUploadHelper;
import cn.gov.gzst.oss.common.exception.FileNameLengthLimitExceededException;
import cn.gov.gzst.oss.common.exception.InvalidExtensionException;
import cn.gov.gzst.oss.config.autoconfigure.OssConfigProperties;
import cn.gov.gzst.oss.entity.Attachment;
import cn.gov.gzst.oss.service.IAttachmentService;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.oss.controller
 * @title: 附件上传助手
 * @description: 附件上传助手
 * @author: jianliaoliang
 * @date: 2018-04-25 14:25:55
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Component("attachmentHelper")
@EnableConfigurationProperties({OssConfigProperties.class})
public class AttachmentHelper {

    Logger logger = LoggerFactory.getLogger(AttachmentHelper.class);

    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private OssConfigProperties configProperties;
    private OSSUploadHelper uploadHelper;

    @PostConstruct
    public void initHelper() {
        uploadHelper = new OSSUploadHelper();
        uploadHelper.init(configProperties);
    }


    public Attachment upload(HttpServletRequest request, MultipartFile file) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String basePath=request.getParameter("base_path");
        String projectId = request.getParameter("projectId");
        String fileType = request.getParameter("fileType");
        String userId = request.getParameter("userId");
        String modelId = request.getParameter("modelId");
        String status = request.getParameter("status");
        String url = uploadHelper.upload(request, file, basePath);
        String filename = file.getOriginalFilename();
        filename = new String(filename.getBytes(), "UTF-8");
        long size = file.getSize();
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setContentType(file.getContentType());
        attachment.setModelId(modelId);
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setUserId(userId);
        // 根据传过来的status赋值 0的时候为临时文件
        if (StringUtils.isEmpty(status)) {
            attachment.setStatus("1");
        } else {
            attachment.setStatus(status);
        }

        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setProjectId(projectId);
        attachment.setFileType(fileType);
        if (StringUtils.isEmpty(userId)) {
            attachment.setCreateBy(UserUtils.getUserId(request));
        }
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

    public Attachment remote(HttpServletRequest request,String remoteUrl) throws FileSizeLimitExceededException,
            IOException, FileNameLengthLimitExceededException, InvalidExtensionException {
        String basePath=request.getParameter("base_path");
        String url = uploadHelper.remote(request, remoteUrl, basePath);
        String filename =  remoteUrl.substring(remoteUrl.lastIndexOf('/')+1);
        URL remoteUri = new URL(remoteUrl);
        HttpURLConnection conn = (HttpURLConnection) remoteUri.openConnection();
        conn.setConnectTimeout(10 * 1000);
        long size = Integer.parseInt(conn.getHeaderField("Content-Length"));
        String contentType =  conn.getHeaderField("Content-Type");
        String realFileName = StringUtils.getFileNameNoEx(filename);
        String fileExtension = StringUtils.getExtensionName(filename);
        // 保存上传的信息
        Attachment attachment = new Attachment();
        attachment.setFileExtension(fileExtension);
        attachment.setFileName(realFileName);
        attachment.setFilePath(url);
        attachment.setFileSize(size);
        attachment.setStatus("1");
        attachment.setUploadIp(IpUtils.getIpAddr(request));
        attachment.setUploadTime(new Date());
        attachment.setContentType(contentType);
        attachment.setCreateBy(UserUtils.getUserId(request));
        attachment.setBasePath(basePath);
        attachmentService.insert(attachment);
        return attachment;
    }

    public void delete(HttpServletRequest request,String fileName) {
        try {
            uploadHelper.delete(request,fileName);
        } catch (IOException e) {
            logger.error("删除远程附件失败");
        }
    }

}
