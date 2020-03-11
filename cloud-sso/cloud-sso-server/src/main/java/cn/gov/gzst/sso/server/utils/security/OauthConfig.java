package cn.gov.gzst.sso.server.utils.security;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class OauthConfig {

	private static final String CONFIG_FILENAME = "/oauth-sso-config.xml";

	private static Map<String, String> propertyCache = new HashMap<String, String>();

	private static Document doc = null;

	static {
		InputStream is = null;
		try {
			is = OauthConfig.class.getResourceAsStream(CONFIG_FILENAME);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(new BufferedInputStream(is));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception localException2) {
				}
				is = null;
			}
		}
	}

	public static synchronized void init(Map<String, String> map) {
		propertyCache.putAll(map);
	}

	public static String getProperty(String name) {
		String cacheProp = popProperty(name);
		if (cacheProp != null) {
			return cacheProp;
		}

		NodeList node = doc.getElementsByTagName(name);
		String value = null;
		if (node.getLength() == 0) {
			return null;
		}
		value = node.item(0).getTextContent();

		if ("".equals(value)) {
			return null;
		}

		value = value.trim();
		pushProperty(name, value);
		return value;
	}

	private static synchronized String popProperty(String name) {
		if (propertyCache.containsKey(name)) {
			return (String) propertyCache.get(name);
		}

		return null;
	}

	private static synchronized void pushProperty(String name, String value) {
		propertyCache.put(name, value);
	}
}
