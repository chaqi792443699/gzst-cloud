package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author Mrlong
 * @since 2019-04-12
 */
@TableName("jxpg_evaluation")
public class Evaluation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 主键ID
     */
    @TableId(value = "eval_id")
    private String evalId;



    /**
     * 合同ID
     */
    @ApiModelProperty(value="合同ID",name="pactid")
    @TableField("pactid")
    private String pactid;

    /**
     * 累计已落实项目总经费(万元）
     */
    @ApiModelProperty(value="累计已落实项目总经费(万元）",name="impTotal")
    @TableField("imp_total")
    private Double impTotal;

    /**
     * 累计已落实项目自筹(万元）
     */
    @ApiModelProperty(value="累计已落实项目自筹(万元）",name="impselfRaised")
    @TableField("impself_raised")
    private Double impselfRaised;

    /**
     * 累计已落实项目厅局拨款(万元）
     */
    @ApiModelProperty(value="累计已落实项目厅局拨款(万元）",name="impoffiAppro")
    @TableField("impoffi_appro")
    private Double impoffiAppro;

    /**
     * 累计已落实区县资金(万元）
     */
    @ApiModelProperty(value="累计已落实区县资金(万元）",name="impcountyFound")
    @TableField("impcounty_found")
    private Double impcountyFound;

    /**
     * 设备费实际支出
     */
    @ApiModelProperty(value="设备费实际支出",name="equipActexpend")
    @TableField("equip_actexpend")
    private Double equipActexpend;

    /**
     * 材料费实际支出
     */
    @ApiModelProperty(value="材料费实际支出",name="materialActexpend")
    @TableField("material_actexpend")
    private Double materialActexpend;

    /**
     * 测试化验加工费实际支出
     */
    @ApiModelProperty(value="测试化验加工费实际支出",name="tprocessingActexpend")
    @TableField("tprocessing_actexpend")
    private Double tprocessingActexpend;

    /**
     * 燃料动力费实际支出
     */
    @ApiModelProperty(value="燃料动力费实际支出",name="fuelActexpend")
    @TableField("fuel_actexpend")
    private Double fuelActexpend;

    /**
     * 会议费差旅费国际合作与交流费实际支出
     */
    @ApiModelProperty(value="会议费差旅费国际合作与交流费实际支出",name="meetingActexpend")
    @TableField("meeting_actexpend")
    private Double meetingActexpend;

    /**
     * 出版文献信息传播知识产权事务费实际支出
     */
    @ApiModelProperty(value="出版文献信息传播知识产权事务费实际支出",name="publishActexpend")
    @TableField("publish_actexpend")
    private Double publishActexpend;

    /**
     * 劳务费实际支出
     */
    @ApiModelProperty(value="劳务费实际支出",name="labourActexpend")
    @TableField("labour_actexpend")
    private Double labourActexpend;

    /**
     * 专家咨询费实际支出
     */
    @ApiModelProperty(value="专家咨询费实际支出",name="expconsultActexpend")
    @TableField("expconsult_actexpend")
    private Double expconsultActexpend;

    /**
     * 其他支出实际支出
     */
    @ApiModelProperty(value="其他支出实际支出",name="otherActexpend")
    @TableField("other_actexpend")
    private Double otherActexpend;

    /**
     * 间接费用（含管理费和绩效支出）实际支出
     */
    @ApiModelProperty(value="间接费用（含管理费和绩效支出）实际支出",name="indircostActexpend")
    @TableField("indircost_actexpend")
    private Double indircostActexpend;

    /**
     * 合同预算拨款合计
     */
    @ApiModelProperty(value="合同预算拨款合计",name="htysTotal")
    @TableField("htys_total")
    private Double htysTotal;

    /**
     * 实际支出合计
     */
    @ApiModelProperty(value="实际支出合计",name="actfoundTotal")
    @TableField("actfound_total")
    private Double actfoundTotal;

    /**
     * 设备费调整说明原因
     */
    @ApiModelProperty(value="设备费调整说明原因",name="equipAdjdesc")
    @TableField("equip_adjdesc")
    private String equipAdjdesc;

    /**
     * 材料费调整说明原因
     */
    @ApiModelProperty(value="材料费调整说明原因",name="materialAdjdesc")
    @TableField("material_adjdesc")
    private String materialAdjdesc;

    /**
     * 测试化验加工费调整说明原因
     */
    @ApiModelProperty(value="测试化验加工费调整说明原因",name="tprocessingAdjdesc")
    @TableField("tprocessing_adjdesc")
    private String tprocessingAdjdesc;

    /**
     * 燃料动力费调整说明原因
     */
    @ApiModelProperty(value="燃料动力费调整说明原因",name="fuelAdjdesc")
    @TableField("fuel_adjdesc")
    private String fuelAdjdesc;

    /**
     * 会议费差旅费国际合作与交流费调整说明原因
     */
    @ApiModelProperty(value="会议费差旅费国际合作与交流费调整说明原因",name="meetingAdjdesc")
    @TableField("meeting_adjdesc")
    private String meetingAdjdesc;

    /**
     * 出版文献信息传播知识产权事务费调整说明原因
     */
    @ApiModelProperty(value="出版文献信息传播知识产权事务费调整说明原因",name="publishAdjdesc")
    @TableField("publish_adjdesc")
    private String publishAdjdesc;

    /**
     * 劳务费调整说明原因
     */
    @ApiModelProperty(value="劳务费调整说明原因",name="labourAdjdesc")
    @TableField("labour_adjdesc")
    private String labourAdjdesc;

    /**
     * 专家咨询费调整说明原因
     */
    @ApiModelProperty(value="专家咨询费调整说明原因",name="expconsultAdjdesc")
    @TableField("expconsult_adjdesc")
    private String expconsultAdjdesc;

    /**
     * 其他支出调整说明原因
     */
    @ApiModelProperty(value="其他支出调整说明原因",name="otherAdjdesc")
    @TableField("other_adjdesc")
    private String otherAdjdesc;

    /**
     * 间接费用（含管理费和绩效支出）调整说明原因
     */
    @ApiModelProperty(value="间接费用（含管理费和绩效支出）调整说明原因",name="indirectcostAdjdesc")
    @TableField("indirectcost_adjdesc")
    private String indirectcostAdjdesc;

    /**
     * 科研经费是否单独建账
     */
    @ApiModelProperty(value="科研经费是否单独建账",name="isEstablishment")
    @TableField("is_establishment")
    private Integer isEstablishment;

    /**
     * 参与人员高级职称(人）
     */
    @ApiModelProperty(value="参与人员高级职称(人）",name="pseniorTitle")
    @TableField("psenior_title")
    private Integer pseniorTitle;

    /**
     * 参与人员中级职称(人）
     */
    @ApiModelProperty(value="参与人员中级职称(人）",name="pintermediateTitle")
    @TableField("pintermediate_title")
    private Integer pintermediateTitle;

    /**
     * 参与人员博士(人）
     */
    @ApiModelProperty(value="参与人员博士(人）",name="participantDoctor")
    @TableField("participant_doctor")
    private Integer participantDoctor;

    /**
     * 参与人员硕士(人）
     */
    @ApiModelProperty(value="参与人员硕士(人）",name="participantMaster")
    @TableField("participant_master")
    private Integer participantMaster;

    /**
     * 参与人员学科带头人(人）
     */
    @ApiModelProperty(value="参与人员学科带头人(人）",name="participantLeader")
    @TableField("participant_leader")
    private Integer participantLeader;

    /**
     * 参与人员留学生(人）
     */
    @ApiModelProperty(value="参与人员留学生(人）",name="participantOverstu")
    @TableField("participant_overstu")
    private Integer participantOverstu;

    /**
     * 项目进度（单选）
     */
    @ApiModelProperty(value="项目进度（单选）",name="projectProgress")
    @TableField("project_progress")
    private String projectProgress;

    /**
     * 项目拖延、停顿、逾期、申请撤项主要原因（单选）
     */
    @ApiModelProperty(value="项目拖延、停顿、逾期、申请撤项主要原因（单选）",name="delayReason")
    @TableField("delay_reason")
    private String delayReason;

    /**
     * 软件著作权申请数
     */
    @ApiModelProperty(value="软件著作权申请数",name="softapplyNumber")
    @TableField("softapply_number")
    private Integer softapplyNumber;

    /**
     * 软件著作权授权数
     */
    @ApiModelProperty(value="软件著作权授权数",name="softauthorizeNumber")
    @TableField("softauthorize_number")
    private Integer softauthorizeNumber;

    /**
     * 发表论文数（省级以上）（篇）
     */
    @ApiModelProperty(value="发表论文数（省级以上）（篇）",name="publicPnumber")
    @TableField("public_pnumber")
    private Integer publicPnumber;

    /**
     * 发表论文数（其中国际刊物）（篇）
     */
    @ApiModelProperty(value="发表论文数（其中国际刊物）（篇）",name="publicInumber")
    @TableField("public_inumber")
    private Integer publicInumber;

    /**
     * 获奖_市级（市）
     */
    @ApiModelProperty(value="获奖_市级（个）",name="prizeCity")
    @TableField("prize_city")
    private Integer prizeCity;

    /**
     * 获奖_其他
     */
    @ApiModelProperty(value="获奖_其他（个）",name="prizeOther")
    @TableField("prize_other")
    private Integer prizeOther;

    /**
     * 制定标准-国家标准（个）
     */
    @ApiModelProperty(value="制定标准-国家标准（个）",name="zdgjbz")
    @TableField("zdgjbz")
    private Integer zdgjbz;

    /**
     * 制定标准-行业标准（个）
     */
    @ApiModelProperty(value="制定标准-行业标准（个）",name="industryStandard")
    @TableField("industry_standard")
    private Integer industryStandard;

    /**
     * 制定标准-企业标准（个）
     */
    @ApiModelProperty(value="制定标准-企业标准（个）",name="enterpriseStandard")
    @TableField("enterprise_standard")
    private Integer enterpriseStandard;

    /**
     * 制定标准-企业标准（个）
     */
    @ApiModelProperty(value="制定标准-企业标准（个）",name="foreignStandard")
    @TableField("foreign_standard")
    private Integer foreignStandard;

    /**
     * 出版著作（部）-国际（部）
     */
    @ApiModelProperty(value="出版著作（部）-国际（部）",name="publiciworkNumber")
    @TableField("publiciwork_number")
    private Integer publiciworkNumber;

    /**
     * 出版著作（部）-国内（部）
     */
    @ApiModelProperty(value="出版著作（部）-国内（部）",name="publicdworkNumber")
    @TableField("publicdwork_number")
    private Integer publicdworkNumber;

    /**
     * 技术成果转移受让方户数
     */
    @ApiModelProperty(value="技术成果转移受让方户数",name="trtransferNumber")
    @TableField("trtransfer_number")
    private Integer trtransferNumber;

    /**
     * 技术成果转移-转移金额（万元）
     */
    @ApiModelProperty(value="技术成果转移-转移金额（万元）",name="trtransferFound")
    @TableField("trtransfer_found")
    private Double trtransferFound;

    /**
     * 研发服务平台（个）
     */
    @ApiModelProperty(value="研发服务平台（个）",name="servicePlatform")
    @TableField("service_platform")
    private Integer servicePlatform;

    /**
     * 项目培训（人次）
     */
    @ApiModelProperty(value="项目培训（人次）",name="projectTraining")
    @TableField("project_training")
    private Integer projectTraining;

    /**
     * 新品种推广面积或扩展繁殖（亩、头）
     */
    @ApiModelProperty(value="新品种推广面积或扩展繁殖（亩、头）",name="promotionArea")
    @TableField("promotion_area")
    private Double promotionArea;

    /**
     * 新增设备（台/件）
     */
    @ApiModelProperty(value="新增设备（台/件）",name="newsb")
    @TableField("newsb")
    private Integer newsb;

    /**
     * 新增生产线
     */
    @ApiModelProperty(value="新增生产线",name="newscx")
    @TableField("newscx")
    private Integer newscx;

    /**
     * 新增中试线
     */
    @ApiModelProperty(value="新增中试线",name="newzsx")
    @TableField("newzsx")
    private Integer newzsx;

    /**
     * 新增示范培训基地
     */
    @ApiModelProperty(value="新增示范培训基地",name="newsfpxjd")
    @TableField("newsfpxjd")
    private Integer newsfpxjd;

    /**
     * 新增实验基地
     */
    @ApiModelProperty(value="新增实验基地",name="newsyjd")
    @TableField("newsyjd")
    private Integer newsyjd;

    /**
     * 新增缴税总额
     */
    @ApiModelProperty(value="新增缴税总额",name="newjsze")
    @TableField("newjsze")
    private String newjsze;

    /**
     * 用户自行添加的文本说明
     */
    @ApiModelProperty(value="合同进度计划-其他原因说明",name="other_reasondesc")
    @TableField("other_reasondesc")
    private String otherReasondesc;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="填写日期",name="submitdate")
    @TableField("submitdate")
    private Date submitdate;

    @ApiModelProperty(value="名称-后台生成",name="ename")
    @TableField("ename")
    private String ename;





    @ApiModelProperty(value="新增产值",name="newcz")
    @TableField("newcz")
    private Double newcz;

    @ApiModelProperty(value="新增销售收入",name="newxssr")
    @TableField("newxssr")
    private Double newxssr;

    @ApiModelProperty(value="新增的利润总额",name="newlrze")
    @TableField("newlrze")
    private Double newlrze;

    @ApiModelProperty(value="新增的创汇额",name="newche")
    @TableField("newche")
    private Double newche;



    public Double getNewcz() {
        return newcz;
    }

    public void setNewcz(Double newcz) {
        this.newcz = newcz;
    }

    public Double getNewxssr() {
        return newxssr;
    }

    public void setNewxssr(Double newxssr) {
        this.newxssr = newxssr;
    }

    public Double getNewlrze() {
        return newlrze;
    }

    public void setNewlrze(Double newlrze) {
        this.newlrze = newlrze;
    }

    public Double getNewche() {
        return newche;
    }

    public void setNewche(Double newche) {
        this.newche = newche;
    }

    public String getEvalId() {
        return evalId;
    }

    public void setEvalId(String evalId) {
        this.evalId = evalId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getSubmitdate() {
        return submitdate;
    }


    public void setSubmitdate(Date submitdate) {
        this.submitdate = submitdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public Integer getIsEstablishment() {
        return isEstablishment;
    }

    public void setIsEstablishment(Integer isEstablishment) {
        this.isEstablishment = isEstablishment;
    }
    public Integer getPseniorTitle() {
        return pseniorTitle;
    }

    public void setPseniorTitle(Integer pseniorTitle) {
        this.pseniorTitle = pseniorTitle;
    }
    public Integer getPintermediateTitle() {
        return pintermediateTitle;
    }

    public void setPintermediateTitle(Integer pintermediateTitle) {
        this.pintermediateTitle = pintermediateTitle;
    }
    public Integer getParticipantDoctor() {
        return participantDoctor;
    }

    public void setParticipantDoctor(Integer participantDoctor) {
        this.participantDoctor = participantDoctor;
    }
    public Integer getParticipantMaster() {
        return participantMaster;
    }

    public void setParticipantMaster(Integer participantMaster) {
        this.participantMaster = participantMaster;
    }
    public Integer getParticipantLeader() {
        return participantLeader;
    }

    public void setParticipantLeader(Integer participantLeader) {
        this.participantLeader = participantLeader;
    }
    public Integer getParticipantOverstu() {
        return participantOverstu;
    }

    public void setParticipantOverstu(Integer participantOverstu) {
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
    public Integer getSoftapplyNumber() {
        return softapplyNumber;
    }

    public void setSoftapplyNumber(Integer softapplyNumber) {
        this.softapplyNumber = softapplyNumber;
    }
    public Integer getSoftauthorizeNumber() {
        return softauthorizeNumber;
    }

    public void setSoftauthorizeNumber(Integer softauthorizeNumber) {
        this.softauthorizeNumber = softauthorizeNumber;
    }
    public Integer getPublicPnumber() {
        return publicPnumber;
    }

    public void setPublicPnumber(Integer publicPnumber) {
        this.publicPnumber = publicPnumber;
    }
    public Integer getPublicInumber() {
        return publicInumber;
    }

    public void setPublicInumber(Integer publicInumber) {
        this.publicInumber = publicInumber;
    }
    public Integer getPrizeCity() {
        return prizeCity;
    }

    public void setPrizeCity(Integer prizeCity) {
        this.prizeCity = prizeCity;
    }
    public Integer getPrizeOther() {
        return prizeOther;
    }

    public void setPrizeOther(Integer prizeOther) {
        this.prizeOther = prizeOther;
    }
    public Integer getZdgjbz() {
        return zdgjbz;
    }

    public void setZdgjbz(Integer zdgjbz) {
        this.zdgjbz = zdgjbz;
    }
    public Integer getIndustryStandard() {
        return industryStandard;
    }

    public void setIndustryStandard(Integer industryStandard) {
        this.industryStandard = industryStandard;
    }
    public Integer getEnterpriseStandard() {
        return enterpriseStandard;
    }

    public void setEnterpriseStandard(Integer enterpriseStandard) {
        this.enterpriseStandard = enterpriseStandard;
    }
    public Integer getForeignStandard() {
        return foreignStandard;
    }

    public void setForeignStandard(Integer foreignStandard) {
        this.foreignStandard = foreignStandard;
    }
    public Integer getPubliciworkNumber() {
        return publiciworkNumber;
    }

    public void setPubliciworkNumber(Integer publiciworkNumber) {
        this.publiciworkNumber = publiciworkNumber;
    }
    public Integer getPublicdworkNumber() {
        return publicdworkNumber;
    }

    public void setPublicdworkNumber(Integer publicdworkNumber) {
        this.publicdworkNumber = publicdworkNumber;
    }
    public Integer getTrtransferNumber() {
        return trtransferNumber;
    }

    public void setTrtransferNumber(Integer trtransferNumber) {
        this.trtransferNumber = trtransferNumber;
    }
    public Double getTrtransferFound() {
        return trtransferFound;
    }

    public void setTrtransferFound(Double trtransferFound) {
        this.trtransferFound = trtransferFound;
    }
    public Integer getServicePlatform() {
        return servicePlatform;
    }

    public void setServicePlatform(Integer servicePlatform) {
        this.servicePlatform = servicePlatform;
    }
    public Integer getProjectTraining() {
        return projectTraining;
    }

    public void setProjectTraining(Integer projectTraining) {
        this.projectTraining = projectTraining;
    }
    public Double getPromotionArea() {
        return promotionArea;
    }

    public void setPromotionArea(Double promotionArea) {
        this.promotionArea = promotionArea;
    }
    public Integer getNewsb() {
        return newsb;
    }

    public void setNewsb(Integer newsb) {
        this.newsb = newsb;
    }
    public Integer getNewscx() {
        return newscx;
    }

    public void setNewscx(Integer newscx) {
        this.newscx = newscx;
    }
    public Integer getNewzsx() {
        return newzsx;
    }

    public void setNewzsx(Integer newzsx) {
        this.newzsx = newzsx;
    }
    public Integer getNewsfpxjd() {
        return newsfpxjd;
    }

    public void setNewsfpxjd(Integer newsfpxjd) {
        this.newsfpxjd = newsfpxjd;
    }
    public Integer getNewsyjd() {
        return newsyjd;
    }

    public void setNewsyjd(Integer newsyjd) {
        this.newsyjd = newsyjd;
    }
    public String getNewjsze() {
        return newjsze;
    }

    public void setNewjsze(String newjsze) {
        this.newjsze = newjsze;
    }

    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }

    public String getOtherReasondesc() {
        return otherReasondesc;
    }

    public void setOtherReasondesc(String other_reasondesc) {
        this.otherReasondesc = otherReasondesc;
    }

    @Override
    public String toString() {
        return "Evaluation {" +
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
        ", other_reasondesc=" + otherReasondesc +
        "}";
    }
}
