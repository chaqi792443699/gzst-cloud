package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.entity
 * @title: cms_site实体
 * @description: cms_site实体
 * @author: 吴正军
 * @date: 2018-10-29 17:32:14
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_site")
@SuppressWarnings("serial")
public class Site extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**站点名称*/
    @TableField(value = "name")
	private String name;
    /**标签*/
    @TableField(value = "tag")
	private String tag;
    /**域名*/
    @TableField(value = "domain")
	private String domain;
    /**SEO标题*/
    @TableField(value = "seo_title")
	private String seoTitle;
    /**SEO关键字*/
    @TableField(value = "seo_keywords")
	private String seoKeywords;
    /**SEO描述*/
    @TableField(value = "seo_description")
	private String seoDescription;
    /**管理角色**/
	@TableField(value = "manager")
    private String manager;

	@TableField(value = "editor")
	private String editor;

	@TableField(value = "auditor")
	private String auditor;

	@TableField(value = "enabled")
	private Integer enabled;

	@TableField(value = "logo")
	private String logo;
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
	 * 获取  name
	 *@return String  站点名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  站点名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  tag
	 *@return String  标签
	 */
	public String getTag(){
		return this.tag;
	}

	/**
	 * 设置  tag
	 *@param tag  标签
	 */
	public void setTag(String tag){
		this.tag = tag;
	}
	/**
	 * 获取  domain
	 *@return String  域名
	 */
	public String getDomain(){
		return this.domain;
	}

	/**
	 * 设置  domain
	 *@param domain  域名
	 */
	public void setDomain(String domain){
		this.domain = domain;
	}
	/**
	 * 获取  seoTitle
	 *@return String  SEO标题
	 */
	public String getSeoTitle(){
		return this.seoTitle;
	}

	/**
	 * 设置  seoTitle
	 *@param seoTitle  SEO标题
	 */
	public void setSeoTitle(String seoTitle){
		this.seoTitle = seoTitle;
	}
	/**
	 * 获取  seoKeywords
	 *@return String  SEO关键字
	 */
	public String getSeoKeywords(){
		return this.seoKeywords;
	}

	/**
	 * 设置  seoKeywords
	 *@param seoKeywords  SEO关键字
	 */
	public void setSeoKeywords(String seoKeywords){
		this.seoKeywords = seoKeywords;
	}
	/**
	 * 获取  seoDescription
	 *@return String  SEO描述
	 */
	public String getSeoDescription(){
		return this.seoDescription;
	}

	/**
	 * 设置  seoDescription
	 *@param seoDescription  SEO描述
	 */
	public void setSeoDescription(String seoDescription){
		this.seoDescription = seoDescription;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}