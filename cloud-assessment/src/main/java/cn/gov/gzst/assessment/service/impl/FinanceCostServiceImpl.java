package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceCost;
import cn.gov.gzst.assessment.mapper.FinanceCostMapper;
import cn.gov.gzst.assessment.service.FinanceCostService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Transactional
@Service("CwpgCostService")
public class FinanceCostServiceImpl extends CommonServiceImpl<FinanceCostMapper, FinanceCost> implements FinanceCostService {

}
