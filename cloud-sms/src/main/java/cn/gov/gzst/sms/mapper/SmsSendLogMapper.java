package cn.gov.gzst.sms.mapper;

import cn.gov.gzst.sms.entity.SmsSendLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 短信发送日志数据库控制层接口
 */
@Mapper
public interface SmsSendLogMapper extends BaseMapper<SmsSendLog> {
    
}