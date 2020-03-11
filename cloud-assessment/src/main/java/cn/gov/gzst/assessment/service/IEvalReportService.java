package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.EvalReport;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-11
 */
public interface IEvalReportService extends ICommonService<EvalReport> {

    HashMap findByPactnoKj(String pactno);

    Map findByPactno(String pactno);
    
}
