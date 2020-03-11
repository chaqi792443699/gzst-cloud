package cn.gov.gzst.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import cn.gov.gzst.common.utils.JarUtil;
import cn.gov.gzst.common.utils.JeewebPropertiesUtil;

import javax.servlet.ServletContext;

/**
 * 启动解压cloud-admin-x.x.x.jar到目录目录
 * 
 * @author Administrator
 *
 */
public class CloudAdminUtil implements InitializingBean, ServletContextAware {

	private static Logger logger = LoggerFactory.getLogger(CloudAdminUtil.class);
	private String version = "1.0.0-SNAPSHOT";

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		logger.info("===== 开始解压cloud-admin =====");
		logger.info("cloud-admin.jar 版本: {}", version);
		String jarPath = servletContext.getRealPath("/WEB-INF/lib/cloud-admin-" + version + ".jar");
		logger.info("cloud-admin.jar 包路径: {}", jarPath);
		String resources = servletContext.getRealPath("/");
		logger.info("cloud-admin.jar 解压到: {}", resources);
		JarUtil.decompress(jarPath, resources);
		logger.info("===== 解压cloud-admin完成 =====");
	}

}
