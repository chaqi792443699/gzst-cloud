package cn.gov.gzst.sms.mapper;

import cn.gov.gzst.sms.entity.SmsConfig;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Title: 短信配置数据库控制层接口
 * @Description: 短信配置数据库控制层接口
 *
 */
@Mapper
public interface SmsConfigMapper extends BaseMapper<SmsConfig> {
    
}