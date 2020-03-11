package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysUserRole;
import cn.gov.gzst.admin.mapper.SysUserRoleMapper;
import cn.gov.gzst.admin.service.ISysUserRoleService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * 用户-角色 服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-19
 */
@Transactional
@Service("SysUserRoleService")
public class SysUserRoleServiceImpl extends CommonServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
