package cn.gov.gzst.oss.entity;

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
 * @author jianliaoliang
 * @since 2019-07-01
 */
@TableName("oss_group")
public class Group extends BaseEntity {

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
     * 所属应用场景
     */
    @TableField("scene_id")
    private String sceneId;

    /**
     * 分组说明
     */
    @TableField("remarks")
    private String remarks;

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
    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Group{" +
        "id=" + id +
        ", name=" + name +
        ", code=" + code +
        ", sceneId=" + sceneId +
        ", remarks=" + remarks +
        "}";
    }
}
