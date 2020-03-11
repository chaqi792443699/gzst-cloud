package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.PgzxProcesslsat;
import cn.gov.gzst.common.common.service.ICommonService;
/**
 * <p>
 * 审核记录表 服务接口类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-23
 */
public interface IPgzxProcesslsatService extends ICommonService<PgzxProcesslsat> {

    String findIdByPactid(String pactid);
}
