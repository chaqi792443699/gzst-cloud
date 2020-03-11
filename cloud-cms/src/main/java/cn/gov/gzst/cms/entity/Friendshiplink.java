package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.entity
 * @title: cms_friendshiplink实体
 * @description: cms_friendshiplink实体
 * @author: wuzhengjun
 * @date: 2018-11-16 11:12:39
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_friendshiplink")
@SuppressWarnings("serial")
public class Friendshiplink extends AbstractEntity<String> {

    /**友情链接id*/
    @TableField(value = "id")
	private String id;
    /**网站名*/
    @TableField(value = "name")
	private String name;
    /**链接地址*/
    @TableField(value = "domain")
	private String domain;
	/**描述*/
	@TableField(value = "description")
	private String description;
    /**缩略图*/
    @TableField(value = "thumb")
	private String thumb;
    /**创建人*/
    @TableField(value = "create_by")
	private String createBy;
    /**创建时间*/
    @TableField(value = "create_date")
	private Date createDate;
    /**更新人*/
    @TableField(value = "update_by")
	private String updateBy;
    /**更新时间*/
    @TableField(value = "update_date")
	private Date updateDate;
    /**删除标记（0：正常；1：删除 ）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**对应站点*/
    @TableField(value = "site_id")
	private String siteId;
	
	/**
	 * 获取  id
	 *@return String  友情链接id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  友情链接id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  网站名
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  网站名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  domain
	 *@return String  链接地址
	 */
	public String getDomain(){
		return this.domain;
	}

	/**
	 * 设置  domain
	 *@param domain  链接地址
	 */
	public void setDomain(String domain){
		this.domain = domain;
	}
	/**
	 * 获取  thumb
	 *@return String  缩略图
	 */
	public String getThumb(){
		return this.thumb;
	}

	/**
	 * 设置  thumb
	 *@param thumb  缩略图
	 */
	public void setThumb(String thumb){
		this.thumb = thumb;
	}
	/**
	 * 获取  createBy
	 *@return String  创建人
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param createBy  创建人
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param createDate  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 * 获取  updateBy
	 *@return String  更新人
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param updateBy  更新人
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return Date  更新时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param updateDate  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  delFlag
	 *@return String  删除标记（0：正常；1：删除 ）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag  删除标记（0：正常；1：删除 ）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  siteId
	 *@return String  对应站点
	 */
	public String getSiteId(){
		return this.siteId;
	}

	/**
	 * 设置  siteId
	 *@param siteId  对应站点
	 */
	public void setSiteId(String siteId){
		this.siteId = siteId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}