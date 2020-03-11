package cn.gov.gzst.pms.service.impl;

import cn.gov.gzst.pms.entity.PactProjectexpense;
import cn.gov.gzst.pms.mapper.PactProjectexpenseMapper;
import cn.gov.gzst.pms.service.IPactProjectexpenseService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@Transactional
@Service("PactProjectexpenseService")
public class PactProjectexpenseServiceImpl extends CommonServiceImpl<PactProjectexpenseMapper, PactProjectexpense> implements IPactProjectexpenseService {

}
