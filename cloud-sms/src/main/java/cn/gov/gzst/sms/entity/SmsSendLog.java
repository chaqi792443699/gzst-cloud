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
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@TableName("sms_send_log")
@SuppressWarnings("serial")
public class SmsSendLog extends AbstractEntity<String> {

	public static final String SMS_SEND_STATUS_SUCCESS="1";
	public static final String SMS_SEND_STATUS_FAIL="-1";
	public static final String SMS_SEND_STATUS_IN="0";
	/** 字段主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 联系电话 */
	private String phone;
	/** 内容 */
	private String content;
	/** 模板ID */
	private String templateId;
	/** 发送状态 */
	private String status; // 0发送中，1成功，-1失败
	/** 发送响应消息ID */
	private String smsid;
	/** 返回码 */
	private String code;
	/** 返回消息 */
	private String msg;
	/** 删除标记（0：正常；1：删除） */
	private String delFlag;
	/** 响应时间 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date responseDate;
	/** 发送的数据 */
	private String sendData;
	/** 发送的编码 */
	private String sendCode;
	/** 发送的smsid */
	private String sendSmsid;

	/**重试次数*/
	@TableField(value = "try_num")
	private Integer tryNum;

	@TableField(value = "app_id")
	protected String appId; // 应用

	@TableField(exist = false)
	private String appName;

	/**
	 * 获取 id
	 * 
	 * @return: String 字段主键
	 */

	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             字段主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 phone
	 * 
	 * @return: String 联系电话
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 设置 phone
	 * 
	 * @param: phone
	 *             联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取 templateId
	 * 
	 * @return: String 模板ID
	 */
	public String getTemplateId() {
		return this.templateId;
	}

	/**
	 * 设置 templateId
	 * 
	 * @param: templateId
	 *             模板ID
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * 获取 status
	 * 
	 * @return: String 发送状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置 status
	 * 
	 * @param: status
	 *             发送状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取 smsid
	 * 
	 * @return: String 发送响应消息ID
	 */
	public String getSmsid() {
		return this.smsid;
	}

	/**
	 * 设置 smsid
	 * 
	 * @param: smsid
	 *             发送响应消息ID
	 */
	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	/**
	 * 获取 code
	 * 
	 * @return: String 返回码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 code
	 * 
	 * @param: code
	 *             返回码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取 msg
	 * 
	 * @return: String 返回消息
	 */
	public String getMsg() {
		return this.msg;
	}

	/**
	 * 设置 msg
	 * 
	 * @param: msg
	 *             返回消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取 delFlag
	 * 
	 * @return: String 删除标记（0：正常；1：删除）
	 */
	public String getDelFlag() {
		return this.delFlag;
	}

	/**
	 * 设置 delFlag
	 * 
	 * @param: delFlag
	 *             删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取 responseDate
	 * 
	 * @return: Date 响应时间
	 */
	public Date getResponseDate() {
		return this.responseDate;
	}

	/**
	 * 设置 responseDate
	 * 
	 * @param: responseDate
	 *             响应时间
	 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSendData() {
		return sendData;
	}

	public void setSendData(String sendData) {
		this.sendData = sendData;
	}

	public String getSendCode() {
		return sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	public String getSendSmsid() {
		return sendSmsid;
	}

	public void setSendSmsid(String sendSmsid) {
		this.sendSmsid = sendSmsid;
	}

	public Integer getTryNum() {
		return tryNum;
	}

	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
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
