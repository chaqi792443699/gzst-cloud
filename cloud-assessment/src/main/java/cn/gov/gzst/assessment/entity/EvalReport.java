package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-11
 */
@TableName("jxpg_report")
public class EvalReport extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     *
     */
    @ApiModelProperty(value="自增ID",name="id")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 项目ID
     */
    @ApiModelProperty(value="项目id,该字段数据库无数据",name="projectbaseid")
    @TableField(" projectbaseid")
    private String 
    projectbaseid;

    /**
     * 国外（申请专利）
     */
    @ApiModelProperty(value="国外（申请专利）",name="gjhxqk")
    @TableField("gjhxqk")
    private Integer gjhxqk;

    /**
     * 国家级奖（获得奖项）
     */
    @ApiModelProperty(value="国家级奖（获得奖项）",name="gnhxqk")
    @TableField("gnhxqk")
    private Integer gnhxqk;

    /**
     * 省部级奖（获得奖项
     */
    @ApiModelProperty(value="省部级奖（获得奖项）",name="sjhxqk")
    @TableField("sjhxqk")
    private Integer sjhxqk;

    /**
     * 引进境外技术经费（技术获取和技术改造情况）
     */
    @ApiModelProperty(value="引进境外技术经费（技术获取和技术改造情况）",name="gjybqk")
    @TableField("gjybqk")
    private Double gjybqk;

    /**
     * 技术改造经费支出（技术获取和技术改造情况）
     */
    @ApiModelProperty(value="技术改造经费支出（技术获取和技术改造情况）",name="gnybqk")
    @TableField("gnybqk")
    private Double gnybqk;

    /**
     *  国外发表（论文、专著、研究报告）
     */
    @ApiModelProperty(value="国外发表（论文、专著、研究报告）",name="sjybqk")
    @TableField("sjybqk")
    private Integer sjybqk;

    /**
     * 国内发表（论文、专著、研究报告）
     */
    @ApiModelProperty(value="国内发表（论文、专著、研究报告）",name="zz")
    @TableField("zz")
    private Integer zz;

    /**
     * 申请发明专利数
     */
    @ApiModelProperty(value="申请发明专利数",name="slfmzl")
    @TableField("slfmzl")
    private Integer slfmzl;

    /**
     * 申请实用新型专利数
     */
    @ApiModelProperty(value="申请实用新型专利数",name="slsyxxzl")
    @TableField("slsyxxzl")
    private Integer slsyxxzl;

    /**
     * 申请外观设计专利数
     */
    @ApiModelProperty(value="申请外观设计专利数",name="slwgsjzl")
    @TableField("slwgsjzl")
    private Integer slwgsjzl;

    /**
     * 国外（授权专利）
     */
    @ApiModelProperty(value=" 国外（授权专利）",name="slpctzl")
    @TableField("slpctzl")
    private Integer slpctzl;

    /**
     * 授权发明专利数
     */
    @ApiModelProperty(value=" 授权发明专利数",name="sqfmzl")
    @TableField("sqfmzl")
    private Integer sqfmzl;

    /**
     * 授权实用新型专利数
     */
    @ApiModelProperty(value=" 授权实用新型专利数",name="sqsyxxzl")
    @TableField("sqsyxxzl")
    private Integer sqsyxxzl;

    /**
     * 授权外观设计专利数
     */
    @ApiModelProperty(value=" 授权外观设计专利数",name="sqwgsjzl")
    @TableField("sqwgsjzl")
    private Integer sqwgsjzl;

    /**
     * 引进其他
     */
    @ApiModelProperty(value=" 引进其他",name="sqpctzl")
    @TableField("sqpctzl")
    private Integer sqpctzl;

    /**
     * 引进杰青
     */
    @ApiModelProperty(value=" 引进杰青",name="sqrjzzq")
    @TableField("sqrjzzq")
    private Integer sqrjzzq;

    /**
     * 引进千人计划
     */
    @ApiModelProperty(value=" 引进千人计划",name="sqjcdlbusj")
    @TableField("sqjcdlbusj")
    private Integer sqjcdlbusj;

    /**
     * 培养硕士
     */
    @ApiModelProperty(value=" 培养硕士",name="sqzwxpz")
    @TableField("sqzwxpz")
    private Integer sqzwxpz;

    /**
     * 软件著作权（项）
     */
    @ApiModelProperty(value=" 软件著作权（项）",name="djrjzzq")
    @TableField("djrjzzq")
    private Integer djrjzzq;

    /**
     * 集成电路布图设计
     */
    @ApiModelProperty(value="集成电路布图设计",name="djjcdlbusj")
    @TableField("djjcdlbusj")
    private Integer djjcdlbusj;

    /**
     * 动植物新品种（项）
     */
    @ApiModelProperty(value="动植物新品种（项）",name="djzwxpz")
    @TableField("djzwxpz")
    private Integer djzwxpz;

    /**
     * 参与地标标准
     */
    @ApiModelProperty(value="参与地标标准",name="qtgjbz")
    @TableField("qtgjbz")
    private Integer qtgjbz;

    /**
     * 参与国标标准
     */
    @ApiModelProperty(value="参与国标标准",name="qthybz")
    @TableField("qthybz")
    private Integer qthybz;

    /**
     * 牵头地标标准
     */
    @ApiModelProperty(value="牵头地标标准",name="qtdfbz")
    @TableField("qtdfbz")
    private Integer qtdfbz;

    /**
     * 牵头国标标准
     */
    @ApiModelProperty(value="牵头国标标准",name="qtqybz")
    @TableField("qtqybz")
    private Integer qtqybz;

    /**
     * 培养入选国家计划
     */
    @ApiModelProperty(value="培养入选国家计划",name="cygjbz")
    @TableField("cygjbz")
    private Integer cygjbz;

    /**
     * 培养入选省级计划
     */
    @ApiModelProperty(value="培养入选省级计划",name="cyhybz")
    @TableField("cyhybz")
    private Integer cyhybz;

    /**
     * 培养入选其他计划
     */
    @TableField("cydfbz")
    private Integer cydfbz;

    /**
     * 引进长江学者
     */
    @TableField("cyqybz")
    private Integer cyqybz;

    /**
     * 中试线（条）
     */
    @ApiModelProperty(value="中试线（条）",name="zsx")
    @TableField("zsx")
    private Integer zsx;

    /**
     * 生产线（条）
     */
    @ApiModelProperty(value="生产线（条）",name="scx")
    @TableField("scx")
    private Integer scx;

    /**
     * 培养博士后
     */
    @ApiModelProperty(value="培养博士后",name="pygjzcys")
    @TableField("pygjzcys")
    private Integer pygjzcys;

    /**
     * 培养博士
     */
    @ApiModelProperty(value="培养博士",name="pyzjzcys")
    @TableField("pyzjzcys")
    private Integer pyzjzcys;

    /**
     * 引进973/863首席
     */
    @TableField("yjgjzcys")
    private Integer yjgjzcys;

    /**
     * 新产品（种）
     */
    @ApiModelProperty(value="新产品（种）",name="yjxpz")
    @TableField("yjxpz")
    private Integer yjxpz;

    /**
     * 新增出口创汇（直接）
     */
    @ApiModelProperty(value="新增出口创汇（直接）",name="yjxjs")
    @TableField("yjxjs")
    private Integer yjxjs;

    /**
     * 新技术、新工艺（项）
     */
    @ApiModelProperty(value="新技术、新工艺（项）",name="yjxgy")
    @TableField("yjxgy")
    private Integer yjxgy;

    /**
     * 新材料（项）
     */
    @ApiModelProperty(value="新材料（项）",name="yjxcl")
    @TableField("yjxcl")
    private Integer yjxcl;

    /**
     * 新增产值（间接
     */
    @ApiModelProperty(value="新增产值（间接",name="zcpt")
    @TableField("zcpt")
    private Double zcpt;

    /**
     * 试验基地（个）
     */
    @ApiModelProperty(value=" 试验基地（个）",name="syjd")
    @TableField("syjd")
    private Integer syjd;

    /**
     * 示范点（区）（个
     */
    @ApiModelProperty(value=" 示范点（区）（个",name="sfd")
    @TableField("sfd")
    private Integer sfd;

    /**
     * 合同ID
     */
    @ApiModelProperty(value=" 合同ID",name="pactid")
    @TableField("pactid")
    private String pactid;

    /**
     * 新增就业人数
     */
    @ApiModelProperty(value=" 新增就业人数",name="xzjy")
    @TableField("xzjy")
    private Integer xzjy;

    /**
     * 新增产值（直接）
     */
    @ApiModelProperty(value="新增产值（直接）",name="jjxycz")
    @TableField("jjxycz")
    private Double jjxycz;

    /**
     * 新增利税（直接）
     */
    @ApiModelProperty(value="新增利税（直接）",name="jjxyss")
    @TableField("jjxyss")
    private Double jjxyss;

    /**
     * 新增利润（间接）
     */
    @ApiModelProperty(value="新增利润（间接）",name="jjxylr")
    @TableField("jjxylr")
    private Double jjxylr;

    @ApiModelProperty(value="与报告内容管理",name="reportsid")
    @TableField("reportsid")
    private String reportsid;

    /**
     * 创建时间
     */
    @ApiModelProperty(value=" 创建时间",name="createdate")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("createdate")
    private Date createdate;

    /**
     * 单位总人数
     */
    @TableField("dwrs")
    private Integer dwrs;

    /**
     * 高级职称
     */
    @TableField("gjzc")
    private Integer gjzc;

    /**
     * 中级职称
     */
    @TableField("zjzc")
    private Integer zjzc;

    /**
     * 博士
     */
    @TableField("bs")
    private Integer bs;

    /**
     * 硕士
     */
    @TableField("ss")
    private Integer ss;

    /**
     * 本科
     */
    @TableField("bk")
    private Integer bk;

    /**
     * 大专
     */
    @TableField("dz")
    private Integer dz;

    /**
     * 新增税收（间接）
     */
    @ApiModelProperty(value=" 新增税收（间接）",name="xzss")
    @TableField("xzss")
    private Double xzss;

    /**
     * 新增出口创汇（间接）
     */
    @ApiModelProperty(value="新增出口创汇（间接）",name="xzckch")
    @TableField("xzckch")
    private Double xzckch;

    /**
     * 经费投入合计（计划
     */
    @TableField("jhjftrhj")
    private Double jhjftrhj;

    /**
     * 省级财政科技经费（计划）
     */
    @TableField("jhsjczkjjf")
    private Double jhsjczkjjf;

    /**
     * 其他财政科技经费（计划）
     */
    @TableField("jhqtczkjjf")
    private Double jhqtczkjjf;

    /**
     * 金融机构贷款（计划）
     */
    @TableField("jhjrjgdk")
    private Double jhjrjgdk;

    /**
     * 单位自筹（计划）
     */
    @TableField("jhdwzc")
    private Double jhdwzc;

    /**
     * 经费投入合计（实际）
     */
    @TableField("sjjftrhj")
    private Double sjjftrhj;

    /**
     * 省级财政科技经费（实际）
     */
    @TableField("sjsjczkjjf")
    private Double sjsjczkjjf;

    /**
     * 其他财政科技经费（实际）
     */
    @TableField("sjqtczkjjf")
    private Double sjqtczkjjf;

    /**
     * 获得天使投资额（实际）
     */
    @TableField("sjhdtstze")
    private Double sjhdtstze;

    /**
     * 获得风险投资额（实际）
     */
    @TableField("sjhdfxtze")
    private Double sjhdfxtze;

    /**
     * 金融机构贷款额（实际）
     */
    @TableField("sjjrjgdke")
    private Double sjjrjgdke;

    /**
     * 单位自筹（实际）
     */
    @TableField("sjdwzc")
    private Double sjdwzc;

    /**
     * 成果转让合同数
     */
    @TableField("cgzrhts")
    private Integer cgzrhts;

    /**
     * 成果转让合同额
     */
    @TableField("cgzrhte")
    private Double cgzrhte;

    /**
     * 实际应用成果数
     */
    @TableField("sjyycgs")
    private Integer sjyycgs;

    /**
     * 已获经济效益
     */
    @TableField("yhjjxy")
    private Double yhjjxy;

    /**
     * 新增就业人数
     */
    @ApiModelProperty(value="新增就业人数",name="xzjyrs")
    @TableField("xzjyrs")
    private Integer xzjyrs;

    /**
     * 开放天数
     */
    @TableField("kfts")
    private Integer kfts;

    /**
     * 接待人数
     */
    @TableField("jdrs")
    private Integer jdrs;

    /**
     * 社会效益说明
     */
    @TableField("shxysm")
    private String shxysm;

    /**
     * 经济效益说明
     */
    @TableField("jjxysm")
    private String jjxysm;

    /**
     * 生态效益说明
     */
    @TableField("stxysm")
    private String stxysm;

    /**
     * 可持续影响说明
     */
    @TableField("kcxyx")
    private String kcxyx;

    /**
     * 社会公众或服务对象满意度
     */
    @TableField("shgzfwmyd")
    private String shgzfwmyd;

    /**
     * 论文期刊
     */
    @TableField("lunwenqikan")
    private String lunwenqikan;

    /**
     * 专利情况
     */
    @TableField("zhuanliqikuang")
    private String zhuanliqikuang;

    /**
     * 奖项名称
     */
    @TableField("jxname")
    private String jxname;

    /**
     * 间接经济效益 出口创汇
     */
    @TableField("sndxzckch")
    private Double sndxzckch;

    /**
     * 就业人数（人）
     */
    @TableField("sndxzjyrs")
    private Integer sndxzjyrs;

    /**
     * 科普基地开放天数（天）
     */
    @TableField("sndkfts")
    private Integer sndkfts;

    /**
     * 接待人数（人）
     */
    @TableField("sndjdrs")
    private Integer sndjdrs;

    /**
     * 直接利润
     */
    @TableField("sndjjxylr")
    private Double sndjjxylr;

    /**
     * 直接产值
     */
    @TableField("sndjjxycz")
    private Double sndjjxycz;

    /**
     * 直接税收
     */
    @TableField("sndjjxyss")
    private Double sndjjxyss;

    /**
     * 直接出口创汇
     */
    @TableField("sndyjxjs")
    private Double sndyjxjs;

    /**
     * 间接产值
     */
    @TableField("sndzcpt")
    private Double sndzcpt;

    /**
     * 间接税收
     */
    @TableField("sndxzss")
    private Double sndxzss;

    /**
     * 间接利润
     */
    @TableField("sndjjxylr1")
    private Double sndjjxylr1;

    @TableField("sndzjxylr")
    private Double sndzjxylr;

    /**
     * 直接新增销售收入
     */
    @TableField("zjxylr")
    private Double zjxylr;

    /**
     * 接销售收入
     */
    @TableField("sndxssr")
    private Double sndxssr;

    /**
     * 研究与开发费用投入
     */
    @TableField("sndrdtr")
    private Double sndrdtr;

    /**
     * 新增销售收入
     */
    @ApiModelProperty(value=" 新增销售收入",name="xzxssr")
    @TableField("xzxssr")
    private Double xzxssr;

    @TableField("xzrdtr")
    private Double xzrdtr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getprojectbaseid() {
        return projectbaseid;
    }

    public void setprojectbaseid(String projectbaseid) {
        this.projectbaseid = projectbaseid;
    }
    public Integer getGjhxqk() {
        return gjhxqk;
    }

    public void setGjhxqk(Integer gjhxqk) {
        this.gjhxqk = gjhxqk;
    }
    public Integer getGnhxqk() {
        return gnhxqk;
    }

    public void setGnhxqk(Integer gnhxqk) {
        this.gnhxqk = gnhxqk;
    }
    public Integer getSjhxqk() {
        return sjhxqk;
    }

    public void setSjhxqk(Integer sjhxqk) {
        this.sjhxqk = sjhxqk;
    }
    public Double getGjybqk() {
        return gjybqk;
    }

    public void setGjybqk(Double gjybqk) {
        this.gjybqk = gjybqk;
    }
    public Double getGnybqk() {
        return gnybqk;
    }

    public void setGnybqk(Double gnybqk) {
        this.gnybqk = gnybqk;
    }
    public Integer getSjybqk() {
        return sjybqk;
    }

    public void setSjybqk(Integer sjybqk) {
        this.sjybqk = sjybqk;
    }
    public Integer getZz() {
        return zz;
    }

    public void setZz(Integer zz) {
        this.zz = zz;
    }
    public Integer getSlfmzl() {
        return slfmzl;
    }

    public void setSlfmzl(Integer slfmzl) {
        this.slfmzl = slfmzl;
    }
    public Integer getSlsyxxzl() {
        return slsyxxzl;
    }

    public void setSlsyxxzl(Integer slsyxxzl) {
        this.slsyxxzl = slsyxxzl;
    }
    public Integer getSlwgsjzl() {
        return slwgsjzl;
    }

    public void setSlwgsjzl(Integer slwgsjzl) {
        this.slwgsjzl = slwgsjzl;
    }
    public Integer getSlpctzl() {
        return slpctzl;
    }

    public void setSlpctzl(Integer slpctzl) {
        this.slpctzl = slpctzl;
    }
    public Integer getSqfmzl() {
        return sqfmzl;
    }

    public void setSqfmzl(Integer sqfmzl) {
        this.sqfmzl = sqfmzl;
    }
    public Integer getSqsyxxzl() {
        return sqsyxxzl;
    }

    public void setSqsyxxzl(Integer sqsyxxzl) {
        this.sqsyxxzl = sqsyxxzl;
    }
    public Integer getSqwgsjzl() {
        return sqwgsjzl;
    }

    public void setSqwgsjzl(Integer sqwgsjzl) {
        this.sqwgsjzl = sqwgsjzl;
    }
    public Integer getSqpctzl() {
        return sqpctzl;
    }

    public void setSqpctzl(Integer sqpctzl) {
        this.sqpctzl = sqpctzl;
    }
    public Integer getSqrjzzq() {
        return sqrjzzq;
    }

    public void setSqrjzzq(Integer sqrjzzq) {
        this.sqrjzzq = sqrjzzq;
    }
    public Integer getSqjcdlbusj() {
        return sqjcdlbusj;
    }

    public void setSqjcdlbusj(Integer sqjcdlbusj) {
        this.sqjcdlbusj = sqjcdlbusj;
    }
    public Integer getSqzwxpz() {
        return sqzwxpz;
    }

    public void setSqzwxpz(Integer sqzwxpz) {
        this.sqzwxpz = sqzwxpz;
    }
    public Integer getDjrjzzq() {
        return djrjzzq;
    }

    public void setDjrjzzq(Integer djrjzzq) {
        this.djrjzzq = djrjzzq;
    }
    public Integer getDjjcdlbusj() {
        return djjcdlbusj;
    }

    public void setDjjcdlbusj(Integer djjcdlbusj) {
        this.djjcdlbusj = djjcdlbusj;
    }
    public Integer getDjzwxpz() {
        return djzwxpz;
    }

    public void setDjzwxpz(Integer djzwxpz) {
        this.djzwxpz = djzwxpz;
    }
    public Integer getQtgjbz() {
        return qtgjbz;
    }

    public void setQtgjbz(Integer qtgjbz) {
        this.qtgjbz = qtgjbz;
    }
    public Integer getQthybz() {
        return qthybz;
    }

    public void setQthybz(Integer qthybz) {
        this.qthybz = qthybz;
    }
    public Integer getQtdfbz() {
        return qtdfbz;
    }

    public void setQtdfbz(Integer qtdfbz) {
        this.qtdfbz = qtdfbz;
    }
    public Integer getQtqybz() {
        return qtqybz;
    }

    public void setQtqybz(Integer qtqybz) {
        this.qtqybz = qtqybz;
    }
    public Integer getCygjbz() {
        return cygjbz;
    }

    public void setCygjbz(Integer cygjbz) {
        this.cygjbz = cygjbz;
    }
    public Integer getCyhybz() {
        return cyhybz;
    }

    public void setCyhybz(Integer cyhybz) {
        this.cyhybz = cyhybz;
    }
    public Integer getCydfbz() {
        return cydfbz;
    }

    public void setCydfbz(Integer cydfbz) {
        this.cydfbz = cydfbz;
    }
    public Integer getCyqybz() {
        return cyqybz;
    }

    public void setCyqybz(Integer cyqybz) {
        this.cyqybz = cyqybz;
    }
    public Integer getZsx() {
        return zsx;
    }

    public void setZsx(Integer zsx) {
        this.zsx = zsx;
    }
    public Integer getScx() {
        return scx;
    }

    public void setScx(Integer scx) {
        this.scx = scx;
    }
    public Integer getPygjzcys() {
        return pygjzcys;
    }

    public void setPygjzcys(Integer pygjzcys) {
        this.pygjzcys = pygjzcys;
    }
    public Integer getPyzjzcys() {
        return pyzjzcys;
    }

    public void setPyzjzcys(Integer pyzjzcys) {
        this.pyzjzcys = pyzjzcys;
    }
    public Integer getYjgjzcys() {
        return yjgjzcys;
    }

    public void setYjgjzcys(Integer yjgjzcys) {
        this.yjgjzcys = yjgjzcys;
    }
    public Integer getYjxpz() {
        return yjxpz;
    }

    public void setYjxpz(Integer yjxpz) {
        this.yjxpz = yjxpz;
    }
    public Integer getYjxjs() {
        return yjxjs;
    }

    public void setYjxjs(Integer yjxjs) {
        this.yjxjs = yjxjs;
    }
    public Integer getYjxgy() {
        return yjxgy;
    }

    public void setYjxgy(Integer yjxgy) {
        this.yjxgy = yjxgy;
    }
    public Integer getYjxcl() {
        return yjxcl;
    }

    public void setYjxcl(Integer yjxcl) {
        this.yjxcl = yjxcl;
    }
    public Double getZcpt() {
        return zcpt;
    }

    public void setZcpt(Double zcpt) {
        this.zcpt = zcpt;
    }
    public Integer getSyjd() {
        return syjd;
    }

    public void setSyjd(Integer syjd) {
        this.syjd = syjd;
    }
    public Integer getSfd() {
        return sfd;
    }

    public void setSfd(Integer sfd) {
        this.sfd = sfd;
    }
    public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid;
    }
    public Integer getXzjy() {
        return xzjy;
    }

    public void setXzjy(Integer xzjy) {
        this.xzjy = xzjy;
    }
    public Double getJjxycz() {
        return jjxycz;
    }

    public void setJjxycz(Double jjxycz) {
        this.jjxycz = jjxycz;
    }
    public Double getJjxyss() {
        return jjxyss;
    }

    public void setJjxyss(Double jjxyss) {
        this.jjxyss = jjxyss;
    }
    public Double getJjxylr() {
        return jjxylr;
    }

    public void setJjxylr(Double jjxylr) {
        this.jjxylr = jjxylr;
    }
    public String getReportsid() {
        return reportsid;
    }

    public void setReportsid(String reportsid) {
        this.reportsid = reportsid;
    }
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    public Integer getDwrs() {
        return dwrs;
    }

    public void setDwrs(Integer dwrs) {
        this.dwrs = dwrs;
    }
    public Integer getGjzc() {
        return gjzc;
    }

    public void setGjzc(Integer gjzc) {
        this.gjzc = gjzc;
    }
    public Integer getZjzc() {
        return zjzc;
    }

    public void setZjzc(Integer zjzc) {
        this.zjzc = zjzc;
    }
    public Integer getBs() {
        return bs;
    }

    public void setBs(Integer bs) {
        this.bs = bs;
    }
    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }
    public Integer getBk() {
        return bk;
    }

    public void setBk(Integer bk) {
        this.bk = bk;
    }
    public Integer getDz() {
        return dz;
    }

    public void setDz(Integer dz) {
        this.dz = dz;
    }
    public Double getXzss() {
        return xzss;
    }

    public void setXzss(Double xzss) {
        this.xzss = xzss;
    }
    public Double getXzckch() {
        return xzckch;
    }

    public void setXzckch(Double xzckch) {
        this.xzckch = xzckch;
    }
    public Double getJhjftrhj() {
        return jhjftrhj;
    }

    public void setJhjftrhj(Double jhjftrhj) {
        this.jhjftrhj = jhjftrhj;
    }
    public Double getJhsjczkjjf() {
        return jhsjczkjjf;
    }

    public void setJhsjczkjjf(Double jhsjczkjjf) {
        this.jhsjczkjjf = jhsjczkjjf;
    }
    public Double getJhqtczkjjf() {
        return jhqtczkjjf;
    }

    public void setJhqtczkjjf(Double jhqtczkjjf) {
        this.jhqtczkjjf = jhqtczkjjf;
    }
    public Double getJhjrjgdk() {
        return jhjrjgdk;
    }

    public void setJhjrjgdk(Double jhjrjgdk) {
        this.jhjrjgdk = jhjrjgdk;
    }
    public Double getJhdwzc() {
        return jhdwzc;
    }

    public void setJhdwzc(Double jhdwzc) {
        this.jhdwzc = jhdwzc;
    }
    public Double getSjjftrhj() {
        return sjjftrhj;
    }

    public void setSjjftrhj(Double sjjftrhj) {
        this.sjjftrhj = sjjftrhj;
    }
    public Double getSjsjczkjjf() {
        return sjsjczkjjf;
    }

    public void setSjsjczkjjf(Double sjsjczkjjf) {
        this.sjsjczkjjf = sjsjczkjjf;
    }
    public Double getSjqtczkjjf() {
        return sjqtczkjjf;
    }

    public void setSjqtczkjjf(Double sjqtczkjjf) {
        this.sjqtczkjjf = sjqtczkjjf;
    }
    public Double getSjhdtstze() {
        return sjhdtstze;
    }

    public void setSjhdtstze(Double sjhdtstze) {
        this.sjhdtstze = sjhdtstze;
    }
    public Double getSjhdfxtze() {
        return sjhdfxtze;
    }

    public void setSjhdfxtze(Double sjhdfxtze) {
        this.sjhdfxtze = sjhdfxtze;
    }
    public Double getSjjrjgdke() {
        return sjjrjgdke;
    }

    public void setSjjrjgdke(Double sjjrjgdke) {
        this.sjjrjgdke = sjjrjgdke;
    }
    public Double getSjdwzc() {
        return sjdwzc;
    }

    public void setSjdwzc(Double sjdwzc) {
        this.sjdwzc = sjdwzc;
    }
    public Integer getCgzrhts() {
        return cgzrhts;
    }

    public void setCgzrhts(Integer cgzrhts) {
        this.cgzrhts = cgzrhts;
    }
    public Double getCgzrhte() {
        return cgzrhte;
    }

    public void setCgzrhte(Double cgzrhte) {
        this.cgzrhte = cgzrhte;
    }
    public Integer getSjyycgs() {
        return sjyycgs;
    }

    public void setSjyycgs(Integer sjyycgs) {
        this.sjyycgs = sjyycgs;
    }
    public Double getYhjjxy() {
        return yhjjxy;
    }

    public void setYhjjxy(Double yhjjxy) {
        this.yhjjxy = yhjjxy;
    }
    public Integer getXzjyrs() {
        return xzjyrs;
    }

    public void setXzjyrs(Integer xzjyrs) {
        this.xzjyrs = xzjyrs;
    }
    public Integer getKfts() {
        return kfts;
    }

    public void setKfts(Integer kfts) {
        this.kfts = kfts;
    }
    public Integer getJdrs() {
        return jdrs;
    }

    public void setJdrs(Integer jdrs) {
        this.jdrs = jdrs;
    }
    public String getShxysm() {
        return shxysm;
    }

    public void setShxysm(String shxysm) {
        this.shxysm = shxysm;
    }
    public String getJjxysm() {
        return jjxysm;
    }

    public void setJjxysm(String jjxysm) {
        this.jjxysm = jjxysm;
    }
    public String getStxysm() {
        return stxysm;
    }

    public void setStxysm(String stxysm) {
        this.stxysm = stxysm;
    }
    public String getKcxyx() {
        return kcxyx;
    }

    public void setKcxyx(String kcxyx) {
        this.kcxyx = kcxyx;
    }
    public String getShgzfwmyd() {
        return shgzfwmyd;
    }

    public void setShgzfwmyd(String shgzfwmyd) {
        this.shgzfwmyd = shgzfwmyd;
    }
    public String getLunwenqikan() {
        return lunwenqikan;
    }

    public void setLunwenqikan(String lunwenqikan) {
        this.lunwenqikan = lunwenqikan;
    }
    public String getZhuanliqikuang() {
        return zhuanliqikuang;
    }

    public void setZhuanliqikuang(String zhuanliqikuang) {
        this.zhuanliqikuang = zhuanliqikuang;
    }
    public String getJxname() {
        return jxname;
    }

    public void setJxname(String jxname) {
        this.jxname = jxname;
    }
    public Double getSndxzckch() {
        return sndxzckch;
    }

    public void setSndxzckch(Double sndxzckch) {
        this.sndxzckch = sndxzckch;
    }
    public Integer getSndxzjyrs() {
        return sndxzjyrs;
    }

    public void setSndxzjyrs(Integer sndxzjyrs) {
        this.sndxzjyrs = sndxzjyrs;
    }
    public Integer getSndkfts() {
        return sndkfts;
    }

    public void setSndkfts(Integer sndkfts) {
        this.sndkfts = sndkfts;
    }
    public Integer getSndjdrs() {
        return sndjdrs;
    }

    public void setSndjdrs(Integer sndjdrs) {
        this.sndjdrs = sndjdrs;
    }
    public Double getSndjjxylr() {
        return sndjjxylr;
    }

    public void setSndjjxylr(Double sndjjxylr) {
        this.sndjjxylr = sndjjxylr;
    }
    public Double getSndjjxycz() {
        return sndjjxycz;
    }

    public void setSndjjxycz(Double sndjjxycz) {
        this.sndjjxycz = sndjjxycz;
    }
    public Double getSndjjxyss() {
        return sndjjxyss;
    }

    public void setSndjjxyss(Double sndjjxyss) {
        this.sndjjxyss = sndjjxyss;
    }
    public Double getSndyjxjs() {
        return sndyjxjs;
    }

    public void setSndyjxjs(Double sndyjxjs) {
        this.sndyjxjs = sndyjxjs;
    }
    public Double getSndzcpt() {
        return sndzcpt;
    }

    public void setSndzcpt(Double sndzcpt) {
        this.sndzcpt = sndzcpt;
    }
    public Double getSndxzss() {
        return sndxzss;
    }

    public void setSndxzss(Double sndxzss) {
        this.sndxzss = sndxzss;
    }
    public Double getSndjjxylr1() {
        return sndjjxylr1;
    }

    public void setSndjjxylr1(Double sndjjxylr1) {
        this.sndjjxylr1 = sndjjxylr1;
    }
    public Double getSndzjxylr() {
        return sndzjxylr;
    }

    public void setSndzjxylr(Double sndzjxylr) {
        this.sndzjxylr = sndzjxylr;
    }
    public Double getZjxylr() {
        return zjxylr;
    }

    public void setZjxylr(Double zjxylr) {
        this.zjxylr = zjxylr;
    }
    public Double getSndxssr() {
        return sndxssr;
    }

    public void setSndxssr(Double sndxssr) {
        this.sndxssr = sndxssr;
    }
    public Double getSndrdtr() {
        return sndrdtr;
    }

    public void setSndrdtr(Double sndrdtr) {
        this.sndrdtr = sndrdtr;
    }
    public Double getXzxssr() {
        return xzxssr;
    }

    public void setXzxssr(Double xzxssr) {
        this.xzxssr = xzxssr;
    }
    public Double getXzrdtr() {
        return xzrdtr;
    }

    public void setXzrdtr(Double xzrdtr) {
        this.xzrdtr = xzrdtr;
    }

    @Override
    public String toString() {
        return "EvalReport{" +
        "id=" + id +
      ", projectbaseid = " +
        projectbaseid +
                ", gjhxqk=" + gjhxqk +
                ", gnhxqk=" + gnhxqk +
                ", sjhxqk=" + sjhxqk +
                ", gjybqk=" + gjybqk +
                ", gnybqk=" + gnybqk +
                ", sjybqk=" + sjybqk +
                ", zz=" + zz +
                ", slfmzl=" + slfmzl +
                ", slsyxxzl=" + slsyxxzl +
        ", slwgsjzl=" + slwgsjzl +
        ", slpctzl=" + slpctzl +
        ", sqfmzl=" + sqfmzl +
        ", sqsyxxzl=" + sqsyxxzl +
        ", sqwgsjzl=" + sqwgsjzl +
        ", sqpctzl=" + sqpctzl +
        ", sqrjzzq=" + sqrjzzq +
        ", sqjcdlbusj=" + sqjcdlbusj +
        ", sqzwxpz=" + sqzwxpz +
        ", djrjzzq=" + djrjzzq +
        ", djjcdlbusj=" + djjcdlbusj +
        ", djzwxpz=" + djzwxpz +
        ", qtgjbz=" + qtgjbz +
        ", qthybz=" + qthybz +
        ", qtdfbz=" + qtdfbz +
        ", qtqybz=" + qtqybz +
        ", cygjbz=" + cygjbz +
        ", cyhybz=" + cyhybz +
        ", cydfbz=" + cydfbz +
        ", cyqybz=" + cyqybz +
        ", zsx=" + zsx +
        ", scx=" + scx +
        ", pygjzcys=" + pygjzcys +
        ", pyzjzcys=" + pyzjzcys +
        ", yjgjzcys=" + yjgjzcys +
        ", yjxpz=" + yjxpz +
        ", yjxjs=" + yjxjs +
        ", yjxgy=" + yjxgy +
        ", yjxcl=" + yjxcl +
        ", zcpt=" + zcpt +
        ", syjd=" + syjd +
        ", sfd=" + sfd +
        ", pactid=" + pactid +
        ", xzjy=" + xzjy +
        ", jjxycz=" + jjxycz +
        ", jjxyss=" + jjxyss +
        ", jjxylr=" + jjxylr +
        ", reportsid=" + reportsid +
        ", createdate=" + createdate +
        ", dwrs=" + dwrs +
        ", gjzc=" + gjzc +
        ", zjzc=" + zjzc +
        ", bs=" + bs +
        ", ss=" + ss +
        ", bk=" + bk +
        ", dz=" + dz +
        ", xzss=" + xzss +
        ", xzckch=" + xzckch +
        ", jhjftrhj=" + jhjftrhj +
        ", jhsjczkjjf=" + jhsjczkjjf +
        ", jhqtczkjjf=" + jhqtczkjjf +
        ", jhjrjgdk=" + jhjrjgdk +
        ", jhdwzc=" + jhdwzc +
        ", sjjftrhj=" + sjjftrhj +
        ", sjsjczkjjf=" + sjsjczkjjf +
        ", sjqtczkjjf=" + sjqtczkjjf +
        ", sjhdtstze=" + sjhdtstze +
        ", sjhdfxtze=" + sjhdfxtze +
        ", sjjrjgdke=" + sjjrjgdke +
        ", sjdwzc=" + sjdwzc +
        ", cgzrhts=" + cgzrhts +
        ", cgzrhte=" + cgzrhte +
        ", sjyycgs=" + sjyycgs +
        ", yhjjxy=" + yhjjxy +
        ", xzjyrs=" + xzjyrs +
        ", kfts=" + kfts +
        ", jdrs=" + jdrs +
        ", shxysm=" + shxysm +
        ", jjxysm=" + jjxysm +
        ", stxysm=" + stxysm +
        ", kcxyx=" + kcxyx +
        ", shgzfwmyd=" + shgzfwmyd +
        ", lunwenqikan=" + lunwenqikan +
        ", zhuanliqikuang=" + zhuanliqikuang +
        ", jxname=" + jxname +
        ", sndxzckch=" + sndxzckch +
        ", sndxzjyrs=" + sndxzjyrs +
        ", sndkfts=" + sndkfts +
        ", sndjdrs=" + sndjdrs +
        ", sndjjxylr=" + sndjjxylr +
        ", sndjjxycz=" + sndjjxycz +
        ", sndjjxyss=" + sndjjxyss +
        ", sndyjxjs=" + sndyjxjs +
        ", sndzcpt=" + sndzcpt +
        ", sndxzss=" + sndxzss +
        ", sndjjxylr1=" + sndjjxylr1 +
        ", sndzjxylr=" + sndzjxylr +
        ", zjxylr=" + zjxylr +
        ", sndxssr=" + sndxssr +
        ", sndrdtr=" + sndrdtr +
        ", xzxssr=" + xzxssr +
        ", xzrdtr=" + xzrdtr +
        "}";
    }
}
