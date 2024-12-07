package net.tp.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static java.util.Objects.*;
import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * Utility class for char sequences.
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public abstract class CharSequenceUtils {
	/**
	 * The space-only char sequence.
	 */
	private static final CharSequence SPACE = " ";
	/**
	 * The space-only char sequence.
	 */
	private static final CharSequence EMPTY = "";
	/**
	 * The tab-only char sequence.
	 */
	private static final CharSequence TAB = "\t";

	/**
	 * Return an empty char sequence casted to che specified type.
	 * @param <T> the type of the char sequence
	 * @return an empty char sequence
	 * @since 1.9.0
	 */
	public static <T extends CharSequence> T empty() {
		@SuppressWarnings("unchecked") T result = (T) EMPTY;
		return result;
	}

	/**
	 * Return a space char sequence casted to che specified type.
	 * @param <T> the type of the char sequence
	 * @return a space char sequence
	 * @since 1.9.0
	 */
	public static <T extends CharSequence> T space() {
		@SuppressWarnings("unchecked") T result = (T) SPACE;
		return result;
	}

	/**
	 * Return a tab char sequence casted to che specified type.
	 * @param <T> the type of the char sequence
	 * @return a tab char sequence
	 * @since 1.9.0
	 */
	public static <T extends CharSequence> T tab() {
		@SuppressWarnings("unchecked") T result = (T) TAB;
		return result;
	}

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not null and not empty
	 * @throws IllegalArgumentException if the default char sequence is null or empty
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonEmpty(T cs) {
		if (isNullOrEmpty(cs)) throw new IllegalArgumentException();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param message the message of the exception
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not null and not empty
	 * @throws IllegalArgumentException if the default char sequence is null or empty
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonEmpty(T cs, String message) {
		if (isNullOrEmpty(cs)) throw new IllegalArgumentException(message);
		return cs;
	}

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param exceptionSupplier the supplier of the exception
	 * @param <T> the type of the char sequence
	 * @param <X> the type of the exception
	 * @return the given char sequence if it is not null and not empty
	 * @throws X if the default char sequence is null or empty
	 * @since 1.4.0
	 */
	public static <T extends CharSequence, X extends Throwable> T requireNonEmptyElseThrow(T cs, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrEmpty(cs)) throw requireNonNull(exceptionSupplier).get();
		return cs;
	}


	/**
	 * Return the given char sequence if it is not null and not empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not null and not empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonEmptyElse(T cs, T defaultCs) {
		return nonEmpty(cs) ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is null or empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is null or empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNullOrEmptyElse(T cs, T defaultCs) {
		return isNullOrEmpty(cs) ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not blank and not empty
	 * @throws IllegalArgumentException if the default char sequence is blank
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonBlank(T cs) {
		if (requireNonNull(cs).toString().isBlank()) throw new IllegalArgumentException();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param message the message of the exception
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not blank
	 * @throws IllegalArgumentException if the default char sequence is blank
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonBlank(T cs, String message) {
		if (requireNonNull(cs).toString().isBlank()) throw new IllegalArgumentException(message);
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param exceptionSupplier the supplier of the exception
	 * @param <T> the type of the char sequence
	 * @param <X> the type of the exception
	 * @return the given char sequence if it is not blank
	 * @throws X if the default char sequence is blank
	 * @since 1.4.0
	 */
	public static <T extends CharSequence, X extends Throwable> T requireNonBlankElseThrow(T cs, Supplier<X> exceptionSupplier) throws X {
		if (requireNonNull(cs).toString().isBlank()) throw requireNonNull(exceptionSupplier).get();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is not blank, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireNonBlankElse(T cs, T defaultCs) {
		return !requireNonNull(cs).toString().isBlank() ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is null or empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @param <T> the type of the char sequence
	 * @return the given char sequence if it is null or empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T requireBlankElse(T cs, T defaultCs) {
		return !requireNonNull(cs).toString().isBlank() ? cs : defaultCs;
	}

	/**
	 * Checks if a given string is null, empty, or only contains whitespace.
	 *
	 * @param cs the string to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the string is null, empty, or only contains whitespace, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isNullOrBlank(T cs) {
		return isNullOrEmpty(cs) || cs.chars().allMatch(Character::isWhitespace);
	}

	/**
	 * Checks if a given string is not null, not empty, and not only contains whitespace.
	 *
	 * @param cs the string to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the string is not null, not empty, and not only contains whitespace, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #nonBlank(CharSequence)} instead
	 */
	@Deprecated
	public static <T extends CharSequence> boolean isNotBlank(T cs) {
		return !isNullOrBlank(cs);
	}

	/**
	 * Checks if a given string is not null, not empty, and not only contains whitespace.
	 *
	 * @param cs the string to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the string is not null, not empty, and not only contains whitespace, {@code false} otherwise
	 * @since 1.6.0
	 */
	public static <T extends CharSequence> boolean nonBlank(T cs) {
		return !isNullOrBlank(cs);
	}

	/**
	 * Checks if given char sequences is all null or blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all null or blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNullOrBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNullOrBlank(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if given char sequences is all null or blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all null or blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNullOrBlank(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNullOrBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNullOrBlank(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNullOrBlank(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if given char sequences is blank and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNullOrBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNullOrBlank(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrBlank(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is blank and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNullOrBlank(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrBlank(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all not null or blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all not null or blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNonBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNotBlank(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::nonBlank);
	}

	/**
	 * Checks if given char sequences is all not null or blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all not null or blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNonBlank(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::nonBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is not blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNonBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNotBlank(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::nonBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not blank.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is not blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNonBlank(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::nonBlank);
	}

	/**
	 * Checks if given char sequences is not blank and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not null or blank, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNonBlank(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNotBlank(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) result[i] = nonBlank(css[i]);
		return result;
	}

	/**
	 * Checks if given char sequences is not blank and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not null or blank, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNonBlank(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) result[i] = nonBlank(css[i]);
		return result;
	}

	/**
	 * Checks if a given string is null or empty.
	 *
	 * @param cs the string to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the string is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isNullOrEmpty(T cs) {
		return isNull(cs) || cs.isEmpty();
	}

	/**
	 * Checks if a given char sequence is not null and not empty.
	 *
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is not null and not empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #nonEmpty(CharSequence)} instead
	 */
	@Deprecated
	public static <T extends CharSequence> boolean isNotEmpty(T cs) {
		return !isNullOrEmpty(cs);
	}

	/**
	 * Checks if a given char sequence is not null and not empty.
	 *
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is not null and not empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	public static <T extends CharSequence> boolean nonEmpty(T cs) {
		return !isNullOrEmpty(cs);
	}

	/**
	 * Checks if given char sequences is all null or empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all null or empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNullOrEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNullOrEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if given char sequences is all null or empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all null or empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNullOrEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNullOrEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNullOrEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNullOrEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if given char sequences is null or empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNullOrEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNullOrEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrEmpty(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is null or empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNullOrEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrEmpty(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if given char sequences is all empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if given char sequences is empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = css[i].isEmpty();
		}
		return result;
	}

	/**
	 * Checks if given char sequences is empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = css[i].isEmpty();
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all not null or empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNonEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNotEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::nonEmpty);
	}

	/**
	 * Checks if given char sequences is all not null or empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all not null or empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNonEmpty(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::nonEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is not empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNonEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNotEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::nonEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not empty.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is not empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNonEmpty(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::nonEmpty);
	}

	/**
	 * Checks if given char sequences is not empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not empty, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNonEmpty(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNotEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = nonEmpty(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is not empty and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not empty, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNonEmpty(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++)
			result[i] = nonEmpty(css[i]);
		return result;
	}

	/**
	 * Checks if a given char sequence is all lower case.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is all lower case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isLowerCase(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(Character::isLowerCase);
	}

	/**
	 * Checks if given char sequences is all lower case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all lower case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allLowerCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllLowerCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if given char sequences is all lower case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all lower case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allLowerCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is lower case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is lower case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyLowerCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyLowerCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is lower case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is lower case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyLowerCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if given char sequences is lower case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is lower case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachLowerCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachLowerCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isLowerCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is lower case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is lower case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachLowerCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isLowerCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is all upper case.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is all upper case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isUpperCase(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(Character::isUpperCase);
	}

	/**
	 * Checks if given char sequences is all upper case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all upper case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allUpperCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllUpperCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if given char sequences is all upper case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are all upper case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allUpperCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is upper case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is upper case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyUpperCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyUpperCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is upper case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is upper case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyUpperCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if given char sequences is upper case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is upper case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachUpperCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachUpperCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isUpperCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is upper case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is upper case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachUpperCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isUpperCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is mixed case.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isMixedCase(T cs) {
		return nonEmpty(cs) && !isLowerCase(cs) && !isUpperCase(cs);
	}

	/**
	 * Checks if given char sequences is mixed case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are mixed case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allMixedCase(CharSequence...)} instead
	 */
	@SafeVarargs
	@Deprecated
	public static <T extends CharSequence> boolean isAllMixedCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isMixedCase);
	}

	/**
	 * Checks if given char sequences is mixed case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are mixed case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allMixedCase(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isMixedCase);
	}


	/**
	 * Checks if in the given char sequences there is at least one char sequence is mixed case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyMixedCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyMixedCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isMixedCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is mixed case.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is mixed case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyMixedCase(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isMixedCase);
	}

	/**
	 * Checks if given char sequences is mixed case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachMixedCase(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachMixedCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isMixedCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is mixed case and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is mixed case, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachMixedCase(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isMixedCase(css[i]);
		}
		return result;
	}


	/**
	 * Checks if a given char sequence is alphabetic.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isAlphabetic(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(Character::isLetter);
	}

	/**
	 * Checks if given char sequences is alphabetic.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allAlphabetic(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllAlphabetic(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if given char sequences is alphabetic.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphabetic, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allAlphabetic(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyAlphabetic(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyAlphabetic(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyAlphabetic(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if given char sequences is alphabetic and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachAlphabetic(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachAlphabetic(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabetic(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is alphabetic and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachAlphabetic(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabetic(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphabetic or space.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isAlphabeticSpace(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is alphabetic or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allAlphabeticSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllAlphabeticSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if given char sequences is alphabetic or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphabetic or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allAlphabeticSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyAlphabeticSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyAlphabeticSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyAlphabeticSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if given char sequences is alphabetic or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachAlphabeticSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachAlphabeticSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabeticSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is alphabetic or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachAlphabeticSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabeticSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphanumeric.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isAlphanumeric(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(Character::isLetterOrDigit);
	}

	/**
	 * Checks if given char sequences is alphanumeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allAlphanumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllAlphanumeric(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if given char sequences is alphanumeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphanumeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allAlphanumeric(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyAlphanumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyAlphanumeric(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyAlphanumeric(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if given char sequences is alphanumeric and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachAlphanumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachAlphanumeric(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is alphanumeric and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachAlphanumeric(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphanumeric or space.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isAlphanumericSpace(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is alphanumeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allAlphanumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllAlphanumericSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if given char sequences is alphanumeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are alphanumeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allAlphanumericSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyAlphanumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyAlphanumericSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyAlphanumericSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if given char sequences is alphanumeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachAlphanumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachAlphanumericSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is alphanumeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachAlphanumericSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is numeric.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isNumeric(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(Character::isDigit);
	}

	/**
	 * Checks if given char sequences is numeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are numeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNumeric(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if given char sequences is numeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are numeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNumeric(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNumeric(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is numeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNumeric(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if given char sequences is numeric and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNumeric(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNumeric(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is numeric and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNumeric(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is numeric or space.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isNumericSpace(T cs) {
		return nonEmpty(cs) && cs.chars().allMatch(c -> Character.isDigit(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is numeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allNumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllNumericSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if given char sequences is numeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are numeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allNumericSpace(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyNumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyNumericSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric or space.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is numeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyNumericSpace(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if given char sequences is numeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachNumericSpace(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachNumericSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is numeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric or space, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachNumericSpace(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is a valid email.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isEmail(T cs) {
		return nonEmpty(cs) && Pattern.compile("^([\\w-.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", CASE_INSENSITIVE).matcher(cs).matches();
	}

	/**
	 * Checks if given char sequences is a valid email.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are valid emails, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allEmail(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllEmail(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if given char sequences is a valid email.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are valid emails, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allEmail(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid email.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyEmail(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyEmail(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid email.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is a valid email, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyEmail(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if given char sequences is a valid email and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachEmail(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachEmail(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isEmail(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is a valid email and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid email, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachEmail(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isEmail(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is a valid URL.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean isURL(T cs) {
		return nonEmpty(cs) && Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", CASE_INSENSITIVE).matcher(cs).matches();
	}

	/**
	 * Checks if given char sequences is a valid URL.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are valid URLs, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #allURL(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAllURL(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if given char sequences is a valid URL.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if all char sequences are valid URLs, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean allURL(T... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid URL.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #anyURL(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean isAnyURL(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid URL.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if at least one char sequence is a valid URL, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean anyURL(T... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if given char sequences is a valid URL and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 * @deprecated use {@link #eachURL(CharSequence...)} instead
	 */
	@SafeVarargs @Deprecated
	public static <T extends CharSequence> boolean[] isEachURL(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isURL(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is a valid URL and put the result in an array.
	 * @param css the char sequences to check
	 * @param <T> the type of the char sequence
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid URL, {@code false} otherwise
	 * @since 1.6.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean[] eachURL(T... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isURL(css[i]);
		}
		return result;
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param abbrevMarker the abbreviation marker
	 * @param offset the offset of the abbreviation
	 * @param maxWidth the maximum width of the abbreviation
	 * @param <T> the type of the char sequence
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T abbreviate(T cs, T abbrevMarker, int offset, int maxWidth) {
		if (nonEmpty(cs) && EMPTY.equals(abbrevMarker) && maxWidth > 0) {
			@SuppressWarnings("unchecked") T result = (T) cs.subSequence(0, maxWidth);
			return result;
		}
		if (anyEmpty(cs, abbrevMarker)) return cs;

		int abbrevMarkerLength = abbrevMarker.length();
		int minAbbrevWidth = abbrevMarkerLength + 1;
		int minAbbrevWidthOffset = abbrevMarkerLength + abbrevMarkerLength + 1;
		if (maxWidth < minAbbrevWidth) throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));

		int csLen = cs.length();
		if (csLen <= maxWidth) return cs;

		if (offset > csLen) offset = csLen;

		if (csLen - offset < maxWidth - abbrevMarkerLength)
			offset = csLen - (maxWidth - abbrevMarkerLength);

		if (offset <= abbrevMarkerLength + 1) {
			@SuppressWarnings("unchecked") T result = (T) (cs.subSequence(0, maxWidth - abbrevMarkerLength).toString() + abbrevMarker);
			return result;
		}
		if (maxWidth < minAbbrevWidthOffset)
			throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));

		@SuppressWarnings("unchecked") T result1 = (T) (abbrevMarker.toString() + abbreviate(cs.subSequence(offset, cs.length()), abbrevMarker, maxWidth - abbrevMarkerLength));
		@SuppressWarnings("unchecked") T result2 = (T) (abbrevMarker.toString() + cs.subSequence(csLen - (maxWidth - abbrevMarkerLength), cs.length()));
		return offset + maxWidth - abbrevMarkerLength < csLen ? result1 :  result2;
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param offset the offset of the abbreviation
	 * @param maxWidth the maximum width of the abbreviation
	 * @param <T> the type of the char sequence
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T abbreviate(T cs, int offset, int maxWidth) {
		@SuppressWarnings("unchecked") T marker = (T) "...";
		return abbreviate(cs, marker, offset, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param abbrevMarker the abbreviation marker
	 * @param maxWidth the maximum width of the abbreviation
	 * @param <T> the type of the char sequence
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T abbreviate(T cs, T abbrevMarker, int maxWidth) {
		return abbreviate(cs, abbrevMarker, 0, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param maxWidth the maximum width of the abbreviation
	 * @param <T> the type of the char sequence
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T abbreviate(T cs, int maxWidth) {
		@SuppressWarnings("unchecked") T marker = (T) "...";
		return abbreviate(cs, marker, 0, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence in the middle.
	 * @param cs the char sequence to abbreviate
	 * @param middle the middle char sequence
	 * @param length the length of the abbreviation
	 * @param <T> the type of the char sequence
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T abbreviateMiddle(T cs, T middle, int length) {
		if (!anyEmpty(cs, middle) && length < cs.length() && length >= middle.length() + 2) {
			int targetSting = length - middle.length();
			int startOffset = targetSting / 2 + targetSting % 2;
			int endOffset = cs.length() - targetSting / 2;

			@SuppressWarnings("unchecked") T result = (T) (cs.subSequence(0, startOffset).toString() + middle + cs.subSequence(endOffset, cs.length()));
			return result;
		} else {
			return cs;
		}
	}

	/**
	 * Appends a suffix to a char sequence if it is missing.
	 * @param cs the char sequence to append the suffix to
	 * @param suffix the suffix to append
	 * @param suffixes the suffixes to check
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the suffix appended
	 */
	@SafeVarargs
	public static <T extends CharSequence> T appendIfMissing(T cs, T suffix, T... suffixes) {
		if (cs != null && !isNullOrEmpty(suffix) && !cs.toString().endsWith(suffix.toString())) {
			if (nonNull(suffixes)) {
				for (T s : suffixes) {
					if (cs.toString().endsWith(s.toString()))
						return cs;
				}
			}
			@SuppressWarnings("unchecked") T result = (T) (cs + suffix.toString());
			return result;
		} return cs;
	}

	/**
	 * Center a char sequence in a larger char sequence of space.
	 * @param cs the char sequence to center
	 * @param size the size of the char sequence to center in
	 * @param <T> the type of the char sequence
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T center(T cs, int size) {
		return center(cs, size, ' ');
	}

	/**
	 * Center a char sequence in a larger char sequence.
	 * @param cs the char sequence to center
	 * @param size the size of the char sequence to center in
	 * @param padChar the padding char
	 * @param <T> the type of the char sequence
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T center(T cs, int size, char padChar) {
		if (nonNull(cs) && size > 0) {
			int strLen = cs.length();
			int pads = size - strLen;
			if (pads <= 0) return cs;

			cs = leftPad(cs, strLen + pads / 2, padChar);
			cs = rightPad(cs, size, padChar);
		}
		return cs;
	}

	/**
	 * Center a char sequence in a larger char sequence.
	 * @param cs the char sequence to center
	 * @param size the size of the char sequence to center in
	 * @param padStr the padding char sequence
	 * @param <T> the type of the char sequence
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T center(T cs, int size, T padStr) {
		if (nonNull(cs) && size > 0) {
			if (isNullOrEmpty(padStr)) padStr = space();

			int strLen = cs.length();
			int pads = size - strLen;
			if (pads <= 0) return cs;

			cs = leftPad(cs, strLen + pads / 2, padStr);
			cs = rightPad(cs, size, padStr);
		}
		return cs;
	}

	/**
	 * Chomp a char sequence.
	 * @param cs the char sequence to chomp
	 * @param <T> the type of the char sequence
	 * @return the chomped char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T chomp(T cs) {
		if (isNullOrEmpty(cs)) return cs;
		if (cs.length() == 1) {
			char ch = cs.charAt(0);
			return ch != '\r' && ch != '\n' ? cs : empty();
		}
		int lastIdx = cs.length() - 1;
		char last = cs.charAt(lastIdx);
		if (last == '\n') {
			if (cs.charAt(lastIdx - 1) == '\r') --lastIdx;
		} else if (last != '\r') ++lastIdx;

		@SuppressWarnings("unchecked") T result = (T) cs.subSequence(0, lastIdx);
		return result;
	}

	/**
	 * Chop a char sequence.
	 * @param cs the char sequence to chop
	 * @param <T> the type of the char sequence
	 * @return the choped char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T chop(T cs) {
		if (isNull(cs)) return null;

		int strLen = cs.length();
		if (strLen < 2) return empty();

		int lastIdx = strLen - 1;
		CharSequence ret = cs.subSequence(0, lastIdx);
		char last = cs.charAt(lastIdx);

		@SuppressWarnings("unchecked") T result = (T) (last == '\n' && ret.charAt(lastIdx - 1) == '\r' ? ret.subSequence(0, lastIdx - 1) : ret);
		return result;
	}

	/**
	 * Checks if a given char sequence contains all the given chars.
	 * @param cs the char sequence to check
	 * @param searchChars the chars to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains all the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsAll(T cs, char... searchChars) {
		if (isNullOrEmpty(cs)) return false;
		for (char ch : searchChars) {
			if (cs.toString().indexOf(ch) < 0) return false;
		} return true;
	}

	/**
	 * Checks if a given char sequence contains all the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains all the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean containsAll(T cs, T... searchCharSequences) {
		if (isNullOrEmpty(cs)) return false;
		for (CharSequence searchCharSequence : searchCharSequences) {
			if (!cs.toString().contains(searchCharSequence.toString())) return false;
		} return true;
	}

	/**
	 * Checks if a given char sequence contains all the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param searchCharSequence the char sequence to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains all the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsAll(T cs, T searchCharSequence) {
		if (isNullOrEmpty(cs)) return false;
		for (int i = 0; i < searchCharSequence.length(); i++) {
			if (cs.toString().indexOf(searchCharSequence.charAt(i)) < 0) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains any of the given chars.
	 * @param cs the char sequence to check
	 * @param searchChars the chars to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains any of the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsAny(T cs, char...searchChars) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			char ch = cs.charAt(i);
			for (char searchChar : searchChars) {
				if (searchChar == ch) return true;
			}
		} return false;
	}

	/**
	 * Checks if a given char sequence contains any of the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains any of the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean containsAny(T cs, T... searchCharSequences) {
		if (isNullOrEmpty(cs)) return false;
		for (CharSequence searchCharSequence : searchCharSequences) {
			if (cs.toString().contains(searchCharSequence)) return true;
		}
		return false;
	}

	/**
	 * Checks if a given char sequence contains any of the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param searchCharSequence the char sequence to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains any of the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsAny(T cs, T searchCharSequence) {
		if (isNullOrEmpty(cs)) return false;
		for (int i = 0; i < searchCharSequence.length(); i++) {
			if (cs.toString().indexOf(searchCharSequence.charAt(i)) >= 0) return true;
		} return false;
	}

	/**
	 * Checks if a given char sequence contains none of the given chars.
	 * @param cs the char sequence to check
	 * @param searchChars the chars to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains none of the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsNone(T cs, char... searchChars) {
		return !containsAny(cs, searchChars);
	}

	/**
	 * Checks if a given char sequence contains none of the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains none of the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean containsNone(T cs, T... searchCharSequences) {
		return !containsAny(cs, searchCharSequences);
	}

	/**
	 * Checks if a given char sequence contains none of the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param searchCharSequence the char sequence to search for
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains none of the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsNone(T cs, T searchCharSequence) {
		return !containsAny(cs, searchCharSequence);
	}

	/**
	 * Checks if a given char sequence contains only the given chars.
	 * @param cs the char sequence to check
	 * @param valid the valid chars
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains only the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsOnly(T cs, char... valid) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			boolean contains = false;
			char ch = cs.charAt(i);
			for (char c : valid) {
				if (c == ch) {
					contains = true;
					break;
				}
			} if (!contains) return false;
		} return true;
	}

	/**
	 * Checks if a given char sequence contains only the given char sequences.
	 * @param cs the char sequence to check
	 * @param valid the valid char sequences
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains only the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> boolean containsOnly(T cs, T... valid) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			boolean contains = false;
			char ch = cs.charAt(i);
			for (CharSequence c : valid) {
				if (c.toString().indexOf(ch) >= 0) {
					contains = true;
					break;
				}
			} if (!contains) return false;
		} return true;
	}

	/**
	 * Checks if a given char sequence contains only the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param valid the valid char sequence
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains only the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsOnly(T cs, T valid) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			if (valid.toString().indexOf(cs.charAt(i)) < 0) return false;
		} return true;
	}

	/**
	 * Checks if a given char sequence contains whitespaces.
	 * @param cs the char sequence to check
	 * @param <T> the type of the char sequence
	 * @return {@code true} if the char sequence contains only whitespace, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> boolean containsWhitespace(T cs) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			if (Character.isWhitespace(cs.charAt(i))) return true;
		} return false;
	}

	/**
	 * Counts the number of occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param c the char to count
	 * @param <T> the type of the char sequence
	 * @return the number of occurrences of the char in the char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> int countMatches(T cs, char c) {
		int count = 0;
		for (int i = 0; i < requireNonNull(cs).length(); i++) {
			if (cs.charAt(i) == c) count++;
		} return count;
	}

	/**
	 * Counts the number of occurrences of a chars in a char sequence.
	 * @param cs the char sequence to check
	 * @param chars the chars to count
	 * @param <T> the type of the char sequence
	 * @return the array with the numbers of occurrences of the char in the char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> int[] countMatches(T cs, char... chars) {
		int[] counts = new int[requireNonNull(chars).length];
		for (int i = 0; i < chars.length; i++) {
			counts[i] = countMatches(cs, chars[i]);
		} return counts;
	}

	/**
	 * Counts the number of occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param sub the char sequence to count
	 * @param <T> the type of the char sequence
	 * @return the number of occurrences of the char sequence in the char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> int countMatches(T cs, T sub) {
		int count = 0;
		int idx = 0;
		while ((idx = requireNonNull(cs).toString().indexOf(requireNonNull(sub).toString(), idx)) != -1) {
			count++;
			idx += sub.length();
		} return count;
	}

	/**
	 * Counts the number of occurrences of a char sequences in a char sequence.
	 * @param cs the char sequence to check
	 * @param subs the char sequences to count
	 * @param <T> the type of the char sequence
	 * @return the array with the numbers of occurrences of the char sequence in the char sequence
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends CharSequence> int[] countMatches(T cs, T... subs) {
		int[] counts = new int[requireNonNull(subs).length];
		for (int i = 0; i < subs.length; i++) {
			counts[i] = countMatches(cs, subs[i]);
		} return counts;
	}

	/**
	 * Repeat a char sequence.
	 * @param ch the char to repeat
	 * @param repeat the number of times to repeat
	 * @param <T> the type of the char sequence
	 * @return the repeated char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T repeat(char ch, int repeat) {
		if (repeat <= 0) return empty();
		char[] buffer = new char[repeat];
		Arrays.fill(buffer, ch);

		@SuppressWarnings("unchecked") T result = (T) new String(buffer);
		return result;
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param <T> the type of the char sequence
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T leftPad(T cs, int size) {
		return leftPad(cs, size, ' ');
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padChar the padding char
	 * @param <T> the type of the char sequence
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T leftPad(T cs, int size, char padChar) {
		if (isNull(cs)) return null;

		int pads = size - cs.length();
		if (pads <= 0) return cs;

		@SuppressWarnings("unchecked") T result2 = (T) repeat(padChar, pads).toString().concat(cs.toString());
		return pads > 8192 ? leftPad(cs, size, padChar) : result2;
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padCs the padding char sequence
	 * @param <T> the type of the char sequence
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T leftPad(T cs, int size, T padCs) {
		if (isNull(cs)) return null;

		if (isNullOrEmpty(padCs)) padCs = space();

		int padLen = padCs.length();
		int strLen = cs.length();
		int pads = size - strLen;
		if (pads <= 0) return cs;
		if (padLen == 1 && pads <= 8192) return leftPad(cs, size, padCs.charAt(0));
		if (pads == padLen) {
			@SuppressWarnings("unchecked") T result = (T) padCs.toString().concat(cs.toString());
			return result;
		} else if (pads < padLen) {
			@SuppressWarnings("unchecked") T result = (T) padCs.subSequence(0, pads).toString().concat(cs.toString());
			return result;
		}

		char[] padding = new char[pads];
		char[] padChars = padCs.toString().toCharArray();

		for(int i = 0; i < pads; ++i) {
			padding[i] = padChars[i % padLen];
		}

		@SuppressWarnings("unchecked") T result = (T) new String(padding).concat(cs.toString());
		return result;
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param <T> the type of the char sequence
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T rightPad(T cs, int size) {
		return rightPad(cs, size, ' ');
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padChar the padding char
	 * @param <T> the type of the char sequence
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T rightPad(T cs, int size, char padChar) {
		if (isNull(cs)) return null;

		int pads = size - cs.length();
		if (pads <= 0) return cs;

		@SuppressWarnings("unchecked") T result2 = (T) cs.toString().concat(repeat(padChar, pads).toString());
		return pads > 8192 ? rightPad(cs, size, padChar) : result2;
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padCs the padding char sequence
	 * @param <T> the type of the char sequence
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T rightPad(T cs, int size, T padCs) {
		if (isNull(cs)) return null;
		if (isNullOrEmpty(padCs)) padCs = empty();

		int padLen = padCs.length();
		int strLen = cs.length();
		int pads = size - strLen;
		if (pads <= 0) return cs;
		if (padLen == 1 && pads <= 8192) return rightPad(cs, size, padCs.charAt(0));
		if (pads == padLen) {
			@SuppressWarnings("unchecked") T result = (T) cs.toString().concat(padCs.toString());
			return result;
		} else if (pads < padLen) {
			@SuppressWarnings("unchecked") T result = (T) cs.toString().concat(padCs.subSequence(0, pads).toString());
			return result;
		}

		char[] padding = new char[pads];
		char[] padChars = padCs.toString().toCharArray();

		for(int i = 0; i < pads; ++i) {
			padding[i] = padChars[i % padLen];
		}

		@SuppressWarnings("unchecked") T result = (T) cs.toString().concat(new String(padding));
		return result;
	}

	/**
	 * Replace all occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param searchChar the char to search for
	 * @param replaceChar the char to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, char searchChar, char replaceChar) {
		if (isNull(cs)) return null;

		@SuppressWarnings("unchecked") T result = (T) cs.toString().replace(searchChar, replaceChar);
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replaceChar the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, T search, char replaceChar) {
		if (isNull(cs)) return null;

		@SuppressWarnings("unchecked") T result = (T) cs.toString().replace(search, String.valueOf(replaceChar));
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replaceChar the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, char[] search, char replaceChar) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (char s : search) {
			str = str.replace(s, replaceChar);
		}

		@SuppressWarnings("unchecked") T result = (T) str;
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, T[] search, char replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (CharSequence s : search) {
			str = str.replace(s, String.valueOf(replace));
		}

		@SuppressWarnings("unchecked") T result = (T) str;
		return result;
	}

	/**
	 * Replace all occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param searchChar the char to search for
	 * @param replace the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, char searchChar, T replace) {
		if (isNull(cs)) return null;

		@SuppressWarnings("unchecked") T result = (T) cs.toString().replace(String.valueOf(searchChar), replace);
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, T search, T replace) {
		if (isNull(cs)) return null;

		@SuppressWarnings("unchecked") T result = (T) cs.toString().replace(search, replace);
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, char[] search, T replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (char s : search) str = str.replace(String.valueOf(s), replace);

		@SuppressWarnings("unchecked") T result = (T) str;
		return result;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @param <T> the type of the char sequence
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static <T extends CharSequence> T replace(T cs, T[] search, T replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (T s : search) str = str.replace(s, replace);

		@SuppressWarnings("unchecked") T result = (T) str;
		return result;
	}

	/**
	 * Capitalize a char sequence.
	 * @param cs the char sequence to capitalize
	 * @param <T> the type of the char sequence
	 * @return the capitalized char sequence
	 * @since 1.2.0
	 */
	public static <T extends CharSequence> T capitalize(T cs) {
		if (isNullOrEmpty(cs)) return cs;

		@SuppressWarnings("unchecked") T result = (T) (String.valueOf(Character.toTitleCase(cs.charAt(0))) + cs.subSequence(1, cs.length()));
		return result;
	}

	/**
	 * Reverse a char sequence.
	 * @param cs the char sequence to reverse
	 * @param <T> the type of the char sequence
	 * @return the reversed char sequence
	 * @since 1.2.0
	 */
	public static <T extends CharSequence> T reverse (T cs) {
		if (isNullOrEmpty(cs)) return cs;
		int length = cs.length();
		if (length <= 1) return cs;
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[length - i - 1] = cs.charAt(i);
		}

		@SuppressWarnings("unchecked") T result = (T) new String(chars);
		return result;
	}

	/**
	 * Join a char sequence with a delimiter.
	 * @param delimiter the delimiter
	 * @param elements the elements to join
	 * @param <T> the type of the char sequence
	 * @return the joined char sequence
	 * @since 1.2.0
	 */
	public static <T extends CharSequence> T join(Object delimiter, Object... elements) {
		if (isNull(delimiter) || isNull(elements) || elements.length == 0) return empty();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.length; i++) {
			if (i > 0) sb.append(delimiter);
			sb.append(elements[i].toString());
		}

		@SuppressWarnings("unchecked") T result = (T) sb.toString();
		return result;
	}

	/**
	 * Join a char sequence with a delimiter.
	 * @param delimiter the delimiter
	 * @param elements the elements to join
	 * @param <T> the type of the char sequence
	 * @return the joined char sequence
	 * @since 1.2.0
	 */
	public static <T extends CharSequence> T join(Object delimiter, Iterable<?> elements) {
		if (isNull(delimiter) || isNull(elements)) return empty();
		StringBuilder sb = new StringBuilder();
		Iterator<?> it = elements.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext()) sb.append(delimiter);
		}

		@SuppressWarnings("unchecked") T result = (T) sb.toString();
		return result;
	}
}