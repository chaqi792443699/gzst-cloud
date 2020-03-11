package cn.gov.gzst.assessment.service.impl;

import cn.gov.gzst.assessment.entity.PgzxSfromres;
import cn.gov.gzst.assessment.mapper.PgzxSfromresMapper;
import cn.gov.gzst.assessment.mapper.PgzxSfromstrMapper;
import cn.gov.gzst.assessment.service.IPgzxSfromresService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
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
@Service("PgzxSfromresService")
public class PgzxSfromresServiceImpl extends CommonServiceImpl<PgzxSfromresMapper, PgzxSfromres> implements IPgzxSfromresService {

    @Autowired
    PgzxSfromresMapper pgzxSfromresMapper;

    @Override
    public List<Map<String, Object>> adminFindTodoList(int page,int size) {

        PageHelper.startPage(page, size);
        return pgzxSfromresMapper.adminFindTodoList();
    }

    @Override
    public List<Map<String, Object>> adminFindDoneList(int page,int size) {
        PageHelper.startPage(page, size);
        return pgzxSfromresMapper.adminFindDoneList();
    }

    @Override
    public List<Map<String, Object>> findBylistPactno(String pactno , Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return pgzxSfromresMapper.findBylistPactno(pactno);
    }
}
