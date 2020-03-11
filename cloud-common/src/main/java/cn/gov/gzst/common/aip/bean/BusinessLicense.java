package cn.gov.gzst.common.aip.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.baidu.aip.bean
 * @title:
 * @description: 企业信息
 * @author: jianliaoliang
 * @date: 2018/4/21 18:58
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class BusinessLicense  implements Serializable {

    /**企业名称*/
    private String name;
    /**统一社会信用代码*/
    private String unifiedSocialCreditcode;
    /**注册资本*/
    private String registeredCapital;
    /**成立日期*/
    private Date registerDate;
    /**有效期*/
    private String validity;
    /**经营范围*/
    private String businessScope;
    /**经营范围*/
    private String legalPerson;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getUnifiedSocialCreditcode() {
        return unifiedSocialCreditcode;
    }

    public void setUnifiedSocialCreditcode(String unifiedSocialCreditcode) {
        this.unifiedSocialCreditcode = unifiedSocialCreditcode;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }
}
