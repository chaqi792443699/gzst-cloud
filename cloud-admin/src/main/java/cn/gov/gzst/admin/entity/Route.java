package cn.gov.gzst.admin.entity;

import cn.gov.gzst.admin.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.List;

/**
 * @Title: 路由实体-前端路由构造 *
 */
public class Route {

	public Route() {
		super();
	}

	private String name;
	private String path;
	private String component;
	private boolean hidden;
	private String redirect;
	private List<Route> children;
	private Meta meta;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public List<Route> getChildren() {
		return children;
	}

	public void setChildren(List<Route> children) {
		this.children = children;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public static class Meta {
		String title;
		String icon;
		boolean noCache;
		boolean requireAuth;
		List<String> roles;

		public Meta() {
			super();
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public boolean isNoCache() {
			return noCache;
		}

		public void setNoCache(boolean noCache) {
			this.noCache = noCache;
		}

		public boolean isRequireAuth() {
			return requireAuth;
		}

		public void setRequireAuth(boolean requireAuth) {
			this.requireAuth = requireAuth;
		}

		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
	}
}
