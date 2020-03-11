package cn.gov.gzst.cms.service.impl;

import cn.gov.gzst.cms.entity.Category;
import cn.gov.gzst.cms.mapper.CategoryMapper;
import cn.gov.gzst.cms.service.ICategoryService;
import cn.gov.gzst.common.common.service.impl.TreeCommonServiceImpl;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;


/**
* All rights Reserved, Designed By www.gzst.gov.cn
*
* @version V1.0
* @package cn.gov.gzst.cms.service.impl
* @title: 栏目管理服务实现
* @description: 栏目管理服务实现
* @author: jianliaoliang
* @date: 2018-05-02 09:35:40
* @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
*/
@Transactional
@Service("categoryService")
public class CategoryServiceImpl extends TreeCommonServiceImpl<CategoryMapper,Category,String> implements  ICategoryService {

    @Override
    public boolean insert(Category entity) {
        this.initParents(entity);
        return super.insert(entity);
    }

    @Override
    public boolean insertOrUpdate(Category entity) {
        this.initParents(entity);
        Category temp = this.selectById(entity.getId());
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
    public void initParents(Category entity) {
        List<Category> parents = new ArrayList<>();
        parents = this.makeParents(entity, parents);
        if (parents.size() > 0) {
            StringBuilder parentIds = new StringBuilder("");
            for (Category category : parents) {
                if (!StringUtils.isEmpty(parentIds)) {
                    parentIds.append("/");
                }
                parentIds.append(category.getId());
            }
            entity.setParentIds(parentIds.toString());
        } else {
            entity.setParentIds("");
        }
    }

    /**
     * 更新子节点的parents
     * @param category
     */
    public void updateChildren(Category category) {
        EntityWrapper<Category> wrapper = new EntityWrapper(Category.class);
        wrapper.eq("parent_id",category.getId());
        List<Category> children = this.selectList(wrapper);
        if (children.size() == 0) {
            return;
        } else {
            String parentIds = category.getParentIds() + "/" + category.getId();
            for (Category category1 : children) {
                category1.setParentIds(parentIds);
                this.saveOrUpdate(category1);
                this.updateChildren(category1);
            }
        }
    }

    @Override
    public List<Category> formatNodes(List<Category> categories) throws Exception {
        if (categories == null) return null;
        EntityWrapper<Category> wrapper = null;
        Integer cnt = 0;
        for (Category category : categories) {
            List<Category> parents = new ArrayList<>();
            parents = this.makeParents(category, parents);
            if (!StringUtils.isEmpty(category.getContent())) {
                category.setContent(HtmlUtils.htmlUnescape(category.getContent()));
            }
            if (parents.size() == 0) {
                category.setLevel(0);
                category.setParents("");
            } else {
                category.setLevel(parents.size());
                StringBuilder parentNames = new StringBuilder("");
                StringBuilder parentIds = new StringBuilder("");
                for (Category parent : parents) {
                    if (!StringUtils.isEmpty(parentNames.toString())) {
                        parentNames.append("/");
                    }
                    if (!StringUtils.isEmpty(parentIds.toString())) {
                        parentIds.append("/");
                    }
                    parentNames.append(parent.getName());
                    parentIds.append(parent.getId());
                }
                category.setParents(parentNames.toString());
                category.setParentIds(parentIds.toString());
            }
            wrapper = new EntityWrapper<>(Category.class);
            wrapper.eq("parent_id",category.getId());
            cnt = this.selectCount(wrapper);
            category.setHasChildren(cnt > 0);
        }
        return categories;
    }

    /**
     * 递归生成父级
     * @param category
     * @param parents
     * @return
     */
    @Override
    public List<Category> makeParents(Category category, List<Category> parents) {
        if (category == null) {
            return parents;
        }
        if (!StringUtils.isEmpty(category.getParentId())) {
            Category parent = this.selectById(category.getParentId());
            if (parent != null) {
                parents.add(0,parent);
            }
            return this.makeParents(parent,parents);
        } else {
            return parents;
        }
    }
}