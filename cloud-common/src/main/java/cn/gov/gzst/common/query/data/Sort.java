package cn.gov.gzst.common.query.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.util.StringUtils;

public class Sort implements Iterable<cn.gov.gzst.common.query.data.Order>, Serializable {

	private static final long serialVersionUID = 5737186511678863905L;
	public static final Direction DEFAULT_DIRECTION = Direction.ASC;
	private List<Order> orders;

	public Sort(){
		//构造函数
	}

	/**
	 * Creates a new {@link Sort} instance using the given {@link Order}s.
	 * 
	 * @param orders
	 *            must not be {@literal null}.
	 */
	public Sort(Order... orders) {
		this(Arrays.asList(orders));
	}

	/**
	 * Creates a new {@link Sort} instance.
	 * 
	 * @param orders
	 *            must not be {@literal null} or contain {@literal null}.
	 */
	public Sort(List<Order> orders) {

		if (null == orders || orders.isEmpty()) {
			throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
		}

		this.orders = orders;
	}

	/**
	 * Creates a new {@link Sort} instance. Order defaults to
	 * {@value Direction#ASC}.
	 * 
	 * @param properties
	 *            must not be {@literal null} or contain {@literal null} or
	 *            empty strings
	 */
	public Sort(String... properties) {
		this(DEFAULT_DIRECTION, properties);
	}

	/**
	 * Creates a new {@link Sort} instance.
	 * 
	 * @param direction
	 *            defaults to {@linke Sort#DEFAULT_DIRECTION} (for
	 *            {@literal null} cases, too)
	 * @param properties
	 *            must not be {@literal null} or contain {@literal null} or
	 *            empty strings
	 */
	public Sort(Direction direction, String... properties) {
		this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
	}

	/**
	 * Creates a new {@link Sort} instance.
	 * 
	 * @param direction
	 * @param properties
	 */
	public Sort(Direction direction, List<String> properties) {

		if (properties == null || properties.isEmpty()) {
			throw new IllegalArgumentException("You have to provide at least one property to sort by!");
		}

		this.orders = new ArrayList<Order>(properties.size());

		for (String property : properties) {
			this.orders.add(new Order(direction, property));
		}
	}

	/**
	 * Returns a new {@link Sort} consisting of the {@link Order}s of the
	 * current {@link Sort} combined with the given ones.
	 * 
	 * @param sort
	 *            can be {@literal null}.
	 * @return
	 */
	public Sort and(Sort sort) {

		if (sort == null) {
			return this;
		}

		ArrayList<Order> these = new ArrayList<Order>(this.orders);

		for (Order order : sort) {
			these.add(order);
		}

		return new Sort(these);
	}

	/**
	 * Returns the order registered for the given property.
	 * 
	 * @param property
	 * @return
	 */
	public Order getOrderFor(String property) {

		for (Order order : this) {
			if (order.getProperty().equals(property)) {
				return order;
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Order> iterator() {
		return this.orders.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Sort)) {
			return false;
		}

		Sort that = (Sort) obj;

		return this.orders.equals(that.orders);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		int result = 17;
		result = 31 * result + orders.hashCode();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return StringUtils.collectionToCommaDelimitedString(orders);
	}

}
