package cn.gov.gzst.cms.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.cms.entity
 * @title: 模型管理实体
 * @description: 模型管理实体
 * @author: jianliaoliang
 * @date: 2018-05-02 09:35:51
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("cms_model")
@SuppressWarnings("serial")
public class Model extends AbstractEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**模型名称*/
    @TableField(value = "name")
	private String name;
    /**模型表名*/
    @TableField(value = "table_name")
	private String tableName;

	/**模型栏目页**/
	@TableField(value = "index_tpl")
	private String indexTpl;

	/**模型列表页面**/
	@TableField(value = "list_tpl")
	private String listTpl;

	/**模型列详情面**/
	@TableField(value = "show_tpl")
	private String showTpl;


	/**是否由系统定义 (1为系统定义，0为自定义)*/
    @TableField(value = "issys")
	private String issys;
	
	/**
	 * 获取  id
	 *@return String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  模型名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  模型名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  tableName
	 *@return String  模型表名
	 */
	public String getTableName(){
		return this.tableName;
	}

	/**
	 * 设置  tableName
	 *@param tableName  模型表名
	 */
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	/**
	 * 获取  issys
	 *@return String  是否由系统定义 (1为系统定义，0为自定义)
	 */
	public String getIssys(){
		return this.issys;
	}

	public void setIssys(String issys) {
		this.issys = issys;
	}

	public String getIndexTpl() {
		return indexTpl;
	}

	public void setIndexTpl(String indexTpl) {
		this.indexTpl = indexTpl;
	}

	public String getListTpl() {
		return listTpl;
	}

	public void setListTpl(String listTpl) {
		this.listTpl = listTpl;
	}

	public String getShowTpl() {
		return showTpl;
	}

	public void setShowTpl(String showTpl) {
		this.showTpl = showTpl;
	}
}