package cn.gov.gzst.survey.service.impl;

import cn.gov.gzst.survey.entity.Option;
import cn.gov.gzst.survey.mapper.OptionMapper;
import cn.gov.gzst.survey.service.IOptionService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuzhengjun
 * @since 2019-03-12
 */
@Transactional
@Service("OptionService")
public class OptionServiceImpl extends CommonServiceImpl<OptionMapper, Option> implements IOptionService {

}
