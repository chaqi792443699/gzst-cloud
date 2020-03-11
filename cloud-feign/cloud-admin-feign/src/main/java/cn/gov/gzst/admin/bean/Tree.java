package cn.gov.gzst.admin.bean;


import cn.gov.gzst.common.common.entity.TreeEntity;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title: 树字典实体
 * @description: 树字典实体
 * @author: jianliaoliang
 * @date: 2018-05-05 11:52:10
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@SuppressWarnings("serial")
public class Tree extends TreeEntity<Tree> {

    /**id*/
    /**分组ID*/
	private String gid;
    /**区划名称*/
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
    private String codeName;
	private String gcode;
	
	/**
	 * 获取  gid
	 *@return: String  分组ID
	 */
	public String getGid(){
		return this.gid;
	}

	/**
	 * 设置  gid
	 *@param: gid  分组ID
	 */
	public void setGid(String gid){
		this.gid = gid;
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


	/**
	 * 获取  remarks
	 *@return: String  remarks
	 */
	public String getCodeName(){
		return this.code + this.getName();
	}

	public String getGcode() {
		return gcode;
	}

}