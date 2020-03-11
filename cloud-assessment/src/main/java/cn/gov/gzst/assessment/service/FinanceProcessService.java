package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.FinanceProcess;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
public interface FinanceProcessService extends ICommonService<FinanceProcess> {
    List<FinanceProcess> selectProcessById(String projectId);
    FinanceProcess selectProcessByProjectId(String projectId);
}
