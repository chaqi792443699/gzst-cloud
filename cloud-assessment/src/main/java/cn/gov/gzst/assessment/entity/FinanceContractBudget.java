package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-24
 */
@TableName("PGZX_CWPG_CONTRACT_BUDGET")
public class FinanceContractBudget extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;

    /**
     * 合同预算编号
     */
    @TableField("contractid")
    @ApiModelProperty(name = "contractid",value = "合同预算编号",dataType = "String")
    private String contractid;

    /**
     * 项目编号（外键）
     */
    @TableField("projectid")
    @ApiModelProperty(name = "projectid",value = "项目编号（外键）",dataType = "String")
    private String projectid;

    /**
     * 合同预算创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("createtime")
    @ApiModelProperty(name = "createtime",value = "合同预算创建时间",dataType = "Date")
    private Date createtime;

    /**
     * 合同预算更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("updatetime")
    @ApiModelProperty(name = "updatetime",value = "合同预算更新时间",dataType = "Date")
    private Date updatetime;

    /**
     * 设备费实际支出（自筹）
     */
    @TableField("instrumentexpenditurezc")
    @ApiModelProperty(name = "instrumentexpenditurezc",value = "设备费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal instrumentexpenditurezc;

    /**
     * 材料费实际支出（自筹）
     */
    @TableField("materialexpenditurezc")
    @ApiModelProperty(name = "materialexpenditurezc",value = "材料费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal materialexpenditurezc;

    /**
     * 测试化验加工费实际支出（自筹）
     */
    @TableField("testexpenditurezc")
    @ApiModelProperty(name = "testexpenditurezc",value = "测试化验加工费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal testexpenditurezc;

    /**
     * 燃料动力费实际支出（自筹）
     */
    @TableField("fuelexpenditurezc")
    @ApiModelProperty(name = "fuelexpenditurezc",value = "燃料动力费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal fuelexpenditurezc;

    /**
     * 会议费/差旅费/国际合作与交流费实际支出（自筹）
     */
    @TableField("meetingenditurezc")
    @ApiModelProperty(name = "meetingenditurezc",value = "会议费/差旅费/国际合作与交流费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal meetingenditurezc;

    /**
     * 出版/文献/信息传播/知识产权事务费实际支出（自筹）
     */
    @TableField("publishingexpenditurezc")
    @ApiModelProperty(name = "publishingexpenditurezc",value = "出版/文献/信息传播/知识产权事务费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal publishingexpenditurezc;

    /**
     * 劳务费实际支出（自筹）
     */
    @TableField("labourservicesexpenditurezc")
    @ApiModelProperty(name = "labourservicesexpenditurezc",value = "劳务费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal labourservicesexpenditurezc;

    /**
     * 专家咨询费实际支出（自筹）
     */
    @TableField("expertexpenditurezc")
    @ApiModelProperty(name = "expertexpenditurezc",value = "专家咨询费实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal expertexpenditurezc;

    /**
     * 其他支出（自筹）
     */
    @TableField("otherexpenditurezc")
    @ApiModelProperty(name = "otherexpenditurezc",value = "其他支出（自筹）",dataType = "BigDecimal")
    private BigDecimal otherexpenditurezc;

    /**
     * 间接费用 （含管理费和绩效支出）（自筹）
     */
    @TableField("indirectexpenditurezc")
    @ApiModelProperty(name = "indirectexpenditurezc",value = "间接费用 （含管理费和绩效支出）（自筹）",dataType = "BigDecimal")
    private BigDecimal indirectexpenditurezc;

    /**
     * 设备费实际支出（专项）
     */
    @TableField("instrumentexpenditurezx")
    @ApiModelProperty(name = "instrumentexpenditurezx",value = "设备费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal instrumentexpenditurezx;

    /**
     * 材料费实际支出（专项）
     */
    @TableField("materialexpenditurezx")
    @ApiModelProperty(name = "materialexpenditurezx",value = "材料费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal materialexpenditurezx;

    /**
     * 测试化验加工费实际支出（专项）
     */
    @TableField("testexpenditurezx")
    @ApiModelProperty(name = "testexpenditurezx",value = "测试化验加工费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal testexpenditurezx;

    /**
     * 燃料动力费实际支出（专项）
     */
    @TableField("fuelexpenditurezx")
    @ApiModelProperty(name = "fuelexpenditurezx",value = "燃料动力费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal fuelexpenditurezx;

    /**
     * 会议费/差旅费/国际合作与交流费实际支出（专项）
     */
    @TableField("meetingenditurezx")
    @ApiModelProperty(name = "meetingenditurezx",value = "会议费/差旅费/国际合作与交流费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal meetingenditurezx;

    /**
     * 出版/文献/信息传播/知识产权事务费实际支出（专项）
     */
    @TableField("publishingexpenditurezx")
    @ApiModelProperty(name = "publishingexpenditurezx",value = "出版/文献/信息传播/知识产权事务费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal publishingexpenditurezx;

    /**
     * 劳务费实际支出（专项）
     */
    @TableField("labourservicesexpenditurezx")
    @ApiModelProperty(name = "labourservicesexpenditurezx",value = "劳务费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal labourservicesexpenditurezx;

    /**
     * 专家咨询费实际支出（专项）
     */
    @TableField("expertexpenditurezx")
    @ApiModelProperty(name = "expertexpenditurezx",value = "专家咨询费实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal expertexpenditurezx;

    /**
     * 其他支出（专项）
     */
    @TableField("otherexpenditurezx")
    @ApiModelProperty(name = "otherexpenditurezx",value = "其他支出（专项）",dataType = "BigDecimal")
    private BigDecimal otherexpenditurezx;

    /**
     * 间接费用 （含管理费和绩效支出）（专项）
     */
    @TableField("indirectexpenditurezx")
    @ApiModelProperty(name = "indirectexpenditurezx",value = "间接费用 （含管理费和绩效支出）（专项）",dataType = "BigDecimal")
    private BigDecimal indirectexpenditurezx;

    /**
     * 实际支出自筹总数
     */
    @TableField("totalzc")
    @ApiModelProperty(name = "totalzc",value = "实际支出自筹总数",dataType = "BigDecimal")
    private BigDecimal totalzc;

    /**
     * 实际支出专项总数
     */
    @TableField("totalzx")
    @ApiModelProperty(name = "totalzx",value = "实际支出专项总数",dataType = "BigDecimal")
    private BigDecimal totalzx;

    /**
     * 合同类型
     */
    @TableField("contracttype")
    @ApiModelProperty(name = "contracttype",value = "合同类型",dataType = "String")
    private String contracttype;

    /**
     *设备费调整原因
     */
    @TableField("instrumentreason")
    @ApiModelProperty(name = "instrumentreason",value = "设备费调整原因",dataType = "String")
    private String instrumentreason;
    /**
     *材料费调整原因
     */
    @TableField("materialreason")
    @ApiModelProperty(name = "materialreason",value = "材料费调整原因",dataType = "String")
    private String materialreason;
    /**
     *测试化验加工费调整原因
     */
    @TableField("testreason")
    @ApiModelProperty(name = "testreason",value = "测试化验加工费调整原因",dataType = "String")
    private String testreason;
    /**
     *燃料动力费调整原因
     */
    @TableField("fuelreason")
    @ApiModelProperty(name = "fuelreason",value = "燃料动力费调整原因",dataType = "String")
    private String fuelreason;
    /**
     *会议费/差旅费/国际合作与交流费调整原因
     */
    @TableField("meetingreason")
    @ApiModelProperty(name = "meetingreason",value = "会议费/差旅费/国际合作与交流费调整原因",dataType = "String")
    private String meetingreason;
    /**
     * 出版/文献/信息传播/知识产权事务费调整原因
     */
    @TableField("publishingreason")
    @ApiModelProperty(name = "publishingreason",value = "出版/文献/信息传播/知识产权事务费调整原因",dataType = "String")
    private String publishingreason;
    /**
     * 劳务费调整原因
     */
    @TableField("labourservicesreason")
    @ApiModelProperty(name = "labourservicesreason",value = "劳务费调整原因",dataType = "String")
    private String labourservicesreason;
    /**
     * 专家咨询费调整原因
     */
    @TableField("expertconsultationreason")
    @ApiModelProperty(name = "expertconsultationreason",value = "专家咨询费调整原因",dataType = "String")
    private String expertconsultationreason;
    /**
     * 其他支出调整原因
     */
    @TableField("otherreason")
    @ApiModelProperty(name = "otherreason",value = "其他支出调整原因",dataType = "String")
    private String otherreason;
    /**
     * 间接费用 （含管理费和绩效支出）调整原因
     */
    @TableField("indirectreason")
    @ApiModelProperty(name = "indirectreason",value = "间接费用 （含管理费和绩效支出）调整原因",dataType = "String")
    private String indirectreason;

    /**
     *设备费调整原因(专项)
     */
    @TableField("instrumentreasonzx")
    @ApiModelProperty(name = "instrumentreasonzx",value = "设备费调整原因(专项)",dataType = "String")
    private String instrumentreasonzx;
    /**
     *材料费调整原因(专项)
     */
    @TableField("materialreasonzx")
    @ApiModelProperty(name = "materialreasonzx",value = "材料费调整原因(专项)",dataType = "String")
    private String materialreasonzx;
    /**
     *测试化验加工费调整原因(专项)
     */
    @TableField("testreasonzx")
    @ApiModelProperty(name = "testreasonzx",value = "测试化验加工费调整原因(专项)",dataType = "String")
    private String testreasonzx;
    /**
     *燃料动力费调整原因(专项)
     */
    @TableField("fuelreasonzx")
    @ApiModelProperty(name = "fuelreasonzx",value = "燃料动力费调整原因(专项)",dataType = "String")
    private String fuelreasonzx;
    /**
     *会议费/差旅费/国际合作与交流费调整原因(专项)
     */
    @TableField("meetingreasonzx")
    @ApiModelProperty(name = "meetingreasonzx",value = "会议费/差旅费/国际合作与交流费调整原因(专项)",dataType = "String")
    private String meetingreasonzx;
    /**
     * 出版/文献/信息传播/知识产权事务费调整原因(专项)
     */
    @TableField("publishingreasonzx")
    @ApiModelProperty(name = "publishingreasonzx",value = "出版/文献/信息传播/知识产权事务费调整原因(专项)",dataType = "String")
    private String publishingreasonzx;
    /**
     * 劳务费调整原因(专项)
     */
    @TableField("labourservicesreasonzx")
    @ApiModelProperty(name = "labourservicesreasonzx",value = "劳务费调整原因(专项)",dataType = "String")
    private String labourservicesreasonzx;
    /**
     * 专家咨询费调整原因(专项)
     */
    @TableField("expertconsultationreasonzx")
    @ApiModelProperty(name = "expertconsultationreasonzx",value = "专家咨询费调整原因(专项)",dataType = "String")
    private String expertconsultationreasonzx;
    /**
     * 其他支出调整原因(专项)
     */
    @TableField("otherreasonzx")
    @ApiModelProperty(name = "otherreasonzx",value = "其他支出调整原因(专项)",dataType = "String")
    private String otherreasonzx;
    /**
     * 间接费用 （含管理费和绩效支出）调整原因(专项)
     */
    @TableField("indirectreasonzx")
    @ApiModelProperty(name = "indirectreasonzx",value = "间接费用 （含管理费和绩效支出）调整原因(专项)",dataType = "String")
    private String indirectreasonzx;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }
    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    public BigDecimal getInstrumentexpenditurezc() {
        return instrumentexpenditurezc;
    }

    public void setInstrumentexpenditurezc(BigDecimal instrumentexpenditurezc) {
        this.instrumentexpenditurezc = instrumentexpenditurezc;
    }
    public BigDecimal getMaterialexpenditurezc() {
        return materialexpenditurezc;
    }

    public void setMaterialexpenditurezc(BigDecimal materialexpenditurezc) {
        this.materialexpenditurezc = materialexpenditurezc;
    }
    public BigDecimal getTestexpenditurezc() {
        return testexpenditurezc;
    }

    public void setTestexpenditurezc(BigDecimal testexpenditurezc) {
        this.testexpenditurezc = testexpenditurezc;
    }
    public BigDecimal getFuelexpenditurezc() {
        return fuelexpenditurezc;
    }

    public void setFuelexpenditurezc(BigDecimal fuelexpenditurezc) {
        this.fuelexpenditurezc = fuelexpenditurezc;
    }
    public BigDecimal getMeetingenditurezc() {
        return meetingenditurezc;
    }

    public void setMeetingenditurezc(BigDecimal meetingenditurezc) {
        this.meetingenditurezc = meetingenditurezc;
    }
    public BigDecimal getPublishingexpenditurezc() {
        return publishingexpenditurezc;
    }

    public void setPublishingexpenditurezc(BigDecimal publishingexpenditurezc) {
        this.publishingexpenditurezc = publishingexpenditurezc;
    }
    public BigDecimal getLabourservicesexpenditurezc() {
        return labourservicesexpenditurezc;
    }

    public void setLabourservicesexpenditurezc(BigDecimal labourservicesexpenditurezc) {
        this.labourservicesexpenditurezc = labourservicesexpenditurezc;
    }

    public BigDecimal getExpertexpenditurezc() {
        return expertexpenditurezc;
    }

    public void setExpertexpenditurezc(BigDecimal expertexpenditurezc) {
        this.expertexpenditurezc = expertexpenditurezc;
    }

    public String getInstrumentreasonzx() {
        return instrumentreasonzx;
    }

    public void setInstrumentreasonzx(String instrumentreasonzx) {
        this.instrumentreasonzx = instrumentreasonzx;
    }

    public String getMaterialreasonzx() {
        return materialreasonzx;
    }

    public void setMaterialreasonzx(String materialreasonzx) {
        this.materialreasonzx = materialreasonzx;
    }

    public String getTestreasonzx() {
        return testreasonzx;
    }

    public void setTestreasonzx(String testreasonzx) {
        this.testreasonzx = testreasonzx;
    }

    public String getFuelreasonzx() {
        return fuelreasonzx;
    }

    public void setFuelreasonzx(String fuelreasonzx) {
        this.fuelreasonzx = fuelreasonzx;
    }

    public String getMeetingreasonzx() {
        return meetingreasonzx;
    }

    public void setMeetingreasonzx(String meetingreasonzx) {
        this.meetingreasonzx = meetingreasonzx;
    }

    public String getPublishingreasonzx() {
        return publishingreasonzx;
    }

    public void setPublishingreasonzx(String publishingreasonzx) {
        this.publishingreasonzx = publishingreasonzx;
    }

    public String getLabourservicesreasonzx() {
        return labourservicesreasonzx;
    }

    public void setLabourservicesreasonzx(String labourservicesreasonzx) {
        this.labourservicesreasonzx = labourservicesreasonzx;
    }

    public String getExpertconsultationreasonzx() {
        return expertconsultationreasonzx;
    }

    public void setExpertconsultationreasonzx(String expertconsultationreasonzx) {
        this.expertconsultationreasonzx = expertconsultationreasonzx;
    }

    public String getOtherreasonzx() {
        return otherreasonzx;
    }

    public void setOtherreasonzx(String otherreasonzx) {
        this.otherreasonzx = otherreasonzx;
    }

    public String getIndirectreasonzx() {
        return indirectreasonzx;
    }

    public void setIndirectreasonzx(String indirectreasonzx) {
        this.indirectreasonzx = indirectreasonzx;
    }

    public BigDecimal getOtherexpenditurezc() {
        return otherexpenditurezc;
    }

    public void setOtherexpenditurezc(BigDecimal otherexpenditurezc) {
        this.otherexpenditurezc = otherexpenditurezc;
    }
    public BigDecimal getIndirectexpenditurezc() {
        return indirectexpenditurezc;
    }

    public void setIndirectexpenditurezc(BigDecimal indirectexpenditurezc) {
        this.indirectexpenditurezc = indirectexpenditurezc;
    }
    public BigDecimal getInstrumentexpenditurezx() {
        return instrumentexpenditurezx;
    }

    public void setInstrumentexpenditurezx(BigDecimal instrumentexpenditurezx) {
        this.instrumentexpenditurezx = instrumentexpenditurezx;
    }
    public BigDecimal getMaterialexpenditurezx() {
        return materialexpenditurezx;
    }

    public void setMaterialexpenditurezx(BigDecimal materialexpenditurezx) {
        this.materialexpenditurezx = materialexpenditurezx;
    }
    public BigDecimal getTestexpenditurezx() {
        return testexpenditurezx;
    }

    public void setTestexpenditurezx(BigDecimal testexpenditurezx) {
        this.testexpenditurezx = testexpenditurezx;
    }
    public BigDecimal getFuelexpenditurezx() {
        return fuelexpenditurezx;
    }

    public void setFuelexpenditurezx(BigDecimal fuelexpenditurezx) {
        this.fuelexpenditurezx = fuelexpenditurezx;
    }
    public BigDecimal getMeetingenditurezx() {
        return meetingenditurezx;
    }

    public void setMeetingenditurezx(BigDecimal meetingenditurezx) {
        this.meetingenditurezx = meetingenditurezx;
    }
    public BigDecimal getPublishingexpenditurezx() {
        return publishingexpenditurezx;
    }

    public void setPublishingexpenditurezx(BigDecimal publishingexpenditurezx) {
        this.publishingexpenditurezx = publishingexpenditurezx;
    }
    public BigDecimal getLabourservicesexpenditurezx() {
        return labourservicesexpenditurezx;
    }

    public void setLabourservicesexpenditurezx(BigDecimal labourservicesexpenditurezx) {
        this.labourservicesexpenditurezx = labourservicesexpenditurezx;
    }

    public BigDecimal getExpertexpenditurezx() {
        return expertexpenditurezx;
    }

    public void setExpertexpenditurezx(BigDecimal expertexpenditurezx) {
        this.expertexpenditurezx = expertexpenditurezx;
    }

    public BigDecimal getOtherexpenditurezx() {
        return otherexpenditurezx;
    }

    public void setOtherexpenditurezx(BigDecimal otherexpenditurezx) {
        this.otherexpenditurezx = otherexpenditurezx;
    }
    public BigDecimal getIndirectexpenditurezx() {
        return indirectexpenditurezx;
    }

    public void setIndirectexpenditurezx(BigDecimal indirectexpenditurezx) {
        this.indirectexpenditurezx = indirectexpenditurezx;
    }
    public BigDecimal getTotalzc() {
        return totalzc;
    }

    public void setTotalzc(BigDecimal totalzc) {
        this.totalzc = totalzc;
    }
    public BigDecimal getTotalzx() {
        return totalzx;
    }

    public void setTotalzx(BigDecimal totalzx) {
        this.totalzx = totalzx;
    }
    public String getContracttype() {
        return contracttype;
    }

    public void setContracttype(String contracttype) {
        this.contracttype = contracttype;
    }

    public String getInstrumentreason() {
        return instrumentreason;
    }

    public void setInstrumentreason(String instrumentreason) {
        this.instrumentreason = instrumentreason;
    }

    public String getMaterialreason() {
        return materialreason;
    }

    public void setMaterialreason(String materialreason) {
        this.materialreason = materialreason;
    }

    public String getTestreason() {
        return testreason;
    }

    public void setTestreason(String testreason) {
        this.testreason = testreason;
    }

    public String getFuelreason() {
        return fuelreason;
    }

    public void setFuelreason(String fuelreason) {
        this.fuelreason = fuelreason;
    }

    public String getMeetingreason() {
        return meetingreason;
    }

    public void setMeetingreason(String meetingreason) {
        this.meetingreason = meetingreason;
    }

    public String getPublishingreason() {
        return publishingreason;
    }

    public void setPublishingreason(String publishingreason) {
        this.publishingreason = publishingreason;
    }

    public String getLabourservicesreason() {
        return labourservicesreason;
    }

    public void setLabourservicesreason(String labourservicesreason) {
        this.labourservicesreason = labourservicesreason;
    }

    public String getExpertconsultationreason() {
        return expertconsultationreason;
    }

    public void setExpertconsultationreason(String expertconsultationreason) {
        this.expertconsultationreason = expertconsultationreason;
    }

    public String getOtherreason() {
        return otherreason;
    }

    public void setOtherreason(String otherreason) {
        this.otherreason = otherreason;
    }

    public String getIndirectreason() {
        return indirectreason;
    }

    public void setIndirectreason(String indirectreason) {
        this.indirectreason = indirectreason;
    }

    @Override
    public String toString() {
        return "FinanceContractBudget{" +
                "id='" + id + '\'' +
                ", contractid='" + contractid + '\'' +
                ", projectid='" + projectid + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", instrumentexpenditurezc=" + instrumentexpenditurezc +
                ", materialexpenditurezc=" + materialexpenditurezc +
                ", testexpenditurezc=" + testexpenditurezc +
                ", fuelexpenditurezc=" + fuelexpenditurezc +
                ", meetingenditurezc=" + meetingenditurezc +
                ", publishingexpenditurezc=" + publishingexpenditurezc +
                ", labourservicesexpenditurezc=" + labourservicesexpenditurezc +
                ", expertexpenditurezc=" + expertexpenditurezc +
                ", otherexpenditurezc=" + otherexpenditurezc +
                ", indirectexpenditurezc=" + indirectexpenditurezc +
                ", instrumentexpenditurezx=" + instrumentexpenditurezx +
                ", materialexpenditurezx=" + materialexpenditurezx +
                ", testexpenditurezx=" + testexpenditurezx +
                ", fuelexpenditurezx=" + fuelexpenditurezx +
                ", meetingenditurezx=" + meetingenditurezx +
                ", publishingexpenditurezx=" + publishingexpenditurezx +
                ", labourservicesexpenditurezx=" + labourservicesexpenditurezx +
                ", expertexpenditurezx=" + expertexpenditurezx +
                ", otherexpenditurezx=" + otherexpenditurezx +
                ", indirectexpenditurezx=" + indirectexpenditurezx +
                ", totalzc=" + totalzc +
                ", totalzx=" + totalzx +
                ", contracttype='" + contracttype + '\'' +
                ", instrumentreason='" + instrumentreason + '\'' +
                ", materialreason='" + materialreason + '\'' +
                ", testreason='" + testreason + '\'' +
                ", fuelreason='" + fuelreason + '\'' +
                ", meetingreason='" + meetingreason + '\'' +
                ", publishingreason='" + publishingreason + '\'' +
                ", labourservicesreason='" + labourservicesreason + '\'' +
                ", expertconsultationreason='" + expertconsultationreason + '\'' +
                ", otherreason='" + otherreason + '\'' +
                ", indirectreason='" + indirectreason + '\'' +
                '}';
    }
}
