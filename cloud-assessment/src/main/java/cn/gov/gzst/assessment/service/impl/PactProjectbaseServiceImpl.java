package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PactProjectbase;
import cn.gov.gzst.assessment.mapper.PactProjectbaseMapper;
import cn.gov.gzst.assessment.service.IPactProjectbaseService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-04-08
 */
@Transactional
@Service("PactProjectbaseService")
public class PactProjectbaseServiceImpl extends CommonServiceImpl<PactProjectbaseMapper, PactProjectbase> implements IPactProjectbaseService {

    @Override
    public Page<PactProjectbase> getPactPro(Page<PactProjectbase> page, @Param("ew") Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectPactPro(page,wrapper));
        return page;
    }

    @Override
    public PactProjectbase exportProPact(Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1", "1");
        return baseMapper.exportProjectPact(wrapper);
    }

    @Override
    public int selectCount(@Param("ew")Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public Page<Map<String,Object>> selectList(Page<Map<String,Object>> page, Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        page.setRecords(baseMapper.selectList(page,wrapper));
        return page;
    }

    @Override
    public Map<String, Object> selectProjectAndContract(Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        return baseMapper.selectProjectAndContract(wrapper);
    }

    @Override
    public Page<Map<String,Object>> selectProjectByDeclarantId(Page<Map<String,Object>> page,@Param("ew") Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        page.setRecords(baseMapper.selectProjectByDeclarantId(page,wrapper));
        return page;
    }

    @Override
    public Page<Map<String, Object>> selectProject(Page<Map<String,Object>> page,Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        page.setRecords(baseMapper.selectProject(page,wrapper));
        return page;
    }

    @Override
    public List<Map<String, Object>> selectStatus() {
        return baseMapper.selectStatus();
    }

    @Override
    public Page<Map<String, Object>> contractByUser(Page<Map<String, Object>> page, Wrapper<PactProjectbase> wrapper) {
        wrapper.eq("1","1");
        page.setRecords(baseMapper.contractByUser(page,wrapper));
        return page;
    }

    @Override
    public Map<String, Object> selectUser(String userId) {
        return baseMapper.selectUser(userId);
    }
}
