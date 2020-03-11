package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.mapper.FinanceConclusionMapper;
import cn.gov.gzst.assessment.service.FinanceConclusionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service("CwpgConclusionService")
public class FinanceConclusionServiceImpl extends CommonServiceImpl<FinanceConclusionMapper, FinanceConclusion> implements FinanceConclusionService {
    @Autowired
    private FinanceProblemServiceImpl problemService;

    @Override
    public List<Map<String,Object>> selectConclusionList(@Param("ew")Wrapper<FinanceConclusion> wrapper) {
        wrapper.eq("1","1");
        return baseMapper.selectConclusionList(wrapper);
    }

    @Override
    public Boolean conclusionSave(FinanceConclusion conclusion) {
        return baseMapper.conclusionSave(conclusion);
    }

    @Override
    public FinanceConclusion selectConclusionByProjectId(String projectId) {
        return baseMapper.selectConclusionByProjectId(projectId);
    }

    @Override
    public boolean conclusionUp(FinanceConclusion conclusion) {
        return baseMapper.conclusionUp(conclusion);
    }


}
