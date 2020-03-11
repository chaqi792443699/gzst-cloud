package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.FinanceProjectExtract;
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
 * @author chaqi
 * @since 2019-04-10
 */
 @Mapper
public interface FinanceProjectExtractMapper extends BaseMapper<FinanceProjectExtract> {
               FinanceProjectExtract selectProjectByProjectId(String projectId);
               List<FinanceProjectExtract> select(@Param("ew")Wrapper<FinanceProjectExtract> wrapper);
               boolean updateByProjectId(Map<String ,Object> map);
               List<FinanceProjectExtract> selectExtractBatch();
               FinanceProjectExtract selectRecentBatch();

 }
