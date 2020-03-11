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
@TableName("survey_option")
public class Option extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 选项名称
     */
    @TableField("name")
    private String name;

    /**
     * 是否启用
     */
    @TableField("isEnable")
    private String isEnable;

    /**
     * 分值/限制
     */
    @TableField("limit_value")
    private Integer limitValue;

    /**
     * 选线描述
     */
    @TableField("description")
    private String description;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 题目id
     */
    @TableField("question_id")
    private String questionId;

    /**
     * 统计数据
     */
    @TableField("count_data")
    private String countData;

    /**
     * 创建时间
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
    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public Integer getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(Integer limitValue) {
        this.limitValue = limitValue;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getCountData() {
        return countData;
    }

    public void setCountData(String countData) {
        this.countData = countData;
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

    @Override
    public String toString() {
        return "Option{" +
        "id=" + id +
        ", name=" + name +
        ", isEnable=" + isEnable +
        ", limitValue=" + limitValue +
        ", description=" + description +
        ", sort=" + sort +
        ", questionId=" + questionId +
        "}";
    }
}
