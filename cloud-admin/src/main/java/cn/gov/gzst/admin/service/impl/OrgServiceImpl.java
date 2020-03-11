package cn.gov.gzst.admin.service.impl;

import cn.gov.gzst.admin.entity.Org;
import cn.gov.gzst.admin.entity.Org;
import cn.gov.gzst.admin.mapper.OrgMapper;
import cn.gov.gzst.common.common.service.impl.CommonServiceImpl;
import cn.gov.gzst.common.common.service.impl.TreeCommonServiceImpl;
import cn.gov.gzst.admin.service.IOrgService;
import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("orgService")
public class OrgServiceImpl extends CommonServiceImpl<OrgMapper, Org>
		implements IOrgService {

	@Override
	public List<Org> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

	@Override
	public boolean insert(Org entity) {
		this.initParents(entity);
		return super.insert(entity);
	}

	@Override
	public boolean insertOrUpdate(Org entity) {
		this.initParents(entity);
		Org temp = this.selectById(entity.getId());
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
	public void initParents(Org entity) {
		List<Org> parents = new ArrayList<>();
		parents = this.makeParents(entity, parents);
		if (parents.size() > 0) {
			StringBuilder parentIds = new StringBuilder("");
			for (Org org : parents) {
				if (!StringUtils.isEmpty(parentIds)) {
					parentIds.append("/");
				}
				parentIds.append(org.getId());
			}
			entity.setParentIds(parentIds.toString());
		} else {
			entity.setParentIds("");
		}
	}

	/**
	 * 更新子节点的parents
	 * @param org
	 */
	public void updateChildren(Org org) {
		EntityWrapper<Org> wrapper = new EntityWrapper(Org.class);
		wrapper.eq("parent_id",org.getId());
		List<Org> children = this.selectList(wrapper);
		if (children.size() == 0) {
			return;
		} else {
			String parentIds = org.getParentIds() + "/" + org.getId();
			for (Org org1 : children) {
				org1.setParentIds(parentIds);
				this.saveOrUpdate(org1);
				this.updateChildren(org1);
			}
		}
	}

	@Override
	public List<Org> formatNodes(List<Org> orgs) throws Exception {
		if (orgs == null) return null;
		EntityWrapper<Org> wrapper = null;
		Integer cnt = 0;
		for (Org org : orgs) {
			List<Org> parents = new ArrayList<>();
			parents = this.makeParents(org, parents);
			if (parents.size() == 0) {
				org.setLevel(0);
				org.setParents("");
			} else {
				org.setLevel(parents.size());
				StringBuilder parentNames = new StringBuilder("");
				StringBuilder parentIds = new StringBuilder("");
				for (Org parent : parents) {
					if (!StringUtils.isEmpty(parentNames.toString())) {
						parentNames.append("/");
					}
					if (!StringUtils.isEmpty(parentIds.toString())) {
						parentIds.append("/");
					}
					parentNames.append(parent.getName());
					parentIds.append(parent.getId());
				}
				org.setParents(parentNames.toString());
				org.setParentIds(parentIds.toString());
			}
			wrapper = new EntityWrapper<>(Org.class);
			wrapper.eq("parent_id",org.getId());
			cnt = this.selectCount(wrapper);
			org.setHasChildren(cnt > 0);
		}
		return orgs;
	}

	/**
	 * 递归生成父级
	 * @param org
	 * @param parents
	 * @return
	 */
	@Override
	public List<Org> makeParents(Org org, List<Org> parents) {
		if (org == null) {
			return parents;
		}
		if (!StringUtils.isEmpty(org.getParentId())) {
			Org parent = this.selectById(org.getParentId());
			if (parent != null) {
				parents.add(0,parent);
			}
			return this.makeParents(parent,parents);
		} else {
			return parents;
		}
	}
}
