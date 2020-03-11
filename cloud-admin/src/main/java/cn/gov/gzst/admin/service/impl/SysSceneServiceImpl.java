package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysScene;
import cn.gov.gzst.admin.mapper.SysSceneMapper;
import cn.gov.gzst.admin.service.ISysSceneService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-02-14
 */
@Transactional
@Service("SysSceneService")
public class SysSceneServiceImpl extends CommonServiceImpl<SysSceneMapper, SysScene> implements ISysSceneService {

}
