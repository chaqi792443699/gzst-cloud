package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@TableName("pact_projectparty")
public class PactProjectparty extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 项目成员合同信息id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private String sex;

    /**
     * 证件名称
     */
    @TableField("certificatename")
    private String certificatename;

    /**
     * 证件号码
     */
    @TableField("certificatenumber")
    private String certificatenumber;

    @TableField("birthday")
    private Date birthday;

    /**
     * 固定电话
     */
    @TableField("telphone")
    private String telphone;

    /**
     * 专业技术职称
     */
    @TableField("professionalpost")
    private String professionalpost;

    /**
     * 从事专业
     */
    @TableField("workforprofession")
    private String workforprofession;

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
     * 工作单位
     */
    @TableField("workplace")
    private String workplace;

    @TableField("email")
    private String email;

    /**
     * 项目分工 true为项目负责人 principal为其他负责人
     */
    @TableField("programrole")
    private String programrole;

    /**
     * 是否企业人员
     */
    @TableField("enterpriseid")
    private String enterpriseid;

    /**
     * 人员id
     */
    @TableField("enterprisepartyid")
    private String enterprisepartyid;

    /**
     * 项目id
     */
    @TableField("projectbaseid")
    private String projectbaseid;

    /**
     * 邮政编码
     */
    @TableField("postalcode")
    private String postalcode;

    /**
     * 通讯地址
     */
    @TableField("postaladdress")
    private String postaladdress;

    /**
     * 法人代码
     */
    @TableField("legalcode")
    private String legalcode;

    /**
     * 年参加项目时间(月）
     */
    @TableField("workday")
    private BigDecimal workday;

    /**
     * 人员信息ID
     */
    @TableField("userinfoid")
    private String userinfoid;

    @TableField("seq")
    private BigDecimal seq;

    @TableField("partynote")
    private BigDecimal partynote;

    /**
     * 加入本项目起年月
     */
    @TableField("joinstarttime")
    private Date joinstarttime;

    /**
     * 加入本项目止年月
     */
    @TableField("joinendtime")
    private Date joinendtime;

    /**
     * 项目预算申报ID
     */
    @TableField("xmyssbid")
    private String xmyssbid;

    /**
     * 参与项目研发时间（月）
     */
    @TableField("createtime")
    private BigDecimal createtime;

    /**
     * 月劳务费
     */
    @TableField("createlaborfee")
    private BigDecimal createlaborfee;

    /**
     * 合计劳务费
     */
    @TableField("totallabor")
    private BigDecimal totallabor;

    @TableField("totalpeople")
    private BigDecimal totalpeople;

    @TableField("totalmoney")
    private BigDecimal totalmoney;

    @TableField("ptype")
    private String ptype;

    /**
     * 出生地
     */
    @TableField("birthplace")
    private String birthplace;

    /**
     * 民族
     */
    @TableField("nation")
    private String nation;

    /**
     * 政治面貌
     */
    @TableField("political")
    private String political;

    /**
     * 技术职称
     */
    @TableField("technicaltitle")
    private String technicaltitle;

    /**
     * 行政职务
     */
    @TableField("administrativeduty")
    private String administrativeduty;

    /**
     * 所学专业
     */
    @TableField("major")
    private String major;

    /**
     * 毕业学校
     */
    @TableField("graduateschool")
    private String graduateschool;

    /**
     * 毕业时间
     */
    @TableField("graduatetime")
    private Date graduatetime;

    /**
     * 曾获科技奖励情况
     */
    @TableField("everaward")
    private String everaward;

    @TableField("jxid")
    private String jxid;

    @TableField("nowengaged")
    private String nowengaged;

    @TableField("contribution")
    private String contribution;

    /**
     * 移动电话
     */
    @TableField("mobilephone")
    private String mobilephone;

    @TableField("signature")
    private String signature;

    /**
     * 项目分工
     */
    @TableField("xmfg")
    private String xmfg;

    /**
     * 民族名称
     */
    @TableField("nationname")
    private String nationname;

    /**
     * 是否在系统中
     */
    @TableField("issys")
    private String issys;

    /**
     * 是否为项目填报人
     */
    @TableField("iswrite")
    private String iswrite;

    /**
     * 是否为责任人
     */
    @TableField("isleader")
    private String isleader;

    /**
     * 合同ID
     */
    @TableField("pactid")
    private String pactid;

    /**
     * 职务
     */
    @TableField("positiontitle")
    private String positiontitle;

    /**
     * 年龄
     */
    @TableField("age")
    private String age;

    /**
     * 传真
     */
    @TableField("fax")
    private String fax;

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
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getCertificatename() {
        return certificatename;
    }

    public void setCertificatename(String certificatename) {
        this.certificatename = certificatename;
    }
    public String getCertificatenumber() {
        return certificatenumber;
    }

    public void setCertificatenumber(String certificatenumber) {
        this.certificatenumber = certificatenumber;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    public String getProfessionalpost() {
        return professionalpost;
    }

    public void setProfessionalpost(String professionalpost) {
        this.professionalpost = professionalpost;
    }
    public String getWorkforprofession() {
        return workforprofession;
    }

    public void setWorkforprofession(String workforprofession) {
        this.workforprofession = workforprofession;
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
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getProgramrole() {
        return programrole;
    }

    public void setProgramrole(String programrole) {
        this.programrole = programrole;
    }
    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }
    public String getEnterprisepartyid() {
        return enterprisepartyid;
    }

    public void setEnterprisepartyid(String enterprisepartyid) {
        this.enterprisepartyid = enterprisepartyid;
    }
    public String getProjectbaseid() {
        return projectbaseid;
    }

    public void setProjectbaseid(String projectbaseid) {
        this.projectbaseid = projectbaseid;
    }
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }
    public String getLegalcode() {
        return legalcode;
    }

    public void setLegalcode(String legalcode) {
        this.legalcode = legalcode;
    }
    public BigDecimal getWorkday() {
        return workday;
    }

    public void setWorkday(BigDecimal workday) {
        this.workday = workday;
    }
    public String getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(String userinfoid) {
        this.userinfoid = userinfoid;
    }
    public BigDecimal getSeq() {
        return seq;
    }

    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }
    public BigDecimal getPartynote() {
        return partynote;
    }

    public void setPartynote(BigDecimal partynote) {
        this.partynote = partynote;
    }
    public Date getJoinstarttime() {
        return joinstarttime;
    }

    public void setJoinstarttime(Date joinstarttime) {
        this.joinstarttime = joinstarttime;
    }
    public Date getJoinendtime() {
        return joinendtime;
    }

    public void setJoinendtime(Date joinendtime) {
        this.joinendtime = joinendtime;
    }
    public String getXmyssbid() {
        return xmyssbid;
    }

    public void setXmyssbid(String xmyssbid) {
        this.xmyssbid = xmyssbid;
    }
    public BigDecimal getCreatetime() {
        return createtime;
    }

    public void setCreatetime(BigDecimal createtime) {
        this.createtime = createtime;
    }
    public BigDecimal getCreatelaborfee() {
        return createlaborfee;
    }

    public void setCreatelaborfee(BigDecimal createlaborfee) {
        this.createlaborfee = createlaborfee;
    }
    public BigDecimal getTotallabor() {
        return totallabor;
    }

    public void setTotallabor(BigDecimal totallabor) {
        this.totallabor = totallabor;
    }
    public BigDecimal getTotalpeople() {
        return totalpeople;
    }

    public void setTotalpeople(BigDecimal totalpeople) {
        this.totalpeople = totalpeople;
    }
    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }
    public String getTechnicaltitle() {
        return technicaltitle;
    }

    public void setTechnicaltitle(String technicaltitle) {
        this.technicaltitle = technicaltitle;
    }
    public String getAdministrativeduty() {
        return administrativeduty;
    }

    public void setAdministrativeduty(String administrativeduty) {
        this.administrativeduty = administrativeduty;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    public String getGraduateschool() {
        return graduateschool;
    }

    public void setGraduateschool(String graduateschool) {
        this.graduateschool = graduateschool;
    }
    public Date getGraduatetime() {
        return graduatetime;
    }

    public void setGraduatetime(Date graduatetime) {
        this.graduatetime = graduatetime;
    }
    public String getEveraward() {
        return everaward;
    }

    public void setEveraward(String everaward) {
        this.everaward = everaward;
    }
    public String getJxid() {
        return jxid;
    }

    public void setJxid(String jxid) {
        this.jxid = jxid;
    }
    public String getNowengaged() {
        return nowengaged;
    }

    public void setNowengaged(String nowengaged) {
        this.nowengaged = nowengaged;
    }
    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }
    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getXmfg() {
        return xmfg;
    }

    public void setXmfg(String xmfg) {
        this.xmfg = xmfg;
    }
    public String getNationname() {
        return nationname;
    }

    public void setNationname(String nationname) {
        this.nationname = nationname;
    }
    public String getIssys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys;
    }
    public String getIswrite() {
        return iswrite;
    }

    public void setIswrite(String iswrite) {
        this.iswrite = iswrite;
    }
    public String getIsleader() {
        return isleader;
    }

    public void setIsleader(String isleader) {
        this.isleader = isleader;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public String getPositiontitle() {
        return positiontitle;
    }

    public void setPositiontitle(String positiontitle) {
        this.positiontitle = positiontitle;
    }
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "PactProjectparty{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", certificatename=" + certificatename +
        ", certificatenumber=" + certificatenumber +
        ", birthday=" + birthday +
        ", telphone=" + telphone +
        ", professionalpost=" + professionalpost +
        ", workforprofession=" + workforprofession +
        ", education=" + education +
        ", degree=" + degree +
        ", workplace=" + workplace +
        ", email=" + email +
        ", programrole=" + programrole +
        ", enterpriseid=" + enterpriseid +
        ", enterprisepartyid=" + enterprisepartyid +
        ", projectbaseid=" + projectbaseid +
        ", postalcode=" + postalcode +
        ", postaladdress=" + postaladdress +
        ", legalcode=" + legalcode +
        ", workday=" + workday +
        ", userinfoid=" + userinfoid +
        ", seq=" + seq +
        ", partynote=" + partynote +
        ", joinstarttime=" + joinstarttime +
        ", joinendtime=" + joinendtime +
        ", xmyssbid=" + xmyssbid +
        ", createtime=" + createtime +
        ", createlaborfee=" + createlaborfee +
        ", totallabor=" + totallabor +
        ", totalpeople=" + totalpeople +
        ", totalmoney=" + totalmoney +
        ", ptype=" + ptype +
        ", birthplace=" + birthplace +
        ", nation=" + nation +
        ", political=" + political +
        ", technicaltitle=" + technicaltitle +
        ", administrativeduty=" + administrativeduty +
        ", major=" + major +
        ", graduateschool=" + graduateschool +
        ", graduatetime=" + graduatetime +
        ", everaward=" + everaward +
        ", jxid=" + jxid +
        ", nowengaged=" + nowengaged +
        ", contribution=" + contribution +
        ", mobilephone=" + mobilephone +
        ", signature=" + signature +
        ", xmfg=" + xmfg +
        ", nationname=" + nationname +
        ", issys=" + issys +
        ", iswrite=" + iswrite +
        ", isleader=" + isleader +
        ", pactid=" + pactid +
        ", positiontitle=" + positiontitle +
        ", age=" + age +
        ", fax=" + fax +
        "}";
    }
}
