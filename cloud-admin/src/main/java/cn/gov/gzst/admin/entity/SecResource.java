package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 资源表实体类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@TableName("sec_resource")
public class SecResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 资源名称
     */
    @TableField("name")
    private String name;

    /**
     * 前端组件编码/路径
     */
    @TableField("source")
    private String source;

    /**
     * 资源类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 所属模块
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
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    @Override
    public String toString() {
        return "SecResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", type=" + type +
                ", sceneId='" + sceneId + '\'' +
                '}';
    }
}
