package cn.gov.gzst.common.common.controller;

import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.utils.convert.DateConvertEditor;
import cn.gov.gzst.common.utils.convert.StringConvertEditor;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 基础控制器类
 */
public class BaseController extends SuperController {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected BaseController() {

	}

	/**
	 * 返回JSON字符串
	 * 
	 * @param response
	 * @param object
	 * @return
	 * @return
	 */
	protected void printString(HttpServletResponse response, Object object) {
		printString(response, JSON.toJSONString(object));
	}

	/**
	 * 打印字符串到页面
	 * 
	 * @param response
	 * @param string
	 * @return
	 */
	protected void printString(HttpServletResponse response, String string) {
		try {
			response.reset();
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
		} catch (IOException e) {

		}
	}
    protected AjaxResult retResult( boolean success ) {
        return retResult(null, null, success);
    }


    protected AjaxResult retResult( String msg, boolean success ) {
        return retResult(msg, null, success);
    }


    protected AjaxResult retResult( Object obj) {
        return retResult(null, obj, true);
    }


    protected AjaxResult retResult(String msg, Object obj, boolean success ) {
		AjaxResult rlt = new AjaxResult();
		rlt.setMeta(rlt.new Meta(success,msg));
		rlt.setData(obj);
        return rlt;
    }

	/**
	 * 页面跳转
	 * @param backURL
	 * @return
	 */
	protected String redirectToUrl(String backURL) {
		if (!backURL.startsWith("/") && !backURL.startsWith("http")) {
			backURL = "/" + backURL;
		}
		return "redirect:" + backURL;
	}

	/**
	 * 初始化数据绑定
	 * 
	 * @param binder
	 */
	@InitBinder
	void initBinder(ServletRequestDataBinder binder) {
		// 将所有传递进来的String进行HTML编码，防止XSS攻击
		// 这个会导致数据库数据
		binder.registerCustomEditor(String.class, new StringConvertEditor());
		// 日期格式
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
}
