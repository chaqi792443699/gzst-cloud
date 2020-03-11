package cn.gov.gzst.assessment.service;

import cn.gov.gzst.assessment.entity.PgzxSfromres;
import cn.gov.gzst.common.common.service.ICommonService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author lwy
 * @since 2019-05-22
 */
public interface IPgzxSfromresService extends ICommonService<PgzxSfromres> {

    List<Map<String, Object>> adminFindTodoList(int page,int size);

    List<Map<String, Object>> adminFindDoneList(int page,int size);

    List<Map<String,Object>> findBylistPactno(String pacton , Integer page, Integer size);
}
