package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PgzxSfromstr;
import cn.gov.gzst.assessment.mapper.PgzxSfromstrMapper;
import cn.gov.gzst.assessment.service.IPgzxSfromstrService;
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
 * @author lwy
 * @since 2019-05-22
 */
@Transactional
@Service("PgzxSfromstrService")
public class PgzxSfromstrServiceImpl extends CommonServiceImpl<PgzxSfromstrMapper, PgzxSfromstr> implements IPgzxSfromstrService {

    @Autowired
    private PgzxSfromstrMapper pgzxSfromstrMapper;

    @Override
    public List<Map<String, Object>> findStructure(String pactid) {
        return pgzxSfromstrMapper.findStructure(pactid);
    }
}
