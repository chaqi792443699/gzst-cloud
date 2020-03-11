package cn.gov.gzst.oss.common.client;

import cn.gov.gzst.common.utils.PropertiesUtil;
import cn.gov.gzst.common.utils.ServletUtils;
import cn.gov.gzst.oss.common.config.OssConfig;
import cn.gov.gzst.oss.common.exception.OSSException;
import org.aspectj.util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * All rights Reserved, Designed By kjt.gzst.gov.cn
 *
 * @version V1.0
 * @title: IOSSClient.java
 * @description: 这里为本地操作
 * @author: jianliaoliang
 * @date: 2017年8月11日 下午9:55:00
 * @copyright: 2017 kjt.gzst.gov.cn Inc. All rights reserved.
 */
public class LocalClient extends  AbstractOSSClient {

    public static final String DEFAULT_CONFIG_FILE = "local.properties";
    private String domain;//本地域名配置

    @Override
    public void init() {
      init(DEFAULT_CONFIG_FILE);
    }

    @Override
    public void init(String propertiesName) {
        PropertiesUtil p = new PropertiesUtil(propertiesName);
        domain = p.getString("local.domain");
    }

    @Override
    public void init(OssConfig config) {

    }


    /**
     * 提取上传的根目录 默认是应用的根
     *
     * @param request
     * @return
     */
    private String extractUploadDir(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }

    /**
     * 判断文件地址保存文件
     * @param path
     * @return
     * @throws IOException
     */
    private File getAbsoluteFile(String path) throws IOException {
        String basePath=extractUploadDir(ServletUtils.getRequest());
        File desc = new File(basePath+File.separator+path);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        if (!desc.exists()) {
            desc.createNewFile();
        }
        return desc;
    }

    /**
     * 文件上传
     * @param inputStream
     * @param path
     * @return
     */
    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            File outFile=getAbsoluteFile(path);
            FileUtil.copyStream(inputStream,new FileOutputStream(outFile));
        } catch (Exception e) {
            throw new OSSException("上传文件失败", e);
        }
        return domain + "/" + path;
    }

    @Override
    public void delete(String filename) {
        String basePath=extractUploadDir(ServletUtils.getRequest());
        File desc = new File(basePath+File.pathSeparator+filename);
        if (desc.exists()) {
            desc.delete();
        }
    }

}
