package cn.gov.gzst.sso.server.utils.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static String LDAP_DATE_FORMAT = "yyyyMMddhhmmss";

	public static Date convertString2Date(String stringDate, String dateFormat) {
		SimpleDateFormat sdf = null;
		if ((dateFormat != null) && (!dateFormat.equals(""))) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
			} catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			}
		} else {
			sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		}
		try {
			return sdf.parse(stringDate);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return new Date(System.currentTimeMillis());
	}

	public static Date convertLdapString2Date(String stringDate) {
		return convertString2Date(stringDate.substring(0, stringDate.length() - 1), LDAP_DATE_FORMAT);
	}

	public static String convertDate2String(Date date, String dateFormat) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = null;
		if ((dateFormat != null) && (!dateFormat.equals(""))) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
			} catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
			}
		} else {
			sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		}
		return sdf.format(date);
	}

	public static String getCurrentStringDate() {
		return convertDate2String(getCurrentDate(), DEFAULT_DATE_FORMAT);
	}

	public static String getCurrentStringDate(String dateFormat) {
		return convertDate2String(getCurrentDate(), dateFormat);
	}

	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
}
