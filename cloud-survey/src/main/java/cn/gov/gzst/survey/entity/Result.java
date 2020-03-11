package cn.gov.gzst.survey.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-13
 */
@TableName("survey_result")
public class Result extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 问卷结果id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 方案id
     */
    @TableField("scheme_id")
    private String schemeId;

    /**
     * 题目id
     */
    @TableField("question_id")
    private String questionId;

    /**
     * 选项id
     */
    @TableField("option_id")
    private String optionId;

    /**
     * 评价人id
     */
    @TableField("reviewer")
    private String reviewer;

    /**
     * 评价结果：分值或内容
     */
    @TableField("result")
    private String result;

    /**
     * 评价对象ID
     */
    @TableField("Pid")
    private String Pid;

    @TableField(exist = false)
    private Questionnaire questionnaire;

    @TableField(exist = false)
    private Scheme scheme;

    @TableField(exist = false)
    private Question question;

    @TableField(exist = false)
    private Option option;

    /**
     * 其他意见
     */
    @TableField("attachement")
    private String attachement;

    /**
     * 问卷id
     */
    @TableField("questionnaire_id")
    private String questionnaireId;


    /**
     * 调查结果类型
     */
    @TableField("type")
    private String type;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @TableField("update_date")
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }
    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getPid() {
        return Pid;
    }

    public void setPid(String Pid) {
        this.Pid = Pid;
    }
    public String getAttachement() {
        return attachement;
    }

    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }
    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Result{" +
        "id=" + id +
        ", schemeId=" + schemeId +
        ", questionId=" + questionId +
        ", optionId=" + optionId +
        ", reviewer=" + reviewer +
        ", result=" + result +
        ", Pid=" + Pid +
        ", attachement=" + attachement +
        ", questionnaireId=" + questionnaireId +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        "}";
    }
}
