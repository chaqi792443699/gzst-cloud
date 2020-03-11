package cn.gov.gzst.oss.service;

import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.oss.entity.Model;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-07-01
 */
public interface IModelService extends ICommonService<Model> {

    List<Map> selectModels(String pid,Wrapper<Model> wrapper);

}
