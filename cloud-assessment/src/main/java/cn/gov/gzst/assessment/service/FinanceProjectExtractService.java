package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.FinanceProjectExtract;
import cn.gov.gzst.common.common.service.ICommonService;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
public interface FinanceProjectExtractService extends ICommonService<FinanceProjectExtract> {
    FinanceProjectExtract selectProjectByProjectId(String projectId);
    List<FinanceProjectExtract> select(@Param("ew") Wrapper<FinanceProjectExtract> wrapper);
    boolean updateByProjectId(Map<String ,Object> map);
    List<FinanceProjectExtract> selectExtractBatch();
    FinanceProjectExtract selectRecentBatch();
}
