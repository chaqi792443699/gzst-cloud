package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PactBase;
import cn.gov.gzst.assessment.mapper.PactBaseMapper;
import cn.gov.gzst.assessment.service.IPactBaseService;
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
@Service("PactBaseService")
public class PactBaseServiceImpl extends CommonServiceImpl<PactBaseMapper, PactBase> implements IPactBaseService {

}
