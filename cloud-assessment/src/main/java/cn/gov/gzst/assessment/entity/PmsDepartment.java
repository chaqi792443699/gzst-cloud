package cn.gov.gzst.assessment.entity;

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
 * @author wuzhengjun
 * @since 2019-04-09
 */
@TableName("pms_department")
public class PmsDepartment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 处室id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 处室名称
     */
    @TableField("name")
    private String name;

    @TableField("departmentcode")
    private String departmentcode;

    @TableField("adminname")
    private String adminname;

    @TableField("admincode")
    private String admincode;

    @TableField("leader")
    private String leader;

    @TableField("shortname")
    private String shortname;

    @TableField("memo")
    private String memo;

    @TableField("enterpriseid")
    private String enterpriseid;

    @TableField("enable")
    private String enable;

    @TableField("isbusiness")
    private String isbusiness;

    @TableField("islead")
    private String islead;

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
    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode;
    }
    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    public String getAdmincode() {
        return admincode;
    }

    public void setAdmincode(String admincode) {
        this.admincode = admincode;
    }
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
    public String getIsbusiness() {
        return isbusiness;
    }

    public void setIsbusiness(String isbusiness) {
        this.isbusiness = isbusiness;
    }
    public String getIslead() {
        return islead;
    }

    public void setIslead(String islead) {
        this.islead = islead;
    }

    @Override
    public String toString() {
        return "PmsDepartment{" +
        "id=" + id +
        ", name=" + name +
        ", departmentcode=" + departmentcode +
        ", adminname=" + adminname +
        ", admincode=" + admincode +
        ", leader=" + leader +
        ", shortname=" + shortname +
        ", memo=" + memo +
        ", enterpriseid=" + enterpriseid +
        ", enable=" + enable +
        ", isbusiness=" + isbusiness +
        ", islead=" + islead +
        "}";
    }
}
