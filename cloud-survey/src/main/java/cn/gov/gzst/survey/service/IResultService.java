package cn.gov.gzst.survey.service;

import cn.gov.gzst.survey.entity.Result;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.survey.entity.Scheme;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-13
 */
public interface IResultService extends ICommonService<Result> {
    //查看结果
    public Map getResult(String questionnaireId,String schemeId,String questionId,String userId);

    //统计
    public Map statistics(String naireId,String questionId,String optionId);

}
