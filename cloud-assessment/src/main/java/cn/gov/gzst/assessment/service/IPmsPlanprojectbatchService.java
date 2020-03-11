package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.PmsPlanprojectbatch;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-09
 */
public interface IPmsPlanprojectbatchService extends ICommonService<PmsPlanprojectbatch> {

    public List<PmsPlanprojectbatch> selectAnnually();

}
