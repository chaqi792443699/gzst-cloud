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
 * @title: cms_guestbook实体
 * @description: cms_guestbook实体
 * @author: 吴正军
 * @date: 2018-10-29 15:58:20
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_guestbook")
@SuppressWarnings("serial")
public class Guestbook extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**用户ID*/
    @TableField(value = "uid")
	private String uid;
    /**留言标题*/
    @TableField(value = "title")
	private String title;
    /**状态（1,已读 0,未读）*/
    @TableField(value = "status")
	private String status;
    /**留言时间*/
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@TableField(value = "dateline",fill = FieldFill.INSERT)
	private Date dateline;
    /**称呼*/
    @TableField(value = "author")
	private String author;
    /**电话或手机号*/
    @TableField(value = "telephone")
	private String telephone;
    /**邮箱*/
    @TableField(value = "email")
	private String email;
    /**留言内容*/
    @TableField(value = "content")
	private String content;
    /**留言IP*/
    @TableField(value = "ip")
	private String ip;
    /**站点ID*/
    @TableField(value = "site_id")
	private String siteId;
    /**用户名**/
    @TableField(exist=false)
    private String username;

	
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
	 * 获取  uid
	 *@return String  用户ID
	 */
	public String getUid(){
		return this.uid;
	}

	/**
	 * 设置  uid
	 *@param uid  用户ID
	 */
	public void setUid(String uid){
		this.uid = uid;
	}
	/**
	 * 获取  title
	 *@return String  留言标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 设置  title
	 *@param title  留言标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * 获取  status
	 *@return String  状态（1,已读 0,未读）
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  状态（1,已读 0,未读）
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  dateline
	 *@return Date  留言时间
	 */
	public Date getDateline(){
		return this.dateline;
	}

	/**
	 * 设置  dateline
	 *@param dateline  留言时间
	 */
	public void setDateline(Date dateline){
		this.dateline = dateline;
	}
	/**
	 * 获取  author
	 *@return String  称呼
	 */
	public String getAuthor(){
		return this.author;
	}

	/**
	 * 设置  author
	 *@param author  称呼
	 */
	public void setAuthor(String author){
		this.author = author;
	}
	/**
	 * 获取  telephone
	 *@return String  电话或手机号
	 */
	public String getTelephone(){
		return this.telephone;
	}

	/**
	 * 设置  telephone
	 *@param telephone  电话或手机号
	 */
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	/**
	 * 获取  email
	 *@return String  邮箱
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * 设置  email
	 *@param email  邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * 获取  content
	 *@return String  留言内容
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 * 设置  content
	 *@param content  留言内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * 获取  ip
	 *@return String  留言IP
	 */
	public String getIp(){
		return this.ip;
	}

	/**
	 * 设置  ip
	 *@param ip  留言IP
	 */
	public void setIp(String ip){
		this.ip = ip;
	}
	/**
	 * 获取  siteId
	 *@return String  站点ID
	 */
	public String getSiteId(){
		return this.siteId;
	}

	/**
	 * 设置  siteId
	 *@param siteId  站点ID
	 */
	public void setSiteId(String siteId){
		this.siteId = siteId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}