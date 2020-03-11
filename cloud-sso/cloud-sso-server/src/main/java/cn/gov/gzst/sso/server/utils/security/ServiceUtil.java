package cn.gov.gzst.sso.server.utils.security;

public class ServiceUtil {

	public static String getTime() {
		return DateUtil.getCurrentStringDate(DateUtil.LDAP_DATE_FORMAT);
	}

	public static String getMd5Sing(String servicecode, String pwd, String time) {
		String newSign = servicecode + pwd + time;
		return MD5.MD5Encode(newSign);
	}
}
