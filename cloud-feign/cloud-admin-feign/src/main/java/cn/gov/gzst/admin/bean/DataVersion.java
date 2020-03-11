package cn.gov.gzst.admin.bean;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title: 数据版本实体
 * @description: 数据版本实体
 * @author: jianliaoliang
 * @date: 2018-07-16 09:49:14
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("sys_data_version")
@SuppressWarnings("serial")
public class DataVersion extends AbstractEntity<String> {

    /**id*/
	private String id;
    /**业务KEY*/
	private String businessKey;
    /**业务类型*/
	private String businessType;
    /**json_data*/
	private String jsonData;
    /**version*/
	private Integer version;

    private Date addtime;
	
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
	/**
	 * 获取  businessKey
	 *@return String  业务KEY
	 */
	public String getBusinessKey(){
		return this.businessKey;
	}

	/**
	 * 设置  businessKey
	 *@param businessKey  业务KEY
	 */
	public void setBusinessKey(String businessKey){
		this.businessKey = businessKey;
	}
	/**
	 * 获取  businessType
	 *@return String  业务类型
	 */
	public String getBusinessType(){
		return this.businessType;
	}

	/**
	 * 设置  businessType
	 *@param businessType  业务类型
	 */
	public void setBusinessType(String businessType){
		this.businessType = businessType;
	}
	/**
	 * 获取  jsonData
	 *@return String  json_data
	 */
	public String getJsonData(){
		return this.jsonData;
	}

	/**
	 * 设置  jsonData
	 *@param jsonData  json_data
	 */
	public void setJsonData(String jsonData){
		this.jsonData = jsonData;
	}
	/**
	 * 获取  version
	 *@return Integer  version
	 */
	public Integer getVersion(){
		return this.version;
	}

	/**
	 * 设置  version
	 *@param version  version
	 */
	public void setVersion(Integer version){
		this.version = version;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}