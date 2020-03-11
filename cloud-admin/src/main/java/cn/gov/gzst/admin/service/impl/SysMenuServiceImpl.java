package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.*;
import cn.gov.gzst.admin.entity.SysMenu;
import cn.gov.gzst.admin.mapper.SysMenuMapper;
import cn.gov.gzst.admin.service.*;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-16
 */
@Transactional
@Service("SysMenuService")
@CacheConfig(cacheNames = "menu",cacheManager = "cacheManager")
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    ISecResourceService secResourceService;

    @Autowired
    ISecAuthorityResourceService secAuthorityResourceService;

    @Autowired
    ISecRoleAuthorityService secRoleAuthorityService;

    @Autowired
    ISysSceneService sysSceneService;

    @Autowired
    IRoleService roleService;

    @Override
    @CacheEvict(key = "menu-cache~keys",allEntries = true)
    public boolean insert(SysMenu entity) {
        this.initParents(entity);
        return super.insert(entity);
    }

    @Override
    @CacheEvict(key = "#entity.id",allEntries = true)
    public boolean insertOrUpdate(SysMenu entity) {
        this.initParents(entity);
        SysMenu temp = this.selectById(entity.getId());
        boolean flag = super.insertOrUpdate(entity);
        String parentId = entity.getParentId();
        String oldId = temp.getParentId();
        boolean changeFlag = StringUtils.equals(parentId,oldId);
        if (flag && !changeFlag) {
            this.updateChildren(entity);
        }
        return flag;
    }

    @Override
    @CacheEvict(key = "menu-cache~keys",allEntries = true)
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }

    /**
     * 初始化父级id
     * @param entity
     */
    public void initParents(SysMenu entity) {
        List<SysMenu> parents = new ArrayList<>();
        parents = this.makeParents(entity, parents);
        if (parents.size() > 0) {
            StringBuilder parentIds = new StringBuilder("");
            for (SysMenu menu : parents) {
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
    public void updateChildren(SysMenu menu) {
        EntityWrapper<SysMenu> wrapper = new EntityWrapper(SysMenu.class);
        wrapper.eq("parent_id",menu.getId());
        List<SysMenu> children = this.selectList(wrapper);
        if (children.size() == 0) {
            return;
        } else {
            String parentIds = menu.getParentIds() + "/" + menu.getId();
            for (SysMenu menu1 : children) {
                menu1.setParentIds(parentIds);
                this.saveOrUpdate(menu1);
                this.updateChildren(menu1);
            }
        }
    }

    @Override
    public List<SysMenu> formatNodes(List<SysMenu> menus) throws Exception {
        if (menus == null) return null;
        EntityWrapper<SysMenu> wrapper = null;
        Integer cnt = 0;
        for (SysMenu menu : menus) {
            List<SysMenu> parents = new ArrayList<>();
            parents = this.makeParents(menu, parents);
            if (parents.size() == 0) {
                menu.setLevel(0);
                menu.setParents("");
            } else {
                menu.setLevel(parents.size());
                StringBuilder parentNames = new StringBuilder("");
                StringBuilder parentIds = new StringBuilder("");
                for (SysMenu parent : parents) {
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
            wrapper = new EntityWrapper<>(SysMenu.class);
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
    public List<SysMenu> makeParents(SysMenu menu, List<SysMenu> parents) {
        if (menu == null) {
            return parents;
        }
        if (!StringUtils.isEmpty(menu.getParentId())) {
            SysMenu parent = this.selectById(menu.getParentId());
            if (parent != null) {
                parents.add(0,parent);
            }
            return this.makeParents(parent,parents);
        } else {
            return parents;
        }
    }

    @Override
    @Cacheable(cacheNames = "menu-cache", key="#scene.id")
    public List<Route> findRoutes(SysScene scene) {
        List<Route> list = new ArrayList<>();
        if (scene == null) {
            return list;
        }
        EntityWrapper<SysMenu> wrapper = new EntityWrapper<>(SysMenu.class);
        wrapper.eq("1","1");
        wrapper.andNew().eq("parent_id","").or().isNull("parent_id");
        wrapper.andNew().eq("scene_id",scene.getId());
        wrapper.orderBy("sort");
        List<SysMenu> menus = this.selectList(wrapper);
        for (SysMenu menu : menus) {
            List<Route> routeList = new ArrayList<>();
            this.makeRoutes(menu,routeList);
            if (routeList.size() > 0) {
                list.addAll(routeList);
            }
        }
        return list;
    }

    /**
     * 根据sourceid找到具备权限的角色，此处性能会有问题
     * 暂时这样处理，后期直接通过sql来获取
     * @param sourceId
     * @return
     */
    List<String> findRoles(String sourceId) {
        ArrayList<String> roles = new ArrayList<>();
        if (StringUtils.isEmpty(sourceId)) return roles;
        List<Role> roleList = this.roleService.findListBySouceId(sourceId);
        for (Role role : roleList) {
            roles.add(role.getCode());
        }
        return roles;
    }

    /**
     * 根据菜单生成Route
     * @param menu
     * @return
     */
    public Route createRoute(SysMenu menu) {
        if (menu == null) return null;
        Route route = new Route();
        route.setName(menu.getName());
        route.setPath(menu.getPath());
        route.setComponent(menu.getComponent());
        List<String> roles = new ArrayList<>();
        if (!StringUtils.isEmpty(menu.getSourceId())) {
            SecResource resource = this.secResourceService.selectById(menu.getSourceId());
            route.setComponent(resource.getSource());
            roles = this.findRoles(resource.getId());
        }
        route.setRedirect(menu.getRedirect());
        route.setHidden(menu.getHidden());
        Route.Meta meta = new Route.Meta();
        meta.setTitle(menu.getTitle());
        meta.setIcon(menu.getIcon());
        meta.setNoCache(menu.getCacheable());
        meta.setRequireAuth(menu.getRequireAuth());
        if (roles.size() > 0) {
            meta.setRoles(roles);
        }
        route.setMeta(meta);
        return route;
    }

    /**
     * 递归构造路由
     * @param menu
     * @param routes
     * @return
     */
    public List<Route> makeRoutes(SysMenu menu, List<Route> routes) {
        if (menu == null) return routes;
        // 创建路由
        Route route = this.createRoute(menu);
        String parentId = menu.getId();
        EntityWrapper<SysMenu> wrapper = new EntityWrapper<>(SysMenu.class);
        wrapper.eq("parent_id",parentId);
        wrapper.orderBy("sort");
        List<SysMenu> children = this.selectList(wrapper);
        if (children.size() > 0) {
            List<Route> childRoutes = new ArrayList<>();
            for (SysMenu menu1 : children) {
                this.makeRoutes(menu1,childRoutes);
            }
            route.setChildren(childRoutes);
        }
        routes.add(route);
        return routes;
    }
}
