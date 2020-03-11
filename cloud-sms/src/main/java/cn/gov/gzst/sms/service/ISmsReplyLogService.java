package cn.gov.gzst.sms.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.sms.entity.SmsReplyLog;

import java.io.Serializable;
import java.util.List;

/**   
 * @Title: 短信回复日志
 * @Description: 短信回复日志
 * @author jianliaoliang
 * @date 2017-10-10 16:23:09
 * @version V1.0   
 *
 */
public interface ISmsReplyLogService extends ICommonService<SmsReplyLog> {
    /**
     * <p>
     * 短信重发
     * </p>
     *
     * @param idList 主键ID列表
     * @return boolean
     */
    boolean retryReply(List<? extends Serializable> idList);
}

