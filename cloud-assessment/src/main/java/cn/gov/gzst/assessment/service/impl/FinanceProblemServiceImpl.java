package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.entity.FinanceProblem;
import cn.gov.gzst.assessment.mapper.FinanceProblemMapper;
import cn.gov.gzst.assessment.service.FinanceProblemService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Transactional
@Service("CwpgProblemService")
public class FinanceProblemServiceImpl extends CommonServiceImpl<FinanceProblemMapper, FinanceProblem> implements FinanceProblemService {
    @Override
    public boolean problemUpdate(Map<String, Object> map) {
        return baseMapper.problemUpdate(map);
    }

    @Override
    public List<FinanceProblem> selectProblemList(String projectId) {
        return baseMapper.selectProblemList(projectId);
    }
}
