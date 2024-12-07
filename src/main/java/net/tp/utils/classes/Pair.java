package net.tp.utils.classes;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * A pair of two values.
 *
 * @param <L> the type of the left value
 * @param <R> the type of the right value
 * @author Tommaso Pastorelli
 * @since 1.2.0
 */
@SuppressWarnings("unused")
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
	private boolean immutable;

	/**
	 * Creates a new pair with the given left and right values.
	 * @param left the left value
	 * @param right the right value
	 * @param immutable if the pair is immutable
	 * @since 1.2.0
	 */
	private Pair(L left, R right, boolean immutable) {
		this.left = left;
		this.right = right;
		this.immutable = immutable;
	}
	/**
	 * Creates a new pair with the left and right values of the given entry.
	 * @param entry the entry to get the left and right values from
	 * @since 1.2.0
	 */
	private Pair(Map.Entry<L, R> entry, boolean immutable) {
		this.left = isNull(entry) ? null : entry.getKey();
		this.right = isNull(entry) ? null : entry.getValue();
		this.immutable = immutable;
	}
	/**
	 * Makes the pair immutable.
	 * @return the pair
	 * @since 1.2.0
	 */
	public Pair<L, R> immutable() {
		this.immutable = true;
		return this;
	}
	/**
	 * Makes the pair mutable.
	 * @return the pair
	 * @since 1.2.0
	 */
	public Pair<L, R> mutable() {
		this.immutable = false;
		return this;
	}

	/**
	 * @return the left value
	 * @since 1.2.0
	 */
	public L getLeft() {
		return left;
	}
	/**
	 * Sets the left value.
	 * @param left the left value
	 * @since 1.2.0
	 */
	public void setLeft(L left) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.left = left;
	}
	/**
	 * @return the right value
	 * @since 1.2.0
	 */
	public R getRight() {
		return right;
	}
	/**
	 * Sets the right value.
	 * @param right the right value
	 * @since 1.2.0
	 */
	public void setRight(R right) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.right = right;
	}
	/**
	 * @return the left value
	 * @since 1.2.0
	 */
	@Override
	public L getKey() {
		return left;
	}
	/**
	 * @return the right value
	 * @since 1.2.0
	 */
	@Override
	public R getValue() {
		return right;
	}
	/**
	 * Sets the right value.
	 * @param value the right value
	 * @return the right value
	 * @since 1.2.0
	 */
	@Override
	public R setValue(R value) {
		if (immutable) throw new UnsupportedOperationException("Pair is immutable.");
		this.right = value;
		return value;
	}
	/**
	 * @return if the pair is immutable
	 * @since 1.2.0
	 */
	public boolean isImmutable() {
		return immutable;
	}
	/**
	 * @return if the pair is equal to another object
	 * @since 1.2.0
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
	 * @since 1.2.0
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getLeft()) ^ Objects.hashCode(getValue());
	}

	/**
	 * Creates a new pair with the given left and right values. Creates an immutable pair.
	 * @param left the left value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the immutable pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> of(L left, R right) {
		return new Pair<>(left, right, true);
	}

	/**
	 * Creates an immutable new pair with the left and right values of the given entry. Creates an immutable pair.
	 * @param entry the entry to get the left and right values from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> of(Map.Entry<L, R> entry) {
		return new Pair<>(entry, true);
	}

	/**
	 * Creates a set of immutable new pairs with the given map.
	 * @param map the map to get the pairs from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the set of pairs
	 * @since 1.8.0
	 */
	public static <L, R> Set<Pair<L, R>> of(Map<L, R> map) {
		if (isNull(map)) return null;

		Set<Pair<L, R>> set = new HashSet<>();
		for (Map.Entry<L, R> entry : map.entrySet()) {
			set.add(of(entry));
		}
		return set;
	}

	/**
	 * Creates an immutable new pair with the given left and right values if they are not null.
	 * @param left the left value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> ofNonNull(L left, R right) {
		return of(requireNonNull(left), requireNonNull(right));
	}

	/**
	 * Creates an immutable new pair with the left and right values of the given entry if they are not null.
	 * @param entry the entry to get the left and right values from; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> ofNonNull(Map.Entry<L, R> entry) {
		requireNonNull(entry);
		return of(requireNonNull(entry.getKey()), requireNonNull(entry.getValue()));
	}

	/**
	 * Creates a set of immutable new pairs with the given map if they are not null.
	 * @param map the map to get the pairs from (all elements not null); not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the set of pairs
	 * @since 1.8.0
	 */
	public static <L, R> Set<Pair<L, R>> ofNonNull(Map<L, R> map) {
		Set<Pair<L, R>> set = new HashSet<>();
		for (Map.Entry<L, R> entry : requireNonNull(map).entrySet()) {
			set.add(ofNonNull(entry));
		}
		return set;
	}

	/**
	 * Creates a mutable new pair with the given left and right values.
	 * @param left the left value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> mutable(L left, R right) {
		return new Pair<>(left, right, false);
	}

	/**
	 * Creates a mutable new pair with the left and right values of the given entry.
	 * @param entry the entry to get the left and right values from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> mutable(Map.Entry<L, R> entry) {
		return new Pair<>(entry, false);
	}

	/**
	 * Creates a set of mutable new pairs with the given map.
	 * @param map the map to get the pairs from
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the set of pairs
	 * @since 1.8.0
	 */
	public static <L, R> Set<Pair<L, R>> mutable(Map<L, R> map) {
		if (isNull(map)) return null;

		Set<Pair<L, R>> set = new HashSet<>();
		for (Map.Entry<L, R> entry : map.entrySet()) {
			set.add(mutable(entry));
		}
		return set;
	}

	/**
	 * Creates a mutable new pair with the given left and right values if they are not null and makes it immutable.
	 * @param left the left value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> mutableNonNull(L left, R right) {
		return mutable(requireNonNull(left), requireNonNull(right));
	}

	/**
	 * Creates a mutable pair with the left and right values of the given entry if they are not null and makes it immutable.
	 * @param entry the entry to get the left and right values from; not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the pair
	 * @since 1.2.0
	 */
	public static <L, R> Pair<L, R> mutableNonNull(Map.Entry<L, R> entry) {
		requireNonNull(entry);
		return mutable(requireNonNull(entry.getKey()), requireNonNull(entry.getValue()));
	}

	/**
	 * Creates a set of mutable new pairs with the given map if they are not null.
	 * @param map the map to get the pairs from (all elements not null); not null
	 * @param <L> the type of the left value
	 * @param <R> the type of the right value
	 * @return the set of pairs
	 * @since 1.8.0
	 */
	public static <L, R> Set<Pair<L, R>> mutableNonNull(Map<L, R> map) {
		Set<Pair<L, R>> set = new HashSet<>();
		for (Map.Entry<L, R> entry : requireNonNull(map).entrySet()) {
			set.add(mutableNonNull(entry));
		}
		return set;
	}

	/**
	 * @return the string representation of the pair
	 */
	@Override
	public String toString() {
		return "(" + left + ", " + right + ")";
	}

	/**
	 * @param format the format to use
	 * @return the string representation of the pair with the given format
	 */
	public String toString(String format) {
		return String.format(format, left, right);
	}
}