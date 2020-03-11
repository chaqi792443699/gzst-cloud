package cn.gov.gzst.sso.server.controller;

import cn.gov.gzst.admin.bean.Role;
import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.sso.server.service.PasswordHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.kisso.common.util.HttpUtil;
import com.baomidou.kisso.security.token.SSOToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：登录退出
 * @Author：zhixuan.wang hubin
 * @Date 2016-02-27
 */
@Controller
public class LoginController extends BaseBeanController {

	@Autowired
	protected HttpServletRequest request;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private PasswordHelper passwordHelper;
	/**
	 * 首页
	 */
    @Permission(action = Action.Skip)
	@RequestMapping(value = "/index")
	@ResponseBody
	public String index() {
		return getSSOToken().getIssuer();
	}

	/**
	 * GET 登录
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	@ResponseBody
	public String userInfo() {
		SSOToken ssoToken = SSOHelper.attrToken(request);
		if (null != ssoToken) {
			String userId = getCurrentUserId();
			User user = userFeign.findByUserId(userId);
			PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
			propertyPreFilterable.addIncludeFilter(User.class,new String[]{"id","username","showName","realName","avatar","type","status","roles","authorities"});
			propertyPreFilterable.addIncludeFilter(Role.class,new String[]{"id","code"});
			propertyPreFilterable.addIncludeFilter(SecAuthority.class,new String[]{"id","name"});
			SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
			String content = JSON.toJSONString(user, filter);
			return content;
		} else {
			return null;
		}
	}

	/**
	 * POST 登录 shiro 写法
	 *
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	@Login(action = Action.Skip)
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AjaxResult login(String username, String password,String loginVerifyCode) {
		HttpSession session = request.getSession();
		if ( StringUtils.isBlank(username) ) {
			return retResult("用户名不能为空", false);
		}
		if ( StringUtils.isBlank(password) ) {
			return retResult("密码不能为空", false);
		}
		if ( StringUtils.isBlank(loginVerifyCode) ) {
			return retResult("验证码不能为空", false);
		}
		Object verifyCode = session.getAttribute("login_verifyCode");
		if (verifyCode != null && loginVerifyCode != null) {
			verifyCode = verifyCode.toString().toLowerCase();
			loginVerifyCode = loginVerifyCode.toLowerCase();
			if (!verifyCode.equals(loginVerifyCode)) {
				return retResult("验证码不正确", false);
			}
		}
		/**
		 * KISSO 登录授权
		 * 此处为验证登录身份
		 */
		User userInfo = userFeign.findByUsername(username);
		if ( userInfo != null && userInfo.getPassword().equals(passwordHelper.encryptPassword(username,password,userInfo.getSalt())) ) {
			SSOToken st = SSOToken.create();
			st.setId(userInfo.getId());
			st.setIssuer(userInfo.getUsername());
			st.setData(userInfo);
			//记住密码，设置 cookie 时长 1 周 = 604800 秒 【动态设置 maxAge 实现记住密码功能】
			if ( "on".equals(request.getParameter("rememberMe")) ) {
				SSOConfig.getInstance().setCacheExpires(604800);
			}
			SSOHelper.setCookie(request, response, st, false);
			
			//处理 ReturnURL 地址
			String rtUrlName = SSOConfig.getInstance().getParamReturl();
			String returnURL = request.getParameter(rtUrlName);
			if ( StringUtils.isNoneBlank(returnURL) ) {
				returnURL = HttpUtil.decodeURL(returnURL);
			} else {
				returnURL = "/index";
			}
			Map data = new HashMap();
			data.put("token",st.getToken());
			data.put("ReturnURL",returnURL);
			return retResult(data);
		}
		
		return retResult("用户名密码错误", false);
	}

	/**
	 * 退出
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout")
	public AjaxResult logout() {
		/**
		 * KISSO 退出登录
		 */
		SSOHelper.clearLogin(request, response);
		return retResult(true);
	}
}
