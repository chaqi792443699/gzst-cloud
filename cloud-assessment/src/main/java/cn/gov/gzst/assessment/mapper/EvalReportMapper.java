package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.EvalReport;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lonwanyuan
 * @since 2019-04-11
 */
 @Mapper
public interface EvalReportMapper extends BaseMapper<EvalReport> {

 Map findByPactno(String pactno);

 HashMap findByPactnoKj(String pactno);
}
