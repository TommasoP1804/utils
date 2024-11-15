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
public abstract class CharSequenceUtils {
	/**
	 * The space-only char sequence.
	 */
	public static final CharSequence SPACE_CS = " ";
	/**
	 * The space-only string.
	 */
	public static final String SPACE = " ";
	/**
	 * The empty-only char sequence.
	 */
	public static final CharSequence EMPTY_CS = "";
	/**
	 * The empty-only string.
	 */
	public static final String EMPTY = "";
	/**
	 * The tab-only char sequence.
	 */
	public static final CharSequence TAB_CS = "\t";
	/**
	 * The tab-only string.
	 */
	public static final String TAB = "\t";

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @return the given char sequence if it is not null and not empty
	 * @throws IllegalArgumentException if the default char sequence is null or empty
	 * @since 1.0.0
	 */
	public static CharSequence requireNonEmpty(CharSequence cs) {
		if (isNullOrEmpty(cs)) throw new IllegalArgumentException();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param message the message of the exception
	 * @return the given char sequence if it is not null and not empty
	 * @throws IllegalArgumentException if the default char sequence is null or empty
	 * @since 1.0.0
	 */
	public static CharSequence requireNonEmpty(CharSequence cs, String message) {
		if (isNullOrEmpty(cs)) throw new IllegalArgumentException(message);
		return cs;
	}

	/**
	 * Return the given char sequence if it is not null and not empty, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param exceptionSupplier the supplier of the exception
	 * @param <X> the type of the exception
	 * @return the given char sequence if it is not null and not empty
	 * @throws X if the default char sequence is null or empty
	 * @since 1.4.0
	 */
	public static <X extends Throwable> CharSequence requireNonEmptyElseThrow(CharSequence cs, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrEmpty(cs)) throw requireNonNull(exceptionSupplier).get();
		return cs;
	}


