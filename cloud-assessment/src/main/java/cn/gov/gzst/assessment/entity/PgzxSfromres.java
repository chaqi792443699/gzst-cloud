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
@TableName("PGZX_SFROMRES")
public class PgzxSfromres extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 合同id
     */
    @TableField("PACTID")
    private String pactid;

    /**
     * 三级指标id
     */
    @TableField("THIRDCLASSID")
    private String thirdclassid;

    /**
     * 得分
     */
    @TableField("GRADE")
    private Integer grade;

    /**
     * 添加/更新时间
     */
    @TableField("FILLTIME")
    private Date filltime;

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
    public String getThirdclassid() {
        return thirdclassid;
    }

    public void setThirdclassid(String thirdclassid) {
        this.thirdclassid = thirdclassid;
    }
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public Date getFilltime() {
        return filltime;
    }

    public void setFilltime(Date filltime) {
        this.filltime = filltime;
    }

    @Override
    public String toString() {
        return "PgzxSfromres{" +
        "id=" + id +
        ", pactid=" + pactid +
        ", thirdclassid=" + thirdclassid +
        ", grade=" + grade +
        ", filltime=" + filltime +
        "}";
    }
}
