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
@TableName("sec_authority")
public class SecAuthority extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 权限名称（英文编码）
     */
    @TableField("name")
    private String name;

    /**
     * 说明
     */
    @TableField("remark")
    private String remark;

    /**
     * 业务场景
     */
    @TableField("scene_id")
    private String sceneId;

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

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SecAuthority{" +
        "id=" + id +
        ", name=" + name +
        ", remark=" + remark +
        "}";
    }
}
