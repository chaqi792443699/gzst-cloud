package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title: sys_user实体
 * @description: sys_user实体
 * @author: wuzhengjun
 * @date: 2018-12-17 11:23:32
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("sys_user")
@SuppressWarnings("serial")
public class User extends AbstractEntity<String> {

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**登录账户名*/
    @TableField(value = "user_name")
	private String username;
	/**真实姓名*/
	@TableField(value = "real_name")
    private String realName;
    /**称谓/昵称*/
    @TableField(value = "show_name")
	private String showName;
    /**证件号码(个人身份证或企业统一社会信用代码)*/
    @TableField(value = "certi_num")
	private String certiNum;
    /**存放证件类型，用数字标识*/
    @TableField(value = "certi_type")
	private String certiType;
    /**用户类型（1.个人；2.企业）决定信息扩展表表名*/
    @TableField(value = "type")
	private Integer type;
    /**mobile*/
    @TableField(value = "mobile")
	private String mobile;
    /**登陆密码*/
    @TableField(value = "password")
	private String password;

    @TableField(exist = false)
    private String repassword;
    /**密码加盐*/
    @TableField(value = "salt")
	private String salt;
    /**用户启用状态(1 启用，2 禁用)*/
    @TableField(value = "status")
	private Integer status;
    /**头像*/
    @TableField(value = "avatar")
	private String avatar;
    /**注册时间*/
    @TableField(value = "register_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date registerDate;
    /**注册IP*/
    @TableField(value = "register_ip")
	private String registerIp;
    /**login_date*/
    @TableField(value = "login_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date loginDate;
    /**login_ip*/
    @TableField(value = "login_ip")
	private String loginIp;
    /**注册地址，通过计算IP获得*/
    @TableField(value = "register_addr")
	private String registerAddr;

    /**用户角色*/
    @TableField(exist = false)
    private List<Role> roles;
	/**用户权限*/
	@TableField(exist = false)
    private List<SecAuthority> authorities;

	/**用户附加信息*/
	@TableField(exist = false)
	private SysUserInfo userInfo;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
        this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取  showName
	 *@return String  称谓/昵称
	 */
	public String getShowName(){
		return this.showName;
	}

	/**
	 * 设置  showName
	 *@param showName  称谓/昵称
	 */
	public void setShowName(String showName){
		this.showName = showName;
	}
	/**
	 * 获取  certiNum
	 *@return String  证件号码(个人身份证或企业统一社会信用代码)
	 */
	public String getCertiNum(){
		return this.certiNum;
	}

	/**
	 * 设置  certiNum
	 *@param certiNum  证件号码(个人身份证或企业统一社会信用代码)
	 */
	public void setCertiNum(String certiNum){
		this.certiNum = certiNum;
	}
	/**
	 * 获取  certiType
	 *@return String  存放证件类型，用数字标识
	 */
	public String getCertiType(){
		return this.certiType;
	}

	/**
	 * 设置  certiType
	 *@param certiType  存放证件类型，用数字标识
	 */
	public void setCertiType(String certiType){
		this.certiType = certiType;
	}
	/**
	 * 获取  type
	 *@return String  用户类型（1.个人；2.企业）决定信息扩展表表名
	 */
	public Integer getType(){
		return this.type;
	}

	/**
	 * 设置  type
	 *@param type  用户类型（1.个人；2.企业）决定信息扩展表表名
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 * 获取  mobile
	 *@return String  mobile
	 */
	public String getMobile(){
		return this.mobile;
	}

	/**
	 * 设置  mobile
	 *@param mobile  mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	/**
	 * 获取  password
	 *@return String  登陆密码
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 * 设置  password
	 *@param password  登陆密码
	 */
	public void setPassword(String password){
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	/**
	 * 获取  salt
	 *@return String  密码加盐
	 */
	public String getSalt(){
		return this.salt;
	}

	/**
	 * 设置  salt
	 *@param salt  密码加盐
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}
	/**
	 * 获取  status
	 *@return String  用户启用状态(1 启用，2 禁用)
	 */
	public Integer getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  用户启用状态(1 启用，2 禁用)
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	/**
	 * 获取  avatar
	 *@return String  头像
	 */
	public String getAvatar(){
		return this.avatar;
	}

	/**
	 * 设置  avatar
	 *@param avatar  头像
	 */
	public void setAvatar(String avatar){
		this.avatar = avatar;
	}
	/**
	 * 获取  registerDate
	 *@return Date  注册时间
	 */
	public Date getRegisterDate(){
		return this.registerDate;
	}

	/**
	 * 设置  registerDate
	 *@param registerDate  注册时间
	 */
	public void setRegisterDate(Date registerDate){
		this.registerDate = registerDate;
	}
	/**
	 * 获取  registerIp
	 *@return String  注册IP
	 */
	public String getRegisterIp(){
		return this.registerIp;
	}

	/**
	 * 设置  registerIp
	 *@param registerIp  注册IP
	 */
	public void setRegisterIp(String registerIp){
		this.registerIp = registerIp;
	}
	/**
	 * 获取  loginDate
	 *@return Date  login_date
	 */
	public Date getLoginDate(){
		return this.loginDate;
	}

	/**
	 * 设置  loginDate
	 *@param loginDate  login_date
	 */
	public void setLoginDate(Date loginDate){
		this.loginDate = loginDate;
	}
	/**
	 * 获取  loginIp
	 *@return String  login_ip
	 */
	public String getLoginIp(){
		return this.loginIp;
	}

	/**
	 * 设置  loginIp
	 *@param loginIp  login_ip
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	/**
	 * 获取  registerAddr
	 *@return String  注册地址，通过计算IP获得
	 */
	public String getRegisterAddr(){
		return this.registerAddr;
	}

	/**
	 * 设置  registerAddr
	 *@param registerAddr  注册地址，通过计算IP获得
	 */
	public void setRegisterAddr(String registerAddr){
		this.registerAddr = registerAddr;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	/**
	 * 用户角色清单
	 * @return
	 */
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<SecAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<SecAuthority> authorities) {
		this.authorities = authorities;
	}

	public SysUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUserInfo userInfo) {
		this.userInfo = userInfo;
	}
}