package cn.gov.gzst.oss.service.impl;

import cn.gov.gzst.oss.entity.Group;
import cn.gov.gzst.oss.mapper.GroupMapper;
import cn.gov.gzst.oss.service.IGroupService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-07-01
 */
@Transactional
@Service("GroupService")
public class GroupServiceImpl extends CommonServiceImpl<GroupMapper, Group> implements IGroupService {

}
