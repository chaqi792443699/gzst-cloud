package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
@TableName("PGZX_EVALFORM")
public class PgzxEvalform extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 合同ID
     */
    @TableField("PACTID")
    private String pactid;

    /**
     * 累计已落实项目总经费(万元）
     */
    @TableField("IMP_TOTAL")
    private Double impTotal;

    /**
     * 累计已落实项目自筹(万元）
     */
    @TableField("IMPSELF_RAISED")
    private Double impselfRaised;

    /**
     * 累计已落实项目厅局拨款(万元）
     */
    @TableField("IMPOFFI_APPRO")
    private Double impoffiAppro;

    /**
     * 累计已落实区县资金(万元）
     */
    @TableField("IMPCOUNTY_FOUND")
    private Double impcountyFound;

    /**
     * 设备费实际支出
     */
    @TableField("EQUIP_ACTEXPEND")
    private Double equipActexpend;

    /**
     * 材料费实际支出
     */
    @TableField("MATERIAL_ACTEXPEND")
    private Double materialActexpend;

    /**
     * 测试化验加工费实际支出
     */
    @TableField("TPROCESSING_ACTEXPEND")
    private Double tprocessingActexpend;

    /**
     * 燃料动力费实际支出
     */
    @TableField("FUEL_ACTEXPEND")
    private Double fuelActexpend;

    /**
     * 会议费差旅费国际合作与交流费实际支出
     */
    @TableField("MEETING_ACTEXPEND")
    private Double meetingActexpend;

    /**
     * 出版文献信息传播知识产权事务费实际支出
     */
    @TableField("PUBLISH_ACTEXPEND")
    private Double publishActexpend;

    /**
     * 劳务费实际支出
     */
    @TableField("LABOUR_ACTEXPEND")
    private Double labourActexpend;

    /**
     * 专家咨询费实际支出
     */
    @TableField("EXPCONSULT_ACTEXPEND")
    private Double expconsultActexpend;

    /**
     * 其他支出实际支出
     */
    @TableField("OTHER_ACTEXPEND")
    private Double otherActexpend;

    /**
     * 间接费用（含管理费和绩效支出）实际支出
     */
    @TableField("INDIRCOST_ACTEXPEND")
    private Double indircostActexpend;

    /**
     * 合同预算拨款合计
     */
    @TableField("HTYS_TOTAL")
    private Double htysTotal;

    /**
     * 实际支出合计
     */
    @TableField("ACTFOUND_TOTAL")
    private Double actfoundTotal;

    /**
     * 设备费调整说明原因
     */
    @TableField("EQUIP_ADJDESC")
    private String equipAdjdesc;

    /**
     * 材料费调整说明原因
     */
    @TableField("MATERIAL_ADJDESC")
    private String materialAdjdesc;

    /**
     * 测试化验加工费调整说明原因
     */
    @TableField("TPROCESSING_ADJDESC")
    private String tprocessingAdjdesc;

    /**
     * 燃料动力费调整说明原因
     */
    @TableField("FUEL_ADJDESC")
    private String fuelAdjdesc;

    /**
     * 会议费差旅费国际合作与交流费调整说明原因
     */
    @TableField("MEETING_ADJDESC")
    private String meetingAdjdesc;

    /**
     * 出版文献信息传播知识产权事务费调整说明原因
     */
    @TableField("PUBLISH_ADJDESC")
    private String publishAdjdesc;

    /**
     * 劳务费调整说明原因
     */
    @TableField("LABOUR_ADJDESC")
    private String labourAdjdesc;

    /**
     * 专家咨询费调整说明原因
     */
    @TableField("EXPCONSULT_ADJDESC")
    private String expconsultAdjdesc;

    /**
     * 其他支出调整说明原因
     */
    @TableField("OTHER_ADJDESC")
    private String otherAdjdesc;

    /**
     * 间接费用（含管理费和绩效支出）调整说明原因
     */
    @TableField("INDIRECTCOST_ADJDESC")
    private String indirectcostAdjdesc;

    /**
     * 科研经费是否单独建账
     */
    @TableField("IS_ESTABLISHMENT")
    private Double isEstablishment;

    /**
     * 参与人员高级职称(人）
     */
    @TableField("PSENIOR_TITLE")
    private Double pseniorTitle;

    /**
     * 参与人员中级职称(人）
     */
    @TableField("PINTERMEDIATE_TITLE")
    private Double pintermediateTitle;

    /**
     * 参与人员博士(人）
     */
    @TableField("PARTICIPANT_DOCTOR")
    private Double participantDoctor;

    /**
     * 参与人员硕士(人）
     */
    @TableField("PARTICIPANT_MASTER")
    private Double participantMaster;

    /**
     * 参与人员学科带头人(人）
     */
    @TableField("PARTICIPANT_LEADER")
    private Double participantLeader;

    /**
     * 参与人员留学生(人）
     */
    @TableField("PARTICIPANT_OVERSTU")
    private Double participantOverstu;

    /**
     * 项目进度（单选）
     */
    @TableField("PROJECT_PROGRESS")
    private String projectProgress;

    /**
     * 项目拖延、停顿、逾期、申请撤项主要原因（单选）
     */
    @TableField("DELAY_REASON")
    private String delayReason;

    /**
     * 软件著作权申请数
     */
    @TableField("SOFTAPPLY_NUMBER")
    private Double softapplyNumber;

    /**
     * 软件著作权授权数
     */
    @TableField("SOFTAUTHORIZE_NUMBER")
    private Double softauthorizeNumber;

    /**
     * 发表论文数（省级以上）（篇）
     */
    @TableField("PUBLIC_PNUMBER")
    private Double publicPnumber;

    /**
     * 发表论文数（其中国际刊物）（篇）
     */
    @TableField("PUBLIC_INUMBER")
    private Double publicInumber;

    /**
     * 获奖_市级（市）
     */
    @TableField("PRIZE_CITY")
    private Double prizeCity;

    /**
     * 获奖_其他
     */
    @TableField("PRIZE_OTHER")
    private Double prizeOther;

    /**
     * 制定标准-国家标准（个）
     */
    @TableField("ZDGJBZ")
    private Double zdgjbz;

    /**
     * 制定标准-行业标准（个）
     */
    @TableField("INDUSTRY_STANDARD")
    private Double industryStandard;

    /**
     * 制定标准-企业标准（个）
     */
    @TableField("ENTERPRISE_STANDARD")
    private Double enterpriseStandard;

    /**
     * 制定标准-企业标准（个）
     */
    @TableField("FOREIGN_STANDARD")
    private Double foreignStandard;

    /**
     * 出版著作（部）-国际（部）
     */
    @TableField("PUBLICIWORK_NUMBER")
    private Double publiciworkNumber;

    /**
     * 出版著作（部）-国内（部）
     */
    @TableField("PUBLICDWORK_NUMBER")
    private Double publicdworkNumber;

    /**
     * 技术成果转移受让方户数
     */
    @TableField("TRTRANSFER_NUMBER")
    private Double trtransferNumber;

    /**
     * 技术成果转移-转移金额（万元）
     */
    @TableField("TRTRANSFER_FOUND")
    private Double trtransferFound;

    /**
     * 研发服务平台（个）
     */
    @TableField("SERVICE_PLATFORM")
    private Double servicePlatform;

    /**
     * 项目培训（人次）
     */
    @TableField("PROJECT_TRAINING")
    private Double projectTraining;

    /**
     * 新品种推广面积或扩展繁殖（亩、头）
     */
    @TableField("PROMOTION_AREA")
    private Double promotionArea;

    /**
     * 新增设备（台/件）
     */
    @TableField("NEWSB")
    private Double newsb;

    /**
     * 新增生产线
     */
    @TableField("NEWSCX")
    private Double newscx;

    /**
     * 新增中试线
     */
    @TableField("NEWZSX")
    private Double newzsx;

    /**
     * 新增示范培训基地
     */
    @TableField("NEWSFPXJD")
    private Double newsfpxjd;

    /**
     * 新增实验基地
     */
    @TableField("NEWSYJD")
    private Double newsyjd;

    /**
     * 新增缴税总额
     */
    @TableField("NEWJSZE")
    private Double newjsze;

    /**
     * 新增创汇额
     */
    @TableField("NEWCHE")
    private Double newche;

    /**
     * 新增利润总额
     */
    @TableField("NEWLRZE")
    private Double newlrze;

    /**
     * 新增销售收入
     */
    @TableField("NEWXSSR")
    private Double newxssr;

    /**
     * 新增产值
     */
    @TableField("NEWCZ")
    private Double newcz;

    /**
     * 合同进度计划-其他原因说明
     */
    @TableField("OTHER_REASONDESC")
    private String otherReasondesc;

    /**
     * 填写日期
     */
    @TableField("SUBMITDATE")
    private Date submitdate;

    @TableField("STATUS")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public Double getImpTotal() {
        return impTotal;
    }

    public void setImpTotal(Double impTotal) {
        this.impTotal = impTotal;
    }
    public Double getImpselfRaised() {
        return impselfRaised;
    }

    public void setImpselfRaised(Double impselfRaised) {
        this.impselfRaised = impselfRaised;
    }
    public Double getImpoffiAppro() {
        return impoffiAppro;
    }

    public void setImpoffiAppro(Double impoffiAppro) {
        this.impoffiAppro = impoffiAppro;
    }
    public Double getImpcountyFound() {
        return impcountyFound;
    }

    public void setImpcountyFound(Double impcountyFound) {
        this.impcountyFound = impcountyFound;
    }
    public Double getEquipActexpend() {
        return equipActexpend;
    }

    public void setEquipActexpend(Double equipActexpend) {
        this.equipActexpend = equipActexpend;
    }
    public Double getMaterialActexpend() {
        return materialActexpend;
    }

    public void setMaterialActexpend(Double materialActexpend) {
        this.materialActexpend = materialActexpend;
    }
    public Double getTprocessingActexpend() {
        return tprocessingActexpend;
    }

    public void setTprocessingActexpend(Double tprocessingActexpend) {
        this.tprocessingActexpend = tprocessingActexpend;
    }
    public Double getFuelActexpend() {
        return fuelActexpend;
    }

    public void setFuelActexpend(Double fuelActexpend) {
        this.fuelActexpend = fuelActexpend;
    }
    public Double getMeetingActexpend() {
        return meetingActexpend;
    }

    public void setMeetingActexpend(Double meetingActexpend) {
        this.meetingActexpend = meetingActexpend;
    }
    public Double getPublishActexpend() {
        return publishActexpend;
    }

    public void setPublishActexpend(Double publishActexpend) {
        this.publishActexpend = publishActexpend;
    }
    public Double getLabourActexpend() {
        return labourActexpend;
    }

    public void setLabourActexpend(Double labourActexpend) {
        this.labourActexpend = labourActexpend;
    }
    public Double getExpconsultActexpend() {
        return expconsultActexpend;
    }

    public void setExpconsultActexpend(Double expconsultActexpend) {
        this.expconsultActexpend = expconsultActexpend;
    }
    public Double getOtherActexpend() {
        return otherActexpend;
    }

    public void setOtherActexpend(Double otherActexpend) {
        this.otherActexpend = otherActexpend;
    }
    public Double getIndircostActexpend() {
        return indircostActexpend;
    }

    public void setIndircostActexpend(Double indircostActexpend) {
        this.indircostActexpend = indircostActexpend;
    }
    public Double getHtysTotal() {
        return htysTotal;
    }

    public void setHtysTotal(Double htysTotal) {
        this.htysTotal = htysTotal;
    }
    public Double getActfoundTotal() {
        return actfoundTotal;
    }

    public void setActfoundTotal(Double actfoundTotal) {
        this.actfoundTotal = actfoundTotal;
    }
    public String getEquipAdjdesc() {
        return equipAdjdesc;
    }

    public void setEquipAdjdesc(String equipAdjdesc) {
        this.equipAdjdesc = equipAdjdesc;
    }
    public String getMaterialAdjdesc() {
        return materialAdjdesc;
    }

    public void setMaterialAdjdesc(String materialAdjdesc) {
        this.materialAdjdesc = materialAdjdesc;
    }
    public String getTprocessingAdjdesc() {
        return tprocessingAdjdesc;
    }

    public void setTprocessingAdjdesc(String tprocessingAdjdesc) {
        this.tprocessingAdjdesc = tprocessingAdjdesc;
    }
    public String getFuelAdjdesc() {
        return fuelAdjdesc;
    }

    public void setFuelAdjdesc(String fuelAdjdesc) {
        this.fuelAdjdesc = fuelAdjdesc;
    }
    public String getMeetingAdjdesc() {
        return meetingAdjdesc;
    }

    public void setMeetingAdjdesc(String meetingAdjdesc) {
        this.meetingAdjdesc = meetingAdjdesc;
    }
    public String getPublishAdjdesc() {
        return publishAdjdesc;
    }

    public void setPublishAdjdesc(String publishAdjdesc) {
        this.publishAdjdesc = publishAdjdesc;
    }
    public String getLabourAdjdesc() {
        return labourAdjdesc;
    }

    public void setLabourAdjdesc(String labourAdjdesc) {
        this.labourAdjdesc = labourAdjdesc;
    }
    public String getExpconsultAdjdesc() {
        return expconsultAdjdesc;
    }

    public void setExpconsultAdjdesc(String expconsultAdjdesc) {
        this.expconsultAdjdesc = expconsultAdjdesc;
    }
    public String getOtherAdjdesc() {
        return otherAdjdesc;
    }

    public void setOtherAdjdesc(String otherAdjdesc) {
        this.otherAdjdesc = otherAdjdesc;
    }
    public String getIndirectcostAdjdesc() {
        return indirectcostAdjdesc;
    }

    public void setIndirectcostAdjdesc(String indirectcostAdjdesc) {
        this.indirectcostAdjdesc = indirectcostAdjdesc;
    }
    public Double getIsEstablishment() {
        return isEstablishment;
    }

    public void setIsEstablishment(Double isEstablishment) {
        this.isEstablishment = isEstablishment;
    }
    public Double getPseniorTitle() {
        return pseniorTitle;
    }

    public void setPseniorTitle(Double pseniorTitle) {
        this.pseniorTitle = pseniorTitle;
    }
    public Double getPintermediateTitle() {
        return pintermediateTitle;
    }

    public void setPintermediateTitle(Double pintermediateTitle) {
        this.pintermediateTitle = pintermediateTitle;
    }
    public Double getParticipantDoctor() {
        return participantDoctor;
    }

    public void setParticipantDoctor(Double participantDoctor) {
        this.participantDoctor = participantDoctor;
    }
    public Double getParticipantMaster() {
        return participantMaster;
    }

    public void setParticipantMaster(Double participantMaster) {
        this.participantMaster = participantMaster;
    }
    public Double getParticipantLeader() {
        return participantLeader;
    }

    public void setParticipantLeader(Double participantLeader) {
        this.participantLeader = participantLeader;
    }
    public Double getParticipantOverstu() {
        return participantOverstu;
    }

    public void setParticipantOverstu(Double participantOverstu) {
        this.participantOverstu = participantOverstu;
    }
    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }
    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }
    public Double getSoftapplyNumber() {
        return softapplyNumber;
    }

    public void setSoftapplyNumber(Double softapplyNumber) {
        this.softapplyNumber = softapplyNumber;
    }
    public Double getSoftauthorizeNumber() {
        return softauthorizeNumber;
    }

    public void setSoftauthorizeNumber(Double softauthorizeNumber) {
        this.softauthorizeNumber = softauthorizeNumber;
    }
    public Double getPublicPnumber() {
        return publicPnumber;
    }

    public void setPublicPnumber(Double publicPnumber) {
        this.publicPnumber = publicPnumber;
    }
    public Double getPublicInumber() {
        return publicInumber;
    }

    public void setPublicInumber(Double publicInumber) {
        this.publicInumber = publicInumber;
    }
    public Double getPrizeCity() {
        return prizeCity;
    }

    public void setPrizeCity(Double prizeCity) {
        this.prizeCity = prizeCity;
    }
    public Double getPrizeOther() {
        return prizeOther;
    }

    public void setPrizeOther(Double prizeOther) {
        this.prizeOther = prizeOther;
    }
    public Double getZdgjbz() {
        return zdgjbz;
    }

    public void setZdgjbz(Double zdgjbz) {
        this.zdgjbz = zdgjbz;
    }
    public Double getIndustryStandard() {
        return industryStandard;
    }

    public void setIndustryStandard(Double industryStandard) {
        this.industryStandard = industryStandard;
    }
    public Double getEnterpriseStandard() {
        return enterpriseStandard;
    }

    public void setEnterpriseStandard(Double enterpriseStandard) {
        this.enterpriseStandard = enterpriseStandard;
    }
    public Double getForeignStandard() {
        return foreignStandard;
    }

    public void setForeignStandard(Double foreignStandard) {
        this.foreignStandard = foreignStandard;
    }
    public Double getPubliciworkNumber() {
        return publiciworkNumber;
    }

    public void setPubliciworkNumber(Double publiciworkNumber) {
        this.publiciworkNumber = publiciworkNumber;
    }
    public Double getPublicdworkNumber() {
        return publicdworkNumber;
    }

    public void setPublicdworkNumber(Double publicdworkNumber) {
        this.publicdworkNumber = publicdworkNumber;
    }
    public Double getTrtransferNumber() {
        return trtransferNumber;
    }

    public void setTrtransferNumber(Double trtransferNumber) {
        this.trtransferNumber = trtransferNumber;
    }
    public Double getTrtransferFound() {
        return trtransferFound;
    }

    public void setTrtransferFound(Double trtransferFound) {
        this.trtransferFound = trtransferFound;
    }
    public Double getServicePlatform() {
        return servicePlatform;
    }

    public void setServicePlatform(Double servicePlatform) {
        this.servicePlatform = servicePlatform;
    }
    public Double getProjectTraining() {
        return projectTraining;
    }

    public void setProjectTraining(Double projectTraining) {
        this.projectTraining = projectTraining;
    }
    public Double getPromotionArea() {
        return promotionArea;
    }

    public void setPromotionArea(Double promotionArea) {
        this.promotionArea = promotionArea;
    }
    public Double getNewsb() {
        return newsb;
    }

    public void setNewsb(Double newsb) {
        this.newsb = newsb;
    }
    public Double getNewscx() {
        return newscx;
    }

    public void setNewscx(Double newscx) {
        this.newscx = newscx;
    }
    public Double getNewzsx() {
        return newzsx;
    }

    public void setNewzsx(Double newzsx) {
        this.newzsx = newzsx;
    }
    public Double getNewsfpxjd() {
        return newsfpxjd;
    }

    public void setNewsfpxjd(Double newsfpxjd) {
        this.newsfpxjd = newsfpxjd;
    }
    public Double getNewsyjd() {
        return newsyjd;
    }

    public void setNewsyjd(Double newsyjd) {
        this.newsyjd = newsyjd;
    }
    public Double getNewjsze() {
        return newjsze;
    }

    public void setNewjsze(Double newjsze) {
        this.newjsze = newjsze;
    }
    public Double getNewche() {
        return newche;
    }

    public void setNewche(Double newche) {
        this.newche = newche;
    }
    public Double getNewlrze() {
        return newlrze;
    }

    public void setNewlrze(Double newlrze) {
        this.newlrze = newlrze;
    }
    public Double getNewxssr() {
        return newxssr;
    }

    public void setNewxssr(Double newxssr) {
        this.newxssr = newxssr;
    }
    public Double getNewcz() {
        return newcz;
    }

    public void setNewcz(Double newcz) {
        this.newcz = newcz;
    }
    public String getOtherReasondesc() {
        return otherReasondesc;
    }

    public void setOtherReasondesc(String otherReasondesc) {
        this.otherReasondesc = otherReasondesc;
    }
    public Date getSubmitdate() {
        return submitdate;
    }

    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PgzxEvalform{" +
        "id=" + id +
        ", pactid=" + pactid +
        ", impTotal=" + impTotal +
        ", impselfRaised=" + impselfRaised +
        ", impoffiAppro=" + impoffiAppro +
        ", impcountyFound=" + impcountyFound +
        ", equipActexpend=" + equipActexpend +
        ", materialActexpend=" + materialActexpend +
        ", tprocessingActexpend=" + tprocessingActexpend +
        ", fuelActexpend=" + fuelActexpend +
        ", meetingActexpend=" + meetingActexpend +
        ", publishActexpend=" + publishActexpend +
        ", labourActexpend=" + labourActexpend +
        ", expconsultActexpend=" + expconsultActexpend +
        ", otherActexpend=" + otherActexpend +
        ", indircostActexpend=" + indircostActexpend +
        ", htysTotal=" + htysTotal +
        ", actfoundTotal=" + actfoundTotal +
        ", equipAdjdesc=" + equipAdjdesc +
        ", materialAdjdesc=" + materialAdjdesc +
        ", tprocessingAdjdesc=" + tprocessingAdjdesc +
        ", fuelAdjdesc=" + fuelAdjdesc +
        ", meetingAdjdesc=" + meetingAdjdesc +
        ", publishAdjdesc=" + publishAdjdesc +
        ", labourAdjdesc=" + labourAdjdesc +
        ", expconsultAdjdesc=" + expconsultAdjdesc +
        ", otherAdjdesc=" + otherAdjdesc +
        ", indirectcostAdjdesc=" + indirectcostAdjdesc +
        ", isEstablishment=" + isEstablishment +
        ", pseniorTitle=" + pseniorTitle +
        ", pintermediateTitle=" + pintermediateTitle +
        ", participantDoctor=" + participantDoctor +
        ", participantMaster=" + participantMaster +
        ", participantLeader=" + participantLeader +
        ", participantOverstu=" + participantOverstu +
        ", projectProgress=" + projectProgress +
        ", delayReason=" + delayReason +
        ", softapplyNumber=" + softapplyNumber +
        ", softauthorizeNumber=" + softauthorizeNumber +
        ", publicPnumber=" + publicPnumber +
        ", publicInumber=" + publicInumber +
        ", prizeCity=" + prizeCity +
        ", prizeOther=" + prizeOther +
        ", zdgjbz=" + zdgjbz +
        ", industryStandard=" + industryStandard +
        ", enterpriseStandard=" + enterpriseStandard +
        ", foreignStandard=" + foreignStandard +
        ", publiciworkNumber=" + publiciworkNumber +
        ", publicdworkNumber=" + publicdworkNumber +
        ", trtransferNumber=" + trtransferNumber +
        ", trtransferFound=" + trtransferFound +
        ", servicePlatform=" + servicePlatform +
        ", projectTraining=" + projectTraining +
        ", promotionArea=" + promotionArea +
        ", newsb=" + newsb +
        ", newscx=" + newscx +
        ", newzsx=" + newzsx +
        ", newsfpxjd=" + newsfpxjd +
        ", newsyjd=" + newsyjd +
        ", newjsze=" + newjsze +
        ", newche=" + newche +
        ", newlrze=" + newlrze +
        ", newxssr=" + newxssr +
        ", newcz=" + newcz +
        ", otherReasondesc=" + otherReasondesc +
        ", submitdate=" + submitdate +
        ", status=" + status +
        "}";
    }
}
