package cn.gov.gzst.oss.service.impl;

import cn.gov.gzst.oss.entity.Model;
import cn.gov.gzst.oss.mapper.ModelMapper;
import cn.gov.gzst.oss.service.IModelService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-07-01
 */
@Transactional
@Service("ModelService")
public class ModelServiceImpl extends CommonServiceImpl<ModelMapper, Model> implements IModelService {

    @Override
    public List<Map> selectModels(String pid,Wrapper<Model> wrapper) {
        wrapper.eq("1","1");
        return this.baseMapper.selectModels(pid,wrapper);
    }
}
