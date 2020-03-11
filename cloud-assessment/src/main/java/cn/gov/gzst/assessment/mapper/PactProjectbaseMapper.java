package cn.gov.gzst.assessment.mapper;

import cn.gov.gzst.assessment.entity.PactProjectbase;
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
 * @author wuzhengjun
 * @since 2019-04-08
 */
 @Mapper
public interface PactProjectbaseMapper extends BaseMapper<PactProjectbase> {

  //状态跟踪查询
  public List<PactProjectbase> selectPactPro(Page<PactProjectbase> page, @Param("ew") Wrapper<PactProjectbase> wrapper);

  //项目合同批量导出
  public PactProjectbase exportProjectPact(@Param("ew") Wrapper<PactProjectbase> wrapper);

  /**
   *根据条件查询项目总条数
   * @param map
   * @return
   */
  Integer selectCount(@Param("ew")Wrapper<PactProjectbase> wrapper);

  /**
   * 查询所有项目信息
   * @param page
   * @param wrapper
   * @return
   */
  List<Map<String,Object>> selectList(Page<Map<String,Object>> page, @Param("ew")Wrapper<PactProjectbase> wrapper);

  /**
   * 根据项目编号查询项目信息和合同信息
   * @param wrapper
   * @return
   */
  Map<String,Object> selectProjectAndContract(@Param("ew") Wrapper<PactProjectbase> wrapper);


  List<Map<String,Object>> selectProject(@Param("page")Page<Map<String,Object>> page,@Param("ew") Wrapper<PactProjectbase> wrapper);

  /**
   * 根据登陆的项目负责人查询项目信息
   * @param page
   * @param wrapper
   * @return
   */
  List<Map<String,Object>> selectProjectByDeclarantId(Page<Map<String,Object>> page,@Param("ew") Wrapper<PactProjectbase> wrapper);

  List<Map<String,Object>> selectStatus();

  /**
   * @param page
   * @param wrapper
   * @return
   */
  List<Map<String,Object>> contractByUser(@Param("page")Page<Map<String,Object>> page,@Param("ew")Wrapper<PactProjectbase> wrapper);

  /**
   * 查询用户姓名
   * @param userId
   * @return
   */
  Map<String,Object> selectUser(String userId);
}
