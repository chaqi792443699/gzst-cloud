package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.integration.amqp.support.NackedAmqpMessageException;

import java.util.Date;

/**
 * <p>
 * 流程信息实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("PGZX_CWPG_PROCESS")
public class FinanceProcess extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "Integer")
    private String id;

    /**
     * 合同预算编号（外键）
     */
    @TableField("PROJECT_ID")
    @ApiModelProperty(name = "projectId",value = "合同预算编号（外键）",dataType = "String")
    private String projectId;

    /**
     * 审批信息
     */
    @TableField("APPROVAL")
    @ApiModelProperty(name = "approval",value = "审批信息",dataType = "String")
    private String approval;

    /**
     * 审批时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField("APPROVAL_TIME")
    @ApiModelProperty(name = "approvalTime",value = "审批时间",dataType = "Date")
    private Date approvalTime;

    /**
     * 审批人编号
     */
    @TableField("APPROVAL_ID")
    @ApiModelProperty(name = "approvalId",value = "审批人编号",dataType = "String")
    private String approvalId;

    /**
     * 审批意见
     */
    @TableField("APPROVAL_OPINION")
    @ApiModelProperty(name = "approvalOpinion",value = "审批意见",dataType = "String")
    private String approvalOpinion;
    @TableField("PACTID")
    @ApiModelProperty(name = "pactId",value = "合同编号",dataType = "String")
    private String pactId;

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

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }
    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }
    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public String getPactId() {
        return pactId;
    }

    public void setPactId(String pactId) {
        this.pactId = pactId;
    }

    @Override
    public String toString() {
        return "FinanceProcess{" +
        "id=" + id +
        ", contractId=" + projectId +
        ", approval=" + approval +
        ", approvalTime=" + approvalTime +
        ", approvalId=" + approvalId +
        ", approvalOpinion=" + approvalOpinion +
        "}";
    }
}
