package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.Evaluation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mrlong
 * @since 2019-04-12
 */
 @Mapper
public interface EvaluationMapper extends BaseMapper<Evaluation> {


    Evaluation findById(String id);

    Map  getReportBaseInfo(String pactid);

    Map getEvalInfo(String pactid);
}
