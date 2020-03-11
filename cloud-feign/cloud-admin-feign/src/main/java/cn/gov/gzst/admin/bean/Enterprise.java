package cn.gov.gzst.admin.bean;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.entity
 * @title: 企业表实体
 * @description: 企业表实体
 * @author: jianliaoliang
 * @date: 2018-05-06 16:14:43
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@SuppressWarnings("serial")
public class Enterprise extends AbstractEntity<String> {

    /**id*/
	private String id;

	private String parentId; // 父编号
    /**企业名称*/
	private String name;
    /**enterprise_type*/
	private String enterpriseType;
	/**单位级别*/
	private String enterpriseLevel;
	/**是否科技管理部门*/
	private String isTechnologyDepartment = "0";
	/**地区编码*/
	private String  manageLocationCode;
	/**地区编码*/
	private String manageLocationCodeLabel;
    /**统一社会信用代码*/
	private String unifiedSocialCreditcode;
    /**法人*/
	private String legalPerson;
    /**注册资本*/
	private String registeredCapital;
    /**成立日期*/
	@JSONField(format="yyyy-MM-dd")
	private Date registerDate;
    /**营业期限开始*/
	private String validity;
	/**公司地址*/
	private String address;
	/**单位邮箱*/
	private String email;
	/**单位电话*/
	private String phone;
	/**邮编*/
	private String zipCode;
	/**单位传真*/
	private String fax;
	/**单位传真（开户行）开户行*/
	private String bankName;
	/**银行帐号名称*/
	private String bankAccount;
	/**银行帐号*/
	private String bankNumber;
	/**（财务信息）财务人员姓名*/
	private String financialStaffName;
	/**（财务信息）财务人员电话*/
	private String financialStaffPhone;

	/**地区编码*/
    private String locationCode;
    /**地区名称*/
	private String locationCodeLabel;
    /**经营范围*/
	private String businessScope;
    /**主导产品**/
    private String leadingProduct;
	/**规模**/
    private String scale;
	private String scaleLabel;
	/**政治面貌**/
    private String politicsStatus;
	/**学历**/
    private String education;
	/**毕业院校**/
    private String graduateInstitution;
	/**是否实名认证*/
	@JSONField(name = "isAuth")
	private String isAuth = "0";
	/**是否第三方服务机构*/
	private String isThirdParty = "0";
	protected String createBy; // 创建者
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	protected Date createDate; // 创建日期
	@JSONField(name = "isCorporation")
	private String isCorporation;
	private Boolean enable;
	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  企业名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  企业名称
	 */
	public void setName(String name){
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取  enterpriseType
	 *@return String  enterprise_type
	 */
	public String getEnterpriseType(){
		return this.enterpriseType;
	}

	/**
	 * 设置  enterpriseType
	 *@param enterpriseType  enterprise_type
	 */
	public void setEnterpriseType(String enterpriseType){
		this.enterpriseType = enterpriseType;
	}

	public String getEnterpriseLevel() {
		return enterpriseLevel;
	}

	public void setEnterpriseLevel(String enterpriseLevel) {
		this.enterpriseLevel = enterpriseLevel;
	}

	public String getIsTechnologyDepartment() {
		return isTechnologyDepartment;
	}

	public void setIsTechnologyDepartment(String isTechnologyDepartment) {
		this.isTechnologyDepartment = isTechnologyDepartment;
	}

	/**
	 * 获取  unifiedSocialCreditcode
	 *@return String  统一社会信用代码
	 */
	public String getUnifiedSocialCreditcode(){
		return this.unifiedSocialCreditcode;
	}

	/**
	 * 设置  unifiedSocialCreditcode
	 *@param unifiedSocialCreditcode  统一社会信用代码
	 */
	public void setUnifiedSocialCreditcode(String unifiedSocialCreditcode){
		this.unifiedSocialCreditcode = unifiedSocialCreditcode;
	}
	/**
	 * 获取  legalPerson
	 *@return String  法人
	 */
	public String getLegalPerson(){
		return this.legalPerson;
	}

	/**
	 * 设置  legalPerson
	 *@param legalPerson  法人
	 */
	public void setLegalPerson(String legalPerson){
		this.legalPerson = legalPerson;
	}
	/**
	 * 获取  registeredCapital
	 *@return String  注册资本
	 */
	public String getRegisteredCapital(){
		return this.registeredCapital;
	}

	/**
	 * 设置  registeredCapital
	 *@param registeredCapital  注册资本
	 */
	public void setRegisteredCapital(String registeredCapital){
		this.registeredCapital = registeredCapital;
	}
	/**
	 * 获取  registerDate
	 *@return Date  成立日期
	 */
	public Date getRegisterDate(){
		return this.registerDate;
	}

	/**
	 * 设置  registerDate
	 *@param registerDate  成立日期
	 */
	public void setRegisterDate(Date registerDate){
		this.registerDate = registerDate;
	}
	/**
	 * 获取  validity
	 *@return String  营业期限开始
	 */
	public String getValidity(){
		return this.validity;
	}

	/**
	 * 设置  validity
	 *@param validity  营业期限开始
	 */
	public void setValidity(String validity){
		this.validity = validity;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取  businessScope
	 *@return String  经营范围
	 */
	public String getBusinessScope(){
		return this.businessScope;
	}

	/**
	 * 设置  businessScope
	 *@param businessScope  经营范围
	 */
	public void setBusinessScope(String businessScope){
		this.businessScope = businessScope;
	}

	public String getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}

	public String getIsThirdParty() {
		return isThirdParty;
	}

	public void setIsThirdParty(String isThirdParty) {
		this.isThirdParty = isThirdParty;
	}

	public String getLeadingProduct() {
		return leadingProduct;
	}

	public void setLeadingProduct(String leadingProduct) {
		this.leadingProduct = leadingProduct;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	/*public String getScaleLabel() {
		if (!StringUtils.isEmpty(scale)){
			this.scaleLabel = TreeUtils.getTreeLabel("QYGM",scale,scale);
		}
		return scaleLabel;
	}*/

	public void setScaleLabel(String scaleLabel) {
		this.scaleLabel = scaleLabel;
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

	public String getGraduateInstitution() {
		return graduateInstitution;
	}

	public void setGraduateInstitution(String graduateInstitution) {
		this.graduateInstitution = graduateInstitution;
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

	public String getLocationCodeLabel() {

		return locationCodeLabel;
	}

	public void setLocationCodeLabel(String locationCodeLabel) {
		this.locationCodeLabel = locationCodeLabel;
	}

	public String getManageLocationCode() {
		return manageLocationCode;
	}

	public void setManageLocationCode(String manageLocationCode) {
		this.manageLocationCode = manageLocationCode;
	}

	public String getManageLocationCodeLabel() {
		return manageLocationCodeLabel;
	}

	public void setManageLocationCodeLabel(String manageLocationCodeLabel) {
		this.manageLocationCodeLabel = manageLocationCodeLabel;
	}

	public String getScaleLabel() {
		return scaleLabel;
	}

	public String getIsCorporation() {
		return isCorporation;
	}

	public void setIsCorporation(String isCorporation) {
		this.isCorporation = isCorporation;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}