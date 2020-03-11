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
 * @since 2019-04-09
 */
@TableName("pms_planprojectbatch")
public class PmsPlanprojectbatch extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 批次名称
     */
    @TableField("name")
    private String name;

    /**
     * 开始时间
     */
    @TableField("starttime")
    private Date starttime;

    /**
     * 结束时间
     */
    @TableField("endtime")
    private Date endtime;

    /**
     * 说明
     */
    @TableField("explain")
    private String explain;

    /**
     * 备注
     */
    @TableField("memo")
    private String memo;

    /**
     * 计划项目类别ID
     */
    @TableField("planprojectid")
    private String planprojectid;

    /**
     * 当前状态
     */
    @TableField("currentstate")
    private String currentstate;

    /**
     * 年度
     */
    @TableField("annually")
    private String annually;

    /**
     * 开放用户
     */
    @TableField("openuser")
    private String openuser;

    /**
     * 是否网上签约
     */
    @TableField("issignonline")
    private String issignonline;

    /**
     * 模板id
     */
    @TableField("applicationtableexplain")
    private String applicationtableexplain;

    /**
     * 开发用户代码
     */
    @TableField("openusercode")
    private String openusercode;

    /**
     * 申报指南ID
     */
    @TableField("declarationguideid")
    private String declarationguideid;

    /**
     * 工作流配置id
     */
    @TableField("workflowdefineid")
    private String workflowdefineid;

    /**
     * 编号规则
     */
    @TableField("numberarithmetic")
    private String numberarithmetic;

    /**
     * 类别1编码
     */
    @TableField("applicationtypecode1")
    private String applicationtypecode1;

    /**
     * 类别2编码
     */
    @TableField("applicationtypecode2")
    private String applicationtypecode2;

    /**
     * 主审单位id
     */
    @TableField("admindepartmentid")
    private String admindepartmentid;

    /**
     * 企业限制
     */
    @TableField("enterpriselimit")
    private String enterpriselimit;

    /**
     * 联审是否启动（doing表示已经启动，going表示准备，pass暂停，没有值表示未启动）
     */
    @TableField("isstartuniteapprove")
    private String isstartuniteapprove;

    /**
     * 批次连接
     */
    @TableField("pageurl")
    private String pageurl;

    /**
     * 批次脚本
     */
    @TableField("readscripts")
    private String readscripts;

    /**
     * 是否在主页显示
     */
    @TableField("isdisplay")
    private String isdisplay;

    /**
     * 批次申报树
     */
    @TableField("enterpriseparentidex")
    private String enterpriseparentidex;

    /**
     * 限制上报的脚本
     */
    @TableField("limitscripts")
    private String limitscripts;

    /**
     * 顺序
     */
    @TableField("seq")
    private String seq;

    /**
     * 项目受理人员
     */
    @TableField("xingshenusers")
    private String xingshenusers;

    /**
     * pdf模板名称
     */
    @TableField("modelname")
    private String modelname;

    /**
     * 短信模版
     */
    @TableField("messagemodel")
    private String messagemodel;

    /**
     * 短信模版(参加)
     */
    @TableField("smsattend")
    private String smsattend;

    /**
     * 短信模版(通知)
     */
    @TableField("smsnotice")
    private String smsnotice;

    /**
     * 短信模版(账号)
     */
    @TableField("smsaccount")
    private String smsaccount;

    /**
     * 评审说明
     */
    @TableField("reviewexplain")
    private String reviewexplain;

    /**
     * 查看申报情况用户
     */
    @TableField("broseruser")
    private String broseruser;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 专家评审承诺书
     */
    @TableField("undertaking")
    private String undertaking;

    /**
     * 每个项目评审人数
     */
    @TableField("perproject")
    private Integer perproject;

    /**
     * 每组人数
     */
    @TableField("perteam")
    private Integer perteam;

    /**
     * 通知人数
     */
    @TableField("persms")
    private Integer persms;

    /**
     * 每个项目评审最少人数
     */
    @TableField("perprojectleast")
    private Integer perprojectleast;

    /**
     * 开始评审时间
     */
    @TableField("pingshenstarttime")
    private Date pingshenstarttime;

    /**
     * 结束评审时间
     */
    @TableField("pingshenendtime")
    private Date pingshenendtime;

    /**
     * 批次归属市
     */
    @TableField("city")
    private String city;

    /**
     * 批次归属县
     */
    @TableField("county")
    private String county;

    /**
     * 形审到达时间
     */
    @TableField("shapeontime")
    private Date shapeontime;

    /**
     * 网评到达时间
     */
    @TableField("networkevaluationtime")
    private Date networkevaluationtime;

    /**
     * 初审到达时间
     */
    @TableField("firsttrialtime")
    private Date firsttrialtime;

    /**
     * 联审到达时间
     */
    @TableField("unitedreviewtime")
    private Date unitedreviewtime;

    /**
     * 竞争性评议到达时间
     */
    @TableField("competitivereviewtime")
    private Date competitivereviewtime;

    /**
     * 批次主状态
     */
    @TableField("mainstatus")
    private String mainstatus;

    /**
     * 技术领域专家
     */
    @TableField("jslyzj")
    private Integer jslyzj;

    /**
     * 行业部门管理人员
     */
    @TableField("hybmglry")
    private Integer hybmglry;

    /**
     * 企业家代表
     */
    @TableField("qyjdb")
    private Integer qyjdb;

    /**
     * 管理领域专家
     */
    @TableField("gllyzj")
    private Integer gllyzj;

    /**
     * 联审启动开始日期
     */
    @TableField("lsqdksrq")
    private Date lsqdksrq;

    /**
     * 联审启动结束日期
     */
    @TableField("lsqdjsrq")
    private Date lsqdjsrq;

    /**
     * 手机号码
     */
    @TableField("yzphone")
    private String yzphone;

    /**
     * 专家网评控制的淘汰比率
     */
    @TableField("mortality")
    private BigDecimal mortality;

    @TableField("pagetemplatedtailid")
    private String pagetemplatedtailid;

    @TableField("fields")
    private String fields;

    /**
     * 合同pdf模板名称
     */
    @TableField("pactmodelname")
    private String pactmodelname;

    /**
     * 合同对应class
     */
    @TableField("pactfields")
    private String pactfields;

    /**
     * 承若涵pdf模板名称
     */
    @TableField("crhmodelname")
    private String crhmodelname;

    /**
     * 承若涵对应class
     */
    @TableField("crhfields")
    private String crhfields;

    /**
     * 是否上传承若函
     */
    @TableField("iscrh")
    private Integer iscrh;

    /**
     * 归口领域
     */
    @TableField("fieldcodes")
    private String fieldcodes;

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
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getPlanprojectid() {
        return planprojectid;
    }

    public void setPlanprojectid(String planprojectid) {
        this.planprojectid = planprojectid;
    }
    public String getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(String currentstate) {
        this.currentstate = currentstate;
    }
    public String getAnnually() {
        return annually;
    }

    public void setAnnually(String annually) {
        this.annually = annually;
    }
    public String getOpenuser() {
        return openuser;
    }

    public void setOpenuser(String openuser) {
        this.openuser = openuser;
    }
    public String getIssignonline() {
        return issignonline;
    }

    public void setIssignonline(String issignonline) {
        this.issignonline = issignonline;
    }
    public String getApplicationtableexplain() {
        return applicationtableexplain;
    }

    public void setApplicationtableexplain(String applicationtableexplain) {
        this.applicationtableexplain = applicationtableexplain;
    }
    public String getOpenusercode() {
        return openusercode;
    }

    public void setOpenusercode(String openusercode) {
        this.openusercode = openusercode;
    }
    public String getDeclarationguideid() {
        return declarationguideid;
    }

    public void setDeclarationguideid(String declarationguideid) {
        this.declarationguideid = declarationguideid;
    }
    public String getWorkflowdefineid() {
        return workflowdefineid;
    }

    public void setWorkflowdefineid(String workflowdefineid) {
        this.workflowdefineid = workflowdefineid;
    }
    public String getNumberarithmetic() {
        return numberarithmetic;
    }

    public void setNumberarithmetic(String numberarithmetic) {
        this.numberarithmetic = numberarithmetic;
    }
    public String getApplicationtypecode1() {
        return applicationtypecode1;
    }

    public void setApplicationtypecode1(String applicationtypecode1) {
        this.applicationtypecode1 = applicationtypecode1;
    }
    public String getApplicationtypecode2() {
        return applicationtypecode2;
    }

    public void setApplicationtypecode2(String applicationtypecode2) {
        this.applicationtypecode2 = applicationtypecode2;
    }
    public String getAdmindepartmentid() {
        return admindepartmentid;
    }

    public void setAdmindepartmentid(String admindepartmentid) {
        this.admindepartmentid = admindepartmentid;
    }
    public String getEnterpriselimit() {
        return enterpriselimit;
    }

    public void setEnterpriselimit(String enterpriselimit) {
        this.enterpriselimit = enterpriselimit;
    }
    public String getIsstartuniteapprove() {
        return isstartuniteapprove;
    }

    public void setIsstartuniteapprove(String isstartuniteapprove) {
        this.isstartuniteapprove = isstartuniteapprove;
    }
    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }
    public String getReadscripts() {
        return readscripts;
    }

    public void setReadscripts(String readscripts) {
        this.readscripts = readscripts;
    }
    public String getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(String isdisplay) {
        this.isdisplay = isdisplay;
    }
    public String getEnterpriseparentidex() {
        return enterpriseparentidex;
    }

    public void setEnterpriseparentidex(String enterpriseparentidex) {
        this.enterpriseparentidex = enterpriseparentidex;
    }
    public String getLimitscripts() {
        return limitscripts;
    }

    public void setLimitscripts(String limitscripts) {
        this.limitscripts = limitscripts;
    }
    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
    public String getXingshenusers() {
        return xingshenusers;
    }

    public void setXingshenusers(String xingshenusers) {
        this.xingshenusers = xingshenusers;
    }
    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }
    public String getMessagemodel() {
        return messagemodel;
    }

    public void setMessagemodel(String messagemodel) {
        this.messagemodel = messagemodel;
    }
    public String getSmsattend() {
        return smsattend;
    }

    public void setSmsattend(String smsattend) {
        this.smsattend = smsattend;
    }
    public String getSmsnotice() {
        return smsnotice;
    }

    public void setSmsnotice(String smsnotice) {
        this.smsnotice = smsnotice;
    }
    public String getSmsaccount() {
        return smsaccount;
    }

    public void setSmsaccount(String smsaccount) {
        this.smsaccount = smsaccount;
    }
    public String getReviewexplain() {
        return reviewexplain;
    }

    public void setReviewexplain(String reviewexplain) {
        this.reviewexplain = reviewexplain;
    }
    public String getBroseruser() {
        return broseruser;
    }

    public void setBroseruser(String broseruser) {
        this.broseruser = broseruser;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getUndertaking() {
        return undertaking;
    }

    public void setUndertaking(String undertaking) {
        this.undertaking = undertaking;
    }
    public Integer getPerproject() {
        return perproject;
    }

    public void setPerproject(Integer perproject) {
        this.perproject = perproject;
    }
    public Integer getPerteam() {
        return perteam;
    }

    public void setPerteam(Integer perteam) {
        this.perteam = perteam;
    }
    public Integer getPersms() {
        return persms;
    }

    public void setPersms(Integer persms) {
        this.persms = persms;
    }
    public Integer getPerprojectleast() {
        return perprojectleast;
    }

    public void setPerprojectleast(Integer perprojectleast) {
        this.perprojectleast = perprojectleast;
    }
    public Date getPingshenstarttime() {
        return pingshenstarttime;
    }

    public void setPingshenstarttime(Date pingshenstarttime) {
        this.pingshenstarttime = pingshenstarttime;
    }
    public Date getPingshenendtime() {
        return pingshenendtime;
    }

    public void setPingshenendtime(Date pingshenendtime) {
        this.pingshenendtime = pingshenendtime;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    public Date getShapeontime() {
        return shapeontime;
    }

    public void setShapeontime(Date shapeontime) {
        this.shapeontime = shapeontime;
    }
    public Date getNetworkevaluationtime() {
        return networkevaluationtime;
    }

    public void setNetworkevaluationtime(Date networkevaluationtime) {
        this.networkevaluationtime = networkevaluationtime;
    }
    public Date getFirsttrialtime() {
        return firsttrialtime;
    }

    public void setFirsttrialtime(Date firsttrialtime) {
        this.firsttrialtime = firsttrialtime;
    }
    public Date getUnitedreviewtime() {
        return unitedreviewtime;
    }

    public void setUnitedreviewtime(Date unitedreviewtime) {
        this.unitedreviewtime = unitedreviewtime;
    }
    public Date getCompetitivereviewtime() {
        return competitivereviewtime;
    }

    public void setCompetitivereviewtime(Date competitivereviewtime) {
        this.competitivereviewtime = competitivereviewtime;
    }
    public String getMainstatus() {
        return mainstatus;
    }

    public void setMainstatus(String mainstatus) {
        this.mainstatus = mainstatus;
    }
    public Integer getJslyzj() {
        return jslyzj;
    }

    public void setJslyzj(Integer jslyzj) {
        this.jslyzj = jslyzj;
    }
    public Integer getHybmglry() {
        return hybmglry;
    }

    public void setHybmglry(Integer hybmglry) {
        this.hybmglry = hybmglry;
    }
    public Integer getQyjdb() {
        return qyjdb;
    }

    public void setQyjdb(Integer qyjdb) {
        this.qyjdb = qyjdb;
    }
    public Integer getGllyzj() {
        return gllyzj;
    }

    public void setGllyzj(Integer gllyzj) {
        this.gllyzj = gllyzj;
    }
    public Date getLsqdksrq() {
        return lsqdksrq;
    }

    public void setLsqdksrq(Date lsqdksrq) {
        this.lsqdksrq = lsqdksrq;
    }
    public Date getLsqdjsrq() {
        return lsqdjsrq;
    }

    public void setLsqdjsrq(Date lsqdjsrq) {
        this.lsqdjsrq = lsqdjsrq;
    }
    public String getYzphone() {
        return yzphone;
    }

    public void setYzphone(String yzphone) {
        this.yzphone = yzphone;
    }
    public BigDecimal getMortality() {
        return mortality;
    }

    public void setMortality(BigDecimal mortality) {
        this.mortality = mortality;
    }
    public String getPagetemplatedtailid() {
        return pagetemplatedtailid;
    }

    public void setPagetemplatedtailid(String pagetemplatedtailid) {
        this.pagetemplatedtailid = pagetemplatedtailid;
    }
    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
    public String getPactmodelname() {
        return pactmodelname;
    }

    public void setPactmodelname(String pactmodelname) {
        this.pactmodelname = pactmodelname;
    }
    public String getPactfields() {
        return pactfields;
    }

    public void setPactfields(String pactfields) {
        this.pactfields = pactfields;
    }
    public String getCrhmodelname() {
        return crhmodelname;
    }

    public void setCrhmodelname(String crhmodelname) {
        this.crhmodelname = crhmodelname;
    }
    public String getCrhfields() {
        return crhfields;
    }

    public void setCrhfields(String crhfields) {
        this.crhfields = crhfields;
    }
    public Integer getIscrh() {
        return iscrh;
    }

    public void setIscrh(Integer iscrh) {
        this.iscrh = iscrh;
    }
    public String getFieldcodes() {
        return fieldcodes;
    }

    public void setFieldcodes(String fieldcodes) {
        this.fieldcodes = fieldcodes;
    }

    @Override
    public String toString() {
        return "PmsPlanprojectbatch{" +
        "id=" + id +
        ", name=" + name +
        ", starttime=" + starttime +
        ", endtime=" + endtime +
        ", explain=" + explain +
        ", memo=" + memo +
        ", planprojectid=" + planprojectid +
        ", currentstate=" + currentstate +
        ", annually=" + annually +
        ", openuser=" + openuser +
        ", issignonline=" + issignonline +
        ", applicationtableexplain=" + applicationtableexplain +
        ", openusercode=" + openusercode +
        ", declarationguideid=" + declarationguideid +
        ", workflowdefineid=" + workflowdefineid +
        ", numberarithmetic=" + numberarithmetic +
        ", applicationtypecode1=" + applicationtypecode1 +
        ", applicationtypecode2=" + applicationtypecode2 +
        ", admindepartmentid=" + admindepartmentid +
        ", enterpriselimit=" + enterpriselimit +
        ", isstartuniteapprove=" + isstartuniteapprove +
        ", pageurl=" + pageurl +
        ", readscripts=" + readscripts +
        ", isdisplay=" + isdisplay +
        ", enterpriseparentidex=" + enterpriseparentidex +
        ", limitscripts=" + limitscripts +
        ", seq=" + seq +
        ", xingshenusers=" + xingshenusers +
        ", modelname=" + modelname +
        ", messagemodel=" + messagemodel +
        ", smsattend=" + smsattend +
        ", smsnotice=" + smsnotice +
        ", smsaccount=" + smsaccount +
        ", reviewexplain=" + reviewexplain +
        ", broseruser=" + broseruser +
        ", status=" + status +
        ", undertaking=" + undertaking +
        ", perproject=" + perproject +
        ", perteam=" + perteam +
        ", persms=" + persms +
        ", perprojectleast=" + perprojectleast +
        ", pingshenstarttime=" + pingshenstarttime +
        ", pingshenendtime=" + pingshenendtime +
        ", city=" + city +
        ", county=" + county +
        ", shapeontime=" + shapeontime +
        ", networkevaluationtime=" + networkevaluationtime +
        ", firsttrialtime=" + firsttrialtime +
        ", unitedreviewtime=" + unitedreviewtime +
        ", competitivereviewtime=" + competitivereviewtime +
        ", mainstatus=" + mainstatus +
        ", jslyzj=" + jslyzj +
        ", hybmglry=" + hybmglry +
        ", qyjdb=" + qyjdb +
        ", gllyzj=" + gllyzj +
        ", lsqdksrq=" + lsqdksrq +
        ", lsqdjsrq=" + lsqdjsrq +
        ", yzphone=" + yzphone +
        ", mortality=" + mortality +
        ", pagetemplatedtailid=" + pagetemplatedtailid +
        ", fields=" + fields +
        ", pactmodelname=" + pactmodelname +
        ", pactfields=" + pactfields +
        ", crhmodelname=" + crhmodelname +
        ", crhfields=" + crhfields +
        ", iscrh=" + iscrh +
        ", fieldcodes=" + fieldcodes +
        "}";
    }
}
