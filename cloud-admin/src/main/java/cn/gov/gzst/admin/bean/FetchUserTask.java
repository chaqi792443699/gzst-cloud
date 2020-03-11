package cn.gov.gzst.admin.bean;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.utils.StringUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti.entity
 * @title: 查找用户任务实体
 * @description: 查找用户任务实体
 * @author: jianliaoliang
 * @date: 2018-06-29 10:28:22
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("act_fetch_user_task")
@SuppressWarnings("serial")
public class FetchUserTask extends AbstractEntity<String> {

	public static final String FETCH_STATUS_WAIT="0";
	public static final String FETCH_STATUS_FAIL="-1";
	public static final String FETCH_STATUS_SUCCESS="1";


    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
	/**角色编码*/
	@TableField(value = "task_id")
	private String taskId;
    /**用户ID*/
    @TableField(value = "uid")
	private String uid;
    /**企业ID*/
    @TableField(value = "eid")
	private String eid;
	@TableField(value = "submit_uid")
	private String submitUid;
	@TableField(value = "submit_eid")
    private String submitEid;
    /**提交变量内容*/
    @TableField(value = "variables")
	private String variables;
    /**企业类型*/
    @TableField(value = "enterprise_type")
	private String enterpriseType;
    /**企业类型*/
    @TableField(value = "enterprise_value")
	private String enterpriseValue;
	@TableField(value = "is_corporation")
	private String isCorporation;
    /**角色编码*/
    @TableField(value = "role_code")
	private String roleCode;
    /**查找Url*/
    @TableField(value = "fetch_user_url")
	private String fetchUserUrl;
    /**添加时间*/
    @TableField(value = "add_date")
	private Date addDate;
    /**查找状态*/
    @TableField(value = "fetch_status")
	private String fetchStatus = FetchUserTask.FETCH_STATUS_WAIT;
    /**查找时间*/
    @TableField(value = "fetch_time")
	private Date fetchTime;
    /**响应消息*/
    @TableField(value = "fetch_msg")
	private String fetchMsg;
	
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

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
	 * 获取  eid
	 *@return String  企业ID
	 */
	public String getEid(){
		return this.eid;
	}

	/**
	 * 设置  eid
	 *@param eid  企业ID
	 */
	public void setEid(String eid){
		this.eid = eid;
	}
	/**
	 * 获取  variables
	 *@return String  提交变量内容
	 */
	public String getVariables(){
		return this.variables;
	}

	/**
	 * 设置  variables
	 *@param variables  提交变量内容
	 */
	public void setVariables(String variables){
		this.variables = variables;
	}
	/**
	 * 获取  enterpriseType
	 *@return String  企业类型
	 */
	public String getEnterpriseType(){
		return this.enterpriseType;
	}

	/**
	 * 设置  enterpriseType
	 *@param enterpriseType  企业类型
	 */
	public void setEnterpriseType(String enterpriseType){
		this.enterpriseType = enterpriseType;
	}
	/**
	 * 获取  enterpriseValue
	 *@return String  企业类型
	 */
	public String getEnterpriseValue(){
		return this.enterpriseValue;
	}

	/**
	 * 设置  enterpriseValue
	 *@param enterpriseValue  企业类型
	 */
	public void setEnterpriseValue(String enterpriseValue){
		this.enterpriseValue = enterpriseValue;
	}

	public String getIsCorporation() {
		if (StringUtils.isEmpty(isCorporation)){
			isCorporation = "1";
		}
		return isCorporation;
	}

	public void setIsCorporation(String isCorporation) {
		this.isCorporation = isCorporation;
	}

	/**
	 * 获取  roleCode
	 *@return String  角色编码
	 */
	public String getRoleCode(){
		return this.roleCode;
	}

	/**
	 * 设置  roleCode
	 *@param roleCode  角色编码
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	/**
	 * 获取  fetchUserUrl
	 *@return String  查找Url
	 */
	public String getFetchUserUrl(){
		return this.fetchUserUrl;
	}

	/**
	 * 设置  fetchUserUrl
	 *@param fetchUserUrl  查找Url
	 */
	public void setFetchUserUrl(String fetchUserUrl){
		this.fetchUserUrl = fetchUserUrl;
	}
	/**
	 * 获取  addDate
	 *@return Date  添加时间
	 */
	public Date getAddDate(){
		return this.addDate;
	}

	/**
	 * 设置  addDate
	 *@param addDate  添加时间
	 */
	public void setAddDate(Date addDate){
		this.addDate = addDate;
	}
	/**
	 * 获取  fetchStatus
	 *@return String  查找状态
	 */
	public String getFetchStatus(){
		return this.fetchStatus;
	}

	/**
	 * 设置  fetchStatus
	 *@param fetchStatus  查找状态
	 */
	public void setFetchStatus(String fetchStatus){
		this.fetchStatus = fetchStatus;
	}
	/**
	 * 获取  fetchTime
	 *@return Date  查找时间
	 */
	public Date getFetchTime(){
		return this.fetchTime;
	}

	/**
	 * 设置  fetchTime
	 *@param fetchTime  查找时间
	 */
	public void setFetchTime(Date fetchTime){
		this.fetchTime = fetchTime;
	}
	/**
	 * 获取  fetchMsg
	 *@return String  响应消息
	 */
	public String getFetchMsg(){
		return this.fetchMsg;
	}

	/**
	 * 设置  fetchMsg
	 *@param fetchMsg  响应消息
	 */
	public void setFetchMsg(String fetchMsg){
		this.fetchMsg = fetchMsg;
	}

	public String getSubmitUid() {
		return submitUid;
	}

	public void setSubmitUid(String submitUid) {
		this.submitUid = submitUid;
	}

	public String getSubmitEid() {
		return submitEid;
	}

	public void setSubmitEid(String submitEid) {
		this.submitEid = submitEid;
	}
}