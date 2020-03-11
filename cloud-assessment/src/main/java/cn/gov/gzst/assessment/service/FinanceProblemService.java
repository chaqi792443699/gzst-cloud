package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.entity.FinanceProblem;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
public interface FinanceProblemService extends ICommonService<FinanceProblem> {
    boolean problemUpdate(Map<String,Object> map);

    /**
     * 根据项目编号查询问题
     * @param projectId   项目编号
     * @return
     */
    List<FinanceProblem> selectProblemList(String projectId);
}
