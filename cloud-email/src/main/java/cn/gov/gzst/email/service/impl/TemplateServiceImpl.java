package cn.gov.gzst.email.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.email.service.ITemplateService;
import cn.gov.gzst.email.entity.Template;
import cn.gov.gzst.email.mapper.TemplateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.email.service.impl
* @title: 邮件模板服务实现
* @description: 邮件模板服务实现
* @author: jianliaoliang
* @date: 2018-04-24 11:19:30
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("templateService")
public class TemplateServiceImpl  extends CommonServiceImpl<TemplateMapper,Template> implements  ITemplateService {

}