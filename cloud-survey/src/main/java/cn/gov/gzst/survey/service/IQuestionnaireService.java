package cn.gov.gzst.survey.service;

import cn.gov.gzst.survey.entity.*;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
public interface IQuestionnaireService extends ICommonService<Questionnaire> {

    //根据问卷id获取问卷信息
    public List<Object> getQuestionnaireByNaireId(String naireId);

    //查看问卷结果
   public List<Object> selectNaire(String questionnaireId,String userId);

   //根据问卷id获取问卷题目
   public List<Object> getQustionBynaireId(String naireId);

   //统计
    public Question statistics(String naireId, String questionId);

    //导出统计结果
    public String exportResult(String naireId);

}
