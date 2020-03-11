package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Dict;
import cn.gov.gzst.admin.entity.DictGroup;
import cn.gov.gzst.admin.mapper.DictGroupMapper;
import cn.gov.gzst.admin.service.IDictService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.admin.service.IDictGroupService;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper, DictGroup> implements IDictGroupService {
    @Autowired
    IDictService dictService;
    @Override
    public boolean deleteById(Serializable id) {
        EntityWrapper<Dict> wrapper = new EntityWrapper<>(Dict.class);
        wrapper.eq("gid",id);
        dictService.delete(wrapper);
        return super.deleteById(id);
    }
}
