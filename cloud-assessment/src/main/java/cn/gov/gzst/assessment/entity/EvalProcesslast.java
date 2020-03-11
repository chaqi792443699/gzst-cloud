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
 * @since 2019-05-06
 */
@TableName("eval_processlast")
public class EvalProcesslast extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField("pactid")
    private String pactid;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

    /**
     * 状态
     */
    @TableField("state")
    private Integer state;

    /**
     * 意见
     */
    @TableField("opinion")
    private String opinion;

    /**
     * 操作时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("operate_time")
    private Date operateTime;

    /**
     * 是否已审核
     */
    @TableField("ischeck")
    private Integer ischeck;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    @Override
    public String toString() {
        return "EvalProcesslast{" +
        "id=" + id +
        ", pactid=" + pactid +
        ", operator=" + operator +
        ", state=" + state +
        ", opinion=" + opinion +
        ", operateTime=" + operateTime +
        ", ischeck=" + ischeck +
        "}";
    }
}
