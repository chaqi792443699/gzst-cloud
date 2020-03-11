package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.EvalProcess;
import cn.gov.gzst.assessment.mapper.EvalProcessMapper;
import cn.gov.gzst.assessment.service.IEvalProcessService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-26
 */
@Transactional
@Service("EvalProcessService")
public class EvalProcessServiceImpl extends CommonServiceImpl<EvalProcessMapper, EvalProcess> implements IEvalProcessService {

    @Autowired
    private EvalProcessMapper evalProcessMapper;

    @Override
    public List<EvalProcess> findRecord(String pactid) {
        return evalProcessMapper.findRecord(pactid);
    }

    @Override
    public  List<EvalProcess> adminFindApprovalRecord(String pactid) {
        return evalProcessMapper.adminFindApprovalRecord(pactid);
    }

    @Override
    public String finByPactidAndState(String pactid,int state) {
        return evalProcessMapper.finByPactidAndState(pactid,state);
    }

    @Override
    public int checkfinish(String pactid) {
        return evalProcessMapper.checkfinish(pactid);
    }
}
