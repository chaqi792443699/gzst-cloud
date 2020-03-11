package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.alibaba.fastjson.annotation.JSONField;
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
 * @title: 文章管理实体
 * @description: 文章管理实体
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:29
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_article")
@SuppressWarnings("serial")
public class Article extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**分类ID*/
    @TableField(value = "cid")
	private String cid;
    /**标题*/
    @TableField(value = "title")
	private String title;
    /**标题颜色*/
    @TableField(value = "color")
	private String color;
    /**英文别名*/
    @TableField(value = "alias")
	private String alias;
    /**标签 (json数据)*/
    @TableField(value = "keywords")
	private String keywords;
    /**摘要*/
    @TableField(value = "description")
	private String description;
	/**内容*/
	@TableField(value = "content")
	private String content;
    /**缩略图*/
    @TableField(value = "thumb")
	private String thumb;
    /**作者*/
    @TableField(value = "author")
	private String author;
    /**来源*/
    @TableField(value = "source")
	private String source;
    /**排序值（越小越在后面）*/
    @TableField(value = "listorder")
	private String listorder;
    /**是否显示*/
    @TableField(value = "if_show")
	private String ifShow;
	/**发布时间*/
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@TableField(value = "dateline")
    private Date dateline;
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
	/**推荐**/
	@TableField(value = "recommend")
	private String recommend;
	/**阅读量**/
	@TableField(value = "reading")
	private Integer reading;
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
	 * 获取  cid
	 *@return String  分类ID
	 */
	public String getCid(){
		return this.cid;
	}

	/**
	 * 设置  cid
	 *@param cid  分类ID
	 */
	public void setCid(String cid){
		this.cid = cid;
	}
	/**
	 * 获取  title
	 *@return String  标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 设置  title
	 *@param title  标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * 获取  color
	 *@return String  标题颜色
	 */
	public String getColor(){
		return this.color;
	}

	/**
	 * 设置  color
	 *@param color  标题颜色
	 */
	public void setColor(String color){
		this.color = color;
	}
	/**
	 * 获取  alias
	 *@return String  英文别名
	 */
	public String getAlias(){
		return this.alias;
	}

	/**
	 * 设置  alias
	 *@param alias  英文别名
	 */
	public void setAlias(String alias){
		this.alias = alias;
	}
	/**
	 * 获取  keywords
	 *@return String  标签 (json数据)
	 */
	public String getKeywords(){
		return this.keywords;
	}

	/**
	 * 设置  keywords
	 *@param keywords  标签 (json数据)
	 */
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
	/**
	 * 获取  description
	 *@return String  摘要
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param description  摘要
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * 获取  content
	 *@return String  内容
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 * 设置  content
	 *@param content  内容
	 */
	public void setContent(String content){
		this.content = content;
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
	 * 获取  author
	 *@return String  作者
	 */
	public String getAuthor(){
		return this.author;
	}

	/**
	 * 设置  author
	 *@param author  作者
	 */
	public void setAuthor(String author){
		this.author = author;
	}
	/**
	 * 获取  source
	 *@return String  来源
	 */
	public String getSource(){
		return this.source;
	}

	/**
	 * 设置  source
	 *@param source  来源
	 */
	public void setSource(String source){
		this.source = source;
	}
	/**
	 * 获取  listorder
	 *@return String  排序值（越小越在后面）
	 */
	public String getListorder(){
		return this.listorder;
	}

	/**
	 * 设置  listorder
	 *@param listorder  排序值（越小越在后面）
	 */
	public void setListorder(String listorder){
		this.listorder = listorder;
	}
	/**
	 * 获取  ifShow
	 *@return String  是否显示
	 */
	public String getIfShow(){
		return this.ifShow;
	}

	/**
	 * 设置  ifShow
	 *@param ifShow  是否显示
	 */
	public void setIfShow(String ifShow){
		this.ifShow = ifShow;
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

	public Date getDateline() {
		return dateline;
	}

	public void setDateline(Date dateline) {
		this.dateline = dateline;
	}

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }
}