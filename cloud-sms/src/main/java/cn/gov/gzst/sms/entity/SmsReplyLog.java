package cn.gov.gzst.sms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.sms.utils.AppUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 短信回复日志
 * @Description: 短信回复日志
 * @author jianliaoliang
 * @date 2017-10-10 16:23:09
 * @version V1.0   
 *
 */
@TableName("sms_reply_log")
@SuppressWarnings("serial")
public class SmsReplyLog extends AbstractEntity<String> {

	public static  final  String SMS_REPLY_DEAL_SUCCESS="1";
	public static  final  String SMS_REPLY_DEAL_FAIL="-1";
	public static  final  String SMS_REPLY_DEAL_IN="0";
    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**联系电话*/
    @TableField(value = "phone")
	private String phone;
    /**发送消息ID*/
    @TableField(value = "smsid")
	private String smsid;
	@TableField(value = "send_smsid")
    private String sendSmsid;
    /**回复内容*/
    @TableField(value = "content")
	private String content;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**回复的时间*/
    @TableField(value = "reply_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date replyDate;
	/**重试次数*/
	@TableField(value = "try_num")
    private Integer tryNum;
	@TableField(value = "deal_flag")
    private String dealFlag;
	@TableField(value = "app_id")
	protected String appId; // 应用
	@TableField(exist = false)
	private String appName;
	/**
	 * 获取  id
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  phone
	 *@return: String  联系电话
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 * 设置  phone
	 *@param: phone  联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * 获取  smsid
	 *@return: String  发送消息ID
	 */
	public String getSmsid(){
		return this.smsid;
	}

	/**
	 * 设置  smsid
	 *@param: smsid  发送消息ID
	 */
	public void setSmsid(String smsid){
		this.smsid = smsid;
	}

	public String getSendSmsid() {
		return sendSmsid;
	}

	public void setSendSmsid(String sendSmsid) {
		this.sendSmsid = sendSmsid;
	}

	/**
	 * 获取  content
	 *@return: String  回复内容
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 * 设置  content
	 *@param: content  回复内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * 获取  delFlag
	 *@return: String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  replyDate
	 *@return: Date  回复的时间
	 */
	public Date getReplyDate(){
		return this.replyDate;
	}

	/**
	 * 设置  replyDate
	 *@param: replyDate  回复的时间
	 */
	public void setReplyDate(Date replyDate){
		this.replyDate = replyDate;
	}

	public Integer getTryNum() {
		return tryNum;
	}

	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
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
