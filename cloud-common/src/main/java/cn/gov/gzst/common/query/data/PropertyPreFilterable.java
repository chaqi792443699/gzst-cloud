package cn.gov.gzst.common.query.data;

import com.alibaba.fastjson.serializer.SerializeFilter;

/**
 * 
 * All rights Reserved, Designed By www.gzst.gov.cn
 * 
 * @title: PropertyPreFilterable.java
 * @package cn.gov.gzst.common.query.data
 * @description: JSON格式化输出
 * @author: jianliaoliang
 * @date: 2017年5月1日 下午9:43:09
 * @version V1.0
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 *
 */
public interface PropertyPreFilterable {
	
	public SerializeFilter constructFilter(Class<?> clazz);
	
	public void addQueryProperty(String... properties);
	
	public void addIncludeFilter(Class<?> clazz, String... properties);

	public void addExcludeFilter(Class<?> clazz, String... properties);
}
