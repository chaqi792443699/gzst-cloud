package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
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
 * @since 2019-06-04
 */
@TableName("sys_user_info1")
public class SysUserInfo1 extends SysUserInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 所属用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 常用联系电话
     */
    @TableField("contact_phone")
    private String contactPhone;

    /**
     * 性别(1男2女）
     */
    @TableField("sex")
    private String sex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private String birthday;

    /**
     * qq
     */
    @TableField("qq")
    private String qq;

    /**
     * email
     */
    @TableField("email")
    private String email;

    /**
     * 政治面貌
     */
    @TableField("politics_status")
    private String politicsStatus;

    /**
     * 学历
     */
    @TableField("education")
    private String education;

    /**
     * 学位
     */
    @TableField("degree")
    private String degree;

    /**
     * 职称级别
     */
    @TableField("professional_grade")
    private String professionalGrade;

    /**
     * 民族
     */
    @TableField("nation")
    private String nation;

    /**
     * 从事专业
     */
    @TableField("major")
    private String major;

    /**
     * 职务
     */
    @TableField("duty")
    private String duty;

    /**
     * 地区
     */
    @TableField("region")
    private String region;

    @TableField("address")
    private String address;

    @TableField("create_by")
    private String createBy;

    @TableField("create_date")
    private Date createDate;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_date")
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getProfessionalGrade() {
        return professionalGrade;
    }

    public void setProfessionalGrade(String professionalGrade) {
        this.professionalGrade = professionalGrade;
    }
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
    public String getCreateBy() {
        return createBy;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "SysUserInfo1{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", contactPhone=" + contactPhone +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", qq=" + qq +
        ", email=" + email +
        ", politicsStatus=" + politicsStatus +
        ", education=" + education +
        ", degree=" + degree +
        ", professionalGrade=" + professionalGrade +
        ", nation=" + nation +
        ", major=" + major +
        ", duty=" + duty +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        "}";
    }
}
