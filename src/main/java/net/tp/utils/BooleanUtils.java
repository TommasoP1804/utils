package net.tp.utils;

import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.*;

/**
 * Utility class for booleans.
 * @author Tommaso Pastorelli
 * @since 1.5.0
 */
@SuppressWarnings("unused")
public abstract class BooleanUtils {
	/**
	 * Check if the given {@link Boolean} object is true.
	 * @param obj the object to check
	 * @return true if the object is not null and true, false otherwise
	 * @since 1.6.0
	 */
	public static boolean isTrue(Boolean obj) {
		return nonNull(obj) && obj.equals(TRUE);
	}

	/**
	 * Check if the given {@link Boolean} object is false.
	 * @param obj the object to check
	 * @return true if the object is not null and false, false otherwise
	 * @since 1.6.0
	 */
	public static boolean isFalse(Boolean obj) {
		return nonNull(obj) && obj.equals(FALSE);
	}

	/**
	 * Check if the given object is null or true.
	 * @param obj the object to check
	 * @return true if the object is null or true, false otherwise
	 * @since 1.5.0
	 */
	public static boolean isNullOrTrue(Boolean obj) {
		return isNull(obj) || obj.equals(TRUE);
	}

	/**
	 * Check if the given object is null or false.
	 * @param obj the object to check
	 * @return true if the object is null or false, false otherwise
	 * @since 1.5.0
	 */
	public static boolean isNullOrFalse(Boolean obj) {
		return isNull(obj) || obj.equals(FALSE);
	}

	/**
	 * Check if all the given values are true.
	 * @param values the values to check
	 * @return true if all the values are true, false otherwise
	 * @since 1.5.0
	 */
	public static boolean allTrue(boolean... values) {
		for (boolean value : requireNonNull(values)) {
			if (!value) return false;
		} return true;
	}

	/**
	 * Check if all the given values are true.
	 * @param values the values to check
	 * @return true if all the values are true, false otherwise
	 * @since 1.5.0
	 */
	public static boolean allTrue(Boolean... values) {
		for (Boolean value : requireNonNull(values)) {
			if (isNull(value) || value.equals(FALSE)) return false;
		} return true;
	}

	/**
	 * Check if any of the given values is true.
	 * @param values the values to check
	 * @return true if any of the values is true, false otherwise
	 * @since 1.5.0
	 */
	public static boolean anyTrue(boolean... values) {
		for (boolean value : requireNonNull(values)) {
			if (value) return true;
		} return false;
	}

	/**
	 * Check if any of the given values is true.
	 * @param values the values to check
	 * @return true if any of the values is true, false otherwise
	 * @since 1.5.0
	 */
	public static boolean anyTrue(Boolean... values) {
		for (Boolean value : requireNonNull(values)) {
			if (nonNull(value) && value.equals(TRUE)) return true;
		} return false;
	}

	/**
	 * Check if all the given values are false.
	 * @param values the values to check
	 * @return true if all the values are false, false otherwise
	 * @since 1.5.0
	 */
	public static boolean allFalse(boolean... values) {
		for (boolean value : requireNonNull(values)) {
			if (value) return false;
		} return true;
	}

	/**
	 * Check if all the given values are false.
	 * @param values the values to check
	 * @return true if all the values are false, false otherwise
	 * @since 1.5.0
	 */
	public static boolean allFalse(Boolean... values) {
		for (Boolean value : requireNonNull(values)) {
			if (isNull(value) || value.equals(TRUE)) return false;
		} return true;
	}

	/**
	 * Check if any of the given values is false.
	 * @param values the values to check
	 * @return true if any of the values is false, false otherwise
	 * @since 1.5.0
	 */
	public static boolean anyFalse(boolean... values) {
		for (boolean value : requireNonNull(values)) {
			if (!value) return true;
		} return false;
	}

