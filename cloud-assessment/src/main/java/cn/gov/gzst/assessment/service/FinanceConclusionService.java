package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.FinanceConclusion;
import cn.gov.gzst.common.common.service.ICommonService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
public interface FinanceConclusionService extends ICommonService<FinanceConclusion> {
        List<Map<String,Object>> selectConclusionList(@Param("ew") Wrapper<FinanceConclusion> wrapper);
        Boolean conclusionSave(FinanceConclusion conclusion);
        FinanceConclusion selectConclusionByProjectId(String projectId);
        boolean conclusionUp(FinanceConclusion conclusion);
}
