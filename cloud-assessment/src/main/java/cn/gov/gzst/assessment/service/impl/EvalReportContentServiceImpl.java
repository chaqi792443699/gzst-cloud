package cn.gov.gzst.assessment.service.impl;


import cn.gov.gzst.assessment.entity.EvalReportContent;
import cn.gov.gzst.assessment.mapper.EvalReportContentMapper;
import cn.gov.gzst.assessment.service.IEvalReportContentService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-11
 */
@Transactional
@Service("EvalReportContentService")
public class EvalReportContentServiceImpl extends CommonServiceImpl<EvalReportContentMapper, EvalReportContent> implements IEvalReportContentService {

}
