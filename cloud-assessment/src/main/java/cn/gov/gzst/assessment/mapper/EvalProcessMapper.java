package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.EvalProcess;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-26
 */
 @Mapper
public interface EvalProcessMapper extends BaseMapper<EvalProcess> {

    List<EvalProcess> findRecord(String pactid);

    List<EvalProcess> adminFindApprovalRecord(String pactid);

    String finByPactidAndState(String pactid,int opinion);

    int checkfinish(String pactid);
}
