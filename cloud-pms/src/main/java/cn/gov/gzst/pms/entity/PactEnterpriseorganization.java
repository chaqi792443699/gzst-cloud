package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 合同-承担单位信息表
 * @Description: 合同-承担单位信息表
 * @author wuzhengjun
 * @date 2019-04-24 15:48:14
 * @version V1.0   
 *
 */
@TableName("PACT_ENTERPRISEORGANIZATION")
@SuppressWarnings("serial")
public class PactEnterpriseorganization extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**企业名称*/
    @TableField(value = "organizationname")
	private String organizationname;
    /**简称*/
    @TableField(value = "organizationsimplename")
	private String organizationsimplename;
    /**企业类型*/
    @TableField(value = "organizationtype")
	private String organizationtype;
    /**法人代码*/
    @TableField(value = "legalcode")
	private String legalcode;
    /**所在区域代码*/
    @TableField(value = "addresscode")
	private String addresscode;
    /**归口管理部门*/
    @TableField(value = "managedepartment")
	private String managedepartment;
    /**通讯地址*/
    @TableField(value = "commintucateaddress")
	private String commintucateaddress;
    /**邮政编码*/
    @TableField(value = "postcard")
	private String postcard;
    /**单位email*/
    @TableField(value = "organizaitonemail")
	private String organizaitonemail;
    /**单位联系人*/
    @TableField(value = "organizationcontact")
	private String organizationcontact;
    /**单位联系人电话*/
    @TableField(value = "organizationphone")
	private String organizationphone;
    /**单位传真*/
    @TableField(value = "organizationfax")
	private String organizationfax;
    /**银行账号*/
    @TableField(value = "banknumber")
	private String banknumber;
    /**管理企业id*/
    @TableField(value = "enterpriseid")
	private String enterpriseid;
    /**项目id*/
    @TableField(value = "projectbaseid")
	private String projectbaseid;
    /**责任分工*/
    @TableField(value = "dutyforproject")
	private String dutyforproject;
    /**true 为主办单位 assume为其他承担单位 空为合作单位*/
    @TableField(value = "ismainenterprise")
	private String ismainenterprise;
    /**经济类别*/
    @TableField(value = "economiccategory")
	private String economiccategory;
    /**企业规模*/
    @TableField(value = "enterprisescale")
	private String enterprisescale;
    /**高新技术企业*/
    @TableField(value = "technologyenterprises")
	private String technologyenterprises;
    /**职工人数*/
    @TableField(value = "numberofstaff")
	private String numberofstaff;
    /**工程技术人员数*/
    @TableField(value = "technicalpersonnel")
	private String technicalpersonnel;
    /**资产总额(万元)*/
    @TableField(value = "totalassets")
	private String totalassets;
    /**年销售额(万元)*/
    @TableField(value = "annualsales")
	private String annualsales;
    /**年研究开发经费(万元)*/
    @TableField(value = "fundingforesearch")
	private String fundingforesearch;
    /**近两年有无产品列入新产品计划*/
    @TableField(value = "newproductplan")
	private String newproductplan;
    /**手机*/
    @TableField(value = "mobile")
	private String mobile;
    /**企业类型 在用*/
    @TableField(value = "enterprisetype")
	private String enterprisetype;
    /**单位负责人*/
    @TableField(value = "organizationhead")
	private String organizationhead;
    /**SEQ*/
    @TableField(value = "seq")
	private Double seq;
    /**注册时间*/
    @TableField(value = "registerdate")
	private Date registerdate;
    /**BELONGSVILLAGE*/
    @TableField(value = "belongsvillage")
	private String belongsvillage;
    /**LEADINGPRODUCTNAME*/
    @TableField(value = "leadingproductname")
	private String leadingproductname;
    /**LASTYEARSALES*/
    @TableField(value = "lastyearsales")
	private Double lastyearsales;
    /**DEVELOPMENTFEE*/
    @TableField(value = "developmentfee")
	private Double developmentfee;
    /**CONTRACTSTARTDATE*/
    @TableField(value = "contractstartdate")
	private Date contractstartdate;
    /**CONTRACTENDDATE*/
    @TableField(value = "contractenddate")
	private Date contractenddate;
    /**LEADER*/
    @TableField(value = "leader")
	private String leader;
    /**LEADERTEL*/
    @TableField(value = "leadertel")
	private String leadertel;
    /**  法人代表*/
    @TableField(value = "legalrepresentative")
	private String legalrepresentative;
    /**年度销售收入*/
    @TableField(value = "annualsalesrevenue")
	private Double annualsalesrevenue;
    /**研究基地// 单位开户名称*/
    @TableField(value = "researchbase")
	private String researchbase;
    /**合作形式*/
    @TableField(value = "cooperation")
	private String cooperation;
    /**申报书ID*/
    @TableField(value = "xmsbsid")
	private String xmsbsid;
    /**法人联系电话*/
    @TableField(value = "contactphone")
	private String contactphone;
    /**单位性质*/
    @TableField(value = "unitproperty")
	private String unitproperty;
    /**法人移动电话*/
    @TableField(value = "legalmobilephone")
	private String legalmobilephone;
    /**联系人移动电话*/
    @TableField(value = "contactmobilphone")
	private String contactmobilphone;
    /**开始时间*/
    @TableField(value = "starttime")
	private Date starttime;
    /**结束时间*/
    @TableField(value = "overtime")
	private Date overtime;
    /**推广应用量*/
    @TableField(value = "application")
	private String application;
    /**销售收入tax*/
    @TableField(value = "saleincome")
	private Double saleincome;
    /**销售税收*/
    @TableField(value = "tax")
	private Double tax;
    /**JXID*/
    @TableField(value = "jxid")
	private String jxid;
    /**STARTENDTIME*/
    @TableField(value = "startendtime")
	private String startendtime;
    /**YYFS*/
    @TableField(value = "yyfs")
	private String yyfs;
    /**PROMOTIONSITUATION*/
    @TableField(value = "promotionsituation")
	private String promotionsituation;
    /**ACCOUNTBANK*/
    @TableField(value = "accountbank")
	private String accountbank;
    /**合同ID*/
    @TableField(value = "pactid")
	private String pactid;
    /**项目分工*/
    @TableField(value = "divisionwork")
	private String divisionwork;
    /**总经费分摊*/
    @TableField(value = "totalexpenditure")
	private Double totalexpenditure;
    /**省科技厅经费*/
    @TableField(value = "kjtexpenditure")
	private Double kjtexpenditure;
    /**银行帐号名*/
    @TableField(value = "bankname")
	private String bankname;
	
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
	 * 获取  organizationname
	 *@return: String  企业名称
	 */
	public String getOrganizationname(){
		return this.organizationname;
	}

	/**
	 * 设置  organizationname
	 *@param: organizationname  企业名称
	 */
	public void setOrganizationname(String organizationname){
		this.organizationname = organizationname;
	}
	/**
	 * 获取  organizationsimplename
	 *@return: String  简称
	 */
	public String getOrganizationsimplename(){
		return this.organizationsimplename;
	}

	/**
	 * 设置  organizationsimplename
	 *@param: organizationsimplename  简称
	 */
	public void setOrganizationsimplename(String organizationsimplename){
		this.organizationsimplename = organizationsimplename;
	}
	/**
	 * 获取  organizationtype
	 *@return: String  企业类型
	 */
	public String getOrganizationtype(){
		return this.organizationtype;
	}

	/**
	 * 设置  organizationtype
	 *@param: organizationtype  企业类型
	 */
	public void setOrganizationtype(String organizationtype){
		this.organizationtype = organizationtype;
	}
	/**
	 * 获取  legalcode
	 *@return: String  法人代码
	 */
	public String getLegalcode(){
		return this.legalcode;
	}

	/**
	 * 设置  legalcode
	 *@param: legalcode  法人代码
	 */
	public void setLegalcode(String legalcode){
		this.legalcode = legalcode;
	}
	/**
	 * 获取  addresscode
	 *@return: String  所在区域代码
	 */
	public String getAddresscode(){
		return this.addresscode;
	}

	/**
	 * 设置  addresscode
	 *@param: addresscode  所在区域代码
	 */
	public void setAddresscode(String addresscode){
		this.addresscode = addresscode;
	}
	/**
	 * 获取  managedepartment
	 *@return: String  归口管理部门
	 */
	public String getManagedepartment(){
		return this.managedepartment;
	}

	/**
	 * 设置  managedepartment
	 *@param: managedepartment  归口管理部门
	 */
	public void setManagedepartment(String managedepartment){
		this.managedepartment = managedepartment;
	}
	/**
	 * 获取  commintucateaddress
	 *@return: String  通讯地址
	 */
	public String getCommintucateaddress(){
		return this.commintucateaddress;
	}

	/**
	 * 设置  commintucateaddress
	 *@param: commintucateaddress  通讯地址
	 */
	public void setCommintucateaddress(String commintucateaddress){
		this.commintucateaddress = commintucateaddress;
	}
	/**
	 * 获取  postcard
	 *@return: String  邮政编码
	 */
	public String getPostcard(){
		return this.postcard;
	}

	/**
	 * 设置  postcard
	 *@param: postcard  邮政编码
	 */
	public void setPostcard(String postcard){
		this.postcard = postcard;
	}
	/**
	 * 获取  organizaitonemail
	 *@return: String  单位email
	 */
	public String getOrganizaitonemail(){
		return this.organizaitonemail;
	}

	/**
	 * 设置  organizaitonemail
	 *@param: organizaitonemail  单位email
	 */
	public void setOrganizaitonemail(String organizaitonemail){
		this.organizaitonemail = organizaitonemail;
	}
	/**
	 * 获取  organizationcontact
	 *@return: String  单位联系人
	 */
	public String getOrganizationcontact(){
		return this.organizationcontact;
	}

	/**
	 * 设置  organizationcontact
	 *@param: organizationcontact  单位联系人
	 */
	public void setOrganizationcontact(String organizationcontact){
		this.organizationcontact = organizationcontact;
	}
	/**
	 * 获取  organizationphone
	 *@return: String  单位联系人电话
	 */
	public String getOrganizationphone(){
		return this.organizationphone;
	}

	/**
	 * 设置  organizationphone
	 *@param: organizationphone  单位联系人电话
	 */
	public void setOrganizationphone(String organizationphone){
		this.organizationphone = organizationphone;
	}
	/**
	 * 获取  organizationfax
	 *@return: String  单位传真
	 */
	public String getOrganizationfax(){
		return this.organizationfax;
	}

	/**
	 * 设置  organizationfax
	 *@param: organizationfax  单位传真
	 */
	public void setOrganizationfax(String organizationfax){
		this.organizationfax = organizationfax;
	}
	/**
	 * 获取  banknumber
	 *@return: String  银行账号
	 */
	public String getBanknumber(){
		return this.banknumber;
	}

	/**
	 * 设置  banknumber
	 *@param: banknumber  银行账号
	 */
	public void setBanknumber(String banknumber){
		this.banknumber = banknumber;
	}
	/**
	 * 获取  enterpriseid
	 *@return: String  管理企业id
	 */
	public String getEnterpriseid(){
		return this.enterpriseid;
	}

	/**
	 * 设置  enterpriseid
	 *@param: enterpriseid  管理企业id
	 */
	public void setEnterpriseid(String enterpriseid){
		this.enterpriseid = enterpriseid;
	}
	/**
	 * 获取  projectbaseid
	 *@return: String  项目id
	 */
	public String getProjectbaseid(){
		return this.projectbaseid;
	}

	/**
	 * 设置  projectbaseid
	 *@param: projectbaseid  项目id
	 */
	public void setProjectbaseid(String projectbaseid){
		this.projectbaseid = projectbaseid;
	}
	/**
	 * 获取  dutyforproject
	 *@return: String  责任分工
	 */
	public String getDutyforproject(){
		return this.dutyforproject;
	}

	/**
	 * 设置  dutyforproject
	 *@param: dutyforproject  责任分工
	 */
	public void setDutyforproject(String dutyforproject){
		this.dutyforproject = dutyforproject;
	}
	/**
	 * 获取  ismainenterprise
	 *@return: String  true 为主办单位 assume为其他承担单位 空为合作单位
	 */
	public String getIsmainenterprise(){
		return this.ismainenterprise;
	}

	/**
	 * 设置  ismainenterprise
	 *@param: ismainenterprise  true 为主办单位 assume为其他承担单位 空为合作单位
	 */
	public void setIsmainenterprise(String ismainenterprise){
		this.ismainenterprise = ismainenterprise;
	}
	/**
	 * 获取  economiccategory
	 *@return: String  经济类别
	 */
	public String getEconomiccategory(){
		return this.economiccategory;
	}

	/**
	 * 设置  economiccategory
	 *@param: economiccategory  经济类别
	 */
	public void setEconomiccategory(String economiccategory){
		this.economiccategory = economiccategory;
	}
	/**
	 * 获取  enterprisescale
	 *@return: String  企业规模
	 */
	public String getEnterprisescale(){
		return this.enterprisescale;
	}

	/**
	 * 设置  enterprisescale
	 *@param: enterprisescale  企业规模
	 */
	public void setEnterprisescale(String enterprisescale){
		this.enterprisescale = enterprisescale;
	}
	/**
	 * 获取  technologyenterprises
	 *@return: String  高新技术企业
	 */
	public String getTechnologyenterprises(){
		return this.technologyenterprises;
	}

	/**
	 * 设置  technologyenterprises
	 *@param: technologyenterprises  高新技术企业
	 */
	public void setTechnologyenterprises(String technologyenterprises){
		this.technologyenterprises = technologyenterprises;
	}
	/**
	 * 获取  numberofstaff
	 *@return: String  职工人数
	 */
	public String getNumberofstaff(){
		return this.numberofstaff;
	}

	/**
	 * 设置  numberofstaff
	 *@param: numberofstaff  职工人数
	 */
	public void setNumberofstaff(String numberofstaff){
		this.numberofstaff = numberofstaff;
	}
	/**
	 * 获取  technicalpersonnel
	 *@return: String  工程技术人员数
	 */
	public String getTechnicalpersonnel(){
		return this.technicalpersonnel;
	}

	/**
	 * 设置  technicalpersonnel
	 *@param: technicalpersonnel  工程技术人员数
	 */
	public void setTechnicalpersonnel(String technicalpersonnel){
		this.technicalpersonnel = technicalpersonnel;
	}
	/**
	 * 获取  totalassets
	 *@return: String  资产总额(万元)
	 */
	public String getTotalassets(){
		return this.totalassets;
	}

	/**
	 * 设置  totalassets
	 *@param: totalassets  资产总额(万元)
	 */
	public void setTotalassets(String totalassets){
		this.totalassets = totalassets;
	}
	/**
	 * 获取  annualsales
	 *@return: String  年销售额(万元)
	 */
	public String getAnnualsales(){
		return this.annualsales;
	}

	/**
	 * 设置  annualsales
	 *@param: annualsales  年销售额(万元)
	 */
	public void setAnnualsales(String annualsales){
		this.annualsales = annualsales;
	}
	/**
	 * 获取  fundingforesearch
	 *@return: String  年研究开发经费(万元)
	 */
	public String getFundingforesearch(){
		return this.fundingforesearch;
	}

	/**
	 * 设置  fundingforesearch
	 *@param: fundingforesearch  年研究开发经费(万元)
	 */
	public void setFundingforesearch(String fundingforesearch){
		this.fundingforesearch = fundingforesearch;
	}
	/**
	 * 获取  newproductplan
	 *@return: String  近两年有无产品列入新产品计划
	 */
	public String getNewproductplan(){
		return this.newproductplan;
	}

	/**
	 * 设置  newproductplan
	 *@param: newproductplan  近两年有无产品列入新产品计划
	 */
	public void setNewproductplan(String newproductplan){
		this.newproductplan = newproductplan;
	}
	/**
	 * 获取  mobile
	 *@return: String  手机
	 */
	public String getMobile(){
		return this.mobile;
	}

	/**
	 * 设置  mobile
	 *@param: mobile  手机
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	/**
	 * 获取  enterprisetype
	 *@return: String  企业类型 在用
	 */
	public String getEnterprisetype(){
		return this.enterprisetype;
	}

	/**
	 * 设置  enterprisetype
	 *@param: enterprisetype  企业类型 在用
	 */
	public void setEnterprisetype(String enterprisetype){
		this.enterprisetype = enterprisetype;
	}
	/**
	 * 获取  organizationhead
	 *@return: String  单位负责人
	 */
	public String getOrganizationhead(){
		return this.organizationhead;
	}

	/**
	 * 设置  organizationhead
	 *@param: organizationhead  单位负责人
	 */
	public void setOrganizationhead(String organizationhead){
		this.organizationhead = organizationhead;
	}
	/**
	 * 获取  seq
	 *@return: Double  SEQ
	 */
	public Double getSeq(){
		return this.seq;
	}

	/**
	 * 设置  seq
	 *@param: seq  SEQ
	 */
	public void setSeq(Double seq){
		this.seq = seq;
	}
	/**
	 * 获取  registerdate
	 *@return: Date  注册时间
	 */
	public Date getRegisterdate(){
		return this.registerdate;
	}

	/**
	 * 设置  registerdate
	 *@param: registerdate  注册时间
	 */
	public void setRegisterdate(Date registerdate){
		this.registerdate = registerdate;
	}
	/**
	 * 获取  belongsvillage
	 *@return: String  BELONGSVILLAGE
	 */
	public String getBelongsvillage(){
		return this.belongsvillage;
	}

	/**
	 * 设置  belongsvillage
	 *@param: belongsvillage  BELONGSVILLAGE
	 */
	public void setBelongsvillage(String belongsvillage){
		this.belongsvillage = belongsvillage;
	}
	/**
	 * 获取  leadingproductname
	 *@return: String  LEADINGPRODUCTNAME
	 */
	public String getLeadingproductname(){
		return this.leadingproductname;
	}

	/**
	 * 设置  leadingproductname
	 *@param: leadingproductname  LEADINGPRODUCTNAME
	 */
	public void setLeadingproductname(String leadingproductname){
		this.leadingproductname = leadingproductname;
	}
	/**
	 * 获取  lastyearsales
	 *@return: Double  LASTYEARSALES
	 */
	public Double getLastyearsales(){
		return this.lastyearsales;
	}

	/**
	 * 设置  lastyearsales
	 *@param: lastyearsales  LASTYEARSALES
	 */
	public void setLastyearsales(Double lastyearsales){
		this.lastyearsales = lastyearsales;
	}
	/**
	 * 获取  developmentfee
	 *@return: Double  DEVELOPMENTFEE
	 */
	public Double getDevelopmentfee(){
		return this.developmentfee;
	}

	/**
	 * 设置  developmentfee
	 *@param: developmentfee  DEVELOPMENTFEE
	 */
	public void setDevelopmentfee(Double developmentfee){
		this.developmentfee = developmentfee;
	}
	/**
	 * 获取  contractstartdate
	 *@return: Date  CONTRACTSTARTDATE
	 */
	public Date getContractstartdate(){
		return this.contractstartdate;
	}

	/**
	 * 设置  contractstartdate
	 *@param: contractstartdate  CONTRACTSTARTDATE
	 */
	public void setContractstartdate(Date contractstartdate){
		this.contractstartdate = contractstartdate;
	}
	/**
	 * 获取  contractenddate
	 *@return: Date  CONTRACTENDDATE
	 */
	public Date getContractenddate(){
		return this.contractenddate;
	}

	/**
	 * 设置  contractenddate
	 *@param: contractenddate  CONTRACTENDDATE
	 */
	public void setContractenddate(Date contractenddate){
		this.contractenddate = contractenddate;
	}
	/**
	 * 获取  leader
	 *@return: String  LEADER
	 */
	public String getLeader(){
		return this.leader;
	}

	/**
	 * 设置  leader
	 *@param: leader  LEADER
	 */
	public void setLeader(String leader){
		this.leader = leader;
	}
	/**
	 * 获取  leadertel
	 *@return: String  LEADERTEL
	 */
	public String getLeadertel(){
		return this.leadertel;
	}

	/**
	 * 设置  leadertel
	 *@param: leadertel  LEADERTEL
	 */
	public void setLeadertel(String leadertel){
		this.leadertel = leadertel;
	}
	/**
	 * 获取  legalrepresentative
	 *@return: String    法人代表
	 */
	public String getLegalrepresentative(){
		return this.legalrepresentative;
	}

	/**
	 * 设置  legalrepresentative
	 *@param: legalrepresentative    法人代表
	 */
	public void setLegalrepresentative(String legalrepresentative){
		this.legalrepresentative = legalrepresentative;
	}
	/**
	 * 获取  annualsalesrevenue
	 *@return: Double  年度销售收入
	 */
	public Double getAnnualsalesrevenue(){
		return this.annualsalesrevenue;
	}

	/**
	 * 设置  annualsalesrevenue
	 *@param: annualsalesrevenue  年度销售收入
	 */
	public void setAnnualsalesrevenue(Double annualsalesrevenue){
		this.annualsalesrevenue = annualsalesrevenue;
	}
	/**
	 * 获取  researchbase
	 *@return: String  研究基地// 单位开户名称
	 */
	public String getResearchbase(){
		return this.researchbase;
	}

	/**
	 * 设置  researchbase
	 *@param: researchbase  研究基地// 单位开户名称
	 */
	public void setResearchbase(String researchbase){
		this.researchbase = researchbase;
	}
	/**
	 * 获取  cooperation
	 *@return: String  合作形式
	 */
	public String getCooperation(){
		return this.cooperation;
	}

	/**
	 * 设置  cooperation
	 *@param: cooperation  合作形式
	 */
	public void setCooperation(String cooperation){
		this.cooperation = cooperation;
	}
	/**
	 * 获取  xmsbsid
	 *@return: String  申报书ID
	 */
	public String getXmsbsid(){
		return this.xmsbsid;
	}

	/**
	 * 设置  xmsbsid
	 *@param: xmsbsid  申报书ID
	 */
	public void setXmsbsid(String xmsbsid){
		this.xmsbsid = xmsbsid;
	}
	/**
	 * 获取  contactphone
	 *@return: String  法人联系电话
	 */
	public String getContactphone(){
		return this.contactphone;
	}

	/**
	 * 设置  contactphone
	 *@param: contactphone  法人联系电话
	 */
	public void setContactphone(String contactphone){
		this.contactphone = contactphone;
	}
	/**
	 * 获取  unitproperty
	 *@return: String  单位性质
	 */
	public String getUnitproperty(){
		return this.unitproperty;
	}

	/**
	 * 设置  unitproperty
	 *@param: unitproperty  单位性质
	 */
	public void setUnitproperty(String unitproperty){
		this.unitproperty = unitproperty;
	}
	/**
	 * 获取  legalmobilephone
	 *@return: String  法人移动电话
	 */
	public String getLegalmobilephone(){
		return this.legalmobilephone;
	}

	/**
	 * 设置  legalmobilephone
	 *@param: legalmobilephone  法人移动电话
	 */
	public void setLegalmobilephone(String legalmobilephone){
		this.legalmobilephone = legalmobilephone;
	}
	/**
	 * 获取  contactmobilphone
	 *@return: String  联系人移动电话
	 */
	public String getContactmobilphone(){
		return this.contactmobilphone;
	}

	/**
	 * 设置  contactmobilphone
	 *@param: contactmobilphone  联系人移动电话
	 */
	public void setContactmobilphone(String contactmobilphone){
		this.contactmobilphone = contactmobilphone;
	}
	/**
	 * 获取  starttime
	 *@return: Date  开始时间
	 */
	public Date getStarttime(){
		return this.starttime;
	}

	/**
	 * 设置  starttime
	 *@param: starttime  开始时间
	 */
	public void setStarttime(Date starttime){
		this.starttime = starttime;
	}
	/**
	 * 获取  overtime
	 *@return: Date  结束时间
	 */
	public Date getOvertime(){
		return this.overtime;
	}

	/**
	 * 设置  overtime
	 *@param: overtime  结束时间
	 */
	public void setOvertime(Date overtime){
		this.overtime = overtime;
	}
	/**
	 * 获取  application
	 *@return: String  推广应用量
	 */
	public String getApplication(){
		return this.application;
	}

	/**
	 * 设置  application
	 *@param: application  推广应用量
	 */
	public void setApplication(String application){
		this.application = application;
	}
	/**
	 * 获取  saleincome
	 *@return: Double  销售收入tax
	 */
	public Double getSaleincome(){
		return this.saleincome;
	}

	/**
	 * 设置  saleincome
	 *@param: saleincome  销售收入tax
	 */
	public void setSaleincome(Double saleincome){
		this.saleincome = saleincome;
	}
	/**
	 * 获取  tax
	 *@return: Double  销售税收
	 */
	public Double getTax(){
		return this.tax;
	}

	/**
	 * 设置  tax
	 *@param: tax  销售税收
	 */
	public void setTax(Double tax){
		this.tax = tax;
	}
	/**
	 * 获取  jxid
	 *@return: String  JXID
	 */
	public String getJxid(){
		return this.jxid;
	}

	/**
	 * 设置  jxid
	 *@param: jxid  JXID
	 */
	public void setJxid(String jxid){
		this.jxid = jxid;
	}
	/**
	 * 获取  startendtime
	 *@return: String  STARTENDTIME
	 */
	public String getStartendtime(){
		return this.startendtime;
	}

	/**
	 * 设置  startendtime
	 *@param: startendtime  STARTENDTIME
	 */
	public void setStartendtime(String startendtime){
		this.startendtime = startendtime;
	}
	/**
	 * 获取  yyfs
	 *@return: String  YYFS
	 */
	public String getYyfs(){
		return this.yyfs;
	}

	/**
	 * 设置  yyfs
	 *@param: yyfs  YYFS
	 */
	public void setYyfs(String yyfs){
		this.yyfs = yyfs;
	}
	/**
	 * 获取  promotionsituation
	 *@return: String  PROMOTIONSITUATION
	 */
	public String getPromotionsituation(){
		return this.promotionsituation;
	}

	/**
	 * 设置  promotionsituation
	 *@param: promotionsituation  PROMOTIONSITUATION
	 */
	public void setPromotionsituation(String promotionsituation){
		this.promotionsituation = promotionsituation;
	}
	/**
	 * 获取  accountbank
	 *@return: String  ACCOUNTBANK
	 */
	public String getAccountbank(){
		return this.accountbank;
	}

	/**
	 * 设置  accountbank
	 *@param: accountbank  ACCOUNTBANK
	 */
	public void setAccountbank(String accountbank){
		this.accountbank = accountbank;
	}
	/**
	 * 获取  pactid
	 *@return: String  合同ID
	 */
	public String getPactid(){
		return this.pactid;
	}

	/**
	 * 设置  pactid
	 *@param: pactid  合同ID
	 */
	public void setPactid(String pactid){
		this.pactid = pactid;
	}
	/**
	 * 获取  divisionwork
	 *@return: String  项目分工
	 */
	public String getDivisionwork(){
		return this.divisionwork;
	}

	/**
	 * 设置  divisionwork
	 *@param: divisionwork  项目分工
	 */
	public void setDivisionwork(String divisionwork){
		this.divisionwork = divisionwork;
	}
	/**
	 * 获取  totalexpenditure
	 *@return: Double  总经费分摊
	 */
	public Double getTotalexpenditure(){
		return this.totalexpenditure;
	}

	/**
	 * 设置  totalexpenditure
	 *@param: totalexpenditure  总经费分摊
	 */
	public void setTotalexpenditure(Double totalexpenditure){
		this.totalexpenditure = totalexpenditure;
	}
	/**
	 * 获取  kjtexpenditure
	 *@return: Double  省科技厅经费
	 */
	public Double getKjtexpenditure(){
		return this.kjtexpenditure;
	}

	/**
	 * 设置  kjtexpenditure
	 *@param: kjtexpenditure  省科技厅经费
	 */
	public void setKjtexpenditure(Double kjtexpenditure){
		this.kjtexpenditure = kjtexpenditure;
	}
	/**
	 * 获取  bankname
	 *@return: String  银行帐号名
	 */
	public String getBankname(){
		return this.bankname;
	}

	/**
	 * 设置  bankname
	 *@param: bankname  银行帐号名
	 */
	public void setBankname(String bankname){
		this.bankname = bankname;
	}
	
}
