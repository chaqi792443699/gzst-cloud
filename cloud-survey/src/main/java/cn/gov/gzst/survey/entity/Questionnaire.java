package cn.gov.gzst.survey.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
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
 * @author wuzhengjun
 * @since 2019-03-12
 */
@TableName("survey_questionnaire")
public class Questionnaire extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 投票id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 问卷名称
     */
    @TableField("name")
    private String name;

    /**
     * 方案
     */
    @TableField("scheme_id")
    private String schemeId;

    /**
     * 开始日期
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("start_date")
    private Date startDate;

    /**
     * 截止日期
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("closing_date")
    private Date closingDate;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField(exist = false)
    private Date answerDate;

    /**
     * 问卷描述
     */
    @TableField("description")
    private String description;

    @TableField(exist = false)
    private Scheme scheme;

    /**
     * 是否启用
     */
    @TableField("isEnable")
    private String isEnable;

    /**
     * 创建日期
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("create_date")
    private Date createDate;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("update_date")
    private Date updateDate;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    @TableField(exist = false)
    private String status;

    @TableField(exist = false)
    private String isValidity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public Date getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(Date answerDate) {
        this.answerDate = answerDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsValidity() {
        return isValidity;
    }

    public void setIsValidity(String isValidity) {
        this.isValidity = isValidity;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
        "id=" + id +
        ", name=" + name +
        ", schemeId=" + schemeId +
        ", startDate=" + startDate +
        ", closingDate=" + closingDate +
        ", description=" + description +
        ", isEnable=" + isEnable +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        "}";
    }
}
