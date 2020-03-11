package cn.gov.gzst.email.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.email.common.utils.EmailConfig;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.entity
 * @title: 邮件配置实体
 * @description: 邮件配置实体
 * @author: jianliaoliang
 * @date: 2018-04-24 11:16:31
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("email_config")
@SuppressWarnings("serial")
public class Config extends AbstractEntity<String> {

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
	/**签名*/
	@TableField(value = "name")
	private String name;
    /**邮件服务器*/
    @TableField(value = "smtp_host")
	private String smtpHost;
    /**邮件服务器端口*/
    @TableField(value = "smtp_port")
	private Integer smtpPort;
    /**SMTP 连接需要使用 SSL 安全认证*/
    @TableField(value = "smtp_open_ssl")
	private Boolean smtpOpenSsl;
    /**邮件服务器是否需要验证*/
    @TableField(value = "auth_able")
	private Boolean authAble;
    /**认证用户*/
    @TableField(value = "auth_username")
	private String authUsername;
    /**认证密码*/
    @TableField(value = "auth_password")
	private String authPassword;
    /**发送人*/
    @TableField(value = "sender_username")
	private String senderUsername;
    /**发送人别名*/
    @TableField(value = "sender_alias")
	private String senderAlias;
	
	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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


	public EmailConfig toEmailConfig(){
		EmailConfig emailConfig=new EmailConfig();
		emailConfig.setSmtpHost(this.getSmtpHost());
		emailConfig.setSmtpPort(this.getSmtpPort());
		emailConfig.setSmtpOpenSsl(this.getSmtpOpenSsl());
		emailConfig.setAuthAble(this.getAuthAble());
		emailConfig.setAuthUsername(this.getAuthUsername());
		emailConfig.setAuthPassword(this.getAuthPassword());
		emailConfig.setSenderUsername(this.getSenderUsername());
		emailConfig.setSenderAlias(this.getSenderAlias());
		return emailConfig;
	}
}