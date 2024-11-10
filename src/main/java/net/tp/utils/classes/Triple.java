package net.tp.utils.classes;

import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * A triple of three values.
 *
 * @param <L> the type of the left value
 * @param <M> the type of the middle value
 * @param <R> the type of the right value
 * @author Tommaso Pastorelli
 * @version 1.0.0 (20241110T120322Z)
 */
public class Triple<L, M, R> implements Serializable {
	/**
	 * The left value.
	 */
	private L left;
	/**
	 * The middle value.
	 */
	private M middle;
	/**
	 * The right value.
	 */
	private R right;
	/**
	 * If the triple is immutable.
	 */
	private boolean immutable = false;

	/**
	 * Creates a new triple with the given left, middle, and right values.
	 * @param left the left value
	 * @param middle the middle value
	 * @param right the right value
	 */
	private Triple(L left, M middle, R right) {
		this.left = left;
		this.middle = middle;
		this.right = right;
	}
	/**
	 * Makes the triple immutable.
	 * @return the triple
	 */
	public Triple<L, M, R> immutable() {
		this.immutable = true;
		return this;
	}
	/**
	 * Makes the triple mutable.
	 * @return the triple
	 */
	public Triple<L, M, R> mutable() {
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
	 * @return the middle value
	 */
	public M getMiddle() {
		return middle;
	}
	/**
	 * Sets the middle value.
	 * @param middle the middle value
	 */
	public void setMiddle(M middle) {
		this.middle = middle;
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
	 * @return if the triple is immutable
	 */
	public boolean isImmutable() {
		return immutable;
	}
	/**
	 * @return if the triple is equal to another object
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;
		return Objects.equals(left, triple.left) && Objects.equals(middle, triple.middle) && Objects.equals(right, triple.right);
	}
	/**
	 * @return the hash code of the triple
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(getLeft()) ^ Objects.hashCode(this.getMiddle()) ^ Objects.hashCode(getRight());
	}
	/**
	 * Creates a new triple with the given left, middle, and right values.
	 * @param left the left value
	 * @param middle the middle value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <M> the type of the middle value
	 * @param <R> the type of the right value
	 * @return the triple
	 */
	public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
		return new Triple<>(left, middle, right);
	}
	/**
	 * Creates a new triple with the given left, middle, and right values if they are not null.
	 * @param left the left value; not null
	 * @param middle the middle value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <M> the type of the middle value
	 * @param <R> the type of the right value
	 * @return the triple
	 */
	public static <L, M, R> Triple<L, M, R> ofNonNull(L left, M middle, R right) {
		return of(requireNonNull(left), requireNonNull(middle), requireNonNull(right));
	}
	/**
	 * Creates a new triple with the given left, middle, and right values and makes it immutable.
	 * @param left the left value
	 * @param middle the middle value
	 * @param right the right value
	 * @param <L> the type of the left value
	 * @param <M> the type of the middle value
	 * @param <R> the type of the right value
	 * @return the triple
	 */
	public static <L, M, R> Triple<L, M, R> immutable(L left, M middle, R right) {
		return new Triple<>(left, middle, right).immutable();
	}
	/**
	 * Creates a new triple with the given left, middle, and right values if they are not null and makes it immutable.
	 * @param left the left value; not null
	 * @param middle the middle value; not null
	 * @param right the right value; not null
	 * @param <L> the type of the left value
	 * @param <M> the type of the middle value
	 * @param <R> the type of the right value
	 * @return the triple
	 */
	public static <L, M, R> Triple<L, M, R> immutableNonNull(L left, M middle, R right) {
		return immutable(requireNonNull(left), requireNonNull(middle), requireNonNull(right));
	}
	/**
	 * @return the string representation of the triple
	 */
	@Override
	public String toString() {
		return "(" + left + ", " + middle + ", " + right + ")";
	}
	/**
	 * @return the string representation of the triple with the given format
	 */
	public String toString(String format) {
		return String.format(format, left, middle, right);
	}
}