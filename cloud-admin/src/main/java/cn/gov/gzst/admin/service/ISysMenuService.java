package cn.gov.gzst.admin.service;

import cn.gov.gzst.admin.entity.Route;
import cn.gov.gzst.admin.entity.SysMenu;
import cn.gov.gzst.admin.entity.SysScene;
import cn.gov.gzst.common.common.service.ICommonService;
import cn.gov.gzst.common.common.service.ITreeCommonService;

import java.util.List;

/**
 * <p>
 *  服务接口类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-16
 */
public interface ISysMenuService extends ICommonService<SysMenu> {
    /**
     * 格式化树数据
     * @param menus
     * @return
     * @throws Exception
     */
    List<SysMenu> formatNodes(List<SysMenu> menus) throws Exception;

    /**
     * 递归构造父级
     * @param menu
     * @param parents
     * @return
     * @throws Exception
     */
    List<SysMenu> makeParents(SysMenu menu, List<SysMenu> parents) throws Exception;

    /**
     * 获取某模块的路由
     * @param scene
     * @return
     */
    List<Route> findRoutes(SysScene scene);
}
