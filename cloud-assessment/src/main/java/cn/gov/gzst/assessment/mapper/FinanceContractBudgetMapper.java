package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.FinanceContractBudget;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-24
 */
@Mapper
public interface FinanceContractBudgetMapper extends BaseMapper<FinanceContractBudget> {

    FinanceContractBudget contractBudgetByProjectId(@Param("ew")Wrapper<FinanceContractBudget> wrapper);
}
