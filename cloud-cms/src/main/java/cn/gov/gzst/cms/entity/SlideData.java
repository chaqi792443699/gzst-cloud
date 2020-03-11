package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.entity
 * @title: 幻灯片数据实体
 * @description: 幻灯片数据实体
 * @author: jianliaoliang
 * @date: 2018-04-28 15:38:38
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_slide_data")
@SuppressWarnings("serial")
public class SlideData extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**幻灯片ID*/
    @TableField(value = "slideid")
	private String slideid;
    /**图片标题*/
    @TableField(value = "title")
	private String title;
    /**图片路径*/
    @TableField(value = "pic")
	private String pic;
    /**图片链接*/
    @TableField(value = "link")
	private String link;
    /**图片描述*/
    @TableField(value = "description")
	private String description;
    /**排序值（越小越在后面）*/
    @TableField(value = "listorder")
	private Integer listorder;
    /**是否显示 (1为显示 0为不显示)*/
    @TableField(value = "status")
	private String status;
    /**创建人*/
    @TableField(value = "create_by", fill = FieldFill.INSERT)
	private String createBy;
    /**创建时间*/
    @TableField(value = "create_date", fill = FieldFill.INSERT)
	private Date createDate;
    /**更新人*/
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
	private String updateBy;
    /**更新时间*/
    @TableField(value = "update_date", fill = FieldFill.UPDATE)
	private Date updateDate;
    /** 删除标记（0：正常；1：删除 ）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注*/
    @TableField(value = "remarks")
	private String remarks;
	
	/**
	 * 获取  id
	 *@return String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  slideid
	 *@return String  幻灯片ID
	 */
	public String getSlideid(){
		return this.slideid;
	}

	/**
	 * 设置  slideid
	 *@param slideid  幻灯片ID
	 */
	public void setSlideid(String slideid){
		this.slideid = slideid;
	}
	/**
	 * 获取  title
	 *@return String  图片标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 设置  title
	 *@param title  图片标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * 获取  pic
	 *@return String  图片路径
	 */
	public String getPic(){
		return this.pic;
	}

	/**
	 * 设置  pic
	 *@param pic  图片路径
	 */
	public void setPic(String pic){
		this.pic = pic;
	}
	/**
	 * 获取  link
	 *@return String  图片链接
	 */
	public String getLink(){
		return this.link;
	}

	/**
	 * 设置  link
	 *@param link  图片链接
	 */
	public void setLink(String link){
		this.link = link;
	}
	/**
	 * 获取  description
	 *@return String  图片描述
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param description  图片描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * 获取  listorder
	 *@return Integer  排序值（越小越在后面）
	 */
	public Integer getListorder(){
		return this.listorder;
	}

	/**
	 * 设置  listorder
	 *@param listorder  排序值（越小越在后面）
	 */
	public void setListorder(Integer listorder){
		this.listorder = listorder;
	}
	/**
	 * 获取  status
	 *@return String  是否显示 (1为显示 0为不显示)
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  是否显示 (1为显示 0为不显示)
	 */
	public void setStatus(String status){
		this.status = status;
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
	 *@return String   删除标记（0：正常；1：删除 ）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag   删除标记（0：正常；1：删除 ）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  remarks
	 *@return String  备注
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param remarks  备注
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	
}