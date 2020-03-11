package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 角色-菜单实体类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-15
 */
@TableName("sec_role_authority")
public class SecRoleAuthority extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 权限ID
     */
    @TableField("authority_id")
    private String authorityId;

    /**
     * 角色ID
     */
    @TableField("role_id")
    private String roleId;

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
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SecRoleAuthority{" +
        "id=" + id +
        ", authorityId=" + authorityId +
        ", roleId=" + roleId +
        "}";
    }
}
