package cn.gzst.gov.cloud.gateway.entity;

import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.sso.server.entity
 * @title:
 * @description: 用户实体类
 * @author: jianliaoliang
 * @date: 2018/3/26 16:52
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class User implements Serializable {

    /**
     * 是否锁定（1：正常；-1：删除；0：锁定；）
     */
    public static final String STATUS_DELETE = "-1";
    public static final String STATUS_LOCKED = "0";
    public static final String STATUS_NORMAL = "1";

    private String id;
    // 姓名
    private String username;
    // 用户名
    private String realname;
    // 头像
    private String portrait;
    // 密码
    private String password;
    // 盐
    private String salt;
    // 邮件
    private String email;
    // 联系电话
    private String phone;
    //身份证号码
    private String idcard;


    /**
     * 系统用户的状态
     */
    private String status = STATUS_NORMAL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
