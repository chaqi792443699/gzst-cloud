package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.FinanceProcess;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
 @Mapper
public interface FinanceProcessMapper extends BaseMapper<FinanceProcess> {
        List<FinanceProcess> selectProcessById(String projectId);
        FinanceProcess selectProcessByProjectId(String projectId);
}
