package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.App;
import cn.gov.gzst.admin.mapper.AppMapper;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.admin.service.IAppService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 应用管理
 * @Description: 应用管理
 * @author jeeweb
 * @date 2017-07-31 10:48:08
 * @version V1.0   
 *
 */
@Transactional
@Service("appService")
public class AppServiceImpl  extends CommonServiceImpl<AppMapper, App> implements  IAppService {

}
