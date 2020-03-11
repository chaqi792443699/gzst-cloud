package cn.gov.gzst.survey.service.impl;

import cn.gov.gzst.survey.entity.Question;
import cn.gov.gzst.survey.mapper.QuestionMapper;
import cn.gov.gzst.survey.service.IQuestionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@Transactional
@Service("QuestionService")
public class QuestionServiceImpl extends CommonServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
