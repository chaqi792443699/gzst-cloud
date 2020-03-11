package cn.gov.gzst.admin.bean;

import cn.gov.gzst.common.common.entity.AbstractEntity;

import java.io.Serializable;

/**
 * 角色实体
 */
@SuppressWarnings("serial")
public class Role extends AbstractEntity<String> {

    public static final Integer STATUS_LOCKED = -1;
    private String id;
    private String name;// 角色名称
    private String code;// 角色编码
    private Integer type;// 是否系统数据
    private String remarks;// 说明
    private Boolean enabled;//状态
    private Integer sort;//排序

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
