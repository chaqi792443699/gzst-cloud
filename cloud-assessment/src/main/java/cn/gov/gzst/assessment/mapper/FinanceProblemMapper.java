package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.assessment.entity.FinanceProblem;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
public interface FinanceProblemMapper extends BaseMapper<FinanceProblem> {
         boolean problemUpdate(Map<String,Object> map);

         List<FinanceProblem> selectProblemList(String projectId);
}
