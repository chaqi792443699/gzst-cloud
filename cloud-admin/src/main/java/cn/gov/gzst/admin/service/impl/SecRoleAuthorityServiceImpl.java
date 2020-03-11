package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SecRoleAuthority;
import cn.gov.gzst.admin.mapper.SecRoleAuthorityMapper;
import cn.gov.gzst.admin.service.ISecRoleAuthorityService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * 角色-菜单 服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-15
 */
@Transactional
@Service("SecRoleAuthorityService")
public class SecRoleAuthorityServiceImpl extends CommonServiceImpl<SecRoleAuthorityMapper, SecRoleAuthority> implements ISecRoleAuthorityService {

}