	/**
	 * Return the given char sequence if it is not null and not empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @return the given char sequence if it is not null and not empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static CharSequence requireNonEmptyElse(CharSequence cs, CharSequence defaultCs) {
		return isNotEmpty(cs) ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is null or empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @return the given char sequence if it is null or empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static CharSequence requireNullOrEmptyElse(CharSequence cs, CharSequence defaultCs) {
		return isNullOrEmpty(cs) ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @return the given char sequence if it is not blank and not empty
	 * @throws IllegalArgumentException if the default char sequence is blank
	 * @since 1.0.0
	 */
	public static CharSequence requireNonBlank(CharSequence cs) {
		if (requireNonNull(cs).toString().isBlank()) throw new IllegalArgumentException();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param message the message of the exception
	 * @return the given char sequence if it is not blank
	 * @throws IllegalArgumentException if the default char sequence is blank
	 * @since 1.0.0
	 */
	public static CharSequence requireNonBlank(CharSequence cs, String message) {
		if (requireNonNull(cs).toString().isBlank()) throw new IllegalArgumentException(message);
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise throw an exception.
	 * @param cs the char sequence to check
	 * @param exceptionSupplier the supplier of the exception
	 * @param <X> the type of the exception
	 * @return the given char sequence if it is not blank
	 * @throws X if the default char sequence is blank
	 * @since 1.4.0
	 */
	public static <X extends Throwable> CharSequence requireNonBlankElseThrow(CharSequence cs, Supplier<X> exceptionSupplier) throws X {
		if (requireNonNull(cs).toString().isBlank()) throw requireNonNull(exceptionSupplier).get();
		return cs;
	}

	/**
	 * Return the given char sequence if it is not blank, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @return the given char sequence if it is not blank, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static CharSequence requireNonBlankElse(CharSequence cs, CharSequence defaultCs) {
		return !requireNonNull(cs).toString().isBlank() ? cs : defaultCs;
	}

	/**
	 * Return the given char sequence if it is null or empty, otherwise return the default char sequence.
	 * @param cs the char sequence to check
	 * @param defaultCs the default char sequence
	 * @return the given char sequence if it is null or empty, the default char sequence otherwise
	 * @since 1.0.0
	 */
	public static CharSequence requireBlankElse(CharSequence cs, CharSequence defaultCs) {
		return !requireNonNull(cs).toString().isBlank() ? cs : defaultCs;
	}

	/**
	 * Checks if a given string is null, empty, or only contains whitespace.
	 *
	 * @param cs the string to check
	 * @return {@code true} if the string is null, empty, or only contains whitespace, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrBlank(CharSequence cs) {
		return isNullOrEmpty(cs) || cs.chars().allMatch(Character::isWhitespace);
	}

	/**
	 * Checks if a given string is not null, not empty, and not only contains whitespace.
	 *
	 * @param cs the string to check
	 * @return {@code true} if the string is not null, not empty, and not only contains whitespace, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotBlank(CharSequence cs) {
		return !isNullOrBlank(cs);
	}

	/**
	 * Checks if given char sequences is all null or blank.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all null or blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNullOrBlank(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is blank.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNullOrBlank(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrBlank);
	}

	/**
	 * Checks if given char sequences is blank and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNullOrBlank(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrBlank(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all not null or blank.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all not null or blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNotBlank(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNotBlank);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not blank.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is not blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNotBlank(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNotBlank);
	}

	/**
	 * Checks if given char sequences is not blank and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not null or blank, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNotBlank(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) result[i] = isNotBlank(css[i]);
		return result;
	}

	/**
	 * Checks if a given string is null or empty.
	 *
	 * @param cs the string to check
	 * @return {@code true} if the string is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(CharSequence cs) {
		return isNull(cs) || cs.isEmpty();
	}

	/**
	 * Checks if a given char sequence is not null and not empty.
	 *
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is not null and not empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(CharSequence cs) {
		return !isNullOrEmpty(cs);
	}

	/**
	 * Checks if given char sequences is all null or empty.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNullOrEmpty(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNullOrEmpty(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNullOrEmpty);
	}

	/**
	 * Checks if given char sequences is null or empty and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNullOrEmpty(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNullOrEmpty(css[i]);
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all empty.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllEmpty(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is empty.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyEmpty(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequence::isEmpty);
	}

	/**
	 * Checks if given char sequences is empty and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachEmpty(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = css[i].isEmpty();
		}
		return result;
	}

	/**
	 * Checks if given char sequences is all not null or empty.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNotEmpty(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNotEmpty);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is not empty.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is not empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNotEmpty(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNotEmpty);
	}

	/**
	 * Checks if given char sequences is not empty and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is not empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNotEmpty(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNotEmpty(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is all lower case.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is all lower case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isLowerCase(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(Character::isLowerCase);
	}

	/**
	 * Checks if given char sequences is all lower case.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all lower case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllLowerCase(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is lower case.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is lower case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyLowerCase(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isLowerCase);
	}

	/**
	 * Checks if given char sequences is lower case and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is lower case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachLowerCase(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isLowerCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is all upper case.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is all upper case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isUpperCase(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(Character::isUpperCase);
	}

	/**
	 * Checks if given char sequences is all upper case.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are all upper case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllUpperCase(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is upper case.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is upper case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyUpperCase(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isUpperCase);
	}

	/**
	 * Checks if given char sequences is upper case and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is upper case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachUpperCase(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isUpperCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is mixed case.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isMixedCase(CharSequence cs) {
		return isNotEmpty(cs) && !isLowerCase(cs) && !isUpperCase(cs);
	}

	/**
	 * Checks if given char sequences is mixed case.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are mixed case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllMixedCase(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isMixedCase);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is mixed case.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyMixedCase(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isMixedCase);
	}

	/**
	 * Checks if given char sequences is mixed case and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is mixed case, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachMixedCase(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isMixedCase(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphabetic.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAlphabetic(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(Character::isLetter);
	}

	/**
	 * Checks if given char sequences is alphabetic.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllAlphabetic(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyAlphabetic(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabetic);
	}

	/**
	 * Checks if given char sequences is alphabetic and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachAlphabetic(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabetic(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphabetic or space.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAlphabeticSpace(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(c -> Character.isLetter(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is alphabetic or space.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllAlphabeticSpace(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphabetic or space.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyAlphabeticSpace(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphabeticSpace);
	}

	/**
	 * Checks if given char sequences is alphabetic or space and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphabetic or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachAlphabeticSpace(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphabeticSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphanumeric.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAlphanumeric(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(Character::isLetterOrDigit);
	}

	/**
	 * Checks if given char sequences is alphanumeric.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllAlphanumeric(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 */

	public static boolean isAnyAlphanumeric(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumeric);
	}

	/**
	 * Checks if given char sequences is alphanumeric and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachAlphanumeric(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is alphanumeric or space.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAlphanumericSpace(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is alphanumeric or space.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllAlphanumericSpace(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is alphanumeric or space.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyAlphanumericSpace(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isAlphanumericSpace);
	}

	/**
	 * Checks if given char sequences is alphanumeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is alphanumeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachAlphanumericSpace(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isAlphanumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is numeric.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNumeric(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(Character::isDigit);
	}

	/**
	 * Checks if given char sequences is numeric.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are numeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNumeric(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNumeric(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumeric);
	}

	/**
	 * Checks if given char sequences is numeric and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNumeric(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumeric(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is numeric or space.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNumericSpace(CharSequence cs) {
		return isNotEmpty(cs) && cs.chars().allMatch(c -> Character.isDigit(c) || Character.isWhitespace(c));
	}

	/**
	 * Checks if given char sequences is numeric or space.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllNumericSpace(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is numeric or space.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyNumericSpace(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isNumericSpace);
	}

	/**
	 * Checks if given char sequences is numeric or space and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is numeric or space, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachNumericSpace(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isNumericSpace(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is a valid email.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmail(CharSequence cs) {
		return isNotEmpty(cs) && Pattern.compile("^([\\w-.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", CASE_INSENSITIVE).matcher(cs).matches();
	}

	/**
	 * Checks if given char sequences is a valid email.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are valid emails, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllEmail(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid email.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyEmail(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isEmail);
	}

	/**
	 * Checks if given char sequences is a valid email and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid email, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachEmail(CharSequence... css) {
		boolean[] result = new boolean[requireNonNull(css).length];
		for (int i = 0; i < css.length; i++) {
			result[i] = isEmail(css[i]);
		}
		return result;
	}

	/**
	 * Checks if a given char sequence is a valid URL.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isURL(CharSequence cs) {
		return isNotEmpty(cs) && Pattern.compile("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", CASE_INSENSITIVE).matcher(cs).matches();
	}

	/**
	 * Checks if given char sequences is a valid URL.
	 * @param css the char sequences to check
	 * @return {@code true} if all char sequences are valid URLs, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAllURL(CharSequence... css) {
		return Arrays.stream(css).allMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if in the given char sequences there is at least one char sequence is a valid URL.
	 * @param css the char sequences to check
	 * @return {@code true} if at least one char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAnyURL(CharSequence... css) {
		return Arrays.stream(css).anyMatch(CharSequenceUtils::isURL);
	}

	/**
	 * Checks if given char sequences is a valid URL and put the result in an array.
	 * @param css the char sequences to check
	 * @return an array of booleans where each element is {@code true} if the corresponding char sequence is a valid URL, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean[] isEachURL(CharSequence... css) {
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
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence abbreviate(CharSequence cs, CharSequence abbrevMarker, int offset, int maxWidth) {
		if (isNotEmpty(cs) && EMPTY_CS.equals(abbrevMarker) && maxWidth > 0)
			return cs.subSequence(0, maxWidth);
		if (isAnyEmpty(cs, abbrevMarker)) return cs;

		int abbrevMarkerLength = abbrevMarker.length();
		int minAbbrevWidth = abbrevMarkerLength + 1;
		int minAbbrevWidthOffset = abbrevMarkerLength + abbrevMarkerLength + 1;
		if (maxWidth < minAbbrevWidth) throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", minAbbrevWidth));

		int csLen = cs.length();
		if (csLen <= maxWidth) return cs;

		if (offset > csLen) offset = csLen;

		if (csLen - offset < maxWidth - abbrevMarkerLength)
			offset = csLen - (maxWidth - abbrevMarkerLength);

		if (offset <= abbrevMarkerLength + 1)
			return cs.subSequence(0, maxWidth - abbrevMarkerLength).toString() + abbrevMarker;
		if (maxWidth < minAbbrevWidthOffset)
			throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", minAbbrevWidthOffset));
		return offset + maxWidth - abbrevMarkerLength < csLen
				? abbrevMarker.toString() + abbreviate(cs.subSequence(offset, cs.length()), abbrevMarker, maxWidth - abbrevMarkerLength)
				: abbrevMarker.toString() + cs.subSequence(csLen - (maxWidth - abbrevMarkerLength), cs.length());
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param offset the offset of the abbreviation
	 * @param maxWidth the maximum width of the abbreviation
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence abbreviate(CharSequence cs, int offset, int maxWidth) {
		return abbreviate(cs, "...", offset, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param abbrevMarker the abbreviation marker
	 * @param maxWidth the maximum width of the abbreviation
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence abbreviate(CharSequence cs, CharSequence abbrevMarker, int maxWidth) {
		return abbreviate(cs, abbrevMarker, 0, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence.
	 * @param cs the char sequence to abbreviate
	 * @param maxWidth the maximum width of the abbreviation
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence abbreviate(CharSequence cs, int maxWidth) {
		return abbreviate(cs, "...", 0, maxWidth);
	}

	/**
	 * Abbreviate a given char sequence in the middle.
	 * @param cs the char sequence to abbreviate
	 * @param middle the middle char sequence
	 * @param length the length of the abbreviation
	 * @return the abbreviated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence abbreviateMiddle(CharSequence cs, CharSequence middle, int length) {
		if (!isAnyEmpty(cs, middle) && length < cs.length() && length >= middle.length() + 2) {
			int targetSting = length - middle.length();
			int startOffset = targetSting / 2 + targetSting % 2;
			int endOffset = cs.length() - targetSting / 2;
			return cs.subSequence(0, startOffset).toString() + middle + cs.subSequence(endOffset, cs.length());
		} else {
			return cs;
		}
	}

	/**
	 * Appends a suffix to a char sequence if it is missing.
	 * @param cs the char sequence to append the suffix to
	 * @param suffix the suffix to append
	* @param suffixes the suffixes to check
	 * @return the char sequence with the suffix appended
	 */
	public static CharSequence appendIfMissing(CharSequence cs, CharSequence suffix, CharSequence... suffixes) {
		if (cs != null && !isNullOrEmpty(suffix) && !cs.toString().endsWith(suffix.toString())) {
			if (nonNull(suffixes)) {
				for (CharSequence s : suffixes) {
					if (cs.toString().endsWith(s.toString()))
						return cs;
				}
			} return cs + suffix.toString();
		} return cs;
	}

	/**
	 * Center a char sequence in a larger char sequence of space.
	 * @param cs the char sequence to center
	 * @param size the size of the char sequence to center in
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static CharSequence center(CharSequence cs, int size) {
		return center(cs, size, ' ');
	}

	/**
	 * Center a char sequence in a larger char sequence.
	 * @param cs the char sequence to center
	 * @param size the size of the char sequence to center in
	 * @param padChar the padding char
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static CharSequence center(CharSequence cs, int size, char padChar) {
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
	 * @return the centered char sequence
	 * @since 1.0.0
	 */
	public static CharSequence center(CharSequence cs, int size, CharSequence padStr) {
		if (nonNull(cs) && size > 0) {
			if (isNullOrEmpty(padStr)) padStr = SPACE_CS;

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
	 * @return the chomped char sequence
	 * @since 1.0.0
	 */
	public static CharSequence chomp(CharSequence cs) {
		if (isNullOrEmpty(cs)) return cs;
		if (cs.length() == 1) {
			char ch = cs.charAt(0);
			return ch != '\r' && ch != '\n' ? cs : EMPTY_CS;
		}
		int lastIdx = cs.length() - 1;
		char last = cs.charAt(lastIdx);
		if (last == '\n') {
			if (cs.charAt(lastIdx - 1) == '\r') --lastIdx;
		} else if (last != '\r') ++lastIdx;

		return cs.subSequence(0, lastIdx);
	}

	/**
	 * Chop a char sequence.
	 * @param cs the char sequence to chop
	 * @return the choped char sequence
	 * @since 1.0.0
	 */
	public static CharSequence chop(CharSequence cs) {
		if (isNull(cs)) return null;

		int strLen = cs.length();
		if (strLen < 2) return EMPTY_CS;

		int lastIdx = strLen - 1;
		CharSequence ret = cs.subSequence(0, lastIdx);
		char last = cs.charAt(lastIdx);
		return last == '\n' && ret.charAt(lastIdx - 1) == '\r' ? ret.subSequence(0, lastIdx - 1) : ret;
	}

	/**
	 * Checks if a given char sequence contains all the given chars.
	 * @param cs the char sequence to check
	 * @param searchChars the chars to search for
	 * @return {@code true} if the char sequence contains all the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAll(CharSequence cs, char... searchChars) {
		if (isNullOrEmpty(cs)) return false;
		for (char ch : searchChars) {
			if (cs.toString().indexOf(ch) < 0) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains all the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @return {@code true} if the char sequence contains all the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAll(CharSequence cs, CharSequence... searchCharSequences) {
		if (isNullOrEmpty(cs)) return false;
		for (CharSequence searchCharSequence : searchCharSequences) {
			if (!cs.toString().contains(searchCharSequence.toString())) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains all the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param searchCharSequence the char sequence to search for
	 * @return {@code true} if the char sequence contains all the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAll(CharSequence cs, CharSequence searchCharSequence) {
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
	 * @return {@code true} if the char sequence contains any of the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAny(CharSequence cs, char...searchChars) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			char ch = cs.charAt(i);
			for (char searchChar : searchChars) {
				if (searchChar == ch) return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a given char sequence contains any of the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @return {@code true} if the char sequence contains any of the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAny(CharSequence cs, CharSequence... searchCharSequences) {
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
	 * @return {@code true} if the char sequence contains any of the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsAny(CharSequence cs, CharSequence searchCharSequence) {
		if (isNullOrEmpty(cs)) return false;
		for (int i = 0; i < searchCharSequence.length(); i++) {
			if (cs.toString().indexOf(searchCharSequence.charAt(i)) >= 0) return true;
		}
		return false;
	}

	/**
	 * Checks if a given char sequence contains none of the given chars.
	 * @param cs the char sequence to check
	 * @param searchChars the chars to search for
	 * @return {@code true} if the char sequence contains none of the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsNone(CharSequence cs, char... searchChars) {
		return !containsAny(cs, searchChars);
	}

	/**
	 * Checks if a given char sequence contains none of the given char sequences.
	 * @param cs the char sequence to check
	 * @param searchCharSequences the char sequences to search for
	 * @return {@code true} if the char sequence contains none of the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsNone(CharSequence cs, CharSequence... searchCharSequences) {
		return !containsAny(cs, searchCharSequences);
	}

	/**
	 * Checks if a given char sequence contains none of the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param searchCharSequence the char sequence to search for
	 * @return {@code true} if the char sequence contains none of the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsNone(CharSequence cs, CharSequence searchCharSequence) {
		return !containsAny(cs, searchCharSequence);
	}

	/**
	 * Checks if a given char sequence contains only the given chars.
	 * @param cs the char sequence to check
	 * @param valid the valid chars
	 * @return {@code true} if the char sequence contains only the given chars, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsOnly(CharSequence cs, char... valid) {
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
			}
			if (!contains) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains only the given char sequences.
	 * @param cs the char sequence to check
	 * @param valid the valid char sequences
	 * @return {@code true} if the char sequence contains only the given char sequences, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsOnly(CharSequence cs, CharSequence... valid) {
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
			}
			if (!contains) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains only the given character of the char sequence.
	 * @param cs the char sequence to check
	 * @param valid the valid char sequence
	 * @return {@code true} if the char sequence contains only the given character of the char sequence, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsOnly(CharSequence cs, CharSequence valid) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			if (valid.toString().indexOf(cs.charAt(i)) < 0) return false;
		}
		return true;
	}

	/**
	 * Checks if a given char sequence contains whitespaces.
	 * @param cs the char sequence to check
	 * @return {@code true} if the char sequence contains only whitespace, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean containsWhitespace(CharSequence cs) {
		if (isNullOrEmpty(cs)) return false;
		int csLen = cs.length();
		for (int i = 0; i < csLen; i++) {
			if (Character.isWhitespace(cs.charAt(i))) return true;
		}
		return false;
	}

	/**
	 * Counts the number of occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param c the char to count
	 * @return the number of occurrences of the char in the char sequence
	 * @since 1.0.0
	 */
	public static int countMatches(CharSequence cs, char c) {
		int count = 0;
		for (int i = 0; i < requireNonNull(cs).length(); i++) {
			if (cs.charAt(i) == c) count++;
		}
		return count;
	}

	/**
	 * Counts the number of occurrences of a chars in a char sequence.
	 * @param cs the char sequence to check
	 * @param chars the chars to count
	 * @return the array with the numbers of occurrences of the char in the char sequence
	 * @since 1.0.0
	 */
	public static int[] countMatches(CharSequence cs, char... chars) {
		int[] counts = new int[requireNonNull(chars).length];
		for (int i = 0; i < chars.length; i++) {
			counts[i] = countMatches(cs, chars[i]);
		}
		return counts;
	}

	/**
	 * Counts the number of occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param sub the char sequence to count
	 * @return the number of occurrences of the char sequence in the char sequence
	 * @since 1.0.0
	 */
	public static int countMatches(CharSequence cs, CharSequence sub) {
		int count = 0;
		int idx = 0;
		while ((idx = requireNonNull(cs).toString().indexOf(requireNonNull(sub).toString(), idx)) != -1) {
			count++;
			idx += sub.length();
		}
		return count;
	}

	/**
	 * Counts the number of occurrences of a char sequences in a char sequence.
	 * @param cs the char sequence to check
	 * @param subs the char sequences to count
	 * @return the array with the numbers of occurrences of the char sequence in the char sequence
	 * @since 1.0.0
	 */
	public static int[] countMatches(CharSequence cs, CharSequence... subs) {
		int[] counts = new int[requireNonNull(subs).length];
		for (int i = 0; i < subs.length; i++) {
			counts[i] = countMatches(cs, subs[i]);
		}
		return counts;
	}

	/**
	 * Repeat a char sequence.
	 * @param ch the char to repeat
	 * @param repeat the number of times to repeat
	 * @return the repeated char sequence
	 * @since 1.0.0
	 */
	public static CharSequence repeat(char ch, int repeat) {
		if (repeat <= 0) return EMPTY_CS;
		char[] buffer = new char[repeat];
		Arrays.fill(buffer, ch);
		return new String(buffer);
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence leftPad(CharSequence cs, int size) {
		return leftPad(cs, size, ' ');
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padChar the padding char
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence leftPad(CharSequence cs, int size, char padChar) {
		if (isNull(cs)) return null;

		int pads = size - cs.length();
		if (pads <= 0) return cs;
		return pads > 8192 ? leftPad(cs, size, String.valueOf(padChar)) : repeat(padChar, pads).toString().concat(cs.toString());
	}

	/**
	 * Left pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padCs the padding char sequence
	 * @return the left padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence leftPad(CharSequence cs, int size, CharSequence padCs) {
		if (isNull(cs)) return null;

		if (isNullOrEmpty(padCs)) padCs = SPACE_CS;

		int padLen = padCs.length();
		int strLen = cs.length();
		int pads = size - strLen;
		if (pads <= 0) return cs;
		if (padLen == 1 && pads <= 8192) return leftPad(cs, size, padCs.charAt(0));
		if (pads == padLen) return padCs.toString().concat(cs.toString());
		if (pads < padLen) return padCs.toString().substring(0, pads).concat(cs.toString());

		char[] padding = new char[pads];
		char[] padChars = padCs.toString().toCharArray();

		for(int i = 0; i < pads; ++i) {
			padding[i] = padChars[i % padLen];
		}

		return (new String(padding)).concat(cs.toString());
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence rightPad(CharSequence cs, int size) {
		return rightPad(cs, size, ' ');
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padChar the padding char
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence rightPad(CharSequence cs, int size, char padChar) {
		if (isNull(cs)) return null;

		int pads = size - cs.length();
		if (pads <= 0) return cs;

		return pads > 8192 ? rightPad(cs, size, String.valueOf(padChar)) : cs.toString().concat(repeat(padChar, pads).toString());
	}

	/**
	 * Right pad of a char sequence.
	 * @param cs the char sequence to pad
	 * @param size the size of the padding
	 * @param padCs the padding char sequence
	 * @return the right padded char sequence
	 * @since 1.0.0
	 */
	public static CharSequence rightPad(CharSequence cs, int size, CharSequence padCs) {
		if (isNull(cs)) return null;
		if (isNullOrEmpty(padCs)) padCs = EMPTY_CS;

		int padLen = padCs.length();
		int strLen = cs.length();
		int pads = size - strLen;
		if (pads <= 0) return cs;
		if (padLen == 1 && pads <= 8192) return rightPad(cs, size, padCs.charAt(0));
		if (pads == padLen) return cs.toString().concat(padCs.toString());
		if (pads < padLen) return cs.toString().concat(padCs.subSequence(0, pads).toString());

		char[] padding = new char[pads];
		char[] padChars = padCs.toString().toCharArray();

		for(int i = 0; i < pads; ++i) {
			padding[i] = padChars[i % padLen];
		}

		return cs.toString().concat(new String(padding));
	}

	/**
	 * Replace all occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param searchChar the char to search for
	 * @param replaceChar the char to replace with
	 * @return the char sequence with the replaced char
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, char searchChar, char replaceChar) {
		if (isNull(cs)) return null;
		return cs.toString().replace(searchChar, replaceChar);
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replaceChar the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, CharSequence search, char replaceChar) {
		if (isNull(cs)) return null;
		return cs.toString().replace(search, String.valueOf(replaceChar));
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replaceChar the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, char[] search, char replaceChar) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (char s : search) {
			str = str.replace(s, replaceChar);
		}
		return str;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, CharSequence[] search, char replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (CharSequence s : search) {
			str = str.replace(s, String.valueOf(replace));
		}
		return str;
	}

	/**
	 * Replace all occurrences of a char in a char sequence.
	 * @param cs the char sequence to check
	 * @param searchChar the char to search for
	 * @param replace the char sequence to replace with
	 * @return the char sequence with the replaced char
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, char searchChar, CharSequence replace) {
		if (isNull(cs)) return null;
		return cs.toString().replace(String.valueOf(searchChar), replace);
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, CharSequence search, CharSequence replace) {
		if (isNull(cs)) return null;
		return cs.toString().replace(search, replace);
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, char[] search, CharSequence replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (char s : search) str = str.replace(String.valueOf(s), replace);
		return str;
	}

	/**
	 * Replace all occurrences of a char sequence in a char sequence.
	 * @param cs the char sequence to check
	 * @param search the char sequence to search for
	 * @param replace the char sequence to replace with
	 * @return the char sequence with the replaced char sequence
	 * @since 1.0.0
	 */
	public static CharSequence replace(CharSequence cs, CharSequence[] search, CharSequence replace) {
		if (isNull(cs) || isNull(search) || search.length == 0) return cs;
		String str = cs.toString();
		for (CharSequence s : search) str = str.replace(s, replace);
		return str;
	}

	/**
	 * Capitalize a char sequence.
	 * @param cs the char sequence to capitalize
	 * @return the capitalized char sequence
	 * @since 1.2.0
	 */
	public static CharSequence capitalize(CharSequence cs) {
		if (isNullOrEmpty(cs)) return cs;
		return String.valueOf(Character.toTitleCase(cs.charAt(0))) + cs.subSequence(1, cs.length());
	}

	/**
	 * Reverse a char sequence.
	 * @param cs the char sequence to reverse
	 * @return the reversed char sequence
	 * @since 1.2.0
	 */
	public static CharSequence reverse (CharSequence cs) {
		if (isNullOrEmpty(cs)) return cs;
		int length = cs.length();
		if (length <= 1) return cs;
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[length - i - 1] = cs.charAt(i);
		}
		return new String(chars);
	}

	/**
	 * Join a char sequence with a delimiter.
	 * @param delimiter the delimiter
	 * @param elements the elements to join
	 * @return the joined char sequence
	 * @since 1.2.0
	 */
	public static CharSequence join(Object delimiter, Object... elements) {
		if (isNull(delimiter) || isNull(elements) || elements.length == 0) return EMPTY_CS;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elements.length; i++) {
			if (i > 0) sb.append(delimiter);
			sb.append(elements[i].toString());
		}
		return sb;
	}

	/**
	 * Join a char sequence with a delimiter.
	 * @param delimiter the delimiter
	 * @param elements the elements to join
	 * @return the joined char sequence
	 * @since 1.2.0
	 */
	public static CharSequence join(Object delimiter, Iterable<?> elements) {
		if (isNull(delimiter) || isNull(elements)) return EMPTY_CS;
		StringBuilder sb = new StringBuilder();
		Iterator<?> it = elements.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext()) sb.append(delimiter);
		}
		return sb;
	}
}