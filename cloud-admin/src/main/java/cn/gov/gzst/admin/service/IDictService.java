package cn.gov.gzst.admin.service;


import cn.gov.gzst.admin.entity.Dict;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @author jwcg
 * @date 2017-02-09 09:05:29
 * @version V1.0
 *
 */
public interface IDictService extends ICommonService<Dict> {
    List<Dict> selectDictList();

    /**
     * 根据字典值获取显示label
     * @param code
     * @param value
     * @return
     */
    String getLabel(String code,String value);

    /**
     * 根据label获取字典值
     * @param code
     * @param label
     * @return
     */
    String getValue(String code,String label);
}
