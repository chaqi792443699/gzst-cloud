package cn.gov.gzst.email.mapper;

import cn.gov.gzst.email.entity.SendLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: 发送日志数据库控制层接口
 * @description: 发送日志数据库控制层接口
 */
@Mapper
public interface SendLogMapper extends BaseMapper<SendLog> {
    
}