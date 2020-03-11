package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
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
 * @author lwy
 * @since 2019-05-22
 */
@TableName("PGZX_SFROMSTR")
public class PgzxSfromstr extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 指标名字
     */
    @TableField("NAME")
    private String name;

    /**
     * 分值
     */
    @TableField("SCORE")
    private Double score;

    /**
     * 评价内容
     */
    @TableField("CONTENT")
    private String content;

    /**
     * 评分标准
     */
    @TableField("STRDANT")
    private String strdant;

    /**
     * 得分
     */
    @TableField("GRADE")
    private Double grade;

    /**
     * 父id
     */
    @TableField("PARENTID")
    private String parentid;

    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private Date createtime;

    /**
     * 创建人
     */
    @TableField("CREATEMAN")
    private String createman;

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
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getStrdant() {
        return strdant;
    }

    public void setStrdant(String strdant) {
        this.strdant = strdant;
    }
    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    @Override
    public String toString() {
        return "PgzxSfromstr{" +
        "id=" + id +
        ", name=" + name +
        ", score=" + score +
        ", content=" + content +
        ", strdant=" + strdant +
        ", grade=" + grade +
        ", parentid=" + parentid +
        ", createtime=" + createtime +
        ", createman=" + createman +
        "}";
    }
}
