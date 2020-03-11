package cn.gov.gzst.admin.utils;

import cn.gov.gzst.admin.bean.Log;
import cn.gov.gzst.admin.feign.LogFeign;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.utils.Exceptions;
import cn.gov.gzst.common.utils.IpUtils;
import cn.gov.gzst.common.utils.SpringContextHolder;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.common.utils.security.UserUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

public class LogUtils {

	private static LogFeign logFeign = (LogFeign) SpringContextHolder.getBean(LogFeign.class);

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title) {
		saveLog(request, null, null, title, null);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title, String content) {
		saveLog(request, null, null, title, content);
	}

	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title) {
		saveLog(request, handler, ex, title, null);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title, String content) {
		String userId = UserUtils.getUserId(request);
		if (!StringUtils.isEmpty(userId)) {
			Log log = new Log();
			log.setTitle(title);
			log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
			log.setRemoteAddr(IpUtils.getIpAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setParams(request.getParameterMap());
			log.setMethod(request.getMethod());
			log.setContent(content);
			// 异步保存日志
			new SaveLogThread(log, handler, ex).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread {

		private Log log;
		private Object handler;
		private Exception ex;

		public SaveLogThread(Log log, Object handler, Exception ex) {
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}

		@Override
		public void run() {
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())) {
				String title = "";
				String notes = "";
				if (handler instanceof HandlerMethod) {
					Method m = ((HandlerMethod) handler).getMethod();
					ApiOperation rp = m.getAnnotation(ApiOperation.class);
					title = (rp != null ? StringUtils.join(rp.value(), ",") : "");
					notes = (rp != null ? StringUtils.join(rp.notes(), ",") : "");
				}
				log.setTitle(title);
				log.setContent(notes);
			}
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isEmpty(log.getTitle()) && StringUtils.isEmpty(log.getException())) {
				return;
			}
			// 保存日志信息
			logFeign.save(log);
		}
	}
}