	/**
	 * Check if any of the given values is false.
	 * @param values the values to check
	 * @return true if any of the values is false, false otherwise
	 * @since 1.5.0
	 */
	public static boolean anyFalse(Boolean... values) {
		for (Boolean value : requireNonNull(values)) {
			if (isNull(value) || value.equals(FALSE)) return true;
		} return false;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false
	 * @since 1.5.0
	 */
	public static boolean requireTrue(boolean obj) {
		if (!obj) throw new IllegalArgumentException();
		return true;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false or null
	 * @since 1.5.0
	 */
	public static Boolean requireTrue(Boolean obj) {
		if (isNull(obj) || obj.equals(FALSE)) throw new IllegalArgumentException();
		return TRUE;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false
	 * @since 1.5.0
	 */
	public static boolean requireTrue(boolean obj, String message) {
		if (!obj) throw new IllegalArgumentException(message);
		return true;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false or null
	 * @since 1.5.0
	 */
	public static Boolean requireTrue(Boolean obj, String message) {
		if (isNull(obj) || obj.equals(FALSE)) throw new IllegalArgumentException(message);
		return TRUE;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is false
	 * @since 1.5.0
	 */
	public static <X extends Throwable> boolean requireTrueElseThrow(boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (!obj) throw exceptionSupplier.get();
		return true;
	}

	/**
	 * Require the given object to be true.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is false or null
	 * @since 1.5.0
	 */
	public static <X extends Throwable> Boolean requireTrueElseThrow(Boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (isNull(obj) || obj.equals(FALSE)) throw exceptionSupplier.get();
		return TRUE;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true
	 * @since 1.5.0
	 */
	public static boolean requireFalse(boolean obj) {
		if (obj) throw new IllegalArgumentException();
		return false;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true or null
	 * @since 1.5.0
	 */
	public static Boolean requireFalse(Boolean obj) {
		if (isNull(obj) || obj.equals(TRUE)) throw new IllegalArgumentException();
		return FALSE;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true
	 * @since 1.5.0
	 */
	public static boolean requireFalse(boolean obj, String message) {
		if (obj) throw new IllegalArgumentException(message);
		return false;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true or null
	 * @since 1.5.0
	 */
	public static Boolean requireFalse(Boolean obj, String message) {
		if (isNull(obj) || obj.equals(TRUE)) throw new IllegalArgumentException(message);
		return FALSE;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is true
	 * @since 1.5.0
	 */
	public static <X extends Throwable> boolean requireFalseElseThrow(boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (obj) throw exceptionSupplier.get();
		return false;
	}

	/**
	 * Require the given object to be false.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is true or null
	 * @since 1.5.0
	 */
	public static <X extends Throwable> Boolean requireFalseElseThrow(Boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (isNull(obj) || obj.equals(TRUE)) throw exceptionSupplier.get();
		return FALSE;
	}

	/**
	 * Require the given object to be true or null.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false
	 * @since 1.5.0
	 */
	public static Boolean requireNullOrTrue(Boolean obj) {
		if (nonNull(obj) && obj.equals(FALSE)) throw new IllegalArgumentException();
		return obj;
	}

	/**
	 * Require the given object to be true or null.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is false
	 * @since 1.5.0
	 */
	public static Boolean requireNullOrTrue(Boolean obj, String message) {
		if (nonNull(obj) && obj.equals(FALSE)) throw new IllegalArgumentException(message);
		return obj;
	}

	/**
	 * Require the given object to be true or null.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is false
	 * @since 1.5.0
	 */
	public static <X extends Throwable> Boolean requireNullOrTrueElseThrow(Boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (nonNull(obj) && obj.equals(FALSE)) throw exceptionSupplier.get();
		return obj;
	}

	/**
	 * Require the given object to be false or null.
	 * @param obj the object to check
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true
	 * @since 1.5.0
	 */
	public static Boolean requireNullOrFalse(Boolean obj) {
		if (nonNull(obj) && obj.equals(TRUE)) throw new IllegalArgumentException();
		return obj;
	}

	/**
	 * Require the given object to be false or null.
	 * @param obj the object to check
	 * @param message the message of the exception
	 * @return the object itself
	 * @throws IllegalArgumentException if the object is true
	 * @since 1.5.0
	 */
	public static Boolean requireNullOrFalse(Boolean obj, String message) {
		if (nonNull(obj) && obj.equals(TRUE)) throw new IllegalArgumentException(message);
		return obj;
	}

	/**
	 * Require the given object to be false or null.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the exception
	 * @return the object itself
	 * @throws X if the object is true
	 * @since 1.5.0
	 */
	public static <X extends Throwable> Boolean requireNullOrFalseElseThrow(Boolean obj, Supplier<X> exceptionSupplier) throws X {
		if (nonNull(obj) && obj.equals(TRUE)) throw exceptionSupplier.get();
		return obj;
	}

	/**
	 * Return the result if the condition is true, null otherwise.
	 * @param condition the condition to check
	 * @param result the result to return if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrue(boolean condition, T result) {
		return condition ? result : null;
	}

	/**
	 * Return the result if the condition is true, null otherwise.
	 * @param condition the condition to check
	 * @param result the result to return if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrue(Boolean condition, T result) {
		return isTrue(condition) ? result : null;
	}

	/**
	 * Return the result if the condition is null or true, null otherwise.
	 * @param condition the condition to check
	 * @param result the result to return if the condition is null or true
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrue(Boolean condition, T result) {
		return isNullOrTrue(condition) ? result : null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGet(boolean condition, Supplier<T> supplier) {
		return condition ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGet(Boolean condition, Supplier<T> supplier) {
		return isTrue(condition) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or true, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueGet(Boolean condition, Supplier<T> supplier) {
		return isNullOrTrue(condition) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Execute the given action if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute
	 * @since 1.10.0
	 */
	public static void ifTrue(boolean condition, Runnable action) {
		if (condition) requireNonNull(action).run();
	}

	/**
	 * Execute the given action if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute
	 * @since 1.10.0
	 */
	public static void ifTrue(Boolean condition, Runnable action) {
		if (isTrue(condition)) requireNonNull(action).run();
	}

	/**
	 * Execute the given action if the condition is null or true.
	 * @param condition the condition to check
	 * @param action the action to execute; not null
	 * @since 1.10.0
	 */
	public static void ifNullOrTrue(Boolean condition, Runnable action) {
		if (isNullOrTrue(condition)) requireNonNull(action).run();
	}

	/**
	 * Return the result if the condition is true, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseResult the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(boolean condition, T result, T elseResult) {
		return condition ? result : elseResult;
	}

	/**
	 * Return the result if the condition is true, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseResult the value if the condition is null or false
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(Boolean condition, T result, T elseResult) {
		return isTrue(condition) ? result : elseResult;
	}

	/**
	 * Return the result if the condition is null or true, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or true
	 * @param elseResult the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueElse(Boolean condition, T result, T elseResult) {
		return isNullOrTrue(condition) ? result : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseResult the value if the condition is false
	 * @return the value if the condition is true, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElse(boolean condition, Supplier<T> supplier, T elseResult) {
		return condition ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseResult the value if the condition is null or false
	 * @return the value if the condition is true, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElse(Boolean condition, Supplier<T> supplier, T elseResult) {
		return isTrue(condition) ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or true, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or true; not null
	 * @param elseResult the value if the condition is false
	 * @return the value if the condition is null or true, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueGetElse(Boolean condition, Supplier<T> supplier, T elseResult) {
		return isNullOrTrue(condition) ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Execute the given action if the condition is true, return result if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseResult the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(boolean condition, Runnable action, T elseResult) {
		if (condition) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Execute the given action if the condition is true, return result if the condition is null or false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseResult the value if the condition is null or false
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(Boolean condition, Runnable action, T elseResult) {
		if (isTrue(condition)) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Execute the given action if the condition is null or true, return result if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or true; not null
	 * @param elseResult the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueElse(Boolean condition, Runnable action, T elseResult) {
		if (isNullOrTrue(condition)) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Return result if the condition is true, the other value inside the given {@link Supplier} otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseSupplier the supplier of the value if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElseGet(boolean condition, T result, Supplier<T> elseSupplier) {
		return condition ? result : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return result if the condition is true, the other value inside the given {@link Supplier} otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseSupplier the supplier of the value if the condition is null or false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElseGet(Boolean condition, T result, Supplier<T> elseSupplier) {
		return isTrue(condition) ? result : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return result if the condition is null or true, the other value inside the given {@link Supplier} otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or true
	 * @param elseSupplier the supplier of the value if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueElseGet(Boolean condition, T result, Supplier<T> elseSupplier) {
		return isNullOrTrue(condition) ? result : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the result if the condition is true, execute the action if the condition is false.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseAction the action to execute if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(boolean condition, T result, Runnable elseAction) {
		if (condition) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the result if the condition is true, execute the action if the condition is null or false.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param elseAction the action to execute if the condition is null or false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElse(Boolean condition, T result, Runnable elseAction) {
		if (isTrue(condition)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the result if the condition is null or true, execute the action if the condition is false.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or true
	 * @param elseAction the action to execute if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, the value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueElse(Boolean condition, T result, Runnable elseAction) {
		if (isNullOrTrue(condition)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseSupplier the supplier of the value if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElseGet(boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return condition ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseSupplier the supplier of the value if the condition is null or false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElseGet(Boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return condition ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or true, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or true; not null
	 * @param elseSupplier the supplier of the value if the condition is false; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is null or true, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueGetElseGet(Boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return isNullOrTrue(condition) ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Execute the given action if the condition is true, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseAction the action to execute if the condition is false; not null
	 * @since 1.10.0
	 */
	public static void ifTrueElse(boolean condition, Runnable action, Runnable elseAction) {
		if (condition) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is true, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseAction the action to execute if the condition is null or false; not null
	 * @since 1.10.0
	 */
	public static void ifTrueElse(Boolean condition, Runnable action, Runnable elseAction) {
		if (isTrue(condition)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is null or true, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or true; not null
	 * @param elseAction the action to execute if the condition is false; not null
	 * @since 1.10.0
	 */
	public static void ifNullOrTrueElse(Boolean condition, Runnable action, Runnable elseAction) {
		if (isNullOrTrue(condition)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is true, the other action if the condition is false.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseAction the action to execute if the condition is false; not null
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElse(boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (condition) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is true, the other action if the condition is null or false.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param elseAction the action to execute if the condition is null or false; not null
	 * @since 1.10.0
	 */
	public static <T> T ifTrueGetElse(Boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (isTrue(condition)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is null or true, the other action if the condition is false.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or true; not null
	 * @param elseAction the action to execute if the condition is false; not null
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueGetElse(Boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (isNullOrTrue(condition)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is true, return the object in the supplier if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseSupplier  the supplier of the value if the condition is false; not null
	 * @return the value if the condition is true, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElseGet(boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (condition) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Execute the given action if the condition is true, return the object in the supplier if the condition is null or false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param elseSupplier  the supplier of the value if the condition is null or false; not null
	 * @return the value if the condition is true, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifTrueElseGet(Boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (isTrue(condition)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Execute the given action if the condition is null or true, return the object in the supplier if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or true; not null
	 * @param elseSupplier  the supplier of the value if the condition is false; not null
	 * @return the value if the condition is null or true, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrTrueElseGet(Boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (isNullOrTrue(condition)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Return the result if the condition is true, throw the exception if the condition is false.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is true
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifTrueElseThrow(boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (condition) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the result if the condition is true, throw the exception if the condition is null or false.
	 * @param condition the condition to check
	 * @param result the value if the condition is true
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or false; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is true
	 * @throws X if the condition is null or false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifTrueElseThrow(Boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (isTrue(condition)) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the result if the condition is null or true, throw the exception if the condition is false.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or true
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is null or true
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifNullOrTrueElseThrow(Boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrTrue(condition)) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @return the value if the condition is true
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifTrueGetElseThrow(boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (condition) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or false; not null
	 * @return the value if the condition is true
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is null or false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifTrueGetElseThrow(Boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (isTrue(condition)) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @return the value if the condition is null or true
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifNullOrTrueGetElseThrow(Boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrTrue(condition)) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifTrueElseThrow(boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (condition) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or false; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is null or false
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifTrueElseThrow(Boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (isTrue(condition)) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is null or true, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or true; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is false; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is false
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifNullOrTrueElseThrow(Boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrTrue(condition)) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the result if the condition is false, null otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalse(boolean condition, T result) {
		return !condition ? result : null;
	}

	/**
	 * Return the result if the condition is false, null otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param <T> the type of the value
	 * @return the value if the condition is false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalse(Boolean condition, T result) {
		return isFalse(condition) ? result : null;
	}

	/**
	 * Return the result if the condition is null or false, null otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or false
	 * @param <T> the type of the value
	 * @return the value if the condition is null or false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalse(Boolean condition, T result) {
		return isNullOrFalse(condition) ? result : null;
	}

	/**
	 * Execute the given action if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute; not null
	 * @since 1.10.0
	 */
	public static void ifFalse(boolean condition, Runnable action) {
		if (!condition) requireNonNull(action).run();
	}

	/**
	 * Execute the given action if the condition is false.
	 * @param condition the condition to check
	 * @param action the action to execute; not null
	 * @since 1.10.0
	 */
	public static void ifFalse(Boolean condition, Runnable action) {
		if (isFalse(condition)) requireNonNull(action).run();
	}

	/**
	 * Execute the given action if the condition is null or false.
	 * @param condition the condition to check
	 * @param action the action to execute; not null
	 * @since 1.10.0
	 */
	public static void ifNullOrFalse(Boolean condition, Runnable action) {
		if (isNullOrFalse(condition)) requireNonNull(action).run();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGet(boolean condition, Supplier<T> supplier) {
		return !condition ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGet(Boolean condition, Supplier<T> supplier) {
		return isFalse(condition) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or false, null otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, null otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseGet(Boolean condition, Supplier<T> supplier) {
		return isNullOrFalse(condition) ? requireNonNull(supplier).get() : null;
	}

	/**
	 * Return the value if the condition is false, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param elseResult the value if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(boolean condition, T result, T elseResult) {
		return !condition ? result : elseResult;
	}

	/**
	 * Return the value if the condition is false, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param elseResult the value if the condition is null or true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(Boolean condition, T result, T elseResult) {
		return isFalse(condition) ? result : elseResult;
	}

	/**
	 * Return the value if the condition is null or false, the other value otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or false
	 * @param elseResult the value if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseElse(Boolean condition, T result, T elseResult) {
		return isNullOrFalse(condition) ? result : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseResult the value if the condition is true
	 * @return the value if the condition is false, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGetElse(boolean condition, Supplier<T> supplier, T elseResult) {
		return !condition ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseResult the value if the condition is null or true
	 * @return the value if the condition is false, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGetElse(Boolean condition, Supplier<T> supplier, T elseResult) {
		return isFalse(condition) ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or false, the other value otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or false; not null
	 * @param elseResult the value if the condition is true
	 * @return the value if the condition is false, the other value otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseGetElse(Boolean condition, Supplier<T> supplier, T elseResult) {
		return isNullOrFalse(condition) ? requireNonNull(supplier).get() : elseResult;
	}

	/**
	 * Return the result if the condition is false, return the value inside the supplier otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElseGet(boolean condition, T result, Supplier<T> supplier) {
		return !condition ? result : requireNonNull(supplier).get();
	}

	/**
	 * Return the result if the condition is false, return the value inside the supplier otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param supplier the supplier of the value if the condition is null or true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElseGet(Boolean condition, T result, Supplier<T> supplier) {
		return isFalse(condition) ? result : requireNonNull(supplier).get();
	}

	/**
	 * Return the result if the condition is null or false, return the value inside the supplier otherwise.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or false
	 * @param supplier the supplier of the value if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the value inside the supplier otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseElseGet(Boolean condition, T result, Supplier<T> supplier) {
		return isNullOrFalse(condition) ? result : requireNonNull(supplier).get();
	}

	/**
	 * Execute the given action if the condition is false, return result if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseResult the value if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(boolean condition, Runnable action, T elseResult) {
		if (!condition) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Execute the given action if the condition is false, return result if the condition is null or true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseResult the value if the condition is null or true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(Boolean condition, Runnable action, T elseResult) {
		if (isFalse(condition)) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Execute the given action if the condition is null or false, return result if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or false; not null
	 * @param elseResult the value if the condition is true
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseElse(Boolean condition, Runnable action, T elseResult) {
		if (isNullOrFalse(condition)) requireNonNull(action).run();
		else return elseResult;
		return null;
	}

	/**
	 * Return the result if the condition is false, execute the action if the condition is true.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param elseAction the action to execute if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, execute the action otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(boolean condition, T result, Runnable elseAction) {
		if (!condition) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the result if the condition is false, execute the action if the condition is null or true.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param elseAction the action to execute if the condition is null or true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, execute the action otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(Boolean condition, T result, Runnable elseAction) {
		if (isFalse(condition)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the result if the condition is null or false, execute the action if the condition is true.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or false
	 * @param elseAction the action to execute if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, execute the action otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseElse(Boolean condition, T result, Runnable elseAction) {
		if (isNullOrFalse(condition)) return result;
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseSupplier the supplier of the value if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGetElseGet(boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return !condition ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseSupplier the supplier of the value if the condition is null or true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGetElseGet(Boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return isFalse(condition) ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or false, the value inside the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or false; not null
	 * @param elseSupplier the supplier of the value if the condition is true; not null
	 * @param <T> the type of the value
	 * @return the value if the condition is false, the other value otherwise
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseGetElseGet(Boolean condition, Supplier<T> supplier, Supplier<T> elseSupplier) {
		return isNullOrFalse(condition) ? requireNonNull(supplier).get() : requireNonNull(elseSupplier).get();
	}

	/**
	 * Execute the given action if the condition is false, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseAction the action to execute if the condition is true; not null
	 * @since 1.10.0
	 */
	public static void ifFalseElse(boolean condition, Runnable action, Runnable elseAction) {
		if (!condition) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is false, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseAction the action to execute if the condition is null or true; not null
	 * @since 1.10.0
	 */
	public static void ifFalseElse(Boolean condition, Runnable action, Runnable elseAction) {
		if (isFalse(condition)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is null or false, the other action otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or false; not null
	 * @param elseAction the action to execute if the condition is true; not null
	 * @since 1.10.0
	 */
	public static void ifNullOrFalseElse(Boolean condition, Runnable action, Runnable elseAction) {
		if (isNullOrFalse(condition)) requireNonNull(action).run();
		else requireNonNull(elseAction).run();
	}

	/**
	 * Execute the given action if the condition is false, the other action if the condition is true.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseAction the action to execute if the condition is true; not null
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElse(boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (!condition) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is false, the other action if the condition is null or true.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param elseAction the action to execute if the condition is null or true; not null
	 * @since 1.10.0
	 */
	public static <T> T ifFalseGetElse(Boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (isFalse(condition)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is null or false, the other action if the condition is true.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or false; not null
	 * @param elseAction the action to execute if the condition is true; not null
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseGetElse(Boolean condition, Supplier<T> supplier, Runnable elseAction) {
		if (isNullOrFalse(condition)) return requireNonNull(supplier).get();
		else requireNonNull(elseAction).run();
		return null;
	}

	/**
	 * Execute the given action if the condition is false, return the object in the supplier if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseSupplier  the supplier of the value if the condition is true; not null
	 * @return the value if the condition is false, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElseGet(boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (!condition) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Execute the given action if the condition is false, return the object in the supplier if the condition is null or true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param elseSupplier  the supplier of the value if the condition is null or true; not null
	 * @return the value if the condition is false, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifFalseElseGet(Boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (isFalse(condition)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Execute the given action if the condition is null or false, return the object in the supplier if the condition is true.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or false; not null
	 * @param elseSupplier  the supplier of the value if the condition is true; not null
	 * @return the value if the condition is null or false, the value inside the supplier otherwise
	 * @param <T> the type of the value
	 * @since 1.10.0
	 */
	public static <T> T ifNullOrFalseElseGet(Boolean condition, Runnable action, Supplier<T> elseSupplier) {
		if (isNullOrFalse(condition)) requireNonNull(action).run();
		else return requireNonNull(elseSupplier).get();
		return null;
	}

	/**
	 * Return the result if the condition is false, throw the exception if the condition is true.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is false
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifFalseElseThrow(boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (!condition) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the result if the condition is false, throw the exception if the condition is true.
	 * @param condition the condition to check
	 * @param result the value if the condition is false
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or true; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is false
	 * @throws X if the condition is null or true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifFalseElseThrow(Boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (isFalse(condition)) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the result if the condition is null or false, throw the exception if the condition is true.
	 * @param condition the condition to check
	 * @param result the value if the condition is null or false
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @return the value if the condition is false
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifNullOrFalseElseThrow(Boolean condition, T result, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrFalse(condition)) return result;
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @return the value if the condition is false
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifFalseGetElseThrow(boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (!condition) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or true; not null
	 * @return the value if the condition is false
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is null or true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifFalseGetElseThrow(Boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (isFalse(condition)) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Return the value inside the given {@link Supplier} if the condition is null or false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param supplier the supplier of the value if the condition is null or false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @return the value if the condition is null or false
	 * @param <T> the type of the value
	 * @param <X> the type of the exception
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <T, X extends Throwable> T ifNullOrFalseGetElseThrow(Boolean condition, Supplier<T> supplier, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrFalse(condition)) return requireNonNull(supplier).get();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifFalseElseThrow(boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (!condition) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is null or true; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is null or true
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifFalseElseThrow(Boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (isFalse(condition)) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}

	/**
	 * Execute the given action if the condition is null or false, throw the exception in the other supplier otherwise.
	 * @param condition the condition to check
	 * @param action the action to execute if the condition is null or false; not null
	 * @param exceptionSupplier the supplier of the exception to throw if the condition is true; not null
	 * @param <X> the type of the exception
	 * @throws X if the condition is true
	 * @since 1.10.0
	 */
	public static <X extends Throwable> void ifNullOrFalseElseThrow(Boolean condition, Runnable action, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrFalse(condition)) requireNonNull(action).run();
		else throw requireNonNull(exceptionSupplier).get();
	}
}