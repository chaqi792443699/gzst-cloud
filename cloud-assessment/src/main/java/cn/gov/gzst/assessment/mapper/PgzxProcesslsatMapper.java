package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.PgzxProcesslsat;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * 审核记录表 Mapper 接口
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-23
 */
 @Mapper
public interface PgzxProcesslsatMapper extends BaseMapper<PgzxProcesslsat> {

 String findIdByPactid(String pactid);
}
