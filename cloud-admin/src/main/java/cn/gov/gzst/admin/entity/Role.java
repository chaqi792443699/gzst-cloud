package cn.gov.gzst.admin.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * @Title: 角色实体
 * @Description: 角色实体
 * @date 2016-12-03 21:33:15
 * @version V1.0
 *
 */
@TableName("sec_role")
@SuppressWarnings("serial")
public class Role extends BaseEntity {
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	@TableField(value = "name")
	private String name;// 角色名称
	@TableField(value = "code")
	private String code;// 角色编码
	@TableField(value = "type")
	private Integer type;// 是否系统数据
	@TableField(value = "scene_id")
	private String sceneId;
	@TableField(value = "remarks")
	private String remarks;// 说明
	@TableField(value = "enabled")
	private Boolean enabled;//状态
	@TableField(value = "sort")
	private Integer sort;//排序

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSceneId() {
		return sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
