package cn.gov.gzst.survey.service;

import cn.gov.gzst.survey.entity.Scheme;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
public interface ISchemeService extends ICommonService<Scheme> {

    public void delete(String id);

    public Scheme getScheme(String id);

}
