package cn.gov.gzst.email.mapper;

import cn.gov.gzst.email.entity.Config;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @title: 邮件配置数据库控制层接口
 * @description: 邮件配置数据库控制层接口
 */
@Mapper
public interface ConfigMapper extends BaseMapper<Config> {
    
}