package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.cms.entity.Menu;
import cn.gov.gzst.cms.mapper.MenuMapper;
import cn.gov.gzst.cms.service.IMenuService;
import cn.gov.gzst.common.common.service.impl.TreeCommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 菜单服务实现类
 */
@Transactional
@Service("menuService")
public class MenuServiceImpl extends TreeCommonServiceImpl<MenuMapper,Menu,String> implements  IMenuService {
    @Override
    public boolean insert(Menu entity) {
        this.initParents(entity);
        return super.insert(entity);
    }

    @Override
    public boolean insertOrUpdate(Menu entity) {
        this.initParents(entity);
        Menu temp = this.selectById(entity.getId());
        boolean flag = super.insertOrUpdate(entity);
        String parentId = entity.getParentId();
        String oldId = temp.getParentId();
        boolean changeFlag = StringUtils.equals(parentId,oldId);
        if (flag && !changeFlag) {
            this.updateChildren(entity);
        }
        return flag;
    }

    /**
     * 初始化父级id
     * @param entity
     */
    public void initParents(Menu entity) {
        List<Menu> parents = new ArrayList<>();
        parents = this.makeParents(entity, parents);
        if (parents.size() > 0) {
            StringBuilder parentIds = new StringBuilder("");
            for (Menu menu : parents) {
                if (!StringUtils.isEmpty(parentIds)) {
                    parentIds.append("/");
                }
                parentIds.append(menu.getId());
            }
            entity.setParentIds(parentIds.toString());
        } else {
            entity.setParentIds("");
        }
    }

    /**
     * 更新子节点的parents
     * @param menu
     */
    public void updateChildren(Menu menu) {
        EntityWrapper<Menu> wrapper = new EntityWrapper(Menu.class);
        wrapper.eq("parent_id",menu.getId());
        List<Menu> children = this.selectList(wrapper);
        if (children.size() == 0) {
            return;
        } else {
            String parentIds = menu.getParentIds() + "/" + menu.getId();
            for (Menu menu1 : children) {
                menu1.setParentIds(parentIds);
                this.saveOrUpdate(menu1);
                this.updateChildren(menu1);
            }
        }
    }

    @Override
    public List<Menu> formatNodes(List<Menu> menus) throws Exception {
        if (menus == null) return null;
        EntityWrapper<Menu> wrapper = null;
        Integer cnt = 0;
        for (Menu menu : menus) {
            List<Menu> parents = new ArrayList<>();
            parents = this.makeParents(menu, parents);
            if (parents.size() == 0) {
                menu.setLevel(0);
                menu.setParents("");
            } else {
                menu.setLevel(parents.size());
                StringBuilder parentNames = new StringBuilder("");
                StringBuilder parentIds = new StringBuilder("");
                for (Menu parent : parents) {
                    if (!StringUtils.isEmpty(parentNames.toString())) {
                        parentNames.append("/");
                    }
                    if (!StringUtils.isEmpty(parentIds.toString())) {
                        parentIds.append("/");
                    }
                    parentNames.append(parent.getName());
                    parentIds.append(parent.getId());
                }
                menu.setParents(parentNames.toString());
                menu.setParentIds(parentIds.toString());
            }
            wrapper = new EntityWrapper<>(Menu.class);
            wrapper.eq("parent_id",menu.getId());
            cnt = this.selectCount(wrapper);
            menu.setHasChildren(cnt > 0);
        }
        return menus;
    }

    /**
     * 递归生成父级
     * @param menu
     * @param parents
     * @return
     */
    @Override
    public List<Menu> makeParents(Menu menu, List<Menu> parents) {
        if (menu == null) {
            return parents;
        }
        if (!StringUtils.isEmpty(menu.getParentId())) {
            Menu parent = this.selectById(menu.getParentId());
            if (parent != null) {
                parents.add(0,parent);
            }
            return this.makeParents(parent,parents);
        } else {
            return parents;
        }
    }
}