package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@TableName("pact_projectbase")
public class PactProjectbase extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 项目合同id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 企业id
     */
    @TableField("enterpriseorusersid")
    private String enterpriseorusersid;

    /**
     * 项目申报批次id
     */
    @TableField("planprojectbatchid")
    private String planprojectbatchid;

    /**
     * 项目开始日期
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("projectstartdate")
    private Date projectstartdate;

    /**
     * 项目结束日期
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("projectenddate")
    private Date projectenddate;

    /**
     * 合同编号
     */
    @TableField(exist = false)
    private String pactno;

    /**
     * 项目经费
     */
    @TableField(exist = false)
    private BigDecimal jhxtzkjjf;

    /**
     * 合同状态
     */
    @TableField(exist = false)
    private String pactStatus;

    /**
     * 承担单位
     */
    @TableField(exist = false)
    private String organizationname;

    /**
     * 申请年度
     */
    @TableField(exist = false)
    private String annually;

    /**
     * 计划领域
     */
    @TableField(exist = false)
    private String applicationtypecode1;

    /**
     * 自费多少
     */
    @TableField("projectsumforself")
    private BigDecimal projectsumforself;

    /**
     * 向政府申请经费
     */
    @TableField("projectsumforgov")
    private BigDecimal projectsumforgov;

    /**
     * 项目总费用
     */
    @TableField("projecttotalsum")
    private BigDecimal projecttotalsum;

    /**
     * 项目经济效益
     */
    @TableField("economicbenefit")
    private String economicbenefit;

    /**
     * 项目内容
     */
    @TableField("projectcontent1")
    private String projectcontent1;

    /**
     * 项目效益
     */
    @TableField("projectachievement1")
    private String projectachievement1;

    /**
     * 项目名称
     */
    @TableField("projectbasename")
    private String projectbasename;

    /**
     * 申报人
     */
    @TableField("declarant")
    private String declarant;

    /**
     * 律师事务所
     */
    @TableField("accountfirmid")
    private String accountfirmid;

    /**
     * 项目负责人
     */
    @TableField("projectleader")
    private String projectleader;

    /**
     * 申请专项名称
     */
    @TableField("applyspecialname")
    private String applyspecialname;

    /**
     * 项目申请类型
     */
    @TableField("projectapplytype")
    private String projectapplytype;

    /**
     * 项目计划类型
     */
    @TableField("projectplantype")
    private String projectplantype;

    /**
     * 技术创新方式
     */
    @TableField("technologicalmode")
    private String technologicalmode;

    /**
     * 项目管理领域
     */
    @TableField("projectmanagedomain")
    private String projectmanagedomain;

    /**
     * 申请拨款方式
     */
    @TableField("appropriationtype")
    private String appropriationtype;

    /**
     * 技术来源
     */
    @TableField("technologicalsource")
    private String technologicalsource;

    /**
     * 主流程状态
     */
    @TableField("maincurrentstate")
    private String maincurrentstate;

    /**
     * 主流程状态ID
     */
    @TableField("maincurrentstateid")
    private String maincurrentstateid;

    /**
     * 子状态
     */
    @TableField("minicurrentstate")
    private String minicurrentstate;

    /**
     * 子状态ID
     */
    @TableField("minicurrentstateid")
    private String minicurrentstateid;

    /**
     * 项目申请时间
     */
    @TableField("applydate")
    private Date applydate;

    /**
     * 预计经济效益和成果
     */
    @TableField("expectedbenefitachievement")
    private String expectedbenefitachievement;

    /**
     * 申报人\单位id
     */
    @TableField("declarantid")
    private String declarantid;

    /**
     * 主办单位
     */
    @TableField("mainorganizers")
    private String mainorganizers;

    /**
     * 研发内容与预期目标凝练
     */
    @TableField("researchcontent1")
    private String researchcontent1;

    /**
     * 项目实施主要任务和目标
     */
    @TableField("projectimplementation")
    private String projectimplementation;

    /**
     * 上年度研发投入
     */
    @TableField("researchinput")
    private String researchinput;

    /**
     * 上年度主营业务收入
     */
    @TableField("mainbusinessincome")
    private String mainbusinessincome;

    /**
     * 企业类型
     */
    @TableField("enterprisetypes")
    private String enterprisetypes;

    /**
     * 研发机构情况
     */
    @TableField("researchinstitutions")
    private String researchinstitutions;

    /**
     * 申请编号
     */
    @TableField("applicationno")
    private String applicationno;

    /**
     * 技术领域
     */
    @TableField("techdomain")
    private String techdomain;

    /**
     * 提交时间
     */
    @TableField("submitdate")
    private Date submitdate;

    /**
     * 是否作废
     */
    @TableField("iscancel")
    private String iscancel;

    /**
     * 是否立项
     */
    @TableField("issetup")
    private String issetup;

    /**
     * 创建日期
     */
    @TableField("createdate")
    private Date createdate;

    /**
     * (主管处室)
     */
    @TableField("chiefdepartment")
    private String chiefdepartment;

    /**
     * (项目主管)
     */
    @TableField("chieldofficals")
    private String chieldofficals;

    /**
     * (归口管理部门)
     */
    @TableField("casemanagement")
    private String casemanagement;

    /**
     * 计划编号
     */
    @TableField("planno")
    private String planno;

    /**
     * 项目行业分类
     */
    @TableField("projectclassification")
    private String projectclassification;

    /**
     * 项目成果提供形式
     */
    @TableField("projectresults")
    private String projectresults;

    /**
     * 特征信息id
     */
    @TableField("projectfeatureinforid")
    private String projectfeatureinforid;

    /**
     * 申请专项名称代码
     */
    @TableField("applyspecialnamecode")
    private String applyspecialnamecode;

    /**
     * 项目申请类型代码
     */
    @TableField("projectapplytypecode")
    private String projectapplytypecode;

    /**
     * 项目计划类型代码
     */
    @TableField("projectplantypecode")
    private String projectplantypecode;

    /**
     * 技术创新方式代码
     */
    @TableField("technologicalmodecode")
    private String technologicalmodecode;

    /**
     * 项目管理领域代码
     */
    @TableField("projectmanagedomaincode")
    private String projectmanagedomaincode;

    /**
     * 申请拨款方式代码
     */
    @TableField("appropriationtypecode")
    private String appropriationtypecode;

    /**
     * 技术来源代码
     */
    @TableField("technologicalsourcecode")
    private String technologicalsourcecode;

    /**
     * 当前状态
     */
    @TableField("currentsate")
    private String currentsate;

    /**
     * 初审所属处室
     */
    @TableField("belonglab")
    private String belonglab;

    /**
     * 初审所属处室ID
     */
    @TableField("belonglabid")
    private String belonglabid;

    /**
     * 产业领域
     */
    @TableField("industryfield")
    private String industryfield;

    /**
     * 技术领域编码
     */
    @TableField("techdomaincode")
    private String techdomaincode;

    /**
     * 产业领域编码
     */
    @TableField("industryfieldcode")
    private String industryfieldcode;

    /**
     * 学科领域
     */
    @TableField("subjectareas")
    private String subjectareas;

    /**
     * 学科领域代码
     */
    @TableField("subjectareascode")
    private String subjectareascode;

    /**
     * 技术领域
     */
    @TableField("technicalrank")
    private String technicalrank;

    /**
     * 归口管理部门代码
     */
    @TableField("casemanagementcode")
    private String casemanagementcode;

    /**
     * 归口管理部门id
     */
    @TableField("casemanagementid")
    private String casemanagementid;

    /**
     * 行业分类代码
     */
    @TableField("projectclassificationcode")
    private String projectclassificationcode;

    /**
     * 社会公益领域
     */
    @TableField("shgyly")
    private String shgyly;

    /**
     * 社会公益领域代码
     */
    @TableField("shgylycode")
    private String shgylycode;

    /**
     * 副标题
     */
    @TableField("secondprojectname")
    private String secondprojectname;

    /**
     * 云平台大仪平台
     */
    @TableField("dayipingtai")
    private String dayipingtai;

    /**
     * 云平台载体名称
     */
    @TableField("zaitimingcheng")
    private String zaitimingcheng;

    /**
     * 项目实施目的意义
     */
    @TableField("purposemean")
    private String purposemean;

    /**
     * 云平台企业类型
     */
    @TableField("yptqiyeleixing")
    private String yptqiyeleixing;

    /**
     * 研发内容与预期目标凝练
     */
    @TableField("researchcontent")
    private String researchcontent;

    /**
     * 项目内容
     */
    @TableField("projectcontent")
    private String projectcontent;

    /**
     * 项目效益
     */
    @TableField("projectachievement")
    private String projectachievement;

    /**
     * 最后一次保存时间
     */
    @TableField("updatelasttime")
    private Date updatelasttime;

    /**
     * 实现销售收入
     */
    @TableField("achievesalesrevenue")
    private BigDecimal achievesalesrevenue;

    /**
     * 实现利润
     */
    @TableField("profits")
    private BigDecimal profits;

    /**
     * 实现上缴税收
     */
    @TableField("implementpaystaxes")
    private BigDecimal implementpaystaxes;

    /**
     * 载体类别
     */
    @TableField("zttype")
    private String zttype;

    /**
     * 超过30万大型仪器信息填写情况
     */
    @TableField("daxingyiqi")
    private String daxingyiqi;

    /**
     * 创新券使用情况
     */
    @TableField("chuangxinquan")
    private String chuangxinquan;

    /**
     * 载体名称ID
     */
    @TableField("zaitimingchenid")
    private String zaitimingchenid;

    /**
     * 显示的项目名称
     */
    @TableField("showprojectbasename")
    private String showprojectbasename;

    /**
     * 批次名称
     */
    @TableField("batchname")
    private String batchname;

    /**
     * 具备条件
     */
    @TableField("possessconditions")
    private String possessconditions;

    /**
     * 实际支付
     */
    @TableField("actualpayment")
    private BigDecimal actualpayment;

    /**
     * 1为第二轮专家评审可选项目标志
     */
    @TableField("truefalse")
    private String truefalse;

    /**
     * 专家网评结果
     */
    @TableField("expertresult")
    private String expertresult;

    /**
     * 处室初审建议经费
     */
    @TableField("csjyjf")
    private BigDecimal csjyjf;

    /**
     * 处室处员初审结果
     */
    @TableField("cscsjg")
    private String cscsjg;

    /**
     * 处室处长建议经费
     */
    @TableField("csczjyjf")
    private BigDecimal csczjyjf;

    /**
     * 处室处长初审结果
     */
    @TableField("csczshjg")
    private String csczshjg;

    /**
     * 立项项目名称
     */
    @TableField("finalprojectname")
    private String finalprojectname;

    /**
     * 立项课题名称
     */
    @TableField("finaltaskprojectname")
    private String finaltaskprojectname;

    /**
     * 分配的项目主管id
     */
    @TableField("xmzgid")
    private String xmzgid;

    /**
     * 临时分配的项目主管id
     */
    @TableField("lsxmzgid")
    private String lsxmzgid;

    /**
     * 流程id
     */
    @TableField("activitiid")
    private String activitiid;

    /**
     * 申报项目批次ID2
     */
    @TableField("planprojectbatchid2")
    private String planprojectbatchid2;

    /**
     * 联审状态-高新技术发展及产业化处
     */
    @TableField("act_gxc")
    private String actGxc;

    /**
     * 联审状态-科技条件与基础研究处
     */
    @TableField("act_kjc")
    private String actKjc;

    /**
     * 联审状态-社会发展科技处
     */
    @TableField("act_sfc")
    private String actSfc;

    /**
     * 联审状态-国际科技合作处
     */
    @TableField("act_gjc")
    private String actGjc;

    /**
     * 联审状态-知识产权发展处
     */
    @TableField("act_zsc")
    private String actZsc;

    /**
     * 联审状态-专利管理处
     */
    @TableField("act_zlglc")
    private String actZlglc;

    /**
     * 联审状态-专利保护处
     */
    @TableField("act_zlbhc")
    private String actZlbhc;

    /**
     * 联审状态-产学研合作与成果转化处
     */
    @TableField("act_cxc")
    private String actCxc;

    /**
     * 联审状态-农村科技处
     */
    @TableField("act_ncc")
    private String actNcc;

    /**
     * 联审状态-政策法规处
     */
    @TableField("act_fgc")
    private String actFgc;

    /**
     * 联审状态-直属机关党委
     */
    @TableField("act_zsjgdw")
    private String actZsjgdw;

    /**
     * 联审状态-监察室
     */
    @TableField("act_jjs")
    private String actJjs;

    /**
     * 主管id-高新技术发展及产业化处
     */
    @TableField("xmzgid_gxc")
    private String xmzgidGxc;

    /**
     * 主管id-科技条件与基础研究处
     */
    @TableField("xmzgid_kjc")
    private String xmzgidKjc;

    /**
     * 主管id-社会发展科技处
     */
    @TableField("xmzgid_sfc")
    private String xmzgidSfc;

    /**
     * 主管id-国际科技合作处
     */
    @TableField("xmzgid_gjc")
    private String xmzgidGjc;

    /**
     * 主管id-知识产权发展处
     */
    @TableField("xmzgid_zsc")
    private String xmzgidZsc;

    /**
     * 主管id-专利管理处
     */
    @TableField("xmzgid_zlglc")
    private String xmzgidZlglc;

    /**
     * 主管id-专利保护处
     */
    @TableField("xmzgid_zlbhc")
    private String xmzgidZlbhc;

    /**
     * 主管id-产学研合作与成果转化处
     */
    @TableField("xmzgid_cxc")
    private String xmzgidCxc;

    /**
     * 主管id-农村科技处
     */
    @TableField("xmzgid_ncc")
    private String xmzgidNcc;

    /**
     * 主管id-政策法规处
     */
    @TableField("xmzgid_fgc")
    private String xmzgidFgc;

    /**
     * 主管id-直属机关党委
     */
    @TableField("xmzgid_zsjgdw")
    private String xmzgidZsjgdw;

    /**
     * 主管id-监察室
     */
    @TableField("xmzgid_jjs")
    private String xmzgidJjs;

    /**
     * 临时主管id-高新技术发展及产业化处
     */
    @TableField("lsxmzgid_gxc")
    private String lsxmzgidGxc;

    /**
     * 临时主管id-科技条件与基础研究处
     */
    @TableField("lsxmzgid_kjc")
    private String lsxmzgidKjc;

    /**
     * 临时主管id-社会发展科技处
     */
    @TableField("lsxmzgid_sfc")
    private String lsxmzgidSfc;

    /**
     * 临时主管id-国际科技合作处
     */
    @TableField("lsxmzgid_gjc")
    private String lsxmzgidGjc;

    /**
     * 临时主管id-知识产权发展处
     */
    @TableField("lsxmzgid_zsc")
    private String lsxmzgidZsc;

    /**
     * 临时主管id-专利管理处
     */
    @TableField("lsxmzgid_zlglc")
    private String lsxmzgidZlglc;

    /**
     * 临时主管id-专利保护处
     */
    @TableField("lsxmzgid_zlbhc")
    private String lsxmzgidZlbhc;

    /**
     * 临时主管id-产学研合作与成果转化处
     */
    @TableField("lsxmzgid_cxc")
    private String lsxmzgidCxc;

    /**
     * 临时主管id-农村科技处
     */
    @TableField("lsxmzgid_ncc")
    private String lsxmzgidNcc;

    /**
     * 临时主管id-政策法规处
     */
    @TableField("lsxmzgid_fgc")
    private String lsxmzgidFgc;

    /**
     * 临时主管id-直属机关党委
     */
    @TableField("lsxmzgid_zsjgdw")
    private String lsxmzgidZsjgdw;

    /**
     * 临时主管id-监察室
     */
    @TableField("lsxmzgid_jjs")
    private String lsxmzgidJjs;

    /**
     * 专家组名单
     */
    @TableField("zhuanjiazumingdan")
    private String zhuanjiazumingdan;

    /**
     * 处室处员意见
     */
    @TableField("chushiopinion")
    private String chushiopinion;

    /**
     * 当年拟安排经费
     */
    @TableField("dnjf")
    private BigDecimal dnjf;

    /**
     * 重大专项集中评审领域分类
     */
    @TableField("jzpyfl")
    private String jzpyfl;

    /**
     * 集中评审分组
     */
    @TableField("jzpsfz")
    private String jzpsfz;

    /**
     * 集中评审行业项目
     */
    @TableField("jzpshyxm")
    private String jzpshyxm;

    /**
     * 科技厅综合意见
     */
    @TableField("kjtopinion")
    private String kjtopinion;

    /**
     * 默认排序
     */
    @TableField("defaultindex")
    private BigDecimal defaultindex;

    @TableField("createtime")
    private Date createtime;

    @TableField("createlaborfee")
    private BigDecimal createlaborfee;

    @TableField("totallabor")
    private BigDecimal totallabor;

    @TableField("professionaltitle")
    private String professionaltitle;

    @TableField("countunit")
    private String countunit;

    @TableField("testcontentunit")
    private String testcontentunit;

    @TableField("testcontent")
    private String testcontent;

    /**
     * 显示状态
     */
    @TableField("showstate")
    private String showstate;

    /**
     * 甲方补助经费
     */
    @TableField("jfbzjf")
    private BigDecimal jfbzjf;

    /**
     * 合同流程状态
     */
    @TableField("htlczt")
    private String htlczt;

    /**
     * 合同编号
     */
    @TableField("contractno")
    private String contractno;

    /**
     * 合同名称
     */
    @TableField("contractname")
    private String contractname;

    /**
     * 联审状态-计财处
     */
    @TableField("act_jcc")
    private String actJcc;

    /**
     * 联审状态-人事处
     */
    @TableField("act_rsc")
    private String actRsc;

    /**
     * 联审状态-基建办
     */
    @TableField("act_jjb")
    private String actJjb;

    /**
     * 主管id-计财处
     */
    @TableField("xmzgid_jcc")
    private String xmzgidJcc;

    /**
     * 主管id-人事处
     */
    @TableField("xmzgid_rsc")
    private String xmzgidRsc;

    /**
     * 主管id-基建办
     */
    @TableField("xmzgid_jjb")
    private String xmzgidJjb;

    /**
     * 临时主管id-计财处
     */
    @TableField("lsxmzgid_jcc")
    private String lsxmzgidJcc;

    /**
     * 临时主管id-人事处
     */
    @TableField("lsxmzgid_rsc")
    private String lsxmzgidRsc;

    /**
     * 合同申请单位
     */
    @TableField("cddwmc")
    private String cddwmc;

    /**
     * 合同项目负责人
     */
    @TableField("htxmfzr")
    private String htxmfzr;

    /**
     * 项目活动类型
     */
    @TableField("xmhdlx")
    private String xmhdlx;

    /**
     * 项目与《技术榜单》或《指南》的衔接性
     */
    @TableField("xmyzntype")
    private String xmyzntype;

    /**
     * 领域
     */
    @TableField("xmyznly")
    private String xmyznly;

    /**
     * 主题
     */
    @TableField("xmyznzt")
    private String xmyznzt;

    @TableField("xmyzndesc")
    private String xmyzndesc;

    /**
     * 项目完成时的应用类型
     */
    @TableField("xmwcslx")
    private String xmwcslx;

    /**
     * 项目活动类型编码
     */
    @TableField("xmhdlxcode")
    private String xmhdlxcode;

    /**
     * 联系电话
     */
    @TableField("projectleaderphone")
    private String projectleaderphone;

    /**
     * 技术领域
     */
    @TableField("ssjsly")
    private String ssjsly;

    @TableField("ssjslycode")
    private String ssjslycode;

    @TableField("xmwcslxcode")
    private String xmwcslxcode;

    /**
     * 项目三查类型， 1、代表查新，2、代表专利检索
     */
    @TableField("projectsearchtype")
    private String projectsearchtype;

    /**
     * 是否属于国家秘密
     */
    @TableField("sfsygjmm")
    private String sfsygjmm;

    @TableField("superuser")
    private String superuser;

    /**
     * 项目类型
     */
    @TableField("xmlx")
    private String xmlx;

    /**
     * 关键字
     */
    @TableField("keywords")
    private String keywords;

    /**
     * 英文关键字
     */
    @TableField("enkeywords")
    private String enkeywords;

    /**
     * 负责人身份证
     */
    @TableField("leadercertificateno")
    private String leadercertificateno;

    /**
     * 是否可用
     */
    @TableField("isable")
    private String isable;

    /**
     * 材料是否被退回过
     */
    @TableField("isbackstuff")
    private String isbackstuff;

    @TableField("izteamid")
    private String izteamid;

    /**
     * 是否进入评审
     */
    @TableField("isreview")
    private String isreview;

    @TableField("ismeeting")
    private String ismeeting;

    /**
     * 合同id
     */
    @TableField("pactid")
    private String pactid;

    @TableField("oldplanno")
    private String oldplanno;

    @TableField("implcontent")
    private String implcontent;

    @TableField("affixes")
    private String affixes;

    @TableField(exist = false)
    private BigDecimal instrumentsumzc;

    @TableField(exist = false)
    private String status;
    @TableField(exist = false)
    private BigDecimal materialexpensezc;
    @TableField(exist = false)
    private BigDecimal proceedingschargeszc;
    @TableField(exist = false)
    private BigDecimal fuelandpowerzc;
    @TableField(exist = false)
    private BigDecimal clhygjhzzc;
    @TableField(exist = false)
    private BigDecimal adminstrativeservicesumzc;
    @TableField(exist = false)
    private BigDecimal adviceforexpertsumzc;
    @TableField(exist = false)
    private BigDecimal qitazc;
    @TableField(exist = false)
    private BigDecimal totaljjsumzc;
    @TableField(exist = false)
    private BigDecimal equipmentone;
    @TableField(exist = false)
    private BigDecimal materialone;
    @TableField(exist = false)
    private BigDecimal processingtestone;
    @TableField(exist = false)
    private BigDecimal expenditureone;
    @TableField(exist = false)
    private BigDecimal inlandtravelone;
    @TableField(exist = false)
    private BigDecimal publishedone;
    @TableField(exist = false)
    private BigDecimal laborone;
    @TableField(exist = false)
    private BigDecimal consultingone;
    @TableField(exist = false)
    private BigDecimal qitakjt;
    @TableField(exist = false)
    private BigDecimal totaljjsumkjt;
    @TableField(exist = false)
    private BigDecimal servicefeezc;
    @TableField(exist = false)
    private String organizationphone;
    @TableField(exist = false)
    private String pactfields;

    public String getOrganizationphone() {
        return organizationphone;
    }

    public void setOrganizationphone(String organizationphone) {
        this.organizationphone = organizationphone;
    }

    public String getPactfields() {
        return pactfields;
    }

    public void setPactfields(String pactfields) {
        this.pactfields = pactfields;
    }

    public BigDecimal getInstrumentsumzc() {
        return instrumentsumzc;
    }

    public void setInstrumentsumzc(BigDecimal instrumentsumzc) {
        this.instrumentsumzc = instrumentsumzc;
    }

    public BigDecimal getMaterialexpensezc() {
        return materialexpensezc;
    }

    public void setMaterialexpensezc(BigDecimal materialexpensezc) {
        this.materialexpensezc = materialexpensezc;
    }

    public BigDecimal getProceedingschargeszc() {
        return proceedingschargeszc;
    }

    public void setProceedingschargeszc(BigDecimal proceedingschargeszc) {
        this.proceedingschargeszc = proceedingschargeszc;
    }

    public BigDecimal getFuelandpowerzc() {
        return fuelandpowerzc;
    }

    public void setFuelandpowerzc(BigDecimal fuelandpowerzc) {
        this.fuelandpowerzc = fuelandpowerzc;
    }

    public BigDecimal getClhygjhzzc() {
        return clhygjhzzc;
    }

    public void setClhygjhzzc(BigDecimal clhygjhzzc) {
        this.clhygjhzzc = clhygjhzzc;
    }

    public BigDecimal getAdminstrativeservicesumzc() {
        return adminstrativeservicesumzc;
    }

    public void setAdminstrativeservicesumzc(BigDecimal adminstrativeservicesumzc) {
        this.adminstrativeservicesumzc = adminstrativeservicesumzc;
    }

    public BigDecimal getAdviceforexpertsumzc() {
        return adviceforexpertsumzc;
    }

    public void setAdviceforexpertsumzc(BigDecimal adviceforexpertsumzc) {
        this.adviceforexpertsumzc = adviceforexpertsumzc;
    }

    public BigDecimal getQitazc() {
        return qitazc;
    }

    public void setQitazc(BigDecimal qitazc) {
        this.qitazc = qitazc;
    }

    public BigDecimal getTotaljjsumzc() {
        return totaljjsumzc;
    }

    public void setTotaljjsumzc(BigDecimal totaljjsumzc) {
        this.totaljjsumzc = totaljjsumzc;
    }

    public BigDecimal getEquipmentone() {
        return equipmentone;
    }

    public void setEquipmentone(BigDecimal equipmentone) {
        this.equipmentone = equipmentone;
    }

    public BigDecimal getMaterialone() {
        return materialone;
    }

    public void setMaterialone(BigDecimal materialone) {
        this.materialone = materialone;
    }

    public BigDecimal getProcessingtestone() {
        return processingtestone;
    }

    public void setProcessingtestone(BigDecimal processingtestone) {
        this.processingtestone = processingtestone;
    }

    public BigDecimal getExpenditureone() {
        return expenditureone;
    }

    public void setExpenditureone(BigDecimal expenditureone) {
        this.expenditureone = expenditureone;
    }

    public BigDecimal getInlandtravelone() {
        return inlandtravelone;
    }

    public void setInlandtravelone(BigDecimal inlandtravelone) {
        this.inlandtravelone = inlandtravelone;
    }

    public BigDecimal getPublishedone() {
        return publishedone;
    }

    public void setPublishedone(BigDecimal publishedone) {
        this.publishedone = publishedone;
    }

    public BigDecimal getLaborone() {
        return laborone;
    }

    public void setLaborone(BigDecimal laborone) {
        this.laborone = laborone;
    }

    public BigDecimal getConsultingone() {
        return consultingone;
    }

    public void setConsultingone(BigDecimal consultingone) {
        this.consultingone = consultingone;
    }

    public BigDecimal getQitakjt() {
        return qitakjt;
    }

    public void setQitakjt(BigDecimal qitakjt) {
        this.qitakjt = qitakjt;
    }

    public BigDecimal getTotaljjsumkjt() {
        return totaljjsumkjt;
    }

    public void setTotaljjsumkjt(BigDecimal totaljjsumkjt) {
        this.totaljjsumkjt = totaljjsumkjt;
    }

    public BigDecimal getServicefeezc() {
        return servicefeezc;
    }

    public void setServicefeezc(BigDecimal servicefeezc) {
        this.servicefeezc = servicefeezc;
    }







    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getEnterpriseorusersid() {
        return enterpriseorusersid;
    }

    public void setEnterpriseorusersid(String enterpriseorusersid) {
        this.enterpriseorusersid = enterpriseorusersid;
    }
    public String getPlanprojectbatchid() {
        return planprojectbatchid;
    }

    public void setPlanprojectbatchid(String planprojectbatchid) {
        this.planprojectbatchid = planprojectbatchid;
    }
    public Date getProjectstartdate() {
        return projectstartdate;
    }

    public void setProjectstartdate(Date projectstartdate) {
        this.projectstartdate = projectstartdate;
    }
    public Date getProjectenddate() {
        return projectenddate;
    }

    public void setProjectenddate(Date projectenddate) {
        this.projectenddate = projectenddate;
    }
    public BigDecimal getProjectsumforself() {
        return projectsumforself;
    }

    public void setProjectsumforself(BigDecimal projectsumforself) {
        this.projectsumforself = projectsumforself;
    }
    public BigDecimal getProjectsumforgov() {
        return projectsumforgov;
    }

    public void setProjectsumforgov(BigDecimal projectsumforgov) {
        this.projectsumforgov = projectsumforgov;
    }
    public BigDecimal getProjecttotalsum() {
        return projecttotalsum;
    }

    public void setProjecttotalsum(BigDecimal projecttotalsum) {
        this.projecttotalsum = projecttotalsum;
    }
    public String getEconomicbenefit() {
        return economicbenefit;
    }

    public void setEconomicbenefit(String economicbenefit) {
        this.economicbenefit = economicbenefit;
    }
    public String getProjectcontent1() {
        return projectcontent1;
    }

    public void setProjectcontent1(String projectcontent1) {
        this.projectcontent1 = projectcontent1;
    }
    public String getProjectachievement1() {
        return projectachievement1;
    }

    public void setProjectachievement1(String projectachievement1) {
        this.projectachievement1 = projectachievement1;
    }
    public String getProjectbasename() {
        return projectbasename;
    }

    public void setProjectbasename(String projectbasename) {
        this.projectbasename = projectbasename;
    }
    public String getDeclarant() {
        return declarant;
    }

    public void setDeclarant(String declarant) {
        this.declarant = declarant;
    }
    public String getAccountfirmid() {
        return accountfirmid;
    }

    public void setAccountfirmid(String accountfirmid) {
        this.accountfirmid = accountfirmid;
    }
    public String getProjectleader() {
        return projectleader;
    }

    public void setProjectleader(String projectleader) {
        this.projectleader = projectleader;
    }
    public String getApplyspecialname() {
        return applyspecialname;
    }

    public void setApplyspecialname(String applyspecialname) {
        this.applyspecialname = applyspecialname;
    }
    public String getProjectapplytype() {
        return projectapplytype;
    }

    public void setProjectapplytype(String projectapplytype) {
        this.projectapplytype = projectapplytype;
    }
    public String getProjectplantype() {
        return projectplantype;
    }

    public void setProjectplantype(String projectplantype) {
        this.projectplantype = projectplantype;
    }
    public String getTechnologicalmode() {
        return technologicalmode;
    }

    public void setTechnologicalmode(String technologicalmode) {
        this.technologicalmode = technologicalmode;
    }
    public String getProjectmanagedomain() {
        return projectmanagedomain;
    }

    public void setProjectmanagedomain(String projectmanagedomain) {
        this.projectmanagedomain = projectmanagedomain;
    }
    public String getAppropriationtype() {
        return appropriationtype;
    }

    public void setAppropriationtype(String appropriationtype) {
        this.appropriationtype = appropriationtype;
    }
    public String getTechnologicalsource() {
        return technologicalsource;
    }

    public void setTechnologicalsource(String technologicalsource) {
        this.technologicalsource = technologicalsource;
    }
    public String getMaincurrentstate() {
        return maincurrentstate;
    }

    public void setMaincurrentstate(String maincurrentstate) {
        this.maincurrentstate = maincurrentstate;
    }
    public String getMaincurrentstateid() {
        return maincurrentstateid;
    }

    public void setMaincurrentstateid(String maincurrentstateid) {
        this.maincurrentstateid = maincurrentstateid;
    }
    public String getMinicurrentstate() {
        return minicurrentstate;
    }

    public void setMinicurrentstate(String minicurrentstate) {
        this.minicurrentstate = minicurrentstate;
    }
    public String getMinicurrentstateid() {
        return minicurrentstateid;
    }

    public void setMinicurrentstateid(String minicurrentstateid) {
        this.minicurrentstateid = minicurrentstateid;
    }
    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }
    public String getExpectedbenefitachievement() {
        return expectedbenefitachievement;
    }

    public void setExpectedbenefitachievement(String expectedbenefitachievement) {
        this.expectedbenefitachievement = expectedbenefitachievement;
    }
    public String getDeclarantid() {
        return declarantid;
    }

    public void setDeclarantid(String declarantid) {
        this.declarantid = declarantid;
    }
    public String getMainorganizers() {
        return mainorganizers;
    }

    public void setMainorganizers(String mainorganizers) {
        this.mainorganizers = mainorganizers;
    }
    public String getResearchcontent1() {
        return researchcontent1;
    }

    public void setResearchcontent1(String researchcontent1) {
        this.researchcontent1 = researchcontent1;
    }
    public String getProjectimplementation() {
        return projectimplementation;
    }

    public void setProjectimplementation(String projectimplementation) {
        this.projectimplementation = projectimplementation;
    }
    public String getResearchinput() {
        return researchinput;
    }

    public void setResearchinput(String researchinput) {
        this.researchinput = researchinput;
    }
    public String getMainbusinessincome() {
        return mainbusinessincome;
    }

    public void setMainbusinessincome(String mainbusinessincome) {
        this.mainbusinessincome = mainbusinessincome;
    }
    public String getEnterprisetypes() {
        return enterprisetypes;
    }

    public void setEnterprisetypes(String enterprisetypes) {
        this.enterprisetypes = enterprisetypes;
    }
    public String getResearchinstitutions() {
        return researchinstitutions;
    }

    public void setResearchinstitutions(String researchinstitutions) {
        this.researchinstitutions = researchinstitutions;
    }
    public String getApplicationno() {
        return applicationno;
    }

    public void setApplicationno(String applicationno) {
        this.applicationno = applicationno;
    }
    public String getTechdomain() {
        return techdomain;
    }

    public void setTechdomain(String techdomain) {
        this.techdomain = techdomain;
    }
    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }
    public String getIscancel() {
        return iscancel;
    }

    public void setIscancel(String iscancel) {
        this.iscancel = iscancel;
    }
    public String getIssetup() {
        return issetup;
    }

    public void setIssetup(String issetup) {
        this.issetup = issetup;
    }
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    public String getChiefdepartment() {
        return chiefdepartment;
    }

    public void setChiefdepartment(String chiefdepartment) {
        this.chiefdepartment = chiefdepartment;
    }
    public String getChieldofficals() {
        return chieldofficals;
    }

    public void setChieldofficals(String chieldofficals) {
        this.chieldofficals = chieldofficals;
    }
    public String getCasemanagement() {
        return casemanagement;
    }

    public void setCasemanagement(String casemanagement) {
        this.casemanagement = casemanagement;
    }
    public String getPlanno() {
        return planno;
    }

    public void setPlanno(String planno) {
        this.planno = planno;
    }
    public String getProjectclassification() {
        return projectclassification;
    }

    public void setProjectclassification(String projectclassification) {
        this.projectclassification = projectclassification;
    }
    public String getProjectresults() {
        return projectresults;
    }

    public void setProjectresults(String projectresults) {
        this.projectresults = projectresults;
    }
    public String getProjectfeatureinforid() {
        return projectfeatureinforid;
    }

    public void setProjectfeatureinforid(String projectfeatureinforid) {
        this.projectfeatureinforid = projectfeatureinforid;
    }
    public String getApplyspecialnamecode() {
        return applyspecialnamecode;
    }

    public void setApplyspecialnamecode(String applyspecialnamecode) {
        this.applyspecialnamecode = applyspecialnamecode;
    }
    public String getProjectapplytypecode() {
        return projectapplytypecode;
    }

    public void setProjectapplytypecode(String projectapplytypecode) {
        this.projectapplytypecode = projectapplytypecode;
    }
    public String getProjectplantypecode() {
        return projectplantypecode;
    }

    public void setProjectplantypecode(String projectplantypecode) {
        this.projectplantypecode = projectplantypecode;
    }
    public String getTechnologicalmodecode() {
        return technologicalmodecode;
    }

    public void setTechnologicalmodecode(String technologicalmodecode) {
        this.technologicalmodecode = technologicalmodecode;
    }
    public String getProjectmanagedomaincode() {
        return projectmanagedomaincode;
    }

    public void setProjectmanagedomaincode(String projectmanagedomaincode) {
        this.projectmanagedomaincode = projectmanagedomaincode;
    }
    public String getAppropriationtypecode() {
        return appropriationtypecode;
    }

    public void setAppropriationtypecode(String appropriationtypecode) {
        this.appropriationtypecode = appropriationtypecode;
    }
    public String getTechnologicalsourcecode() {
        return technologicalsourcecode;
    }

    public void setTechnologicalsourcecode(String technologicalsourcecode) {
        this.technologicalsourcecode = technologicalsourcecode;
    }
    public String getCurrentsate() {
        return currentsate;
    }

    public void setCurrentsate(String currentsate) {
        this.currentsate = currentsate;
    }
    public String getBelonglab() {
        return belonglab;
    }

    public void setBelonglab(String belonglab) {
        this.belonglab = belonglab;
    }
    public String getBelonglabid() {
        return belonglabid;
    }

    public void setBelonglabid(String belonglabid) {
        this.belonglabid = belonglabid;
    }
    public String getIndustryfield() {
        return industryfield;
    }

    public void setIndustryfield(String industryfield) {
        this.industryfield = industryfield;
    }
    public String getTechdomaincode() {
        return techdomaincode;
    }

    public void setTechdomaincode(String techdomaincode) {
        this.techdomaincode = techdomaincode;
    }
    public String getIndustryfieldcode() {
        return industryfieldcode;
    }

    public void setIndustryfieldcode(String industryfieldcode) {
        this.industryfieldcode = industryfieldcode;
    }
    public String getSubjectareas() {
        return subjectareas;
    }

    public void setSubjectareas(String subjectareas) {
        this.subjectareas = subjectareas;
    }
    public String getSubjectareascode() {
        return subjectareascode;
    }

    public void setSubjectareascode(String subjectareascode) {
        this.subjectareascode = subjectareascode;
    }
    public String getTechnicalrank() {
        return technicalrank;
    }

    public void setTechnicalrank(String technicalrank) {
        this.technicalrank = technicalrank;
    }
    public String getCasemanagementcode() {
        return casemanagementcode;
    }

    public void setCasemanagementcode(String casemanagementcode) {
        this.casemanagementcode = casemanagementcode;
    }
    public String getCasemanagementid() {
        return casemanagementid;
    }

    public void setCasemanagementid(String casemanagementid) {
        this.casemanagementid = casemanagementid;
    }
    public String getProjectclassificationcode() {
        return projectclassificationcode;
    }

    public void setProjectclassificationcode(String projectclassificationcode) {
        this.projectclassificationcode = projectclassificationcode;
    }
    public String getShgyly() {
        return shgyly;
    }

    public void setShgyly(String shgyly) {
        this.shgyly = shgyly;
    }
    public String getShgylycode() {
        return shgylycode;
    }

    public void setShgylycode(String shgylycode) {
        this.shgylycode = shgylycode;
    }
    public String getSecondprojectname() {
        return secondprojectname;
    }

    public void setSecondprojectname(String secondprojectname) {
        this.secondprojectname = secondprojectname;
    }
    public String getDayipingtai() {
        return dayipingtai;
    }

    public void setDayipingtai(String dayipingtai) {
        this.dayipingtai = dayipingtai;
    }
    public String getZaitimingcheng() {
        return zaitimingcheng;
    }

    public void setZaitimingcheng(String zaitimingcheng) {
        this.zaitimingcheng = zaitimingcheng;
    }
    public String getPurposemean() {
        return purposemean;
    }

    public void setPurposemean(String purposemean) {
        this.purposemean = purposemean;
    }
    public String getYptqiyeleixing() {
        return yptqiyeleixing;
    }

    public void setYptqiyeleixing(String yptqiyeleixing) {
        this.yptqiyeleixing = yptqiyeleixing;
    }
    public String getResearchcontent() {
        return researchcontent;
    }

    public void setResearchcontent(String researchcontent) {
        this.researchcontent = researchcontent;
    }
    public String getProjectcontent() {
        return projectcontent;
    }

    public void setProjectcontent(String projectcontent) {
        this.projectcontent = projectcontent;
    }
    public String getProjectachievement() {
        return projectachievement;
    }

    public void setProjectachievement(String projectachievement) {
        this.projectachievement = projectachievement;
    }
    public Date getUpdatelasttime() {
        return updatelasttime;
    }

    public void setUpdatelasttime(Date updatelasttime) {
        this.updatelasttime = updatelasttime;
    }
    public BigDecimal getAchievesalesrevenue() {
        return achievesalesrevenue;
    }

    public void setAchievesalesrevenue(BigDecimal achievesalesrevenue) {
        this.achievesalesrevenue = achievesalesrevenue;
    }
    public BigDecimal getProfits() {
        return profits;
    }

    public void setProfits(BigDecimal profits) {
        this.profits = profits;
    }
    public BigDecimal getImplementpaystaxes() {
        return implementpaystaxes;
    }

    public void setImplementpaystaxes(BigDecimal implementpaystaxes) {
        this.implementpaystaxes = implementpaystaxes;
    }
    public String getZttype() {
        return zttype;
    }

    public void setZttype(String zttype) {
        this.zttype = zttype;
    }
    public String getDaxingyiqi() {
        return daxingyiqi;
    }

    public void setDaxingyiqi(String daxingyiqi) {
        this.daxingyiqi = daxingyiqi;
    }
    public String getChuangxinquan() {
        return chuangxinquan;
    }

    public void setChuangxinquan(String chuangxinquan) {
        this.chuangxinquan = chuangxinquan;
    }
    public String getZaitimingchenid() {
        return zaitimingchenid;
    }

    public void setZaitimingchenid(String zaitimingchenid) {
        this.zaitimingchenid = zaitimingchenid;
    }
    public String getShowprojectbasename() {
        return showprojectbasename;
    }

    public void setShowprojectbasename(String showprojectbasename) {
        this.showprojectbasename = showprojectbasename;
    }
    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }
    public String getPossessconditions() {
        return possessconditions;
    }

    public void setPossessconditions(String possessconditions) {
        this.possessconditions = possessconditions;
    }
    public BigDecimal getActualpayment() {
        return actualpayment;
    }

    public void setActualpayment(BigDecimal actualpayment) {
        this.actualpayment = actualpayment;
    }
    public String getTruefalse() {
        return truefalse;
    }

    public void setTruefalse(String truefalse) {
        this.truefalse = truefalse;
    }
    public String getExpertresult() {
        return expertresult;
    }

    public void setExpertresult(String expertresult) {
        this.expertresult = expertresult;
    }
    public BigDecimal getCsjyjf() {
        return csjyjf;
    }

    public void setCsjyjf(BigDecimal csjyjf) {
        this.csjyjf = csjyjf;
    }
    public String getCscsjg() {
        return cscsjg;
    }

    public void setCscsjg(String cscsjg) {
        this.cscsjg = cscsjg;
    }
    public BigDecimal getCsczjyjf() {
        return csczjyjf;
    }

    public void setCsczjyjf(BigDecimal csczjyjf) {
        this.csczjyjf = csczjyjf;
    }
    public String getCsczshjg() {
        return csczshjg;
    }

    public void setCsczshjg(String csczshjg) {
        this.csczshjg = csczshjg;
    }
    public String getFinalprojectname() {
        return finalprojectname;
    }

    public void setFinalprojectname(String finalprojectname) {
        this.finalprojectname = finalprojectname;
    }
    public String getFinaltaskprojectname() {
        return finaltaskprojectname;
    }

    public void setFinaltaskprojectname(String finaltaskprojectname) {
        this.finaltaskprojectname = finaltaskprojectname;
    }
    public String getXmzgid() {
        return xmzgid;
    }

    public void setXmzgid(String xmzgid) {
        this.xmzgid = xmzgid;
    }
    public String getLsxmzgid() {
        return lsxmzgid;
    }

    public void setLsxmzgid(String lsxmzgid) {
        this.lsxmzgid = lsxmzgid;
    }
    public String getActivitiid() {
        return activitiid;
    }

    public void setActivitiid(String activitiid) {
        this.activitiid = activitiid;
    }
    public String getPlanprojectbatchid2() {
        return planprojectbatchid2;
    }

    public void setPlanprojectbatchid2(String planprojectbatchid2) {
        this.planprojectbatchid2 = planprojectbatchid2;
    }
    public String getActGxc() {
        return actGxc;
    }

    public void setActGxc(String actGxc) {
        this.actGxc = actGxc;
    }
    public String getActKjc() {
        return actKjc;
    }

    public void setActKjc(String actKjc) {
        this.actKjc = actKjc;
    }
    public String getActSfc() {
        return actSfc;
    }

    public void setActSfc(String actSfc) {
        this.actSfc = actSfc;
    }
    public String getActGjc() {
        return actGjc;
    }

    public void setActGjc(String actGjc) {
        this.actGjc = actGjc;
    }
    public String getActZsc() {
        return actZsc;
    }

    public void setActZsc(String actZsc) {
        this.actZsc = actZsc;
    }
    public String getActZlglc() {
        return actZlglc;
    }

    public void setActZlglc(String actZlglc) {
        this.actZlglc = actZlglc;
    }
    public String getActZlbhc() {
        return actZlbhc;
    }

    public void setActZlbhc(String actZlbhc) {
        this.actZlbhc = actZlbhc;
    }
    public String getActCxc() {
        return actCxc;
    }

    public void setActCxc(String actCxc) {
        this.actCxc = actCxc;
    }
    public String getActNcc() {
        return actNcc;
    }

    public void setActNcc(String actNcc) {
        this.actNcc = actNcc;
    }
    public String getActFgc() {
        return actFgc;
    }

    public void setActFgc(String actFgc) {
        this.actFgc = actFgc;
    }
    public String getActZsjgdw() {
        return actZsjgdw;
    }

    public void setActZsjgdw(String actZsjgdw) {
        this.actZsjgdw = actZsjgdw;
    }
    public String getActJjs() {
        return actJjs;
    }

    public void setActJjs(String actJjs) {
        this.actJjs = actJjs;
    }
    public String getXmzgidGxc() {
        return xmzgidGxc;
    }

    public void setXmzgidGxc(String xmzgidGxc) {
        this.xmzgidGxc = xmzgidGxc;
    }
    public String getXmzgidKjc() {
        return xmzgidKjc;
    }

    public void setXmzgidKjc(String xmzgidKjc) {
        this.xmzgidKjc = xmzgidKjc;
    }
    public String getXmzgidSfc() {
        return xmzgidSfc;
    }

    public void setXmzgidSfc(String xmzgidSfc) {
        this.xmzgidSfc = xmzgidSfc;
    }
    public String getXmzgidGjc() {
        return xmzgidGjc;
    }

    public void setXmzgidGjc(String xmzgidGjc) {
        this.xmzgidGjc = xmzgidGjc;
    }
    public String getXmzgidZsc() {
        return xmzgidZsc;
    }

    public void setXmzgidZsc(String xmzgidZsc) {
        this.xmzgidZsc = xmzgidZsc;
    }
    public String getXmzgidZlglc() {
        return xmzgidZlglc;
    }

    public void setXmzgidZlglc(String xmzgidZlglc) {
        this.xmzgidZlglc = xmzgidZlglc;
    }
    public String getXmzgidZlbhc() {
        return xmzgidZlbhc;
    }

    public void setXmzgidZlbhc(String xmzgidZlbhc) {
        this.xmzgidZlbhc = xmzgidZlbhc;
    }
    public String getXmzgidCxc() {
        return xmzgidCxc;
    }

    public void setXmzgidCxc(String xmzgidCxc) {
        this.xmzgidCxc = xmzgidCxc;
    }
    public String getXmzgidNcc() {
        return xmzgidNcc;
    }

    public void setXmzgidNcc(String xmzgidNcc) {
        this.xmzgidNcc = xmzgidNcc;
    }
    public String getXmzgidFgc() {
        return xmzgidFgc;
    }

    public void setXmzgidFgc(String xmzgidFgc) {
        this.xmzgidFgc = xmzgidFgc;
    }
    public String getXmzgidZsjgdw() {
        return xmzgidZsjgdw;
    }

    public void setXmzgidZsjgdw(String xmzgidZsjgdw) {
        this.xmzgidZsjgdw = xmzgidZsjgdw;
    }
    public String getXmzgidJjs() {
        return xmzgidJjs;
    }

    public void setXmzgidJjs(String xmzgidJjs) {
        this.xmzgidJjs = xmzgidJjs;
    }
    public String getLsxmzgidGxc() {
        return lsxmzgidGxc;
    }

    public void setLsxmzgidGxc(String lsxmzgidGxc) {
        this.lsxmzgidGxc = lsxmzgidGxc;
    }
    public String getLsxmzgidKjc() {
        return lsxmzgidKjc;
    }

    public void setLsxmzgidKjc(String lsxmzgidKjc) {
        this.lsxmzgidKjc = lsxmzgidKjc;
    }
    public String getLsxmzgidSfc() {
        return lsxmzgidSfc;
    }

    public void setLsxmzgidSfc(String lsxmzgidSfc) {
        this.lsxmzgidSfc = lsxmzgidSfc;
    }
    public String getLsxmzgidGjc() {
        return lsxmzgidGjc;
    }

    public void setLsxmzgidGjc(String lsxmzgidGjc) {
        this.lsxmzgidGjc = lsxmzgidGjc;
    }
    public String getLsxmzgidZsc() {
        return lsxmzgidZsc;
    }

    public void setLsxmzgidZsc(String lsxmzgidZsc) {
        this.lsxmzgidZsc = lsxmzgidZsc;
    }
    public String getLsxmzgidZlglc() {
        return lsxmzgidZlglc;
    }

    public void setLsxmzgidZlglc(String lsxmzgidZlglc) {
        this.lsxmzgidZlglc = lsxmzgidZlglc;
    }
    public String getLsxmzgidZlbhc() {
        return lsxmzgidZlbhc;
    }

    public void setLsxmzgidZlbhc(String lsxmzgidZlbhc) {
        this.lsxmzgidZlbhc = lsxmzgidZlbhc;
    }
    public String getLsxmzgidCxc() {
        return lsxmzgidCxc;
    }

    public void setLsxmzgidCxc(String lsxmzgidCxc) {
        this.lsxmzgidCxc = lsxmzgidCxc;
    }
    public String getLsxmzgidNcc() {
        return lsxmzgidNcc;
    }

    public String getPactno() {
        return pactno;
    }

    public void setPactno(String pactno) {
        this.pactno = pactno;
    }

    public BigDecimal getJhxtzkjjf() {
        return jhxtzkjjf;
    }

    public void setJhxtzkjjf(BigDecimal jhxtzkjjf) {
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

    public void setLsxmzgidNcc(String lsxmzgidNcc) {
        this.lsxmzgidNcc = lsxmzgidNcc;
    }
    public String getLsxmzgidFgc() {
        return lsxmzgidFgc;
    }

    public void setLsxmzgidFgc(String lsxmzgidFgc) {
        this.lsxmzgidFgc = lsxmzgidFgc;
    }
    public String getLsxmzgidZsjgdw() {
        return lsxmzgidZsjgdw;
    }

    public void setLsxmzgidZsjgdw(String lsxmzgidZsjgdw) {
        this.lsxmzgidZsjgdw = lsxmzgidZsjgdw;
    }
    public String getLsxmzgidJjs() {
        return lsxmzgidJjs;
    }

    public void setLsxmzgidJjs(String lsxmzgidJjs) {
        this.lsxmzgidJjs = lsxmzgidJjs;
    }
    public String getZhuanjiazumingdan() {
        return zhuanjiazumingdan;
    }

    public void setZhuanjiazumingdan(String zhuanjiazumingdan) {
        this.zhuanjiazumingdan = zhuanjiazumingdan;
    }
    public String getChushiopinion() {
        return chushiopinion;
    }

    public void setChushiopinion(String chushiopinion) {
        this.chushiopinion = chushiopinion;
    }
    public BigDecimal getDnjf() {
        return dnjf;
    }

    public void setDnjf(BigDecimal dnjf) {
        this.dnjf = dnjf;
    }
    public String getJzpyfl() {
        return jzpyfl;
    }

    public void setJzpyfl(String jzpyfl) {
        this.jzpyfl = jzpyfl;
    }
    public String getJzpsfz() {
        return jzpsfz;
    }

    public void setJzpsfz(String jzpsfz) {
        this.jzpsfz = jzpsfz;
    }
    public String getJzpshyxm() {
        return jzpshyxm;
    }

    public void setJzpshyxm(String jzpshyxm) {
        this.jzpshyxm = jzpshyxm;
    }
    public String getKjtopinion() {
        return kjtopinion;
    }

    public void setKjtopinion(String kjtopinion) {
        this.kjtopinion = kjtopinion;
    }
    public BigDecimal getDefaultindex() {
        return defaultindex;
    }

    public void setDefaultindex(BigDecimal defaultindex) {
        this.defaultindex = defaultindex;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public BigDecimal getCreatelaborfee() {
        return createlaborfee;
    }

    public void setCreatelaborfee(BigDecimal createlaborfee) {
        this.createlaborfee = createlaborfee;
    }
    public BigDecimal getTotallabor() {
        return totallabor;
    }

    public void setTotallabor(BigDecimal totallabor) {
        this.totallabor = totallabor;
    }
    public String getProfessionaltitle() {
        return professionaltitle;
    }

    public void setProfessionaltitle(String professionaltitle) {
        this.professionaltitle = professionaltitle;
    }
    public String getCountunit() {
        return countunit;
    }

    public void setCountunit(String countunit) {
        this.countunit = countunit;
    }
    public String getTestcontentunit() {
        return testcontentunit;
    }

    public void setTestcontentunit(String testcontentunit) {
        this.testcontentunit = testcontentunit;
    }
    public String getTestcontent() {
        return testcontent;
    }

    public void setTestcontent(String testcontent) {
        this.testcontent = testcontent;
    }
    public String getShowstate() {
        return showstate;
    }

    public void setShowstate(String showstate) {
        this.showstate = showstate;
    }
    public BigDecimal getJfbzjf() {
        return jfbzjf;
    }

    public void setJfbzjf(BigDecimal jfbzjf) {
        this.jfbzjf = jfbzjf;
    }
    public String getHtlczt() {
        return htlczt;
    }

    public void setHtlczt(String htlczt) {
        this.htlczt = htlczt;
    }
    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }
    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
    }
    public String getActJcc() {
        return actJcc;
    }

    public void setActJcc(String actJcc) {
        this.actJcc = actJcc;
    }
    public String getActRsc() {
        return actRsc;
    }

    public void setActRsc(String actRsc) {
        this.actRsc = actRsc;
    }
    public String getActJjb() {
        return actJjb;
    }

    public void setActJjb(String actJjb) {
        this.actJjb = actJjb;
    }
    public String getXmzgidJcc() {
        return xmzgidJcc;
    }

    public void setXmzgidJcc(String xmzgidJcc) {
        this.xmzgidJcc = xmzgidJcc;
    }
    public String getXmzgidRsc() {
        return xmzgidRsc;
    }

    public void setXmzgidRsc(String xmzgidRsc) {
        this.xmzgidRsc = xmzgidRsc;
    }
    public String getXmzgidJjb() {
        return xmzgidJjb;
    }

    public void setXmzgidJjb(String xmzgidJjb) {
        this.xmzgidJjb = xmzgidJjb;
    }
    public String getLsxmzgidJcc() {
        return lsxmzgidJcc;
    }

    public void setLsxmzgidJcc(String lsxmzgidJcc) {
        this.lsxmzgidJcc = lsxmzgidJcc;
    }
    public String getLsxmzgidRsc() {
        return lsxmzgidRsc;
    }

    public void setLsxmzgidRsc(String lsxmzgidRsc) {
        this.lsxmzgidRsc = lsxmzgidRsc;
    }
    public String getCddwmc() {
        return cddwmc;
    }

    public void setCddwmc(String cddwmc) {
        this.cddwmc = cddwmc;
    }
    public String getHtxmfzr() {
        return htxmfzr;
    }

    public void setHtxmfzr(String htxmfzr) {
        this.htxmfzr = htxmfzr;
    }
    public String getXmhdlx() {
        return xmhdlx;
    }

    public void setXmhdlx(String xmhdlx) {
        this.xmhdlx = xmhdlx;
    }
    public String getXmyzntype() {
        return xmyzntype;
    }

    public void setXmyzntype(String xmyzntype) {
        this.xmyzntype = xmyzntype;
    }
    public String getXmyznly() {
        return xmyznly;
    }

    public void setXmyznly(String xmyznly) {
        this.xmyznly = xmyznly;
    }
    public String getXmyznzt() {
        return xmyznzt;
    }

    public void setXmyznzt(String xmyznzt) {
        this.xmyznzt = xmyznzt;
    }
    public String getXmyzndesc() {
        return xmyzndesc;
    }

    public void setXmyzndesc(String xmyzndesc) {
        this.xmyzndesc = xmyzndesc;
    }
    public String getXmwcslx() {
        return xmwcslx;
    }

    public void setXmwcslx(String xmwcslx) {
        this.xmwcslx = xmwcslx;
    }
    public String getXmhdlxcode() {
        return xmhdlxcode;
    }

    public void setXmhdlxcode(String xmhdlxcode) {
        this.xmhdlxcode = xmhdlxcode;
    }
    public String getProjectleaderphone() {
        return projectleaderphone;
    }

    public void setProjectleaderphone(String projectleaderphone) {
        this.projectleaderphone = projectleaderphone;
    }
    public String getSsjsly() {
        return ssjsly;
    }

    public void setSsjsly(String ssjsly) {
        this.ssjsly = ssjsly;
    }
    public String getSsjslycode() {
        return ssjslycode;
    }

    public void setSsjslycode(String ssjslycode) {
        this.ssjslycode = ssjslycode;
    }
    public String getXmwcslxcode() {
        return xmwcslxcode;
    }

    public void setXmwcslxcode(String xmwcslxcode) {
        this.xmwcslxcode = xmwcslxcode;
    }
    public String getProjectsearchtype() {
        return projectsearchtype;
    }

    public void setProjectsearchtype(String projectsearchtype) {
        this.projectsearchtype = projectsearchtype;
    }
    public String getSfsygjmm() {
        return sfsygjmm;
    }

    public void setSfsygjmm(String sfsygjmm) {
        this.sfsygjmm = sfsygjmm;
    }
    public String getSuperuser() {
        return superuser;
    }

    public void setSuperuser(String superuser) {
        this.superuser = superuser;
    }
    public String getXmlx() {
        return xmlx;
    }

    public void setXmlx(String xmlx) {
        this.xmlx = xmlx;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getEnkeywords() {
        return enkeywords;
    }

    public void setEnkeywords(String enkeywords) {
        this.enkeywords = enkeywords;
    }
    public String getLeadercertificateno() {
        return leadercertificateno;
    }

    public void setLeadercertificateno(String leadercertificateno) {
        this.leadercertificateno = leadercertificateno;
    }
    public String getIsable() {
        return isable;
    }

    public void setIsable(String isable) {
        this.isable = isable;
    }
    public String getIsbackstuff() {
        return isbackstuff;
    }

    public void setIsbackstuff(String isbackstuff) {
        this.isbackstuff = isbackstuff;
    }
    public String getIzteamid() {
        return izteamid;
    }

    public void setIzteamid(String izteamid) {
        this.izteamid = izteamid;
    }
    public String getIsreview() {
        return isreview;
    }

    public void setIsreview(String isreview) {
        this.isreview = isreview;
    }
    public String getIsmeeting() {
        return ismeeting;
    }

    public void setIsmeeting(String ismeeting) {
        this.ismeeting = ismeeting;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public String getOldplanno() {
        return oldplanno;
    }

    public void setOldplanno(String oldplanno) {
        this.oldplanno = oldplanno;
    }
    public String getImplcontent() {
        return implcontent;
    }

    public void setImplcontent(String implcontent) {
        this.implcontent = implcontent;
    }
    public String getAffixes() {
        return affixes;
    }

    public void setAffixes(String affixes) {
        this.affixes = affixes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PactProjectbase{" +
        "id=" + id +
        ", enterpriseorusersid=" + enterpriseorusersid +
        ", planprojectbatchid=" + planprojectbatchid +
        ", projectstartdate=" + projectstartdate +
        ", projectenddate=" + projectenddate +
        ", projectsumforself=" + projectsumforself +
        ", projectsumforgov=" + projectsumforgov +
        ", projecttotalsum=" + projecttotalsum +
        ", economicbenefit=" + economicbenefit +
        ", projectcontent1=" + projectcontent1 +
        ", projectachievement1=" + projectachievement1 +
        ", projectbasename=" + projectbasename +
        ", declarant=" + declarant +
        ", accountfirmid=" + accountfirmid +
        ", projectleader=" + projectleader +
        ", applyspecialname=" + applyspecialname +
        ", projectapplytype=" + projectapplytype +
        ", projectplantype=" + projectplantype +
        ", technologicalmode=" + technologicalmode +
        ", projectmanagedomain=" + projectmanagedomain +
        ", appropriationtype=" + appropriationtype +
        ", technologicalsource=" + technologicalsource +
        ", maincurrentstate=" + maincurrentstate +
        ", maincurrentstateid=" + maincurrentstateid +
        ", minicurrentstate=" + minicurrentstate +
        ", minicurrentstateid=" + minicurrentstateid +
        ", applydate=" + applydate +
        ", expectedbenefitachievement=" + expectedbenefitachievement +
        ", declarantid=" + declarantid +
        ", mainorganizers=" + mainorganizers +
        ", researchcontent1=" + researchcontent1 +
        ", projectimplementation=" + projectimplementation +
        ", researchinput=" + researchinput +
        ", mainbusinessincome=" + mainbusinessincome +
        ", enterprisetypes=" + enterprisetypes +
        ", researchinstitutions=" + researchinstitutions +
        ", applicationno=" + applicationno +
        ", techdomain=" + techdomain +
        ", submitdate=" + submitdate +
        ", iscancel=" + iscancel +
        ", issetup=" + issetup +
        ", createdate=" + createdate +
        ", chiefdepartment=" + chiefdepartment +
        ", chieldofficals=" + chieldofficals +
        ", casemanagement=" + casemanagement +
        ", planno=" + planno +
        ", projectclassification=" + projectclassification +
        ", projectresults=" + projectresults +
        ", projectfeatureinforid=" + projectfeatureinforid +
        ", applyspecialnamecode=" + applyspecialnamecode +
        ", projectapplytypecode=" + projectapplytypecode +
        ", projectplantypecode=" + projectplantypecode +
        ", technologicalmodecode=" + technologicalmodecode +
        ", projectmanagedomaincode=" + projectmanagedomaincode +
        ", appropriationtypecode=" + appropriationtypecode +
        ", technologicalsourcecode=" + technologicalsourcecode +
        ", currentsate=" + currentsate +
        ", belonglab=" + belonglab +
        ", belonglabid=" + belonglabid +
        ", industryfield=" + industryfield +
        ", techdomaincode=" + techdomaincode +
        ", industryfieldcode=" + industryfieldcode +
        ", subjectareas=" + subjectareas +
        ", subjectareascode=" + subjectareascode +
        ", technicalrank=" + technicalrank +
        ", casemanagementcode=" + casemanagementcode +
        ", casemanagementid=" + casemanagementid +
        ", projectclassificationcode=" + projectclassificationcode +
        ", shgyly=" + shgyly +
        ", shgylycode=" + shgylycode +
        ", secondprojectname=" + secondprojectname +
        ", dayipingtai=" + dayipingtai +
        ", zaitimingcheng=" + zaitimingcheng +
        ", purposemean=" + purposemean +
        ", yptqiyeleixing=" + yptqiyeleixing +
        ", researchcontent=" + researchcontent +
        ", projectcontent=" + projectcontent +
        ", projectachievement=" + projectachievement +
        ", updatelasttime=" + updatelasttime +
        ", achievesalesrevenue=" + achievesalesrevenue +
        ", profits=" + profits +
        ", implementpaystaxes=" + implementpaystaxes +
        ", zttype=" + zttype +
        ", daxingyiqi=" + daxingyiqi +
        ", chuangxinquan=" + chuangxinquan +
        ", zaitimingchenid=" + zaitimingchenid +
        ", showprojectbasename=" + showprojectbasename +
        ", batchname=" + batchname +
        ", possessconditions=" + possessconditions +
        ", actualpayment=" + actualpayment +
        ", truefalse=" + truefalse +
        ", expertresult=" + expertresult +
        ", csjyjf=" + csjyjf +
        ", cscsjg=" + cscsjg +
        ", csczjyjf=" + csczjyjf +
        ", csczshjg=" + csczshjg +
        ", finalprojectname=" + finalprojectname +
        ", finaltaskprojectname=" + finaltaskprojectname +
        ", xmzgid=" + xmzgid +
        ", lsxmzgid=" + lsxmzgid +
        ", activitiid=" + activitiid +
        ", planprojectbatchid2=" + planprojectbatchid2 +
        ", actGxc=" + actGxc +
        ", actKjc=" + actKjc +
        ", actSfc=" + actSfc +
        ", actGjc=" + actGjc +
        ", actZsc=" + actZsc +
        ", actZlglc=" + actZlglc +
        ", actZlbhc=" + actZlbhc +
        ", actCxc=" + actCxc +
        ", actNcc=" + actNcc +
        ", actFgc=" + actFgc +
        ", actZsjgdw=" + actZsjgdw +
        ", actJjs=" + actJjs +
        ", xmzgidGxc=" + xmzgidGxc +
        ", xmzgidKjc=" + xmzgidKjc +
        ", xmzgidSfc=" + xmzgidSfc +
        ", xmzgidGjc=" + xmzgidGjc +
        ", xmzgidZsc=" + xmzgidZsc +
        ", xmzgidZlglc=" + xmzgidZlglc +
        ", xmzgidZlbhc=" + xmzgidZlbhc +
        ", xmzgidCxc=" + xmzgidCxc +
        ", xmzgidNcc=" + xmzgidNcc +
        ", xmzgidFgc=" + xmzgidFgc +
        ", xmzgidZsjgdw=" + xmzgidZsjgdw +
        ", xmzgidJjs=" + xmzgidJjs +
        ", lsxmzgidGxc=" + lsxmzgidGxc +
        ", lsxmzgidKjc=" + lsxmzgidKjc +
        ", lsxmzgidSfc=" + lsxmzgidSfc +
        ", lsxmzgidGjc=" + lsxmzgidGjc +
        ", lsxmzgidZsc=" + lsxmzgidZsc +
        ", lsxmzgidZlglc=" + lsxmzgidZlglc +
        ", lsxmzgidZlbhc=" + lsxmzgidZlbhc +
        ", lsxmzgidCxc=" + lsxmzgidCxc +
        ", lsxmzgidNcc=" + lsxmzgidNcc +
        ", lsxmzgidFgc=" + lsxmzgidFgc +
        ", lsxmzgidZsjgdw=" + lsxmzgidZsjgdw +
        ", lsxmzgidJjs=" + lsxmzgidJjs +
        ", zhuanjiazumingdan=" + zhuanjiazumingdan +
        ", chushiopinion=" + chushiopinion +
        ", dnjf=" + dnjf +
        ", jzpyfl=" + jzpyfl +
        ", jzpsfz=" + jzpsfz +
        ", jzpshyxm=" + jzpshyxm +
        ", kjtopinion=" + kjtopinion +
        ", defaultindex=" + defaultindex +
        ", createtime=" + createtime +
        ", createlaborfee=" + createlaborfee +
        ", totallabor=" + totallabor +
        ", professionaltitle=" + professionaltitle +
        ", countunit=" + countunit +
        ", testcontentunit=" + testcontentunit +
        ", testcontent=" + testcontent +
        ", showstate=" + showstate +
        ", jfbzjf=" + jfbzjf +
        ", htlczt=" + htlczt +
        ", contractno=" + contractno +
        ", contractname=" + contractname +
        ", actJcc=" + actJcc +
        ", actRsc=" + actRsc +
        ", actJjb=" + actJjb +
        ", xmzgidJcc=" + xmzgidJcc +
        ", xmzgidRsc=" + xmzgidRsc +
        ", xmzgidJjb=" + xmzgidJjb +
        ", lsxmzgidJcc=" + lsxmzgidJcc +
        ", lsxmzgidRsc=" + lsxmzgidRsc +
        ", cddwmc=" + cddwmc +
        ", htxmfzr=" + htxmfzr +
        ", xmhdlx=" + xmhdlx +
        ", xmyzntype=" + xmyzntype +
        ", xmyznly=" + xmyznly +
        ", xmyznzt=" + xmyznzt +
        ", xmyzndesc=" + xmyzndesc +
        ", xmwcslx=" + xmwcslx +
        ", xmhdlxcode=" + xmhdlxcode +
        ", projectleaderphone=" + projectleaderphone +
        ", ssjsly=" + ssjsly +
        ", ssjslycode=" + ssjslycode +
        ", xmwcslxcode=" + xmwcslxcode +
        ", projectsearchtype=" + projectsearchtype +
        ", sfsygjmm=" + sfsygjmm +
        ", superuser=" + superuser +
        ", xmlx=" + xmlx +
        ", keywords=" + keywords +
        ", enkeywords=" + enkeywords +
        ", leadercertificateno=" + leadercertificateno +
        ", isable=" + isable +
        ", isbackstuff=" + isbackstuff +
        ", izteamid=" + izteamid +
        ", isreview=" + isreview +
        ", ismeeting=" + ismeeting +
        ", pactid=" + pactid +
        ", oldplanno=" + oldplanno +
        ", implcontent=" + implcontent +
        ", affixes=" + affixes +
        "}";
    }
}
