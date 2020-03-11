package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Model;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

 /**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.mapper
 * @title: 模型管理数据库控制层接口
 * @description: 模型管理数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:51
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface ModelMapper extends BaseMapper<Model> {
    
}