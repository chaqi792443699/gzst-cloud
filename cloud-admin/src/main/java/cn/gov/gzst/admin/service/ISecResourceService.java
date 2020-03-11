package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.SecResource;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * <p>
 * 资源表 服务接口类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
public interface ISecResourceService extends ICommonService<SecResource> {
    /**
     * 根据权限id查询资源列表
     * @param authorityId
     * @return
     */
    List<SecResource> listByAuthorityId(String authorityId);
}
