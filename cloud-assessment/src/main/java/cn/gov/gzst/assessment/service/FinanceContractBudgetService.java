package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.FinanceContractBudget;
import cn.gov.gzst.common.common.service.ICommonService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;

public interface FinanceContractBudgetService extends ICommonService<FinanceContractBudget> {
    FinanceContractBudget contractBudgetByProjectId(@Param("ew") Wrapper<FinanceContractBudget> wrapper);
}
