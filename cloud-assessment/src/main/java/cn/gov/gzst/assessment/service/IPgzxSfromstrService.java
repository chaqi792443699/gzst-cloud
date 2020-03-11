package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.PgzxSfromstr;
import cn.gov.gzst.common.common.service.ICommonService;

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
public interface IPgzxSfromstrService extends ICommonService<PgzxSfromstr> {

    List<Map<String,Object>> findStructure(String pactid);

}
