package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.PgzxEvalform;
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
 * @author lwy
 * @since 2019-05-22
 */
public interface IPgzxEvalformService extends ICommonService<PgzxEvalform> {


    Page<Map<String,Object>> userFindContructList(@Param("page") Page<Map<String,Object>> page, @Param("ew") Wrapper<PgzxEvalform> wrapper);

    Map Findbase(String pactid);

    Map Findevalform(String pactid);

    List<Map<String,Object>> Findsfromres(String pactid);
}
