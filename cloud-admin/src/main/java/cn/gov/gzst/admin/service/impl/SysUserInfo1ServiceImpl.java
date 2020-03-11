package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysUserInfo1;
import cn.gov.gzst.admin.mapper.SysUserInfo1Mapper;
import cn.gov.gzst.admin.service.ISysUserInfo1Service;
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
@Service("SysUserInfo1Service")
public class SysUserInfo1ServiceImpl extends CommonServiceImpl<SysUserInfo1Mapper, SysUserInfo1> implements ISysUserInfo1Service {

}
