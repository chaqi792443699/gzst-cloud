package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.SecAuthority;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
public interface ISecAuthorityService extends ICommonService<SecAuthority> {

    boolean updateResources(String id,String[] resourceIds);

    List<SecAuthority> listByRoleId(String roleId);
}
