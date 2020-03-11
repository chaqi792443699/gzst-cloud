package cn.gov.gzst.oss.mapper;

import cn.gov.gzst.oss.entity.Model;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-07-01
 */
 @Mapper
public interface ModelMapper extends BaseMapper<Model> {

  List<Map> selectModels(@Param("pid")String pid,@Param("ew") Wrapper<Model> wrapper);

}
