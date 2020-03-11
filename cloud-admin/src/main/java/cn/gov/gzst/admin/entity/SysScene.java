package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@TableName("sys_scene")
public class SysScene extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 业务场景名称
     */
    @TableField("name")
    private String name;

    /**
     * 场景编码
     */
    @TableField("code")
    private String code;

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

    @Override
    public String toString() {
        return "SysScene{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        "}";
    }
}
