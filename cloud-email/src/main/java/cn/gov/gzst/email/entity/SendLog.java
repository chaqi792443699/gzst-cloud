package cn.gov.gzst.email.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.utils.AppUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.entity
 * @title: 发送日志实体
 * @description: 发送日志实体
 * @author: jianliaoliang
 * @date: 2018-04-24 11:24:16
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("email_send_log")
@SuppressWarnings("serial")
public class SendLog extends AbstractEntity<String> {

	public static final String EMAIL_SEND_STATUS_SUCCESS="1";
	public static final String EMAIL_SEND_STATUS_FAIL="-1";
	public static final String EMAIL_SEND_STATUS_IN="0";
    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**联系电话*/
    @TableField(value = "email")
	private String email;
    /**主题*/
    @TableField(value = "subject")
	private String subject;
    /**模板类型*/
    @TableField(value = "content")
	private String content;
    /**json格式保存历史*/
	@TableField(value = "send_data")
	private String sendData;
    @TableField(value = "send_code")
	private String sendCode;
    /**响应时间*/
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "response_date")
	private Date responseDate;
	/**重试次数*/
	@TableField(value = "try_num")
	private Integer tryNum;
    /**返回消息*/
    @TableField(value = "msg")
	private String msg;
    /**发送状态*/
    @TableField(value = "status")
	private String status;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;

	@TableField(value = "app_id")
	protected String appId; // 应用

	@TableField(exist = false)
	private String appName;
	
	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  email
	 *@return String  联系电话
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * 设置  email
	 *@param email  联系电话
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * 获取  subject
	 *@return String  主题
	 */
	public String getSubject(){
		return this.subject;
	}

	/**
	 * 设置  subject
	 *@param subject  主题
	 */
	public void setSubject(String subject){
		this.subject = subject;
	}
	/**
	 * 获取  content
	 *@return String  模板类型
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 * 设置  content
	 *@param content  模板类型
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * 获取  responseDate
	 *@return Date  响应时间
	 */
	public Date getResponseDate(){
		return this.responseDate;
	}

	/**
	 * 设置  responseDate
	 *@param responseDate  响应时间
	 */
	public void setResponseDate(Date responseDate){
		this.responseDate = responseDate;
	}

	public Integer getTryNum() {
		return tryNum;
	}

	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
	}

	/**
	 * 获取  msg
	 *@return String  返回消息
	 */
	public String getMsg(){
		return this.msg;
	}

	/**
	 * 设置  msg
	 *@param msg  返回消息
	 */
	public void setMsg(String msg){
		this.msg = msg;
	}
	/**
	 * 获取  status
	 *@return String  发送状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  发送状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  delFlag
	 *@return String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  remarks
	 *@return String  备注信息
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param remarks  备注信息
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}

	public String getSendCode() {
		return sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	public String getSendData() {
		return sendData;
	}

	public void setSendData(String sendData) {
		this.sendData = sendData;
	}


	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 *
	 * @return
	 */
	public String getAppName() {
		if (!StringUtils.isEmpty(appId)&& AppUtils.getApp(appId)!=null){
			appName = AppUtils.getApp(appId).getTitle();
		}
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}