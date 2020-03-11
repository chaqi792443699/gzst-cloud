package cn.gov.gzst.pms.mapper;

import cn.gov.gzst.pms.entity.PmsPlanprojectbatch;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-09
 */
 @Mapper
public interface PmsPlanprojectbatchMapper extends BaseMapper<PmsPlanprojectbatch> {

  public List<PmsPlanprojectbatch> getAn();
}
