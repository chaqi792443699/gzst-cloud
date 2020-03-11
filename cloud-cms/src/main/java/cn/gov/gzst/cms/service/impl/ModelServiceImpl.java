package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.IModelService;
import cn.gov.gzst.cms.entity.Model;
import cn.gov.gzst.cms.mapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: 模型管理服务实现
* @description: 模型管理服务实现
* @author: jianliaoliang
* @date: 2018-05-02 09:35:51
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("modelService")
public class ModelServiceImpl  extends CommonServiceImpl<ModelMapper,Model> implements  IModelService {

}