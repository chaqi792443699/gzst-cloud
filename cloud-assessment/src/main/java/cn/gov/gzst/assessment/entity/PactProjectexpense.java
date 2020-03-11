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
@TableName("pact_projectexpense")
public class PactProjectexpense extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 自筹费用
     */
    @TableField("selfsum")
    private BigDecimal selfsum;

    /**
     * 向省厅申请费用
     */
    @TableField("applyprovicegvosum")
    private BigDecimal applyprovicegvosum;

    /**
     * 经费支出（总额）
     */
    @TableField("totalsum")
    private BigDecimal totalsum;

    /**
     * 设备费（总额）
     */
    @TableField("instrumentsum")
    private BigDecimal instrumentsum;

    /**
     * 差旅费（总额）
     */
    @TableField("businesstripsum")
    private BigDecimal businesstripsum;

    /**
     * 专家质询费
     */
    @TableField("adviceforexpertsum")
    private BigDecimal adviceforexpertsum;

    /**
     * 材料费（总额）
     */
    @TableField("materialexpense")
    private BigDecimal materialexpense;

    /**
     * 劳务费
     */
    @TableField("servicefee")
    private BigDecimal servicefee;

    /**
     * 出版/文献/信息传播/知识产权事务费（总额）
     */
    @TableField("adminstrativeservicesum")
    private BigDecimal adminstrativeservicesum;

    /**
     * 测试化验加工费（总额）
     */
    @TableField("proceedingscharges")
    private BigDecimal proceedingscharges;

    /**
     * 会议费 6
     */
    @TableField("coferemce")
    private BigDecimal coferemce;

    /**
     * 合作研究交流费 7
     */
    @TableField("coorperationresearchsum")
    private BigDecimal coorperationresearchsum;

    /**
     * 燃料动力费（总额）
     */
    @TableField("fuelandpower")
    private BigDecimal fuelandpower;

    /**
     * 管理费 11
     */
    @TableField("managesum")
    private BigDecimal managesum;

    /**
     * 市、县（市、区）补助金额
     */
    @TableField("applycitysum")
    private BigDecimal applycitysum;

    /**
     * 已获市、县（市、区）补助金额
     */
    @TableField("getcitysum")
    private BigDecimal getcitysum;

    /**
     * 技术交易实际金额
     */
    @TableField("realamount")
    private BigDecimal realamount;

    /**
     * 项目id
     */
    @TableField("projectbaseid")
    private String projectbaseid;

    /**
     * 省厅拨款时间
     */
    @TableField("getapplyprovicegvosumdate")
    private Date getapplyprovicegvosumdate;

    /**
     * 已获省厅申请费用
     */
    @TableField("getapplyprovicegvosum")
    private BigDecimal getapplyprovicegvosum;

    /**
     * 已获自筹费用
     */
    @TableField("getselfsum")
    private BigDecimal getselfsum;

    /**
     * 自筹时间
     */
    @TableField("getselfsumdate")
    private Date getselfsumdate;

    /**
     * 其他（含培训费）总额
     */
    @TableField("qita")
    private BigDecimal qita;

    /**
     * 激励费 12
     */
    @TableField("incentivefee")
    private BigDecimal incentivefee;

    /**
     * 外方投入资金
     */
    @TableField("foreigninvestment")
    private BigDecimal foreigninvestment;

    /**
     * 单位自有货币资金
     */
    @TableField("unitmoney")
    private BigDecimal unitmoney;

    /**
     * 部门、地方配套
     */
    @TableField("departmentsmatching")
    private BigDecimal departmentsmatching;

    /**
     * 其他资金
     */
    @TableField("othermoney")
    private BigDecimal othermoney;

    /**
     * 企业获研经费
     */
    @TableField("enterpriseresearchspending")
    private BigDecimal enterpriseresearchspending;

    /**
     * 设备费---科技厅专项经费
     */
    @TableField("equipmentone")
    private BigDecimal equipmentone;

    /**
     * 材料费---专项经费
     */
    @TableField("materialone")
    private BigDecimal materialone;

    /**
     * 测试化验加工费---专项经费
     */
    @TableField("processingtestone")
    private BigDecimal processingtestone;

    /**
     * 燃料动力费---专项经费
     */
    @TableField("expenditureone")
    private BigDecimal expenditureone;

    /**
     * 差旅费（指国内差旅费）---专项经费
     */
    @TableField("inlandtravelone")
    private BigDecimal inlandtravelone;

    /**
     * 会议费---专项经费
     */
    @TableField("conferenceone")
    private BigDecimal conferenceone;

    /**
     * 出版/文献/传播/知识产权事务费---专项经费
     */
    @TableField("publishedone")
    private BigDecimal publishedone;

    /**
     * 激励费---专项经费
     */
    @TableField("incentiveone")
    private BigDecimal incentiveone;

    /**
     * 管理费---专项经费
     */
    @TableField("managementone")
    private BigDecimal managementone;

    /**
     * 合作协作研究与交流费---专项经费
     */
    @TableField("collaborativeresearchone")
    private BigDecimal collaborativeresearchone;

    /**
     * 国内人员出国考察费---专项经费
     */
    @TableField("domesticresearchersone")
    private BigDecimal domesticresearchersone;

    /**
     * 海外专家来华交流费---专项经费
     */
    @TableField("overseasexpertsone")
    private BigDecimal overseasexpertsone;

    /**
     * 劳务费---专项经费
     */
    @TableField("laborone")
    private BigDecimal laborone;

    /**
     * 国内人员劳务费---专项经费
     */
    @TableField("domesticlaborone")
    private BigDecimal domesticlaborone;

    /**
     * 海外专家劳务费---专项经费
     */
    @TableField("overseaslaborone")
    private BigDecimal overseaslaborone;

    /**
     * 专家咨询费---专项经费
     */
    @TableField("consultingone")
    private BigDecimal consultingone;

    /**
     * 国内专家咨询费---专项经费
     */
    @TableField("domesticconsultingone")
    private BigDecimal domesticconsultingone;

    /**
     * 海外专家咨询费---专项经费
     */
    @TableField("overseasconsultingone")
    private BigDecimal overseasconsultingone;

    /**
     * 设备费---自筹经费
     */
    @TableField("equipmenttwo")
    private BigDecimal equipmenttwo;

    /**
     * 设备费---外方投入
     */
    @TableField("equipmentthree")
    private BigDecimal equipmentthree;

    /**
     * 设备费---合计
     */
    @TableField("equipmentfour")
    private BigDecimal equipmentfour;

    /**
     * （3）设备改造与租赁费（总额）
     */
    @TableField("instrumentsum3")
    private BigDecimal instrumentsum3;

    /**
     * （2）试制设备费（总额）
     */
    @TableField("instrumentsum2")
    private BigDecimal instrumentsum2;

    /**
     * （1）购置设备费(总额）
     */
    @TableField("instrumentsum1")
    private BigDecimal instrumentsum1;

    /**
     * 项目预算申报书ID
     */
    @TableField("xmsbsid")
    private String xmsbsid;

    /**
     * 购置费备注
     */
    @TableField("instrumentsum1note")
    private String instrumentsum1note;

    /**
     * 改造费备注
     */
    @TableField("instrumentsum2note")
    private String instrumentsum2note;

    /**
     * 租赁费备注
     */
    @TableField("instrumentsum3note")
    private String instrumentsum3note;

    /**
     * 材料费备注
     */
    @TableField("materialexpensenote")
    private String materialexpensenote;

    /**
     * 试验加工费备注
     */
    @TableField("proceedingschargesnote")
    private String proceedingschargesnote;

    /**
     * 燃料动力费备注
     */
    @TableField("fuelandpowernote")
    private String fuelandpowernote;

    /**
     * 差旅费备注
     */
    @TableField("businesstripsumnote")
    private String businesstripsumnote;

    /**
     * 会议费备注
     */
    @TableField("conferemcenote")
    private String conferemcenote;

    /**
     * 合作交流费备注
     */
    @TableField("coorperationresearchsumnote")
    private String coorperationresearchsumnote;

    /**
     * 出版费备注
     */
    @TableField("adminstrativeservicesumnote")
    private String adminstrativeservicesumnote;

    /**
     * 人员劳务费备注
     */
    @TableField("servicefeenote")
    private String servicefeenote;

    /**
     * 专家咨询费备注
     */
    @TableField("adviceforexpertsumnote")
    private String adviceforexpertsumnote;

    /**
     * 设备费（科技经费）
     */
    @TableField("instrumentsumkjt")
    private BigDecimal instrumentsumkjt;

    /**
     * （1）购置设备费(科技经费）
     */
    @TableField("instrumentsum1kjt")
    private BigDecimal instrumentsum1kjt;

    /**
     * （2）试制设备费（科技经费）
     */
    @TableField("instrumentsum2kjt")
    private BigDecimal instrumentsum2kjt;

    /**
     * （3）设备改造与租赁费（科技经费）
     */
    @TableField("instrumentsum3kjt")
    private BigDecimal instrumentsum3kjt;

    /**
     * 材料费（科技经费）
     */
    @TableField("materialexpensekjt")
    private BigDecimal materialexpensekjt;

    /**
     * 测试化验加工费（科技经费）
     */
    @TableField("proceedingschargeskjt")
    private BigDecimal proceedingschargeskjt;

    /**
     * 燃料动力费（科技经费）
     */
    @TableField("fuelandpowerkjt")
    private BigDecimal fuelandpowerkjt;

    /**
     * 差旅费科技厅
     */
    @TableField("businesstripsumkjt")
    private BigDecimal businesstripsumkjt;

    /**
     * 会议费科技厅
     */
    @TableField("coferemcekjt")
    private BigDecimal coferemcekjt;

    /**
     * 合作研究交流费科技厅
     */
    @TableField("coorperationresearchsumkjt")
    private BigDecimal coorperationresearchsumkjt;

    /**
     * 出版/文献/信息传播/知识产权事务费（科技经费）
     */
    @TableField("adminstrativeservicesumkjt")
    private BigDecimal adminstrativeservicesumkjt;

    /**
     * 劳务费（科技经费）
     */
    @TableField("servicefeekjt")
    private BigDecimal servicefeekjt;

    /**
     * 专家咨询费（科技经费）
     */
    @TableField("adviceforexpertsumkjt")
    private BigDecimal adviceforexpertsumkjt;

    /**
     * 管理费科技厅
     */
    @TableField("managesumkjt")
    private BigDecimal managesumkjt;

    /**
     * 其他（含培训费）（科技经费）
     */
    @TableField("qitakjt")
    private BigDecimal qitakjt;

    /**
     * 经费支出（科技经费）
     */
    @TableField("totalsumkjt")
    private BigDecimal totalsumkjt;

    /**
     * 计划投资总额
     */
    @TableField("jhtzze")
    private BigDecimal jhtzze;

    /**
     * 已完成投资
     */
    @TableField("ywctz")
    private BigDecimal ywctz;

    /**
     * 其中：自筹
     */
    @TableField("ywctzzc")
    private BigDecimal ywctzzc;

    /**
     * 计划新增投资
     */
    @TableField("jhxztz")
    private BigDecimal jhxztz;

    /**
     * 省科技计划拨款
     */
    @TableField("jhxtzkjjf")
    private BigDecimal jhxtzkjjf;

    /**
     * 单位自筹
     */
    @TableField("jhxtzzc")
    private BigDecimal jhxtzzc;

    /**
     * 其中：其他拨款
     */
    @TableField("jhxtzqtbk")
    private BigDecimal jhxtzqtbk;

    /**
     * 直接费用（总额）
     */
    @TableField("totalzjsum")
    private BigDecimal totalzjsum;

    /**
     * 直接费用（科技经费）
     */
    @TableField("totalzjsumkjt")
    private BigDecimal totalzjsumkjt;

    /**
     * 间接费用（总额）
     */
    @TableField("totaljjsum")
    private BigDecimal totaljjsum;

    /**
     * 间接费用（科技经费）
     */
    @TableField("totaljjsumkjt")
    private BigDecimal totaljjsumkjt;

    /**
     * 其中：绩效支出（总额）
     */
    @TableField("jxzc")
    private BigDecimal jxzc;

    /**
     * 其中：绩效支出（科技经费）
     */
    @TableField("jxzckjt")
    private BigDecimal jxzckjt;

    /**
     * 差旅费/会议费/国际合作与交流费（总额）
     */
    @TableField("clhygjhz")
    private BigDecimal clhygjhz;

    /**
     * 差旅费/会议费/国际合作与交流费（科技经费）
     */
    @TableField("clhygjhzkjt")
    private BigDecimal clhygjhzkjt;

    /**
     * 合同ID
     */
    @TableField("pactid")
    private String pactid;

    /**
     * 国家其它拨款
     */
    @TableField("gjqtbk")
    private BigDecimal gjqtbk;

    /**
     * 部门拨款
     */
    @TableField("bmbk")
    private BigDecimal bmbk;

    /**
     * 地方拨款
     */
    @TableField("dfbk")
    private BigDecimal dfbk;

    /**
     * 其它来源
     */
    @TableField("qily")
    private BigDecimal qily;

    /**
     * 经费支出(自筹)
     */
    @TableField("totalsumzc")
    private BigDecimal totalsumzc;

    /**
     * 设备费(自筹经费）
     */
    @TableField("instrumentsumzc")
    private BigDecimal instrumentsumzc;

    /**
     * （1）购置设备费(自筹经费）
     */
    @TableField("instrumentsum1zc")
    private BigDecimal instrumentsum1zc;

    /**
     * （2）试制设备费（自筹经费）
     */
    @TableField("instrumentsum2zc")
    private BigDecimal instrumentsum2zc;

    /**
     * （3）设备改造与租赁费（自筹经费）
     */
    @TableField("instrumentsum3zc")
    private BigDecimal instrumentsum3zc;

    /**
     * 专家咨询费（自筹经费）
     */
    @TableField("adviceforexpertsumzc")
    private BigDecimal adviceforexpertsumzc;

    /**
     * 材料费（自筹经费）
     */
    @TableField("materialexpensezc")
    private BigDecimal materialexpensezc;

    /**
     * 劳务费（自筹经费）
     */
    @TableField("servicefeezc")
    private BigDecimal servicefeezc;

    /**
     * 出版/文献/信息传播/知识产权事务费（自筹经费）
     */
    @TableField("adminstrativeservicesumzc")
    private BigDecimal adminstrativeservicesumzc;

    /**
     * 测试化验加工费（自筹经费）
     */
    @TableField("proceedingschargeszc")
    private BigDecimal proceedingschargeszc;

    /**
     * 燃料动力费（自筹经费）
     */
    @TableField("fuelandpowerzc")
    private BigDecimal fuelandpowerzc;

    /**
     * 直接费用（自筹）
     */
    @TableField("totalzjsumzc")
    private BigDecimal totalzjsumzc;

    /**
     * 间接费用（自筹经费）
     */
    @TableField("totaljjsumzc")
    private BigDecimal totaljjsumzc;

    /**
     * 其中：绩效支出（自筹经费）
     */
    @TableField("jxzczc")
    private BigDecimal jxzczc;

    /**
     * 差旅费/会议费/国际合作与交流费（自筹经费）
     */
    @TableField("clhygjhzzc")
    private BigDecimal clhygjhzzc;

    /**
     * 其他（含培训费）（自筹经费）
     */
    @TableField("qitazc")
    private BigDecimal qitazc;

    /**
     * 学术交流费用
     */
    @TableField("xsjlfy")
    private BigDecimal xsjlfy;

    /**
     * 仪器购置等改善科研条件相关费用
     */
    @TableField("syyqclzlfxfy")
    private BigDecimal syyqclzlfxfy;

    /**
     * 团队人员培养、人才引进等费用
     */
    @TableField("tdrypxfy")
    private BigDecimal tdrypxfy;

    /**
     * 入选对象申报院士、国家相关人才计划等所需费用
     */
    @TableField("yslxfy")
    private BigDecimal yslxfy;

    /**
     * 专家咨询费、选聘学术顾问所需经费
     */
    @TableField("lwzjzxfy")
    private BigDecimal lwzjzxfy;

    /**
     * 丙方匹配经费
     */
    @TableField("bfppjf")
    private BigDecimal bfppjf;

    /**
     * 科技厅资助经费(第一年)
     */
    @TableField("kjtbk1")
    private BigDecimal kjtbk1;

    /**
     * 科技厅资助经费(第二年)
     */
    @TableField("kjtbk2")
    private BigDecimal kjtbk2;

    /**
     * 其中选聘学术顾问所需经费
     */
    @TableField("xpgwjf")
    private BigDecimal xpgwjf;

    /**
     * 科技厅资助经费(第三年)
     */
    @TableField("kjtbk3")
    private BigDecimal kjtbk3;

    /**
     * 开展科研所需的相关费用
     */
    @TableField("kzkxyj")
    private BigDecimal kzkxyj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public BigDecimal getSelfsum() {
        return selfsum;
    }

    public void setSelfsum(BigDecimal selfsum) {
        this.selfsum = selfsum;
    }
    public BigDecimal getApplyprovicegvosum() {
        return applyprovicegvosum;
    }

    public void setApplyprovicegvosum(BigDecimal applyprovicegvosum) {
        this.applyprovicegvosum = applyprovicegvosum;
    }
    public BigDecimal getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(BigDecimal totalsum) {
        this.totalsum = totalsum;
    }
    public BigDecimal getInstrumentsum() {
        return instrumentsum;
    }

    public void setInstrumentsum(BigDecimal instrumentsum) {
        this.instrumentsum = instrumentsum;
    }
    public BigDecimal getBusinesstripsum() {
        return businesstripsum;
    }

    public void setBusinesstripsum(BigDecimal businesstripsum) {
        this.businesstripsum = businesstripsum;
    }
    public BigDecimal getAdviceforexpertsum() {
        return adviceforexpertsum;
    }

    public void setAdviceforexpertsum(BigDecimal adviceforexpertsum) {
        this.adviceforexpertsum = adviceforexpertsum;
    }
    public BigDecimal getMaterialexpense() {
        return materialexpense;
    }

    public void setMaterialexpense(BigDecimal materialexpense) {
        this.materialexpense = materialexpense;
    }
    public BigDecimal getServicefee() {
        return servicefee;
    }

    public void setServicefee(BigDecimal servicefee) {
        this.servicefee = servicefee;
    }
    public BigDecimal getAdminstrativeservicesum() {
        return adminstrativeservicesum;
    }

    public void setAdminstrativeservicesum(BigDecimal adminstrativeservicesum) {
        this.adminstrativeservicesum = adminstrativeservicesum;
    }
    public BigDecimal getProceedingscharges() {
        return proceedingscharges;
    }

    public void setProceedingscharges(BigDecimal proceedingscharges) {
        this.proceedingscharges = proceedingscharges;
    }
    public BigDecimal getCoferemce() {
        return coferemce;
    }

    public void setCoferemce(BigDecimal coferemce) {
        this.coferemce = coferemce;
    }
    public BigDecimal getCoorperationresearchsum() {
        return coorperationresearchsum;
    }

    public void setCoorperationresearchsum(BigDecimal coorperationresearchsum) {
        this.coorperationresearchsum = coorperationresearchsum;
    }
    public BigDecimal getFuelandpower() {
        return fuelandpower;
    }

    public void setFuelandpower(BigDecimal fuelandpower) {
        this.fuelandpower = fuelandpower;
    }
    public BigDecimal getManagesum() {
        return managesum;
    }

    public void setManagesum(BigDecimal managesum) {
        this.managesum = managesum;
    }
    public BigDecimal getApplycitysum() {
        return applycitysum;
    }

    public void setApplycitysum(BigDecimal applycitysum) {
        this.applycitysum = applycitysum;
    }
    public BigDecimal getGetcitysum() {
        return getcitysum;
    }

    public void setGetcitysum(BigDecimal getcitysum) {
        this.getcitysum = getcitysum;
    }
    public BigDecimal getRealamount() {
        return realamount;
    }

    public void setRealamount(BigDecimal realamount) {
        this.realamount = realamount;
    }
    public String getProjectbaseid() {
        return projectbaseid;
    }

    public void setProjectbaseid(String projectbaseid) {
        this.projectbaseid = projectbaseid;
    }
    public Date getGetapplyprovicegvosumdate() {
        return getapplyprovicegvosumdate;
    }

    public void setGetapplyprovicegvosumdate(Date getapplyprovicegvosumdate) {
        this.getapplyprovicegvosumdate = getapplyprovicegvosumdate;
    }
    public BigDecimal getGetapplyprovicegvosum() {
        return getapplyprovicegvosum;
    }

    public void setGetapplyprovicegvosum(BigDecimal getapplyprovicegvosum) {
        this.getapplyprovicegvosum = getapplyprovicegvosum;
    }
    public BigDecimal getGetselfsum() {
        return getselfsum;
    }

    public void setGetselfsum(BigDecimal getselfsum) {
        this.getselfsum = getselfsum;
    }
    public Date getGetselfsumdate() {
        return getselfsumdate;
    }

    public void setGetselfsumdate(Date getselfsumdate) {
        this.getselfsumdate = getselfsumdate;
    }
    public BigDecimal getQita() {
        return qita;
    }

    public void setQita(BigDecimal qita) {
        this.qita = qita;
    }
    public BigDecimal getIncentivefee() {
        return incentivefee;
    }

    public void setIncentivefee(BigDecimal incentivefee) {
        this.incentivefee = incentivefee;
    }
    public BigDecimal getForeigninvestment() {
        return foreigninvestment;
    }

    public void setForeigninvestment(BigDecimal foreigninvestment) {
        this.foreigninvestment = foreigninvestment;
    }
    public BigDecimal getUnitmoney() {
        return unitmoney;
    }

    public void setUnitmoney(BigDecimal unitmoney) {
        this.unitmoney = unitmoney;
    }
    public BigDecimal getDepartmentsmatching() {
        return departmentsmatching;
    }

    public void setDepartmentsmatching(BigDecimal departmentsmatching) {
        this.departmentsmatching = departmentsmatching;
    }
    public BigDecimal getOthermoney() {
        return othermoney;
    }

    public void setOthermoney(BigDecimal othermoney) {
        this.othermoney = othermoney;
    }
    public BigDecimal getEnterpriseresearchspending() {
        return enterpriseresearchspending;
    }

    public void setEnterpriseresearchspending(BigDecimal enterpriseresearchspending) {
        this.enterpriseresearchspending = enterpriseresearchspending;
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
    public BigDecimal getConferenceone() {
        return conferenceone;
    }

    public void setConferenceone(BigDecimal conferenceone) {
        this.conferenceone = conferenceone;
    }
    public BigDecimal getPublishedone() {
        return publishedone;
    }

    public void setPublishedone(BigDecimal publishedone) {
        this.publishedone = publishedone;
    }
    public BigDecimal getIncentiveone() {
        return incentiveone;
    }

    public void setIncentiveone(BigDecimal incentiveone) {
        this.incentiveone = incentiveone;
    }
    public BigDecimal getManagementone() {
        return managementone;
    }

    public void setManagementone(BigDecimal managementone) {
        this.managementone = managementone;
    }
    public BigDecimal getCollaborativeresearchone() {
        return collaborativeresearchone;
    }

    public void setCollaborativeresearchone(BigDecimal collaborativeresearchone) {
        this.collaborativeresearchone = collaborativeresearchone;
    }
    public BigDecimal getDomesticresearchersone() {
        return domesticresearchersone;
    }

    public void setDomesticresearchersone(BigDecimal domesticresearchersone) {
        this.domesticresearchersone = domesticresearchersone;
    }
    public BigDecimal getOverseasexpertsone() {
        return overseasexpertsone;
    }

    public void setOverseasexpertsone(BigDecimal overseasexpertsone) {
        this.overseasexpertsone = overseasexpertsone;
    }
    public BigDecimal getLaborone() {
        return laborone;
    }

    public void setLaborone(BigDecimal laborone) {
        this.laborone = laborone;
    }
    public BigDecimal getDomesticlaborone() {
        return domesticlaborone;
    }

    public void setDomesticlaborone(BigDecimal domesticlaborone) {
        this.domesticlaborone = domesticlaborone;
    }
    public BigDecimal getOverseaslaborone() {
        return overseaslaborone;
    }

    public void setOverseaslaborone(BigDecimal overseaslaborone) {
        this.overseaslaborone = overseaslaborone;
    }
    public BigDecimal getConsultingone() {
        return consultingone;
    }

    public void setConsultingone(BigDecimal consultingone) {
        this.consultingone = consultingone;
    }
    public BigDecimal getDomesticconsultingone() {
        return domesticconsultingone;
    }

    public void setDomesticconsultingone(BigDecimal domesticconsultingone) {
        this.domesticconsultingone = domesticconsultingone;
    }
    public BigDecimal getOverseasconsultingone() {
        return overseasconsultingone;
    }

    public void setOverseasconsultingone(BigDecimal overseasconsultingone) {
        this.overseasconsultingone = overseasconsultingone;
    }
    public BigDecimal getEquipmenttwo() {
        return equipmenttwo;
    }

    public void setEquipmenttwo(BigDecimal equipmenttwo) {
        this.equipmenttwo = equipmenttwo;
    }
    public BigDecimal getEquipmentthree() {
        return equipmentthree;
    }

    public void setEquipmentthree(BigDecimal equipmentthree) {
        this.equipmentthree = equipmentthree;
    }
    public BigDecimal getEquipmentfour() {
        return equipmentfour;
    }

    public void setEquipmentfour(BigDecimal equipmentfour) {
        this.equipmentfour = equipmentfour;
    }
    public BigDecimal getInstrumentsum3() {
        return instrumentsum3;
    }

    public void setInstrumentsum3(BigDecimal instrumentsum3) {
        this.instrumentsum3 = instrumentsum3;
    }
    public BigDecimal getInstrumentsum2() {
        return instrumentsum2;
    }

    public void setInstrumentsum2(BigDecimal instrumentsum2) {
        this.instrumentsum2 = instrumentsum2;
    }
    public BigDecimal getInstrumentsum1() {
        return instrumentsum1;
    }

    public void setInstrumentsum1(BigDecimal instrumentsum1) {
        this.instrumentsum1 = instrumentsum1;
    }
    public String getXmsbsid() {
        return xmsbsid;
    }

    public void setXmsbsid(String xmsbsid) {
        this.xmsbsid = xmsbsid;
    }
    public String getInstrumentsum1note() {
        return instrumentsum1note;
    }

    public void setInstrumentsum1note(String instrumentsum1note) {
        this.instrumentsum1note = instrumentsum1note;
    }
    public String getInstrumentsum2note() {
        return instrumentsum2note;
    }

    public void setInstrumentsum2note(String instrumentsum2note) {
        this.instrumentsum2note = instrumentsum2note;
    }
    public String getInstrumentsum3note() {
        return instrumentsum3note;
    }

    public void setInstrumentsum3note(String instrumentsum3note) {
        this.instrumentsum3note = instrumentsum3note;
    }
    public String getMaterialexpensenote() {
        return materialexpensenote;
    }

    public void setMaterialexpensenote(String materialexpensenote) {
        this.materialexpensenote = materialexpensenote;
    }
    public String getProceedingschargesnote() {
        return proceedingschargesnote;
    }

    public void setProceedingschargesnote(String proceedingschargesnote) {
        this.proceedingschargesnote = proceedingschargesnote;
    }
    public String getFuelandpowernote() {
        return fuelandpowernote;
    }

    public void setFuelandpowernote(String fuelandpowernote) {
        this.fuelandpowernote = fuelandpowernote;
    }
    public String getBusinesstripsumnote() {
        return businesstripsumnote;
    }

    public void setBusinesstripsumnote(String businesstripsumnote) {
        this.businesstripsumnote = businesstripsumnote;
    }
    public String getConferemcenote() {
        return conferemcenote;
    }

    public void setConferemcenote(String conferemcenote) {
        this.conferemcenote = conferemcenote;
    }
    public String getCoorperationresearchsumnote() {
        return coorperationresearchsumnote;
    }

    public void setCoorperationresearchsumnote(String coorperationresearchsumnote) {
        this.coorperationresearchsumnote = coorperationresearchsumnote;
    }
    public String getAdminstrativeservicesumnote() {
        return adminstrativeservicesumnote;
    }

    public void setAdminstrativeservicesumnote(String adminstrativeservicesumnote) {
        this.adminstrativeservicesumnote = adminstrativeservicesumnote;
    }
    public String getServicefeenote() {
        return servicefeenote;
    }

    public void setServicefeenote(String servicefeenote) {
        this.servicefeenote = servicefeenote;
    }
    public String getAdviceforexpertsumnote() {
        return adviceforexpertsumnote;
    }

    public void setAdviceforexpertsumnote(String adviceforexpertsumnote) {
        this.adviceforexpertsumnote = adviceforexpertsumnote;
    }
    public BigDecimal getInstrumentsumkjt() {
        return instrumentsumkjt;
    }

    public void setInstrumentsumkjt(BigDecimal instrumentsumkjt) {
        this.instrumentsumkjt = instrumentsumkjt;
    }
    public BigDecimal getInstrumentsum1kjt() {
        return instrumentsum1kjt;
    }

    public void setInstrumentsum1kjt(BigDecimal instrumentsum1kjt) {
        this.instrumentsum1kjt = instrumentsum1kjt;
    }
    public BigDecimal getInstrumentsum2kjt() {
        return instrumentsum2kjt;
    }

    public void setInstrumentsum2kjt(BigDecimal instrumentsum2kjt) {
        this.instrumentsum2kjt = instrumentsum2kjt;
    }
    public BigDecimal getInstrumentsum3kjt() {
        return instrumentsum3kjt;
    }

    public void setInstrumentsum3kjt(BigDecimal instrumentsum3kjt) {
        this.instrumentsum3kjt = instrumentsum3kjt;
    }
    public BigDecimal getMaterialexpensekjt() {
        return materialexpensekjt;
    }

    public void setMaterialexpensekjt(BigDecimal materialexpensekjt) {
        this.materialexpensekjt = materialexpensekjt;
    }
    public BigDecimal getProceedingschargeskjt() {
        return proceedingschargeskjt;
    }

    public void setProceedingschargeskjt(BigDecimal proceedingschargeskjt) {
        this.proceedingschargeskjt = proceedingschargeskjt;
    }
    public BigDecimal getFuelandpowerkjt() {
        return fuelandpowerkjt;
    }

    public void setFuelandpowerkjt(BigDecimal fuelandpowerkjt) {
        this.fuelandpowerkjt = fuelandpowerkjt;
    }
    public BigDecimal getBusinesstripsumkjt() {
        return businesstripsumkjt;
    }

    public void setBusinesstripsumkjt(BigDecimal businesstripsumkjt) {
        this.businesstripsumkjt = businesstripsumkjt;
    }
    public BigDecimal getCoferemcekjt() {
        return coferemcekjt;
    }

    public void setCoferemcekjt(BigDecimal coferemcekjt) {
        this.coferemcekjt = coferemcekjt;
    }
    public BigDecimal getCoorperationresearchsumkjt() {
        return coorperationresearchsumkjt;
    }

    public void setCoorperationresearchsumkjt(BigDecimal coorperationresearchsumkjt) {
        this.coorperationresearchsumkjt = coorperationresearchsumkjt;
    }
    public BigDecimal getAdminstrativeservicesumkjt() {
        return adminstrativeservicesumkjt;
    }

    public void setAdminstrativeservicesumkjt(BigDecimal adminstrativeservicesumkjt) {
        this.adminstrativeservicesumkjt = adminstrativeservicesumkjt;
    }
    public BigDecimal getServicefeekjt() {
        return servicefeekjt;
    }

    public void setServicefeekjt(BigDecimal servicefeekjt) {
        this.servicefeekjt = servicefeekjt;
    }
    public BigDecimal getAdviceforexpertsumkjt() {
        return adviceforexpertsumkjt;
    }

    public void setAdviceforexpertsumkjt(BigDecimal adviceforexpertsumkjt) {
        this.adviceforexpertsumkjt = adviceforexpertsumkjt;
    }
    public BigDecimal getManagesumkjt() {
        return managesumkjt;
    }

    public void setManagesumkjt(BigDecimal managesumkjt) {
        this.managesumkjt = managesumkjt;
    }
    public BigDecimal getQitakjt() {
        return qitakjt;
    }

    public void setQitakjt(BigDecimal qitakjt) {
        this.qitakjt = qitakjt;
    }
    public BigDecimal getTotalsumkjt() {
        return totalsumkjt;
    }

    public void setTotalsumkjt(BigDecimal totalsumkjt) {
        this.totalsumkjt = totalsumkjt;
    }
    public BigDecimal getJhtzze() {
        return jhtzze;
    }

    public void setJhtzze(BigDecimal jhtzze) {
        this.jhtzze = jhtzze;
    }
    public BigDecimal getYwctz() {
        return ywctz;
    }

    public void setYwctz(BigDecimal ywctz) {
        this.ywctz = ywctz;
    }
    public BigDecimal getYwctzzc() {
        return ywctzzc;
    }

    public void setYwctzzc(BigDecimal ywctzzc) {
        this.ywctzzc = ywctzzc;
    }
    public BigDecimal getJhxztz() {
        return jhxztz;
    }

    public void setJhxztz(BigDecimal jhxztz) {
        this.jhxztz = jhxztz;
    }
    public BigDecimal getJhxtzkjjf() {
        return jhxtzkjjf;
    }

    public void setJhxtzkjjf(BigDecimal jhxtzkjjf) {
        this.jhxtzkjjf = jhxtzkjjf;
    }
    public BigDecimal getJhxtzzc() {
        return jhxtzzc;
    }

    public void setJhxtzzc(BigDecimal jhxtzzc) {
        this.jhxtzzc = jhxtzzc;
    }
    public BigDecimal getJhxtzqtbk() {
        return jhxtzqtbk;
    }

    public void setJhxtzqtbk(BigDecimal jhxtzqtbk) {
        this.jhxtzqtbk = jhxtzqtbk;
    }
    public BigDecimal getTotalzjsum() {
        return totalzjsum;
    }

    public void setTotalzjsum(BigDecimal totalzjsum) {
        this.totalzjsum = totalzjsum;
    }
    public BigDecimal getTotalzjsumkjt() {
        return totalzjsumkjt;
    }

    public void setTotalzjsumkjt(BigDecimal totalzjsumkjt) {
        this.totalzjsumkjt = totalzjsumkjt;
    }
    public BigDecimal getTotaljjsum() {
        return totaljjsum;
    }

    public void setTotaljjsum(BigDecimal totaljjsum) {
        this.totaljjsum = totaljjsum;
    }
    public BigDecimal getTotaljjsumkjt() {
        return totaljjsumkjt;
    }

    public void setTotaljjsumkjt(BigDecimal totaljjsumkjt) {
        this.totaljjsumkjt = totaljjsumkjt;
    }
    public BigDecimal getJxzc() {
        return jxzc;
    }

    public void setJxzc(BigDecimal jxzc) {
        this.jxzc = jxzc;
    }
    public BigDecimal getJxzckjt() {
        return jxzckjt;
    }

    public void setJxzckjt(BigDecimal jxzckjt) {
        this.jxzckjt = jxzckjt;
    }
    public BigDecimal getClhygjhz() {
        return clhygjhz;
    }

    public void setClhygjhz(BigDecimal clhygjhz) {
        this.clhygjhz = clhygjhz;
    }
    public BigDecimal getClhygjhzkjt() {
        return clhygjhzkjt;
    }

    public void setClhygjhzkjt(BigDecimal clhygjhzkjt) {
        this.clhygjhzkjt = clhygjhzkjt;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public BigDecimal getGjqtbk() {
        return gjqtbk;
    }

    public void setGjqtbk(BigDecimal gjqtbk) {
        this.gjqtbk = gjqtbk;
    }
    public BigDecimal getBmbk() {
        return bmbk;
    }

    public void setBmbk(BigDecimal bmbk) {
        this.bmbk = bmbk;
    }
    public BigDecimal getDfbk() {
        return dfbk;
    }

    public void setDfbk(BigDecimal dfbk) {
        this.dfbk = dfbk;
    }
    public BigDecimal getQily() {
        return qily;
    }

    public void setQily(BigDecimal qily) {
        this.qily = qily;
    }
    public BigDecimal getTotalsumzc() {
        return totalsumzc;
    }

    public void setTotalsumzc(BigDecimal totalsumzc) {
        this.totalsumzc = totalsumzc;
    }
    public BigDecimal getInstrumentsumzc() {
        return instrumentsumzc;
    }

    public void setInstrumentsumzc(BigDecimal instrumentsumzc) {
        this.instrumentsumzc = instrumentsumzc;
    }
    public BigDecimal getInstrumentsum1zc() {
        return instrumentsum1zc;
    }

    public void setInstrumentsum1zc(BigDecimal instrumentsum1zc) {
        this.instrumentsum1zc = instrumentsum1zc;
    }
    public BigDecimal getInstrumentsum2zc() {
        return instrumentsum2zc;
    }

    public void setInstrumentsum2zc(BigDecimal instrumentsum2zc) {
        this.instrumentsum2zc = instrumentsum2zc;
    }
    public BigDecimal getInstrumentsum3zc() {
        return instrumentsum3zc;
    }

    public void setInstrumentsum3zc(BigDecimal instrumentsum3zc) {
        this.instrumentsum3zc = instrumentsum3zc;
    }
    public BigDecimal getAdviceforexpertsumzc() {
        return adviceforexpertsumzc;
    }

    public void setAdviceforexpertsumzc(BigDecimal adviceforexpertsumzc) {
        this.adviceforexpertsumzc = adviceforexpertsumzc;
    }
    public BigDecimal getMaterialexpensezc() {
        return materialexpensezc;
    }

    public void setMaterialexpensezc(BigDecimal materialexpensezc) {
        this.materialexpensezc = materialexpensezc;
    }
    public BigDecimal getServicefeezc() {
        return servicefeezc;
    }

    public void setServicefeezc(BigDecimal servicefeezc) {
        this.servicefeezc = servicefeezc;
    }
    public BigDecimal getAdminstrativeservicesumzc() {
        return adminstrativeservicesumzc;
    }

    public void setAdminstrativeservicesumzc(BigDecimal adminstrativeservicesumzc) {
        this.adminstrativeservicesumzc = adminstrativeservicesumzc;
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
    public BigDecimal getTotalzjsumzc() {
        return totalzjsumzc;
    }

    public void setTotalzjsumzc(BigDecimal totalzjsumzc) {
        this.totalzjsumzc = totalzjsumzc;
    }
    public BigDecimal getTotaljjsumzc() {
        return totaljjsumzc;
    }

    public void setTotaljjsumzc(BigDecimal totaljjsumzc) {
        this.totaljjsumzc = totaljjsumzc;
    }
    public BigDecimal getJxzczc() {
        return jxzczc;
    }

    public void setJxzczc(BigDecimal jxzczc) {
        this.jxzczc = jxzczc;
    }
    public BigDecimal getClhygjhzzc() {
        return clhygjhzzc;
    }

    public void setClhygjhzzc(BigDecimal clhygjhzzc) {
        this.clhygjhzzc = clhygjhzzc;
    }
    public BigDecimal getQitazc() {
        return qitazc;
    }

    public void setQitazc(BigDecimal qitazc) {
        this.qitazc = qitazc;
    }
    public BigDecimal getXsjlfy() {
        return xsjlfy;
    }

    public void setXsjlfy(BigDecimal xsjlfy) {
        this.xsjlfy = xsjlfy;
    }
    public BigDecimal getSyyqclzlfxfy() {
        return syyqclzlfxfy;
    }

    public void setSyyqclzlfxfy(BigDecimal syyqclzlfxfy) {
        this.syyqclzlfxfy = syyqclzlfxfy;
    }
    public BigDecimal getTdrypxfy() {
        return tdrypxfy;
    }

    public void setTdrypxfy(BigDecimal tdrypxfy) {
        this.tdrypxfy = tdrypxfy;
    }
    public BigDecimal getYslxfy() {
        return yslxfy;
    }

    public void setYslxfy(BigDecimal yslxfy) {
        this.yslxfy = yslxfy;
    }
    public BigDecimal getLwzjzxfy() {
        return lwzjzxfy;
    }

    public void setLwzjzxfy(BigDecimal lwzjzxfy) {
        this.lwzjzxfy = lwzjzxfy;
    }
    public BigDecimal getBfppjf() {
        return bfppjf;
    }

    public void setBfppjf(BigDecimal bfppjf) {
        this.bfppjf = bfppjf;
    }
    public BigDecimal getKjtbk1() {
        return kjtbk1;
    }

    public void setKjtbk1(BigDecimal kjtbk1) {
        this.kjtbk1 = kjtbk1;
    }
    public BigDecimal getKjtbk2() {
        return kjtbk2;
    }

    public void setKjtbk2(BigDecimal kjtbk2) {
        this.kjtbk2 = kjtbk2;
    }
    public BigDecimal getXpgwjf() {
        return xpgwjf;
    }

    public void setXpgwjf(BigDecimal xpgwjf) {
        this.xpgwjf = xpgwjf;
    }
    public BigDecimal getKjtbk3() {
        return kjtbk3;
    }

    public void setKjtbk3(BigDecimal kjtbk3) {
        this.kjtbk3 = kjtbk3;
    }
    public BigDecimal getKzkxyj() {
        return kzkxyj;
    }

    public void setKzkxyj(BigDecimal kzkxyj) {
        this.kzkxyj = kzkxyj;
    }

    @Override
    public String toString() {
        return "PactProjectexpense{" +
        "id=" + id +
        ", selfsum=" + selfsum +
        ", applyprovicegvosum=" + applyprovicegvosum +
        ", totalsum=" + totalsum +
        ", instrumentsum=" + instrumentsum +
        ", businesstripsum=" + businesstripsum +
        ", adviceforexpertsum=" + adviceforexpertsum +
        ", materialexpense=" + materialexpense +
        ", servicefee=" + servicefee +
        ", adminstrativeservicesum=" + adminstrativeservicesum +
        ", proceedingscharges=" + proceedingscharges +
        ", coferemce=" + coferemce +
        ", coorperationresearchsum=" + coorperationresearchsum +
        ", fuelandpower=" + fuelandpower +
        ", managesum=" + managesum +
        ", applycitysum=" + applycitysum +
        ", getcitysum=" + getcitysum +
        ", realamount=" + realamount +
        ", projectbaseid=" + projectbaseid +
        ", getapplyprovicegvosumdate=" + getapplyprovicegvosumdate +
        ", getapplyprovicegvosum=" + getapplyprovicegvosum +
        ", getselfsum=" + getselfsum +
        ", getselfsumdate=" + getselfsumdate +
        ", qita=" + qita +
        ", incentivefee=" + incentivefee +
        ", foreigninvestment=" + foreigninvestment +
        ", unitmoney=" + unitmoney +
        ", departmentsmatching=" + departmentsmatching +
        ", othermoney=" + othermoney +
        ", enterpriseresearchspending=" + enterpriseresearchspending +
        ", equipmentone=" + equipmentone +
        ", materialone=" + materialone +
        ", processingtestone=" + processingtestone +
        ", expenditureone=" + expenditureone +
        ", inlandtravelone=" + inlandtravelone +
        ", conferenceone=" + conferenceone +
        ", publishedone=" + publishedone +
        ", incentiveone=" + incentiveone +
        ", managementone=" + managementone +
        ", collaborativeresearchone=" + collaborativeresearchone +
        ", domesticresearchersone=" + domesticresearchersone +
        ", overseasexpertsone=" + overseasexpertsone +
        ", laborone=" + laborone +
        ", domesticlaborone=" + domesticlaborone +
        ", overseaslaborone=" + overseaslaborone +
        ", consultingone=" + consultingone +
        ", domesticconsultingone=" + domesticconsultingone +
        ", overseasconsultingone=" + overseasconsultingone +
        ", equipmenttwo=" + equipmenttwo +
        ", equipmentthree=" + equipmentthree +
        ", equipmentfour=" + equipmentfour +
        ", instrumentsum3=" + instrumentsum3 +
        ", instrumentsum2=" + instrumentsum2 +
        ", instrumentsum1=" + instrumentsum1 +
        ", xmsbsid=" + xmsbsid +
        ", instrumentsum1note=" + instrumentsum1note +
        ", instrumentsum2note=" + instrumentsum2note +
        ", instrumentsum3note=" + instrumentsum3note +
        ", materialexpensenote=" + materialexpensenote +
        ", proceedingschargesnote=" + proceedingschargesnote +
        ", fuelandpowernote=" + fuelandpowernote +
        ", businesstripsumnote=" + businesstripsumnote +
        ", conferemcenote=" + conferemcenote +
        ", coorperationresearchsumnote=" + coorperationresearchsumnote +
        ", adminstrativeservicesumnote=" + adminstrativeservicesumnote +
        ", servicefeenote=" + servicefeenote +
        ", adviceforexpertsumnote=" + adviceforexpertsumnote +
        ", instrumentsumkjt=" + instrumentsumkjt +
        ", instrumentsum1kjt=" + instrumentsum1kjt +
        ", instrumentsum2kjt=" + instrumentsum2kjt +
        ", instrumentsum3kjt=" + instrumentsum3kjt +
        ", materialexpensekjt=" + materialexpensekjt +
        ", proceedingschargeskjt=" + proceedingschargeskjt +
        ", fuelandpowerkjt=" + fuelandpowerkjt +
        ", businesstripsumkjt=" + businesstripsumkjt +
        ", coferemcekjt=" + coferemcekjt +
        ", coorperationresearchsumkjt=" + coorperationresearchsumkjt +
        ", adminstrativeservicesumkjt=" + adminstrativeservicesumkjt +
        ", servicefeekjt=" + servicefeekjt +
        ", adviceforexpertsumkjt=" + adviceforexpertsumkjt +
        ", managesumkjt=" + managesumkjt +
        ", qitakjt=" + qitakjt +
        ", totalsumkjt=" + totalsumkjt +
        ", jhtzze=" + jhtzze +
        ", ywctz=" + ywctz +
        ", ywctzzc=" + ywctzzc +
        ", jhxztz=" + jhxztz +
        ", jhxtzkjjf=" + jhxtzkjjf +
        ", jhxtzzc=" + jhxtzzc +
        ", jhxtzqtbk=" + jhxtzqtbk +
        ", totalzjsum=" + totalzjsum +
        ", totalzjsumkjt=" + totalzjsumkjt +
        ", totaljjsum=" + totaljjsum +
        ", totaljjsumkjt=" + totaljjsumkjt +
        ", jxzc=" + jxzc +
        ", jxzckjt=" + jxzckjt +
        ", clhygjhz=" + clhygjhz +
        ", clhygjhzkjt=" + clhygjhzkjt +
        ", pactid=" + pactid +
        ", gjqtbk=" + gjqtbk +
        ", bmbk=" + bmbk +
        ", dfbk=" + dfbk +
        ", qily=" + qily +
        ", totalsumzc=" + totalsumzc +
        ", instrumentsumzc=" + instrumentsumzc +
        ", instrumentsum1zc=" + instrumentsum1zc +
        ", instrumentsum2zc=" + instrumentsum2zc +
        ", instrumentsum3zc=" + instrumentsum3zc +
        ", adviceforexpertsumzc=" + adviceforexpertsumzc +
        ", materialexpensezc=" + materialexpensezc +
        ", servicefeezc=" + servicefeezc +
        ", adminstrativeservicesumzc=" + adminstrativeservicesumzc +
        ", proceedingschargeszc=" + proceedingschargeszc +
        ", fuelandpowerzc=" + fuelandpowerzc +
        ", totalzjsumzc=" + totalzjsumzc +
        ", totaljjsumzc=" + totaljjsumzc +
        ", jxzczc=" + jxzczc +
        ", clhygjhzzc=" + clhygjhzzc +
        ", qitazc=" + qitazc +
        ", xsjlfy=" + xsjlfy +
        ", syyqclzlfxfy=" + syyqclzlfxfy +
        ", tdrypxfy=" + tdrypxfy +
        ", yslxfy=" + yslxfy +
        ", lwzjzxfy=" + lwzjzxfy +
        ", bfppjf=" + bfppjf +
        ", kjtbk1=" + kjtbk1 +
        ", kjtbk2=" + kjtbk2 +
        ", xpgwjf=" + xpgwjf +
        ", kjtbk3=" + kjtbk3 +
        ", kzkxyj=" + kzkxyj +
        "}";
    }
}
