package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.entity.EvalSelfResult;
import cn.gov.gzst.common.common.service.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-19
 */
public interface IEvalSelfResultService extends ICommonService<EvalSelfResult> {

    List<Map<String,Object>> userFindList(String userid);

    List<Map<String,Object>> userFindDetail(String pactid);

    List<Map<String,Object>> adminFindListDone(int page,int size);

    List<Map<String,Object>> adminFindListTodo(int page,int size);


    List<EvalProcesslast> adminFindListtodoone(int page,int size);

    List<EvalProcesslast>  adminFindListoDoneone();
}
