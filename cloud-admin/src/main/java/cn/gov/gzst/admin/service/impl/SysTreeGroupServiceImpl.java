package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysTreeGroup;
import cn.gov.gzst.admin.mapper.SysTreeGroupMapper;
import cn.gov.gzst.admin.service.ISysTreeGroupService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * 树分组 服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-06
 */
@Transactional
@Service("SysTreeGroupService")
public class SysTreeGroupServiceImpl extends CommonServiceImpl<SysTreeGroupMapper, SysTreeGroup> implements ISysTreeGroupService {

}
