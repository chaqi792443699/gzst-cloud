package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.EvalSelfStructure;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-19
 */
public interface IEvalSelfStructureService extends ICommonService<EvalSelfStructure> {

    List<Map<String,Object>> findAllStrInfo();
}
