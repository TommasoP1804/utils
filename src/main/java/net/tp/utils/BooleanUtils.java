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
public abstract class BooleanUtils {
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
}