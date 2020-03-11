package cn.gov.gzst.email.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.email.entity.SendLog;

import java.io.Serializable;
import java.util.List;

/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.email.service
* @title: 发送日志服务接口
* @description: 发送日志服务接口
* @author: jianliaoliang
* @date: 2018-04-24 11:24:16
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
public interface ISendLogService extends ICommonService<SendLog> {
    /**
     * <p>
     *  邮件重发
     * </p>
     *
     * @param idList 主键ID列表
     * @return boolean
     */
    boolean retrySend(List<? extends Serializable> idList);
}