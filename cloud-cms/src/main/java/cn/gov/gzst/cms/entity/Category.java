package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.TreeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.entity
 * @title: 栏目管理实体
 * @description: 栏目管理实体
 * @author: jianliaoliang
 * @date: 2018-05-02 08:54:12
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_category")
@SuppressWarnings("serial")
public class Category extends TreeEntity<Category> {

	/**内容模型ID*/
	@TableField(value = "mid")
	private String mid;
	/**类型 (0为列表，1为频道)*/
	@TableField(value = "type")
	private String type;
	/**唯一别名 (必填，只能是英文、数字、下划线，并且不超过50个字符，用于伪静态)*/
	@TableField(value = "alias")
	private String alias;
	/**缩略图*/
	@TableField(value = "thumb")
	private String thumb;
	/**分类介绍*/
	@TableField(value = "description")
	private String description;
	/**内容数*/
	@TableField(value = "count")
	private Integer count;
	/**排序*/
	@TableField(value = "listorder")
	private Short listorder;
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
	/**站点id**/
	@TableField(value = "site_id")
	private String siteId;
	/**内容**/
	@TableField(value = "content")
	private String content;

	@TableField(exist = false)
	private String parents;

	@TableField(value = "index_tpl")
	private String indexTpl;

	@TableField(value = "list_tpl")
	private String listTpl;

	@TableField(value = "show_tpl")
	private String showTpl;

	@TableField(value = "seo_title")
	private String seoTitle;

	@TableField(value = "seo_keywords")
	private String seoKeywords;

	@TableField(value = "seo_description")
	private String seoDescription;

	/**
	 * 获取  mid
	 *@return String  内容模型ID
	 */
	public String getMid(){
		return this.mid;
	}

	/**
	 * 设置  mid
	 *@param mid  内容模型ID
	 */
	public void setMid(String mid){
		this.mid = mid;
	}
	/**
	 * 获取  type
	 *@return String  类型 (0为列表，1为频道)
	 */
	public String getType(){
		return this.type;
	}

	/**
	 * 设置  type
	 *@param type  类型 (0为列表，1为频道)
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 * 获取  alias
	 *@return String  唯一别名 (必填，只能是英文、数字、下划线，并且不超过50个字符，用于伪静态)
	 */
	public String getAlias(){
		return this.alias;
	}

	/**
	 * 设置  alias
	 *@param alias  唯一别名 (必填，只能是英文、数字、下划线，并且不超过50个字符，用于伪静态)
	 */
	public void setAlias(String alias){
		this.alias = alias;
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
	 * 获取  description
	 *@return String  分类介绍
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param description  分类介绍
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * 获取  count
	 *@return Integer  内容数
	 */
	public Integer getCount(){
		return this.count;
	}

	/**
	 * 设置  count
	 *@param count  内容数
	 */
	public void setCount(Integer count){
		this.count = count;
	}
	/**
	 * 获取  listorder
	 *@return Short  排序
	 */
	public Short getListorder(){
		return this.listorder;
	}

	/**
	 * 设置  listorder
	 *@param listorder  排序
	 */
	public void setListorder(Short listorder){
		this.listorder = listorder;
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

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParents() {
		return parents;
	}

	public void setParents(String parents) {
		this.parents = parents;
	}

	public String getIndexTpl() {
		return indexTpl;
	}

	public void setIndexTpl(String indexTpl) {
		this.indexTpl = indexTpl;
	}

	public String getListTpl() {
		return listTpl;
	}

	public void setListTpl(String listTpl) {
		this.listTpl = listTpl;
	}

	public String getShowTpl() {
		return showTpl;
	}

	public void setShowTpl(String showTpl) {
		this.showTpl = showTpl;
	}


	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
}