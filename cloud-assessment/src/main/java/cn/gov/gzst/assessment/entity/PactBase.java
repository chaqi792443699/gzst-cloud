package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@TableName("pact_base")
public class PactBase extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 合同编号id
     */
    @TableField("id")
    private String id;

    /**
     * 项目id
     */
    @TableField("project_id")
    private String projectId;

    /**
     * 合同编码
     */
    @TableField("pactno")
    private String pactno;

    /**
     * 创建人id
     */
    @TableField("create_user_id")
    private String createUserId;

    /**
     * 合同状态
     */
    @TableField("pact_status")
    private String pactStatus;

    /**
     * 合同审核
     */
    @TableField("status")
    private String status;

    /**
     * 分配时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /**
     * 申报人id
     */
    @TableField("declarant_id")
    private String declarantId;

    /**
     * 申报人企业id
     */
    @TableField("declarant_depart_id")
    private String declarantDepartId;

    /**
     * 归口审核状态
     */
    @TableField("management_status")
    private String managementStatus;

    /**
     * 是否是导入数据
     */
    @TableField("isimport")
    private String isimport;

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
    public String getPactno() {
        return pactno;
    }

    public void setPactno(String pactno) {
        this.pactno = pactno;
    }
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
    public String getPactStatus() {
        return pactStatus;
    }

    public void setPactStatus(String pactStatus) {
        this.pactStatus = pactStatus;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getDeclarantId() {
        return declarantId;
    }

    public void setDeclarantId(String declarantId) {
        this.declarantId = declarantId;
    }
    public String getDeclarantDepartId() {
        return declarantDepartId;
    }

    public void setDeclarantDepartId(String declarantDepartId) {
        this.declarantDepartId = declarantDepartId;
    }
    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus;
    }
    public String getIsimport() {
        return isimport;
    }

    public void setIsimport(String isimport) {
        this.isimport = isimport;
    }

    @Override
    public String toString() {
        return "PactBase{" +
        "id=" + id +
        ", projectId=" + projectId +
        ", pactno=" + pactno +
        ", createUserId=" + createUserId +
        ", pactStatus=" + pactStatus +
        ", status=" + status +
        ", createTime=" + createTime +
        ", declarantId=" + declarantId +
        ", declarantDepartId=" + declarantDepartId +
        ", managementStatus=" + managementStatus +
        ", isimport=" + isimport +
        "}";
    }
}
