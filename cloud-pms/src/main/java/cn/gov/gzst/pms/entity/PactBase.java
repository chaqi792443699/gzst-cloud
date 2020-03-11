package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.base.BaseEntity;
import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 合同-编号及关联信息表
 * @Description: 合同-编号及关联信息表
 * @author 李佳芹
 * @date 2017-09-11 15:42:10
 * @version V1.0   
 *
 */
@TableName("PACT_BASE")
@SuppressWarnings("serial")
public class PactBase extends BaseEntity {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**项目ID*/
    @TableField(value = "projectid")
	private String projectid;
    /**合同编码*/
    @TableField(value = "pactno")
	private String pactno;
    /**创建人ID*/
    @TableField(value = "createuserid")
	private String createuserid;
    /**PACTSTATUS*/
    @TableField(value = "pactstatus")
	private String pactstatus;
    /**合同审核*/
    @TableField(value = "status")
	private String status;
    /**分配时间*/
    @TableField(value = "createtime")
	private Date createtime;
    /**申报人ID*/
    @TableField(value = "declarantid")
	private String declarantid;
    /**申报人企业ID*/
    @TableField(value = "declarantdepartid")
	private String declarantdepartid;
    /**归口审核状态*/
    @TableField(value = "managementstatus")
	private String managementstatus;
	
	/**
	 * 获取  id
	 *@return: String  ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  projectid
	 *@return: String  项目ID
	 */
	public String getProjectid(){
		return this.projectid;
	}

	/**
	 * 设置  projectid
	 *@param: projectid  项目ID
	 */
	public void setProjectid(String projectid){
		this.projectid = projectid;
	}
	/**
	 * 获取  pactno
	 *@return: String  合同编码
	 */
	public String getPactno(){
		return this.pactno;
	}

	/**
	 * 设置  pactno
	 *@param: pactno  合同编码
	 */
	public void setPactno(String pactno){
		this.pactno = pactno;
	}
	/**
	 * 获取  createuserid
	 *@return: String  创建人ID
	 */
	public String getCreateuserid(){
		return this.createuserid;
	}

	/**
	 * 设置  createuserid
	 *@param: createuserid  创建人ID
	 */
	public void setCreateuserid(String createuserid){
		this.createuserid = createuserid;
	}
	/**
	 * 获取  pactstatus
	 *@return: String  PACTSTATUS
	 */
	public String getPactstatus(){
		return this.pactstatus;
	}

	/**
	 * 设置  pactstatus
	 *@param: pactstatus  PACTSTATUS
	 */
	public void setPactstatus(String pactstatus){
		this.pactstatus = pactstatus;
	}
	/**
	 * 获取  status
	 *@return: String  合同审核
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param: status  合同审核
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  createtime
	 *@return: Date  分配时间
	 */
	public Date getCreatetime(){
		return this.createtime;
	}

	/**
	 * 设置  createtime
	 *@param: createtime  分配时间
	 */
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	/**
	 * 获取  declarantid
	 *@return: String  申报人ID
	 */
	public String getDeclarantid(){
		return this.declarantid;
	}

	/**
	 * 设置  declarantid
	 *@param: declarantid  申报人ID
	 */
	public void setDeclarantid(String declarantid){
		this.declarantid = declarantid;
	}
	/**
	 * 获取  declarantdepartid
	 *@return: String  申报人企业ID
	 */
	public String getDeclarantdepartid(){
		return this.declarantdepartid;
	}

	/**
	 * 设置  declarantdepartid
	 *@param: declarantdepartid  申报人企业ID
	 */
	public void setDeclarantdepartid(String declarantdepartid){
		this.declarantdepartid = declarantdepartid;
	}
	/**
	 * 获取  managementstatus
	 *@return: String  归口审核状态
	 */
	public String getManagementstatus(){
		return this.managementstatus;
	}

	/**
	 * 设置  managementstatus
	 *@param: managementstatus  归口审核状态
	 */
	public void setManagementstatus(String managementstatus){
		this.managementstatus = managementstatus;
	}
	
}
