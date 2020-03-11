package cn.gov.gzst.sms.mapper;

import cn.gov.gzst.sms.entity.SmsModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信模板数据库控制层接口
 */
@Mapper
public interface SmsModelMapper extends BaseMapper<SmsModel> {

}