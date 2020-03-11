package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 申报配置-批次配置表
 * @Description: 申报配置-批次配置表
 * @author wuzhengjun
 * @date 2019-04-24 16:22:21
 * @version V1.0   
 *
 */
@TableName("PMS_PLANPROJECTBATCH")
@SuppressWarnings("serial")
public class PmsPlanprojectbatch extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**批次名称*/
    @TableField(value = "name")
	private String name;
    /**开始时间*/
    @TableField(value = "starttime")
	private String starttime;
    /**结束时间*/
    @TableField(value = "endtime")
	private String endtime;
    /**说明*/
    @TableField(value = "explain")
	private String explain;
    /**备注*/
    @TableField(value = "memo")
	private String memo;
    /**计划项目类别ID*/
    @TableField(value = "planprojectid")
	private String planprojectid;
    /**当前状态*/
    @TableField(value = "currentstate")
	private String currentstate;
    /**年度*/
    @TableField(value = "annually")
	private String annually;
    /**开放用户*/
    @TableField(value = "openuser")
	private String openuser;
    /**是否网上签约*/
    @TableField(value = "issignonline")
	private String issignonline;
    /**模板ID*/
    @TableField(value = "applicationtableexplain")
	private String applicationtableexplain;
    /**开发用户代码*/
    @TableField(value = "openusercode")
	private String openusercode;
    /**申报指南ID*/
    @TableField(value = "declarationguideid")
	private String declarationguideid;
    /**工作流配置id*/
    @TableField(value = "workflowdefineid")
	private String workflowdefineid;
    /**编号规则*/
    @TableField(value = "numberarithmetic")
	private String numberarithmetic;
    /**类别1编码*/
    @TableField(value = "applicationtypecode1")
	private String applicationtypecode1;
    /**类别2编码*/
    @TableField(value = "applicationtypecode2")
	private String applicationtypecode2;
    /**主审单位id*/
    @TableField(value = "admindepartmentid")
	private String admindepartmentid;
    /**企业限制*/
    @TableField(value = "enterpriselimit")
	private String enterpriselimit;
    /**联审是否启动（doing表示已经启动，going表示准备，pass暂停，没有值表示未启动）*/
    @TableField(value = "isstartuniteapprove")
	private String isstartuniteapprove;
    /**批次连接*/
    @TableField(value = "pageurl")
	private String pageurl;
    /**批次读脚本*/
    @TableField(value = "readscripts")
	private String readscripts;
    /**是否在主页显示*/
    @TableField(value = "isdisplay")
	private String isdisplay;
    /**批次申报树*/
    @TableField(value = "enterpriseparentidex")
	private String enterpriseparentidex;
    /**限制上报的脚本*/
    @TableField(value = "limitscripts")
	private String limitscripts;
    /**顺序*/
    @TableField(value = "seq")
	private Double seq;
    /**项目受理人员*/
    @TableField(value = "xingshenusers")
	private String xingshenusers;
    /**pdf模板名称*/
    @TableField(value = "modelname")
	private String modelname;
    /**短信模版*/
    @TableField(value = "messagemodel")
	private String messagemodel;
    /**短信模版(参加)*/
    @TableField(value = "smsattend")
	private String smsattend;
    /**短信模版(通知)*/
    @TableField(value = "smsnotice")
	private String smsnotice;
    /**短信模版(账号)*/
    @TableField(value = "smsaccount")
	private String smsaccount;
    /**评审说明*/
    @TableField(value = "reviewexplain")
	private String reviewexplain;
    /**查看申报情况用户*/
    @TableField(value = "broseruser")
	private String broseruser;
    /**状态*/
    @TableField(value = "status")
	private String status;
    /**专家评审承诺书*/
    @TableField(value = "undertaking")
	private String undertaking;
    /**每个项目评审人数*/
    @TableField(value = "perproject")
	private Double perproject;
    /**每组人数*/
    @TableField(value = "perteam")
	private Double perteam;
    /**通知人数*/
    @TableField(value = "persms")
	private Double persms;
    /**每个项目评审最少人数*/
    @TableField(value = "perprojectleast")
	private Double perprojectleast;
    /**开始评审时间*/
    @TableField(value = "pingshenstarttime")
	private Date pingshenstarttime;
    /**结束评审时间*/
    @TableField(value = "pingshenendtime")
	private Date pingshenendtime;
    /**批次归属市*/
    @TableField(value = "city")
	private String city;
    /**批次归属县*/
    @TableField(value = "county")
	private String county;
    /**形审到达时间*/
    @TableField(value = "shapeontime")
	private Date shapeontime;
    /**网评到达时间*/
    @TableField(value = "networkevaluationtime")
	private Date networkevaluationtime;
    /**初审到达时间*/
    @TableField(value = "firsttrialtime")
	private Date firsttrialtime;
    /**联审到达时间*/
    @TableField(value = "unitedreviewtime")
	private Date unitedreviewtime;
    /**竞争性评议到达时间*/
    @TableField(value = "competitivereviewtime")
	private Date competitivereviewtime;
    /**批次主状态
*/
    @TableField(value = "mainstatus")
	private String mainstatus;
    /**技术领域专家*/
    @TableField(value = "jslyzj")
	private Double jslyzj;
    /**行业部门管理人员*/
    @TableField(value = "hybmglry")
	private Double hybmglry;
    /**企业家代表*/
    @TableField(value = "qyjdb")
	private Double qyjdb;
    /**管理领域专家*/
    @TableField(value = "gllyzj")
	private Double gllyzj;
    /**联审启动开始日期*/
    @TableField(value = "lsqdksrq")
	private Date lsqdksrq;
    /**联审启动结束日期*/
    @TableField(value = "lsqdjsrq")
	private Date lsqdjsrq;
    /**手机号码*/
    @TableField(value = "yzphone")
	private String yzphone;
    /**专家网评控制的淘汰比率*/
    @TableField(value = "mortality")
	private Double mortality;
	
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
	 *@return: String  批次名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  批次名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  starttime
	 *@return: String  开始时间
	 */
	public String getStarttime(){
		return this.starttime;
	}

	/**
	 * 设置  starttime
	 *@param: starttime  开始时间
	 */
	public void setStarttime(String starttime){
		this.starttime = starttime;
	}
	/**
	 * 获取  endtime
	 *@return: String  结束时间
	 */
	public String getEndtime(){
		return this.endtime;
	}

	/**
	 * 设置  endtime
	 *@param: endtime  结束时间
	 */
	public void setEndtime(String endtime){
		this.endtime = endtime;
	}
	/**
	 * 获取  explain
	 *@return: String  说明
	 */
	public String getExplain(){
		return this.explain;
	}

	/**
	 * 设置  explain
	 *@param: explain  说明
	 */
	public void setExplain(String explain){
		this.explain = explain;
	}
	/**
	 * 获取  memo
	 *@return: String  备注
	 */
	public String getMemo(){
		return this.memo;
	}

	/**
	 * 设置  memo
	 *@param: memo  备注
	 */
	public void setMemo(String memo){
		this.memo = memo;
	}
	/**
	 * 获取  planprojectid
	 *@return: String  计划项目类别ID
	 */
	public String getPlanprojectid(){
		return this.planprojectid;
	}

	/**
	 * 设置  planprojectid
	 *@param: planprojectid  计划项目类别ID
	 */
	public void setPlanprojectid(String planprojectid){
		this.planprojectid = planprojectid;
	}
	/**
	 * 获取  currentstate
	 *@return: String  当前状态
	 */
	public String getCurrentstate(){
		return this.currentstate;
	}

	/**
	 * 设置  currentstate
	 *@param: currentstate  当前状态
	 */
	public void setCurrentstate(String currentstate){
		this.currentstate = currentstate;
	}
	/**
	 * 获取  annually
	 *@return: String  年度
	 */
	public String getAnnually(){
		return this.annually;
	}

	/**
	 * 设置  annually
	 *@param: annually  年度
	 */
	public void setAnnually(String annually){
		this.annually = annually;
	}
	/**
	 * 获取  openuser
	 *@return: String  开放用户
	 */
	public String getOpenuser(){
		return this.openuser;
	}

	/**
	 * 设置  openuser
	 *@param: openuser  开放用户
	 */
	public void setOpenuser(String openuser){
		this.openuser = openuser;
	}
	/**
	 * 获取  issignonline
	 *@return: String  是否网上签约
	 */
	public String getIssignonline(){
		return this.issignonline;
	}

	/**
	 * 设置  issignonline
	 *@param: issignonline  是否网上签约
	 */
	public void setIssignonline(String issignonline){
		this.issignonline = issignonline;
	}
	/**
	 * 获取  applicationtableexplain
	 *@return: String  模板ID
	 */
	public String getApplicationtableexplain(){
		return this.applicationtableexplain;
	}

	/**
	 * 设置  applicationtableexplain
	 *@param: applicationtableexplain  模板ID
	 */
	public void setApplicationtableexplain(String applicationtableexplain){
		this.applicationtableexplain = applicationtableexplain;
	}
	/**
	 * 获取  openusercode
	 *@return: String  开发用户代码
	 */
	public String getOpenusercode(){
		return this.openusercode;
	}

	/**
	 * 设置  openusercode
	 *@param: openusercode  开发用户代码
	 */
	public void setOpenusercode(String openusercode){
		this.openusercode = openusercode;
	}
	/**
	 * 获取  declarationguideid
	 *@return: String  申报指南ID
	 */
	public String getDeclarationguideid(){
		return this.declarationguideid;
	}

	/**
	 * 设置  declarationguideid
	 *@param: declarationguideid  申报指南ID
	 */
	public void setDeclarationguideid(String declarationguideid){
		this.declarationguideid = declarationguideid;
	}
	/**
	 * 获取  workflowdefineid
	 *@return: String  工作流配置id
	 */
	public String getWorkflowdefineid(){
		return this.workflowdefineid;
	}

	/**
	 * 设置  workflowdefineid
	 *@param: workflowdefineid  工作流配置id
	 */
	public void setWorkflowdefineid(String workflowdefineid){
		this.workflowdefineid = workflowdefineid;
	}
	/**
	 * 获取  numberarithmetic
	 *@return: String  编号规则
	 */
	public String getNumberarithmetic(){
		return this.numberarithmetic;
	}

	/**
	 * 设置  numberarithmetic
	 *@param: numberarithmetic  编号规则
	 */
	public void setNumberarithmetic(String numberarithmetic){
		this.numberarithmetic = numberarithmetic;
	}
	/**
	 * 获取  applicationtypecode1
	 *@return: String  类别1编码
	 */
	public String getApplicationtypecode1(){
		return this.applicationtypecode1;
	}

	/**
	 * 设置  applicationtypecode1
	 *@param: applicationtypecode1  类别1编码
	 */
	public void setApplicationtypecode1(String applicationtypecode1){
		this.applicationtypecode1 = applicationtypecode1;
	}
	/**
	 * 获取  applicationtypecode2
	 *@return: String  类别2编码
	 */
	public String getApplicationtypecode2(){
		return this.applicationtypecode2;
	}

	/**
	 * 设置  applicationtypecode2
	 *@param: applicationtypecode2  类别2编码
	 */
	public void setApplicationtypecode2(String applicationtypecode2){
		this.applicationtypecode2 = applicationtypecode2;
	}
	/**
	 * 获取  admindepartmentid
	 *@return: String  主审单位id
	 */
	public String getAdmindepartmentid(){
		return this.admindepartmentid;
	}

	/**
	 * 设置  admindepartmentid
	 *@param: admindepartmentid  主审单位id
	 */
	public void setAdmindepartmentid(String admindepartmentid){
		this.admindepartmentid = admindepartmentid;
	}
	/**
	 * 获取  enterpriselimit
	 *@return: String  企业限制
	 */
	public String getEnterpriselimit(){
		return this.enterpriselimit;
	}

	/**
	 * 设置  enterpriselimit
	 *@param: enterpriselimit  企业限制
	 */
	public void setEnterpriselimit(String enterpriselimit){
		this.enterpriselimit = enterpriselimit;
	}
	/**
	 * 获取  isstartuniteapprove
	 *@return: String  联审是否启动（doing表示已经启动，going表示准备，pass暂停，没有值表示未启动）
	 */
	public String getIsstartuniteapprove(){
		return this.isstartuniteapprove;
	}

	/**
	 * 设置  isstartuniteapprove
	 *@param: isstartuniteapprove  联审是否启动（doing表示已经启动，going表示准备，pass暂停，没有值表示未启动）
	 */
	public void setIsstartuniteapprove(String isstartuniteapprove){
		this.isstartuniteapprove = isstartuniteapprove;
	}
	/**
	 * 获取  pageurl
	 *@return: String  批次连接
	 */
	public String getPageurl(){
		return this.pageurl;
	}

	/**
	 * 设置  pageurl
	 *@param: pageurl  批次连接
	 */
	public void setPageurl(String pageurl){
		this.pageurl = pageurl;
	}
	/**
	 * 获取  readscripts
	 *@return: String  批次读脚本
	 */
	public String getReadscripts(){
		return this.readscripts;
	}

	/**
	 * 设置  readscripts
	 *@param: readscripts  批次读脚本
	 */
	public void setReadscripts(String readscripts){
		this.readscripts = readscripts;
	}
	/**
	 * 获取  isdisplay
	 *@return: String  是否在主页显示
	 */
	public String getIsdisplay(){
		return this.isdisplay;
	}

	/**
	 * 设置  isdisplay
	 *@param: isdisplay  是否在主页显示
	 */
	public void setIsdisplay(String isdisplay){
		this.isdisplay = isdisplay;
	}
	/**
	 * 获取  enterpriseparentidex
	 *@return: String  批次申报树
	 */
	public String getEnterpriseparentidex(){
		return this.enterpriseparentidex;
	}

	/**
	 * 设置  enterpriseparentidex
	 *@param: enterpriseparentidex  批次申报树
	 */
	public void setEnterpriseparentidex(String enterpriseparentidex){
		this.enterpriseparentidex = enterpriseparentidex;
	}
	/**
	 * 获取  limitscripts
	 *@return: String  限制上报的脚本
	 */
	public String getLimitscripts(){
		return this.limitscripts;
	}

	/**
	 * 设置  limitscripts
	 *@param: limitscripts  限制上报的脚本
	 */
	public void setLimitscripts(String limitscripts){
		this.limitscripts = limitscripts;
	}
	/**
	 * 获取  seq
	 *@return: Double  顺序
	 */
	public Double getSeq(){
		return this.seq;
	}

	/**
	 * 设置  seq
	 *@param: seq  顺序
	 */
	public void setSeq(Double seq){
		this.seq = seq;
	}
	/**
	 * 获取  xingshenusers
	 *@return: String  项目受理人员
	 */
	public String getXingshenusers(){
		return this.xingshenusers;
	}

	/**
	 * 设置  xingshenusers
	 *@param: xingshenusers  项目受理人员
	 */
	public void setXingshenusers(String xingshenusers){
		this.xingshenusers = xingshenusers;
	}
	/**
	 * 获取  modelname
	 *@return: String  pdf模板名称
	 */
	public String getModelname(){
		return this.modelname;
	}

	/**
	 * 设置  modelname
	 *@param: modelname  pdf模板名称
	 */
	public void setModelname(String modelname){
		this.modelname = modelname;
	}
	/**
	 * 获取  messagemodel
	 *@return: String  短信模版
	 */
	public String getMessagemodel(){
		return this.messagemodel;
	}

	/**
	 * 设置  messagemodel
	 *@param: messagemodel  短信模版
	 */
	public void setMessagemodel(String messagemodel){
		this.messagemodel = messagemodel;
	}
	/**
	 * 获取  smsattend
	 *@return: String  短信模版(参加)
	 */
	public String getSmsattend(){
		return this.smsattend;
	}

	/**
	 * 设置  smsattend
	 *@param: smsattend  短信模版(参加)
	 */
	public void setSmsattend(String smsattend){
		this.smsattend = smsattend;
	}
	/**
	 * 获取  smsnotice
	 *@return: String  短信模版(通知)
	 */
	public String getSmsnotice(){
		return this.smsnotice;
	}

	/**
	 * 设置  smsnotice
	 *@param: smsnotice  短信模版(通知)
	 */
	public void setSmsnotice(String smsnotice){
		this.smsnotice = smsnotice;
	}
	/**
	 * 获取  smsaccount
	 *@return: String  短信模版(账号)
	 */
	public String getSmsaccount(){
		return this.smsaccount;
	}

	/**
	 * 设置  smsaccount
	 *@param: smsaccount  短信模版(账号)
	 */
	public void setSmsaccount(String smsaccount){
		this.smsaccount = smsaccount;
	}
	/**
	 * 获取  reviewexplain
	 *@return: String  评审说明
	 */
	public String getReviewexplain(){
		return this.reviewexplain;
	}

	/**
	 * 设置  reviewexplain
	 *@param: reviewexplain  评审说明
	 */
	public void setReviewexplain(String reviewexplain){
		this.reviewexplain = reviewexplain;
	}
	/**
	 * 获取  broseruser
	 *@return: String  查看申报情况用户
	 */
	public String getBroseruser(){
		return this.broseruser;
	}

	/**
	 * 设置  broseruser
	 *@param: broseruser  查看申报情况用户
	 */
	public void setBroseruser(String broseruser){
		this.broseruser = broseruser;
	}
	/**
	 * 获取  status
	 *@return: String  状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param: status  状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  undertaking
	 *@return: String  专家评审承诺书
	 */
	public String getUndertaking(){
		return this.undertaking;
	}

	/**
	 * 设置  undertaking
	 *@param: undertaking  专家评审承诺书
	 */
	public void setUndertaking(String undertaking){
		this.undertaking = undertaking;
	}
	/**
	 * 获取  perproject
	 *@return: Double  每个项目评审人数
	 */
	public Double getPerproject(){
		return this.perproject;
	}

	/**
	 * 设置  perproject
	 *@param: perproject  每个项目评审人数
	 */
	public void setPerproject(Double perproject){
		this.perproject = perproject;
	}
	/**
	 * 获取  perteam
	 *@return: Double  每组人数
	 */
	public Double getPerteam(){
		return this.perteam;
	}

	/**
	 * 设置  perteam
	 *@param: perteam  每组人数
	 */
	public void setPerteam(Double perteam){
		this.perteam = perteam;
	}
	/**
	 * 获取  persms
	 *@return: Double  通知人数
	 */
	public Double getPersms(){
		return this.persms;
	}

	/**
	 * 设置  persms
	 *@param: persms  通知人数
	 */
	public void setPersms(Double persms){
		this.persms = persms;
	}
	/**
	 * 获取  perprojectleast
	 *@return: Double  每个项目评审最少人数
	 */
	public Double getPerprojectleast(){
		return this.perprojectleast;
	}

	/**
	 * 设置  perprojectleast
	 *@param: perprojectleast  每个项目评审最少人数
	 */
	public void setPerprojectleast(Double perprojectleast){
		this.perprojectleast = perprojectleast;
	}
	/**
	 * 获取  pingshenstarttime
	 *@return: Date  开始评审时间
	 */
	public Date getPingshenstarttime(){
		return this.pingshenstarttime;
	}

	/**
	 * 设置  pingshenstarttime
	 *@param: pingshenstarttime  开始评审时间
	 */
	public void setPingshenstarttime(Date pingshenstarttime){
		this.pingshenstarttime = pingshenstarttime;
	}
	/**
	 * 获取  pingshenendtime
	 *@return: Date  结束评审时间
	 */
	public Date getPingshenendtime(){
		return this.pingshenendtime;
	}

	/**
	 * 设置  pingshenendtime
	 *@param: pingshenendtime  结束评审时间
	 */
	public void setPingshenendtime(Date pingshenendtime){
		this.pingshenendtime = pingshenendtime;
	}
	/**
	 * 获取  city
	 *@return: String  批次归属市
	 */
	public String getCity(){
		return this.city;
	}

	/**
	 * 设置  city
	 *@param: city  批次归属市
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 * 获取  county
	 *@return: String  批次归属县
	 */
	public String getCounty(){
		return this.county;
	}

	/**
	 * 设置  county
	 *@param: county  批次归属县
	 */
	public void setCounty(String county){
		this.county = county;
	}
	/**
	 * 获取  shapeontime
	 *@return: Date  形审到达时间
	 */
	public Date getShapeontime(){
		return this.shapeontime;
	}

	/**
	 * 设置  shapeontime
	 *@param: shapeontime  形审到达时间
	 */
	public void setShapeontime(Date shapeontime){
		this.shapeontime = shapeontime;
	}
	/**
	 * 获取  networkevaluationtime
	 *@return: Date  网评到达时间
	 */
	public Date getNetworkevaluationtime(){
		return this.networkevaluationtime;
	}

	/**
	 * 设置  networkevaluationtime
	 *@param: networkevaluationtime  网评到达时间
	 */
	public void setNetworkevaluationtime(Date networkevaluationtime){
		this.networkevaluationtime = networkevaluationtime;
	}
	/**
	 * 获取  firsttrialtime
	 *@return: Date  初审到达时间
	 */
	public Date getFirsttrialtime(){
		return this.firsttrialtime;
	}

	/**
	 * 设置  firsttrialtime
	 *@param: firsttrialtime  初审到达时间
	 */
	public void setFirsttrialtime(Date firsttrialtime){
		this.firsttrialtime = firsttrialtime;
	}
	/**
	 * 获取  unitedreviewtime
	 *@return: Date  联审到达时间
	 */
	public Date getUnitedreviewtime(){
		return this.unitedreviewtime;
	}

	/**
	 * 设置  unitedreviewtime
	 *@param: unitedreviewtime  联审到达时间
	 */
	public void setUnitedreviewtime(Date unitedreviewtime){
		this.unitedreviewtime = unitedreviewtime;
	}
	/**
	 * 获取  competitivereviewtime
	 *@return: Date  竞争性评议到达时间
	 */
	public Date getCompetitivereviewtime(){
		return this.competitivereviewtime;
	}

	/**
	 * 设置  competitivereviewtime
	 *@param: competitivereviewtime  竞争性评议到达时间
	 */
	public void setCompetitivereviewtime(Date competitivereviewtime){
		this.competitivereviewtime = competitivereviewtime;
	}
	/**
	 * 获取  mainstatus
	 *@return: String  批次主状态

	 */
	public String getMainstatus(){
		return this.mainstatus;
	}

	/**
	 * 设置  mainstatus
	 *@param: mainstatus  批次主状态

	 */
	public void setMainstatus(String mainstatus){
		this.mainstatus = mainstatus;
	}
	/**
	 * 获取  jslyzj
	 *@return: Double  技术领域专家
	 */
	public Double getJslyzj(){
		return this.jslyzj;
	}

	/**
	 * 设置  jslyzj
	 *@param: jslyzj  技术领域专家
	 */
	public void setJslyzj(Double jslyzj){
		this.jslyzj = jslyzj;
	}
	/**
	 * 获取  hybmglry
	 *@return: Double  行业部门管理人员
	 */
	public Double getHybmglry(){
		return this.hybmglry;
	}

	/**
	 * 设置  hybmglry
	 *@param: hybmglry  行业部门管理人员
	 */
	public void setHybmglry(Double hybmglry){
		this.hybmglry = hybmglry;
	}
	/**
	 * 获取  qyjdb
	 *@return: Double  企业家代表
	 */
	public Double getQyjdb(){
		return this.qyjdb;
	}

	/**
	 * 设置  qyjdb
	 *@param: qyjdb  企业家代表
	 */
	public void setQyjdb(Double qyjdb){
		this.qyjdb = qyjdb;
	}
	/**
	 * 获取  gllyzj
	 *@return: Double  管理领域专家
	 */
	public Double getGllyzj(){
		return this.gllyzj;
	}

	/**
	 * 设置  gllyzj
	 *@param: gllyzj  管理领域专家
	 */
	public void setGllyzj(Double gllyzj){
		this.gllyzj = gllyzj;
	}
	/**
	 * 获取  lsqdksrq
	 *@return: Date  联审启动开始日期
	 */
	public Date getLsqdksrq(){
		return this.lsqdksrq;
	}

	/**
	 * 设置  lsqdksrq
	 *@param: lsqdksrq  联审启动开始日期
	 */
	public void setLsqdksrq(Date lsqdksrq){
		this.lsqdksrq = lsqdksrq;
	}
	/**
	 * 获取  lsqdjsrq
	 *@return: Date  联审启动结束日期
	 */
	public Date getLsqdjsrq(){
		return this.lsqdjsrq;
	}

	/**
	 * 设置  lsqdjsrq
	 *@param: lsqdjsrq  联审启动结束日期
	 */
	public void setLsqdjsrq(Date lsqdjsrq){
		this.lsqdjsrq = lsqdjsrq;
	}
	/**
	 * 获取  yzphone
	 *@return: String  手机号码
	 */
	public String getYzphone(){
		return this.yzphone;
	}

	/**
	 * 设置  yzphone
	 *@param: yzphone  手机号码
	 */
	public void setYzphone(String yzphone){
		this.yzphone = yzphone;
	}
	/**
	 * 获取  mortality
	 *@return: Double  专家网评控制的淘汰比率
	 */
	public Double getMortality(){
		return this.mortality;
	}

	/**
	 * 设置  mortality
	 *@param: mortality  专家网评控制的淘汰比率
	 */
	public void setMortality(Double mortality){
		this.mortality = mortality;
	}
	
}
