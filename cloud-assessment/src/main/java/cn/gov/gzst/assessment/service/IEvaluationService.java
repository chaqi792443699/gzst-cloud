package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.Evaluation;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author Mrlong
 * @since 2019-04-12
 */
public interface IEvaluationService extends ICommonService<Evaluation> {


    Evaluation findById(String id);
    Map  getReportBaseInfo(String pactid);
    Map getEvalInfo(String pactid);
}
