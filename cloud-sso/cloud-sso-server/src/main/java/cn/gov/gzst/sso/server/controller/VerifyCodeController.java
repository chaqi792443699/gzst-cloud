package cn.gov.gzst.sso.server.controller;

import cn.gov.gzst.admin.bean.Role;
import cn.gov.gzst.admin.bean.SecAuthority;
import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.bean.AjaxResult;
import cn.gov.gzst.common.common.controller.BaseBeanController;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.utils.CaptchaUtil;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：验证码
 * @Author：Jianliaoliang
 * @Date 2019-05-20
 */
@Controller
public class VerifyCodeController extends BaseBeanController {

	@Autowired
	protected HttpServletRequest request;

	@Login(action = Action.Skip)
	@ResponseBody
	@RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
	public void index(String type,HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			if (StringUtils.isEmpty(type)) {
				type = "common";
			}
			String verifyCode = CaptchaUtil.outputImage(response.getOutputStream());
			String sessionKey = type + "_verifyCode";
			session.setAttribute(sessionKey,verifyCode);
			System.out.println("验证码:" + verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Login(action = Action.Skip)
	@ResponseBody
	@RequestMapping(value = "/checkVerifyCode", method = RequestMethod.GET)
	public AjaxResult checkVerifyCode(String type,String verifyCode,HttpServletResponse response) {
		HttpSession session = request.getSession();
		if ( StringUtils.isBlank(verifyCode) ) {
			return retResult("验证码不能为空", false);
		}
		Object verifyCode1 = session.getAttribute(type + "_verifyCode");
		if (verifyCode != null && verifyCode1 != null) {
			verifyCode1 = verifyCode1.toString().toLowerCase();
			verifyCode = verifyCode.toLowerCase();
			if (!verifyCode.equals(verifyCode1)) {
				return retResult("验证码不正确", false);
			}
		}
		return retResult(true);
	}
}
