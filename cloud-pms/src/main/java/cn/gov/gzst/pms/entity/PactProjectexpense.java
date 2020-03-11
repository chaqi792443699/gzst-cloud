package cn.gov.gzst.pms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**   
 * @Title: 合同-投资预算
 * @Description: 合同-投资预算
 * @author wuzhengjun
 * @date 2019-04-24 15:54:54
 * @version V1.0   
 *
 */
@TableName("PACT_PROJECTEXPENSE")
@SuppressWarnings("serial")
public class PactProjectexpense extends AbstractEntity<String> {

    /**ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**自筹费用*/
    @TableField(value = "selfsum")
	private Double selfsum;
    /**向省厅申请费用*/
    @TableField(value = "applyprovicegvosum")
	private Double applyprovicegvosum;
    /**总计费用*/
    @TableField(value = "totalsum")
	private Double totalsum;
    /**设备费 1*/
    @TableField(value = "instrumentsum")
	private Double instrumentsum;
    /**差旅费 5*/
    @TableField(value = "businesstripsum")
	private Double businesstripsum;
    /**专家咨询费 10*/
    @TableField(value = "adviceforexpertsum")
	private Double adviceforexpertsum;
    /**材料费 2*/
    @TableField(value = "materialexpense")
	private Double materialexpense;
    /**劳务费 9*/
    @TableField(value = "servicefee")
	private Double servicefee;
    /**出版费 8*/
    @TableField(value = "adminstrativeservicesum")
	private Double adminstrativeservicesum;
    /**测试化验加工费 3*/
    @TableField(value = "proceedingscharges")
	private Double proceedingscharges;
    /**会议费 6*/
    @TableField(value = "coferemce")
	private Double coferemce;
    /**合作研究交流费 7*/
    @TableField(value = "coorperationresearchsum")
	private Double coorperationresearchsum;
    /**燃料动力费 4*/
    @TableField(value = "fuelandpower")
	private Double fuelandpower;
    /**管理费 11*/
    @TableField(value = "managesum")
	private Double managesum;
    /**市、县(市、区)补助金额*/
    @TableField(value = "applycitysum")
	private Double applycitysum;
    /**已获市、县(市、区)补助金额*/
    @TableField(value = "getcitysum")
	private Double getcitysum;
    /**技术交易实际支付金额*/
    @TableField(value = "realamount")
	private Double realamount;
    /**项目id*/
    @TableField(value = "projectbaseid")
	private String projectbaseid;
    /**省厅拨款时间*/
    @TableField(value = "getapplyprovicegvosumdate")
	private Date getapplyprovicegvosumdate;
    /**已获省厅申请费用*/
    @TableField(value = "getapplyprovicegvosum")
	private String getapplyprovicegvosum;
    /**已获自筹费用*/
    @TableField(value = "getselfsum")
	private String getselfsum;
    /**自筹时间*/
    @TableField(value = "getselfsumdate")
	private Date getselfsumdate;
    /**外协费拨出*/
    @TableField(value = "qita")
	private Double qita;
    /**激励费 12*/
    @TableField(value = "incentivefee")
	private Double incentivefee;
    /**外方投入资金*/
    @TableField(value = "foreigninvestment")
	private Double foreigninvestment;
    /**单位自有货币资金*/
    @TableField(value = "unitmoney")
	private Double unitmoney;
    /**部门、地方配套*/
    @TableField(value = "departmentsmatching")
	private Double departmentsmatching;
    /**其它资金 	*/
    @TableField(value = "othermoney")
	private Double othermoney;
    /**企业获研发经费*/
    @TableField(value = "enterpriseresearchspending")
	private Double enterpriseresearchspending;
    /**设备费---科技厅专项经费*/
    @TableField(value = "equipmentone")
	private Double equipmentone;
    /**材料费---专项经费*/
    @TableField(value = "materialone")
	private Double materialone;
    /**测试化验加工费---专项经费*/
    @TableField(value = "processingtestone")
	private Double processingtestone;
    /**燃料动力费---专项经费*/
    @TableField(value = "expenditureone")
	private Double expenditureone;
    /**差旅费（指国内差旅费）---专项经费*/
    @TableField(value = "inlandtravelone")
	private Double inlandtravelone;
    /**会议费---专项经费*/
    @TableField(value = "conferenceone")
	private Double conferenceone;
    /**出版/文献/传播/知识产权事务费---专项经费*/
    @TableField(value = "publishedone")
	private Double publishedone;
    /**激励费---专项经费*/
    @TableField(value = "incentiveone")
	private Double incentiveone;
    /**管理费---专项经费*/
    @TableField(value = "managementone")
	private Double managementone;
    /**合作协作研究与交流费---专项经费*/
    @TableField(value = "collaborativeresearchone")
	private Double collaborativeresearchone;
    /**国内人员出国考察费---专项经费*/
    @TableField(value = "domesticresearchersone")
	private Double domesticresearchersone;
    /**海外专家来华交流费---专项经费*/
    @TableField(value = "overseasexpertsone")
	private Double overseasexpertsone;
    /**劳务费---专项经费*/
    @TableField(value = "laborone")
	private Double laborone;
    /**国内人员劳务费---专项经费*/
    @TableField(value = "domesticlaborone")
	private Double domesticlaborone;
    /**海外专家劳务费---专项经费*/
    @TableField(value = "overseaslaborone")
	private Double overseaslaborone;
    /**专家咨询费---专项经费*/
    @TableField(value = "consultingone")
	private Double consultingone;
    /**国内专家咨询费---专项经费*/
    @TableField(value = "domesticconsultingone")
	private Double domesticconsultingone;
    /**海外专家咨询费---专项经费*/
    @TableField(value = "overseasconsultingone")
	private Double overseasconsultingone;
    /**设备费---自筹经费*/
    @TableField(value = "equipmenttwo")
	private Double equipmenttwo;
    /**MATERIALTWO*/
    @TableField(value = "materialtwo")
	private Double materialtwo;
    /**PROCESSINGTESTTWO*/
    @TableField(value = "processingtesttwo")
	private Double processingtesttwo;
    /**EXPENDITURETWO*/
    @TableField(value = "expendituretwo")
	private Double expendituretwo;
    /**INLANDTRAVELTWO*/
    @TableField(value = "inlandtraveltwo")
	private Double inlandtraveltwo;
    /**CONFERENCETWO*/
    @TableField(value = "conferencetwo")
	private Double conferencetwo;
    /**PUBLISHEDTWO*/
    @TableField(value = "publishedtwo")
	private Double publishedtwo;
    /**INCENTIVETWO*/
    @TableField(value = "incentivetwo")
	private Double incentivetwo;
    /**MANAGEMENTTWO*/
    @TableField(value = "managementtwo")
	private Double managementtwo;
    /**COLLABORATIVERESEARCHTWO*/
    @TableField(value = "collaborativeresearchtwo")
	private Double collaborativeresearchtwo;
    /**DOMESTICRESEARCHERSTWO*/
    @TableField(value = "domesticresearcherstwo")
	private Double domesticresearcherstwo;
    /**OVERSEASEXPERTSTWO*/
    @TableField(value = "overseasexpertstwo")
	private Double overseasexpertstwo;
    /**LABORTWO*/
    @TableField(value = "labortwo")
	private Double labortwo;
    /**DOMESTICLABORTWO*/
    @TableField(value = "domesticlabortwo")
	private Double domesticlabortwo;
    /**OVERSEASLABORTWO*/
    @TableField(value = "overseaslabortwo")
	private Double overseaslabortwo;
    /**CONSULTINGTWO*/
    @TableField(value = "consultingtwo")
	private Double consultingtwo;
    /**DOMESTICCONSULTINGTWO*/
    @TableField(value = "domesticconsultingtwo")
	private Double domesticconsultingtwo;
    /**OVERSEASCONSULTINGTWO*/
    @TableField(value = "overseasconsultingtwo")
	private Double overseasconsultingtwo;
    /**设备费---外方投入*/
    @TableField(value = "equipmentthree")
	private Double equipmentthree;
    /**MATERIALTHREE*/
    @TableField(value = "materialthree")
	private Double materialthree;
    /**PROCESSINGTESTTHREE*/
    @TableField(value = "processingtestthree")
	private Double processingtestthree;
    /**EXPENDITURETHREE*/
    @TableField(value = "expenditurethree")
	private Double expenditurethree;
    /**INLANDTRAVELTHREE*/
    @TableField(value = "inlandtravelthree")
	private Double inlandtravelthree;
    /**CONFERENCETHREE*/
    @TableField(value = "conferencethree")
	private Double conferencethree;
    /**PUBLISHEDTHREE*/
    @TableField(value = "publishedthree")
	private Double publishedthree;
    /**INCENTIVETHREE*/
    @TableField(value = "incentivethree")
	private Double incentivethree;
    /**MANAGEMENTTHREE*/
    @TableField(value = "managementthree")
	private Double managementthree;
    /**COLLABORATIVERESEARCHTHREE*/
    @TableField(value = "collaborativeresearchthree")
	private Double collaborativeresearchthree;
    /**DOMESTICRESEARCHERSTHREE*/
    @TableField(value = "domesticresearchersthree")
	private Double domesticresearchersthree;
    /**OVERSEASEXPERTSTHREE*/
    @TableField(value = "overseasexpertsthree")
	private Double overseasexpertsthree;
    /**LABORTHREE*/
    @TableField(value = "laborthree")
	private Double laborthree;
    /**DOMESTICLABORTHREE*/
    @TableField(value = "domesticlaborthree")
	private Double domesticlaborthree;
    /**OVERSEASLABORTHREE*/
    @TableField(value = "overseaslaborthree")
	private Double overseaslaborthree;
    /**CONSULTINGTHREE*/
    @TableField(value = "consultingthree")
	private Double consultingthree;
    /**DOMESTICCONSULTINGTHREE*/
    @TableField(value = "domesticconsultingthree")
	private Double domesticconsultingthree;
    /**OVERSEASCONSULTINGTHREE*/
    @TableField(value = "overseasconsultingthree")
	private Double overseasconsultingthree;
    /**设备费---合计*/
    @TableField(value = "equipmentfour")
	private Double equipmentfour;
    /**MATERIALFOUR*/
    @TableField(value = "materialfour")
	private Double materialfour;
    /**PROCESSINGTESTFOUR*/
    @TableField(value = "processingtestfour")
	private Double processingtestfour;
    /**EXPENDITUREFOUR*/
    @TableField(value = "expenditurefour")
	private Double expenditurefour;
    /**INLANDTRAVELFOUR*/
    @TableField(value = "inlandtravelfour")
	private Double inlandtravelfour;
    /**CONFERENCEFOUR*/
    @TableField(value = "conferencefour")
	private Double conferencefour;
    /**PUBLISHEDFOUR*/
    @TableField(value = "publishedfour")
	private Double publishedfour;
    /**INCENTIVEFOUR*/
    @TableField(value = "incentivefour")
	private Double incentivefour;
    /**MANAGEMENTFOUR*/
    @TableField(value = "managementfour")
	private Double managementfour;
    /**COLLABORATIVERESEARCHFOUR*/
    @TableField(value = "collaborativeresearchfour")
	private Double collaborativeresearchfour;
    /**DOMESTICRESEARCHERSFOUR*/
    @TableField(value = "domesticresearchersfour")
	private Double domesticresearchersfour;
    /**OVERSEASEXPERTSFOUR*/
    @TableField(value = "overseasexpertsfour")
	private Double overseasexpertsfour;
    /**LABORFOUR*/
    @TableField(value = "laborfour")
	private Double laborfour;
    /**DOMESTICLABORFOUR*/
    @TableField(value = "domesticlaborfour")
	private Double domesticlaborfour;
    /**OVERSEASLABORFOUR*/
    @TableField(value = "overseaslaborfour")
	private Double overseaslaborfour;
    /**CONSULTINGFOUR*/
    @TableField(value = "consultingfour")
	private Double consultingfour;
    /**DOMESTICCONSULTINGFOUR*/
    @TableField(value = "domesticconsultingfour")
	private Double domesticconsultingfour;
    /**OVERSEASCONSULTINGFOUR*/
    @TableField(value = "overseasconsultingfour")
	private Double overseasconsultingfour;
    /**INSTRUMENTSUM3*/
    @TableField(value = "instrumentsum3")
	private Double instrumentsum3;
    /**INSTRUMENTSUM2*/
    @TableField(value = "instrumentsum2")
	private Double instrumentsum2;
    /**INSTRUMENTSUM1*/
    @TableField(value = "instrumentsum1")
	private Double instrumentsum1;
    /**TOTALLABOR*/
    @TableField(value = "totallabor")
	private Double totallabor;
    /**REASON*/
    @TableField(value = "reason")
	private Double reason;
    /**PROFESSIONALTITLE*/
    @TableField(value = "professionaltitle")
	private String professionaltitle;
    /**CREATETIME*/
    @TableField(value = "createtime")
	private Double createtime;
    /**CREATELABORFEE*/
    @TableField(value = "createlaborfee")
	private Double createlaborfee;
    /**TESTCONTENT*/
    @TableField(value = "testcontent")
	private String testcontent;
    /**TESTCONTENTUNIT*/
    @TableField(value = "testcontentunit")
	private String testcontentunit;
    /**COMMUNICATEWAY*/
    @TableField(value = "communicateway")
	private Double communicateway;
    /**COMMUNICATEUNIT*/
    @TableField(value = "communicateunit")
	private Double communicateunit;
    /**PROJECTSUMFORSELF1*/
    @TableField(value = "projectsumforself1")
	private Double projectsumforself1;
    /**PROJECTSUMFORSELF2*/
    @TableField(value = "projectsumforself2")
	private Double projectsumforself2;
    /**PROJECTSUMFORSELF3*/
    @TableField(value = "projectsumforself3")
	private Double projectsumforself3;
    /**PROJECTSUMFORGOV*/
    @TableField(value = "projectsumforgov")
	private Double projectsumforgov;
    /**PROJECTSUMFORSELF*/
    @TableField(value = "projectsumforself")
	private Double projectsumforself;
    /**项目预算申报书ID*/
    @TableField(value = "xmsbsid")
	private String xmsbsid;
    /**购置费备注*/
    @TableField(value = "instrumentsum1note")
	private String instrumentsum1note;
    /**改造费备注*/
    @TableField(value = "instrumentsum2note")
	private String instrumentsum2note;
    /**租赁费备注*/
    @TableField(value = "instrumentsum3note")
	private String instrumentsum3note;
    /**材料费备注*/
    @TableField(value = "materialexpensenote")
	private String materialexpensenote;
    /**试验加工费备注*/
    @TableField(value = "proceedingschargesnote")
	private String proceedingschargesnote;
    /**燃料动力费备注*/
    @TableField(value = "fuelandpowernote")
	private String fuelandpowernote;
    /**差旅费备注*/
    @TableField(value = "businesstripsumnote")
	private String businesstripsumnote;
    /**会议费备注*/
    @TableField(value = "conferemcenote")
	private String conferemcenote;
    /**合作交流费备注*/
    @TableField(value = "coorperationresearchsumnote")
	private String coorperationresearchsumnote;
    /**出版费备注*/
    @TableField(value = "adminstrativeservicesumnote")
	private String adminstrativeservicesumnote;
    /**人员劳务费备注*/
    @TableField(value = "servicefeenote")
	private String servicefeenote;
    /**专家咨询费备注*/
    @TableField(value = "adviceforexpertsumnote")
	private String adviceforexpertsumnote;
    /**设备费申请申请*/
    @TableField(value = "instrumentsumkjt")
	private Double instrumentsumkjt;
    /**购置设备费科技厅*/
    @TableField(value = "instrumentsum1kjt")
	private Double instrumentsum1kjt;
    /**改造设备费科技厅*/
    @TableField(value = "instrumentsum2kjt")
	private Double instrumentsum2kjt;
    /**设备租赁费科技厅*/
    @TableField(value = "instrumentsum3kjt")
	private Double instrumentsum3kjt;
    /**材料费科技厅*/
    @TableField(value = "materialexpensekjt")
	private Double materialexpensekjt;
    /**测试化验加工费科技厅*/
    @TableField(value = "proceedingschargeskjt")
	private Double proceedingschargeskjt;
    /** 燃料动力费科技厅*/
    @TableField(value = "fuelandpowerkjt")
	private Double fuelandpowerkjt;
    /**差旅费科技厅*/
    @TableField(value = "businesstripsumkjt")
	private Double businesstripsumkjt;
    /**会议费科技厅*/
    @TableField(value = "coferemcekjt")
	private Double coferemcekjt;
    /**合作研究交流费科技厅*/
    @TableField(value = "coorperationresearchsumkjt")
	private Double coorperationresearchsumkjt;
    /**出版科技厅*/
    @TableField(value = "adminstrativeservicesumkjt")
	private Double adminstrativeservicesumkjt;
    /**劳务费科技厅*/
    @TableField(value = "servicefeekjt")
	private Double servicefeekjt;
    /**专家咨询费科技厅*/
    @TableField(value = "adviceforexpertsumkjt")
	private Double adviceforexpertsumkjt;
    /**管理费科技厅*/
    @TableField(value = "managesumkjt")
	private Double managesumkjt;
    /**QITAKJT*/
    @TableField(value = "qitakjt")
	private Double qitakjt;
    /**总计费用*/
    @TableField(value = "totalsumkjt")
	private Double totalsumkjt;
    /**计划投资总额*/
    @TableField(value = "jhtzze")
	private Double jhtzze;
    /**已完成投资*/
    @TableField(value = "ywctz")
	private Double ywctz;
    /**其中：自筹*/
    @TableField(value = "ywctzzc")
	private Double ywctzzc;
    /**计划新增投资*/
    @TableField(value = "jhxztz")
	private Double jhxztz;
    /**其中：申请科技经费*/
    @TableField(value = "jhxtzkjjf")
	private Double jhxtzkjjf;
    /**其中：自筹*/
    @TableField(value = "jhxtzzc")
	private Double jhxtzzc;
    /**其中：其他拨款*/
    @TableField(value = "jhxtzqtbk")
	private Double jhxtzqtbk;
    /**直接费用*/
    @TableField(value = "totalzjsum")
	private Double totalzjsum;
    /**直接费用科技经费*/
    @TableField(value = "totalzjsumkjt")
	private Double totalzjsumkjt;
    /**间接费用*/
    @TableField(value = "totaljjsum")
	private Double totaljjsum;
    /**间接费用科技经费*/
    @TableField(value = "totaljjsumkjt")
	private Double totaljjsumkjt;
    /**技校支出*/
    @TableField(value = "jxzc")
	private Double jxzc;
    /**JXZCKJT*/
    @TableField(value = "jxzckjt")
	private Double jxzckjt;
    /**差旅费/会议费/国际合作与交流费*/
    @TableField(value = "clhygjhz")
	private Double clhygjhz;
    /**差旅费/会议费/国际合作与交流费科技经费*/
    @TableField(value = "clhygjhzkjt")
	private Double clhygjhzkjt;
    /**BUDGEDESC*/
    @TableField(value = "budgedesc")
	private String budgedesc;
    /**合同ID*/
    @TableField(value = "pactid")
	private String pactid;
    /**国家其它拨款*/
    @TableField(value = "gjqtbk")
	private Double gjqtbk;
    /**部门拨款*/
    @TableField(value = "bmbk")
	private Double bmbk;
    /**地方拨款*/
    @TableField(value = "dfbk")
	private Double dfbk;
    /**其它来源*/
    @TableField(value = "qily")
	private Double qily;
    /**TOTALSUMZC*/
    @TableField(value = "totalsumzc")
	private Double totalsumzc;
    /**INSTRUMENTSUMZC*/
    @TableField(value = "instrumentsumzc")
	private Double instrumentsumzc;
    /**INSTRUMENTSUM1ZC*/
    @TableField(value = "instrumentsum1zc")
	private Double instrumentsum1zc;
    /**INSTRUMENTSUM2ZC*/
    @TableField(value = "instrumentsum2zc")
	private Double instrumentsum2zc;
    /**INSTRUMENTSUM3ZC*/
    @TableField(value = "instrumentsum3zc")
	private Double instrumentsum3zc;
    /**BUSINESSTRIPSUMZC*/
    @TableField(value = "businesstripsumzc")
	private Double businesstripsumzc;
    /**ADVICEFOREXPERTSUMZC*/
    @TableField(value = "adviceforexpertsumzc")
	private Double adviceforexpertsumzc;
    /**MATERIALEXPENSEZC*/
    @TableField(value = "materialexpensezc")
	private Double materialexpensezc;
    /**SERVICEFEEZC*/
    @TableField(value = "servicefeezc")
	private Double servicefeezc;
    /**ADMINSTRATIVESERVICESUMZC*/
    @TableField(value = "adminstrativeservicesumzc")
	private Double adminstrativeservicesumzc;
    /**PROCEEDINGSCHARGESZC*/
    @TableField(value = "proceedingschargeszc")
	private Double proceedingschargeszc;
    /**COFEREMCEZC*/
    @TableField(value = "coferemcezc")
	private Double coferemcezc;
    /**COORPERATIONRESEARCHSUMZC*/
    @TableField(value = "coorperationresearchsumzc")
	private Double coorperationresearchsumzc;
    /**FUELANDPOWERZC*/
    @TableField(value = "fuelandpowerzc")
	private Double fuelandpowerzc;
    /**MANAGESUMZC*/
    @TableField(value = "managesumzc")
	private Double managesumzc;
    /**TOTALZJSUMZC*/
    @TableField(value = "totalzjsumzc")
	private Double totalzjsumzc;
    /**TOTALJJSUMZC*/
    @TableField(value = "totaljjsumzc")
	private Double totaljjsumzc;
    /**JXZCZC*/
    @TableField(value = "jxzczc")
	private Double jxzczc;
    /**CLHYGJHZZC*/
    @TableField(value = "clhygjhzzc")
	private Double clhygjhzzc;
    /**QITAZC*/
    @TableField(value = "qitazc")
	private Double qitazc;
	
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
	 * 获取  selfsum
	 *@return: Double  自筹费用
	 */
	public Double getSelfsum(){
		return this.selfsum;
	}

