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
 * @author longwanyuan
 * @since 2019-04-19
 */
@TableName("jxpg_selfresult")
public class EvalSelfResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户id
     */
    @TableField("userid")
    private String userid;

    /**
     * 三级指标id
     */
    @TableField("thirdclassid")
    private String thirdclassid;

    /**
     * 得分
     */
    @TableField("grade")
    private String grade;



    /**
     * 提交时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("filltime")
    private Date filltime;


    /**
     * 意见
     */
    @TableField("opinion")
    private String  opinion;

    /**
     * 状态
     */
    @TableField("status")
    private Integer  status;


    /**
     * 合同id
     */
    @TableField("pactid")
    private String pactid;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }



    public String getOpinion() {return opinion;}
    public void setOpinion(String opinion) {this.opinion = opinion;}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getThirdclassid() {
        return thirdclassid;
    }

    public void setThirdclassid(String thirdclassid) {
        this.thirdclassid = thirdclassid;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getFilltime() {
        return filltime;
    }

    public void setFilltime(Date filltime) {
        this.filltime = filltime;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }

    @Override
    public String toString() {
        return "EvalSelfResult{" +
        "id=" + id +
        ", userid=" + userid +
        ", thirdclassid=" + thirdclassid +
        ", grade=" + grade +
        ", filltime=" + filltime +
        ", pactid=" + pactid +
        "}";
    }
}
