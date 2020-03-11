package cn.gov.gzst.pms.service.impl;


import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.pms.entity.PactProjectparty;
import cn.gov.gzst.pms.mapper.PactProjectpartyMapper;
import cn.gov.gzst.pms.service.IPactProjectpartyService;
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
