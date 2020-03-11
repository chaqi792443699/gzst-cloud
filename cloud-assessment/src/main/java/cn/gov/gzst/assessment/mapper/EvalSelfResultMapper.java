package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.entity.EvalSelfResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-19
 */
 @Mapper
public interface EvalSelfResultMapper extends BaseMapper<EvalSelfResult> {

 List<Map<String,Object>>  userFindList(String userid);

 List<Map<String,Object>> userFindDetail(String pactid);

 List<Map<String,Object>> adminFindListDone();

 List<Map<String,Object>> adminFindListTodo();


 List<EvalProcesslast> adminFindListtodoone();

 List<EvalProcesslast> adminFindListoDoneone();
}
