package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PactProjectparty;
import cn.gov.gzst.assessment.mapper.PactProjectpartyMapper;
import cn.gov.gzst.assessment.service.IPactProjectpartyService;
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
@Service("PactProjectpartyService")
public class PactProjectpartyServiceImpl extends CommonServiceImpl<PactProjectpartyMapper, PactProjectparty> implements IPactProjectpartyService {

}
