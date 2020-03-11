package cn.gov.gzst.common.query.parse;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

import com.baomidou.mybatisplus.mapper.Wrapper;

import cn.gov.gzst.common.query.data.Condition;
import cn.gov.gzst.common.query.data.Condition.Filter;
import cn.gov.gzst.common.query.data.Condition.Operator;
import cn.gov.gzst.common.query.data.Queryable;
import cn.gov.gzst.common.utils.ObjectUtils;

public class QueryToWrapper<T>  implements Serializable{

	public void parseCondition(Wrapper<T> wrapper, Queryable queryable) {
		Condition condition = queryable.getCondition();
		if (condition != null) {
			for (Filter filter : condition) {
				Object value = filter.getValue();
				if (!ObjectUtils.isNullOrEmpty(value)) {
					// 可以使用反射快速绑定
					Operator operator = filter.getOperator();
					String property = filter.getProperty();
					if (operator == Operator.custom) {
						continue;
					} else if (operator == Operator.isNull) {
						wrapper.isNull(property);
					} else if (operator == Operator.isNotNull) {
						wrapper.isNotNull(property);
					} else if (operator == Operator.between) {
						Object[] between = null;
						if (value instanceof List) {
							between = ((List<?>) value).toArray(new Object[((List<?>) value).size()]);
						} else {
							between = (Object[]) value;
						}
						if (between.length == 2) {
							wrapper.between(property, between[0], between[1]);
						}
					} else if (operator.name().toUpperCase(Locale.US).contains("LIKE")) {
						value = parseLike(filter);
						if (operator.name().toUpperCase(Locale.US).contains("NOT")) {
							wrapper.notLike(filter.getProperty(), (String) value);

						} else {
							wrapper.like(filter.getProperty(), (String) value);
						}
					} else if (operator.name().toUpperCase(Locale.US).contains("IN")) {
						if (operator.name().toUpperCase(Locale.US).contains("NOT")) {
							wrapper.notIn(filter.getProperty(), (String) value);
						} else {
							wrapper.in(filter.getProperty(), (String) value);
						}
					}else {
						invokeWrapper(wrapper, filter);
					}
				}
			}
		}

	}

	public Object parseLike(Filter filter) {
		String operatorStr = filter.getOperator().name().toUpperCase(Locale.US);
		Object value = filter.getValue();
		if (operatorStr.contains("PREFIX")) {
			value = "%" + value;
		} else if (operatorStr.contains("SUFFIX")) {
			value = value + "%";
		} else {
			value = "%" + value + "%";
		}
		return value;
	}

	/**
	 * 
	 * 
	 * @param filter
	 * @return
	 */
	public void invokeWrapper(Wrapper<T> wrapper, Filter filter) {
		try {
			Method method = wrapper.getClass().getMethod(filter.getOperator().name(), String.class,
					Object.class);
			method.invoke(wrapper, filter.getProperty(), filter.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parseSort(Wrapper<T> wrapper, Queryable queryable) {
		cn.gov.gzst.common.query.data.Sort sort = queryable.getPageable().getSort();
		if (sort != null) {
			for (cn.gov.gzst.common.query.data.Order order : sort) {
				if (order.getDirection() == cn.gov.gzst.common.query.data.Direction.DESC) {
					wrapper.orderBy(order.getProperty(), false);
				} else if (order.getDirection() == cn.gov.gzst.common.query.data.Direction.ASC) {
					wrapper.orderBy(order.getProperty(), true);
				}
			}
		}
	}

}
