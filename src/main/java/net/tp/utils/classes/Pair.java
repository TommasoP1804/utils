package net.tp.utils.classes;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * A pair of two values.
 *
 * @param <L> the type of the left value
 * @param <R> the type of the right value
 * @author Tommaso Pastorelli
 * @version 1.0.0 (20241110T115656Z)
 */
public class Pair<L, R> implements Map.Entry<L, R>, Serializable {
	/**
	 * The left value (key).
	 */
	private L left;
	/**
	 * The right value (value).
	 */
	private R right;
	/**
	 * If the pair is immutable.
	 */
	private boolean immutable = false;

	/**
	 * Creates a new pair with the given left and right values.
	 * @param left the left value
	 * @param right the right value
	 */
	private Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}
	/**
	 * Creates a new pair with the left and right values of the given entry.
	 * @param entry the entry to get the left and right values from
	 */
	private Pair(Map.Entry<L, R> entry) {
		this.left = isNull(entry) ? null : entry.getKey();
		this.right = isNull(entry) ? null : entry.getValue();
	}
	/**
	 * Makes the pair immutable.
	 * @return the pair
	 */
	public Pair<L, R> immutable() {
		this.immutable = true;
		return this;
	}
	/**
	 * Makes the pair mutable.
	 * @return the pair
	 */
	public Pair<L, R> mutable() {
		this.immutable = false;
		return this;
	}

	/**
	 * @return the left value
	 */
	public L getLeft() {
		return left;
	}
	/**
	 * Sets the left value.
	 * @param left the left value
	 */
	public void setLeft(L left) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.left = left;
	}
	/**
	 * @return the right value
	 */
	public R getRight() {
		return right;
	}
	/**
	 * Sets the right value.
	 * @param right the right value
	 */
	public void setRight(R right) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.right = right;
	}
	/**
	 * @return the left value
	 */
	@Override
	public L getKey() {
		return left;
	}
	/**
	 * @return the right value
	 */
	@Override
	public R getValue() {
		return right;
	}
	/**
	 * Sets the right value.
	 * @param value the right value
	 * @return the right value
	 */
	@Override
	public R setValue(R value) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.right = value;
		return value;
	}
	/**
	 * @return if the pair is immutable
	 */
	public boolean isImmutable() {
		return immutable;
	}
	/**
	 * @return if the pair is equal to another object
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair<?, ?> pair = (Pair<?, ?>) o;
		return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
	}
	/**
	 * @return the hash code of the pair
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getLeft()) ^ Objects.hashCode(getValue());
	}
	/**
	 * Creates a new pair with the given left and right values.
	 * @param left the left value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> of(L left, R right) {
		return new Pair<>(left, right);
	}
	/**
	 * Creates a new pair with the left and right values of the given entry.
	 * @param entry the entry to get the left and right values from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> of(Map.Entry<L, R> entry) {
		return new Pair<>(entry);
	}
	/**
	 * Creates a new pair with the given left and right values if they are not null.
	 * @param left the left value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> ofNonNull(L left, R right) {
		return of(requireNonNull(left), requireNonNull(right));
	}
	/**
	 * Creates a new pair with the left and right values of the given entry if they are not null.
	 * @param entry the entry to get the left and right values from; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> ofNonNull(Map.Entry<L, R> entry) {
		requireNonNull(entry);
		return of(requireNonNull(entry.getKey()), requireNonNull(entry.getValue()));
	}
	/**
	 * Creates a new pair with the given left and right values and makes it immutable.
	 * @param left the left value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> immutable(L left, R right) {
		return new Pair<>(left, right).immutable();
	}
	/**
	 * Creates a new pair with the left and right values of the given entry and makes it immutable.
	 * @param entry the entry to get the left and right values from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> immutable(Map.Entry<L, R> entry) {
		return new Pair<>(entry).immutable();
	}
	/**
	 * Creates a new pair with the given left and right values if they are not null and makes it immutable.
	 * @param left the left value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> immutableNonNull(L left, R right) {
		return immutable(requireNonNull(left), requireNonNull(right));
	}
	/**
	 * Creates a new pair with the left and right values of the given entry if they are not null and makes it immutable.
	 * @param entry the entry to get the left and right values from; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 */
	public static <L, R> Pair<L, R> immutableNonNull(Map.Entry<L, R> entry) {
		requireNonNull(entry);
		return immutable(requireNonNull(entry.getKey()), requireNonNull(entry.getValue()));
	}
	/**
	 * @return the string representation of the pair
	 */
	@Override
	public String toString() {
		return "(" + left + ", " + right + ")";
	}
	/**
	 * @return the string representation of the pair with the given format
	 */
	public String toString(String format) {
		return String.format(format, left, right);
	}
}