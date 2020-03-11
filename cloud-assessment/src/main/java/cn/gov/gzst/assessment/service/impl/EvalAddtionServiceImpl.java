package cn.gov.gzst.assessment.service.impl;


import cn.gov.gzst.assessment.entity.EvalAddtion;
import cn.gov.gzst.assessment.mapper.EvalAddtionMapper;
import cn.gov.gzst.assessment.service.IEvalAddtionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-22
 */
@Transactional
@Service("EvalAddtionService")
public class EvalAddtionServiceImpl extends CommonServiceImpl<EvalAddtionMapper, EvalAddtion> implements IEvalAddtionService {

}
