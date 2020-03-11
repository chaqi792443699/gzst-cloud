package cn.gov.gzst.admin.bean;

import java.io.Serializable;

/**
 * 权限实体
 */
public class SecAuthority implements Serializable {

    private String id;
    private String name;// 角色名称
    private String remark;// 说明

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
