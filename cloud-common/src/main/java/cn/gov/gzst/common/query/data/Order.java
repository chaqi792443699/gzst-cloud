package cn.gov.gzst.common.query.data;

import cn.gov.gzst.common.query.data.Sort;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * PropertyPath implements the pairing of an {@link Direction} and a
 * property. It is used to provide input for {@link Sort}
 *
 * @author Oliver Gierke
 * @author Kevin Raymond
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1522511010900108987L;
    public static final Direction DEFAULT_DIRECTION = Direction.ASC;
    private static final boolean DEFAULT_IGNORE_CASE = false;
    private  Direction direction;
    private  String property;
    private  boolean ignoreCase;
    public Order(){

    }
    public Order(Direction direction, String property) {
        this(direction, property, DEFAULT_IGNORE_CASE);
    }


    public Order(String property) {
        this(DEFAULT_DIRECTION, property);
    }

    private Order(Direction direction, String property, boolean ignoreCase) {

        if (!StringUtils.hasText(property)) {
            throw new IllegalArgumentException("Property must not null or empty!");
        }
        this.direction = direction == null ? DEFAULT_DIRECTION : direction;
        this.property = property;
        this.ignoreCase = ignoreCase;
    }

    /**
     * @deprecated use {@link Sort#Sort(Direction, List)} instead.
     */
    @Deprecated
    public static List<Order> create(Direction direction, Iterable<String> properties) {

        List<Order> orders = new ArrayList<Order>();
        for (String property : properties) {
            orders.add(new Order(direction, property));
        }
        return orders;
    }

    /**
     * Returns the order the property shall be sorted for.
     *
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the property to order for.
     *
     * @return
     */
    public String getProperty() {
        return property;
    }

    /**
     * Returns whether sorting for this property shall be ascending.
     *
     * @return
     */
    public boolean isAscending() {
        return this.direction.equals(Direction.ASC);
    }

    /**
     * Returns whether or not the sort will be case sensitive.
     *
     * @return
     */
    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    /**
     * Returns a new {@link Order} with the given {@link Order}.
     *
     * @param order
     * @return
     */
    public Order with(Direction order) {
        return new Order(order, this.property);
    }

    /**
     * Returns a new {@link Sort} instance for the given properties.
     *
     * @param properties
     * @return
     */
    public Sort withProperties(String... properties) {
        return new Sort(this.direction, properties);
    }

    /**
     * Returns a new {@link Order} with case insensitive sorting enabled.
     *
     * @return
     */
    public Order ignoreCase() {
        return new Order(direction, property, true);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + direction.hashCode();
        result = 31 * result + property.hashCode();

        return result;
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

        if (!(obj instanceof Order)) {
            return false;
        }

        Order that = (Order) obj;

        return this.direction.equals(that.direction) && this.property.equals(that.property);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s: %s", property, direction);
    }
}