	/**
	 * 设置  selfsum
	 *@param: selfsum  自筹费用
	 */
	public void setSelfsum(Double selfsum){
		this.selfsum = selfsum;
	}
	/**
	 * 获取  applyprovicegvosum
	 *@return: Double  向省厅申请费用
	 */
	public Double getApplyprovicegvosum(){
		return this.applyprovicegvosum;
	}

	/**
	 * 设置  applyprovicegvosum
	 *@param: applyprovicegvosum  向省厅申请费用
	 */
	public void setApplyprovicegvosum(Double applyprovicegvosum){
		this.applyprovicegvosum = applyprovicegvosum;
	}
	/**
	 * 获取  totalsum
	 *@return: Double  总计费用
	 */
	public Double getTotalsum(){
		return this.totalsum;
	}

	/**
	 * 设置  totalsum
	 *@param: totalsum  总计费用
	 */
	public void setTotalsum(Double totalsum){
		this.totalsum = totalsum;
	}
	/**
	 * 获取  instrumentsum
	 *@return: Double  设备费 1
	 */
	public Double getInstrumentsum(){
		return this.instrumentsum;
	}

	/**
	 * 设置  instrumentsum
	 *@param: instrumentsum  设备费 1
	 */
	public void setInstrumentsum(Double instrumentsum){
		this.instrumentsum = instrumentsum;
	}
	/**
	 * 获取  businesstripsum
	 *@return: Double  差旅费 5
	 */
	public Double getBusinesstripsum(){
		return this.businesstripsum;
	}

	/**
	 * 设置  businesstripsum
	 *@param: businesstripsum  差旅费 5
	 */
	public void setBusinesstripsum(Double businesstripsum){
		this.businesstripsum = businesstripsum;
	}
	/**
	 * 获取  adviceforexpertsum
	 *@return: Double  专家咨询费 10
	 */
	public Double getAdviceforexpertsum(){
		return this.adviceforexpertsum;
	}

	/**
	 * 设置  adviceforexpertsum
	 *@param: adviceforexpertsum  专家咨询费 10
	 */
	public void setAdviceforexpertsum(Double adviceforexpertsum){
		this.adviceforexpertsum = adviceforexpertsum;
	}
	/**
	 * 获取  materialexpense
	 *@return: Double  材料费 2
	 */
	public Double getMaterialexpense(){
		return this.materialexpense;
	}

	/**
	 * 设置  materialexpense
	 *@param: materialexpense  材料费 2
	 */
	public void setMaterialexpense(Double materialexpense){
		this.materialexpense = materialexpense;
	}
	/**
	 * 获取  servicefee
	 *@return: Double  劳务费 9
	 */
	public Double getServicefee(){
		return this.servicefee;
	}

