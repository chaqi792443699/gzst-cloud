package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 问题实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("PGZX_CWPG_PROBLEM")
public class FinanceProblem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;

    /**
     * 评估结论编号（外键）
     */
    @TableField("PROJECT_ID")
    @ApiModelProperty(name = "projectId",value = "项目编号（外键）",dataType = "String")
        private String projectId;

    /**
     * 问题排序
     */
    @TableField("SORT")
    @ApiModelProperty(name = "sort",value = "问题排序",dataType = "int")
    private Integer sort;

    /**
     * 问题内容
     */
    @TableField("PROBLEM_CONTENT")
    @ApiModelProperty(name = "problemContent",value = "问题内容",dataType = "String")
    private String problemContent;

    /**
     * 给出的意见
     */
    @TableField("OPINION")
    @ApiModelProperty(name = "opinion",value = "给出的意见",dataType = "String")
    private String opinion;

    /**
     *  1.采纳 2.不采纳
     */
    @TableField("STATUS")
    @ApiModelProperty(name = "status",value = "1.采纳 2.不采纳",dataType = "String")
    private String status;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FinanceProblem{" +
                "id='" + id + '\'' +
                ", jielunNumber='" + projectId + '\'' +
                ", sort=" + sort +
                ", problemContent='" + problemContent + '\'' +
                ", opinion='" + opinion + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
