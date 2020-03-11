package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 合同-项目负责人
 * @Description: 合同-项目负责人
 * @author 李佳芹
 * @date 2017-09-11 15:57:44
 * @version V1.0   
 *
 */
@TableName("PACT_PROJECTPARTY")
@SuppressWarnings("serial")
public class PactProjectparty extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**NAME*/
    @TableField(value = "name")
	private String name;
    /**SEX*/
    @TableField(value = "sex")
	private String sex;
    /**证件名称*/
    @TableField(value = "certificatename")
	private String certificatename;
    /**证件号码*/
    @TableField(value = "certificatenumber")
	private String certificatenumber;
    /**BIRTHDAY*/
    @TableField(value = "birthday")
	private Date birthday;
    /**固定电话*/
    @TableField(value = "telphone")
	private String telphone;
    /**专业技术职称*/
    @TableField(value = "professionalpost")
	private String professionalpost;
    /**从事专业*/
    @TableField(value = "workforprofession")
	private String workforprofession;
    /**学历*/
    @TableField(value = "education")
	private String education;
    /**学位*/
    @TableField(value = "degree")
	private String degree;
    /**工作单位*/
    @TableField(value = "workplace")
	private String workplace;
    /**EMAIL*/
    @TableField(value = "email")
	private String email;
    /**项目分工 true为项目负责人 principal为其他负责人*/
    @TableField(value = "programrole")
	private String programrole;
    /**是否企业人员*/
    @TableField(value = "enterpriseid")
	private String enterpriseid;
    /**人员id*/
    @TableField(value = "enterprisepartyid")
	private String enterprisepartyid;
    /**项目id*/
    @TableField(value = "projectbaseid")
	private String projectbaseid;
    /**邮政编码*/
    @TableField(value = "postalcode")
	private String postalcode;
    /**通讯地址*/
    @TableField(value = "postaladdress")
	private String postaladdress;
    /**法人代码*/
    @TableField(value = "legalcode")
	private String legalcode;
    /**年参加项目时间(月）*/
    @TableField(value = "workday")
	private Double workday;
    /**人员信息ID*/
    @TableField(value = "userinfoid")
	private String userinfoid;
    /**SEQ*/
    @TableField(value = "seq")
	private Double seq;
    /**PARTYNOTE*/
    @TableField(value = "partynote")
	private Double partynote;
    /**加入本项目起止年月*/
    @TableField(value = "joinstarttime")
	private Date joinstarttime;
    /**加入本项目起止年月*/
    @TableField(value = "joinendtime")
	private Date joinendtime;
    /**项目预算申报ID*/
    @TableField(value = "xmyssbid")
	private String xmyssbid;
    /**参与项目研发时间（月）*/
    @TableField(value = "createtime")
	private Double createtime;
    /**月劳务费*/
    @TableField(value = "createlaborfee")
	private Double createlaborfee;
    /**合计劳务费*/
    @TableField(value = "totallabor")
	private Double totallabor;
    /**TOTALPEOPLE*/
    @TableField(value = "totalpeople")
	private Double totalpeople;
    /**TOTALMONEY*/
    @TableField(value = "totalmoney")
	private Double totalmoney;
    /**PTYPE*/
    @TableField(value = "ptype")
	private String ptype;
    /**出生地*/
    @TableField(value = "birthplace")
	private String birthplace;
    /**民族*/
    @TableField(value = "nation")
	private String nation;
    /**政治面貌*/
    @TableField(value = "political")
	private String political;
    /**技术职称*/
    @TableField(value = "technicaltitle")
	private String technicaltitle;
    /**行政职务*/
    @TableField(value = "administrativeduty")
	private String administrativeduty;
    /**所学专业*/
    @TableField(value = "major")
	private String major;
    /**毕业学校*/
    @TableField(value = "graduateschool")
	private String graduateschool;
    /**毕业时间*/
    @TableField(value = "graduatetime")
	private Date graduatetime;
    /**曾获科技奖励情况*/
    @TableField(value = "everaward")
	private String everaward;
    /**JXID*/
    @TableField(value = "jxid")
	private String jxid;
    /**NOWENGAGED*/
    @TableField(value = "nowengaged")
	private String nowengaged;
    /**CONTRIBUTION*/
    @TableField(value = "contribution")
	private String contribution;
    /**移动电话*/
    @TableField(value = "mobilephone")
	private String mobilephone;
    /**SIGNATURE*/
    @TableField(value = "signature")
	private String signature;
    /**项目分工*/
    @TableField(value = "xmfg")
	private String xmfg;
    /**民族名称*/
    @TableField(value = "nationname")
	private String nationname;
    /**是否在系统中*/
    @TableField(value = "issys")
	private String issys;
    /**是否为项目填报人*/
    @TableField(value = "iswrite")
	private String iswrite;
    /**是否为责任人*/
    @TableField(value = "isleader")
	private String isleader;
    /**合同ID*/
    @TableField(value = "pactid")
	private String pactid;
    /**职务*/
    @TableField(value = "positiontitle")
	private String positiontitle;
    /**年龄*/
    @TableField(value = "age")
	private String age;
    /**传真*/
    @TableField(value = "fax")
	private String fax;
	
	/**
	 * 获取  id
	 *@return: String  ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return: String  NAME
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  NAME
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  sex
	 *@return: String  SEX
	 */
	public String getSex(){
		return this.sex;
	}

	/**
	 * 设置  sex
	 *@param: sex  SEX
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 * 获取  certificatename
	 *@return: String  证件名称
	 */
	public String getCertificatename(){
		return this.certificatename;
	}

	/**
	 * 设置  certificatename
	 *@param: certificatename  证件名称
	 */
	public void setCertificatename(String certificatename){
		this.certificatename = certificatename;
	}
	/**
	 * 获取  certificatenumber
	 *@return: String  证件号码
	 */
	public String getCertificatenumber(){
		return this.certificatenumber;
	}

	/**
	 * 设置  certificatenumber
	 *@param: certificatenumber  证件号码
	 */
	public void setCertificatenumber(String certificatenumber){
		this.certificatenumber = certificatenumber;
	}
	/**
	 * 获取  birthday
	 *@return: Date  BIRTHDAY
	 */
	public Date getBirthday(){
		return this.birthday;
	}

	/**
	 * 设置  birthday
	 *@param: birthday  BIRTHDAY
	 */
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	/**
	 * 获取  telphone
	 *@return: String  固定电话
	 */
	public String getTelphone(){
		return this.telphone;
	}

	/**
	 * 设置  telphone
	 *@param: telphone  固定电话
	 */
	public void setTelphone(String telphone){
		this.telphone = telphone;
	}
	/**
	 * 获取  professionalpost
	 *@return: String  专业技术职称
	 */
	public String getProfessionalpost(){
		return this.professionalpost;
	}

	/**
	 * 设置  professionalpost
	 *@param: professionalpost  专业技术职称
	 */
	public void setProfessionalpost(String professionalpost){
		this.professionalpost = professionalpost;
	}
	/**
	 * 获取  workforprofession
	 *@return: String  从事专业
	 */
	public String getWorkforprofession(){
		return this.workforprofession;
	}

	/**
	 * 设置  workforprofession
	 *@param: workforprofession  从事专业
	 */
	public void setWorkforprofession(String workforprofession){
		this.workforprofession = workforprofession;
	}
	/**
	 * 获取  education
	 *@return: String  学历
	 */
	public String getEducation(){
		return this.education;
	}

	/**
	 * 设置  education
	 *@param: education  学历
	 */
	public void setEducation(String education){
		this.education = education;
	}
	/**
	 * 获取  degree
	 *@return: String  学位
	 */
	public String getDegree(){
		return this.degree;
	}

	/**
	 * 设置  degree
	 *@param: degree  学位
	 */
	public void setDegree(String degree){
		this.degree = degree;
	}
	/**
	 * 获取  workplace
	 *@return: String  工作单位
	 */
	public String getWorkplace(){
		return this.workplace;
	}

	/**
	 * 设置  workplace
	 *@param: workplace  工作单位
	 */
	public void setWorkplace(String workplace){
		this.workplace = workplace;
	}
	/**
	 * 获取  email
	 *@return: String  EMAIL
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * 设置  email
	 *@param: email  EMAIL
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * 获取  programrole
	 *@return: String  项目分工 true为项目负责人 principal为其他负责人
	 */
	public String getProgramrole(){
		return this.programrole;
	}

	/**
	 * 设置  programrole
	 *@param: programrole  项目分工 true为项目负责人 principal为其他负责人
	 */
	public void setProgramrole(String programrole){
		this.programrole = programrole;
	}
	/**
	 * 获取  enterpriseid
	 *@return: String  是否企业人员
	 */
	public String getEnterpriseid(){
		return this.enterpriseid;
	}

	/**
	 * 设置  enterpriseid
	 *@param: enterpriseid  是否企业人员
	 */
	public void setEnterpriseid(String enterpriseid){
		this.enterpriseid = enterpriseid;
	}
	/**
	 * 获取  enterprisepartyid
	 *@return: String  人员id
	 */
	public String getEnterprisepartyid(){
		return this.enterprisepartyid;
	}

	/**
	 * 设置  enterprisepartyid
	 *@param: enterprisepartyid  人员id
	 */
	public void setEnterprisepartyid(String enterprisepartyid){
		this.enterprisepartyid = enterprisepartyid;
	}
	/**
	 * 获取  projectbaseid
	 *@return: String  项目id
	 */
	public String getProjectbaseid(){
		return this.projectbaseid;
	}

	/**
	 * 设置  projectbaseid
	 *@param: projectbaseid  项目id
	 */
	public void setProjectbaseid(String projectbaseid){
		this.projectbaseid = projectbaseid;
	}
	/**
	 * 获取  postalcode
	 *@return: String  邮政编码
	 */
	public String getPostalcode(){
		return this.postalcode;
	}

	/**
	 * 设置  postalcode
	 *@param: postalcode  邮政编码
	 */
	public void setPostalcode(String postalcode){
		this.postalcode = postalcode;
	}
	/**
	 * 获取  postaladdress
	 *@return: String  通讯地址
	 */
	public String getPostaladdress(){
		return this.postaladdress;
	}

	/**
	 * 设置  postaladdress
	 *@param: postaladdress  通讯地址
	 */
	public void setPostaladdress(String postaladdress){
		this.postaladdress = postaladdress;
	}
	/**
	 * 获取  legalcode
	 *@return: String  法人代码
	 */
	public String getLegalcode(){
		return this.legalcode;
	}

	/**
	 * 设置  legalcode
	 *@param: legalcode  法人代码
	 */
	public void setLegalcode(String legalcode){
		this.legalcode = legalcode;
	}
	/**
	 * 获取  workday
	 *@return: Double  年参加项目时间(月）
	 */
	public Double getWorkday(){
		return this.workday;
	}

	/**
	 * 设置  workday
	 *@param: workday  年参加项目时间(月）
	 */
	public void setWorkday(Double workday){
		this.workday = workday;
	}
	/**
	 * 获取  userinfoid
	 *@return: String  人员信息ID
	 */
	public String getUserinfoid(){
		return this.userinfoid;
	}

	/**
	 * 设置  userinfoid
	 *@param: userinfoid  人员信息ID
	 */
	public void setUserinfoid(String userinfoid){
		this.userinfoid = userinfoid;
	}
	/**
	 * 获取  seq
	 *@return: Double  SEQ
	 */
	public Double getSeq(){
		return this.seq;
	}

	/**
	 * 设置  seq
	 *@param: seq  SEQ
	 */
	public void setSeq(Double seq){
		this.seq = seq;
	}
	/**
	 * 获取  partynote
	 *@return: Double  PARTYNOTE
	 */
	public Double getPartynote(){
		return this.partynote;
	}

	/**
	 * 设置  partynote
	 *@param: partynote  PARTYNOTE
	 */
	public void setPartynote(Double partynote){
		this.partynote = partynote;
	}
	/**
	 * 获取  joinstarttime
	 *@return: Date  加入本项目起止年月
	 */
	public Date getJoinstarttime(){
		return this.joinstarttime;
	}

	/**
	 * 设置  joinstarttime
	 *@param: joinstarttime  加入本项目起止年月
	 */
	public void setJoinstarttime(Date joinstarttime){
		this.joinstarttime = joinstarttime;
	}
	/**
	 * 获取  joinendtime
	 *@return: Date  加入本项目起止年月
	 */
	public Date getJoinendtime(){
		return this.joinendtime;
	}

	/**
	 * 设置  joinendtime
	 *@param: joinendtime  加入本项目起止年月
	 */
	public void setJoinendtime(Date joinendtime){
		this.joinendtime = joinendtime;
	}
	/**
	 * 获取  xmyssbid
	 *@return: String  项目预算申报ID
	 */
	public String getXmyssbid(){
		return this.xmyssbid;
	}

	/**
	 * 设置  xmyssbid
	 *@param: xmyssbid  项目预算申报ID
	 */
	public void setXmyssbid(String xmyssbid){
		this.xmyssbid = xmyssbid;
	}
	/**
	 * 获取  createtime
	 *@return: Double  参与项目研发时间（月）
	 */
	public Double getCreatetime(){
		return this.createtime;
	}

	/**
	 * 设置  createtime
	 *@param: createtime  参与项目研发时间（月）
	 */
	public void setCreatetime(Double createtime){
		this.createtime = createtime;
	}
	/**
	 * 获取  createlaborfee
	 *@return: Double  月劳务费
	 */
	public Double getCreatelaborfee(){
		return this.createlaborfee;
	}

	/**
	 * 设置  createlaborfee
	 *@param: createlaborfee  月劳务费
	 */
	public void setCreatelaborfee(Double createlaborfee){
		this.createlaborfee = createlaborfee;
	}
	/**
	 * 获取  totallabor
	 *@return: Double  合计劳务费
	 */
	public Double getTotallabor(){
		return this.totallabor;
	}

	/**
	 * 设置  totallabor
	 *@param: totallabor  合计劳务费
	 */
	public void setTotallabor(Double totallabor){
		this.totallabor = totallabor;
	}
	/**
	 * 获取  totalpeople
	 *@return: Double  TOTALPEOPLE
	 */
	public Double getTotalpeople(){
		return this.totalpeople;
	}

	/**
	 * 设置  totalpeople
	 *@param: totalpeople  TOTALPEOPLE
	 */
	public void setTotalpeople(Double totalpeople){
		this.totalpeople = totalpeople;
	}
	/**
	 * 获取  totalmoney
	 *@return: Double  TOTALMONEY
	 */
	public Double getTotalmoney(){
		return this.totalmoney;
	}

	/**
	 * 设置  totalmoney
	 *@param: totalmoney  TOTALMONEY
	 */
	public void setTotalmoney(Double totalmoney){
		this.totalmoney = totalmoney;
	}
	/**
	 * 获取  ptype
	 *@return: String  PTYPE
	 */
	public String getPtype(){
		return this.ptype;
	}

	/**
	 * 设置  ptype
	 *@param: ptype  PTYPE
	 */
	public void setPtype(String ptype){
		this.ptype = ptype;
	}
	/**
	 * 获取  birthplace
	 *@return: String  出生地
	 */
	public String getBirthplace(){
		return this.birthplace;
	}

	/**
	 * 设置  birthplace
	 *@param: birthplace  出生地
	 */
	public void setBirthplace(String birthplace){
		this.birthplace = birthplace;
	}
	/**
	 * 获取  nation
	 *@return: String  民族
	 */
	public String getNation(){
		return this.nation;
	}

	/**
	 * 设置  nation
	 *@param: nation  民族
	 */
	public void setNation(String nation){
		this.nation = nation;
	}
	/**
	 * 获取  political
	 *@return: String  政治面貌
	 */
	public String getPolitical(){
		return this.political;
	}

	/**
	 * 设置  political
	 *@param: political  政治面貌
	 */
	public void setPolitical(String political){
		this.political = political;
	}
	/**
	 * 获取  technicaltitle
	 *@return: String  技术职称
	 */
	public String getTechnicaltitle(){
		return this.technicaltitle;
	}

	/**
	 * 设置  technicaltitle
	 *@param: technicaltitle  技术职称
	 */
	public void setTechnicaltitle(String technicaltitle){
		this.technicaltitle = technicaltitle;
	}
	/**
	 * 获取  administrativeduty
	 *@return: String  行政职务
	 */
	public String getAdministrativeduty(){
		return this.administrativeduty;
	}

	/**
	 * 设置  administrativeduty
	 *@param: administrativeduty  行政职务
	 */
	public void setAdministrativeduty(String administrativeduty){
		this.administrativeduty = administrativeduty;
	}
	/**
	 * 获取  major
	 *@return: String  所学专业
	 */
	public String getMajor(){
		return this.major;
	}

	/**
	 * 设置  major
	 *@param: major  所学专业
	 */
	public void setMajor(String major){
		this.major = major;
	}
	/**
	 * 获取  graduateschool
	 *@return: String  毕业学校
	 */
	public String getGraduateschool(){
		return this.graduateschool;
	}

	/**
	 * 设置  graduateschool
	 *@param: graduateschool  毕业学校
	 */
	public void setGraduateschool(String graduateschool){
		this.graduateschool = graduateschool;
	}
	/**
	 * 获取  graduatetime
	 *@return: Date  毕业时间
	 */
	public Date getGraduatetime(){
		return this.graduatetime;
	}

	/**
	 * 设置  graduatetime
	 *@param: graduatetime  毕业时间
	 */
	public void setGraduatetime(Date graduatetime){
		this.graduatetime = graduatetime;
	}
	/**
	 * 获取  everaward
	 *@return: String  曾获科技奖励情况
	 */
	public String getEveraward(){
		return this.everaward;
	}

	/**
	 * 设置  everaward
	 *@param: everaward  曾获科技奖励情况
	 */
	public void setEveraward(String everaward){
		this.everaward = everaward;
	}
	/**
	 * 获取  jxid
	 *@return: String  JXID
	 */
	public String getJxid(){
		return this.jxid;
	}

	/**
	 * 设置  jxid
	 *@param: jxid  JXID
	 */
	public void setJxid(String jxid){
		this.jxid = jxid;
	}
	/**
	 * 获取  nowengaged
	 *@return: String  NOWENGAGED
	 */
	public String getNowengaged(){
		return this.nowengaged;
	}

	/**
	 * 设置  nowengaged
	 *@param: nowengaged  NOWENGAGED
	 */
	public void setNowengaged(String nowengaged){
		this.nowengaged = nowengaged;
	}
	/**
	 * 获取  contribution
	 *@return: String  CONTRIBUTION
	 */
	public String getContribution(){
		return this.contribution;
	}

	/**
	 * 设置  contribution
	 *@param: contribution  CONTRIBUTION
	 */
	public void setContribution(String contribution){
		this.contribution = contribution;
	}
	/**
	 * 获取  mobilephone
	 *@return: String  移动电话
	 */
	public String getMobilephone(){
		return this.mobilephone;
	}

	/**
	 * 设置  mobilephone
	 *@param: mobilephone  移动电话
	 */
	public void setMobilephone(String mobilephone){
		this.mobilephone = mobilephone;
	}
	/**
	 * 获取  signature
	 *@return: String  SIGNATURE
	 */
	public String getSignature(){
		return this.signature;
	}

	/**
	 * 设置  signature
	 *@param: signature  SIGNATURE
	 */
	public void setSignature(String signature){
		this.signature = signature;
	}
	/**
	 * 获取  xmfg
	 *@return: String  项目分工
	 */
	public String getXmfg(){
		return this.xmfg;
	}

	/**
	 * 设置  xmfg
	 *@param: xmfg  项目分工
	 */
	public void setXmfg(String xmfg){
		this.xmfg = xmfg;
	}
	/**
	 * 获取  nationname
	 *@return: String  民族名称
	 */
	public String getNationname(){
		return this.nationname;
	}

	/**
	 * 设置  nationname
	 *@param: nationname  民族名称
	 */
	public void setNationname(String nationname){
		this.nationname = nationname;
	}
	/**
	 * 获取  issys
	 *@return: String  是否在系统中
	 */
	public String getIssys(){
		return this.issys;
	}

	/**
	 * 设置  issys
	 *@param: issys  是否在系统中
	 */
	public void setIssys(String issys){
		this.issys = issys;
	}
	/**
	 * 获取  iswrite
	 *@return: String  是否为项目填报人
	 */
	public String getIswrite(){
		return this.iswrite;
	}

	/**
	 * 设置  iswrite
	 *@param: iswrite  是否为项目填报人
	 */
	public void setIswrite(String iswrite){
		this.iswrite = iswrite;
	}
	/**
	 * 获取  isleader
	 *@return: String  是否为责任人
	 */
	public String getIsleader(){
		return this.isleader;
	}

	/**
	 * 设置  isleader
	 *@param: isleader  是否为责任人
	 */
	public void setIsleader(String isleader){
		this.isleader = isleader;
	}
	/**
	 * 获取  pactid
	 *@return: String  合同ID
	 */
	public String getPactid(){
		return this.pactid;
	}

	/**
	 * 设置  pactid
	 *@param: pactid  合同ID
	 */
	public void setPactid(String pactid){
		this.pactid = pactid;
	}
	/**
	 * 获取  positiontitle
	 *@return: String  职务
	 */
	public String getPositiontitle(){
		return this.positiontitle;
	}

	/**
	 * 设置  positiontitle
	 *@param: positiontitle  职务
	 */
	public void setPositiontitle(String positiontitle){
		this.positiontitle = positiontitle;
	}
	/**
	 * 获取  age
	 *@return: String  年龄
	 */
	public String getAge(){
		return this.age;
	}

	/**
	 * 设置  age
	 *@param: age  年龄
	 */
	public void setAge(String age){
		this.age = age;
	}
	/**
	 * 获取  fax
	 *@return: String  传真
	 */
	public String getFax(){
		return this.fax;
	}

	/**
	 * 设置  fax
	 *@param: fax  传真
	 */
	public void setFax(String fax){
		this.fax = fax;
	}
	
}
