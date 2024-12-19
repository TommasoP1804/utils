package net.tp.utils;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * Utility class for predicate.
 * @author Tommaso Pastorelli
 * @since 1.7.0
 */
@SuppressWarnings("unused")
public abstract class PredicateUtils {
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

	/**
	 * Return the result if the value satisfies the predicate, null otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param result the result to return if the value satisfies the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value satisfies the predicate, null otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsured(Predicate<T1> predicate, T1 value, T2 result) {
		return requireNonNull(predicate).test(value) ? result : null;
	}

	/**
	 * Return the result of the supplier if the value satisfies the predicate, null otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value satisfies the predicate, null otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredGet(Predicate<T1> predicate, T1 value, Supplier<T2> supplier) {
		return requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Execute the action if the value satisfies the predicate.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param action the action to execute if the value satisfies the predicate; not null
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> void ifEnsured(Predicate<T> predicate, T value, Runnable action) {
		if (requireNonNull(predicate).test(value)) requireNonNull(action).run();
	}

	/**
	 * Return the result if the value satisfies the predicate, elseResult otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param result the result to return if the value satisfies the predicate
	 * @param elseResult the result to return if the value does not satisfy the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value satisfies the predicate, elseResult otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredElse(Predicate<T1> predicate, T1 value, T2 result, T2 elseResult) {
		return requireNonNull(predicate).test(value) ? result : elseResult;
	}

	/**
	 * Return the result if the value satisfies the predicate, the result of the elseSupplier otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param result the result to return if the value satisfies the predicate
	 * @param elseSupplier the supplier of the result if the value does not satisfy the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value satisfies the predicate, the result of the elseSupplier otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredElseGet(Predicate<T1> predicate, T1 value, T2 result, Supplier<T2> elseSupplier) {
		return requireNonNull(predicate).test(value) ? result : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the result of the supplier if the value satisfies the predicate, elseResult otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseResult the result to return if the value does not satisfy the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value satisfies the predicate, elseResult otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredGetElse(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, T2 elseResult) {
		return requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the result if the value satisfies the predicate, execute the elseAction otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param result the result to return if the value satisfies the predicate
	 * @param elseAction the action to execute if the value does not satisfy the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value satisfies the predicate, execute the elseAction otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredElse(Predicate<T1> predicate, T1 value, T2 result, Runnable elseAction) {
		if (requireNonNull(predicate).test(value)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the action if the value satisfies the predicate, else return the elseResult otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param action the action to execute if the value satisfies the predicate; not null
	 * @param elseResult the result to return if the value does not satisfy the predicate
	 * @param <T> the type of the value
	 * @param <T2> the type of the result
	 * @return the elseResult if the value does not satisfy the predicate, execute the action otherwise
	 * @since 1.10.0
	 */
	public static <T, T2> T2 ifEnsuredElse(Predicate<T> predicate, T value, Runnable action, T2 elseResult) {
		if (requireNonNull(predicate).test(value)) {
			requireNonNull(action).run();
			return null;
		}
		return elseResult;
	}

