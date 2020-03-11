package cn.gov.gzst.admin.entity;

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
 * @since 2019-06-04
 */
@TableName("sys_user_info2")
public class SysUserInfo2 extends SysUserInfo {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 所属用户ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 单位名称
     */
    @TableField("name")
    private String name;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 机构法人
     */
    @TableField("legal_person")
    private String legalPerson;

    /**
     * 机构类型
     */
    @TableField("type")
    private String type;

    /**
     * 机构所在地
     */
    @TableField("region")
    private String region;

    /**
     * 机构地址
     */
    @TableField("address")
    private String address;

    /**
     * 机构邮编
     */
    @TableField("post_code")
    private String postCode;

    /**
     * 联系人
     */
    @TableField("link_man")
    private String linkMan;

    /**
     * 学位
     */
    @TableField("link_phone")
    private String linkPhone;

    /**
     * 企业邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 机构传真
     */
    @TableField("fax")
    private String fax;

    /**
     * 开户行
     */
    @TableField("bank_name")
    private String bankName;

    /**
     * 银行账号名称
     */
    @TableField("bank_account")
    private String bankAccount;

    /**
     * 银行账号
     */
    @TableField("bank_number")
    private String bankNumber;

    /**
     * 财务人员
     */
    @TableField("financial_staff_name")
    private String financialStaffName;

    /**
     * 财务电话
     */
    @TableField("financial_staff_phone")
    private String financialStaffPhone;

    @TableField("create_by")
    private String createBy;

    @TableField("create_date")
    private Date createDate;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_date")
    private Date updateDate;

    /**
     * 法人身份证号码
     */
    @TableField("legalPersonIdcard")
    private String legalPersonIdcard;

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
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }
    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }
    public String getFinancialStaffName() {
        return financialStaffName;
    }

    public void setFinancialStaffName(String financialStaffName) {
        this.financialStaffName = financialStaffName;
    }
    public String getFinancialStaffPhone() {
        return financialStaffPhone;
    }

    public void setFinancialStaffPhone(String financialStaffPhone) {
        this.financialStaffPhone = financialStaffPhone;
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
    public String getLegalPersonIdcard() {
        return legalPersonIdcard;
    }

    public void setLegalPersonIdcard(String legalPersonIdcard) {
        this.legalPersonIdcard = legalPersonIdcard;
    }

    @Override
    public String toString() {
        return "SysUserInfo2{" +
        "id=" + id +
        ", userId=" + userId +
        ", name=" + name +
        ", phone=" + phone +
        ", legalPerson=" + legalPerson +
        ", type=" + type +
        ", region=" + region +
        ", address=" + address +
        ", postCode=" + postCode +
        ", linkMan=" + linkMan +
        ", linkPhone=" + linkPhone +
        ", email=" + email +
        ", fax=" + fax +
        ", bankName=" + bankName +
        ", bankAccount=" + bankAccount +
        ", bankNumber=" + bankNumber +
        ", financialStaffName=" + financialStaffName +
        ", financialStaffPhone=" + financialStaffPhone +
        ", createBy=" + createBy +
        ", createDate=" + createDate +
        ", updateBy=" + updateBy +
        ", updateDate=" + updateDate +
        ", legalPersonIdcard=" + legalPersonIdcard +
        "}";
    }
}
