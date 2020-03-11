package cn.gov.gzst.pms.service.impl;

import cn.gov.gzst.pms.entity.PmsPlanprojectbatch;
import cn.gov.gzst.pms.mapper.PmsPlanprojectbatchMapper;
import cn.gov.gzst.pms.service.IPmsPlanprojectbatchService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-09
 */
@Transactional
@Service("PmsPlanprojectbatchService")
public class PmsPlanprojectbatchServiceImpl extends CommonServiceImpl<PmsPlanprojectbatchMapper, PmsPlanprojectbatch> implements IPmsPlanprojectbatchService {

    @Override
    public List<PmsPlanprojectbatch> selectAnnually() {
        return baseMapper.getAn();
    }
}
