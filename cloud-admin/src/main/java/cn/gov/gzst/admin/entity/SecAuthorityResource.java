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
@TableName("sec_authority_resource")
public class SecAuthorityResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 权限ID
     */
    @TableField("authority_id")
    private String authorityId;

    /**
     * 资源ID
     */
    @TableField("resource_id")
    private String resourceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "SecAuthorityResource{" +
        "id=" + id +
        ", authorityId=" + authorityId +
        ", resourceId=" + resourceId +
        "}";
    }
}
