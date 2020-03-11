package cn.gov.gzst.common.aip.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.baidu.aip.bean
 * @title:
 * @description: 身份证正面
 * @author: jianliaoliang
 * @date: 2018/4/21 19:01
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class IdcardFront  implements Serializable {
    /**姓名*/
    private String name;
    /**性别*/
    private String sex;
    /**民族*/
    private String nation;
    /**出生日期*/
    private Date birthdate;
    /**家庭住址*/
    private String address;
    /**身份证号码*/
    private String idcard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
