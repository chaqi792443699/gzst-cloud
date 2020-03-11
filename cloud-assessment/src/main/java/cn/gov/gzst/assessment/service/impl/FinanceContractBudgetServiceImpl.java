package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceContractBudget;
import cn.gov.gzst.assessment.mapper.FinanceContractBudgetMapper;
import cn.gov.gzst.assessment.service.FinanceContractBudgetService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-24
 */
@Transactional
@Service("FinanceContractBudgetService")
public class FinanceContractBudgetServiceImpl extends CommonServiceImpl<FinanceContractBudgetMapper, FinanceContractBudget> implements FinanceContractBudgetService {
    @Override
    public FinanceContractBudget contractBudgetByProjectId(Wrapper<FinanceContractBudget> wrapper) {
        wrapper.eq("1","1");
        return baseMapper.contractBudgetByProjectId(wrapper);
    }
}
