package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("passwordHelper")
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	@Value(value = "${cloud.shiro.credentials.hashAlgorithmName}")
	private String algorithmName = "md5";
	@Value(value = "${cloud.shiro.credentials.hashIterations}")
	private int hashIterations = 2;

	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	public void encryptPassword(User user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(
				algorithmName,
				user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				hashIterations).toHex();

		user.setPassword(newPassword);
	}

	/**
	 * 根据用户名和盐值加密
	 *
	 * @param username
	 * @param password
	 * @param salt
	 */
	public String encryptPassword(String username, String password, String salt) {
		String pwd = new SimpleHash(
				algorithmName,
				password,
				ByteSource.Util.bytes(username + salt),
				hashIterations).toHex();

		return pwd;
	}
}
