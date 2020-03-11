package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.IFriendshiplinkService;
import cn.gov.gzst.cms.entity.Friendshiplink;
import cn.gov.gzst.cms.mapper.FriendshiplinkMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: cms_friendshiplink服务实现
* @description: cms_friendshiplink服务实现
* @author: wuzhengjun
* @date: 2018-11-16 11:12:39
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("friendshiplinkService")
public class FriendshiplinkServiceImpl  extends CommonServiceImpl<FriendshiplinkMapper,Friendshiplink> implements  IFriendshiplinkService {

}