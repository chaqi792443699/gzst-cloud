package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.cms.service.ISlideDataService;
import cn.gov.gzst.cms.entity.SlideData;
import cn.gov.gzst.cms.mapper.SlideDataMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: 幻灯片数据服务实现
* @description: 幻灯片数据服务实现
* @author: jianliaoliang
* @date: 2018-04-28 15:38:38
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("slidedataService")
public class SlideDataServiceImpl  extends CommonServiceImpl<SlideDataMapper,SlideData> implements  ISlideDataService {

}