	/**
	 * 设置  servicefee
	 *@param: servicefee  劳务费 9
	 */
	public void setServicefee(Double servicefee){
		this.servicefee = servicefee;
	}
	/**
	 * 获取  adminstrativeservicesum
	 *@return: Double  出版费 8
	 */
	public Double getAdminstrativeservicesum(){
		return this.adminstrativeservicesum;
	}

	/**
	 * 设置  adminstrativeservicesum
	 *@param: adminstrativeservicesum  出版费 8
	 */
	public void setAdminstrativeservicesum(Double adminstrativeservicesum){
		this.adminstrativeservicesum = adminstrativeservicesum;
	}
	/**
	 * 获取  proceedingscharges
	 *@return: Double  测试化验加工费 3
	 */
	public Double getProceedingscharges(){
		return this.proceedingscharges;
	}

	/**
	 * 设置  proceedingscharges
	 *@param: proceedingscharges  测试化验加工费 3
	 */
	public void setProceedingscharges(Double proceedingscharges){
		this.proceedingscharges = proceedingscharges;
	}
	/**
	 * 获取  coferemce
	 *@return: Double  会议费 6
	 */
	public Double getCoferemce(){
		return this.coferemce;
	}

	/**
	 * 设置  coferemce
	 *@param: coferemce  会议费 6
	 */
	public void setCoferemce(Double coferemce){
		this.coferemce = coferemce;
	}
	/**
	 * 获取  coorperationresearchsum
	 *@return: Double  合作研究交流费 7
	 */
	public Double getCoorperationresearchsum(){
		return this.coorperationresearchsum;
	}

	/**
	 * 设置  coorperationresearchsum
	 *@param: coorperationresearchsum  合作研究交流费 7
	 */
	public void setCoorperationresearchsum(Double coorperationresearchsum){
		this.coorperationresearchsum = coorperationresearchsum;
	}
	/**
	 * 获取  fuelandpower
	 *@return: Double  燃料动力费 4
	 */
	public Double getFuelandpower(){
		return this.fuelandpower;
	}

	/**
	 * 设置  fuelandpower
	 *@param: fuelandpower  燃料动力费 4
	 */
	public void setFuelandpower(Double fuelandpower){
		this.fuelandpower = fuelandpower;
	}
	/**
	 * 获取  managesum
	 *@return: Double  管理费 11
	 */
	public Double getManagesum(){
		return this.managesum;
	}

	/**
	 * 设置  managesum
	 *@param: managesum  管理费 11
	 */
	public void setManagesum(Double managesum){
		this.managesum = managesum;
	}
	/**
	 * 获取  applycitysum
	 *@return: Double  市、县(市、区)补助金额
	 */
	public Double getApplycitysum(){
		return this.applycitysum;
	}

	/**
	 * 设置  applycitysum
	 *@param: applycitysum  市、县(市、区)补助金额
	 */
	public void setApplycitysum(Double applycitysum){
		this.applycitysum = applycitysum;
	}
	/**
	 * 获取  getcitysum
	 *@return: Double  已获市、县(市、区)补助金额
	 */
	public Double getGetcitysum(){
		return this.getcitysum;
	}

	/**
	 * 设置  getcitysum
	 *@param: getcitysum  已获市、县(市、区)补助金额
	 */
	public void setGetcitysum(Double getcitysum){
		this.getcitysum = getcitysum;
	}
	/**
	 * 获取  realamount
	 *@return: Double  技术交易实际支付金额
	 */
	public Double getRealamount(){
		return this.realamount;
	}

