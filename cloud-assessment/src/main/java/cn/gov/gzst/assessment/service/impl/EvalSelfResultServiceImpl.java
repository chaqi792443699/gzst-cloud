package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.EvalProcesslast;
import cn.gov.gzst.assessment.entity.EvalSelfResult;
import cn.gov.gzst.assessment.mapper.EvalSelfResultMapper;
import cn.gov.gzst.assessment.service.IEvalSelfResultService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-04-19
 */
@Transactional
@Service("EvalSelfResultService")
public class EvalSelfResultServiceImpl extends CommonServiceImpl<EvalSelfResultMapper, EvalSelfResult> implements IEvalSelfResultService {

    @Autowired
    private EvalSelfResultMapper evalSelfResultMapper;




    @Override
    public List<Map<String,Object>> userFindList(String userid) {
        return evalSelfResultMapper.userFindList(userid);
    }

    @Override
    public List<Map<String, Object>> userFindDetail(String pactid) {
        return evalSelfResultMapper.userFindDetail(pactid);
    }

    @Override
    public List<Map<String, Object>> adminFindListDone(int page,int size) {
        PageHelper.startPage(page, size);
        return evalSelfResultMapper.adminFindListDone();
    }

    @Override
    public List<Map<String, Object>> adminFindListTodo(int page,int size) {
        PageHelper.startPage(page, size);
        return evalSelfResultMapper.adminFindListTodo();
    }

    @Override
    public List<EvalProcesslast> adminFindListtodoone(int page,int size) {
        PageHelper.startPage(page, size);
        return evalSelfResultMapper.adminFindListtodoone();
    }

    @Override
    public  List<EvalProcesslast>  adminFindListoDoneone() {
        return evalSelfResultMapper.adminFindListoDoneone();
    }


}
