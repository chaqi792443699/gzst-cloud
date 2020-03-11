package cn.gov.gzst.pms.service;

import cn.gov.gzst.pms.entity.PactProjectbase;
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
 * @author wuzhengjun
 * @since 2019-04-08
 */
public interface IPactProjectbaseService extends ICommonService<PactProjectbase> {

    public Page<PactProjectbase> getPactPro(Page<PactProjectbase> page, @Param("ew") Wrapper<PactProjectbase> wrapper);

    //项目合同批量导出
    public PactProjectbase exportProPact(@Param("ew") Wrapper<PactProjectbase> wrapper);

    int selectCount(@Param("ew")Wrapper<PactProjectbase> wrapper);

    /**
     * 随机抽取项目
     * @param page
     * @param wrapper
     * @return
     */
    Page<Map<String,Object>> selectList(Page<Map<String,Object>> page, @Param("ew")Wrapper<PactProjectbase> wrapper);

    /**
     * 根据项目编号查询项目信息和合同信息
     * @param wrapper
     * @return
     */
    Map<String,Object> selectProjectAndContract(@Param("ew") Wrapper<PactProjectbase> wrapper);

    /**
     * 根据条件查询项目信息
     * @return
     */
    Page<Map<String,Object>> selectProjectByDeclarantId(Page<Map<String,Object>> page,@Param("ew") Wrapper<PactProjectbase> wrapper);
    Map<String,Object> selectProject(@Param("ew") Wrapper<PactProjectbase> wrapper);
    List<Map<String,Object>> selectStatus();

    /**
     * 根据pact列表查询出项目基本信息
     * @return
     */
    List<Map<String,Object>> adminFindList(List pactidlist);

    List<Map<String,Object>> userFindList(String userid);
}
