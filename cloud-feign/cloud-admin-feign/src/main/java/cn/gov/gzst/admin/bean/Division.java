package cn.gov.gzst.admin.bean;

import cn.gov.gzst.common.common.entity.TreeEntity;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title: 行政区划实体
 * @description: 行政区划实体
 * @author: jianliaoliang
 * @date: 2018-05-05 10:42:04
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

public class Division extends TreeEntity<Division> {

	private String fullName;
    /**区划编码*/
	private String code;
    /**父节点*/
    /**父节点路径*/
    /**create_by*/
	private String createBy;
    /**create_date*/
	private Date createDate;
    /**update_by*/
	private String updateBy;
    /**update_date*/
	private Date updateDate;
    /**删除标记*/
	private String delFlag;
    /**remarks*/
	private String remarks;
	
	/**
	 * 获取  fullName
	 *@return: String  区划全名
	 */
	public String getFullName(){
		return this.fullName;
	}

	/**
	 * 设置  fullName
	 *@param: fullName  区划全名
	 */
	public void setFullName(String fullName){
		this.fullName = fullName;
	}
	/**
	 * 获取  code
	 *@return: String  区划编码
	 */
	public String getCode(){
		return this.code;
	}

	/**
	 * 设置  code
	 *@param: code  区划编码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * 获取  createBy
	 *@return: String  create_by
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param: createBy  create_by
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return: Date  create_date
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param: createDate  create_date
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 * 获取  updateBy
	 *@return: String  update_by
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param: updateBy  update_by
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return: Date  update_date
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param: updateDate  update_date
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  delFlag
	 *@return: String  删除标记
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  删除标记
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  remarks
	 *@return: String  remarks
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param: remarks  remarks
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	
}