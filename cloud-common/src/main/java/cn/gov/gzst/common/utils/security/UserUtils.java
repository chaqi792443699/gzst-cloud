package cn.gov.gzst.common.utils.security;

import cn.gov.gzst.common.exception.WebException;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.security.token.SSOToken;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户工具
 */
@SuppressWarnings("unchecked")
public class UserUtils {

	/**
     * 获取token
	 * @param request
     * @return
     */
	protected static SSOToken getSSOToken(HttpServletRequest request) {
		SSOToken tk = (SSOToken) SSOHelper.attrToken(request);
		return tk;
	}

	/**
     * 获取用户ID
	 * @param request
     * @return
     */
	public static String getUserId(HttpServletRequest request) {
		if (request == null) return null;
		SSOToken token = UserUtils.getSSOToken(request);
		String userId = null;
		if (token != null) {
			userId = token.getId();
		}
		return userId;
	}

}
