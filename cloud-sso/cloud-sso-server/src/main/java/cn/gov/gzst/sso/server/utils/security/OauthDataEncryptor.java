package cn.gov.gzst.sso.server.utils.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.NoSuchAlgorithmException;

public class OauthDataEncryptor {

	private static final String KEY_ALGORITHM = "PBEWithMD5AndDES";

	private static final String DEFAULT_SECRET = "merry";

	private static final String SAML_PREFIX = "INSPURCSG";

	private static final byte[] SAML_SALT = {'I', 'N', 'S', 'P', 'U', 'R', 'E', 'D'};

	private static final int ITERATION_COUNT = 8;

	public static String encrypt(String data) throws Exception {
		return encrypt(data, null);
	}

	public static String decrypt(String data) throws Exception {
		return decrypt(data, null);
	}

	public static String encrypt(String data, String secret) throws Exception {
		if (null == secret || "".equals(secret)) {
			secret = DEFAULT_SECRET;
		}
		try {
			SecretKeyFactory secKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			PBEKeySpec pbeKeySpec = new PBEKeySpec(secret.toCharArray());
			SecretKey secKey = secKeyFactory.generateSecret(pbeKeySpec);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SAML_SALT, ITERATION_COUNT);
			cipher.init(Cipher.ENCRYPT_MODE, secKey, pbeParameterSpec);
			byte[] encData = cipher.doFinal(data.getBytes("UTF-8"));
			encData = addPrefix(encData);
			return Base64.encode(encData);
		} catch (NoSuchAlgorithmException nse) {
			throw new Exception(nse.getMessage());
		}
	}

	public static String decrypt(String data, String secret) throws Exception {
		if (null == secret || "".equals(secret)) {
			secret = DEFAULT_SECRET;
		}
		try {
			SecretKeyFactory secKeyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			PBEKeySpec pbeKeySpec = new PBEKeySpec(secret.toCharArray());
			SecretKey secKey = secKeyFactory.generateSecret(pbeKeySpec);
			Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SAML_SALT, ITERATION_COUNT);
			cipher.init(Cipher.DECRYPT_MODE, secKey, pbeParameterSpec);
			byte[] tmp = Base64.decode(data);
			byte[] encData = removePrefix(tmp);
			byte[] decData = cipher.doFinal(encData);
			return Base64.encode(decData);
		} catch (NoSuchAlgorithmException nse) {
			throw new Exception(nse.getMessage());
		}
	}

	private static byte[] addPrefix(byte[] encData) {
		int length = encData.length;
		byte[] result = new byte[9 + length];
		byte[] encrypted = SAML_PREFIX.getBytes();
		for (int i = 0; i < 9; i++) {
			result[i] = encrypted[i];
		}
		for (int i = 0; i < length; i++) {
			result[(9 + i)] = encData[i];
		}
		return result;
	}

	private static byte[] removePrefix(byte[] data) {
		int length = data.length - 9;
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			result[i] = data[(9 + i)];
		}
		return result;
	}

}
