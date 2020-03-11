package cn.gov.gzst.survey.service.impl;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.survey.entity.*;
import cn.gov.gzst.survey.mapper.QuestionnaireMapper;
import cn.gov.gzst.survey.service.*;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@Transactional
@Service("QuestionnaireService")
public class QuestionnaireServiceImpl extends CommonServiceImpl<QuestionnaireMapper, Questionnaire> implements IQuestionnaireService {
    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private ISchemeService schemeService;

    @Autowired
    private IResultService resultService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IOptionService optionService;

    @Override
    public List<Object> getQuestionnaireByNaireId(String naireId) {
        Questionnaire questionnaire = questionnaireService.selectById(naireId);
        Scheme scheme  = schemeService.selectById(questionnaire.getSchemeId());
        List<Object> list = new ArrayList<>();
        EntityWrapper<Question> entityWrapper = new EntityWrapper<>(Question.class);
        entityWrapper.eq("scheme_id",scheme.getId());
        List<Question> questionList = questionService.selectList(entityWrapper);
        for(Question qs : questionList){
            EntityWrapper<Option> optionEntityWrapper = new EntityWrapper<>(Option.class);
            optionEntityWrapper.eq("question_id",qs.getId());
            List<Option> optionList = optionService.selectList(optionEntityWrapper);
            qs.setOptionList(optionList);
        }
        scheme.setQuestionList(questionList);
        list.add(questionnaire);
        list.add(scheme);
        return  list;
    }

    @Override
    public List<Object> selectNaire(String questionnaireId, String userId) {
        //获取问卷
        Questionnaire questionnaire = questionnaireService.selectById(questionnaireId);

        //获取方案
        String schemeId = questionnaire.getSchemeId();
        Scheme scheme = schemeService.selectById(schemeId);
        List<Scheme> list = new ArrayList<>();

        EntityWrapper<Question> questionEntityWrapper = new EntityWrapper<>(Question.class);
        questionEntityWrapper.eq("scheme_id",scheme.getId());
        List<Question> questionList = questionService.selectList(questionEntityWrapper);
        List<Question> lqs = new ArrayList<>();
        for(Question qs: questionList){
            //获取选项
            EntityWrapper<Option> optionEntityWrapper = new EntityWrapper<>(Option.class);
            optionEntityWrapper.eq("question_id",qs.getId());
            List<Option> optionList = optionService.selectList(optionEntityWrapper);

            //获取填写值
            String scoreData = "";
            Map map =resultService.getResult(questionnaireId,scheme.getId(),qs.getId(),userId);
            String score = map.get("scores").toString();
            String scoreStr = map.get("scoreStr").toString();
            String optionId =map.get("optionId").toString();
            String type = qs.getType();
            switch (type){
                case "1":
                    scoreData = optionId;
                    break;
                case "2":
                    scoreData = optionId;
                    break;
                case "3":
                    scoreData = score;
                    break;
                case "4":
                    scoreData = scoreStr;
                    break;
                default:
                    break;
            }
            qs.setResult(scoreData);
            qs.setOptionList(optionList);
            lqs.add(qs);
        }
        scheme.setQuestionList(lqs);
        list.add(scheme);
        List<Object> obList = new ArrayList<>();
        obList.add(list);
        obList.add(questionnaire);
        return obList;
    }

    @Override
    public List<Object> getQustionBynaireId(String naireId) {
        List<Object>  list = new ArrayList<>();
        //获取问卷
        Questionnaire questionnaire = questionnaireService.selectById(naireId);
        //获取方案
        Scheme scheme = schemeService.selectById(questionnaire.getSchemeId());
        //获取题目
        EntityWrapper<Question> questionEntityWrapper = new EntityWrapper<>(Question.class);
        questionEntityWrapper.eq("scheme_id",scheme.getId()).eq("type","1")
                .orNew().eq("scheme_id",scheme.getId()).eq("type","2");
        List<Question> questionList = questionService.selectList(questionEntityWrapper);
        scheme.setQuestionList(questionList);
        list.add(questionnaire);
        list.add(scheme);
        return list;
    }

    @Override
    public Question statistics(String naireId,String questionId) {
            Question question = questionService.selectById(questionId);
            //获取选项
            EntityWrapper<Option> optionEntityWrapper = new EntityWrapper<>(Option.class);
            optionEntityWrapper.eq("question_id",questionId);
            List<Option> optionList = optionService.selectList(optionEntityWrapper);
            List<Option> lop = new ArrayList<>();
            String countData = "";
            for(Option op : optionList){
                Map map = resultService.statistics(naireId,questionId,op.getId());
                String count = map.get("count").toString();
                switch (question.getType()){
                    case "1":
                        countData = count;
                        break;
                    case "2":
                        countData = count;
                        break;
                    default:
                        break;
                }
                op.setCountData(countData);
                lop.add(op);
            }
            question.setOptionList(optionList);
        return question;
    }

    @Override
    public String exportResult(String naireId) {
        String countData = "";
        List<Object> list = new ArrayList<>();
        String[] strArray = naireId.split(",");
        for(int i=0;i<strArray.length;i++){
            Questionnaire questionnaire = questionnaireService.selectById(strArray[i]);
            Scheme scheme = schemeService.selectById(questionnaire.getSchemeId());
            EntityWrapper<Question> questionEntityWrapper = new EntityWrapper<>(Question.class);
            questionEntityWrapper.eq("scheme_id",scheme.getId()).eq("type","1")
                    .orNew().eq("scheme_id",scheme.getId()).eq("type","2");
            List<Question> questionList = questionService.selectList(questionEntityWrapper);
            for(Question qs : questionList){
                EntityWrapper<Option> optionEntityWrapper = new EntityWrapper<>(Option.class);
                optionEntityWrapper.eq("question_id",qs.getId());
                List<Option> optionList = optionService.selectList(optionEntityWrapper);
                for(Option op : optionList){
                    Map map = resultService.statistics(naireId,qs.getId(),op.getId());
                    String count = map.get("count").toString();
                    switch (qs.getType()){
                        case "1":
                            countData = count;
                            break;
                        case "2":
                            countData = count;
                            break;
                        default:
                            break;
                    }
                    op.setCountData(countData);
                }
                qs.setOptionList(optionList);
            }
            scheme.setQuestionList(questionList);
            questionnaire.setScheme(scheme);
            list.add(questionnaire);
        }
        //禁止循环引用方案
        return JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
    }
}
