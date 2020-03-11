package cn.gov.gzst.activiti.service.impl;

import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.activiti.service.IFetchUserTaskService;
import cn.gov.gzst.activiti.entity.FetchUserTask;
import cn.gov.gzst.activiti.mapper.FetchUserTaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.activiti.service.impl
* @title: 查找用户任务服务实现
* @description: 查找用户任务服务实现
* @author: jianliaoliang
* @date: 2018-06-29 10:28:22
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("fetchusertaskService")
public class FetchUserTaskServiceImpl  extends CommonServiceImpl<FetchUserTaskMapper,FetchUserTask> implements  IFetchUserTaskService {

}