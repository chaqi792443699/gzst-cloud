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
@TableName("survey_scheme")
public class Scheme extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 问卷id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 方案名称
     */
    @TableField("name")
    private String name;

    /**
     * 方案分组名
     */
    @TableField("group_name")
    private String groupName;

    /**
     * 问卷描述
     */
    @TableField("description")
    private String description;

    @TableField("isEnable")
    private String isEnable;

    @TableField("sort")
    private Integer sort;

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

    @TableField(exist = false)
    private List<Question> questionList;

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
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "Scheme{" +
        "id=" + id +
        ", name=" + name +
        ", groupName=" + groupName +
        ", description=" + description +
        ", isEnable=" + isEnable +
        ", sort=" + sort +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        "}";
    }
}
