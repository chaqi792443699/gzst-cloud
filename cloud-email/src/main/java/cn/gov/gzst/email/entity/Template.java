package cn.gov.gzst.email.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.utils.AppUtils;
import cn.gov.gzst.email.utils.ConfigUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.email.entity
 * @title: 邮件模板实体
 * @description: 邮件模板实体
 * @author: jianliaoliang
 * @date: 2018-04-24 11:19:30
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("email_template")
@SuppressWarnings("serial")
public class Template extends AbstractEntity<String> {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 模版名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 模版编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 业务类型
     */
    @TableField(value = "business_type")
    private String businessType;
    /**
     * 模版主题
     */
    @TableField(value = "template_subject")
    private String templateSubject;
    /**
     * 模版内容
     */
    @TableField(value = "template_content")
    private String templateContent;
    /**
     * 备注信息
     */
    @TableField(value = "remarks")
    private String remarks;
    /**
     * 更新者
     */
    @TableField(value = "update_by")
    private String updateBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;
    /**
     * 删除标记（0：正常；1：删除）
     */
    @TableField(value = "del_flag")
    private String delFlag;
    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private String createBy;
    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    private Date updateDate;

    @TableField(value = "config_id")
    private String configId;

    @TableField(exist = false)
    private String configName;

    @TableField(value = "app_id")
    protected String appId; // 应用

    @TableField(exist = false)
    private String appName;

    /**
     * 获取  id
     *
     * @return String  主键
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置  id
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取  name
     *
     * @return String  模版名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置  name
     *
     * @param name 模版名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取  code
     *
     * @return String  模版编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置  code
     *
     * @param code 模版编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取  businessType
     *
     * @return String  业务类型
     */
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * 设置  businessType
     *
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取  templateSubject
     *
     * @return String  模版主题
     */
    public String getTemplateSubject() {
        return this.templateSubject;
    }

    /**
     * 设置  templateSubject
     *
     * @param templateSubject 模版主题
     */
    public void setTemplateSubject(String templateSubject) {
        this.templateSubject = templateSubject;
    }

    /**
     * 获取  templateContent
     *
     * @return String  模版内容
     */
    public String getTemplateContent() {
        return this.templateContent;
    }

    /**
     * 设置  templateContent
     *
     * @param templateContent 模版内容
     */
    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    /**
     * 获取  remarks
     *
     * @return String  备注信息
     */
    public String getRemarks() {
        return this.remarks;
    }

    /**
     * 设置  remarks
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取  updateBy
     *
     * @return String  更新者
     */
    public String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 设置  updateBy
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取  createDate
     *
     * @return String  创建时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置  createDate
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取  delFlag
     *
     * @return String  删除标记（0：正常；1：删除）
     */
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
     * 设置  delFlag
     *
     * @param delFlag 删除标记（0：正常；1：删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取  createBy
     *
     * @return String  创建者
     */
    public String getCreateBy() {
        return this.createBy;
    }

    /**
     * 设置  createBy
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取  updateDate
     *
     * @return String  更新时间
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 设置  updateDate
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getConfigName() {
        if (!StringUtils.isEmpty(configId) && ConfigUtils.getConfig(configId) != null) {
            this.configName = ConfigUtils.getConfig(configId).getName();
        }
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * @return
     */
    public String getAppName() {
        if (!StringUtils.isEmpty(appId) && AppUtils.getApp(appId) != null) {
            appName = AppUtils.getApp(appId).getTitle();
        }
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

}