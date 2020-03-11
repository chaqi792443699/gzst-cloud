package cn.gov.gzst.admin.mapper;

import cn.gov.gzst.admin.entity.App;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**   
 * @Title: 应用管理数据库控制层接口
 * @Description: 应用管理数据库控制层接口
 * @author jeeweb
 * @date 2017-07-31 10:48:08
 * @version V1.0   
 *
 */
@Mapper
public interface AppMapper extends BaseMapper<App> {
    
}