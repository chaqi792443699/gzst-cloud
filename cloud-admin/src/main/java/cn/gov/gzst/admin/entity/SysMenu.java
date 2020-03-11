package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import cn.gov.gzst.common.common.entity.TreeEntity;
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
 * @since 2019-06-16
 */
@TableName("sys_menu")
public class SysMenu extends TreeEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 权限ID
     */
    @TableField("source_id")
    private String sourceId;

    /**
     * 资源路径
     */
    @TableField("name")
    private String name;

    /**
     * 菜单所属场景
     */
    @TableField("scene_id")
    private String sceneId;

    /**
     * 路径编码
     */
    @TableField("path")
    private String path;

    /**
     * 访问路由
     */
    @TableField("title")
    private String title;

    /**
     * 父编号
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 父编号列表
     */
    @TableField("parent_ids")
    private String parentIds;

    @TableField(exist = false)
    private Integer level;

    @TableField(exist = false)
    private String parents;

    /**
     * 是否显示
     */
    @TableField("hidden")
    private Boolean hidden;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 跳转title
     */
    @TableField("redirect")
    private String redirect;

    /**
     * 是否缓存
     */
    @TableField("cacheable")
    private Boolean cacheable;

    @TableField("require_auth")
    private Boolean requireAuth;

    /**
     * 前端资源路径
     */
    @TableField("component")
    private String component;

    /**
     * 摘要
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
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
    public Boolean getCacheable() {
        return cacheable;
    }

    public void setCacheable(Boolean cacheable) {
        this.cacheable = cacheable;
    }
    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
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
        return "SysMenu{" +
        "id=" + id +
        ", sourceId=" + sourceId +
        ", name=" + name +
        ", sceneId=" + sceneId +
        ", path=" + path +
        ", title=" + title +
        ", parentId=" + parentId +
        ", parentIds=" + parentIds +
        ", hidden=" + hidden +
        ", sort=" + sort +
        ", icon=" + icon +
        ", redirect=" + redirect +
        ", cacheable=" + cacheable +
        ", requireAuth=" + requireAuth +
        ", component=" + component +
        ", remarks=" + remarks +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", delFlag=" + delFlag +
        "}";
    }
}
