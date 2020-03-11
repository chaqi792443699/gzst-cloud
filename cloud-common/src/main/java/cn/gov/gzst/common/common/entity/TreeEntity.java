package cn.gov.gzst.common.common.entity;

import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import cn.gov.gzst.common.common.entity.tree.TreeNode;
import cn.gov.gzst.common.utils.StringUtils;

/**
 * 树抽象实体基类
 * 
 * @author jianliaoliang
 *
 * 
 */
public abstract class TreeEntity<T> extends AbstractEntity<String> implements TreeNode<String> {

	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.UUID)
	private String id; // 编号
	@TableField(value = "name")
	private String name; // 资源名称
	@TableField(value = "parent_id", strategy = FieldStrategy.IGNORED)
	private String parentId; // 父编号
	@TableField(value = "parent_ids", strategy = FieldStrategy.IGNORED)
	private String parentIds; // 父编号列表

	@TableField(exist = false)
	private Boolean expanded = Boolean.FALSE;

	@TableField(exist = false)
	private Boolean loaded = Boolean.TRUE;

	@TableField(exist = false)
	private T parent;

	@TableField(exist = false)
	private Integer level;

	@TableField(exist = false)
	private List<T> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 是否有叶子节点
	 */
	@TableField(exist = false)
	private boolean hasChildren;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	@Override
	public boolean isRoot() {
		if (getParentId() == null || getParentId().equals("0") || getParentId().equals("")) {
			return true;
		}
		return false;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public Integer getLevel() {
		if (StringUtils.isEmpty(parentIds)) {
			this.level = 0;
		} else {
			String[] parentIdArr = parentIds.split("/");
			this.level = (parentIdArr.length);
		}
		return this.level;
	}

	@Override
	public Boolean isLeaf() {
		if (isHasChildren()) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public List<T> getChildren() {
		return children;
	}

	public void setChildren(List<T> children) {
		this.children = children;
	}

	@Override
	public String makeSelfAsNewParentIds() {
		if (StringUtils.isEmpty(getParentIds())) {
			return getId() + getSeparator();
		}
		return getParentIds() + getId() + getSeparator();
	}

	@Override
	public String getSeparator() {
		return "/";
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	@Override
	public Boolean getExpanded() {
		return expanded;
	}

	@Override
	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}

	public Boolean getLoaded() {
		return loaded;
	}

	public T getParent() {
		return parent;
	}

	public void setParent(T parent) {
		this.parent = parent;
	}

	public String[] makeTags() {
		return new String[0];
	}
}
