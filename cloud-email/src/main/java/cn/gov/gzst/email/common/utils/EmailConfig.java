package cn.gov.gzst.email.common.utils;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.entity
 * @title: 邮件配置实体
 * @description: 邮件配置
 * @author: jianliaoliang
 * @date: 2018-04-24 11:16:31
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
public class EmailConfig implements Serializable{

    /**邮件服务器*/
	private String smtpHost;
    /**邮件服务器端口*/
	private Integer smtpPort;
    /**SMTP 连接需要使用 SSL 安全认证*/
	private Boolean smtpOpenSsl;
    /**邮件服务器是否需要验证*/
	private Boolean authAble;
    /**认证用户*/
	private String authUsername;
    /**认证密码*/
	private String authPassword;
    /**发送人*/
	private String senderUsername;
    /**发送人别名*/
	private String senderAlias;


	/**
	 * 获取  smtpHost
	 *@return String  邮件服务器
	 */
	public String getSmtpHost(){
		return this.smtpHost;
	}

	/**
	 * 设置  smtpHost
	 *@param smtpHost  邮件服务器
	 */
	public void setSmtpHost(String smtpHost){
		this.smtpHost = smtpHost;
	}
	/**
	 * 获取  smtpPort
	 *@return String  邮件服务器端口
	 */
	public Integer getSmtpPort(){
		return this.smtpPort;
	}

	/**
	 * 设置  smtpPort
	 *@param smtpPort  邮件服务器端口
	 */
	public void setSmtpPort(Integer smtpPort){
		this.smtpPort = smtpPort;
	}
	/**
	 * 获取  smtpOpenSsl
	 *@return Short  SMTP 连接需要使用 SSL 安全认证
	 */
	public Boolean getSmtpOpenSsl(){
		return this.smtpOpenSsl;
	}

	/**
	 * 设置  smtpOpenSsl
	 *@param smtpOpenSsl  SMTP 连接需要使用 SSL 安全认证
	 */
	public void setSmtpOpenSsl(Boolean smtpOpenSsl){
		this.smtpOpenSsl = smtpOpenSsl;
	}
	/**
	 * 获取  authAble
	 *@return Short  邮件服务器是否需要验证
	 */
	public Boolean getAuthAble(){
		return this.authAble;
	}

	/**
	 * 设置  authAble
	 *@param authAble  邮件服务器是否需要验证
	 */
	public void setAuthAble(Boolean authAble){
		this.authAble = authAble;
	}
	/**
	 * 获取  authUsername
	 *@return String  认证用户
	 */
	public String getAuthUsername(){
		return this.authUsername;
	}

	/**
	 * 设置  authUsername
	 *@param authUsername  认证用户
	 */
	public void setAuthUsername(String authUsername){
		this.authUsername = authUsername;
	}
	/**
	 * 获取  authPassword
	 *@return String  认证密码
	 */
	public String getAuthPassword(){
		return this.authPassword;
	}

	/**
	 * 设置  authPassword
	 *@param authPassword  认证密码
	 */
	public void setAuthPassword(String authPassword){
		this.authPassword = authPassword;
	}
	/**
	 * 获取  senderUsername
	 *@return String  发送人
	 */
	public String getSenderUsername(){
		return this.senderUsername;
	}

	/**
	 * 设置  senderUsername
	 *@param senderUsername  发送人
	 */
	public void setSenderUsername(String senderUsername){
		this.senderUsername = senderUsername;
	}
	/**
	 * 获取  senderAlias
	 *@return String  发送人别名
	 */
	public String getSenderAlias(){
		return this.senderAlias;
	}

	/**
	 * 设置  senderAlias
	 *@param senderAlias  发送人别名
	 */
	public void setSenderAlias(String senderAlias){
		this.senderAlias = senderAlias;
	}
	
}