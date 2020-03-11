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
 * @since 2019-04-22
 */
@TableName("jxpg_evaladd")
public class EvalAddtion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 添加项
     */
    @TableField("add_key")
    private String addKey;

    /**
     * 添加值
     */
    @TableField("add_value")
    private String addValue;

    /**
     * 关联评价表id
     */
    @TableField("eval_id")
    private String evalId;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAddKey() {
        return addKey;
    }

    public void setAddKey(String addKey) {
        this.addKey = addKey;
    }
    public String getAddValue() {
        return addValue;
    }

    public void setAddValue(String addValue) {
        this.addValue = addValue;
    }
    public String getEvalId() {
        return evalId;
    }

    public void setEvalId(String evalId) {
        this.evalId = evalId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "EvalAddtion{" +
        "id=" + id +
        ", addKey=" + addKey +
        ", addValue=" + addValue +
        ", evalId=" + evalId +
        ", createTime=" + createTime +
        "}";
    }
}
