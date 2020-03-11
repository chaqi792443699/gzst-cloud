package cn.gov.gzst.common.query.data;

import java.io.Serializable;
import java.util.Locale;

/**
 * Enumeration for sort directions.
 *
 * @author Oliver Gierke
 */
public enum Direction implements Serializable {

    ASC, DESC;

    /**
     * Returns the {@link Direction} enum for the given {@link String}
     * value.
     *
     * @param value
     * @throws IllegalArgumentException
     *             in case the given value cannot be parsed into an enum
     *             value.
     * @return
     */
    public static Direction fromString(String value) {

        try {
            return Direction.valueOf(value.toUpperCase(Locale.US));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).",
                    value), e);
        }
    }

    /**
     * Returns the {@link Direction} enum for the given {@link String} or
     * null if it cannot be parsed into an enum value.
     *
     * @param value
     * @return
     */
    public static Direction fromStringOrNull(String value) {

        try {
            return fromString(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}