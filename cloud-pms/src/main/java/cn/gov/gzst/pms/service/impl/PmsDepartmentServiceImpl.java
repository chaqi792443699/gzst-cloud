package cn.gov.gzst.pms.service.impl;

import cn.gov.gzst.pms.entity.PmsDepartment;
import cn.gov.gzst.pms.mapper.PmsDepartmentMapper;
import cn.gov.gzst.pms.service.IPmsDepartmentService;
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
