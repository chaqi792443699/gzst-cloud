package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 合同-基本信息表
 * @Description: 合同-基本信息表
 * @author wuzhengjun
 * @date 2019-04-24 15:53:12
 * @version V1.0   
 *
 */
@TableName("PACT_PROJECTBASE")
@SuppressWarnings("serial")
public class PactProjectbase extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**企业id*/
    @TableField(value = "enterpriseorusersid")
	private String enterpriseorusersid;
    /**申报项目批次ID*/
    @TableField(value = "planprojectbatchid")
	private String planprojectbatchid;
    /**项目开始日期*/
    @JSONField(format="yyyy-MM-dd")
    @TableField(value = "projectstartdate")
	private Date projectstartdate;

    @TableField(exist = false)
    private String pactno;

    @TableField(exist = false)
    private String jhxtzkjjf;

    @TableField(exist = false)
    private String pactStatus;

    @TableField(exist = false)
    private String organizationname;

    @TableField(exist = false)
    private String status;

    @TableField(exist = false)
    private String annually;

    @TableField(exist = false)
    private String applicationtypecode1;

    /**项目结束日期*/
    @JSONField(format="yyyy-MM-dd")
    @TableField(value = "projectenddate")
	private Date projectenddate;
    /**自费多少*/
    @TableField(value = "projectsumforself")
	private Double projectsumforself;
    /**向政府申请经费*/
    @TableField(value = "projectsumforgov")
	private Double projectsumforgov;
    /**项目总费用*/
    @TableField(value = "projecttotalsum")
	private Double projecttotalsum;
    /**项目经济效益*/
    @TableField(value = "economicbenefit")
	private String economicbenefit;
    /**项目内容*/
    @TableField(value = "projectcontent1")
	private String projectcontent1;
    /**项目效益*/
    @TableField(value = "projectachievement1")
	private String projectachievement1;
    /**项目名称*/
    @TableField(value = "projectbasename")
	private String projectbasename;
    /**申报人*/
    @TableField(value = "declarant")
	private String declarant;
    /**律师事务所*/
    @TableField(value = "accountfirmid")
	private String accountfirmid;
    /**项目负责人*/
    @TableField(value = "projectleader")
	private String projectleader;
    /**申请专项名称*/
    @TableField(value = "applyspecialname")
	private String applyspecialname;
    /**项目申请类型*/
    @TableField(value = "projectapplytype")
	private String projectapplytype;
    /**项目计划类型*/
    @TableField(value = "projectplantype")
	private String projectplantype;
    /**技术创新方式*/
    @TableField(value = "technologicalmode")
	private String technologicalmode;
    /**项目管理领域*/
    @TableField(value = "projectmanagedomain")
	private String projectmanagedomain;
    /**申请拨款方式*/
    @TableField(value = "appropriationtype")
	private String appropriationtype;
    /**技术来源*/
    @TableField(value = "technologicalsource")
	private String technologicalsource;
    /**主流程状态*/
    @TableField(value = "maincurrentstate")
	private String maincurrentstate;
    /**主流程状态ID*/
    @TableField(value = "maincurrentstateid")
	private String maincurrentstateid;
    /**子状态*/
    @TableField(value = "minicurrentstate")
	private String minicurrentstate;
    /**子状态ID*/
    @TableField(value = "minicurrentstateid")
	private String minicurrentstateid;
    /**项目申请时间*/
    @TableField(value = "applydate")
	private Date applydate;
    /**预计经济效益和成果*/
    @TableField(value = "expectedbenefitachievement")
	private String expectedbenefitachievement;
    /**申报人\单位id*/
    @TableField(value = "declarantid")
	private String declarantid;
    /**主办单位*/
    @TableField(value = "mainorganizers")
	private String mainorganizers;
    /**研发内容与预期目标凝练*/
    @TableField(value = "researchcontent1")
	private String researchcontent1;
    /**项目实施主要任务和目标*/
    @TableField(value = "projectimplementation")
	private String projectimplementation;
    /**上年度研发投入*/
    @TableField(value = "researchinput")
	private String researchinput;
    /**上年度主营业务收入*/
    @TableField(value = "mainbusinessincome")
	private String mainbusinessincome;
    /**企业类型*/
    @TableField(value = "enterprisetypes")
	private String enterprisetypes;
    /**研发机构情况*/
    @TableField(value = "researchinstitutions")
	private String researchinstitutions;
    /**申请编号*/
    @TableField(value = "applicationno")
	private String applicationno;
    /**技术领域*/
    @TableField(value = "techdomain")
	private String techdomain;
    /**提交时间*/
    @TableField(value = "submitdate")
	private Date submitdate;
    /**是否作废*/
    @TableField(value = "iscancel")
	private Double iscancel;
    /**是否立项*/
    @TableField(value = "issetup")
	private Double issetup;
    /**创建日期*/
    @TableField(value = "createdate")
	private Date createdate;
    /**(主管处室)*/
    @TableField(value = "chiefdepartment")
	private String chiefdepartment;
    /**(项目主管)*/
    @TableField(value = "chieldofficals")
	private String chieldofficals;
    /**(归口管理部门)*/
    @TableField(value = "casemanagement")
	private String casemanagement;
    /**计划编号*/
    @TableField(value = "planno")
	private String planno;
    /**项目行业分类*/
    @TableField(value = "projectclassification")
	private String projectclassification;
    /**项目成果提供形式*/
    @TableField(value = "projectresults")
	private String projectresults;
    /**特征信息id*/
    @TableField(value = "projectfeatureinforid")
	private String projectfeatureinforid;
    /**申请专项名称代码*/
    @TableField(value = "applyspecialnamecode")
	private String applyspecialnamecode;
    /**项目申请类型代码*/
    @TableField(value = "projectapplytypecode")
	private String projectapplytypecode;
    /**项目计划类型代码*/
    @TableField(value = "projectplantypecode")
	private String projectplantypecode;
    /**技术创新方式代码*/
    @TableField(value = "technologicalmodecode")
	private String technologicalmodecode;
    /**项目管理领域代码*/
    @TableField(value = "projectmanagedomaincode")
	private String projectmanagedomaincode;
    /**申请拨款方式代码*/
    @TableField(value = "appropriationtypecode")
	private String appropriationtypecode;
    /**技术来源代码*/
    @TableField(value = "technologicalsourcecode")
	private String technologicalsourcecode;
    /**当前状态*/
    @TableField(value = "currentsate")
	private String currentsate;
    /**初审所属处室*/
    @TableField(value = "belonglab")
	private String belonglab;
    /**初审所属处室ID*/
    @TableField(value = "belonglabid")
	private String belonglabid;
    /**产业领域*/
    @TableField(value = "industryfield")
	private String industryfield;
    /**技术领域编码*/
    @TableField(value = "techdomaincode")
	private String techdomaincode;
    /**产业领域编码*/
    @TableField(value = "industryfieldcode")
	private String industryfieldcode;
    /**学科领域*/
    @TableField(value = "subjectareas")
	private String subjectareas;
    /**学科领域代码*/
    @TableField(value = "subjectareascode")
	private String subjectareascode;
    /**技术领域*/
    @TableField(value = "technicalrank")
	private String technicalrank;
    /**归口管理部门代码*/
    @TableField(value = "casemanagementcode")
	private String casemanagementcode;
    /**归口管理部门id*/
    @TableField(value = "casemanagementid")
	private String casemanagementid;
    /**行业分类代码*/
    @TableField(value = "projectclassificationcode")
	private String projectclassificationcode;
    /**社会公益领域*/
    @TableField(value = "shgyly")
	private String shgyly;
    /**社会公益领域代码*/
    @TableField(value = "shgylycode")
	private String shgylycode;
    /**副标题*/
    @TableField(value = "secondprojectname")
	private String secondprojectname;
    /**云平台大仪平台*/
    @TableField(value = "dayipingtai")
	private String dayipingtai;
    /**云平台载体名称*/
    @TableField(value = "zaitimingcheng")
	private String zaitimingcheng;
    /**项目实施目的意义*/
    @TableField(value = "purposemean")
	private String purposemean;
    /**云平台企业类型*/
    @TableField(value = "yptqiyeleixing")
	private String yptqiyeleixing;
    /**研发内容与预期目标凝练*/
    @TableField(value = "researchcontent")
	private String researchcontent;
    /**项目内容*/
    @TableField(value = "projectcontent")
	private String projectcontent;
    /**项目效益*/
    @TableField(value = "projectachievement")
	private String projectachievement;
    /**最后一次保存时间*/
    @TableField(value = "updatelasttime")
	private Date updatelasttime;
    /**实现销售收入*/
    @TableField(value = "achievesalesrevenue")
	private Double achievesalesrevenue;
    /**实现利润*/
    @TableField(value = "profits")
	private Double profits;
    /**实现上缴税收*/
    @TableField(value = "implementpaystaxes")
	private Double implementpaystaxes;
    /**载体类别*/
    @TableField(value = "zttype")
	private String zttype;
    /**超过30万大型仪器信息填写情况 */
    @TableField(value = "daxingyiqi")
	private String daxingyiqi;
    /**创新券使用情况*/
    @TableField(value = "chuangxinquan")
	private String chuangxinquan;
    /**载体名称ID*/
    @TableField(value = "zaitimingchenid")
	private String zaitimingchenid;
    /**显示的项目名称*/
    @TableField(value = "showprojectbasename")
	private String showprojectbasename;
    /**批次名称*/
    @TableField(value = "batchname")
	private String batchname;
    /**具备条件*/
    @TableField(value = "possessconditions")
	private String possessconditions;
    /**实际支付*/
    @TableField(value = "actualpayment")
	private Double actualpayment;
    /**1为第二轮专家评审可选项目标志*/
    @TableField(value = "truefalse")
	private String truefalse;
    /**专家网评结果*/
    @TableField(value = "expertresult")
	private String expertresult;
    /**处室初审建议经费*/
    @TableField(value = "csjyjf")
	private Double csjyjf;
    /**处室处员初审结果*/
    @TableField(value = "cscsjg")
	private String cscsjg;
    /**处室处长建议经费*/
    @TableField(value = "csczjyjf")
	private Double csczjyjf;
    /**处室处长初审结果*/
    @TableField(value = "csczshjg")
	private String csczshjg;
    /**立项项目名称*/
    @TableField(value = "finalprojectname")
	private String finalprojectname;
    /**立项课题名称*/
    @TableField(value = "finaltaskprojectname")
	private String finaltaskprojectname;
    /**分配的项目主管id*/
    @TableField(value = "xmzgid")
	private String xmzgid;
    /**临时分配的项目主管id*/
    @TableField(value = "lsxmzgid")
	private String lsxmzgid;
    /**流程id*/
    @TableField(value = "activitiid")
	private String activitiid;
    /**申报项目批次ID2*/
    @TableField(value = "planprojectbatchid2")
	private String planprojectbatchid2;
    /**联审状态-高新技术发展及产业化处*/
    @TableField(value = "act_gxc")
	private String actGxc;
    /**联审状态-科技条件与基础研究处*/
    @TableField(value = "act_kjc")
	private String actKjc;
    /**联审状态-社会发展科技处*/
    @TableField(value = "act_sfc")
	private String actSfc;
    /**联审状态-国际科技合作处*/
    @TableField(value = "act_gjc")
	private String actGjc;
    /**联审状态-知识产权发展处*/
    @TableField(value = "act_zsc")
	private String actZsc;
    /**联审状态-专利管理处*/
    @TableField(value = "act_zlglc")
	private String actZlglc;
    /**联审状态-专利保护处*/
    @TableField(value = "act_zlbhc")
	private String actZlbhc;
    /**联审状态-产学研合作与成果转化处*/
    @TableField(value = "act_cxc")
	private String actCxc;
    /**联审状态-农村科技处*/
    @TableField(value = "act_ncc")
	private String actNcc;
    /**联审状态-政策法规处*/
    @TableField(value = "act_fgc")
	private String actFgc;
    /**联审状态-直属机关党委*/
    @TableField(value = "act_zsjgdw")
	private String actZsjgdw;
    /**联审状态-监察室*/
    @TableField(value = "act_jjs")
	private String actJjs;
    /**主管id-高新技术发展及产业化处*/
    @TableField(value = "xmzgid_gxc")
	private String xmzgidGxc;
    /**主管id-科技条件与基础研究处*/
    @TableField(value = "xmzgid_kjc")
	private String xmzgidKjc;
    /**主管id-社会发展科技处*/
    @TableField(value = "xmzgid_sfc")
	private String xmzgidSfc;
    /**主管id-国际科技合作处*/
    @TableField(value = "xmzgid_gjc")
	private String xmzgidGjc;
    /**主管id-知识产权发展处*/
    @TableField(value = "xmzgid_zsc")
	private String xmzgidZsc;
    /**主管id-专利管理处*/
    @TableField(value = "xmzgid_zlglc")
	private String xmzgidZlglc;
    /**主管id-专利保护处*/
    @TableField(value = "xmzgid_zlbhc")
	private String xmzgidZlbhc;
    /**主管id-产学研合作与成果转化处*/
    @TableField(value = "xmzgid_cxc")
	private String xmzgidCxc;
    /**主管id-农村科技处*/
    @TableField(value = "xmzgid_ncc")
	private String xmzgidNcc;
    /**主管id-政策法规处*/
    @TableField(value = "xmzgid_fgc")
	private String xmzgidFgc;
    /**主管id-直属机关党委*/
    @TableField(value = "xmzgid_zsjgdw")
	private String xmzgidZsjgdw;
    /**主管id-监察室*/
    @TableField(value = "xmzgid_jjs")
	private String xmzgidJjs;
    /**临时主管id-高新技术发展及产业化处*/
    @TableField(value = "lsxmzgid_gxc")
	private String lsxmzgidGxc;
    /**临时主管id-科技条件与基础研究处*/
    @TableField(value = "lsxmzgid_kjc")
	private String lsxmzgidKjc;
    /**临时主管id-社会发展科技处*/
    @TableField(value = "lsxmzgid_sfc")
	private String lsxmzgidSfc;
    /**临时主管id-国际科技合作处*/
    @TableField(value = "lsxmzgid_gjc")
	private String lsxmzgidGjc;
    /**临时主管id-知识产权发展处*/
    @TableField(value = "lsxmzgid_zsc")
	private String lsxmzgidZsc;
    /**临时主管id-专利管理处*/
    @TableField(value = "lsxmzgid_zlglc")
	private String lsxmzgidZlglc;
    /**临时主管id-专利保护处*/
    @TableField(value = "lsxmzgid_zlbhc")
	private String lsxmzgidZlbhc;
    /**临时主管id-产学研合作与成果转化处*/
    @TableField(value = "lsxmzgid_cxc")
	private String lsxmzgidCxc;
    /**临时主管id-农村科技处*/
    @TableField(value = "lsxmzgid_ncc")
	private String lsxmzgidNcc;
    /**临时主管id-政策法规处*/
    @TableField(value = "lsxmzgid_fgc")
	private String lsxmzgidFgc;
    /**临时主管id-直属机关党委*/
    @TableField(value = "lsxmzgid_zsjgdw")
	private String lsxmzgidZsjgdw;
    /**临时主管id-监察室*/
    @TableField(value = "lsxmzgid_jjs")
	private String lsxmzgidJjs;
    /**专家组名单*/
    @TableField(value = "zhuanjiazumingdan")
	private String zhuanjiazumingdan;
    /**处室处员意见*/
    @TableField(value = "chushiopinion")
	private String chushiopinion;
    /**当年拟安排经费*/
    @TableField(value = "dnjf")
	private Double dnjf;
    /**重大专项集中评审领域分类*/
    @TableField(value = "jzpyfl")
	private String jzpyfl;
    /**集中评审分组*/
    @TableField(value = "jzpsfz")
	private String jzpsfz;
    /**集中评审行业项目*/
    @TableField(value = "jzpshyxm")
	private String jzpshyxm;
    /**科技厅综合意见*/
    @TableField(value = "kjtopinion")
	private String kjtopinion;
    /**默认排序*/
    @TableField(value = "defaultindex")
	private Double defaultindex;
    /**CREATETIME*/
    @TableField(value = "createtime")
	private Double createtime;
    /**CREATELABORFEE*/
    @TableField(value = "createlaborfee")
	private Double createlaborfee;
    /**TOTALLABOR*/
    @TableField(value = "totallabor")
	private Double totallabor;
    /**PROFESSIONALTITLE*/
    @TableField(value = "professionaltitle")
	private String professionaltitle;
    /**COUNTUNIT*/
    @TableField(value = "countunit")
	private String countunit;
    /**TESTCONTENTUNIT*/
    @TableField(value = "testcontentunit")
	private String testcontentunit;
    /**TESTCONTENT*/
    @TableField(value = "testcontent")
	private String testcontent;
    /**显示状态*/
    @TableField(value = "showstate")
	private String showstate;
    /**甲方补助经费*/
    @TableField(value = "jfbzjf")
	private Double jfbzjf;
    /**合同流程状态*/
    @TableField(value = "htlczt")
	private String htlczt;
    /**合同编号*/
    @TableField(value = "contractno")
	private String contractno;
    /**合同名称*/
    @TableField(value = "contractname")
	private String contractname;
    /**联审状态-计财处*/
    @TableField(value = "act_jcc")
	private String actJcc;
    /**联审状态-人事处*/
    @TableField(value = "act_rsc")
	private String actRsc;
    /**联审状态-基建办*/
    @TableField(value = "act_jjb")
	private String actJjb;
    /**主管id-计财处*/
    @TableField(value = "xmzgid_jcc")
	private String xmzgidJcc;
    /**主管id-人事处*/
    @TableField(value = "xmzgid_rsc")
	private String xmzgidRsc;
    /**主管id-基建办*/
    @TableField(value = "xmzgid_jjb")
	private String xmzgidJjb;
    /**临时主管id-计财处*/
    @TableField(value = "lsxmzgid_jcc")
	private String lsxmzgidJcc;
    /**临时主管id-人事处*/
    @TableField(value = "lsxmzgid_rsc")
	private String lsxmzgidRsc;
    /**合同申请单位*/
    @TableField(value = "cddwmc")
	private String cddwmc;
    /**合同项目负责人*/
    @TableField(value = "htxmfzr")
	private String htxmfzr;
    /**项目活动类型*/
    @TableField(value = "xmhdlx")
	private String xmhdlx;
    /**项目与《技术榜单》或《指南》的衔接性*/
    @TableField(value = "xmyzntype")
	private String xmyzntype;
    /**领域*/
    @TableField(value = "xmyznly")
	private String xmyznly;
    /**主题*/
    @TableField(value = "xmyznzt")
	private String xmyznzt;
    /**XMYZNDESC*/
    @TableField(value = "xmyzndesc")
	private String xmyzndesc;
    /**项目完成时的应用类型*/
    @TableField(value = "xmwcslx")
	private String xmwcslx;
    /**项目活动类型编码*/
    @TableField(value = "xmhdlxcode")
	private String xmhdlxcode;
    /**联系电话*/
    @TableField(value = "projectleaderphone")
	private String projectleaderphone;
    /**SSJSLY*/
    @TableField(value = "ssjsly")
	private String ssjsly;
    /**SSJSLYCODE*/
    @TableField(value = "ssjslycode")
	private String ssjslycode;
    /**XMWCSLXCODE*/
    @TableField(value = "xmwcslxcode")
	private String xmwcslxcode;
    /**项目三查类型， 1、代表查新，2、代表专利检索*/
    @TableField(value = "projectsearchtype")
	private String projectsearchtype;
    /**是否属于国家秘密*/
    @TableField(value = "sfsygjmm")
	private String sfsygjmm;
    /**SUPERUSER*/
    @TableField(value = "superuser")
	private String superuser;
    /**项目类型*/
    @TableField(value = "xmlx")
	private String xmlx;
    /**关键字*/
    @TableField(value = "keywords")
	private String keywords;
    /**英文关键字*/
    @TableField(value = "enkeywords")
	private String enkeywords;
    /**负责人身份证*/
    @TableField(value = "leadercertificateno")
	private String leadercertificateno;
    /**是否可用*/
    @TableField(value = "isable")
	private String isable;
    /**材料是否被退回过*/
    @TableField(value = "isbackstuff")
	private Double isbackstuff;
    /**IZTEAMID*/
    @TableField(value = "izteamid")
	private String izteamid;
    /**是否进入评审*/
    @TableField(value = "isreview")
	private Double isreview;
    /**ISMEETING*/
    @TableField(value = "ismeeting")
	private Double ismeeting;
    /**合同ID*/
    @TableField(value = "pactid")
	private String pactid;
    /**实施内容*/
    @TableField(value = "implcontent")
	private String implcontent;
    /**OLDPLANNO*/
    @TableField(value = "oldplanno")
	private String oldplanno;
	
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
	 * 获取  enterpriseorusersid
	 *@return: String  企业id
	 */
	public String getEnterpriseorusersid(){
		return this.enterpriseorusersid;
	}

	/**
	 * 设置  enterpriseorusersid
	 *@param: enterpriseorusersid  企业id
	 */
	public void setEnterpriseorusersid(String enterpriseorusersid){
		this.enterpriseorusersid = enterpriseorusersid;
	}
	/**
	 * 获取  planprojectbatchid
	 *@return: String  申报项目批次ID
	 */
	public String getPlanprojectbatchid(){
		return this.planprojectbatchid;
	}

	/**
	 * 设置  planprojectbatchid
	 *@param: planprojectbatchid  申报项目批次ID
	 */
	public void setPlanprojectbatchid(String planprojectbatchid){
		this.planprojectbatchid = planprojectbatchid;
	}
	/**
	 * 获取  projectstartdate
	 *@return: Date  项目开始日期
	 */
	public Date getProjectstartdate(){
		return this.projectstartdate;
	}

	/**
	 * 设置  projectstartdate
	 *@param: projectstartdate  项目开始日期
	 */
	public void setProjectstartdate(Date projectstartdate){
		this.projectstartdate = projectstartdate;
	}
	/**
	 * 获取  projectenddate
	 *@return: Date  项目结束日期
	 */
	public Date getProjectenddate(){
		return this.projectenddate;
	}

	/**
	 * 设置  projectenddate
	 *@param: projectenddate  项目结束日期
	 */
	public void setProjectenddate(Date projectenddate){
		this.projectenddate = projectenddate;
	}
	/**
	 * 获取  projectsumforself
	 *@return: Double  自费多少
	 */
	public Double getProjectsumforself(){
		return this.projectsumforself;
	}

	/**
	 * 设置  projectsumforself
	 *@param: projectsumforself  自费多少
	 */
	public void setProjectsumforself(Double projectsumforself){
		this.projectsumforself = projectsumforself;
	}
	/**
	 * 获取  projectsumforgov
	 *@return: Double  向政府申请经费
	 */
	public Double getProjectsumforgov(){
		return this.projectsumforgov;
	}

	/**
	 * 设置  projectsumforgov
	 *@param: projectsumforgov  向政府申请经费
	 */
	public void setProjectsumforgov(Double projectsumforgov){
		this.projectsumforgov = projectsumforgov;
	}
	/**
	 * 获取  projecttotalsum
	 *@return: Double  项目总费用
	 */
	public Double getProjecttotalsum(){
		return this.projecttotalsum;
	}

	/**
	 * 设置  projecttotalsum
	 *@param: projecttotalsum  项目总费用
	 */
	public void setProjecttotalsum(Double projecttotalsum){
		this.projecttotalsum = projecttotalsum;
	}
	/**
	 * 获取  economicbenefit
	 *@return: String  项目经济效益
	 */
	public String getEconomicbenefit(){
		return this.economicbenefit;
	}

	/**
	 * 设置  economicbenefit
	 *@param: economicbenefit  项目经济效益
	 */
	public void setEconomicbenefit(String economicbenefit){
		this.economicbenefit = economicbenefit;
	}
	/**
	 * 获取  projectcontent1
	 *@return: String  项目内容
	 */
	public String getProjectcontent1(){
		return this.projectcontent1;
	}

	/**
	 * 设置  projectcontent1
	 *@param: projectcontent1  项目内容
	 */
	public void setProjectcontent1(String projectcontent1){
		this.projectcontent1 = projectcontent1;
	}
	/**
	 * 获取  projectachievement1
	 *@return: String  项目效益
	 */
	public String getProjectachievement1(){
		return this.projectachievement1;
	}

	/**
	 * 设置  projectachievement1
	 *@param: projectachievement1  项目效益
	 */
	public void setProjectachievement1(String projectachievement1){
		this.projectachievement1 = projectachievement1;
	}
	/**
	 * 获取  projectbasename
	 *@return: String  项目名称
	 */
	public String getProjectbasename(){
		return this.projectbasename;
	}

	/**
	 * 设置  projectbasename
	 *@param: projectbasename  项目名称
	 */
	public void setProjectbasename(String projectbasename){
		this.projectbasename = projectbasename;
	}
	/**
	 * 获取  declarant
	 *@return: String  申报人
	 */
	public String getDeclarant(){
		return this.declarant;
	}

	/**
	 * 设置  declarant
	 *@param: declarant  申报人
	 */
	public void setDeclarant(String declarant){
		this.declarant = declarant;
	}
	/**
	 * 获取  accountfirmid
	 *@return: String  律师事务所
	 */
	public String getAccountfirmid(){
		return this.accountfirmid;
	}

	/**
	 * 设置  accountfirmid
	 *@param: accountfirmid  律师事务所
	 */
	public void setAccountfirmid(String accountfirmid){
		this.accountfirmid = accountfirmid;
	}
	/**
	 * 获取  projectleader
	 *@return: String  项目负责人
	 */
	public String getProjectleader(){
		return this.projectleader;
	}

	/**
	 * 设置  projectleader
	 *@param: projectleader  项目负责人
	 */
	public void setProjectleader(String projectleader){
		this.projectleader = projectleader;
	}
	/**
	 * 获取  applyspecialname
	 *@return: String  申请专项名称
	 */
	public String getApplyspecialname(){
		return this.applyspecialname;
	}

	/**
	 * 设置  applyspecialname
	 *@param: applyspecialname  申请专项名称
	 */
	public void setApplyspecialname(String applyspecialname){
		this.applyspecialname = applyspecialname;
	}
	/**
	 * 获取  projectapplytype
	 *@return: String  项目申请类型
	 */
	public String getProjectapplytype(){
		return this.projectapplytype;
	}

	/**
	 * 设置  projectapplytype
	 *@param: projectapplytype  项目申请类型
	 */
	public void setProjectapplytype(String projectapplytype){
		this.projectapplytype = projectapplytype;
	}
	/**
	 * 获取  projectplantype
	 *@return: String  项目计划类型
	 */
	public String getProjectplantype(){
		return this.projectplantype;
	}

	/**
	 * 设置  projectplantype
	 *@param: projectplantype  项目计划类型
	 */
	public void setProjectplantype(String projectplantype){
		this.projectplantype = projectplantype;
	}
	/**
	 * 获取  technologicalmode
	 *@return: String  技术创新方式
	 */
	public String getTechnologicalmode(){
		return this.technologicalmode;
	}

	/**
	 * 设置  technologicalmode
	 *@param: technologicalmode  技术创新方式
	 */
	public void setTechnologicalmode(String technologicalmode){
		this.technologicalmode = technologicalmode;
	}
	/**
	 * 获取  projectmanagedomain
	 *@return: String  项目管理领域
	 */
	public String getProjectmanagedomain(){
		return this.projectmanagedomain;
	}

	/**
	 * 设置  projectmanagedomain
	 *@param: projectmanagedomain  项目管理领域
	 */
	public void setProjectmanagedomain(String projectmanagedomain){
		this.projectmanagedomain = projectmanagedomain;
	}
	/**
	 * 获取  appropriationtype
	 *@return: String  申请拨款方式
	 */
	public String getAppropriationtype(){
		return this.appropriationtype;
	}

	/**
	 * 设置  appropriationtype
	 *@param: appropriationtype  申请拨款方式
	 */
	public void setAppropriationtype(String appropriationtype){
		this.appropriationtype = appropriationtype;
	}
	/**
	 * 获取  technologicalsource
	 *@return: String  技术来源
	 */
	public String getTechnologicalsource(){
		return this.technologicalsource;
	}

	/**
	 * 设置  technologicalsource
	 *@param: technologicalsource  技术来源
	 */
	public void setTechnologicalsource(String technologicalsource){
		this.technologicalsource = technologicalsource;
	}
	/**
	 * 获取  maincurrentstate
	 *@return: String  主流程状态
	 */
	public String getMaincurrentstate(){
		return this.maincurrentstate;
	}

	/**
	 * 设置  maincurrentstate
	 *@param: maincurrentstate  主流程状态
	 */
	public void setMaincurrentstate(String maincurrentstate){
		this.maincurrentstate = maincurrentstate;
	}
	/**
	 * 获取  maincurrentstateid
	 *@return: String  主流程状态ID
	 */
	public String getMaincurrentstateid(){
		return this.maincurrentstateid;
	}

	/**
	 * 设置  maincurrentstateid
	 *@param: maincurrentstateid  主流程状态ID
	 */
	public void setMaincurrentstateid(String maincurrentstateid){
		this.maincurrentstateid = maincurrentstateid;
	}
	/**
	 * 获取  minicurrentstate
	 *@return: String  子状态
	 */
	public String getMinicurrentstate(){
		return this.minicurrentstate;
	}

	/**
	 * 设置  minicurrentstate
	 *@param: minicurrentstate  子状态
	 */
	public void setMinicurrentstate(String minicurrentstate){
		this.minicurrentstate = minicurrentstate;
	}
	/**
	 * 获取  minicurrentstateid
	 *@return: String  子状态ID
	 */
	public String getMinicurrentstateid(){
		return this.minicurrentstateid;
	}

	/**
	 * 设置  minicurrentstateid
	 *@param: minicurrentstateid  子状态ID
	 */
	public void setMinicurrentstateid(String minicurrentstateid){
		this.minicurrentstateid = minicurrentstateid;
	}
	/**
	 * 获取  applydate
	 *@return: Date  项目申请时间
	 */
	public Date getApplydate(){
		return this.applydate;
	}

	/**
	 * 设置  applydate
	 *@param: applydate  项目申请时间
	 */
	public void setApplydate(Date applydate){
		this.applydate = applydate;
	}
	/**
	 * 获取  expectedbenefitachievement
	 *@return: String  预计经济效益和成果
	 */
	public String getExpectedbenefitachievement(){
		return this.expectedbenefitachievement;
	}

	/**
	 * 设置  expectedbenefitachievement
	 *@param: expectedbenefitachievement  预计经济效益和成果
	 */
	public void setExpectedbenefitachievement(String expectedbenefitachievement){
		this.expectedbenefitachievement = expectedbenefitachievement;
	}
	/**
	 * 获取  declarantid
	 *@return: String  申报人\单位id
	 */
	public String getDeclarantid(){
		return this.declarantid;
	}

	/**
	 * 设置  declarantid
	 *@param: declarantid  申报人\单位id
	 */
	public void setDeclarantid(String declarantid){
		this.declarantid = declarantid;
	}
	/**
	 * 获取  mainorganizers
	 *@return: String  主办单位
	 */
	public String getMainorganizers(){
		return this.mainorganizers;
	}

	/**
	 * 设置  mainorganizers
	 *@param: mainorganizers  主办单位
	 */
	public void setMainorganizers(String mainorganizers){
		this.mainorganizers = mainorganizers;
	}
	/**
	 * 获取  researchcontent1
	 *@return: String  研发内容与预期目标凝练
	 */
	public String getResearchcontent1(){
		return this.researchcontent1;
	}

	/**
	 * 设置  researchcontent1
	 *@param: researchcontent1  研发内容与预期目标凝练
	 */
	public void setResearchcontent1(String researchcontent1){
		this.researchcontent1 = researchcontent1;
	}
	/**
	 * 获取  projectimplementation
	 *@return: String  项目实施主要任务和目标
	 */
	public String getProjectimplementation(){
		return this.projectimplementation;
	}

	/**
	 * 设置  projectimplementation
	 *@param: projectimplementation  项目实施主要任务和目标
	 */
	public void setProjectimplementation(String projectimplementation){
		this.projectimplementation = projectimplementation;
	}
	/**
	 * 获取  researchinput
	 *@return: String  上年度研发投入
	 */
	public String getResearchinput(){
		return this.researchinput;
	}

	/**
	 * 设置  researchinput
	 *@param: researchinput  上年度研发投入
	 */
	public void setResearchinput(String researchinput){
		this.researchinput = researchinput;
	}
	/**
	 * 获取  mainbusinessincome
	 *@return: String  上年度主营业务收入
	 */
	public String getMainbusinessincome(){
		return this.mainbusinessincome;
	}

	/**
	 * 设置  mainbusinessincome
	 *@param: mainbusinessincome  上年度主营业务收入
	 */
	public void setMainbusinessincome(String mainbusinessincome){
		this.mainbusinessincome = mainbusinessincome;
	}
	/**
	 * 获取  enterprisetypes
	 *@return: String  企业类型
	 */
	public String getEnterprisetypes(){
		return this.enterprisetypes;
	}

	/**
	 * 设置  enterprisetypes
	 *@param: enterprisetypes  企业类型
	 */
	public void setEnterprisetypes(String enterprisetypes){
		this.enterprisetypes = enterprisetypes;
	}
	/**
	 * 获取  researchinstitutions
	 *@return: String  研发机构情况
	 */
	public String getResearchinstitutions(){
		return this.researchinstitutions;
	}

	/**
	 * 设置  researchinstitutions
	 *@param: researchinstitutions  研发机构情况
	 */
	public void setResearchinstitutions(String researchinstitutions){
		this.researchinstitutions = researchinstitutions;
	}
	/**
	 * 获取  applicationno
	 *@return: String  申请编号
	 */
	public String getApplicationno(){
		return this.applicationno;
	}

	/**
	 * 设置  applicationno
	 *@param: applicationno  申请编号
	 */
	public void setApplicationno(String applicationno){
		this.applicationno = applicationno;
	}
	/**
	 * 获取  techdomain
	 *@return: String  技术领域
	 */
	public String getTechdomain(){
		return this.techdomain;
	}

	/**
	 * 设置  techdomain
	 *@param: techdomain  技术领域
	 */
	public void setTechdomain(String techdomain){
		this.techdomain = techdomain;
	}
	/**
	 * 获取  submitdate
	 *@return: Date  提交时间
	 */
	public Date getSubmitdate(){
		return this.submitdate;
	}

	/**
	 * 设置  submitdate
	 *@param: submitdate  提交时间
	 */
	public void setSubmitdate(Date submitdate){
		this.submitdate = submitdate;
	}
	/**
	 * 获取  iscancel
	 *@return: Double  是否作废
	 */
	public Double getIscancel(){
		return this.iscancel;
	}

	/**
	 * 设置  iscancel
	 *@param: iscancel  是否作废
	 */
	public void setIscancel(Double iscancel){
		this.iscancel = iscancel;
	}
	/**
	 * 获取  issetup
	 *@return: Double  是否立项
	 */
	public Double getIssetup(){
		return this.issetup;
	}

	/**
	 * 设置  issetup
	 *@param: issetup  是否立项
	 */
	public void setIssetup(Double issetup){
		this.issetup = issetup;
	}
	/**
	 * 获取  createdate
	 *@return: Date  创建日期
	 */
	public Date getCreatedate(){
		return this.createdate;
	}

	/**
	 * 设置  createdate
	 *@param: createdate  创建日期
	 */
	public void setCreatedate(Date createdate){
		this.createdate = createdate;
	}
	/**
	 * 获取  chiefdepartment
	 *@return: String  (主管处室)
	 */
	public String getChiefdepartment(){
		return this.chiefdepartment;
	}

	/**
	 * 设置  chiefdepartment
	 *@param: chiefdepartment  (主管处室)
	 */
	public void setChiefdepartment(String chiefdepartment){
		this.chiefdepartment = chiefdepartment;
	}
	/**
	 * 获取  chieldofficals
	 *@return: String  (项目主管)
	 */
	public String getChieldofficals(){
		return this.chieldofficals;
	}

	/**
	 * 设置  chieldofficals
	 *@param: chieldofficals  (项目主管)
	 */
	public void setChieldofficals(String chieldofficals){
		this.chieldofficals = chieldofficals;
	}
	/**
	 * 获取  casemanagement
	 *@return: String  (归口管理部门)
	 */
	public String getCasemanagement(){
		return this.casemanagement;
	}

	/**
	 * 设置  casemanagement
	 *@param: casemanagement  (归口管理部门)
	 */
	public void setCasemanagement(String casemanagement){
		this.casemanagement = casemanagement;
	}
	/**
	 * 获取  planno
	 *@return: String  计划编号
	 */
	public String getPlanno(){
		return this.planno;
	}

	/**
	 * 设置  planno
	 *@param: planno  计划编号
	 */
	public void setPlanno(String planno){
		this.planno = planno;
	}
	/**
	 * 获取  projectclassification
	 *@return: String  项目行业分类
	 */
	public String getProjectclassification(){
		return this.projectclassification;
	}

	/**
	 * 设置  projectclassification
	 *@param: projectclassification  项目行业分类
	 */
	public void setProjectclassification(String projectclassification){
		this.projectclassification = projectclassification;
	}
	/**
	 * 获取  projectresults
	 *@return: String  项目成果提供形式
	 */
	public String getProjectresults(){
		return this.projectresults;
	}

	/**
	 * 设置  projectresults
	 *@param: projectresults  项目成果提供形式
	 */
	public void setProjectresults(String projectresults){
		this.projectresults = projectresults;
	}
	/**
	 * 获取  projectfeatureinforid
	 *@return: String  特征信息id
	 */
	public String getProjectfeatureinforid(){
		return this.projectfeatureinforid;
	}

	/**
	 * 设置  projectfeatureinforid
	 *@param: projectfeatureinforid  特征信息id
	 */
	public void setProjectfeatureinforid(String projectfeatureinforid){
		this.projectfeatureinforid = projectfeatureinforid;
	}
	/**
	 * 获取  applyspecialnamecode
	 *@return: String  申请专项名称代码
	 */
	public String getApplyspecialnamecode(){
		return this.applyspecialnamecode;
	}

	/**
	 * 设置  applyspecialnamecode
	 *@param: applyspecialnamecode  申请专项名称代码
	 */
	public void setApplyspecialnamecode(String applyspecialnamecode){
		this.applyspecialnamecode = applyspecialnamecode;
	}
	/**
	 * 获取  projectapplytypecode
	 *@return: String  项目申请类型代码
	 */
	public String getProjectapplytypecode(){
		return this.projectapplytypecode;
	}

	/**
	 * 设置  projectapplytypecode
	 *@param: projectapplytypecode  项目申请类型代码
	 */
	public void setProjectapplytypecode(String projectapplytypecode){
		this.projectapplytypecode = projectapplytypecode;
	}
	/**
	 * 获取  projectplantypecode
	 *@return: String  项目计划类型代码
	 */
	public String getProjectplantypecode(){
		return this.projectplantypecode;
	}

	/**
	 * 设置  projectplantypecode
	 *@param: projectplantypecode  项目计划类型代码
	 */
	public void setProjectplantypecode(String projectplantypecode){
		this.projectplantypecode = projectplantypecode;
	}
	/**
	 * 获取  technologicalmodecode
	 *@return: String  技术创新方式代码
	 */
	public String getTechnologicalmodecode(){
		return this.technologicalmodecode;
	}

	/**
	 * 设置  technologicalmodecode
	 *@param: technologicalmodecode  技术创新方式代码
	 */
	public void setTechnologicalmodecode(String technologicalmodecode){
		this.technologicalmodecode = technologicalmodecode;
	}
	/**
	 * 获取  projectmanagedomaincode
	 *@return: String  项目管理领域代码
	 */
	public String getProjectmanagedomaincode(){
		return this.projectmanagedomaincode;
	}

	/**
	 * 设置  projectmanagedomaincode
	 *@param: projectmanagedomaincode  项目管理领域代码
	 */
	public void setProjectmanagedomaincode(String projectmanagedomaincode){
		this.projectmanagedomaincode = projectmanagedomaincode;
	}
	/**
	 * 获取  appropriationtypecode
	 *@return: String  申请拨款方式代码
	 */
	public String getAppropriationtypecode(){
		return this.appropriationtypecode;
	}

	/**
	 * 设置  appropriationtypecode
	 *@param: appropriationtypecode  申请拨款方式代码
	 */
	public void setAppropriationtypecode(String appropriationtypecode){
		this.appropriationtypecode = appropriationtypecode;
	}
	/**
	 * 获取  technologicalsourcecode
	 *@return: String  技术来源代码
	 */
	public String getTechnologicalsourcecode(){
		return this.technologicalsourcecode;
	}

	/**
	 * 设置  technologicalsourcecode
	 *@param: technologicalsourcecode  技术来源代码
	 */
	public void setTechnologicalsourcecode(String technologicalsourcecode){
		this.technologicalsourcecode = technologicalsourcecode;
	}
	/**
	 * 获取  currentsate
	 *@return: String  当前状态
	 */
	public String getCurrentsate(){
		return this.currentsate;
	}

	/**
	 * 设置  currentsate
	 *@param: currentsate  当前状态
	 */
	public void setCurrentsate(String currentsate){
		this.currentsate = currentsate;
	}
	/**
	 * 获取  belonglab
	 *@return: String  初审所属处室
	 */
	public String getBelonglab(){
		return this.belonglab;
	}

	/**
	 * 设置  belonglab
	 *@param: belonglab  初审所属处室
	 */
	public void setBelonglab(String belonglab){
		this.belonglab = belonglab;
	}
	/**
	 * 获取  belonglabid
	 *@return: String  初审所属处室ID
	 */
	public String getBelonglabid(){
		return this.belonglabid;
	}

	/**
	 * 设置  belonglabid
	 *@param: belonglabid  初审所属处室ID
	 */
	public void setBelonglabid(String belonglabid){
		this.belonglabid = belonglabid;
	}
	/**
	 * 获取  industryfield
	 *@return: String  产业领域
	 */
	public String getIndustryfield(){
		return this.industryfield;
	}

	/**
	 * 设置  industryfield
	 *@param: industryfield  产业领域
	 */
	public void setIndustryfield(String industryfield){
		this.industryfield = industryfield;
	}
	/**
	 * 获取  techdomaincode
	 *@return: String  技术领域编码
	 */
	public String getTechdomaincode(){
		return this.techdomaincode;
	}

	/**
	 * 设置  techdomaincode
	 *@param: techdomaincode  技术领域编码
	 */
	public void setTechdomaincode(String techdomaincode){
		this.techdomaincode = techdomaincode;
	}
	/**
	 * 获取  industryfieldcode
	 *@return: String  产业领域编码
	 */
	public String getIndustryfieldcode(){
		return this.industryfieldcode;
	}

	/**
	 * 设置  industryfieldcode
	 *@param: industryfieldcode  产业领域编码
	 */
	public void setIndustryfieldcode(String industryfieldcode){
		this.industryfieldcode = industryfieldcode;
	}
	/**
	 * 获取  subjectareas
	 *@return: String  学科领域
	 */
	public String getSubjectareas(){
		return this.subjectareas;
	}

	/**
	 * 设置  subjectareas
	 *@param: subjectareas  学科领域
	 */
	public void setSubjectareas(String subjectareas){
		this.subjectareas = subjectareas;
	}
	/**
	 * 获取  subjectareascode
	 *@return: String  学科领域代码
	 */
	public String getSubjectareascode(){
		return this.subjectareascode;
	}

	/**
	 * 设置  subjectareascode
	 *@param: subjectareascode  学科领域代码
	 */
	public void setSubjectareascode(String subjectareascode){
		this.subjectareascode = subjectareascode;
	}
	/**
	 * 获取  technicalrank
	 *@return: String  技术领域
	 */
	public String getTechnicalrank(){
		return this.technicalrank;
	}

	/**
	 * 设置  technicalrank
	 *@param: technicalrank  技术领域
	 */
	public void setTechnicalrank(String technicalrank){
		this.technicalrank = technicalrank;
	}
	/**
	 * 获取  casemanagementcode
	 *@return: String  归口管理部门代码
	 */
	public String getCasemanagementcode(){
		return this.casemanagementcode;
	}

	/**
	 * 设置  casemanagementcode
	 *@param: casemanagementcode  归口管理部门代码
	 */
	public void setCasemanagementcode(String casemanagementcode){
		this.casemanagementcode = casemanagementcode;
	}
	/**
	 * 获取  casemanagementid
	 *@return: String  归口管理部门id
	 */
	public String getCasemanagementid(){
		return this.casemanagementid;
	}

	/**
	 * 设置  casemanagementid
	 *@param: casemanagementid  归口管理部门id
	 */
	public void setCasemanagementid(String casemanagementid){
		this.casemanagementid = casemanagementid;
	}
	/**
	 * 获取  projectclassificationcode
	 *@return: String  行业分类代码
	 */
	public String getProjectclassificationcode(){
		return this.projectclassificationcode;
	}

	/**
	 * 设置  projectclassificationcode
	 *@param: projectclassificationcode  行业分类代码
	 */
	public void setProjectclassificationcode(String projectclassificationcode){
		this.projectclassificationcode = projectclassificationcode;
	}
	/**
	 * 获取  shgyly
	 *@return: String  社会公益领域
	 */
	public String getShgyly(){
		return this.shgyly;
	}

	/**
	 * 设置  shgyly
	 *@param: shgyly  社会公益领域
	 */
	public void setShgyly(String shgyly){
		this.shgyly = shgyly;
	}
	/**
	 * 获取  shgylycode
	 *@return: String  社会公益领域代码
	 */
	public String getShgylycode(){
		return this.shgylycode;
	}

	/**
	 * 设置  shgylycode
	 *@param: shgylycode  社会公益领域代码
	 */
	public void setShgylycode(String shgylycode){
		this.shgylycode = shgylycode;
	}
	/**
	 * 获取  secondprojectname
	 *@return: String  副标题
	 */
	public String getSecondprojectname(){
		return this.secondprojectname;
	}

	/**
	 * 设置  secondprojectname
	 *@param: secondprojectname  副标题
	 */
	public void setSecondprojectname(String secondprojectname){
		this.secondprojectname = secondprojectname;
	}
	/**
	 * 获取  dayipingtai
	 *@return: String  云平台大仪平台
	 */
	public String getDayipingtai(){
		return this.dayipingtai;
	}

	/**
	 * 设置  dayipingtai
	 *@param: dayipingtai  云平台大仪平台
	 */
	public void setDayipingtai(String dayipingtai){
		this.dayipingtai = dayipingtai;
	}
	/**
	 * 获取  zaitimingcheng
	 *@return: String  云平台载体名称
	 */
	public String getZaitimingcheng(){
		return this.zaitimingcheng;
	}

	/**
	 * 设置  zaitimingcheng
	 *@param: zaitimingcheng  云平台载体名称
	 */
	public void setZaitimingcheng(String zaitimingcheng){
		this.zaitimingcheng = zaitimingcheng;
	}
	/**
	 * 获取  purposemean
	 *@return: String  项目实施目的意义
	 */
	public String getPurposemean(){
		return this.purposemean;
	}

	/**
	 * 设置  purposemean
	 *@param: purposemean  项目实施目的意义
	 */
	public void setPurposemean(String purposemean){
		this.purposemean = purposemean;
	}
	/**
	 * 获取  yptqiyeleixing
	 *@return: String  云平台企业类型
	 */
	public String getYptqiyeleixing(){
		return this.yptqiyeleixing;
	}

	/**
	 * 设置  yptqiyeleixing
	 *@param: yptqiyeleixing  云平台企业类型
	 */
	public void setYptqiyeleixing(String yptqiyeleixing){
		this.yptqiyeleixing = yptqiyeleixing;
	}
	/**
	 * 获取  researchcontent
	 *@return: String  研发内容与预期目标凝练
	 */
	public String getResearchcontent(){
		return this.researchcontent;
	}

	/**
	 * 设置  researchcontent
	 *@param: researchcontent  研发内容与预期目标凝练
	 */
	public void setResearchcontent(String researchcontent){
		this.researchcontent = researchcontent;
	}
	/**
	 * 获取  projectcontent
	 *@return: String  项目内容
	 */
	public String getProjectcontent(){
		return this.projectcontent;
	}

	/**
	 * 设置  projectcontent
	 *@param: projectcontent  项目内容
	 */
	public void setProjectcontent(String projectcontent){
		this.projectcontent = projectcontent;
	}
	/**
	 * 获取  projectachievement
	 *@return: String  项目效益
	 */
	public String getProjectachievement(){
		return this.projectachievement;
	}

	/**
	 * 设置  projectachievement
	 *@param: projectachievement  项目效益
	 */
	public void setProjectachievement(String projectachievement){
		this.projectachievement = projectachievement;
	}
	/**
	 * 获取  updatelasttime
	 *@return: Date  最后一次保存时间
	 */
	public Date getUpdatelasttime(){
		return this.updatelasttime;
	}

	/**
	 * 设置  updatelasttime
	 *@param: updatelasttime  最后一次保存时间
	 */
	public void setUpdatelasttime(Date updatelasttime){
		this.updatelasttime = updatelasttime;
	}
	/**
	 * 获取  achievesalesrevenue
	 *@return: Double  实现销售收入
	 */
	public Double getAchievesalesrevenue(){
		return this.achievesalesrevenue;
	}

	/**
	 * 设置  achievesalesrevenue
	 *@param: achievesalesrevenue  实现销售收入
	 */
	public void setAchievesalesrevenue(Double achievesalesrevenue){
		this.achievesalesrevenue = achievesalesrevenue;
	}
	/**
	 * 获取  profits
	 *@return: Double  实现利润
	 */
	public Double getProfits(){
		return this.profits;
	}

	/**
	 * 设置  profits
	 *@param: profits  实现利润
	 */
	public void setProfits(Double profits){
		this.profits = profits;
	}
	/**
	 * 获取  implementpaystaxes
	 *@return: Double  实现上缴税收
	 */
	public Double getImplementpaystaxes(){
		return this.implementpaystaxes;
	}

	/**
	 * 设置  implementpaystaxes
	 *@param: implementpaystaxes  实现上缴税收
	 */
	public void setImplementpaystaxes(Double implementpaystaxes){
		this.implementpaystaxes = implementpaystaxes;
	}
	/**
	 * 获取  zttype
	 *@return: String  载体类别
	 */
	public String getZttype(){
		return this.zttype;
	}

	/**
	 * 设置  zttype
	 *@param: zttype  载体类别
	 */
	public void setZttype(String zttype){
		this.zttype = zttype;
	}
	/**
	 * 获取  daxingyiqi
	 *@return: String  超过30万大型仪器信息填写情况 
	 */
	public String getDaxingyiqi(){
		return this.daxingyiqi;
	}

	/**
	 * 设置  daxingyiqi
	 *@param: daxingyiqi  超过30万大型仪器信息填写情况 
	 */
	public void setDaxingyiqi(String daxingyiqi){
		this.daxingyiqi = daxingyiqi;
	}
	/**
	 * 获取  chuangxinquan
	 *@return: String  创新券使用情况
	 */
	public String getChuangxinquan(){
		return this.chuangxinquan;
	}

	/**
	 * 设置  chuangxinquan
	 *@param: chuangxinquan  创新券使用情况
	 */
	public void setChuangxinquan(String chuangxinquan){
		this.chuangxinquan = chuangxinquan;
	}
	/**
	 * 获取  zaitimingchenid
	 *@return: String  载体名称ID
	 */
	public String getZaitimingchenid(){
		return this.zaitimingchenid;
	}

	/**
	 * 设置  zaitimingchenid
	 *@param: zaitimingchenid  载体名称ID
	 */
	public void setZaitimingchenid(String zaitimingchenid){
		this.zaitimingchenid = zaitimingchenid;
	}
	/**
	 * 获取  showprojectbasename
	 *@return: String  显示的项目名称
	 */
	public String getShowprojectbasename(){
		return this.showprojectbasename;
	}

	/**
	 * 设置  showprojectbasename
	 *@param: showprojectbasename  显示的项目名称
	 */
	public void setShowprojectbasename(String showprojectbasename){
		this.showprojectbasename = showprojectbasename;
	}
	/**
	 * 获取  batchname
	 *@return: String  批次名称
	 */
	public String getBatchname(){
		return this.batchname;
	}

	/**
	 * 设置  batchname
	 *@param: batchname  批次名称
	 */
	public void setBatchname(String batchname){
		this.batchname = batchname;
	}
	/**
	 * 获取  possessconditions
	 *@return: String  具备条件
	 */
	public String getPossessconditions(){
		return this.possessconditions;
	}

	/**
	 * 设置  possessconditions
	 *@param: possessconditions  具备条件
	 */
	public void setPossessconditions(String possessconditions){
		this.possessconditions = possessconditions;
	}
	/**
	 * 获取  actualpayment
	 *@return: Double  实际支付
	 */
	public Double getActualpayment(){
		return this.actualpayment;
	}

	/**
	 * 设置  actualpayment
	 *@param: actualpayment  实际支付
	 */
	public void setActualpayment(Double actualpayment){
		this.actualpayment = actualpayment;
	}
	/**
	 * 获取  truefalse
	 *@return: String  1为第二轮专家评审可选项目标志
	 */
	public String getTruefalse(){
		return this.truefalse;
	}

	/**
	 * 设置  truefalse
	 *@param: truefalse  1为第二轮专家评审可选项目标志
	 */
	public void setTruefalse(String truefalse){
		this.truefalse = truefalse;
	}
	/**
	 * 获取  expertresult
	 *@return: String  专家网评结果
	 */
	public String getExpertresult(){
		return this.expertresult;
	}

	/**
	 * 设置  expertresult
	 *@param: expertresult  专家网评结果
	 */
	public void setExpertresult(String expertresult){
		this.expertresult = expertresult;
	}
	/**
	 * 获取  csjyjf
	 *@return: Double  处室初审建议经费
	 */
	public Double getCsjyjf(){
		return this.csjyjf;
	}

	/**
	 * 设置  csjyjf
	 *@param: csjyjf  处室初审建议经费
	 */
	public void setCsjyjf(Double csjyjf){
		this.csjyjf = csjyjf;
	}
	/**
	 * 获取  cscsjg
	 *@return: String  处室处员初审结果
	 */
	public String getCscsjg(){
		return this.cscsjg;
	}

	/**
	 * 设置  cscsjg
	 *@param: cscsjg  处室处员初审结果
	 */
	public void setCscsjg(String cscsjg){
		this.cscsjg = cscsjg;
	}
	/**
	 * 获取  csczjyjf
	 *@return: Double  处室处长建议经费
	 */
	public Double getCsczjyjf(){
		return this.csczjyjf;
	}

	/**
	 * 设置  csczjyjf
	 *@param: csczjyjf  处室处长建议经费
	 */
	public void setCsczjyjf(Double csczjyjf){
		this.csczjyjf = csczjyjf;
	}
	/**
	 * 获取  csczshjg
	 *@return: String  处室处长初审结果
	 */
	public String getCsczshjg(){
		return this.csczshjg;
	}

	/**
	 * 设置  csczshjg
	 *@param: csczshjg  处室处长初审结果
	 */
	public void setCsczshjg(String csczshjg){
		this.csczshjg = csczshjg;
	}
	/**
	 * 获取  finalprojectname
	 *@return: String  立项项目名称
	 */
	public String getFinalprojectname(){
		return this.finalprojectname;
	}

	/**
	 * 设置  finalprojectname
	 *@param: finalprojectname  立项项目名称
	 */
	public void setFinalprojectname(String finalprojectname){
		this.finalprojectname = finalprojectname;
	}
	/**
	 * 获取  finaltaskprojectname
	 *@return: String  立项课题名称
	 */
	public String getFinaltaskprojectname(){
		return this.finaltaskprojectname;
	}

	/**
	 * 设置  finaltaskprojectname
	 *@param: finaltaskprojectname  立项课题名称
	 */
	public void setFinaltaskprojectname(String finaltaskprojectname){
		this.finaltaskprojectname = finaltaskprojectname;
	}
	/**
	 * 获取  xmzgid
	 *@return: String  分配的项目主管id
	 */
	public String getXmzgid(){
		return this.xmzgid;
	}

	/**
	 * 设置  xmzgid
	 *@param: xmzgid  分配的项目主管id
	 */
	public void setXmzgid(String xmzgid){
		this.xmzgid = xmzgid;
	}
	/**
	 * 获取  lsxmzgid
	 *@return: String  临时分配的项目主管id
	 */
	public String getLsxmzgid(){
		return this.lsxmzgid;
	}

	/**
	 * 设置  lsxmzgid
	 *@param: lsxmzgid  临时分配的项目主管id
	 */
	public void setLsxmzgid(String lsxmzgid){
		this.lsxmzgid = lsxmzgid;
	}
	/**
	 * 获取  activitiid
	 *@return: String  流程id
	 */
	public String getActivitiid(){
		return this.activitiid;
	}

	/**
	 * 设置  activitiid
	 *@param: activitiid  流程id
	 */
	public void setActivitiid(String activitiid){
		this.activitiid = activitiid;
	}
	/**
	 * 获取  planprojectbatchid2
	 *@return: String  申报项目批次ID2
	 */
	public String getPlanprojectbatchid2(){
		return this.planprojectbatchid2;
	}

	/**
	 * 设置  planprojectbatchid2
	 *@param: planprojectbatchid2  申报项目批次ID2
	 */
	public void setPlanprojectbatchid2(String planprojectbatchid2){
		this.planprojectbatchid2 = planprojectbatchid2;
	}
	/**
	 * 获取  actGxc
	 *@return: String  联审状态-高新技术发展及产业化处
	 */
	public String getActGxc(){
		return this.actGxc;
	}

	/**
	 * 设置  actGxc
	 *@param: actGxc  联审状态-高新技术发展及产业化处
	 */
	public void setActGxc(String actGxc){
		this.actGxc = actGxc;
	}
	/**
	 * 获取  actKjc
	 *@return: String  联审状态-科技条件与基础研究处
	 */
	public String getActKjc(){
		return this.actKjc;
	}

	/**
	 * 设置  actKjc
	 *@param: actKjc  联审状态-科技条件与基础研究处
	 */
	public void setActKjc(String actKjc){
		this.actKjc = actKjc;
	}
	/**
	 * 获取  actSfc
	 *@return: String  联审状态-社会发展科技处
	 */
	public String getActSfc(){
		return this.actSfc;
	}

	/**
	 * 设置  actSfc
	 *@param: actSfc  联审状态-社会发展科技处
	 */
	public void setActSfc(String actSfc){
		this.actSfc = actSfc;
	}
	/**
	 * 获取  actGjc
	 *@return: String  联审状态-国际科技合作处
	 */
	public String getActGjc(){
		return this.actGjc;
	}

	/**
	 * 设置  actGjc
	 *@param: actGjc  联审状态-国际科技合作处
	 */
	public void setActGjc(String actGjc){
		this.actGjc = actGjc;
	}
	/**
	 * 获取  actZsc
	 *@return: String  联审状态-知识产权发展处
	 */
	public String getActZsc(){
		return this.actZsc;
	}

	/**
	 * 设置  actZsc
	 *@param: actZsc  联审状态-知识产权发展处
	 */
	public void setActZsc(String actZsc){
		this.actZsc = actZsc;
	}
	/**
	 * 获取  actZlglc
	 *@return: String  联审状态-专利管理处
	 */
	public String getActZlglc(){
		return this.actZlglc;
	}

	/**
	 * 设置  actZlglc
	 *@param: actZlglc  联审状态-专利管理处
	 */
	public void setActZlglc(String actZlglc){
		this.actZlglc = actZlglc;
	}
	/**
	 * 获取  actZlbhc
	 *@return: String  联审状态-专利保护处
	 */
	public String getActZlbhc(){
		return this.actZlbhc;
	}

	/**
	 * 设置  actZlbhc
	 *@param: actZlbhc  联审状态-专利保护处
	 */
	public void setActZlbhc(String actZlbhc){
		this.actZlbhc = actZlbhc;
	}
	/**
	 * 获取  actCxc
	 *@return: String  联审状态-产学研合作与成果转化处
	 */
	public String getActCxc(){
		return this.actCxc;
	}

	/**
	 * 设置  actCxc
	 *@param: actCxc  联审状态-产学研合作与成果转化处
	 */
	public void setActCxc(String actCxc){
		this.actCxc = actCxc;
	}
	/**
	 * 获取  actNcc
	 *@return: String  联审状态-农村科技处
	 */
	public String getActNcc(){
		return this.actNcc;
	}

	/**
	 * 设置  actNcc
	 *@param: actNcc  联审状态-农村科技处
	 */
	public void setActNcc(String actNcc){
		this.actNcc = actNcc;
	}
	/**
	 * 获取  actFgc
	 *@return: String  联审状态-政策法规处
	 */
	public String getActFgc(){
		return this.actFgc;
	}

	/**
	 * 设置  actFgc
	 *@param: actFgc  联审状态-政策法规处
	 */
	public void setActFgc(String actFgc){
		this.actFgc = actFgc;
	}
	/**
	 * 获取  actZsjgdw
	 *@return: String  联审状态-直属机关党委
	 */
	public String getActZsjgdw(){
		return this.actZsjgdw;
	}

	/**
	 * 设置  actZsjgdw
	 *@param: actZsjgdw  联审状态-直属机关党委
	 */
	public void setActZsjgdw(String actZsjgdw){
		this.actZsjgdw = actZsjgdw;
	}
	/**
	 * 获取  actJjs
	 *@return: String  联审状态-监察室
	 */
	public String getActJjs(){
		return this.actJjs;
	}

	/**
	 * 设置  actJjs
	 *@param: actJjs  联审状态-监察室
	 */
	public void setActJjs(String actJjs){
		this.actJjs = actJjs;
	}
	/**
	 * 获取  xmzgidGxc
	 *@return: String  主管id-高新技术发展及产业化处
	 */
	public String getXmzgidGxc(){
		return this.xmzgidGxc;
	}

	/**
	 * 设置  xmzgidGxc
	 *@param: xmzgidGxc  主管id-高新技术发展及产业化处
	 */
	public void setXmzgidGxc(String xmzgidGxc){
		this.xmzgidGxc = xmzgidGxc;
	}
	/**
	 * 获取  xmzgidKjc
	 *@return: String  主管id-科技条件与基础研究处
	 */
	public String getXmzgidKjc(){
		return this.xmzgidKjc;
	}

	/**
	 * 设置  xmzgidKjc
	 *@param: xmzgidKjc  主管id-科技条件与基础研究处
	 */
	public void setXmzgidKjc(String xmzgidKjc){
		this.xmzgidKjc = xmzgidKjc;
	}
	/**
	 * 获取  xmzgidSfc
	 *@return: String  主管id-社会发展科技处
	 */
	public String getXmzgidSfc(){
		return this.xmzgidSfc;
	}

	/**
	 * 设置  xmzgidSfc
	 *@param: xmzgidSfc  主管id-社会发展科技处
	 */
	public void setXmzgidSfc(String xmzgidSfc){
		this.xmzgidSfc = xmzgidSfc;
	}
	/**
	 * 获取  xmzgidGjc
	 *@return: String  主管id-国际科技合作处
	 */
	public String getXmzgidGjc(){
		return this.xmzgidGjc;
	}

	/**
	 * 设置  xmzgidGjc
	 *@param: xmzgidGjc  主管id-国际科技合作处
	 */
	public void setXmzgidGjc(String xmzgidGjc){
		this.xmzgidGjc = xmzgidGjc;
	}
	/**
	 * 获取  xmzgidZsc
	 *@return: String  主管id-知识产权发展处
	 */
	public String getXmzgidZsc(){
		return this.xmzgidZsc;
	}

	/**
	 * 设置  xmzgidZsc
	 *@param: xmzgidZsc  主管id-知识产权发展处
	 */
	public void setXmzgidZsc(String xmzgidZsc){
		this.xmzgidZsc = xmzgidZsc;
	}
	/**
	 * 获取  xmzgidZlglc
	 *@return: String  主管id-专利管理处
	 */
	public String getXmzgidZlglc(){
		return this.xmzgidZlglc;
	}

	/**
	 * 设置  xmzgidZlglc
	 *@param: xmzgidZlglc  主管id-专利管理处
	 */
	public void setXmzgidZlglc(String xmzgidZlglc){
		this.xmzgidZlglc = xmzgidZlglc;
	}
	/**
	 * 获取  xmzgidZlbhc
	 *@return: String  主管id-专利保护处
	 */
	public String getXmzgidZlbhc(){
		return this.xmzgidZlbhc;
	}

	/**
	 * 设置  xmzgidZlbhc
	 *@param: xmzgidZlbhc  主管id-专利保护处
	 */
	public void setXmzgidZlbhc(String xmzgidZlbhc){
		this.xmzgidZlbhc = xmzgidZlbhc;
	}
	/**
	 * 获取  xmzgidCxc
	 *@return: String  主管id-产学研合作与成果转化处
	 */
	public String getXmzgidCxc(){
		return this.xmzgidCxc;
	}

	/**
	 * 设置  xmzgidCxc
	 *@param: xmzgidCxc  主管id-产学研合作与成果转化处
	 */
	public void setXmzgidCxc(String xmzgidCxc){
		this.xmzgidCxc = xmzgidCxc;
	}
	/**
	 * 获取  xmzgidNcc
	 *@return: String  主管id-农村科技处
	 */
	public String getXmzgidNcc(){
		return this.xmzgidNcc;
	}

	/**
	 * 设置  xmzgidNcc
	 *@param: xmzgidNcc  主管id-农村科技处
	 */
	public void setXmzgidNcc(String xmzgidNcc){
		this.xmzgidNcc = xmzgidNcc;
	}
	/**
	 * 获取  xmzgidFgc
	 *@return: String  主管id-政策法规处
	 */
	public String getXmzgidFgc(){
		return this.xmzgidFgc;
	}

	/**
	 * 设置  xmzgidFgc
	 *@param: xmzgidFgc  主管id-政策法规处
	 */
	public void setXmzgidFgc(String xmzgidFgc){
		this.xmzgidFgc = xmzgidFgc;
	}
	/**
	 * 获取  xmzgidZsjgdw
	 *@return: String  主管id-直属机关党委
	 */
	public String getXmzgidZsjgdw(){
		return this.xmzgidZsjgdw;
	}

	/**
	 * 设置  xmzgidZsjgdw
	 *@param: xmzgidZsjgdw  主管id-直属机关党委
	 */
	public void setXmzgidZsjgdw(String xmzgidZsjgdw){
		this.xmzgidZsjgdw = xmzgidZsjgdw;
	}
	/**
	 * 获取  xmzgidJjs
	 *@return: String  主管id-监察室
	 */
	public String getXmzgidJjs(){
		return this.xmzgidJjs;
	}

	/**
	 * 设置  xmzgidJjs
	 *@param: xmzgidJjs  主管id-监察室
	 */
	public void setXmzgidJjs(String xmzgidJjs){
		this.xmzgidJjs = xmzgidJjs;
	}
	/**
	 * 获取  lsxmzgidGxc
	 *@return: String  临时主管id-高新技术发展及产业化处
	 */
	public String getLsxmzgidGxc(){
		return this.lsxmzgidGxc;
	}

	/**
	 * 设置  lsxmzgidGxc
	 *@param: lsxmzgidGxc  临时主管id-高新技术发展及产业化处
	 */
	public void setLsxmzgidGxc(String lsxmzgidGxc){
		this.lsxmzgidGxc = lsxmzgidGxc;
	}
	/**
	 * 获取  lsxmzgidKjc
	 *@return: String  临时主管id-科技条件与基础研究处
	 */
	public String getLsxmzgidKjc(){
		return this.lsxmzgidKjc;
	}

	/**
	 * 设置  lsxmzgidKjc
	 *@param: lsxmzgidKjc  临时主管id-科技条件与基础研究处
	 */
	public void setLsxmzgidKjc(String lsxmzgidKjc){
		this.lsxmzgidKjc = lsxmzgidKjc;
	}
	/**
	 * 获取  lsxmzgidSfc
	 *@return: String  临时主管id-社会发展科技处
	 */
	public String getLsxmzgidSfc(){
		return this.lsxmzgidSfc;
	}

	/**
	 * 设置  lsxmzgidSfc
	 *@param: lsxmzgidSfc  临时主管id-社会发展科技处
	 */
	public void setLsxmzgidSfc(String lsxmzgidSfc){
		this.lsxmzgidSfc = lsxmzgidSfc;
	}
	/**
	 * 获取  lsxmzgidGjc
	 *@return: String  临时主管id-国际科技合作处
	 */
	public String getLsxmzgidGjc(){
		return this.lsxmzgidGjc;
	}

	/**
	 * 设置  lsxmzgidGjc
	 *@param: lsxmzgidGjc  临时主管id-国际科技合作处
	 */
	public void setLsxmzgidGjc(String lsxmzgidGjc){
		this.lsxmzgidGjc = lsxmzgidGjc;
	}
	/**
	 * 获取  lsxmzgidZsc
	 *@return: String  临时主管id-知识产权发展处
	 */
	public String getLsxmzgidZsc(){
		return this.lsxmzgidZsc;
	}

	/**
	 * 设置  lsxmzgidZsc
	 *@param: lsxmzgidZsc  临时主管id-知识产权发展处
	 */
	public void setLsxmzgidZsc(String lsxmzgidZsc){
		this.lsxmzgidZsc = lsxmzgidZsc;
	}
	/**
	 * 获取  lsxmzgidZlglc
	 *@return: String  临时主管id-专利管理处
	 */
	public String getLsxmzgidZlglc(){
		return this.lsxmzgidZlglc;
	}

	/**
	 * 设置  lsxmzgidZlglc
	 *@param: lsxmzgidZlglc  临时主管id-专利管理处
	 */
	public void setLsxmzgidZlglc(String lsxmzgidZlglc){
		this.lsxmzgidZlglc = lsxmzgidZlglc;
	}
	/**
	 * 获取  lsxmzgidZlbhc
	 *@return: String  临时主管id-专利保护处
	 */
	public String getLsxmzgidZlbhc(){
		return this.lsxmzgidZlbhc;
	}

	/**
	 * 设置  lsxmzgidZlbhc
	 *@param: lsxmzgidZlbhc  临时主管id-专利保护处
	 */
	public void setLsxmzgidZlbhc(String lsxmzgidZlbhc){
		this.lsxmzgidZlbhc = lsxmzgidZlbhc;
	}
	/**
	 * 获取  lsxmzgidCxc
	 *@return: String  临时主管id-产学研合作与成果转化处
	 */
	public String getLsxmzgidCxc(){
		return this.lsxmzgidCxc;
	}

	/**
	 * 设置  lsxmzgidCxc
	 *@param: lsxmzgidCxc  临时主管id-产学研合作与成果转化处
	 */
	public void setLsxmzgidCxc(String lsxmzgidCxc){
		this.lsxmzgidCxc = lsxmzgidCxc;
	}
	/**
	 * 获取  lsxmzgidNcc
	 *@return: String  临时主管id-农村科技处
	 */
	public String getLsxmzgidNcc(){
		return this.lsxmzgidNcc;
	}

	/**
	 * 设置  lsxmzgidNcc
	 *@param: lsxmzgidNcc  临时主管id-农村科技处
	 */
	public void setLsxmzgidNcc(String lsxmzgidNcc){
		this.lsxmzgidNcc = lsxmzgidNcc;
	}
	/**
	 * 获取  lsxmzgidFgc
	 *@return: String  临时主管id-政策法规处
	 */
	public String getLsxmzgidFgc(){
		return this.lsxmzgidFgc;
	}

	/**
	 * 设置  lsxmzgidFgc
	 *@param: lsxmzgidFgc  临时主管id-政策法规处
	 */
	public void setLsxmzgidFgc(String lsxmzgidFgc){
		this.lsxmzgidFgc = lsxmzgidFgc;
	}
	/**
	 * 获取  lsxmzgidZsjgdw
	 *@return: String  临时主管id-直属机关党委
	 */
	public String getLsxmzgidZsjgdw(){
		return this.lsxmzgidZsjgdw;
	}

	/**
	 * 设置  lsxmzgidZsjgdw
	 *@param: lsxmzgidZsjgdw  临时主管id-直属机关党委
	 */
	public void setLsxmzgidZsjgdw(String lsxmzgidZsjgdw){
		this.lsxmzgidZsjgdw = lsxmzgidZsjgdw;
	}
	/**
	 * 获取  lsxmzgidJjs
	 *@return: String  临时主管id-监察室
	 */
	public String getLsxmzgidJjs(){
		return this.lsxmzgidJjs;
	}

	/**
	 * 设置  lsxmzgidJjs
	 *@param: lsxmzgidJjs  临时主管id-监察室
	 */
	public void setLsxmzgidJjs(String lsxmzgidJjs){
		this.lsxmzgidJjs = lsxmzgidJjs;
	}
	/**
	 * 获取  zhuanjiazumingdan
	 *@return: String  专家组名单
	 */
	public String getZhuanjiazumingdan(){
		return this.zhuanjiazumingdan;
	}

	/**
	 * 设置  zhuanjiazumingdan
	 *@param: zhuanjiazumingdan  专家组名单
	 */
	public void setZhuanjiazumingdan(String zhuanjiazumingdan){
		this.zhuanjiazumingdan = zhuanjiazumingdan;
	}
	/**
	 * 获取  chushiopinion
	 *@return: String  处室处员意见
	 */
	public String getChushiopinion(){
		return this.chushiopinion;
	}

	/**
	 * 设置  chushiopinion
	 *@param: chushiopinion  处室处员意见
	 */
	public void setChushiopinion(String chushiopinion){
		this.chushiopinion = chushiopinion;
	}
	/**
	 * 获取  dnjf
	 *@return: Double  当年拟安排经费
	 */
	public Double getDnjf(){
		return this.dnjf;
	}

	/**
	 * 设置  dnjf
	 *@param: dnjf  当年拟安排经费
	 */
	public void setDnjf(Double dnjf){
		this.dnjf = dnjf;
	}
	/**
	 * 获取  jzpyfl
	 *@return: String  重大专项集中评审领域分类
	 */
	public String getJzpyfl(){
		return this.jzpyfl;
	}

	/**
	 * 设置  jzpyfl
	 *@param: jzpyfl  重大专项集中评审领域分类
	 */
	public void setJzpyfl(String jzpyfl){
		this.jzpyfl = jzpyfl;
	}
	/**
	 * 获取  jzpsfz
	 *@return: String  集中评审分组
	 */
	public String getJzpsfz(){
		return this.jzpsfz;
	}

	/**
	 * 设置  jzpsfz
	 *@param: jzpsfz  集中评审分组
	 */
	public void setJzpsfz(String jzpsfz){
		this.jzpsfz = jzpsfz;
	}
	/**
	 * 获取  jzpshyxm
	 *@return: String  集中评审行业项目
	 */
	public String getJzpshyxm(){
		return this.jzpshyxm;
	}

	/**
	 * 设置  jzpshyxm
	 *@param: jzpshyxm  集中评审行业项目
	 */
	public void setJzpshyxm(String jzpshyxm){
		this.jzpshyxm = jzpshyxm;
	}
	/**
	 * 获取  kjtopinion
	 *@return: String  科技厅综合意见
	 */
	public String getKjtopinion(){
		return this.kjtopinion;
	}

	/**
	 * 设置  kjtopinion
	 *@param: kjtopinion  科技厅综合意见
	 */
	public void setKjtopinion(String kjtopinion){
		this.kjtopinion = kjtopinion;
	}
	/**
	 * 获取  defaultindex
	 *@return: Double  默认排序
	 */
	public Double getDefaultindex(){
		return this.defaultindex;
	}

	/**
	 * 设置  defaultindex
	 *@param: defaultindex  默认排序
	 */
	public void setDefaultindex(Double defaultindex){
		this.defaultindex = defaultindex;
	}
	/**
	 * 获取  createtime
	 *@return: Double  CREATETIME
	 */
	public Double getCreatetime(){
		return this.createtime;
	}

	/**
	 * 设置  createtime
	 *@param: createtime  CREATETIME
	 */
	public void setCreatetime(Double createtime){
		this.createtime = createtime;
	}
	/**
	 * 获取  createlaborfee
	 *@return: Double  CREATELABORFEE
	 */
	public Double getCreatelaborfee(){
		return this.createlaborfee;
	}

	/**
	 * 设置  createlaborfee
	 *@param: createlaborfee  CREATELABORFEE
	 */
	public void setCreatelaborfee(Double createlaborfee){
		this.createlaborfee = createlaborfee;
	}
	/**
	 * 获取  totallabor
	 *@return: Double  TOTALLABOR
	 */
	public Double getTotallabor(){
		return this.totallabor;
	}

	/**
	 * 设置  totallabor
	 *@param: totallabor  TOTALLABOR
	 */
	public void setTotallabor(Double totallabor){
		this.totallabor = totallabor;
	}
	/**
	 * 获取  professionaltitle
	 *@return: String  PROFESSIONALTITLE
	 */
	public String getProfessionaltitle(){
		return this.professionaltitle;
	}

	/**
	 * 设置  professionaltitle
	 *@param: professionaltitle  PROFESSIONALTITLE
	 */
	public void setProfessionaltitle(String professionaltitle){
		this.professionaltitle = professionaltitle;
	}
	/**
	 * 获取  countunit
	 *@return: String  COUNTUNIT
	 */
	public String getCountunit(){
		return this.countunit;
	}

	/**
	 * 设置  countunit
	 *@param: countunit  COUNTUNIT
	 */
	public void setCountunit(String countunit){
		this.countunit = countunit;
	}
	/**
	 * 获取  testcontentunit
	 *@return: String  TESTCONTENTUNIT
	 */
	public String getTestcontentunit(){
		return this.testcontentunit;
	}

	/**
	 * 设置  testcontentunit
	 *@param: testcontentunit  TESTCONTENTUNIT
	 */
	public void setTestcontentunit(String testcontentunit){
		this.testcontentunit = testcontentunit;
	}
	/**
	 * 获取  testcontent
	 *@return: String  TESTCONTENT
	 */
	public String getTestcontent(){
		return this.testcontent;
	}

	/**
	 * 设置  testcontent
	 *@param: testcontent  TESTCONTENT
	 */
	public void setTestcontent(String testcontent){
		this.testcontent = testcontent;
	}
	/**
	 * 获取  showstate
	 *@return: String  显示状态
	 */
	public String getShowstate(){
		return this.showstate;
	}

	/**
	 * 设置  showstate
	 *@param: showstate  显示状态
	 */
	public void setShowstate(String showstate){
		this.showstate = showstate;
	}
	/**
	 * 获取  jfbzjf
	 *@return: Double  甲方补助经费
	 */
	public Double getJfbzjf(){
		return this.jfbzjf;
	}

	/**
	 * 设置  jfbzjf
	 *@param: jfbzjf  甲方补助经费
	 */
	public void setJfbzjf(Double jfbzjf){
		this.jfbzjf = jfbzjf;
	}
	/**
	 * 获取  htlczt
	 *@return: String  合同流程状态
	 */
	public String getHtlczt(){
		return this.htlczt;
	}

	/**
	 * 设置  htlczt
	 *@param: htlczt  合同流程状态
	 */
	public void setHtlczt(String htlczt){
		this.htlczt = htlczt;
	}
	/**
	 * 获取  contractno
	 *@return: String  合同编号
	 */
	public String getContractno(){
		return this.contractno;
	}

	/**
	 * 设置  contractno
	 *@param: contractno  合同编号
	 */
	public void setContractno(String contractno){
		this.contractno = contractno;
	}
	/**
	 * 获取  contractname
	 *@return: String  合同名称
	 */
	public String getContractname(){
		return this.contractname;
	}

	/**
	 * 设置  contractname
	 *@param: contractname  合同名称
	 */
	public void setContractname(String contractname){
		this.contractname = contractname;
	}
	/**
	 * 获取  actJcc
	 *@return: String  联审状态-计财处
	 */
	public String getActJcc(){
		return this.actJcc;
	}

	/**
	 * 设置  actJcc
	 *@param: actJcc  联审状态-计财处
	 */
	public void setActJcc(String actJcc){
		this.actJcc = actJcc;
	}
	/**
	 * 获取  actRsc
	 *@return: String  联审状态-人事处
	 */
	public String getActRsc(){
		return this.actRsc;
	}

	/**
	 * 设置  actRsc
	 *@param: actRsc  联审状态-人事处
	 */
	public void setActRsc(String actRsc){
		this.actRsc = actRsc;
	}
	/**
	 * 获取  actJjb
	 *@return: String  联审状态-基建办
	 */
	public String getActJjb(){
		return this.actJjb;
	}

	/**
	 * 设置  actJjb
	 *@param: actJjb  联审状态-基建办
	 */
	public void setActJjb(String actJjb){
		this.actJjb = actJjb;
	}
	/**
	 * 获取  xmzgidJcc
	 *@return: String  主管id-计财处
	 */
	public String getXmzgidJcc(){
		return this.xmzgidJcc;
	}

	/**
	 * 设置  xmzgidJcc
	 *@param: xmzgidJcc  主管id-计财处
	 */
	public void setXmzgidJcc(String xmzgidJcc){
		this.xmzgidJcc = xmzgidJcc;
	}
	/**
	 * 获取  xmzgidRsc
	 *@return: String  主管id-人事处
	 */
	public String getXmzgidRsc(){
		return this.xmzgidRsc;
	}

	/**
	 * 设置  xmzgidRsc
	 *@param: xmzgidRsc  主管id-人事处
	 */
	public void setXmzgidRsc(String xmzgidRsc){
		this.xmzgidRsc = xmzgidRsc;
	}
	/**
	 * 获取  xmzgidJjb
	 *@return: String  主管id-基建办
	 */
	public String getXmzgidJjb(){
		return this.xmzgidJjb;
	}

	/**
	 * 设置  xmzgidJjb
	 *@param: xmzgidJjb  主管id-基建办
	 */
	public void setXmzgidJjb(String xmzgidJjb){
		this.xmzgidJjb = xmzgidJjb;
	}
	/**
	 * 获取  lsxmzgidJcc
	 *@return: String  临时主管id-计财处
	 */
	public String getLsxmzgidJcc(){
		return this.lsxmzgidJcc;
	}

	/**
	 * 设置  lsxmzgidJcc
	 *@param: lsxmzgidJcc  临时主管id-计财处
	 */
	public void setLsxmzgidJcc(String lsxmzgidJcc){
		this.lsxmzgidJcc = lsxmzgidJcc;
	}
	/**
	 * 获取  lsxmzgidRsc
	 *@return: String  临时主管id-人事处
	 */
	public String getLsxmzgidRsc(){
		return this.lsxmzgidRsc;
	}

	/**
	 * 设置  lsxmzgidRsc
	 *@param: lsxmzgidRsc  临时主管id-人事处
	 */
	public void setLsxmzgidRsc(String lsxmzgidRsc){
		this.lsxmzgidRsc = lsxmzgidRsc;
	}
	/**
	 * 获取  cddwmc
	 *@return: String  合同申请单位
	 */
	public String getCddwmc(){
		return this.cddwmc;
	}

	/**
	 * 设置  cddwmc
	 *@param: cddwmc  合同申请单位
	 */
	public void setCddwmc(String cddwmc){
		this.cddwmc = cddwmc;
	}
	/**
	 * 获取  htxmfzr
	 *@return: String  合同项目负责人
	 */
	public String getHtxmfzr(){
		return this.htxmfzr;
	}

	/**
	 * 设置  htxmfzr
	 *@param: htxmfzr  合同项目负责人
	 */
	public void setHtxmfzr(String htxmfzr){
		this.htxmfzr = htxmfzr;
	}
	/**
	 * 获取  xmhdlx
	 *@return: String  项目活动类型
	 */
	public String getXmhdlx(){
		return this.xmhdlx;
	}

	/**
	 * 设置  xmhdlx
	 *@param: xmhdlx  项目活动类型
	 */
	public void setXmhdlx(String xmhdlx){
		this.xmhdlx = xmhdlx;
	}
	/**
	 * 获取  xmyzntype
	 *@return: String  项目与《技术榜单》或《指南》的衔接性
	 */
	public String getXmyzntype(){
		return this.xmyzntype;
	}

	/**
	 * 设置  xmyzntype
	 *@param: xmyzntype  项目与《技术榜单》或《指南》的衔接性
	 */
	public void setXmyzntype(String xmyzntype){
		this.xmyzntype = xmyzntype;
	}
	/**
	 * 获取  xmyznly
	 *@return: String  领域
	 */
	public String getXmyznly(){
		return this.xmyznly;
	}

	/**
	 * 设置  xmyznly
	 *@param: xmyznly  领域
	 */
	public void setXmyznly(String xmyznly){
		this.xmyznly = xmyznly;
	}
	/**
	 * 获取  xmyznzt
	 *@return: String  主题
	 */
	public String getXmyznzt(){
		return this.xmyznzt;
	}

	/**
	 * 设置  xmyznzt
	 *@param: xmyznzt  主题
	 */
	public void setXmyznzt(String xmyznzt){
		this.xmyznzt = xmyznzt;
	}
	/**
	 * 获取  xmyzndesc
	 *@return: String  XMYZNDESC
	 */
	public String getXmyzndesc(){
		return this.xmyzndesc;
	}

	/**
	 * 设置  xmyzndesc
	 *@param: xmyzndesc  XMYZNDESC
	 */
	public void setXmyzndesc(String xmyzndesc){
		this.xmyzndesc = xmyzndesc;
	}
	/**
	 * 获取  xmwcslx
	 *@return: String  项目完成时的应用类型
	 */
	public String getXmwcslx(){
		return this.xmwcslx;
	}

	/**
	 * 设置  xmwcslx
	 *@param: xmwcslx  项目完成时的应用类型
	 */
	public void setXmwcslx(String xmwcslx){
		this.xmwcslx = xmwcslx;
	}
	/**
	 * 获取  xmhdlxcode
	 *@return: String  项目活动类型编码
	 */
	public String getXmhdlxcode(){
		return this.xmhdlxcode;
	}

	/**
	 * 设置  xmhdlxcode
	 *@param: xmhdlxcode  项目活动类型编码
	 */
	public void setXmhdlxcode(String xmhdlxcode){
		this.xmhdlxcode = xmhdlxcode;
	}
	/**
	 * 获取  projectleaderphone
	 *@return: String  联系电话
	 */
	public String getProjectleaderphone(){
		return this.projectleaderphone;
	}

	/**
	 * 设置  projectleaderphone
	 *@param: projectleaderphone  联系电话
	 */
	public void setProjectleaderphone(String projectleaderphone){
		this.projectleaderphone = projectleaderphone;
	}
	/**
	 * 获取  ssjsly
	 *@return: String  SSJSLY
	 */
	public String getSsjsly(){
		return this.ssjsly;
	}

	/**
	 * 设置  ssjsly
	 *@param: ssjsly  SSJSLY
	 */
	public void setSsjsly(String ssjsly){
		this.ssjsly = ssjsly;
	}
	/**
	 * 获取  ssjslycode
	 *@return: String  SSJSLYCODE
	 */
	public String getSsjslycode(){
		return this.ssjslycode;
	}

	/**
	 * 设置  ssjslycode
	 *@param: ssjslycode  SSJSLYCODE
	 */
	public void setSsjslycode(String ssjslycode){
		this.ssjslycode = ssjslycode;
	}
	/**
	 * 获取  xmwcslxcode
	 *@return: String  XMWCSLXCODE
	 */
	public String getXmwcslxcode(){
		return this.xmwcslxcode;
	}

	/**
	 * 设置  xmwcslxcode
	 *@param: xmwcslxcode  XMWCSLXCODE
	 */
	public void setXmwcslxcode(String xmwcslxcode){
		this.xmwcslxcode = xmwcslxcode;
	}
	/**
	 * 获取  projectsearchtype
	 *@return: String  项目三查类型， 1、代表查新，2、代表专利检索
	 */
	public String getProjectsearchtype(){
		return this.projectsearchtype;
	}

	/**
	 * 设置  projectsearchtype
	 *@param: projectsearchtype  项目三查类型， 1、代表查新，2、代表专利检索
	 */
	public void setProjectsearchtype(String projectsearchtype){
		this.projectsearchtype = projectsearchtype;
	}
	/**
	 * 获取  sfsygjmm
	 *@return: String  是否属于国家秘密
	 */
	public String getSfsygjmm(){
		return this.sfsygjmm;
	}

	/**
	 * 设置  sfsygjmm
	 *@param: sfsygjmm  是否属于国家秘密
	 */
	public void setSfsygjmm(String sfsygjmm){
		this.sfsygjmm = sfsygjmm;
	}
	/**
	 * 获取  superuser
	 *@return: String  SUPERUSER
	 */
	public String getSuperuser(){
		return this.superuser;
	}

	/**
	 * 设置  superuser
	 *@param: superuser  SUPERUSER
	 */
	public void setSuperuser(String superuser){
		this.superuser = superuser;
	}
	/**
	 * 获取  xmlx
	 *@return: String  项目类型
	 */
	public String getXmlx(){
		return this.xmlx;
	}

	/**
	 * 设置  xmlx
	 *@param: xmlx  项目类型
	 */
	public void setXmlx(String xmlx){
		this.xmlx = xmlx;
	}
	/**
	 * 获取  keywords
	 *@return: String  关键字
	 */
	public String getKeywords(){
		return this.keywords;
	}

	/**
	 * 设置  keywords
	 *@param: keywords  关键字
	 */
	public void setKeywords(String keywords){
		this.keywords = keywords;
	}
	/**
	 * 获取  enkeywords
	 *@return: String  英文关键字
	 */
	public String getEnkeywords(){
		return this.enkeywords;
	}

	/**
	 * 设置  enkeywords
	 *@param: enkeywords  英文关键字
	 */
	public void setEnkeywords(String enkeywords){
		this.enkeywords = enkeywords;
	}
	/**
	 * 获取  leadercertificateno
	 *@return: String  负责人身份证
	 */
	public String getLeadercertificateno(){
		return this.leadercertificateno;
	}

	/**
	 * 设置  leadercertificateno
	 *@param: leadercertificateno  负责人身份证
	 */
	public void setLeadercertificateno(String leadercertificateno){
		this.leadercertificateno = leadercertificateno;
	}
	/**
	 * 获取  isable
	 *@return: String  是否可用
	 */
	public String getIsable(){
		return this.isable;
	}

	/**
	 * 设置  isable
	 *@param: isable  是否可用
	 */
	public void setIsable(String isable){
		this.isable = isable;
	}
	/**
	 * 获取  isbackstuff
	 *@return: Double  材料是否被退回过
	 */
	public Double getIsbackstuff(){
		return this.isbackstuff;
	}

	/**
	 * 设置  isbackstuff
	 *@param: isbackstuff  材料是否被退回过
	 */
	public void setIsbackstuff(Double isbackstuff){
		this.isbackstuff = isbackstuff;
	}
	/**
	 * 获取  izteamid
	 *@return: String  IZTEAMID
	 */
	public String getIzteamid(){
		return this.izteamid;
	}

	/**
	 * 设置  izteamid
	 *@param: izteamid  IZTEAMID
	 */
	public void setIzteamid(String izteamid){
		this.izteamid = izteamid;
	}
	/**
	 * 获取  isreview
	 *@return: Double  是否进入评审
	 */
	public Double getIsreview(){
		return this.isreview;
	}

	/**
	 * 设置  isreview
	 *@param: isreview  是否进入评审
	 */
	public void setIsreview(Double isreview){
		this.isreview = isreview;
	}
	/**
	 * 获取  ismeeting
	 *@return: Double  ISMEETING
	 */
	public Double getIsmeeting(){
		return this.ismeeting;
	}

	/**
	 * 设置  ismeeting
	 *@param: ismeeting  ISMEETING
	 */
	public void setIsmeeting(Double ismeeting){
		this.ismeeting = ismeeting;
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
	 * 获取  implcontent
	 *@return: String  实施内容
	 */
	public String getImplcontent(){
		return this.implcontent;
	}

	/**
	 * 设置  implcontent
	 *@param: implcontent  实施内容
	 */
	public void setImplcontent(String implcontent){
		this.implcontent = implcontent;
	}
	/**
	 * 获取  oldplanno
	 *@return: String  OLDPLANNO
	 */
	public String getOldplanno(){
		return this.oldplanno;
	}

	/**
	 * 设置  oldplanno
	 *@param: oldplanno  OLDPLANNO
	 */
	public void setOldplanno(String oldplanno){
		this.oldplanno = oldplanno;
	}

    public String getPactno() {
        return pactno;
    }

    public void setPactno(String pactno) {
        this.pactno = pactno;
    }

    public String getJhxtzkjjf() {
        return jhxtzkjjf;
    }

    public void setJhxtzkjjf(String jhxtzkjjf) {
        this.jhxtzkjjf = jhxtzkjjf;
    }

    public String getPactStatus() {
        return pactStatus;
    }

    public void setPactStatus(String pactStatus) {
        this.pactStatus = pactStatus;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public String getAnnually() {
        return annually;
    }

    public void setAnnually(String annually) {
        this.annually = annually;
    }

    public String getApplicationtypecode1() {
        return applicationtypecode1;
    }

    public void setApplicationtypecode1(String applicationtypecode1) {
        this.applicationtypecode1 = applicationtypecode1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
