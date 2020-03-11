package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.EvalSelfStructure;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-19
 */
 @Mapper
public interface EvalSelfStructureMapper extends BaseMapper<EvalSelfStructure> {

 List<Map<String,Object>> findAllStrInfo();
}
