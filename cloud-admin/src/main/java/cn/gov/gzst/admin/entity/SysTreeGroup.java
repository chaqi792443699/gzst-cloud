package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * <p>
 * 树分组实体类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-06
 */
@TableName("sys_tree_group")
public class SysTreeGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 分组名称
     */
    @TableField("name")
    private String name;

    /**
     * 分组编码
     */
    @TableField("code")
    private String code;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    @TableField("create_by")
    private String createBy;

    @TableField("create_date")
    private Date createDate;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_date")
    private Date updateDate;

    @TableField("del_flag")
    private String delFlag;

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "SysTreeGroup{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", remarks=" + remarks +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", delFlag=" + delFlag +
        "}";
    }
}
