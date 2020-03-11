package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.PgzxEvalform;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
 @Mapper
public interface PgzxEvalformMapper extends BaseMapper<PgzxEvalform> {

 List<Map<String,Object>> userFindContructList(@Param("page") Page<Map<String,Object>> page, @Param("ew")Wrapper<PgzxEvalform> wrapper);

 Map Findbase(String pactid);

 Map Findevalform(String pactid);

 List<Map<String,Object>> Findsfromres(String pactid);
}
