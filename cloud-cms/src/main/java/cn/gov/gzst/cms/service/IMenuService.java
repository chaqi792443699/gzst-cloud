package cn.gov.gzst.cms.service;

import cn.gov.gzst.cms.entity.Menu;
import cn.gov.gzst.common.common.service.ITreeCommonService;

import java.util.List;

/**
 * CMS菜单管理
 */
public interface IMenuService extends ITreeCommonService<Menu,String> {
    /**
     * 格式化树数据
     * @param Menus
     * @return
     * @throws Exception
     */
    List<Menu> formatNodes(List<Menu> Menus) throws Exception;

    /**
     * 递归构造父级
     * @param menu
     * @param parents
     * @return
     * @throws Exception
     */
    List<Menu> makeParents(Menu menu, List<Menu> parents) throws Exception;

}