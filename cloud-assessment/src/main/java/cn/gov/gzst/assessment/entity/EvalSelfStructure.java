package cn.gov.gzst.assessment.entity;

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
 * @author lonwanyuan
 * @since 2019-04-19
 */
@TableName("jxpg_self")
public class EvalSelfStructure extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 指标名字
     */
    @TableField("name")
    private String name;

    /**
     * 分值
     */
    @TableField("score")
    private Integer score;

    /**
     * 评价内容
     */
    @TableField("content")
    private String content;

    /**
     * 评分标准
     */
    @TableField("strdant")
    private String strdant;

    /**
     * 得分
     */
    @TableField("grade")
    private Integer grade;

    /**
     * 父id
     */
    @TableField("parentid")
    private String parentid;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("createtime")
    private Date createtime;

    /**
     * 创建人
     */
    @TableField("creatby")
    private String creatby;

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
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
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
    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby;
    }

    @Override
    public String toString() {
        return "EvalSelfStructure{" +
        "id=" + id +
        ", name=" + name +
        ", score=" + score +
        ", content=" + content +
        ", strdant=" + strdant +
        ", grade=" + grade +
        ", parentid=" + parentid +
        ", createtime=" + createtime +
        ", creatby=" + creatby +
        "}";
    }
}
