package cn.gov.gzst.sms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.sms.utils.AppUtils;
import cn.gov.gzst.sms.utils.ConfigUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @author jeeweb
 * @version V1.0
 * @Title: 短信模版
 * @Description: 短信模版
 * @date 2017-06-08 10:50:52
 */
@TableName("sms_model")
@SuppressWarnings("serial")
public class SmsModel extends AbstractEntity<String> {

    /**
     * 字段主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 模版编码
     */
    private String code;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 模版ID
     */
    private String templateId;
    /**
     * 模版内容
     */
    private String templateContent;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 删除标记（0：正常；1：删除）
     */
    private String delFlag;
    /**
     * 备注信息
     */
    private String remarks;
    @TableField(value = "config_id")
    private String configId;

    @TableField(exist = false)
    private String configName;

    @TableField(value = "app_id")
    protected String appId; // 应用

    @TableField(exist = false)
    private String appName;

    /**
     * 获取 id
     *
     * @return: String 字段主键
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param: id
     * 字段主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 name
     *
     * @return: String 模版名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 name
     *
     * @param: name
     * 模版名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 code
     *
     * @return: String 模版编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 code
     *
     * @param: code
     * 模版编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 businessType
     *
     * @return: String 业务类型
     */
    public String getBusinessType() {
        return this.businessType;
    }

    /**
     * 设置 businessType
     *
     * @param: businessType
     * 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取 templateId
     *
     * @return: String 模版ID
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * 设置 templateId
     *
     * @param: templateId
     * 模版ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取 templateContent
     *
     * @return: String 模版内容
     */
    public String getTemplateContent() {
        return this.templateContent;
    }

    /**
     * 设置 templateContent
     *
     * @param: templateContent
     * 模版内容
     */
    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    /**
     * 获取 createDate
     *
     * @return: Date 创建时间
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 设置 createDate
     *
     * @param: createDate
     * 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取 updateDate
     *
     * @return: Date 更新时间
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 设置 updateDate
     *
     * @param: updateDate
     * 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取 delFlag
     *
     * @return: String 删除标记（0：正常；1：删除）
     */
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
     * 设置 delFlag
     *
     * @param: delFlag
     * 删除标记（0：正常；1：删除）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取 remarks
     *
     * @return: String 备注信息
     */
    public String getRemarks() {
        return this.remarks;
    }

    /**
     * 设置 remarks
     *
     * @param: remarks
     * 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
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
