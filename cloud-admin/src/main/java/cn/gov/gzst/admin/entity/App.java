package cn.gov.gzst.admin.entity;

import cn.gov.gzst.admin.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title: 应用管理 *
 */
@TableName("sys_app")
@SuppressWarnings("serial")
public class App extends DataEntity<String> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 应用标题 */
	@TableField(value = "title")
	private String title;
	/** 应用的KEY */
	@TableField(value = "app_key")
	private String appKey;
	/** 应用图标 */
	@TableField(value = "icon")
	private String icon;
	/** 应用path */
	@TableField(value = "path")
	private String path;
	/** 应用URL */
	@TableField(value = "url")
	private String url;
	/** 应用编码 */
	@TableField(value = "app_secret")
	private String appSecret;
	/** 返回验证码 */
	@TableField(value = "app_token")
	private String appToken;
	/** 是否可以 */
	@TableField(value = "available")
	private Short available;

	@TableField(value = "oss_root_path")
	private String ossRootPath;//文件根目录
	@TableField(value = "send_sms_callback")
	private String sendSmsCallback;//短信发送成功回掉
	@TableField(value = "receive_sms_callback")
	private String receiveSmsCallback;//接受短信回掉
	/** 同步用户信息地址 */
	@TableField(value = "userUrl")
	private String userUrl;
	/** 同步企业信息地址 */
	@TableField(value = "enterpriseUrl")
	private String enterpriseUrl;


	/**
	 * 获取 id
	 * 
	 * @return: String 主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 title
	 * 
	 * @return: String 应用标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 设置 title
	 * 
	 * @param: title
	 *             应用标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取 appKey
	 * 
	 * @return: String 应用的KEY
	 */
	public String getAppKey() {
		return this.appKey;
	}

	/**
	 * 设置 appKey
	 * 
	 * @param: appKey
	 *             应用的KEY
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取 url
	 * 
	 * @return: String 应用URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 设置 url
	 * 
	 * @param: url
	 *             应用URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取 appSecret
	 * 
	 * @return: String 应用编码
	 */
	public String getAppSecret() {
		return this.appSecret;
	}

	/**
	 * 设置 appSecret
	 * 
	 * @param: appSecret
	 *             应用编码
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	/**
	 * 获取 available
	 * 
	 * @return: Short 是否可以
	 */
	public Short getAvailable() {
		return this.available;
	}

	/**
	 * 设置 available
	 * 
	 * @param: available
	 *             是否可以
	 */
	public void setAvailable(Short available) {
		this.available = available;
	}

	public String getOssRootPath() {
		return ossRootPath;
	}

	public void setOssRootPath(String ossRootPath) {
		this.ossRootPath = ossRootPath;
	}

	public String getSendSmsCallback() {
		return sendSmsCallback;
	}

	public void setSendSmsCallback(String sendSmsCallback) {
		this.sendSmsCallback = sendSmsCallback;
	}

	public String getReceiveSmsCallback() {
		return receiveSmsCallback;
	}

	public void setReceiveSmsCallback(String receiveSmsCallback) {
		this.receiveSmsCallback = receiveSmsCallback;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public String getEnterpriseUrl() {
		return enterpriseUrl;
	}

	public void setEnterpriseUrl(String enterpriseUrl) {
		this.enterpriseUrl = enterpriseUrl;
	}
}
