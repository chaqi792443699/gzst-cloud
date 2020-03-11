package cn.gov.gzst.pms.service.impl;

import cn.gov.gzst.pms.entity.PactEnterpriseorganization;
import cn.gov.gzst.pms.mapper.PactEnterpriseorganizationMapper;
import cn.gov.gzst.pms.service.IPactEnterpriseorganizationService;
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
@Service("PactEnterpriseorganizationService")
public class PactEnterpriseorganizationServiceImpl extends CommonServiceImpl<PactEnterpriseorganizationMapper, PactEnterpriseorganization> implements IPactEnterpriseorganizationService {

}
