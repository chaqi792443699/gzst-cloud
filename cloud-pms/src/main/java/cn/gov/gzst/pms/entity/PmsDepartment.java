package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**   
 * @Title: 部门
 * @Description: 部门
 * @author wuzhengjun
 * @date 2019-04-24 16:12:34
 * @version V1.0   
 *
 */
@TableName("PMS_DEPARTMENT")
@SuppressWarnings("serial")
public class PmsDepartment extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**部门名称*/
    @TableField(value = "name")
	private String name;
    /**部门编号*/
    @TableField(value = "departmentcode")
	private String departmentcode;
    /**上级部门名称*/
    @TableField(value = "adminname")
	private String adminname;
    /**上级部门编码*/
    @TableField(value = "admincode")
	private String admincode;
    /**部门负责人*/
    @TableField(value = "leader")
	private String leader;
    /**部门简称*/
    @TableField(value = "shortname")
	private String shortname;
    /**部门简介*/
    @TableField(value = "memo")
	private String memo;
    /**所属企业ID(PMS_ENTERPRISE)*/
    @TableField(value = "enterpriseid")
	private String enterpriseid;
    /**部门状态 1 执行部门，2查看部门，3不可用*/
    @TableField(value = "enable")
	private String enable;
    /**是否业务处室*/
    @TableField(value = "isbusiness")
	private String isbusiness;
    /**是否牵头处室*/
    @TableField(value = "islead")
	private String islead;
	
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
	 * 获取  name
	 *@return: String  部门名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  部门名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  departmentcode
	 *@return: String  部门编号
	 */
	public String getDepartmentcode(){
		return this.departmentcode;
	}

	/**
	 * 设置  departmentcode
	 *@param: departmentcode  部门编号
	 */
	public void setDepartmentcode(String departmentcode){
		this.departmentcode = departmentcode;
	}
	/**
	 * 获取  adminname
	 *@return: String  上级部门名称
	 */
	public String getAdminname(){
		return this.adminname;
	}

	/**
	 * 设置  adminname
	 *@param: adminname  上级部门名称
	 */
	public void setAdminname(String adminname){
		this.adminname = adminname;
	}
	/**
	 * 获取  admincode
	 *@return: String  上级部门编码
	 */
	public String getAdmincode(){
		return this.admincode;
	}

	/**
	 * 设置  admincode
	 *@param: admincode  上级部门编码
	 */
	public void setAdmincode(String admincode){
		this.admincode = admincode;
	}
	/**
	 * 获取  leader
	 *@return: String  部门负责人
	 */
	public String getLeader(){
		return this.leader;
	}

	/**
	 * 设置  leader
	 *@param: leader  部门负责人
	 */
	public void setLeader(String leader){
		this.leader = leader;
	}
	/**
	 * 获取  shortname
	 *@return: String  部门简称
	 */
	public String getShortname(){
		return this.shortname;
	}

	/**
	 * 设置  shortname
	 *@param: shortname  部门简称
	 */
	public void setShortname(String shortname){
		this.shortname = shortname;
	}
	/**
	 * 获取  memo
	 *@return: String  部门简介
	 */
	public String getMemo(){
		return this.memo;
	}

	/**
	 * 设置  memo
	 *@param: memo  部门简介
	 */
	public void setMemo(String memo){
		this.memo = memo;
	}
	/**
	 * 获取  enterpriseid
	 *@return: String  所属企业ID(PMS_ENTERPRISE)
	 */
	public String getEnterpriseid(){
		return this.enterpriseid;
	}

	/**
	 * 设置  enterpriseid
	 *@param: enterpriseid  所属企业ID(PMS_ENTERPRISE)
	 */
	public void setEnterpriseid(String enterpriseid){
		this.enterpriseid = enterpriseid;
	}
	/**
	 * 获取  enable
	 *@return: String  部门状态 1 执行部门，2查看部门，3不可用
	 */
	public String getEnable(){
		return this.enable;
	}

	/**
	 * 设置  enable
	 *@param: enable  部门状态 1 执行部门，2查看部门，3不可用
	 */
	public void setEnable(String enable){
		this.enable = enable;
	}
	/**
	 * 获取  isbusiness
	 *@return: String  是否业务处室
	 */
	public String getIsbusiness(){
		return this.isbusiness;
	}

	/**
	 * 设置  isbusiness
	 *@param: isbusiness  是否业务处室
	 */
	public void setIsbusiness(String isbusiness){
		this.isbusiness = isbusiness;
	}
	/**
	 * 获取  islead
	 *@return: String  是否牵头处室
	 */
	public String getIslead(){
		return this.islead;
	}

	/**
	 * 设置  islead
	 *@param: islead  是否牵头处室
	 */
	public void setIslead(String islead){
		this.islead = islead;
	}
	
}
