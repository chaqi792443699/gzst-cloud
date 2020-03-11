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
 * 已抽取项目实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("PGZX_CWPG_PROJECT_EXTRACT")
public class FinanceProjectExtract extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;

    /**
     * 项目编号
     */
    @TableField("PROJECT_ID")
    @ApiModelProperty(name = "projectId",value = "项目编号",dataType = "String")
    private String projectId;

    /**
     * 抽取人编号
     */
    @TableField("EXTRACT_ID")
    @ApiModelProperty(name = "extractId",value = "抽取人编号",dataType = "String")
    private String extractId;

    /**
     * 抽取时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("EXTRACT_TIME")
    @ApiModelProperty(name = "extractTime",value = "抽取时间",dataType = "Date")
    private Date extractTime;

    /**
     * 0.未审核 1.审核通过 2.审核不通过3.退回
     */
    @TableField("STATUS")
    @ApiModelProperty(name = "status",value = "0.未审核 1.审核通过 2.审核不通过3.退回",dataType = "String")
    private String status;
    @TableField("EXTRACT_BATCH")
    @ApiModelProperty(name = "extractBatch",value = "项目抽取批次",dataType = "String")
    private String extractBatch;

    @TableField(exist = false)
    private String projectbasename;
    @TableField(exist = false)
    private String pactid;
    @TableField(exist = false)
    private String projectleader;
    @TableField(exist = false)
    private String mainorganizers;
    @TableField(exist = false)
    private String batchname;

    @TableField(exist = false)
    private String projectstartdate;
    @TableField(exist = false)
    private String projectenddate;
    @TableField(exist = false)
    private String contractno;
    @TableField(exist = false)
    private String techdomain;
    @TableField(exist = false)
    private String chiefdepartment;
    @TableField(exist = false)
    private String projectleaderphone;

    public String getProjectleaderphone() {
        return projectleaderphone;
    }

    public void setProjectleaderphone(String projectleaderphone) {
        this.projectleaderphone = projectleaderphone;
    }

    public String getProjectstartdate() {
        return projectstartdate;
    }

    public void setProjectstartdate(String projectstartdate) {
        this.projectstartdate = projectstartdate;
    }

    public String getProjectenddate() {
        return projectenddate;
    }

    public void setProjectenddate(String projectenddate) {
        this.projectenddate = projectenddate;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getTechdomain() {
        return techdomain;
    }

    public void setTechdomain(String techdomain) {
        this.techdomain = techdomain;
    }

    public String getChieldofficals() {
        return chiefdepartment;
    }

    public void setChieldofficals(String chieldofficals) {
        this.chiefdepartment = chieldofficals;
    }

    public String getProjectbasename() {
        return projectbasename;
    }

    public void setProjectbasename(String projectbasename) {
        this.projectbasename = projectbasename;
    }

    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }

    public String getProjectleader() {
        return projectleader;
    }

    public void setProjectleader(String projectleader) {
        this.projectleader = projectleader;
    }

    public String getMainorganizers() {
        return mainorganizers;
    }

    public void setMainorganizers(String mainorganizers) {
        this.mainorganizers = mainorganizers;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getExtractId() {
        return extractId;
    }

    public void setExtractId(String extractId) {
        this.extractId = extractId;
    }
    public Date getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(Date extractTime) {
        this.extractTime = extractTime;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtractBatch() {
        return extractBatch;
    }

    public void setExtractBatch(String extractBatch) {
        this.extractBatch = extractBatch;
    }

    @Override
    public String toString() {
        return "FinanceProjectExtract{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", extractId=" + extractId +
                ", extractTime=" + extractTime +
                ", status=" + status +
                "}";
    }
}
