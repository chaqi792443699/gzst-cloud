package cn.gov.gzst.cms.mapper;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.entity.Slide;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.mapper
 * @title: 幻灯片数据库控制层接口
 * @description: 幻灯片数据库控制层接口
 * @author: jianliaoliang
 * @date: 2018-04-28 15:38:16
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */
@Mapper
public interface SlideMapper extends BaseMapper<Slide> {
 List<Slide> selectList(Page<Slide> page, @Param("ew") Wrapper<Slide> wrapper);

}