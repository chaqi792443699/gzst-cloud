package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceExpenditure;
import cn.gov.gzst.assessment.mapper.FinanceExpenditureMapper;
import cn.gov.gzst.assessment.service.FinanceExpenditureService;
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
@Service("CwpgExpenditureService")
public class FinanceExpenditureServiceImpl extends CommonServiceImpl<FinanceExpenditureMapper, FinanceExpenditure> implements FinanceExpenditureService {

}
