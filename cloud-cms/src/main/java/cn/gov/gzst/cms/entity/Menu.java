package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.TreeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * CMS菜单实体
 */

@TableName("cms_menu")
@SuppressWarnings("serial")
public class Menu extends TreeEntity<Menu> {

    /**菜单id*/
    @TableField(value = "id")
	private String id;
    /**菜单名称*/
    @TableField(value = "name")
	private String name;
    /**菜单标签*/
    @TableField(value = "alias")
	private String  alias;
    /**菜单描述*/
    @TableField(value = "description")
	private String description;
    /**路径*/
    @TableField(value = "url")
	private String url;
    /**父级id*/
    @TableField(value = "parent_id")
	private String parentId;
    /**菜单位置*/
    @TableField(value = "position")
	private String position;
    /**排序*/
    @TableField(value = "sort")
	private Short sort;
    /**图标*/
    @TableField(value = "icon")
	private String icon;
    /**站点id*/
    @TableField(value = "site_id")
	private String siteId;
    /**是否显示（1，显示，0不显示）*/
    @TableField(value = "status")
	private String status;
    /**是否打开二级页面（1:打开，0:不打开）*/
    @TableField(value = "blank")
	private Integer blank;
	/**菜单类型*/
	@TableField(value = "type")
	private String type;

	@TableField(exist = false)
	private String parents;

	/**
	 * 获取  id
	 *@return String  菜单id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  菜单id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  菜单名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  菜单名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取   alias
	 *@return String  菜单标签
	 */
	public String getAlias(){
		return this.alias;
	}

	/**
	 * 设置   alias
	 *@param  alias  菜单标签
	 */
	public void setAlias(String  alias){
		this.alias =  alias;
	}
	/**
	 * 获取  description
	 *@return String  菜单描述
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param description  菜单描述
	 */
	public void setDescription(String description){
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getParentId() {
		return parentId;
	}

	@Override
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取  position
	 *@return String  菜单位置
	 */
	public String getPosition(){
		return this.position;
	}

	/**
	 * 设置  position
	 *@param position  菜单位置
	 */
	public void setPosition(String position){
		this.position = position;
	}
	/**
	 * 获取  sort
	 *@return Short  排序
	 */
	public Short getSort(){
		return this.sort;
	}

	/**
	 * 设置  sort
	 *@param sort  排序
	 */
	public void setSort(Short sort){
		this.sort = sort;
	}
	/**
	 * 获取  icon
	 *@return String  图标
	 */
	public String getIcon(){
		return this.icon;
	}

	/**
	 * 设置  icon
	 *@param icon  图标
	 */
	public void setIcon(String icon){
		this.icon = icon;
	}
	/**
	 * 获取  siteId
	 *@return String  站点id
	 */
	public String getSiteId(){
		return this.siteId;
	}

	/**
	 * 设置  siteId
	 *@param siteId  站点id
	 */
	public void setSiteId(String siteId){
		this.siteId = siteId;
	}
	/**
	 * 获取  status
	 *@return String  是否显示（1，显示，0不显示）
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  是否显示（1，显示，0不显示）
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  blank
	 *@return String  是否打开二级页面（1:打开，0:不打开）
	 */
	public Integer getBlank(){
		return this.blank;
	}

	/**
	 * 设置  blank
	 *@param blank  是否打开二级页面（1:打开，0:不打开）
	 */
	public void setBlank(Integer blank){
		this.blank = blank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParents() {
		return parents;
	}

	public void setParents(String parents) {
		this.parents = parents;
	}
}