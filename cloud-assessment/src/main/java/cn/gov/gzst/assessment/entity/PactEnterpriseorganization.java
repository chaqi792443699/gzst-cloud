package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
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
@TableName("pact_enterpriseorganization")
public class PactEnterpriseorganization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 企业名称
     */
    @TableField("organizationname")
    private String organizationname;

    /**
     * 简称
     */
    @TableField("organizationsimplename")
    private String organizationsimplename;

    /**
     * 企业类型
     */
    @TableField("organizationtype")
    private String organizationtype;

    /**
     * 法人代码
     */
    @TableField("legalcode")
    private String legalcode;

    /**
     * 所在区域代码
     */
    @TableField("addresscode")
    private String addresscode;

    /**
     * 归口管理部门
     */
    @TableField("managedepartment")
    private String managedepartment;

    /**
     * 通讯地址
     */
    @TableField("commintucateaddress")
    private String commintucateaddress;

    /**
     * 邮政编码
     */
    @TableField("postcard")
    private String postcard;

    /**
     * 单位email
     */
    @TableField("organizaitonemail")
    private String organizaitonemail;

    /**
     * 单位联系人
     */
    @TableField("organizationcontact")
    private String organizationcontact;

    /**
     * 单位联系人电话
     */
    @TableField("organizationphone")
    private String organizationphone;

    /**
     * 单位传真
     */
    @TableField("organizationfax")
    private String organizationfax;

    /**
     * 银行账号
     */
    @TableField("banknumber")
    private String banknumber;

    /**
     * 管理企业id
     */
    @TableField("enterpriseid")
    private String enterpriseid;

    /**
     * 项目id
     */
    @TableField("projectbaseid")
    private String projectbaseid;

    /**
     * 责任分工
     */
    @TableField("dutyforproject")
    private String dutyforproject;

    /**
     * true 为主办单位 assume为其他承担单位 空为合作单位
     */
    @TableField("ismainenterprise")
    private String ismainenterprise;

    /**
     * 经济类别
     */
    @TableField("economiccategory")
    private String economiccategory;

    /**
     * 企业规模
     */
    @TableField("enterprisescale")
    private String enterprisescale;

    /**
     * 高新技术企业
     */
    @TableField("technologyenterprises")
    private String technologyenterprises;

    /**
     * 职工人数
     */
    @TableField("numberofstaff")
    private String numberofstaff;

    /**
     * 工程技术人员数
     */
    @TableField("technicalpersonnel")
    private String technicalpersonnel;

    /**
     * 资产总额(万元)
     */
    @TableField("totalassets")
    private String totalassets;

    /**
     * 年销售额(万元)
     */
    @TableField("annualsales")
    private String annualsales;

    /**
     * 年研究开发经费(万元)
     */
    @TableField("fundingforesearch")
    private String fundingforesearch;

    /**
     * 近两年有无产品列入新产品计划
     */
    @TableField("newproductplan")
    private String newproductplan;

    /**
     * 手机
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 企业类型 在用
     */
    @TableField("enterprisetype")
    private String enterprisetype;

    /**
     * 单位负责人
     */
    @TableField("organizationhead")
    private String organizationhead;

    @TableField("seq")
    private BigDecimal seq;

    /**
     * 注册时间
     */
    @TableField("registerdate")
    private Date registerdate;

    @TableField("belongsvillage")
    private String belongsvillage;

    @TableField("leadingproductname")
    private String leadingproductname;

    @TableField("lastyearsales")
    private BigDecimal lastyearsales;

    @TableField("developmentfee")
    private BigDecimal developmentfee;

    @TableField("contractstartdate")
    private Date contractstartdate;

    @TableField("contractenddate")
    private Date contractenddate;

    @TableField("leader")
    private String leader;

    @TableField("leadertel")
    private String leadertel;

    /**
     *   法人代表
     */
    @TableField("legalrepresentative")
    private String legalrepresentative;

    /**
     * 年度销售收入
     */
    @TableField("annualsalesrevenue")
    private BigDecimal annualsalesrevenue;

    /**
     * 研究基地// 单位开户名称
     */
    @TableField("researchbase")
    private String researchbase;

    /**
     * 合作形式
     */
    @TableField("cooperation")
    private String cooperation;

    /**
     * 申报书ID
     */
    @TableField("xmsbsid")
    private String xmsbsid;

    /**
     * 法人联系电话
     */
    @TableField("contactphone")
    private String contactphone;

    /**
     * 单位性质
     */
    @TableField("unitproperty")
    private String unitproperty;

    /**
     * 法人移动电话
     */
    @TableField("legalmobilephone")
    private String legalmobilephone;

    /**
     * 联系人移动电话
     */
    @TableField("contactmobilphone")
    private String contactmobilphone;

    /**
     * 开始时间
     */
    @TableField("starttime")
    private Date starttime;

    /**
     * 结束时间
     */
    @TableField("overtime")
    private Date overtime;

    /**
     * 推广应用量
     */
    @TableField("application")
    private String application;

    /**
     * 销售收入tax
     */
    @TableField("saleincome")
    private BigDecimal saleincome;

    /**
     * 销售税收
     */
    @TableField("tax")
    private BigDecimal tax;

    @TableField("jxid")
    private String jxid;

    @TableField("startendtime")
    private String startendtime;

    @TableField("yyfs")
    private String yyfs;

    @TableField("promotionsituation")
    private String promotionsituation;

    @TableField("accountbank")
    private String accountbank;

    /**
     * 合同ID
     */
    @TableField("pactid")
    private String pactid;

    /**
     * 项目分工
     */
    @TableField("divisionwork")
    private String divisionwork;

    /**
     * 总经费分摊
     */
    @TableField("totalexpenditure")
    private BigDecimal totalexpenditure;

    /**
     * 省科技厅经费
     */
    @TableField("kjtexpenditure")
    private BigDecimal kjtexpenditure;

    /**
     * 银行帐号名
     */
    @TableField("bankname")
    private String bankname;

    /**
     * 银行账户
     */
    @TableField("bankacountname")
    private String bankacountname;

    /**
     * 企业分类：1.行政事业单位；2.企业-2.1国企，2.2民营企业，2.3混合所有制；3.社会团体；4.其他
     */
    @TableField("type")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }
    public String getOrganizationsimplename() {
        return organizationsimplename;
    }

    public void setOrganizationsimplename(String organizationsimplename) {
        this.organizationsimplename = organizationsimplename;
    }
    public String getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(String organizationtype) {
        this.organizationtype = organizationtype;
    }
    public String getLegalcode() {
        return legalcode;
    }

    public void setLegalcode(String legalcode) {
        this.legalcode = legalcode;
    }
    public String getAddresscode() {
        return addresscode;
    }

    public void setAddresscode(String addresscode) {
        this.addresscode = addresscode;
    }
    public String getManagedepartment() {
        return managedepartment;
    }

    public void setManagedepartment(String managedepartment) {
        this.managedepartment = managedepartment;
    }
    public String getCommintucateaddress() {
        return commintucateaddress;
    }

    public void setCommintucateaddress(String commintucateaddress) {
        this.commintucateaddress = commintucateaddress;
    }
    public String getPostcard() {
        return postcard;
    }

    public void setPostcard(String postcard) {
        this.postcard = postcard;
    }
    public String getOrganizaitonemail() {
        return organizaitonemail;
    }

    public void setOrganizaitonemail(String organizaitonemail) {
        this.organizaitonemail = organizaitonemail;
    }
    public String getOrganizationcontact() {
        return organizationcontact;
    }

    public void setOrganizationcontact(String organizationcontact) {
        this.organizationcontact = organizationcontact;
    }
    public String getOrganizationphone() {
        return organizationphone;
    }

    public void setOrganizationphone(String organizationphone) {
        this.organizationphone = organizationphone;
    }
    public String getOrganizationfax() {
        return organizationfax;
    }

    public void setOrganizationfax(String organizationfax) {
        this.organizationfax = organizationfax;
    }
    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }
    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
    public String getProjectbaseid() {
        return projectbaseid;
    }

    public void setProjectbaseid(String projectbaseid) {
        this.projectbaseid = projectbaseid;
    }
    public String getDutyforproject() {
        return dutyforproject;
    }

    public void setDutyforproject(String dutyforproject) {
        this.dutyforproject = dutyforproject;
    }
    public String getIsmainenterprise() {
        return ismainenterprise;
    }

    public void setIsmainenterprise(String ismainenterprise) {
        this.ismainenterprise = ismainenterprise;
    }
    public String getEconomiccategory() {
        return economiccategory;
    }

    public void setEconomiccategory(String economiccategory) {
        this.economiccategory = economiccategory;
    }
    public String getEnterprisescale() {
        return enterprisescale;
    }

    public void setEnterprisescale(String enterprisescale) {
        this.enterprisescale = enterprisescale;
    }
    public String getTechnologyenterprises() {
        return technologyenterprises;
    }

    public void setTechnologyenterprises(String technologyenterprises) {
        this.technologyenterprises = technologyenterprises;
    }
    public String getNumberofstaff() {
        return numberofstaff;
    }

    public void setNumberofstaff(String numberofstaff) {
        this.numberofstaff = numberofstaff;
    }
    public String getTechnicalpersonnel() {
        return technicalpersonnel;
    }

    public void setTechnicalpersonnel(String technicalpersonnel) {
        this.technicalpersonnel = technicalpersonnel;
    }
    public String getTotalassets() {
        return totalassets;
    }

    public void setTotalassets(String totalassets) {
        this.totalassets = totalassets;
    }
    public String getAnnualsales() {
        return annualsales;
    }

    public void setAnnualsales(String annualsales) {
        this.annualsales = annualsales;
    }
    public String getFundingforesearch() {
        return fundingforesearch;
    }

    public void setFundingforesearch(String fundingforesearch) {
        this.fundingforesearch = fundingforesearch;
    }
    public String getNewproductplan() {
        return newproductplan;
    }

    public void setNewproductplan(String newproductplan) {
        this.newproductplan = newproductplan;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEnterprisetype() {
        return enterprisetype;
    }

    public void setEnterprisetype(String enterprisetype) {
        this.enterprisetype = enterprisetype;
    }
    public String getOrganizationhead() {
        return organizationhead;
    }

    public void setOrganizationhead(String organizationhead) {
        this.organizationhead = organizationhead;
    }
    public BigDecimal getSeq() {
        return seq;
    }

    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }
    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }
    public String getBelongsvillage() {
        return belongsvillage;
    }

    public void setBelongsvillage(String belongsvillage) {
        this.belongsvillage = belongsvillage;
    }
    public String getLeadingproductname() {
        return leadingproductname;
    }

    public void setLeadingproductname(String leadingproductname) {
        this.leadingproductname = leadingproductname;
    }
    public BigDecimal getLastyearsales() {
        return lastyearsales;
    }

    public void setLastyearsales(BigDecimal lastyearsales) {
        this.lastyearsales = lastyearsales;
    }
    public BigDecimal getDevelopmentfee() {
        return developmentfee;
    }

    public void setDevelopmentfee(BigDecimal developmentfee) {
        this.developmentfee = developmentfee;
    }
    public Date getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(Date contractstartdate) {
        this.contractstartdate = contractstartdate;
    }
    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getLeadertel() {
        return leadertel;
    }

    public void setLeadertel(String leadertel) {
        this.leadertel = leadertel;
    }
    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative;
    }
    public BigDecimal getAnnualsalesrevenue() {
        return annualsalesrevenue;
    }

    public void setAnnualsalesrevenue(BigDecimal annualsalesrevenue) {
        this.annualsalesrevenue = annualsalesrevenue;
    }
    public String getResearchbase() {
        return researchbase;
    }

    public void setResearchbase(String researchbase) {
        this.researchbase = researchbase;
    }
    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }
    public String getXmsbsid() {
        return xmsbsid;
    }

    public void setXmsbsid(String xmsbsid) {
        this.xmsbsid = xmsbsid;
    }
    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }
    public String getUnitproperty() {
        return unitproperty;
    }

    public void setUnitproperty(String unitproperty) {
        this.unitproperty = unitproperty;
    }
    public String getLegalmobilephone() {
        return legalmobilephone;
    }

    public void setLegalmobilephone(String legalmobilephone) {
        this.legalmobilephone = legalmobilephone;
    }
    public String getContactmobilphone() {
        return contactmobilphone;
    }

    public void setContactmobilphone(String contactmobilphone) {
        this.contactmobilphone = contactmobilphone;
    }
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
    public BigDecimal getSaleincome() {
        return saleincome;
    }

    public void setSaleincome(BigDecimal saleincome) {
        this.saleincome = saleincome;
    }
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    public String getJxid() {
        return jxid;
    }

    public void setJxid(String jxid) {
        this.jxid = jxid;
    }
    public String getStartendtime() {
        return startendtime;
    }

    public void setStartendtime(String startendtime) {
        this.startendtime = startendtime;
    }
    public String getYyfs() {
        return yyfs;
    }

    public void setYyfs(String yyfs) {
        this.yyfs = yyfs;
    }
    public String getPromotionsituation() {
        return promotionsituation;
    }

    public void setPromotionsituation(String promotionsituation) {
        this.promotionsituation = promotionsituation;
    }
    public String getAccountbank() {
        return accountbank;
    }

    public void setAccountbank(String accountbank) {
        this.accountbank = accountbank;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public String getDivisionwork() {
        return divisionwork;
    }

    public void setDivisionwork(String divisionwork) {
        this.divisionwork = divisionwork;
    }
    public BigDecimal getTotalexpenditure() {
        return totalexpenditure;
    }

    public void setTotalexpenditure(BigDecimal totalexpenditure) {
        this.totalexpenditure = totalexpenditure;
    }
    public BigDecimal getKjtexpenditure() {
        return kjtexpenditure;
    }

    public void setKjtexpenditure(BigDecimal kjtexpenditure) {
        this.kjtexpenditure = kjtexpenditure;
    }
    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
    public String getBankacountname() {
        return bankacountname;
    }

    public void setBankacountname(String bankacountname) {
        this.bankacountname = bankacountname;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PactEnterpriseorganization{" +
        "id=" + id +
        ", organizationname=" + organizationname +
        ", organizationsimplename=" + organizationsimplename +
        ", organizationtype=" + organizationtype +
        ", legalcode=" + legalcode +
        ", addresscode=" + addresscode +
        ", managedepartment=" + managedepartment +
        ", commintucateaddress=" + commintucateaddress +
        ", postcard=" + postcard +
        ", organizaitonemail=" + organizaitonemail +
        ", organizationcontact=" + organizationcontact +
        ", organizationphone=" + organizationphone +
        ", organizationfax=" + organizationfax +
        ", banknumber=" + banknumber +
        ", enterpriseid=" + enterpriseid +
        ", projectbaseid=" + projectbaseid +
        ", dutyforproject=" + dutyforproject +
        ", ismainenterprise=" + ismainenterprise +
        ", economiccategory=" + economiccategory +
        ", enterprisescale=" + enterprisescale +
        ", technologyenterprises=" + technologyenterprises +
        ", numberofstaff=" + numberofstaff +
        ", technicalpersonnel=" + technicalpersonnel +
        ", totalassets=" + totalassets +
        ", annualsales=" + annualsales +
        ", fundingforesearch=" + fundingforesearch +
        ", newproductplan=" + newproductplan +
        ", mobile=" + mobile +
        ", enterprisetype=" + enterprisetype +
        ", organizationhead=" + organizationhead +
        ", seq=" + seq +
        ", registerdate=" + registerdate +
        ", belongsvillage=" + belongsvillage +
        ", leadingproductname=" + leadingproductname +
        ", lastyearsales=" + lastyearsales +
        ", developmentfee=" + developmentfee +
        ", contractstartdate=" + contractstartdate +
        ", contractenddate=" + contractenddate +
        ", leader=" + leader +
        ", leadertel=" + leadertel +
        ", legalrepresentative=" + legalrepresentative +
        ", annualsalesrevenue=" + annualsalesrevenue +
        ", researchbase=" + researchbase +
        ", cooperation=" + cooperation +
        ", xmsbsid=" + xmsbsid +
        ", contactphone=" + contactphone +
        ", unitproperty=" + unitproperty +
        ", legalmobilephone=" + legalmobilephone +
        ", contactmobilphone=" + contactmobilphone +
        ", starttime=" + starttime +
        ", overtime=" + overtime +
        ", application=" + application +
        ", saleincome=" + saleincome +
        ", tax=" + tax +
        ", jxid=" + jxid +
        ", startendtime=" + startendtime +
        ", yyfs=" + yyfs +
        ", promotionsituation=" + promotionsituation +
        ", accountbank=" + accountbank +
        ", pactid=" + pactid +
        ", divisionwork=" + divisionwork +
        ", totalexpenditure=" + totalexpenditure +
        ", kjtexpenditure=" + kjtexpenditure +
        ", bankname=" + bankname +
        ", bankacountname=" + bankacountname +
        ", type=" + type +
        "}";
    }
}
