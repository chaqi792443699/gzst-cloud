package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
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
 * @author chaqi
 * @since 2019-04-10
 */
 @Mapper
public interface FinanceConclusionMapper extends BaseMapper<FinanceConclusion> {
       List<Map<String,Object>> selectConclusionList(@Param("ew") Wrapper<FinanceConclusion> wrapper);
       Boolean conclusionSave(FinanceConclusion conclusion);
       FinanceConclusion selectConclusionByProjectId(String projectId);
       boolean conclusionUp(FinanceConclusion conclusion);

 }
