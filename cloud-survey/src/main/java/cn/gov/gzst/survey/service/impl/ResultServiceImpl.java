package cn.gov.gzst.survey.service.impl;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.survey.entity.*;
import cn.gov.gzst.survey.mapper.ResultMapper;
import cn.gov.gzst.survey.service.*;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.soap.Text;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-13
 */
@Transactional
@Service("ResultService")
public class ResultServiceImpl extends CommonServiceImpl<ResultMapper, Result> implements IResultService {
    @Autowired
    private IResultService resultService;


    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IOptionService optionService;

    @Override
    public Map getResult(String questionnaireId,String schemeId, String questionId, String userId) {
        Map map = new HashMap();
        List<Result> list = new ArrayList<>();
        Integer scores = 0;
        String scoreStr = "";
        String option_Id = "";

        EntityWrapper<Result> entityWrapper = new EntityWrapper<>(Result.class);
        entityWrapper.eq("questionnaire_id",questionnaireId).eq("scheme_id",schemeId).eq("question_id",questionId).eq("reviewer",userId);
        list = resultService.selectList(entityWrapper);
        for(Result rs: list){
          Question question = questionService.selectById(questionId);
          String resultVal = rs.getResult().toString();
          String optionId = rs.getOptionId().toString();
          Option option = optionService.selectById(optionId);
          String type = question.getType();
          switch (type){
              case "1":
                  option_Id = optionId;
                  break;
              case  "2":
                  option_Id += optionId+",";
                  break;
              case  "3":
                  scores = Integer.parseInt(resultVal);
                  break;
              case  "4":
                  scoreStr = resultVal;
                  break;
              default:
                  break;
          }
        }
        map.put("optionId",option_Id);
        map.put("scores",scores);
        map.put("scoreStr",scoreStr);
        return map;
    }

    @Override
    public Map statistics(String naireId, String questionId, String optionId) {
        Integer count = 0;
        Map map = new HashMap();
        Question question = questionService.selectById(questionId);
        EntityWrapper<Result> entityWrapper = new EntityWrapper<>(Result.class);
        entityWrapper.eq("questionnaire_id",naireId).eq("question_id",questionId).eq("option_id",optionId);
        int countData = resultService.selectCount(entityWrapper);
        switch (question.getType()){
            case "1":
                count += countData;
                break;
            case  "2":
                count += countData;
                break;
            default:
                break;
        }
        map.put("count",String.valueOf(count));
        return map;
    }
}
