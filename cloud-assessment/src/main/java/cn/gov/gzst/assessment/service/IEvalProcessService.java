package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.EvalProcess;
import cn.gov.gzst.common.bean.ResponseResult;
import cn.gov.gzst.common.common.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-26
 */
public interface IEvalProcessService extends ICommonService<EvalProcess> {



    List<EvalProcess> findRecord(String pactid);

    List<EvalProcess> adminFindApprovalRecord(String pactid);

    String finByPactidAndState(String pactid,int state);

    int checkfinish(String pactid);

}
