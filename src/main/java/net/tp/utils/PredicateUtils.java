package net.tp.utils;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

public class PredicateUtils {
	/**
	 * Require that the given value satisfies the given predicate.
	 * @param predicate the predicate to satisfy
	 * @param value the value to check
	 * @param <T> the type of the value
	 * @return the value if it satisfies the predicate
	 * @throws IllegalArgumentException if the value does not satisfy the predicate
	 * @since 1.7.0
	 */
	public static <T> T requireEnsured(Predicate<T> predicate, T value) {
		if (!requireNonNull(predicate).test(value)) throw new IllegalArgumentException();
		return value;
	}

	/**
	 * Require that the given value satisfies the given predicate.
	 * @param predicate the predicate to satisfy
	 * @param value the value to check
	 * @param message the message of the exception
	 * @param <T> the type of the value
	 * @return the value if it satisfies the predicate
	 * @throws IllegalArgumentException if the value does not satisfy the predicate
	 * @since 1.7.0
	 */
	public static <T> T requireEnsured(Predicate<T> predicate, T value, String message) {
		if (!requireNonNull(predicate).test(value)) throw new IllegalArgumentException(message);
		return value;
	}

	/**
	 * Require that the given value satisfies the given predicate.
	 * @param predicate the predicate to satisfy
	 * @param value the value to check
	 * @param defaultValue the default value to return if the value does not satisfy the predicate
	 * @param <T> the type of the value
	 * @return the value if it satisfies the predicate, the default value otherwise
	 * @since 1.7.0
	 */
	public static <T> T requireEnsuredElse(Predicate<T> predicate, T value, T defaultValue) {
		if (!requireNonNull(predicate).test(value)) return defaultValue;
		return value;
	}

	/**
	 * Require that the given value satisfies the given predicate.
	 * @param predicate the predicate to satisfy
	 * @param value the value to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the value if it satisfies the predicate
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the value does not satisfy the predicate
	 * @since 1.7.0
	 */
	public static <T, X extends Throwable> T requireEnsuredElseThrow(Predicate<T> predicate, T value, Supplier<X> exceptionSupplier) throws X {
		if (!requireNonNull(predicate).test(value)) throw exceptionSupplier.get();
		return value;
	}

	/**
	 * Require that the given value doesn't satisfy the given predicate.
	 * @param predicate the predicate to not-satisfy
	 * @param value the value to check
	 * @param <T> the type of the value
	 * @return the value if it doesn't satisfy the predicate
	 * @throws IllegalArgumentException if the value satisfies the predicate
	 * @since 1.7.0
	 */
	public static <T> T requireNonEnsured(Predicate<T> predicate, T value) {
		if (requireNonNull(predicate).test(value)) throw new IllegalArgumentException();
		return value;
	}

	/**
	 * Require that the given value doesn't satisfy the given predicate.
	 * @param predicate the predicate to not-satisfy
	 * @param value the value to check
	 * @param message the message of the exception
	 * @param <T> the type of the value
	 * @return the value if it doesn't satisfy the predicate
	 * @throws IllegalArgumentException if the value satisfies the predicate
	 * @since 1.7.0
	 */
	public static <T> T requireNonEnsured(Predicate<T> predicate, T value, String message) {
		if (requireNonNull(predicate).test(value)) throw new IllegalArgumentException(message);
		return value;
	}

	/**
	 * Require that the given value doesn't satisfy the given predicate.
	 * @param predicate the predicate to not-satisfy
	 * @param value the value to check
	 * @param defaultValue the default value to return if the value satisfy the predicate
	 * @param <T> the type of the value
	 * @return the value if it doesn't satisfy the predicate, the default value otherwise
	 * @since 1.7.0
	 */
	public static <T> T requireNonEnsuredElse(Predicate<T> predicate, T value, T defaultValue) {
		if (requireNonNull(predicate).test(value)) return defaultValue;
		return value;
	}

	/**
	 * Require that the given value doesn't satisfy the given predicate.
	 * @param predicate the predicate to not-satisfy
	 * @param value the value to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the value if it doesn't satisfy the predicate
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the value satisfies the predicate
	 * @since 1.7.0
	 */
	public static <T, X extends Throwable> T requireNonEnsuredElseThrow(Predicate<T> predicate, T value, Supplier<X> exceptionSupplier) throws X {
		if (!requireNonNull(predicate).test(value)) throw exceptionSupplier.get();
		return value;
	}
}