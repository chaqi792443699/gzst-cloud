package cn.gzst.gov.cloud.gateway.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gzst.gov.cloud.gateway.entity
 * @title: 拦截链路实体
 * @description: 拦截链路实体
 * @author: jianliaoliang
 * @date: 2018-04-27 09:37:02
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("gateway_filter_chain")
@SuppressWarnings("serial")
public class FilterChain extends AbstractEntity<String> {

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
	@TableField(value = "name")
    private String name;
    /**perms*/
    @TableField(value = "perms")
	private String perms;
    /**url*/
    @TableField(value = "path")
	private String path;

	@TableField(value = "sort")
    private Integer sort;
	
	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}