package cn.gov.gzst.assessment.service.impl;


import cn.gov.gzst.assessment.entity.Evaluation;
import cn.gov.gzst.assessment.mapper.EvaluationMapper;
import cn.gov.gzst.assessment.service.IEvaluationService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mrlong
 * @since 2019-04-12
 */
@Transactional
@Service("EvaluationService")
public class EvaluationServiceImpl extends CommonServiceImpl<EvaluationMapper, Evaluation> implements IEvaluationService {

    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public Evaluation findById(String id) {
        return evaluationMapper.findById(id);
    }

    @Override
    public Map  getReportBaseInfo(String pactid) {
        return evaluationMapper.getReportBaseInfo(pactid);
    }

    @Override
    public Map getEvalInfo(String pactid) {
        return evaluationMapper.getEvalInfo(pactid);
    }
}
