package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.mapper.EvalProcesslastMapper;
import cn.gov.gzst.assessment.service.IEvalProcesslastService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-06
 */
@Transactional
@Service("EvalProcesslastService")
public class EvalProcesslastServiceImpl extends CommonServiceImpl<EvalProcesslastMapper, EvalProcesslast> implements IEvalProcesslastService {

}
