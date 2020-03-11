package cn.gov.gzst.survey.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@TableName("survey_question")
public class Question extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 题目名称
     */
    @TableField("name")
    private String name;

    /**
     * 题目类型（单选、多选、文本框，文本域）
     */
    @TableField("type")
    private String type;

    /**
     * 分值/限制
     */
    @TableField("limit_value")
    private Integer limitValue;

    /**
     * 是否启用
     */
    @TableField("isEnable")
    private String isEnable;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 问题描述
     */
    @TableField("description")
    private String description;

    /**
     * 方案idd
     */
    @TableField("scheme_id")
    private String schemeId;

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

    @TableField("scoreData")
    private String result;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    @TableField(exist = false)
    private List<Option> optionList;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(Integer limitValue) {
        this.limitValue = limitValue;
    }
    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
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

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Question{" +
        "id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", limitValue=" + limitValue +
        ", isEnable=" + isEnable +
        ", sort=" + sort +
        ", description=" + description +
        ", schemeId=" + schemeId +
        "}";
    }
}
