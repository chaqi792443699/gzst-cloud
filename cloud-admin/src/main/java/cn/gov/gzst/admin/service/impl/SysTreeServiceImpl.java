package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.SysTree;
import cn.gov.gzst.admin.entity.SysTreeGroup;
import cn.gov.gzst.admin.mapper.SysTreeMapper;
import cn.gov.gzst.admin.service.ISysTreeGroupService;
import cn.gov.gzst.admin.service.ISysTreeService;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianliaoliang
 * @since 2019-06-06
 */
@Transactional
@Service("SysTreeService")
public class SysTreeServiceImpl extends CommonServiceImpl<SysTreeMapper, SysTree> implements ISysTreeService {

    @Autowired
    private ISysTreeGroupService sysTreeGroupService;

    @Override
    public boolean insert(SysTree entity) {
        this.initParents(entity);
        return super.insert(entity);
    }

    @Override
    public boolean insertOrUpdate(SysTree entity) {
        this.initParents(entity);
        SysTree temp = this.selectById(entity.getId());
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
    public void initParents(SysTree entity) {
        List<SysTree> parents = new ArrayList<>();
        parents = this.makeParents(entity, parents);
        if (parents.size() > 0) {
            StringBuilder parentIds = new StringBuilder("");
            for (SysTree tree : parents) {
                if (!StringUtils.isEmpty(parentIds)) {
                    parentIds.append("/");
                }
                parentIds.append(tree.getId());
            }
            entity.setParentIds(parentIds.toString());
        } else {
            entity.setParentIds("");
        }
    }

    /**
     * 更新子节点的parents
     * @param tree
     */
    public void updateChildren(SysTree tree) {
        EntityWrapper<SysTree> wrapper = new EntityWrapper(SysTree.class);
        wrapper.eq("parent_id",tree.getId());
        List<SysTree> children = this.selectList(wrapper);
        if (children.size() == 0) {
            return;
        } else {
            String parentIds = tree.getParentIds() + "/" + tree.getId();
            for (SysTree tree1 : children) {
                tree1.setParentIds(parentIds);
                this.saveOrUpdate(tree1);
                this.updateChildren(tree1);
            }
        }
    }

    @Override
    public List<SysTree> formatTreeNodes(List<SysTree> trees) throws Exception {
        if (trees == null) return null;
        EntityWrapper<SysTree> wrapper = null;
        Integer cnt = 0;
        for (SysTree tree : trees) {
            List<SysTree> parents = new ArrayList<>();
            parents = this.makeParents(tree, parents);
            if (parents.size() == 0) {
                tree.setLevel(0);
                tree.setParents("");
            } else {
                tree.setLevel(parents.size());
                StringBuilder parentNames = new StringBuilder("");
                StringBuilder parentIds = new StringBuilder("");
                for (SysTree parent : parents) {
                    if (!StringUtils.isEmpty(parentNames.toString())) {
                        parentNames.append("/");
                    }
                    if (!StringUtils.isEmpty(parentIds.toString())) {
                        parentIds.append("/");
                    }
                    parentNames.append(parent.getName());
                    parentIds.append(parent.getId());
                }
                tree.setParents(parentNames.toString());
                tree.setParentIds(parentIds.toString());
            }
            wrapper = new EntityWrapper<>(SysTree.class);
            wrapper.eq("parent_id",tree.getId());
            cnt = this.selectCount(wrapper);
            tree.setHasChildren(cnt > 0);
        }
        return trees;
    }

    /**
     * 递归生成父级
     * @param tree
     * @param parents
     * @return
     */
    @Override
    public List<SysTree> makeParents(SysTree tree, List<SysTree> parents) {
        if (tree == null) {
            return parents;
        }
        if (!StringUtils.isEmpty(tree.getParentId())) {
            SysTree parent = this.selectById(tree.getParentId());
            if (parent != null) {
                parents.add(0,parent);
            }
            return this.makeParents(parent,parents);
        } else {
            return parents;
        }
    }

    @Override
    public String getValue(SysTree tree) {
        if (tree == null) return "";
        List<SysTree> list = new ArrayList<>();
        list = this.makeParents(tree,list);
        StringBuilder parentNames = new StringBuilder("");
        for (SysTree parent : list) {
            if (!StringUtils.isEmpty(parentNames.toString())) {
                parentNames.append("/");
            }
            parentNames.append(parent.getName());
        }
        parentNames.append("/").append(tree.getName());
        return parentNames.toString();
    }

    @Override
    public String getValues(String groupCode, String[] codes) {
        StringBuilder values = new StringBuilder("");
        EntityWrapper<SysTree> entityWrapper = new EntityWrapper<>(SysTree.class);
        if (codes != null && codes.length > 0) {
            int i = codes.length;
            entityWrapper.andNew();
            for (String code : codes) {
                i --;
                entityWrapper.eq("code",code);
                if (i > 0) {
                    entityWrapper.or();
                }
            }
        }
        String gid = "";
        // groupCode为主找到组id
        if (!StringUtils.isEmpty(groupCode)) {
            EntityWrapper<SysTreeGroup> wrapper = new EntityWrapper<>(SysTreeGroup.class);
            wrapper.eq("code",groupCode);
            SysTreeGroup treeGroup = this.sysTreeGroupService.selectOne(wrapper);
            if (treeGroup != null) {
                gid = treeGroup.getId();
            }
        }
        entityWrapper.andNew().eq("gid", gid);
        List<SysTree> trees = this.selectList(entityWrapper);
        for (SysTree tree : trees) {
            if (!StringUtils.isEmpty(values.toString())) {
                values.append(",");
            }
            values.append(tree.getName());
        }
        return values.toString();
    }

    @Override
    public List<SysTree> findTrees(String groupCode) {
        List<SysTree> list = new ArrayList<>();
        if (StringUtils.isEmpty(groupCode)) {
            return list;
        }
        EntityWrapper<SysTreeGroup> wrapper = new EntityWrapper<>(SysTreeGroup.class);
        wrapper.eq("code",groupCode);
        SysTreeGroup group = this.sysTreeGroupService.selectOne(wrapper);
        if (group == null) return list;
        EntityWrapper<SysTree> wrapper1 = new EntityWrapper<>(SysTree.class);
        wrapper1.eq("1","1");
        wrapper1.andNew().eq("parent_id","").or().isNull("parent_id");
        wrapper1.andNew().eq("gid",group.getId());
        wrapper1.orderBy("sort");
        List<SysTree> trees = this.selectList(wrapper1);
        for (SysTree tree : trees) {
            List<SysTree> treeList = new ArrayList<>();
            this.makeTrees(tree,treeList);
            if (treeList.size() > 0) {
                list.addAll(treeList);
            }
        }
        return list;
    }


    /**
     * 构造树数据
     * @param tree
     * @param trees
     * @return
     */
    public List<SysTree> makeTrees(SysTree tree, List<SysTree> trees) {
        if (tree == null) return trees;
        // 创建路由
        String parentId = tree.getId();
        EntityWrapper<SysTree> wrapper = new EntityWrapper<>(SysTree.class);
        wrapper.eq("parent_id",parentId);
        wrapper.orderBy("sort");
        List<SysTree> children = this.selectList(wrapper);
        if (children.size() > 0) {
            List<SysTree> childTrees = new ArrayList<>();
            for (SysTree tree1 : children) {
                this.makeTrees(tree1,childTrees);
            }
            tree.setHasChildren(true);
            tree.setChildren(childTrees);
        } else {
            tree.setHasChildren(false);
        }
        if (!StringUtils.isEmpty(tree.getParentIds())) {
            String[] pids = tree.getParentIds().split("/");
            tree.setLevel(pids.length);
        } else {
            tree.setLevel(0);
        }
        trees.add(tree);
        return trees;
    }
}
