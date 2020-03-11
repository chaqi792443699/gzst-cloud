package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.FinanceProjectExtract;
import cn.gov.gzst.assessment.mapper.FinanceProjectExtractMapper;
import cn.gov.gzst.assessment.service.FinanceProjectExtractService;
import cn.gov.gzst.common.common.service.ISSOPermissionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@Transactional
@Service("CwpgProjectExtractService")
public class FinanceProjectExtractServiceImpl extends CommonServiceImpl<FinanceProjectExtractMapper, FinanceProjectExtract> implements FinanceProjectExtractService{
    @Override
    public FinanceProjectExtract selectProjectByProjectId(String projectId) {
        return baseMapper.selectProjectByProjectId(projectId);
    }

    @Override
    public List<FinanceProjectExtract> select(@Param("ew") Wrapper<FinanceProjectExtract> wrapper) {
        wrapper.eq("1","1");
        return baseMapper.select(wrapper);
    }

    @Override
    public boolean updateByProjectId(Map<String ,Object> map) {
        return baseMapper.updateByProjectId(map);
    }

    @Override
    public List<FinanceProjectExtract> selectExtractBatch() {
        return baseMapper.selectExtractBatch();
    }

    @Override
    public FinanceProjectExtract selectRecentBatch() {
        return baseMapper.selectRecentBatch();
    }

}
