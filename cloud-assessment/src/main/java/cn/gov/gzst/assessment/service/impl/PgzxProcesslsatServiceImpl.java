package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PgzxProcesslsat;
import cn.gov.gzst.assessment.mapper.PgzxProcesslsatMapper;
import cn.gov.gzst.assessment.service.IPgzxProcesslsatService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 * 审核记录表 服务实现类
 * </p>
 *
 * @author longwanyuan
 * @since 2019-05-23
 */
@Transactional
@Service("PgzxProcesslsatService")
public class PgzxProcesslsatServiceImpl extends CommonServiceImpl<PgzxProcesslsatMapper, PgzxProcesslsat> implements IPgzxProcesslsatService {

    @Autowired
    PgzxProcesslsatMapper pgzxProcesslsatMapper;

    @Override
    public String findIdByPactid(String pactid) {
        return pgzxProcesslsatMapper.findIdByPactid(pactid);
    }
}
