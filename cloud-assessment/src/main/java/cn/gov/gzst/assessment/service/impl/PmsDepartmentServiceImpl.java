package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PmsDepartment;
import cn.gov.gzst.assessment.mapper.PmsDepartmentMapper;
import cn.gov.gzst.assessment.service.IPmsDepartmentService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-09
 */
@Transactional
@Service("PmsDepartmentService")
public class PmsDepartmentServiceImpl extends CommonServiceImpl<PmsDepartmentMapper, PmsDepartment> implements IPmsDepartmentService {

}
