package cn.gov.gzst.sms.mapper;

import cn.gov.gzst.sms.entity.SmsReplyLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Title: 短信回复日志数据库控制层接口
 * @Description: 短信回复日志数据库控制层接口
 *
 */
@Mapper
public interface SmsReplyLogMapper extends BaseMapper<SmsReplyLog> {
    
}