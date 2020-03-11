package cn.gov.gzst.email.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.email.service.IConfigService;
import cn.gov.gzst.email.entity.Config;
import cn.gov.gzst.email.mapper.ConfigMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.email.service.impl
* @title: 邮件配置服务实现
* @description: 邮件配置服务实现
* @author: jianliaoliang
* @date: 2018-04-24 11:16:31
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("configService")
public class ConfigServiceImpl  extends CommonServiceImpl<ConfigMapper,Config> implements  IConfigService {

}