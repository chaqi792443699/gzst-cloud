package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceProcess;
import cn.gov.gzst.assessment.mapper.FinanceProcessMapper;
import cn.gov.gzst.assessment.service.FinanceProcessService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Transactional
@Service("CwpgProcessService")
public class FinanceProcessServiceImpl extends CommonServiceImpl<FinanceProcessMapper, FinanceProcess> implements FinanceProcessService {

    @Override
    public List<FinanceProcess> selectProcessById(String projectId) {
        return baseMapper.selectProcessById(projectId);
    }

    @Override
    public FinanceProcess selectProcessByProjectId(String projectId) {
        return baseMapper.selectProcessByProjectId(projectId);
    }
}
