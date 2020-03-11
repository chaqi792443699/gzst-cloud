package cn.gov.gzst.sms.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.sms.entity.SmsSendLog;

import java.io.Serializable;
import java.util.List;

/**   
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0   
 *
 */
public interface ISmsSendLogService extends ICommonService<SmsSendLog> {

    /**
     * <p>
     * 短信重发
     * </p>
     *
     * @param idList 主键ID列表
     * @return boolean
     */
    boolean retrySend(List<? extends Serializable> idList);
}

