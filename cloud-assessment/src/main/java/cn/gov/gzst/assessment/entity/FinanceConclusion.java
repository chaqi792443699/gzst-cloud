package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 财务评估结论实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("PGZX_CWPG_CONCLUSION")
public class FinanceConclusion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;


    /**
     * 编制人员编号
     */
    @TableField("PREPARED_ID")
    @ApiModelProperty(name = "preparedId",value = "编制人员编号",dataType = "String")
    private String preparedId;

    /**
     * 复核人员编号
     */
    @TableField("REVIEW_ID")
    @ApiModelProperty(name = "reviewId",value = "复核人员编号",dataType = "String")
    private String reviewId;

    /**
     * 复核意见
     */
    @TableField("REVIEW_OPINION")
    @ApiModelProperty(name = "reviewOpinion",value = "复核意见",dataType = "String")
    private String reviewOpinion;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("CREATE_TIME")
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "Date")
    private Date createTime;

    /**
     * 反馈时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("OPINION_TIME")
    @ApiModelProperty(name = "opinionTime",value = "反馈时间",dataType = "Date")
    private Date opinionTime;

    /**
     * 复核时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("REVIEW_TIME")
    @ApiModelProperty(name = "reviewTime",value = "复核时间",dataType = "Date")
    private Date reviewTime;
    /**
     * 项目编号（外键）
     */
    @TableField("PROJECT_ID")
    @ApiModelProperty(name = "projectId",value = "项目编号（外键）",dataType = "String")
    private String projectId;
    /**
     * 基本情况
     */
    @TableField("BASIC_SITUATION")
    @ApiModelProperty(name = "basicSituation",value = "基本情况",dataType = "String")
    private String basicSituation;
    @TableField("CONCLUSION_STATUS")
    @ApiModelProperty(name = "conclusionStatus",value = "结论状态",dataType = "String")
    private String conclusionStatus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreparedId() {
        return preparedId;
    }

    public void setPreparedId(String preparedId) {
        this.preparedId = preparedId;
    }
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(Date opinionTime) {
        this.opinionTime = opinionTime;
    }
    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBasicSituation() {
        return basicSituation;
    }

    public void setBasicSituation(String basicSituation) {
        this.basicSituation = basicSituation;
    }

    public String getConclusionStatus() {
        return conclusionStatus;
    }

    public void setConclusionStatus(String conclusionStatus) {
        this.conclusionStatus = conclusionStatus;
    }

    @Override
    public String toString() {
        return "FinanceConclusion{" +
                "id='" + id + '\'' +
                ", preparedId='" + preparedId + '\'' +
                ", reviewId='" + reviewId + '\'' +
                ", reviewOpinion='" + reviewOpinion + '\'' +
                ", createTime=" + createTime +
                ", opinionTime=" + opinionTime +
                ", reviewTime=" + reviewTime +
                ", projectId='" + projectId + '\'' +
                ", basicSituation='" + basicSituation + '\'' +
                ", status='" + conclusionStatus + '\'' +
                '}';
    }
}
