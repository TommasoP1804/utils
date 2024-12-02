package net.tp.utils;

import java.util.Objects;

import static java.util.Objects.nonNull;

/**
 * Utility class for characters.
 *
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public abstract class CharUtils {
	/**
	 * The hexadecimal digits
	 */
	private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	/**
	 * The new-line character
	 */
	public static final char LF = '\n';
	/**
	 * The carriage return character
	 */
	public static final char CR = '\r';
	/**
	 * The nul character
	 */
	public static final char NUL = '\u0000';

	/**
	 * Compares two characters.
	 * @param x the first character
	 * @param y the second character
	 * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y}; and a value greater than {@code 0} if {@code x > y}
	 * @since 1.0.0
	 */
	public static int compare(char x, char y) {
		return x - y;
	}

	/**
	 * Checks if a character is Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAscii(char ch) {
		return ch < 128;
	}

	/**
	 * Checks if a character is alphabetic Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is alphabetic Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiAlpha(char ch) {
		return isAsciiAlphaUpper(ch) || isAsciiAlphaLower(ch);
	}

	/**
	 * Checks if a character is a lower-case alphabetic Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is a lower-case alphabetic Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiAlphaLower(char ch) {
		return ch >= 'a' && ch <= 'z';
	}

	/**
	 * Checks if a character is an alphanumeric Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is an alphanumeric Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiAlphanumeric(char ch) {
		return isAsciiAlpha(ch) || isAsciiNumeric(ch);
	}

	/**
	 * Checks if a character is an upper-case alphabetic Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is an upper-case alphabetic Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiAlphaUpper(char ch) {
		return ch >= 'A' && ch <= 'Z';
	}

	/**
	 * Checks if a character is a control Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is a control Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiControl(char ch) {
		return ch < ' ' || ch == 127;
	}

	/**
	 * Checks if a character is a digit Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is a digit Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiNumeric(char ch) {
		return ch >= '0' && ch <= '9';
	}

	/**
	 * Checks if a character is a printable Ascii.
	 * @param ch the character
	 * @return {@code true} if the character is a printable Ascii; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isAsciiPrintable(char ch) {
		return ch >= ' ' && ch < 127;
	}

	/**
	 * Transforms a Character into a char.
	 * @param ch the Character
	 * @return the char
	 * @since 1.0.0
	 */
	public static char toPrimitive(Character ch) {
		return (Character) Objects.requireNonNull(ch, "ch");
	}

	/**
	 * Transforms a Character into a char.
	 * @param ch the Character
	 * @param defaultValue the default value
	 * @return the char
	 * @since 1.0.0
	 */
	public static char toPrimitive(Character ch, char defaultValue) {
		return ch != null ? ch : defaultValue;
	}

	/**
	 * Transforms a char into a Character.
	 * @param ch the char
	 * @return the Character
	 * @since 1.0.0
	 */
	public static Character toWrapper(char ch) {
		return ch;
	}

	/**
	 * Transfrom a char into an int value.
	 * @param ch the char
	 * @return the int value
	 * @since 1.0.0
	 */
	public static int toIntValue(char ch) {
		if (!isAsciiNumeric(ch)) throw new IllegalArgumentException("The character " + ch + " is not in the range '0' - '9'");
		return ch - 48;
	}

	/**
	 * Transfrom a char into an int value.
	 * @param ch the char
	 * @param defaultValue the default value if the char is not an ascii numeric
	 * @return the int value
	 * @since 1.0.0
	 */
	public static int toIntValue(char ch, int defaultValue) {
		return isAsciiNumeric(ch) ? ch - 48 : defaultValue;
	}

	/**
	 * Transforms a Character into an int value.
	 * @param ch the Character
	 * @return the int value
	 * @since 1.0.0
	 */
	public static int toIntValue(Character ch) {
		return toIntValue(toPrimitive(ch));
	}

	/**
	 * Transforms a Character into an int value.
	 * @param ch the Character
	 * @param defaultValue the default value if the Character is null
	 * @return the int value
	 * @since 1.6.1
	 */
	public static int toIntValue(Character ch, int defaultValue) {
		return nonNull(ch) ? toIntValue(toPrimitive(ch), defaultValue) : defaultValue;
	}
}