package cn.gov.gzst.sms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**   
 * @Title: 短信配置
 * @Description: 短信配置
 * @author jianliaoliang
 * @date 2018-02-06 16:12:28
 * @version V1.0   
 *
 */
@TableName("sms_config")
@SuppressWarnings("serial")
public class SmsConfig extends AbstractEntity<String> {

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**签名*/
    @TableField(value = "name")
	private String name;
    /**描述*/
    @TableField(value = "description")
	private String description;
    /**应用KEY*/
    @TableField(value = "app_key")
	private String appKey;
    /**应用ID*/
    @TableField(value = "app_id")
	private String appId;
	
	/**
	 * 获取  id
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return: String  签名
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  签名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  description
	 *@return: String  描述
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param: description  描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * 获取  appKey
	 *@return: String  应用KEY
	 */
	public String getAppKey(){
		return this.appKey;
	}

	/**
	 * 设置  appKey
	 *@param: appKey  应用KEY
	 */
	public void setAppKey(String appKey){
		this.appKey = appKey;
	}
	/**
	 * 获取  appId
	 *@return: String  应用ID
	 */
	public String getAppId(){
		return this.appId;
	}

	/**
	 * 设置  appId
	 *@param: appId  应用ID
	 */
	public void setAppId(String appId){
		this.appId = appId;
	}
	
}
