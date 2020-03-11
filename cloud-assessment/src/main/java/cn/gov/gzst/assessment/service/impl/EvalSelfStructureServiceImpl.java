package cn.gov.gzst.assessment.service.impl;


import cn.gov.gzst.assessment.entity.EvalSelfStructure;
import cn.gov.gzst.assessment.mapper.EvalSelfStructureMapper;
import cn.gov.gzst.assessment.service.IEvalSelfStructureService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
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
 * @author lonwanyuan
 * @since 2019-04-19
 */
@Transactional
@Service("EvalSelfStructureService")
public class EvalSelfStructureServiceImpl extends CommonServiceImpl<EvalSelfStructureMapper, EvalSelfStructure> implements IEvalSelfStructureService {

    @Autowired
    private EvalSelfStructureMapper evalSelfStructureMapper;
    @Override
    public List<Map<String, Object>> findAllStrInfo() {
        return evalSelfStructureMapper.findAllStrInfo();
    }
}
