package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysUserInfo2;
import cn.gov.gzst.admin.mapper.SysUserInfo2Mapper;
import cn.gov.gzst.admin.service.ISysUserInfo2Service;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-04
 */
@Transactional
@Service("SysUserInfo2Service")
public class SysUserInfo2ServiceImpl extends CommonServiceImpl<SysUserInfo2Mapper, SysUserInfo2> implements ISysUserInfo2Service {

}
