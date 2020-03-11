package cn.gov.gzst.survey.service.impl;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.survey.entity.Option;
import cn.gov.gzst.survey.entity.Question;
import cn.gov.gzst.survey.entity.Scheme;
import cn.gov.gzst.survey.mapper.SchemeMapper;
import cn.gov.gzst.survey.service.IOptionService;
import cn.gov.gzst.survey.service.IQuestionService;
import cn.gov.gzst.survey.service.ISchemeService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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
@Service("SchemeService")
public class SchemeServiceImpl extends CommonServiceImpl<SchemeMapper, Scheme> implements ISchemeService {
    @Autowired
    private ISchemeService schemeService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IOptionService optionService;


    @Override
    public void delete(String id) {
        EntityWrapper<Question> questionEntityWrapper = new EntityWrapper<>(Question.class);
        questionEntityWrapper.eq("scheme_id",id);
        List<Question> questionList = questionService.selectList(questionEntityWrapper);
        // 1.删除问题对应的所有答案
        for(Question qs : questionList){
            EntityWrapper<Option> optionEntityWrapper = new EntityWrapper<>(Option.class);
            optionEntityWrapper.eq("question_id",qs.getId());
            List<Option> optionList = optionService.selectList(optionEntityWrapper);
            optionService.deleteBatchIds(optionList);
        }
        //2.删除方案下的所有问题
        questionService.deleteBatchIds(questionList);
        //3.删除方案
        schemeService.deleteById(id);
    }

    @Override
    public Scheme getScheme(String id) {
        List<Map<String,Object>> dataList = new ArrayList<>();
        Map<String,Object> questionMap = new HashMap<>();
        List<Option> optionList =null;
        //获取方案数据
        Scheme scheme = schemeService.selectById(id);

        //获取该方案对应问题数据
        EntityWrapper<Question> questionWrapper = new EntityWrapper<>(Question.class);
        questionWrapper.eq("scheme_id",id);
        List<Question> questionList = questionService.selectList(questionWrapper);

        //获取方案问题下对应选项数据
        for(Question qs : questionList){
            EntityWrapper<Option> optionWrapper = new EntityWrapper<>(Option.class);
            optionWrapper.eq("question_id",qs.getId());
            optionList = optionService.selectList(optionWrapper);
            if(optionList.size()>0){
                qs.setOptionList(optionList);
            }
        }
        scheme.setQuestionList(questionList);

        return scheme;
    }
}
