package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * <p>
 * 审核记录表实体类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-23
 */
@TableName("PGZX_PROCESSLSAT")
public class PgzxProcesslsat extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 项目编号（外键）
     */
    @TableField("PROJECT_ID")
    private String projectId;

    /**
     * 审核状态
     */
    @TableField("APPROVAL")
    private String approval;

    /**
     * 审核时间
     */
    @TableField("APPROVAL_TIME")
    private Date approvalTime;

    /**
     * 审核人
     */
    @TableField("APPROVAL_ID")
    private String approvalId;

    /**
     * 审核意见
     */
    @TableField("APPROVAL_OPINION")
    private String approvalOpinion;

    /**
     * 合同编号
     */
    @TableField("PACTID")
    private String pactid;

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
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }

    @Override
    public String toString() {
        return "PgzxProcesslsat{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", approval=" + approval +
        ", approvalTime=" + approvalTime +
        ", approvalId=" + approvalId +
        ", approvalOpinion=" + approvalOpinion +
        ", pactid=" + pactid +
        "}";
    }
}
