package cn.gov.gzst.sso.server.utils.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class OauthClientSecureUtil {

	private static final String SIGN_AF = "AF";

	private static final String DEFAULT_SECRET = "merry";

	public Map buildUserInfo(String str) throws Exception {
		return this.buildUserInfo(str, DEFAULT_SECRET);
	}

	public Map buildUserInfo(String str, String secret) throws Exception {
		if (str == null) {
			return null;
		}

		Map map = getAttributesFromEncodedData(str);

		String signature = (String) map.remove("Signature");
		if (!verifySign(map, signature, secret)) {
			return null;
		}
		return map;
	}

	public Map getAttributesFromEncodedData(String str) throws Exception {
		if (str == null) {
			return null;
		}

		if (str.indexOf(' ') > 0) {
			str = str.replace(' ', '+');
		}
		byte[] bytes = Base64.decode(str);
		String decoded = new String(bytes, "UTF-8");
		if (decoded.indexOf("|") == -1) {
			return null;
		}
		StringTokenizer tokenizer = new StringTokenizer(decoded, "|");

		Map map = new HashMap();
		while (tokenizer.hasMoreTokens()) {
			String st = tokenizer.nextToken();
			int index = st.indexOf("=");
			if (index == -1) {
				continue;
			}
			String attr = st.substring(0, index);
			String value = st.substring(index + 1, st.length());
			map.put(attr, value);
		}

		return map;
	}

	public boolean verifySign(Map attrs, String token, String secret) throws Exception {
		StringBuffer str = normalize(attrs);

		int idx = token.indexOf(SIGN_AF, 2);
		String ts = token.substring(2, idx);

		String seed = secret + ts;

		String newstr = SIGN_AF + ts + SIGN_AF + encrypt(new StringBuilder().append(str).append(seed).toString(), seed);

		return token.equals(newstr);
	}

	public Map buildUserInfo(String str, String secret, String encSecret) throws Exception {
		if (encSecret == null) {
			return buildUserInfo(str, secret);
		}

		if (!isEncrypted(str)) {
			return buildUserInfo(str, secret);
		}
		if (str.indexOf(' ') > 0) {
			str = str.replace(' ', '+');
		}
		String decryptStr = null;
		decryptStr = OauthDataEncryptor.decrypt(str, encSecret);

		return buildUserInfo(decryptStr, secret);
	}

	private boolean isEncrypted(String str) throws Exception {
		if (str.indexOf(' ') > 0) {
			str = str.replace(' ', '+');
		}
		byte[] decoded = Base64.decode(str);
		String tmp1 = new String(decoded, "UTF-8");
		byte[] encString = new byte[9];
		for (int i = 0; i < 9; i++) {
			encString[i] = decoded[i];
		}

		String tmp = new String(encString, "UTF-8");

		return tmp.equals("INSPURCSG");
	}

	private StringBuffer normalize(Map attrs) {
		TreeMap smap = new TreeMap(attrs);
		StringBuffer str = new StringBuffer();
		Iterator iter = smap.keySet().iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			str.append(key).append("=").append(smap.get(key)).append("|");
		}
		return str;
	}

	private synchronized String encrypt(String plaintext, String seed) throws Exception {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception(e.getMessage());
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new Exception(e.getMessage());
		}
		byte[] raw = md.digest();
		String hash = Base64.encode(raw);
		return hash;
	}
}
