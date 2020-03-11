package cn.gov.gzst.assessment.service.impl;


import cn.gov.gzst.assessment.entity.EvalReport;
import cn.gov.gzst.assessment.mapper.EvalReportMapper;
import cn.gov.gzst.assessment.service.IEvalReportService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-11
 */
@Transactional
@Service("EvalReportService")
public class EvalReportServiceImpl extends CommonServiceImpl<EvalReportMapper, EvalReport> implements IEvalReportService {

    @Autowired
    private EvalReportMapper evalReportMapper;

    @Override
    public HashMap findByPactnoKj(String pactno) {
        return evalReportMapper.findByPactnoKj(pactno);
    }

    @Override
    public Map findByPactno(String pactno) {
        return evalReportMapper.findByPactno(pactno);
    }
}
