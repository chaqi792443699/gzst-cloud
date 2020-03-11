package cn.gov.gzst.oss.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-07-01
 */
@TableName("oss_model")
public class Model extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 附件名称
     */
    @TableField("name")
    private String name;

    /**
     * 所属分组
     */
    @TableField("gid")
    private String gid;

    /**
     * 接收类型
     */
    @TableField("type")
    private String type;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    @TableField("require")
    private Integer require;

    /**
     * 附件说明
     */
    @TableField("remarks")
    private String remarks;

    @TableField("size")
    private Integer size;

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
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getRemarks() {
        return remarks;
    }

    public Integer getRequire() {
        return require;
    }

    public void setRequire(Integer require) {
        this.require = require;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Model{" +
        "id=" + id +
        ", name=" + name +
        ", gid=" + gid +
        ", type=" + type +
        ", sort=" + sort +
        ", remarks=" + remarks +
        "}";
    }
}