	/**
	 * 设置  realamount
	 *@param: realamount  技术交易实际支付金额
	 */
	public void setRealamount(Double realamount){
		this.realamount = realamount;
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
	 * 获取  getapplyprovicegvosumdate
	 *@return: Date  省厅拨款时间
	 */
	public Date getGetapplyprovicegvosumdate(){
		return this.getapplyprovicegvosumdate;
	}

	/**
	 * 设置  getapplyprovicegvosumdate
	 *@param: getapplyprovicegvosumdate  省厅拨款时间
	 */
	public void setGetapplyprovicegvosumdate(Date getapplyprovicegvosumdate){
		this.getapplyprovicegvosumdate = getapplyprovicegvosumdate;
	}
	/**
	 * 获取  getapplyprovicegvosum
	 *@return: String  已获省厅申请费用
	 */
	public String getGetapplyprovicegvosum(){
		return this.getapplyprovicegvosum;
	}

	/**
	 * 设置  getapplyprovicegvosum
	 *@param: getapplyprovicegvosum  已获省厅申请费用
	 */
	public void setGetapplyprovicegvosum(String getapplyprovicegvosum){
		this.getapplyprovicegvosum = getapplyprovicegvosum;
	}
	/**
	 * 获取  getselfsum
	 *@return: String  已获自筹费用
	 */
	public String getGetselfsum(){
		return this.getselfsum;
	}

	/**
	 * 设置  getselfsum
	 *@param: getselfsum  已获自筹费用
	 */
	public void setGetselfsum(String getselfsum){
		this.getselfsum = getselfsum;
	}
	/**
	 * 获取  getselfsumdate
	 *@return: Date  自筹时间
	 */
	public Date getGetselfsumdate(){
		return this.getselfsumdate;
	}

	/**
	 * 设置  getselfsumdate
	 *@param: getselfsumdate  自筹时间
	 */
	public void setGetselfsumdate(Date getselfsumdate){
		this.getselfsumdate = getselfsumdate;
	}
	/**
	 * 获取  qita
	 *@return: Double  外协费拨出
	 */
	public Double getQita(){
		return this.qita;
	}

	/**
	 * 设置  qita
	 *@param: qita  外协费拨出
	 */
	public void setQita(Double qita){
		this.qita = qita;
	}
	/**
	 * 获取  incentivefee
	 *@return: Double  激励费 12
	 */
	public Double getIncentivefee(){
		return this.incentivefee;
	}

	/**
	 * 设置  incentivefee
	 *@param: incentivefee  激励费 12
	 */
	public void setIncentivefee(Double incentivefee){
		this.incentivefee = incentivefee;
	}
	/**
	 * 获取  foreigninvestment
	 *@return: Double  外方投入资金
	 */
	public Double getForeigninvestment(){
		return this.foreigninvestment;
	}

	/**
	 * 设置  foreigninvestment
	 *@param: foreigninvestment  外方投入资金
	 */
	public void setForeigninvestment(Double foreigninvestment){
		this.foreigninvestment = foreigninvestment;
	}
	/**
	 * 获取  unitmoney
	 *@return: Double  单位自有货币资金
	 */
	public Double getUnitmoney(){
		return this.unitmoney;
	}

	/**
	 * 设置  unitmoney
	 *@param: unitmoney  单位自有货币资金
	 */
	public void setUnitmoney(Double unitmoney){
		this.unitmoney = unitmoney;
	}
	/**
	 * 获取  departmentsmatching
	 *@return: Double  部门、地方配套
	 */
	public Double getDepartmentsmatching(){
		return this.departmentsmatching;
	}

	/**
	 * 设置  departmentsmatching
	 *@param: departmentsmatching  部门、地方配套
	 */
	public void setDepartmentsmatching(Double departmentsmatching){
		this.departmentsmatching = departmentsmatching;
	}
	/**
	 * 获取  othermoney
	 *@return: Double  其它资金 	
	 */
	public Double getOthermoney(){
		return this.othermoney;
	}

	/**
	 * 设置  othermoney
	 *@param: othermoney  其它资金 	
	 */
	public void setOthermoney(Double othermoney){
		this.othermoney = othermoney;
	}
	/**
	 * 获取  enterpriseresearchspending
	 *@return: Double  企业获研发经费
	 */
	public Double getEnterpriseresearchspending(){
		return this.enterpriseresearchspending;
	}

	/**
	 * 设置  enterpriseresearchspending
	 *@param: enterpriseresearchspending  企业获研发经费
	 */
	public void setEnterpriseresearchspending(Double enterpriseresearchspending){
		this.enterpriseresearchspending = enterpriseresearchspending;
	}
	/**
	 * 获取  equipmentone
	 *@return: Double  设备费---科技厅专项经费
	 */
	public Double getEquipmentone(){
		return this.equipmentone;
	}

	/**
	 * 设置  equipmentone
	 *@param: equipmentone  设备费---科技厅专项经费
	 */
	public void setEquipmentone(Double equipmentone){
		this.equipmentone = equipmentone;
	}
	/**
	 * 获取  materialone
	 *@return: Double  材料费---专项经费
	 */
	public Double getMaterialone(){
		return this.materialone;
	}

	/**
	 * 设置  materialone
	 *@param: materialone  材料费---专项经费
	 */
	public void setMaterialone(Double materialone){
		this.materialone = materialone;
	}
	/**
	 * 获取  processingtestone
	 *@return: Double  测试化验加工费---专项经费
	 */
	public Double getProcessingtestone(){
		return this.processingtestone;
	}

	/**
	 * 设置  processingtestone
	 *@param: processingtestone  测试化验加工费---专项经费
	 */
	public void setProcessingtestone(Double processingtestone){
		this.processingtestone = processingtestone;
	}
	/**
	 * 获取  expenditureone
	 *@return: Double  燃料动力费---专项经费
	 */
	public Double getExpenditureone(){
		return this.expenditureone;
	}

	/**
	 * 设置  expenditureone
	 *@param: expenditureone  燃料动力费---专项经费
	 */
	public void setExpenditureone(Double expenditureone){
		this.expenditureone = expenditureone;
	}
	/**
	 * 获取  inlandtravelone
	 *@return: Double  差旅费（指国内差旅费）---专项经费
	 */
	public Double getInlandtravelone(){
		return this.inlandtravelone;
	}

	/**
	 * 设置  inlandtravelone
	 *@param: inlandtravelone  差旅费（指国内差旅费）---专项经费
	 */
	public void setInlandtravelone(Double inlandtravelone){
		this.inlandtravelone = inlandtravelone;
	}
	/**
	 * 获取  conferenceone
	 *@return: Double  会议费---专项经费
	 */
	public Double getConferenceone(){
		return this.conferenceone;
	}

	/**
	 * 设置  conferenceone
	 *@param: conferenceone  会议费---专项经费
	 */
	public void setConferenceone(Double conferenceone){
		this.conferenceone = conferenceone;
	}
	/**
	 * 获取  publishedone
	 *@return: Double  出版/文献/传播/知识产权事务费---专项经费
	 */
	public Double getPublishedone(){
		return this.publishedone;
	}

	/**
	 * 设置  publishedone
	 *@param: publishedone  出版/文献/传播/知识产权事务费---专项经费
	 */
	public void setPublishedone(Double publishedone){
		this.publishedone = publishedone;
	}
	/**
	 * 获取  incentiveone
	 *@return: Double  激励费---专项经费
	 */
	public Double getIncentiveone(){
		return this.incentiveone;
	}

	/**
	 * 设置  incentiveone
	 *@param: incentiveone  激励费---专项经费
	 */
	public void setIncentiveone(Double incentiveone){
		this.incentiveone = incentiveone;
	}
	/**
	 * 获取  managementone
	 *@return: Double  管理费---专项经费
	 */
	public Double getManagementone(){
		return this.managementone;
	}

	/**
	 * 设置  managementone
	 *@param: managementone  管理费---专项经费
	 */
	public void setManagementone(Double managementone){
		this.managementone = managementone;
	}
	/**
	 * 获取  collaborativeresearchone
	 *@return: Double  合作协作研究与交流费---专项经费
	 */
	public Double getCollaborativeresearchone(){
		return this.collaborativeresearchone;
	}

	/**
	 * 设置  collaborativeresearchone
	 *@param: collaborativeresearchone  合作协作研究与交流费---专项经费
	 */
	public void setCollaborativeresearchone(Double collaborativeresearchone){
		this.collaborativeresearchone = collaborativeresearchone;
	}
	/**
	 * 获取  domesticresearchersone
	 *@return: Double  国内人员出国考察费---专项经费
	 */
	public Double getDomesticresearchersone(){
		return this.domesticresearchersone;
	}

	/**
	 * 设置  domesticresearchersone
	 *@param: domesticresearchersone  国内人员出国考察费---专项经费
	 */
	public void setDomesticresearchersone(Double domesticresearchersone){
		this.domesticresearchersone = domesticresearchersone;
	}
	/**
	 * 获取  overseasexpertsone
	 *@return: Double  海外专家来华交流费---专项经费
	 */
	public Double getOverseasexpertsone(){
		return this.overseasexpertsone;
	}

	/**
	 * 设置  overseasexpertsone
	 *@param: overseasexpertsone  海外专家来华交流费---专项经费
	 */
	public void setOverseasexpertsone(Double overseasexpertsone){
		this.overseasexpertsone = overseasexpertsone;
	}
	/**
	 * 获取  laborone
	 *@return: Double  劳务费---专项经费
	 */
	public Double getLaborone(){
		return this.laborone;
	}

	/**
	 * 设置  laborone
	 *@param: laborone  劳务费---专项经费
	 */
	public void setLaborone(Double laborone){
		this.laborone = laborone;
	}
	/**
	 * 获取  domesticlaborone
	 *@return: Double  国内人员劳务费---专项经费
	 */
	public Double getDomesticlaborone(){
		return this.domesticlaborone;
	}

	/**
	 * 设置  domesticlaborone
	 *@param: domesticlaborone  国内人员劳务费---专项经费
	 */
	public void setDomesticlaborone(Double domesticlaborone){
		this.domesticlaborone = domesticlaborone;
	}
	/**
	 * 获取  overseaslaborone
	 *@return: Double  海外专家劳务费---专项经费
	 */
	public Double getOverseaslaborone(){
		return this.overseaslaborone;
	}

	/**
	 * 设置  overseaslaborone
	 *@param: overseaslaborone  海外专家劳务费---专项经费
	 */
	public void setOverseaslaborone(Double overseaslaborone){
		this.overseaslaborone = overseaslaborone;
	}
	/**
	 * 获取  consultingone
	 *@return: Double  专家咨询费---专项经费
	 */
	public Double getConsultingone(){
		return this.consultingone;
	}

	/**
	 * 设置  consultingone
	 *@param: consultingone  专家咨询费---专项经费
	 */
	public void setConsultingone(Double consultingone){
		this.consultingone = consultingone;
	}
	/**
	 * 获取  domesticconsultingone
	 *@return: Double  国内专家咨询费---专项经费
	 */
	public Double getDomesticconsultingone(){
		return this.domesticconsultingone;
	}

	/**
	 * 设置  domesticconsultingone
	 *@param: domesticconsultingone  国内专家咨询费---专项经费
	 */
	public void setDomesticconsultingone(Double domesticconsultingone){
		this.domesticconsultingone = domesticconsultingone;
	}
	/**
	 * 获取  overseasconsultingone
	 *@return: Double  海外专家咨询费---专项经费
	 */
	public Double getOverseasconsultingone(){
		return this.overseasconsultingone;
	}

	/**
	 * 设置  overseasconsultingone
	 *@param: overseasconsultingone  海外专家咨询费---专项经费
	 */
	public void setOverseasconsultingone(Double overseasconsultingone){
		this.overseasconsultingone = overseasconsultingone;
	}
	/**
	 * 获取  equipmenttwo
	 *@return: Double  设备费---自筹经费
	 */
	public Double getEquipmenttwo(){
		return this.equipmenttwo;
	}

	/**
	 * 设置  equipmenttwo
	 *@param: equipmenttwo  设备费---自筹经费
	 */
	public void setEquipmenttwo(Double equipmenttwo){
		this.equipmenttwo = equipmenttwo;
	}
	/**
	 * 获取  materialtwo
	 *@return: Double  MATERIALTWO
	 */
	public Double getMaterialtwo(){
		return this.materialtwo;
	}

	/**
	 * 设置  materialtwo
	 *@param: materialtwo  MATERIALTWO
	 */
	public void setMaterialtwo(Double materialtwo){
		this.materialtwo = materialtwo;
	}
	/**
	 * 获取  processingtesttwo
	 *@return: Double  PROCESSINGTESTTWO
	 */
	public Double getProcessingtesttwo(){
		return this.processingtesttwo;
	}

	/**
	 * 设置  processingtesttwo
	 *@param: processingtesttwo  PROCESSINGTESTTWO
	 */
	public void setProcessingtesttwo(Double processingtesttwo){
		this.processingtesttwo = processingtesttwo;
	}
	/**
	 * 获取  expendituretwo
	 *@return: Double  EXPENDITURETWO
	 */
	public Double getExpendituretwo(){
		return this.expendituretwo;
	}

	/**
	 * 设置  expendituretwo
	 *@param: expendituretwo  EXPENDITURETWO
	 */
	public void setExpendituretwo(Double expendituretwo){
		this.expendituretwo = expendituretwo;
	}
	/**
	 * 获取  inlandtraveltwo
	 *@return: Double  INLANDTRAVELTWO
	 */
	public Double getInlandtraveltwo(){
		return this.inlandtraveltwo;
	}

	/**
	 * 设置  inlandtraveltwo
	 *@param: inlandtraveltwo  INLANDTRAVELTWO
	 */
	public void setInlandtraveltwo(Double inlandtraveltwo){
		this.inlandtraveltwo = inlandtraveltwo;
	}
	/**
	 * 获取  conferencetwo
	 *@return: Double  CONFERENCETWO
	 */
	public Double getConferencetwo(){
		return this.conferencetwo;
	}

	/**
	 * 设置  conferencetwo
	 *@param: conferencetwo  CONFERENCETWO
	 */
	public void setConferencetwo(Double conferencetwo){
		this.conferencetwo = conferencetwo;
	}
	/**
	 * 获取  publishedtwo
	 *@return: Double  PUBLISHEDTWO
	 */
	public Double getPublishedtwo(){
		return this.publishedtwo;
	}

	/**
	 * 设置  publishedtwo
	 *@param: publishedtwo  PUBLISHEDTWO
	 */
	public void setPublishedtwo(Double publishedtwo){
		this.publishedtwo = publishedtwo;
	}
	/**
	 * 获取  incentivetwo
	 *@return: Double  INCENTIVETWO
	 */
	public Double getIncentivetwo(){
		return this.incentivetwo;
	}

	/**
	 * 设置  incentivetwo
	 *@param: incentivetwo  INCENTIVETWO
	 */
	public void setIncentivetwo(Double incentivetwo){
		this.incentivetwo = incentivetwo;
	}
	/**
	 * 获取  managementtwo
	 *@return: Double  MANAGEMENTTWO
	 */
	public Double getManagementtwo(){
		return this.managementtwo;
	}

	/**
	 * 设置  managementtwo
	 *@param: managementtwo  MANAGEMENTTWO
	 */
	public void setManagementtwo(Double managementtwo){
		this.managementtwo = managementtwo;
	}
	/**
	 * 获取  collaborativeresearchtwo
	 *@return: Double  COLLABORATIVERESEARCHTWO
	 */
	public Double getCollaborativeresearchtwo(){
		return this.collaborativeresearchtwo;
	}

	/**
	 * 设置  collaborativeresearchtwo
	 *@param: collaborativeresearchtwo  COLLABORATIVERESEARCHTWO
	 */
	public void setCollaborativeresearchtwo(Double collaborativeresearchtwo){
		this.collaborativeresearchtwo = collaborativeresearchtwo;
	}
	/**
	 * 获取  domesticresearcherstwo
	 *@return: Double  DOMESTICRESEARCHERSTWO
	 */
	public Double getDomesticresearcherstwo(){
		return this.domesticresearcherstwo;
	}

	/**
	 * 设置  domesticresearcherstwo
	 *@param: domesticresearcherstwo  DOMESTICRESEARCHERSTWO
	 */
	public void setDomesticresearcherstwo(Double domesticresearcherstwo){
		this.domesticresearcherstwo = domesticresearcherstwo;
	}
	/**
	 * 获取  overseasexpertstwo
	 *@return: Double  OVERSEASEXPERTSTWO
	 */
	public Double getOverseasexpertstwo(){
		return this.overseasexpertstwo;
	}

	/**
	 * 设置  overseasexpertstwo
	 *@param: overseasexpertstwo  OVERSEASEXPERTSTWO
	 */
	public void setOverseasexpertstwo(Double overseasexpertstwo){
		this.overseasexpertstwo = overseasexpertstwo;
	}
	/**
	 * 获取  labortwo
	 *@return: Double  LABORTWO
	 */
	public Double getLabortwo(){
		return this.labortwo;
	}

	/**
	 * 设置  labortwo
	 *@param: labortwo  LABORTWO
	 */
	public void setLabortwo(Double labortwo){
		this.labortwo = labortwo;
	}
	/**
	 * 获取  domesticlabortwo
	 *@return: Double  DOMESTICLABORTWO
	 */
	public Double getDomesticlabortwo(){
		return this.domesticlabortwo;
	}

	/**
	 * 设置  domesticlabortwo
	 *@param: domesticlabortwo  DOMESTICLABORTWO
	 */
	public void setDomesticlabortwo(Double domesticlabortwo){
		this.domesticlabortwo = domesticlabortwo;
	}
	/**
	 * 获取  overseaslabortwo
	 *@return: Double  OVERSEASLABORTWO
	 */
	public Double getOverseaslabortwo(){
		return this.overseaslabortwo;
	}

	/**
	 * 设置  overseaslabortwo
	 *@param: overseaslabortwo  OVERSEASLABORTWO
	 */
	public void setOverseaslabortwo(Double overseaslabortwo){
		this.overseaslabortwo = overseaslabortwo;
	}
	/**
	 * 获取  consultingtwo
	 *@return: Double  CONSULTINGTWO
	 */
	public Double getConsultingtwo(){
		return this.consultingtwo;
	}

	/**
	 * 设置  consultingtwo
	 *@param: consultingtwo  CONSULTINGTWO
	 */
	public void setConsultingtwo(Double consultingtwo){
		this.consultingtwo = consultingtwo;
	}
	/**
	 * 获取  domesticconsultingtwo
	 *@return: Double  DOMESTICCONSULTINGTWO
	 */
	public Double getDomesticconsultingtwo(){
		return this.domesticconsultingtwo;
	}

	/**
	 * 设置  domesticconsultingtwo
	 *@param: domesticconsultingtwo  DOMESTICCONSULTINGTWO
	 */
	public void setDomesticconsultingtwo(Double domesticconsultingtwo){
		this.domesticconsultingtwo = domesticconsultingtwo;
	}
	/**
	 * 获取  overseasconsultingtwo
	 *@return: Double  OVERSEASCONSULTINGTWO
	 */
	public Double getOverseasconsultingtwo(){
		return this.overseasconsultingtwo;
	}

	/**
	 * 设置  overseasconsultingtwo
	 *@param: overseasconsultingtwo  OVERSEASCONSULTINGTWO
	 */
	public void setOverseasconsultingtwo(Double overseasconsultingtwo){
		this.overseasconsultingtwo = overseasconsultingtwo;
	}
	/**
	 * 获取  equipmentthree
	 *@return: Double  设备费---外方投入
	 */
	public Double getEquipmentthree(){
		return this.equipmentthree;
	}

	/**
	 * 设置  equipmentthree
	 *@param: equipmentthree  设备费---外方投入
	 */
	public void setEquipmentthree(Double equipmentthree){
		this.equipmentthree = equipmentthree;
	}
	/**
	 * 获取  materialthree
	 *@return: Double  MATERIALTHREE
	 */
	public Double getMaterialthree(){
		return this.materialthree;
	}

	/**
	 * 设置  materialthree
	 *@param: materialthree  MATERIALTHREE
	 */
	public void setMaterialthree(Double materialthree){
		this.materialthree = materialthree;
	}
	/**
	 * 获取  processingtestthree
	 *@return: Double  PROCESSINGTESTTHREE
	 */
	public Double getProcessingtestthree(){
		return this.processingtestthree;
	}

	/**
	 * 设置  processingtestthree
	 *@param: processingtestthree  PROCESSINGTESTTHREE
	 */
	public void setProcessingtestthree(Double processingtestthree){
		this.processingtestthree = processingtestthree;
	}
	/**
	 * 获取  expenditurethree
	 *@return: Double  EXPENDITURETHREE
	 */
	public Double getExpenditurethree(){
		return this.expenditurethree;
	}

	/**
	 * 设置  expenditurethree
	 *@param: expenditurethree  EXPENDITURETHREE
	 */
	public void setExpenditurethree(Double expenditurethree){
		this.expenditurethree = expenditurethree;
	}
	/**
	 * 获取  inlandtravelthree
	 *@return: Double  INLANDTRAVELTHREE
	 */
	public Double getInlandtravelthree(){
		return this.inlandtravelthree;
	}

	/**
	 * 设置  inlandtravelthree
	 *@param: inlandtravelthree  INLANDTRAVELTHREE
	 */
	public void setInlandtravelthree(Double inlandtravelthree){
		this.inlandtravelthree = inlandtravelthree;
	}
	/**
	 * 获取  conferencethree
	 *@return: Double  CONFERENCETHREE
	 */
	public Double getConferencethree(){
		return this.conferencethree;
	}

	/**
	 * 设置  conferencethree
	 *@param: conferencethree  CONFERENCETHREE
	 */
	public void setConferencethree(Double conferencethree){
		this.conferencethree = conferencethree;
	}
	/**
	 * 获取  publishedthree
	 *@return: Double  PUBLISHEDTHREE
	 */
	public Double getPublishedthree(){
		return this.publishedthree;
	}

	/**
	 * 设置  publishedthree
	 *@param: publishedthree  PUBLISHEDTHREE
	 */
	public void setPublishedthree(Double publishedthree){
		this.publishedthree = publishedthree;
	}
	/**
	 * 获取  incentivethree
	 *@return: Double  INCENTIVETHREE
	 */
	public Double getIncentivethree(){
		return this.incentivethree;
	}

	/**
	 * 设置  incentivethree
	 *@param: incentivethree  INCENTIVETHREE
	 */
	public void setIncentivethree(Double incentivethree){
		this.incentivethree = incentivethree;
	}
	/**
	 * 获取  managementthree
	 *@return: Double  MANAGEMENTTHREE
	 */
	public Double getManagementthree(){
		return this.managementthree;
	}

	/**
	 * 设置  managementthree
	 *@param: managementthree  MANAGEMENTTHREE
	 */
	public void setManagementthree(Double managementthree){
		this.managementthree = managementthree;
	}
	/**
	 * 获取  collaborativeresearchthree
	 *@return: Double  COLLABORATIVERESEARCHTHREE
	 */
	public Double getCollaborativeresearchthree(){
		return this.collaborativeresearchthree;
	}

	/**
	 * 设置  collaborativeresearchthree
	 *@param: collaborativeresearchthree  COLLABORATIVERESEARCHTHREE
	 */
	public void setCollaborativeresearchthree(Double collaborativeresearchthree){
		this.collaborativeresearchthree = collaborativeresearchthree;
	}
	/**
	 * 获取  domesticresearchersthree
	 *@return: Double  DOMESTICRESEARCHERSTHREE
	 */
	public Double getDomesticresearchersthree(){
		return this.domesticresearchersthree;
	}

	/**
	 * 设置  domesticresearchersthree
	 *@param: domesticresearchersthree  DOMESTICRESEARCHERSTHREE
	 */
	public void setDomesticresearchersthree(Double domesticresearchersthree){
		this.domesticresearchersthree = domesticresearchersthree;
	}
	/**
	 * 获取  overseasexpertsthree
	 *@return: Double  OVERSEASEXPERTSTHREE
	 */
	public Double getOverseasexpertsthree(){
		return this.overseasexpertsthree;
	}

	/**
	 * 设置  overseasexpertsthree
	 *@param: overseasexpertsthree  OVERSEASEXPERTSTHREE
	 */
	public void setOverseasexpertsthree(Double overseasexpertsthree){
		this.overseasexpertsthree = overseasexpertsthree;
	}
	/**
	 * 获取  laborthree
	 *@return: Double  LABORTHREE
	 */
	public Double getLaborthree(){
		return this.laborthree;
	}

	/**
	 * 设置  laborthree
	 *@param: laborthree  LABORTHREE
	 */
	public void setLaborthree(Double laborthree){
		this.laborthree = laborthree;
	}
	/**
	 * 获取  domesticlaborthree
	 *@return: Double  DOMESTICLABORTHREE
	 */
	public Double getDomesticlaborthree(){
		return this.domesticlaborthree;
	}

	/**
	 * 设置  domesticlaborthree
	 *@param: domesticlaborthree  DOMESTICLABORTHREE
	 */
	public void setDomesticlaborthree(Double domesticlaborthree){
		this.domesticlaborthree = domesticlaborthree;
	}
	/**
	 * 获取  overseaslaborthree
	 *@return: Double  OVERSEASLABORTHREE
	 */
	public Double getOverseaslaborthree(){
		return this.overseaslaborthree;
	}

	/**
	 * 设置  overseaslaborthree
	 *@param: overseaslaborthree  OVERSEASLABORTHREE
	 */
	public void setOverseaslaborthree(Double overseaslaborthree){
		this.overseaslaborthree = overseaslaborthree;
	}
	/**
	 * 获取  consultingthree
	 *@return: Double  CONSULTINGTHREE
	 */
	public Double getConsultingthree(){
		return this.consultingthree;
	}

	/**
	 * 设置  consultingthree
	 *@param: consultingthree  CONSULTINGTHREE
	 */
	public void setConsultingthree(Double consultingthree){
		this.consultingthree = consultingthree;
	}
	/**
	 * 获取  domesticconsultingthree
	 *@return: Double  DOMESTICCONSULTINGTHREE
	 */
	public Double getDomesticconsultingthree(){
		return this.domesticconsultingthree;
	}

	/**
	 * 设置  domesticconsultingthree
	 *@param: domesticconsultingthree  DOMESTICCONSULTINGTHREE
	 */
	public void setDomesticconsultingthree(Double domesticconsultingthree){
		this.domesticconsultingthree = domesticconsultingthree;
	}
	/**
	 * 获取  overseasconsultingthree
	 *@return: Double  OVERSEASCONSULTINGTHREE
	 */
	public Double getOverseasconsultingthree(){
		return this.overseasconsultingthree;
	}

	/**
	 * 设置  overseasconsultingthree
	 *@param: overseasconsultingthree  OVERSEASCONSULTINGTHREE
	 */
	public void setOverseasconsultingthree(Double overseasconsultingthree){
		this.overseasconsultingthree = overseasconsultingthree;
	}
	/**
	 * 获取  equipmentfour
	 *@return: Double  设备费---合计
	 */
	public Double getEquipmentfour(){
		return this.equipmentfour;
	}

	/**
	 * 设置  equipmentfour
	 *@param: equipmentfour  设备费---合计
	 */
	public void setEquipmentfour(Double equipmentfour){
		this.equipmentfour = equipmentfour;
	}
	/**
	 * 获取  materialfour
	 *@return: Double  MATERIALFOUR
	 */
	public Double getMaterialfour(){
		return this.materialfour;
	}

	/**
	 * 设置  materialfour
	 *@param: materialfour  MATERIALFOUR
	 */
	public void setMaterialfour(Double materialfour){
		this.materialfour = materialfour;
	}
	/**
	 * 获取  processingtestfour
	 *@return: Double  PROCESSINGTESTFOUR
	 */
	public Double getProcessingtestfour(){
		return this.processingtestfour;
	}

	/**
	 * 设置  processingtestfour
	 *@param: processingtestfour  PROCESSINGTESTFOUR
	 */
	public void setProcessingtestfour(Double processingtestfour){
		this.processingtestfour = processingtestfour;
	}
	/**
	 * 获取  expenditurefour
	 *@return: Double  EXPENDITUREFOUR
	 */
	public Double getExpenditurefour(){
		return this.expenditurefour;
	}

	/**
	 * 设置  expenditurefour
	 *@param: expenditurefour  EXPENDITUREFOUR
	 */
	public void setExpenditurefour(Double expenditurefour){
		this.expenditurefour = expenditurefour;
	}
	/**
	 * 获取  inlandtravelfour
	 *@return: Double  INLANDTRAVELFOUR
	 */
	public Double getInlandtravelfour(){
		return this.inlandtravelfour;
	}

	/**
	 * 设置  inlandtravelfour
	 *@param: inlandtravelfour  INLANDTRAVELFOUR
	 */
	public void setInlandtravelfour(Double inlandtravelfour){
		this.inlandtravelfour = inlandtravelfour;
	}
	/**
	 * 获取  conferencefour
	 *@return: Double  CONFERENCEFOUR
	 */
	public Double getConferencefour(){
		return this.conferencefour;
	}

	/**
	 * 设置  conferencefour
	 *@param: conferencefour  CONFERENCEFOUR
	 */
	public void setConferencefour(Double conferencefour){
		this.conferencefour = conferencefour;
	}
	/**
	 * 获取  publishedfour
	 *@return: Double  PUBLISHEDFOUR
	 */
	public Double getPublishedfour(){
		return this.publishedfour;
	}

	/**
	 * 设置  publishedfour
	 *@param: publishedfour  PUBLISHEDFOUR
	 */
	public void setPublishedfour(Double publishedfour){
		this.publishedfour = publishedfour;
	}
	/**
	 * 获取  incentivefour
	 *@return: Double  INCENTIVEFOUR
	 */
	public Double getIncentivefour(){
		return this.incentivefour;
	}

	/**
	 * 设置  incentivefour
	 *@param: incentivefour  INCENTIVEFOUR
	 */
	public void setIncentivefour(Double incentivefour){
		this.incentivefour = incentivefour;
	}
	/**
	 * 获取  managementfour
	 *@return: Double  MANAGEMENTFOUR
	 */
	public Double getManagementfour(){
		return this.managementfour;
	}

	/**
	 * 设置  managementfour
	 *@param: managementfour  MANAGEMENTFOUR
	 */
	public void setManagementfour(Double managementfour){
		this.managementfour = managementfour;
	}
	/**
	 * 获取  collaborativeresearchfour
	 *@return: Double  COLLABORATIVERESEARCHFOUR
	 */
	public Double getCollaborativeresearchfour(){
		return this.collaborativeresearchfour;
	}

	/**
	 * 设置  collaborativeresearchfour
	 *@param: collaborativeresearchfour  COLLABORATIVERESEARCHFOUR
	 */
	public void setCollaborativeresearchfour(Double collaborativeresearchfour){
		this.collaborativeresearchfour = collaborativeresearchfour;
	}
	/**
	 * 获取  domesticresearchersfour
	 *@return: Double  DOMESTICRESEARCHERSFOUR
	 */
	public Double getDomesticresearchersfour(){
		return this.domesticresearchersfour;
	}

	/**
	 * 设置  domesticresearchersfour
	 *@param: domesticresearchersfour  DOMESTICRESEARCHERSFOUR
	 */
	public void setDomesticresearchersfour(Double domesticresearchersfour){
		this.domesticresearchersfour = domesticresearchersfour;
	}
	/**
	 * 获取  overseasexpertsfour
	 *@return: Double  OVERSEASEXPERTSFOUR
	 */
	public Double getOverseasexpertsfour(){
		return this.overseasexpertsfour;
	}

	/**
	 * 设置  overseasexpertsfour
	 *@param: overseasexpertsfour  OVERSEASEXPERTSFOUR
	 */
	public void setOverseasexpertsfour(Double overseasexpertsfour){
		this.overseasexpertsfour = overseasexpertsfour;
	}
	/**
	 * 获取  laborfour
	 *@return: Double  LABORFOUR
	 */
	public Double getLaborfour(){
		return this.laborfour;
	}

	/**
	 * 设置  laborfour
	 *@param: laborfour  LABORFOUR
	 */
	public void setLaborfour(Double laborfour){
		this.laborfour = laborfour;
	}
	/**
	 * 获取  domesticlaborfour
	 *@return: Double  DOMESTICLABORFOUR
	 */
	public Double getDomesticlaborfour(){
		return this.domesticlaborfour;
	}

	/**
	 * 设置  domesticlaborfour
	 *@param: domesticlaborfour  DOMESTICLABORFOUR
	 */
	public void setDomesticlaborfour(Double domesticlaborfour){
		this.domesticlaborfour = domesticlaborfour;
	}
	/**
	 * 获取  overseaslaborfour
	 *@return: Double  OVERSEASLABORFOUR
	 */
	public Double getOverseaslaborfour(){
		return this.overseaslaborfour;
	}

	/**
	 * 设置  overseaslaborfour
	 *@param: overseaslaborfour  OVERSEASLABORFOUR
	 */
	public void setOverseaslaborfour(Double overseaslaborfour){
		this.overseaslaborfour = overseaslaborfour;
	}
	/**
	 * 获取  consultingfour
	 *@return: Double  CONSULTINGFOUR
	 */
	public Double getConsultingfour(){
		return this.consultingfour;
	}

	/**
	 * 设置  consultingfour
	 *@param: consultingfour  CONSULTINGFOUR
	 */
	public void setConsultingfour(Double consultingfour){
		this.consultingfour = consultingfour;
	}
	/**
	 * 获取  domesticconsultingfour
	 *@return: Double  DOMESTICCONSULTINGFOUR
	 */
	public Double getDomesticconsultingfour(){
		return this.domesticconsultingfour;
	}

	/**
	 * 设置  domesticconsultingfour
	 *@param: domesticconsultingfour  DOMESTICCONSULTINGFOUR
	 */
	public void setDomesticconsultingfour(Double domesticconsultingfour){
		this.domesticconsultingfour = domesticconsultingfour;
	}
	/**
	 * 获取  overseasconsultingfour
	 *@return: Double  OVERSEASCONSULTINGFOUR
	 */
	public Double getOverseasconsultingfour(){
		return this.overseasconsultingfour;
	}

	/**
	 * 设置  overseasconsultingfour
	 *@param: overseasconsultingfour  OVERSEASCONSULTINGFOUR
	 */
	public void setOverseasconsultingfour(Double overseasconsultingfour){
		this.overseasconsultingfour = overseasconsultingfour;
	}
	/**
	 * 获取  instrumentsum3
	 *@return: Double  INSTRUMENTSUM3
	 */
	public Double getInstrumentsum3(){
		return this.instrumentsum3;
	}

	/**
	 * 设置  instrumentsum3
	 *@param: instrumentsum3  INSTRUMENTSUM3
	 */
	public void setInstrumentsum3(Double instrumentsum3){
		this.instrumentsum3 = instrumentsum3;
	}
	/**
	 * 获取  instrumentsum2
	 *@return: Double  INSTRUMENTSUM2
	 */
	public Double getInstrumentsum2(){
		return this.instrumentsum2;
	}

	/**
	 * 设置  instrumentsum2
	 *@param: instrumentsum2  INSTRUMENTSUM2
	 */
	public void setInstrumentsum2(Double instrumentsum2){
		this.instrumentsum2 = instrumentsum2;
	}
	/**
	 * 获取  instrumentsum1
	 *@return: Double  INSTRUMENTSUM1
	 */
	public Double getInstrumentsum1(){
		return this.instrumentsum1;
	}

	/**
	 * 设置  instrumentsum1
	 *@param: instrumentsum1  INSTRUMENTSUM1
	 */
	public void setInstrumentsum1(Double instrumentsum1){
		this.instrumentsum1 = instrumentsum1;
	}
	/**
	 * 获取  totallabor
	 *@return: Double  TOTALLABOR
	 */
	public Double getTotallabor(){
		return this.totallabor;
	}

	/**
	 * 设置  totallabor
	 *@param: totallabor  TOTALLABOR
	 */
	public void setTotallabor(Double totallabor){
		this.totallabor = totallabor;
	}
	/**
	 * 获取  reason
	 *@return: Double  REASON
	 */
	public Double getReason(){
		return this.reason;
	}

	/**
	 * 设置  reason
	 *@param: reason  REASON
	 */
	public void setReason(Double reason){
		this.reason = reason;
	}
	/**
	 * 获取  professionaltitle
	 *@return: String  PROFESSIONALTITLE
	 */
	public String getProfessionaltitle(){
		return this.professionaltitle;
	}

	/**
	 * 设置  professionaltitle
	 *@param: professionaltitle  PROFESSIONALTITLE
	 */
	public void setProfessionaltitle(String professionaltitle){
		this.professionaltitle = professionaltitle;
	}
	/**
	 * 获取  createtime
	 *@return: Double  CREATETIME
	 */
	public Double getCreatetime(){
		return this.createtime;
	}

	/**
	 * 设置  createtime
	 *@param: createtime  CREATETIME
	 */
	public void setCreatetime(Double createtime){
		this.createtime = createtime;
	}
	/**
	 * 获取  createlaborfee
	 *@return: Double  CREATELABORFEE
	 */
	public Double getCreatelaborfee(){
		return this.createlaborfee;
	}

	/**
	 * 设置  createlaborfee
	 *@param: createlaborfee  CREATELABORFEE
	 */
	public void setCreatelaborfee(Double createlaborfee){
		this.createlaborfee = createlaborfee;
	}
	/**
	 * 获取  testcontent
	 *@return: String  TESTCONTENT
	 */
	public String getTestcontent(){
		return this.testcontent;
	}

	/**
	 * 设置  testcontent
	 *@param: testcontent  TESTCONTENT
	 */
	public void setTestcontent(String testcontent){
		this.testcontent = testcontent;
	}
	/**
	 * 获取  testcontentunit
	 *@return: String  TESTCONTENTUNIT
	 */
	public String getTestcontentunit(){
		return this.testcontentunit;
	}

	/**
	 * 设置  testcontentunit
	 *@param: testcontentunit  TESTCONTENTUNIT
	 */
	public void setTestcontentunit(String testcontentunit){
		this.testcontentunit = testcontentunit;
	}
	/**
	 * 获取  communicateway
	 *@return: Double  COMMUNICATEWAY
	 */
	public Double getCommunicateway(){
		return this.communicateway;
	}

	/**
	 * 设置  communicateway
	 *@param: communicateway  COMMUNICATEWAY
	 */
	public void setCommunicateway(Double communicateway){
		this.communicateway = communicateway;
	}
	/**
	 * 获取  communicateunit
	 *@return: Double  COMMUNICATEUNIT
	 */
	public Double getCommunicateunit(){
		return this.communicateunit;
	}

	/**
	 * 设置  communicateunit
	 *@param: communicateunit  COMMUNICATEUNIT
	 */
	public void setCommunicateunit(Double communicateunit){
		this.communicateunit = communicateunit;
	}
	/**
	 * 获取  projectsumforself1
	 *@return: Double  PROJECTSUMFORSELF1
	 */
	public Double getProjectsumforself1(){
		return this.projectsumforself1;
	}

	/**
	 * 设置  projectsumforself1
	 *@param: projectsumforself1  PROJECTSUMFORSELF1
	 */
	public void setProjectsumforself1(Double projectsumforself1){
		this.projectsumforself1 = projectsumforself1;
	}
	/**
	 * 获取  projectsumforself2
	 *@return: Double  PROJECTSUMFORSELF2
	 */
	public Double getProjectsumforself2(){
		return this.projectsumforself2;
	}

	/**
	 * 设置  projectsumforself2
	 *@param: projectsumforself2  PROJECTSUMFORSELF2
	 */
	public void setProjectsumforself2(Double projectsumforself2){
		this.projectsumforself2 = projectsumforself2;
	}
	/**
	 * 获取  projectsumforself3
	 *@return: Double  PROJECTSUMFORSELF3
	 */
	public Double getProjectsumforself3(){
		return this.projectsumforself3;
	}

	/**
	 * 设置  projectsumforself3
	 *@param: projectsumforself3  PROJECTSUMFORSELF3
	 */
	public void setProjectsumforself3(Double projectsumforself3){
		this.projectsumforself3 = projectsumforself3;
	}
	/**
	 * 获取  projectsumforgov
	 *@return: Double  PROJECTSUMFORGOV
	 */
	public Double getProjectsumforgov(){
		return this.projectsumforgov;
	}

	/**
	 * 设置  projectsumforgov
	 *@param: projectsumforgov  PROJECTSUMFORGOV
	 */
	public void setProjectsumforgov(Double projectsumforgov){
		this.projectsumforgov = projectsumforgov;
	}
	/**
	 * 获取  projectsumforself
	 *@return: Double  PROJECTSUMFORSELF
	 */
	public Double getProjectsumforself(){
		return this.projectsumforself;
	}

	/**
	 * 设置  projectsumforself
	 *@param: projectsumforself  PROJECTSUMFORSELF
	 */
	public void setProjectsumforself(Double projectsumforself){
		this.projectsumforself = projectsumforself;
	}
	/**
	 * 获取  xmsbsid
	 *@return: String  项目预算申报书ID
	 */
	public String getXmsbsid(){
		return this.xmsbsid;
	}

	/**
	 * 设置  xmsbsid
	 *@param: xmsbsid  项目预算申报书ID
	 */
	public void setXmsbsid(String xmsbsid){
		this.xmsbsid = xmsbsid;
	}
	/**
	 * 获取  instrumentsum1note
	 *@return: String  购置费备注
	 */
	public String getInstrumentsum1note(){
		return this.instrumentsum1note;
	}

	/**
	 * 设置  instrumentsum1note
	 *@param: instrumentsum1note  购置费备注
	 */
	public void setInstrumentsum1note(String instrumentsum1note){
		this.instrumentsum1note = instrumentsum1note;
	}
	/**
	 * 获取  instrumentsum2note
	 *@return: String  改造费备注
	 */
	public String getInstrumentsum2note(){
		return this.instrumentsum2note;
	}

	/**
	 * 设置  instrumentsum2note
	 *@param: instrumentsum2note  改造费备注
	 */
	public void setInstrumentsum2note(String instrumentsum2note){
		this.instrumentsum2note = instrumentsum2note;
	}
	/**
	 * 获取  instrumentsum3note
	 *@return: String  租赁费备注
	 */
	public String getInstrumentsum3note(){
		return this.instrumentsum3note;
	}

	/**
	 * 设置  instrumentsum3note
	 *@param: instrumentsum3note  租赁费备注
	 */
	public void setInstrumentsum3note(String instrumentsum3note){
		this.instrumentsum3note = instrumentsum3note;
	}
	/**
	 * 获取  materialexpensenote
	 *@return: String  材料费备注
	 */
	public String getMaterialexpensenote(){
		return this.materialexpensenote;
	}

	/**
	 * 设置  materialexpensenote
	 *@param: materialexpensenote  材料费备注
	 */
	public void setMaterialexpensenote(String materialexpensenote){
		this.materialexpensenote = materialexpensenote;
	}
	/**
	 * 获取  proceedingschargesnote
	 *@return: String  试验加工费备注
	 */
	public String getProceedingschargesnote(){
		return this.proceedingschargesnote;
	}

	/**
	 * 设置  proceedingschargesnote
	 *@param: proceedingschargesnote  试验加工费备注
	 */
	public void setProceedingschargesnote(String proceedingschargesnote){
		this.proceedingschargesnote = proceedingschargesnote;
	}
	/**
	 * 获取  fuelandpowernote
	 *@return: String  燃料动力费备注
	 */
	public String getFuelandpowernote(){
		return this.fuelandpowernote;
	}

	/**
	 * 设置  fuelandpowernote
	 *@param: fuelandpowernote  燃料动力费备注
	 */
	public void setFuelandpowernote(String fuelandpowernote){
		this.fuelandpowernote = fuelandpowernote;
	}
	/**
	 * 获取  businesstripsumnote
	 *@return: String  差旅费备注
	 */
	public String getBusinesstripsumnote(){
		return this.businesstripsumnote;
	}

	/**
	 * 设置  businesstripsumnote
	 *@param: businesstripsumnote  差旅费备注
	 */
	public void setBusinesstripsumnote(String businesstripsumnote){
		this.businesstripsumnote = businesstripsumnote;
	}
	/**
	 * 获取  conferemcenote
	 *@return: String  会议费备注
	 */
	public String getConferemcenote(){
		return this.conferemcenote;
	}

	/**
	 * 设置  conferemcenote
	 *@param: conferemcenote  会议费备注
	 */
	public void setConferemcenote(String conferemcenote){
		this.conferemcenote = conferemcenote;
	}
	/**
	 * 获取  coorperationresearchsumnote
	 *@return: String  合作交流费备注
	 */
	public String getCoorperationresearchsumnote(){
		return this.coorperationresearchsumnote;
	}

	/**
	 * 设置  coorperationresearchsumnote
	 *@param: coorperationresearchsumnote  合作交流费备注
	 */
	public void setCoorperationresearchsumnote(String coorperationresearchsumnote){
		this.coorperationresearchsumnote = coorperationresearchsumnote;
	}
	/**
	 * 获取  adminstrativeservicesumnote
	 *@return: String  出版费备注
	 */
	public String getAdminstrativeservicesumnote(){
		return this.adminstrativeservicesumnote;
	}

	/**
	 * 设置  adminstrativeservicesumnote
	 *@param: adminstrativeservicesumnote  出版费备注
	 */
	public void setAdminstrativeservicesumnote(String adminstrativeservicesumnote){
		this.adminstrativeservicesumnote = adminstrativeservicesumnote;
	}
	/**
	 * 获取  servicefeenote
	 *@return: String  人员劳务费备注
	 */
	public String getServicefeenote(){
		return this.servicefeenote;
	}

	/**
	 * 设置  servicefeenote
	 *@param: servicefeenote  人员劳务费备注
	 */
	public void setServicefeenote(String servicefeenote){
		this.servicefeenote = servicefeenote;
	}
	/**
	 * 获取  adviceforexpertsumnote
	 *@return: String  专家咨询费备注
	 */
	public String getAdviceforexpertsumnote(){
		return this.adviceforexpertsumnote;
	}

	/**
	 * 设置  adviceforexpertsumnote
	 *@param: adviceforexpertsumnote  专家咨询费备注
	 */
	public void setAdviceforexpertsumnote(String adviceforexpertsumnote){
		this.adviceforexpertsumnote = adviceforexpertsumnote;
	}
	/**
	 * 获取  instrumentsumkjt
	 *@return: Double  设备费申请申请
	 */
	public Double getInstrumentsumkjt(){
		return this.instrumentsumkjt;
	}

	/**
	 * 设置  instrumentsumkjt
	 *@param: instrumentsumkjt  设备费申请申请
	 */
	public void setInstrumentsumkjt(Double instrumentsumkjt){
		this.instrumentsumkjt = instrumentsumkjt;
	}
	/**
	 * 获取  instrumentsum1kjt
	 *@return: Double  购置设备费科技厅
	 */
	public Double getInstrumentsum1kjt(){
		return this.instrumentsum1kjt;
	}

	/**
	 * 设置  instrumentsum1kjt
	 *@param: instrumentsum1kjt  购置设备费科技厅
	 */
	public void setInstrumentsum1kjt(Double instrumentsum1kjt){
		this.instrumentsum1kjt = instrumentsum1kjt;
	}
	/**
	 * 获取  instrumentsum2kjt
	 *@return: Double  改造设备费科技厅
	 */
	public Double getInstrumentsum2kjt(){
		return this.instrumentsum2kjt;
	}

	/**
	 * 设置  instrumentsum2kjt
	 *@param: instrumentsum2kjt  改造设备费科技厅
	 */
	public void setInstrumentsum2kjt(Double instrumentsum2kjt){
		this.instrumentsum2kjt = instrumentsum2kjt;
	}
	/**
	 * 获取  instrumentsum3kjt
	 *@return: Double  设备租赁费科技厅
	 */
	public Double getInstrumentsum3kjt(){
		return this.instrumentsum3kjt;
	}

	/**
	 * 设置  instrumentsum3kjt
	 *@param: instrumentsum3kjt  设备租赁费科技厅
	 */
	public void setInstrumentsum3kjt(Double instrumentsum3kjt){
		this.instrumentsum3kjt = instrumentsum3kjt;
	}
	/**
	 * 获取  materialexpensekjt
	 *@return: Double  材料费科技厅
	 */
	public Double getMaterialexpensekjt(){
		return this.materialexpensekjt;
	}

	/**
	 * 设置  materialexpensekjt
	 *@param: materialexpensekjt  材料费科技厅
	 */
	public void setMaterialexpensekjt(Double materialexpensekjt){
		this.materialexpensekjt = materialexpensekjt;
	}
	/**
	 * 获取  proceedingschargeskjt
	 *@return: Double  测试化验加工费科技厅
	 */
	public Double getProceedingschargeskjt(){
		return this.proceedingschargeskjt;
	}

	/**
	 * 设置  proceedingschargeskjt
	 *@param: proceedingschargeskjt  测试化验加工费科技厅
	 */
	public void setProceedingschargeskjt(Double proceedingschargeskjt){
		this.proceedingschargeskjt = proceedingschargeskjt;
	}
	/**
	 * 获取  fuelandpowerkjt
	 *@return: Double   燃料动力费科技厅
	 */
	public Double getFuelandpowerkjt(){
		return this.fuelandpowerkjt;
	}

	/**
	 * 设置  fuelandpowerkjt
	 *@param: fuelandpowerkjt   燃料动力费科技厅
	 */
	public void setFuelandpowerkjt(Double fuelandpowerkjt){
		this.fuelandpowerkjt = fuelandpowerkjt;
	}
	/**
	 * 获取  businesstripsumkjt
	 *@return: Double  差旅费科技厅
	 */
	public Double getBusinesstripsumkjt(){
		return this.businesstripsumkjt;
	}

	/**
	 * 设置  businesstripsumkjt
	 *@param: businesstripsumkjt  差旅费科技厅
	 */
	public void setBusinesstripsumkjt(Double businesstripsumkjt){
		this.businesstripsumkjt = businesstripsumkjt;
	}
	/**
	 * 获取  coferemcekjt
	 *@return: Double  会议费科技厅
	 */
	public Double getCoferemcekjt(){
		return this.coferemcekjt;
	}

	/**
	 * 设置  coferemcekjt
	 *@param: coferemcekjt  会议费科技厅
	 */
	public void setCoferemcekjt(Double coferemcekjt){
		this.coferemcekjt = coferemcekjt;
	}
	/**
	 * 获取  coorperationresearchsumkjt
	 *@return: Double  合作研究交流费科技厅
	 */
	public Double getCoorperationresearchsumkjt(){
		return this.coorperationresearchsumkjt;
	}

	/**
	 * 设置  coorperationresearchsumkjt
	 *@param: coorperationresearchsumkjt  合作研究交流费科技厅
	 */
	public void setCoorperationresearchsumkjt(Double coorperationresearchsumkjt){
		this.coorperationresearchsumkjt = coorperationresearchsumkjt;
	}
	/**
	 * 获取  adminstrativeservicesumkjt
	 *@return: Double  出版科技厅
	 */
	public Double getAdminstrativeservicesumkjt(){
		return this.adminstrativeservicesumkjt;
	}

	/**
	 * 设置  adminstrativeservicesumkjt
	 *@param: adminstrativeservicesumkjt  出版科技厅
	 */
	public void setAdminstrativeservicesumkjt(Double adminstrativeservicesumkjt){
		this.adminstrativeservicesumkjt = adminstrativeservicesumkjt;
	}
	/**
	 * 获取  servicefeekjt
	 *@return: Double  劳务费科技厅
	 */
	public Double getServicefeekjt(){
		return this.servicefeekjt;
	}

	/**
	 * 设置  servicefeekjt
	 *@param: servicefeekjt  劳务费科技厅
	 */
	public void setServicefeekjt(Double servicefeekjt){
		this.servicefeekjt = servicefeekjt;
	}
	/**
	 * 获取  adviceforexpertsumkjt
	 *@return: Double  专家咨询费科技厅
	 */
	public Double getAdviceforexpertsumkjt(){
		return this.adviceforexpertsumkjt;
	}

	/**
	 * 设置  adviceforexpertsumkjt
	 *@param: adviceforexpertsumkjt  专家咨询费科技厅
	 */
	public void setAdviceforexpertsumkjt(Double adviceforexpertsumkjt){
		this.adviceforexpertsumkjt = adviceforexpertsumkjt;
	}
	/**
	 * 获取  managesumkjt
	 *@return: Double  管理费科技厅
	 */
	public Double getManagesumkjt(){
		return this.managesumkjt;
	}

	/**
	 * 设置  managesumkjt
	 *@param: managesumkjt  管理费科技厅
	 */
	public void setManagesumkjt(Double managesumkjt){
		this.managesumkjt = managesumkjt;
	}
	/**
	 * 获取  qitakjt
	 *@return: Double  QITAKJT
	 */
	public Double getQitakjt(){
		return this.qitakjt;
	}

	/**
	 * 设置  qitakjt
	 *@param: qitakjt  QITAKJT
	 */
	public void setQitakjt(Double qitakjt){
		this.qitakjt = qitakjt;
	}
	/**
	 * 获取  totalsumkjt
	 *@return: Double  总计费用
	 */
	public Double getTotalsumkjt(){
		return this.totalsumkjt;
	}

	/**
	 * 设置  totalsumkjt
	 *@param: totalsumkjt  总计费用
	 */
	public void setTotalsumkjt(Double totalsumkjt){
		this.totalsumkjt = totalsumkjt;
	}
	/**
	 * 获取  jhtzze
	 *@return: Double  计划投资总额
	 */
	public Double getJhtzze(){
		return this.jhtzze;
	}

	/**
	 * 设置  jhtzze
	 *@param: jhtzze  计划投资总额
	 */
	public void setJhtzze(Double jhtzze){
		this.jhtzze = jhtzze;
	}
	/**
	 * 获取  ywctz
	 *@return: Double  已完成投资
	 */
	public Double getYwctz(){
		return this.ywctz;
	}

	/**
	 * 设置  ywctz
	 *@param: ywctz  已完成投资
	 */
	public void setYwctz(Double ywctz){
		this.ywctz = ywctz;
	}
	/**
	 * 获取  ywctzzc
	 *@return: Double  其中：自筹
	 */
	public Double getYwctzzc(){
		return this.ywctzzc;
	}

	/**
	 * 设置  ywctzzc
	 *@param: ywctzzc  其中：自筹
	 */
	public void setYwctzzc(Double ywctzzc){
		this.ywctzzc = ywctzzc;
	}
	/**
	 * 获取  jhxztz
	 *@return: Double  计划新增投资
	 */
	public Double getJhxztz(){
		return this.jhxztz;
	}

	/**
	 * 设置  jhxztz
	 *@param: jhxztz  计划新增投资
	 */
	public void setJhxztz(Double jhxztz){
		this.jhxztz = jhxztz;
	}
	/**
	 * 获取  jhxtzkjjf
	 *@return: Double  其中：申请科技经费
	 */
	public Double getJhxtzkjjf(){
		return this.jhxtzkjjf;
	}

	/**
	 * 设置  jhxtzkjjf
	 *@param: jhxtzkjjf  其中：申请科技经费
	 */
	public void setJhxtzkjjf(Double jhxtzkjjf){
		this.jhxtzkjjf = jhxtzkjjf;
	}
	/**
	 * 获取  jhxtzzc
	 *@return: Double  其中：自筹
	 */
	public Double getJhxtzzc(){
		return this.jhxtzzc;
	}

	/**
	 * 设置  jhxtzzc
	 *@param: jhxtzzc  其中：自筹
	 */
	public void setJhxtzzc(Double jhxtzzc){
		this.jhxtzzc = jhxtzzc;
	}
	/**
	 * 获取  jhxtzqtbk
	 *@return: Double  其中：其他拨款
	 */
	public Double getJhxtzqtbk(){
		return this.jhxtzqtbk;
	}

	/**
	 * 设置  jhxtzqtbk
	 *@param: jhxtzqtbk  其中：其他拨款
	 */
	public void setJhxtzqtbk(Double jhxtzqtbk){
		this.jhxtzqtbk = jhxtzqtbk;
	}
	/**
	 * 获取  totalzjsum
	 *@return: Double  直接费用
	 */
	public Double getTotalzjsum(){
		return this.totalzjsum;
	}

	/**
	 * 设置  totalzjsum
	 *@param: totalzjsum  直接费用
	 */
	public void setTotalzjsum(Double totalzjsum){
		this.totalzjsum = totalzjsum;
	}
	/**
	 * 获取  totalzjsumkjt
	 *@return: Double  直接费用科技经费
	 */
	public Double getTotalzjsumkjt(){
		return this.totalzjsumkjt;
	}

	/**
	 * 设置  totalzjsumkjt
	 *@param: totalzjsumkjt  直接费用科技经费
	 */
	public void setTotalzjsumkjt(Double totalzjsumkjt){
		this.totalzjsumkjt = totalzjsumkjt;
	}
	/**
	 * 获取  totaljjsum
	 *@return: Double  间接费用
	 */
	public Double getTotaljjsum(){
		return this.totaljjsum;
	}

	/**
	 * 设置  totaljjsum
	 *@param: totaljjsum  间接费用
	 */
	public void setTotaljjsum(Double totaljjsum){
		this.totaljjsum = totaljjsum;
	}
	/**
	 * 获取  totaljjsumkjt
	 *@return: Double  间接费用科技经费
	 */
	public Double getTotaljjsumkjt(){
		return this.totaljjsumkjt;
	}

	/**
	 * 设置  totaljjsumkjt
	 *@param: totaljjsumkjt  间接费用科技经费
	 */
	public void setTotaljjsumkjt(Double totaljjsumkjt){
		this.totaljjsumkjt = totaljjsumkjt;
	}
	/**
	 * 获取  jxzc
	 *@return: Double  技校支出
	 */
	public Double getJxzc(){
		return this.jxzc;
	}

	/**
	 * 设置  jxzc
	 *@param: jxzc  技校支出
	 */
	public void setJxzc(Double jxzc){
		this.jxzc = jxzc;
	}
	/**
	 * 获取  jxzckjt
	 *@return: Double  JXZCKJT
	 */
	public Double getJxzckjt(){
		return this.jxzckjt;
	}

	/**
	 * 设置  jxzckjt
	 *@param: jxzckjt  JXZCKJT
	 */
	public void setJxzckjt(Double jxzckjt){
		this.jxzckjt = jxzckjt;
	}
	/**
	 * 获取  clhygjhz
	 *@return: Double  差旅费/会议费/国际合作与交流费
	 */
	public Double getClhygjhz(){
		return this.clhygjhz;
	}

	/**
	 * 设置  clhygjhz
	 *@param: clhygjhz  差旅费/会议费/国际合作与交流费
	 */
	public void setClhygjhz(Double clhygjhz){
		this.clhygjhz = clhygjhz;
	}
	/**
	 * 获取  clhygjhzkjt
	 *@return: Double  差旅费/会议费/国际合作与交流费科技经费
	 */
	public Double getClhygjhzkjt(){
		return this.clhygjhzkjt;
	}

	/**
	 * 设置  clhygjhzkjt
	 *@param: clhygjhzkjt  差旅费/会议费/国际合作与交流费科技经费
	 */
	public void setClhygjhzkjt(Double clhygjhzkjt){
		this.clhygjhzkjt = clhygjhzkjt;
	}
	/**
	 * 获取  budgedesc
	 *@return: String  BUDGEDESC
	 */
	public String getBudgedesc(){
		return this.budgedesc;
	}

	/**
	 * 设置  budgedesc
	 *@param: budgedesc  BUDGEDESC
	 */
	public void setBudgedesc(String budgedesc){
		this.budgedesc = budgedesc;
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
	 * 获取  gjqtbk
	 *@return: Double  国家其它拨款
	 */
	public Double getGjqtbk(){
		return this.gjqtbk;
	}

	/**
	 * 设置  gjqtbk
	 *@param: gjqtbk  国家其它拨款
	 */
	public void setGjqtbk(Double gjqtbk){
		this.gjqtbk = gjqtbk;
	}
	/**
	 * 获取  bmbk
	 *@return: Double  部门拨款
	 */
	public Double getBmbk(){
		return this.bmbk;
	}

	/**
	 * 设置  bmbk
	 *@param: bmbk  部门拨款
	 */
	public void setBmbk(Double bmbk){
		this.bmbk = bmbk;
	}
	/**
	 * 获取  dfbk
	 *@return: Double  地方拨款
	 */
	public Double getDfbk(){
		return this.dfbk;
	}

	/**
	 * 设置  dfbk
	 *@param: dfbk  地方拨款
	 */
	public void setDfbk(Double dfbk){
		this.dfbk = dfbk;
	}
	/**
	 * 获取  qily
	 *@return: Double  其它来源
	 */
	public Double getQily(){
		return this.qily;
	}

	/**
	 * 设置  qily
	 *@param: qily  其它来源
	 */
	public void setQily(Double qily){
		this.qily = qily;
	}
	/**
	 * 获取  totalsumzc
	 *@return: Double  TOTALSUMZC
	 */
	public Double getTotalsumzc(){
		return this.totalsumzc;
	}

	/**
	 * 设置  totalsumzc
	 *@param: totalsumzc  TOTALSUMZC
	 */
	public void setTotalsumzc(Double totalsumzc){
		this.totalsumzc = totalsumzc;
	}
	/**
	 * 获取  instrumentsumzc
	 *@return: Double  INSTRUMENTSUMZC
	 */
	public Double getInstrumentsumzc(){
		return this.instrumentsumzc;
	}

	/**
	 * 设置  instrumentsumzc
	 *@param: instrumentsumzc  INSTRUMENTSUMZC
	 */
	public void setInstrumentsumzc(Double instrumentsumzc){
		this.instrumentsumzc = instrumentsumzc;
	}
	/**
	 * 获取  instrumentsum1zc
	 *@return: Double  INSTRUMENTSUM1ZC
	 */
	public Double getInstrumentsum1zc(){
		return this.instrumentsum1zc;
	}

	/**
	 * 设置  instrumentsum1zc
	 *@param: instrumentsum1zc  INSTRUMENTSUM1ZC
	 */
	public void setInstrumentsum1zc(Double instrumentsum1zc){
		this.instrumentsum1zc = instrumentsum1zc;
	}
	/**
	 * 获取  instrumentsum2zc
	 *@return: Double  INSTRUMENTSUM2ZC
	 */
	public Double getInstrumentsum2zc(){
		return this.instrumentsum2zc;
	}

	/**
	 * 设置  instrumentsum2zc
	 *@param: instrumentsum2zc  INSTRUMENTSUM2ZC
	 */
	public void setInstrumentsum2zc(Double instrumentsum2zc){
		this.instrumentsum2zc = instrumentsum2zc;
	}
	/**
	 * 获取  instrumentsum3zc
	 *@return: Double  INSTRUMENTSUM3ZC
	 */
	public Double getInstrumentsum3zc(){
		return this.instrumentsum3zc;
	}

	/**
	 * 设置  instrumentsum3zc
	 *@param: instrumentsum3zc  INSTRUMENTSUM3ZC
	 */
	public void setInstrumentsum3zc(Double instrumentsum3zc){
		this.instrumentsum3zc = instrumentsum3zc;
	}
	/**
	 * 获取  businesstripsumzc
	 *@return: Double  BUSINESSTRIPSUMZC
	 */
	public Double getBusinesstripsumzc(){
		return this.businesstripsumzc;
	}

	/**
	 * 设置  businesstripsumzc
	 *@param: businesstripsumzc  BUSINESSTRIPSUMZC
	 */
	public void setBusinesstripsumzc(Double businesstripsumzc){
		this.businesstripsumzc = businesstripsumzc;
	}
	/**
	 * 获取  adviceforexpertsumzc
	 *@return: Double  ADVICEFOREXPERTSUMZC
	 */
	public Double getAdviceforexpertsumzc(){
		return this.adviceforexpertsumzc;
	}

	/**
	 * 设置  adviceforexpertsumzc
	 *@param: adviceforexpertsumzc  ADVICEFOREXPERTSUMZC
	 */
	public void setAdviceforexpertsumzc(Double adviceforexpertsumzc){
		this.adviceforexpertsumzc = adviceforexpertsumzc;
	}
	/**
	 * 获取  materialexpensezc
	 *@return: Double  MATERIALEXPENSEZC
	 */
	public Double getMaterialexpensezc(){
		return this.materialexpensezc;
	}

	/**
	 * 设置  materialexpensezc
	 *@param: materialexpensezc  MATERIALEXPENSEZC
	 */
	public void setMaterialexpensezc(Double materialexpensezc){
		this.materialexpensezc = materialexpensezc;
	}
	/**
	 * 获取  servicefeezc
	 *@return: Double  SERVICEFEEZC
	 */
	public Double getServicefeezc(){
		return this.servicefeezc;
	}

	/**
	 * 设置  servicefeezc
	 *@param: servicefeezc  SERVICEFEEZC
	 */
	public void setServicefeezc(Double servicefeezc){
		this.servicefeezc = servicefeezc;
	}
	/**
	 * 获取  adminstrativeservicesumzc
	 *@return: Double  ADMINSTRATIVESERVICESUMZC
	 */
	public Double getAdminstrativeservicesumzc(){
		return this.adminstrativeservicesumzc;
	}

	/**
	 * 设置  adminstrativeservicesumzc
	 *@param: adminstrativeservicesumzc  ADMINSTRATIVESERVICESUMZC
	 */
	public void setAdminstrativeservicesumzc(Double adminstrativeservicesumzc){
		this.adminstrativeservicesumzc = adminstrativeservicesumzc;
	}
	/**
	 * 获取  proceedingschargeszc
	 *@return: Double  PROCEEDINGSCHARGESZC
	 */
	public Double getProceedingschargeszc(){
		return this.proceedingschargeszc;
	}

	/**
	 * 设置  proceedingschargeszc
	 *@param: proceedingschargeszc  PROCEEDINGSCHARGESZC
	 */
	public void setProceedingschargeszc(Double proceedingschargeszc){
		this.proceedingschargeszc = proceedingschargeszc;
	}
	/**
	 * 获取  coferemcezc
	 *@return: Double  COFEREMCEZC
	 */
	public Double getCoferemcezc(){
		return this.coferemcezc;
	}

	/**
	 * 设置  coferemcezc
	 *@param: coferemcezc  COFEREMCEZC
	 */
	public void setCoferemcezc(Double coferemcezc){
		this.coferemcezc = coferemcezc;
	}
	/**
	 * 获取  coorperationresearchsumzc
	 *@return: Double  COORPERATIONRESEARCHSUMZC
	 */
	public Double getCoorperationresearchsumzc(){
		return this.coorperationresearchsumzc;
	}

	/**
	 * 设置  coorperationresearchsumzc
	 *@param: coorperationresearchsumzc  COORPERATIONRESEARCHSUMZC
	 */
	public void setCoorperationresearchsumzc(Double coorperationresearchsumzc){
		this.coorperationresearchsumzc = coorperationresearchsumzc;
	}
	/**
	 * 获取  fuelandpowerzc
	 *@return: Double  FUELANDPOWERZC
	 */
	public Double getFuelandpowerzc(){
		return this.fuelandpowerzc;
	}

	/**
	 * 设置  fuelandpowerzc
	 *@param: fuelandpowerzc  FUELANDPOWERZC
	 */
	public void setFuelandpowerzc(Double fuelandpowerzc){
		this.fuelandpowerzc = fuelandpowerzc;
	}
	/**
	 * 获取  managesumzc
	 *@return: Double  MANAGESUMZC
	 */
	public Double getManagesumzc(){
		return this.managesumzc;
	}

	/**
	 * 设置  managesumzc
	 *@param: managesumzc  MANAGESUMZC
	 */
	public void setManagesumzc(Double managesumzc){
		this.managesumzc = managesumzc;
	}
	/**
	 * 获取  totalzjsumzc
	 *@return: Double  TOTALZJSUMZC
	 */
	public Double getTotalzjsumzc(){
		return this.totalzjsumzc;
	}

	/**
	 * 设置  totalzjsumzc
	 *@param: totalzjsumzc  TOTALZJSUMZC
	 */
	public void setTotalzjsumzc(Double totalzjsumzc){
		this.totalzjsumzc = totalzjsumzc;
	}
	/**
	 * 获取  totaljjsumzc
	 *@return: Double  TOTALJJSUMZC
	 */
	public Double getTotaljjsumzc(){
		return this.totaljjsumzc;
	}

	/**
	 * 设置  totaljjsumzc
	 *@param: totaljjsumzc  TOTALJJSUMZC
	 */
	public void setTotaljjsumzc(Double totaljjsumzc){
		this.totaljjsumzc = totaljjsumzc;
	}
	/**
	 * 获取  jxzczc
	 *@return: Double  JXZCZC
	 */
	public Double getJxzczc(){
		return this.jxzczc;
	}

	/**
	 * 设置  jxzczc
	 *@param: jxzczc  JXZCZC
	 */
	public void setJxzczc(Double jxzczc){
		this.jxzczc = jxzczc;
	}
	/**
	 * 获取  clhygjhzzc
	 *@return: Double  CLHYGJHZZC
	 */
	public Double getClhygjhzzc(){
		return this.clhygjhzzc;
	}

	/**
	 * 设置  clhygjhzzc
	 *@param: clhygjhzzc  CLHYGJHZZC
	 */
	public void setClhygjhzzc(Double clhygjhzzc){
		this.clhygjhzzc = clhygjhzzc;
	}
	/**
	 * 获取  qitazc
	 *@return: Double  QITAZC
	 */
	public Double getQitazc(){
		return this.qitazc;
	}

	/**
	 * 设置  qitazc
	 *@param: qitazc  QITAZC
	 */
	public void setQitazc(Double qitazc){
		this.qitazc = qitazc;
	}
	
}
