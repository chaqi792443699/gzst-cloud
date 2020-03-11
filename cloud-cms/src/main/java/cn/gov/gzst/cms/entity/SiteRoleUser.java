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
 * @title: cms_site_role_user实体
 * @description: cms_site_role_user实体
 * @author: wuzhengjun
 * @date: 2018-11-23 09:15:43
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_site_role_user")
@SuppressWarnings("serial")
public class SiteRoleUser extends AbstractEntity<String> {

    /**站点角色用户id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**站点id*/
    @TableField(value = "site_id")
	private String siteId;
    /**角色id*/
    @TableField(value = "role_id")
	private String roleId;
    /**人员id*/
    @TableField(value = "user_id")
	private String userId;
	@TableField(exist = false)
    private String username;
	@TableField(exist = false)
	private String rolename;
	@TableField(exist = false)
	private String roleIds;
	
	/**
	 * 获取  id
	 *@return String  站点角色用户id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  站点角色用户id
	 */
	public void setId(String id){
		this.id = id;
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
	 * 获取  roleId
	 *@return String  角色id
	 */
	public String getRoleId(){
		return this.roleId;
	}

	/**
	 * 设置  roleId
	 *@param roleId  角色id
	 */
	public void setRoleId(String roleId){
		this.roleId = roleId;
	}
	/**
	 * 获取  userId
	 *@return String  人员id
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 * 设置  userId
	 *@param userId  人员id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
}