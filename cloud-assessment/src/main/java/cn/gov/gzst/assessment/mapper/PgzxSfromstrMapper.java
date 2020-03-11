package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.PgzxSfromstr;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
 @Mapper
public interface PgzxSfromstrMapper extends BaseMapper<PgzxSfromstr> {

 List<Map<String,Object>> findStructure(String pactid);

}
