package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PgzxEvalform;
import cn.gov.gzst.assessment.mapper.PgzxEvalformMapper;
import cn.gov.gzst.assessment.service.IPgzxEvalformService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
@Service("PgzxEvalformService")
public class PgzxEvalformServiceImpl extends CommonServiceImpl<PgzxEvalformMapper, PgzxEvalform> implements IPgzxEvalformService {

    @Autowired PgzxEvalformMapper pgzxEvalformMapper;


    @Override
    public Page<Map<String, Object>> userFindContructList(Page<Map<String, Object>> page, Wrapper<PgzxEvalform> wrapper) {
        wrapper.eq("1","1");
        page.setRecords(pgzxEvalformMapper.userFindContructList(page,wrapper));
        return page;
    }

    @Override
    public Map Findbase(String pactid) {
        return pgzxEvalformMapper.Findbase(pactid);
    }

    @Override
    public Map Findevalform(String pactid) {
        return  pgzxEvalformMapper.Findevalform(pactid);
    }

    @Override
    public List<Map<String,Object>> Findsfromres(String pactid) {
        return  pgzxEvalformMapper.Findsfromres(pactid);
    }


}