	/**
	 * Return the result of the supplier if the value satisfies the predicate, the result of the elseSupplier otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseSupplier the supplier of the result if the value does not satisfy the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value satisfies the predicate, the result of the elseSupplier otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredGetElseGet(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Supplier<T2> elseSupplier) {
		return requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Execute the action if the value satisfies the predicate, the elseAction otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param action the action to execute if the value satisfies the predicate; not null
	 * @param elseAction the action to execute if the value does not satisfy the predicate; not null
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> void ifEnsured(Predicate<T> predicate, T value, Runnable action, Runnable elseAction) {
		if (requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Return the result of the supplier if the value satisfies the predicate, execute the elseAction otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseAction the action to execute if the value does not satisfy the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value satisfies the predicate, execute the elseAction otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredGetElse(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Runnable elseAction) {
		if (requireNonNull(predicate).test(value)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the action if the value satisfies the predicate, else return the result of the elseSupplier.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param action the action to execute if the value satisfies the predicate
	 * @param elseSupplier the supplier of the result if the value does not satisfy the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the elseSupplier if the value does not satisfy the predicate, execute the action otherwise
	 * @since 1.10.0
	 */
	public static <T1, T2> T2 ifEnsuredElseGet(Predicate<T1> predicate, T1 value, Runnable action, Supplier<T2> elseSupplier) {
		if (requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Return the result if the value satisfies the predicate, null otherwise.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param result the result to return if the value satisfies the predicate
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @param <X> the type of the exception
	 * @return the result if the value satisfies the predicate, null otherwise
	 * @throws X if the value does not satisfy the predicate
	 * @since 1.10.0
	 */
	public static <T1, T2, X extends Throwable> T2 ifEnsuredElseThrow(Predicate<T1> predicate, T1 value, T2 result, Supplier<X> exceptionSupplier) throws X {
		if (requireNonNull(predicate).test(value)) return result;
		else throw exceptionSupplier.get();
	}

	/**
	 * Return the result of the supplier if the value satisfies the predicate, else throw an exception.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @param <X> the type of the exception
	 * @return the result of the supplier if the value satisfies the predicate, null otherwise
	 * @throws X if the value does not satisfy the predicate
	 * @since 1.10.0
	 */
	public static <T1, T2, X extends Throwable> T2 ifEnsuredGetElseThrow(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Supplier<X> exceptionSupplier) throws X {
		if (requireNonNull(predicate).test(value)) return requireNonNull(supplier).get();
		else throw exceptionSupplier.get();
	}

	/**
	 * Execute the action if the value satisfies the predicate, else throw an exception.
	 * @param predicate the predicate to satisfy; not null
	 * @param value the value to check
	 * @param action the action to execute if the value satisfies the predicate; not null
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the value does not satisfy the predicate
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> void ifEnsuredElseThrow(Predicate<T> predicate, T value, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else throw exceptionSupplier.get();
	}

	/**
	 * Return the result if the value does not satisfy the predicate, null otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param result the result to return if the value does not satisfy the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value does not satisfy the predicate, null otherwise
	 */
	public static <T1, T2> T2 ifNonEnsured(Predicate<T1> predicate, T1 value, T2 result) {
		return !requireNonNull(predicate).test(value) ? result : null;
	}

	/**
	 * Return the result of the supplier if the value does not satisfy the predicate, null otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value does not satisfy the predicate, null otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredGet(Predicate<T1> predicate, T1 value, Supplier<T2> supplier) {
		return !requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Execute the action if the value does not satisfy the predicate.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param action the action to execute if the value does not satisfy the predicate; not null
	 * @param <T> the type of the value
	 */
	public static <T> void ifNonEnsured(Predicate<T> predicate, T value, Runnable action) {
		if (!requireNonNull(predicate).test(value)) requireNonNull(action).run();
	}

	/**
	 * Return the result if the value does not satisfy the predicate, elseResult otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param result the result to return if the value does not satisfy the predicate
	 * @param elseResult the result to return if the value satisfies the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value does not satisfy the predicate, elseResult otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredElse(Predicate<T1> predicate, T1 value, T2 result, T2 elseResult) {
		return !requireNonNull(predicate).test(value) ? result : elseResult;
	}

	/**
	 * Return the result if the value does not satisfy the predicate, the result of the elseSupplier otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param result the result to return if the value does not satisfy the predicate
	 * @param elseSupplier the supplier of the result if the value satisfies the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value does not satisfy the predicate, the result of the elseSupplier otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredElseGet(Predicate<T1> predicate, T1 value, T2 result, Supplier<T2> elseSupplier) {
		return !requireNonNull(predicate).test(value) ? result : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the result of the supplier if the value does not satisfy the predicate, elseResult otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseResult the result to return if the value satisfies the predicate
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value does not satisfy the predicate, elseResult otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredGetElse(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, T2 elseResult) {
		return !requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the result if the value does not satisfy the predicate, execute the elseAction otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param result the result to return if the value does not satisfy the predicate
	 * @param elseAction the action to execute if the value satisfies the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result if the value does not satisfy the predicate, execute the elseAction otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredElse(Predicate<T1> predicate, T1 value, T2 result, Runnable elseAction) {
		if (!requireNonNull(predicate).test(value)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the action if the value does not satisfy the predicate, else return the elseResult otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param action the action to execute if the value does not satisfy the predicate; not null
	 * @param elseResult the result to return if the value satisfies the predicate
	 * @param <T> the type of the value
	 * @param <T2> the type of the result
	 * @return the elseResult if the value satisfies the predicate, execute the action otherwise
	 */
	public static <T, T2> T2 ifNonEnsuredElse(Predicate<T> predicate, T value, Runnable action, T2 elseResult) {
		if (!requireNonNull(predicate).test(value)) {
			requireNonNull(action).run();
			return null;
		}
		return elseResult;
	}

	/**
	 * Return the result of the supplier if the value does not satisfy the predicate, the result of the elseSupplier otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseSupplier the supplier of the result if the value satisfies the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value does not satisfy the predicate, the result of the elseSupplier otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredGetElseGet(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Supplier<T2> elseSupplier) {
		return !requireNonNull(predicate).test(value) ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Execute the action if the value does not satisfy the predicate, the elseAction otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param action the action to execute if the value does not satisfy the predicate; not null
	 * @param elseAction the action to execute if the value satisfies the predicate; not null
	 * @param <T> the type of the value
	 */
	public static <T> void ifNonEnsured(Predicate<T> predicate, T value, Runnable action, Runnable elseAction) {
		if (!requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Return the result of the supplier if the value does not satisfy the predicate, execute the elseAction otherwise.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param elseAction the action to execute if the value satisfies the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the supplier if the value does not satisfy the predicate, execute the elseAction otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredGetElse(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Runnable elseAction) {
		if (!requireNonNull(predicate).test(value)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the action if the value does not satisfy the predicate, else return the result of the elseSupplier.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param action the action to execute if the value does not satisfy the predicate
	 * @param elseSupplier the supplier of the result if the value satisfies the predicate; not null
	 * @param <T1> the type of the value
	 * @param <T2> the type of the result
	 * @return the result of the elseSupplier if the value satisfies the predicate, execute the action otherwise
	 */
	public static <T1, T2> T2 ifNonEnsuredElseGet(Predicate<T1> predicate, T1 value, Runnable action, Supplier<T2> elseSupplier) {
		if (!requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Return the result if the value does not satisfy the predicate, else throw an exception.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param result the result to return if the value does not satisfy the predicate
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @return the result if the value does not satisfy the predicate, else throw an exception
	 * @param <T1> the type of the value to check
	 * @param <T2> the type of the result
	 * @param <X> the type of the exception
	 * @throws X if the value satisfies the predicate
	 */
	public static <T1, T2, X extends Throwable> T2 ifNonEnsuredElseThrow(Predicate<T1> predicate, T1 value, T2 result, Supplier<X> exceptionSupplier) throws X {
		if (!requireNonNull(predicate).test(value)) return result;
		else throw exceptionSupplier.get();
	}

	/**
	 * Return the result of the supplier if the value does not satisfy the predicate, else throw an exception.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param supplier the supplier of the result; not null
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @return the result of the supplier if the value does not satisfy the predicate, else throw an exception
	 * @param <T1> the type of the value to check
	 * @param <T2> the type of the result
	 * @param <X> the type of the exception
	 * @throws X if the value satisfies the predicate
	 */
	public static <T1, T2, X extends Throwable> T2 ifNonEnsuredGetElseThrow(Predicate<T1> predicate, T1 value, Supplier<T2> supplier, Supplier<X> exceptionSupplier) throws X {
		if (!requireNonNull(predicate).test(value)) return requireNonNull(supplier).get();
		else throw exceptionSupplier.get();
	}

	/**
	 * Execute the action if the value does not satisfy the predicate, else throw an exception.
	 * @param predicate the predicate to check; not null
	 * @param value the value to check
	 * @param action the action to execute if the value does not satisfy the predicate; not null
	 * @param exceptionSupplier the supplier of the exception to throw; not null
	 * @param <T> the type of the value to check
	 * @param <X> the type of the exception
	 * @throws X if the value satisfies the predicate
	 */
	public static <T, X extends Throwable> void ifNonEnsuredElseThrow(Predicate<T> predicate, T value, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (!requireNonNull(predicate).test(value)) requireNonNull(action).run();
		else throw exceptionSupplier.get();
	}
}
