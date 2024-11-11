package net.tp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

import static java.math.BigInteger.*;
import static java.util.Objects.isNull;

/**
 * A utility class for numbers.
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public abstract class NumberUtils {
	/**
	 * Checks if a given number is a non-decimal number.
	 *
	 * @param number the number to check
	 * @param classBased if the check should be based on the class of the number
	 * @return {@code true} if the number is a non-decimal number, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isNonDecimalNumber(T number, boolean classBased) {
		if (number instanceof Integer || number instanceof Long || number instanceof Short || number instanceof Byte || number instanceof BigInteger)
			return true;
		if (number instanceof Double) return !classBased && ((Double) number) % 1 == 0;
		if (number instanceof Float) return !classBased && ((Float) number) % 1 == 0;
		return false;
	}

	/**
	 * Checks if a given number is a non-decimal number (also a double or a float with .0 is non-decimal number, for classBased see {@link NumberUtils#isNonDecimalNumber(Number, boolean)}).
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is a non-decimal number, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isNonDecimalNumber(T number) {
		return isNonDecimalNumber(number, false);
	}

	/**
	 * Checks if a given number is a decimal number.
	 *
	 * @param number the number to check
	 * @param classBased if the check should be based on the class of the number
	 * @return {@code true} if the number is a decimal number, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isDecimalNumber(T number, boolean classBased) {
		if (number instanceof Double) return classBased || ((Double) number) % 1 != 0;
		if (number instanceof Float) return classBased || ((Float) number) % 1 != 0;
		if (number instanceof BigDecimal) return classBased || number.doubleValue() % 1 != 0;
		return false;
	}

	/**
	 * Checks if a given number is a decimal number (a double or a float with .0 is non-decimal number, for classBased see {@link NumberUtils#isDecimalNumber(Number, boolean)}).
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is a decimal number, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isDecimalNumber(T number) {
		return isDecimalNumber(number, false);
	}

	/**
	 * Checks if a given number is even. For decimal numbers the check is based on the floor of the number.
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is even, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isEven(T number) {
		if (number instanceof Integer || number instanceof Long || number instanceof Short || number instanceof Byte)
			return number.longValue() % 2 == 0;
		else if (number instanceof BigInteger)
			return ((BigInteger) number).mod(TWO).equals(ZERO);
		else if (number instanceof Double || number instanceof Float)
			return Math.floor(number.doubleValue()) % 2 == 0;
		else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}

	/**
	 * Checks if a given number is odd. For decimal numbers the check is based on the floor of the number.
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is odd, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isOdd(T number) {
		return !isEven(number);
	}

	/**
	 * Checks if a given number is prime.
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is prime, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T extends Number> boolean isPrime(T number) {
		if (isNonDecimalNumber(number)) {
			if (number.longValue() <= 1) return false;
			for (int i = 2; i <= Math.sqrt(number.longValue()); i++)
				if (number.longValue() % i == 0) return false;
			return true;
		} else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}

	/**
	 * Calculates the greatest common divisor of two numbers.
	 *
	 * @param a the first number
	 * @param b the second number
	 * @return the greatest common divisor of the two numbers
	 * @since 1.0.0
	 */
	public static <T1 extends Number, T2 extends Number> long gcd(T1 a, T2 b) {
		if (isNonDecimalNumber(a) && isNonDecimalNumber(b)) {
			if (b.longValue() == 0) return a.longValue();
			return gcd(b.longValue(), a.longValue() % b.longValue());
		} else throw new IllegalArgumentException("Unsupported types.");
	}

	/**
	 * Calculates the least common multiple of multiple numbers.
	 *
	 * @param numbers the numbers to calculate the least common multiple of
	 * @return the least common multiple of the given numbers
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends Number> long lcm(T... numbers) {
		if (isNull(numbers) || numbers.length == 0) {
			throw new IllegalArgumentException("At least 1 number.");
		}
		if (Arrays.stream(numbers).anyMatch(num -> !isNonDecimalNumber(num))) {
			throw new IllegalArgumentException("Unsupported types.");
		}
		long lcm = Arrays.stream(numbers)
				.mapToLong(Number::longValue)
				.reduce(1, (a, b) -> (a * b) / gcd(a, b));
		return lcm;
	}

	/**
	 * Counts the digits of a number.
	 *
	 * @param number the number to count the digits of
	 * @return the number of digits of the given number
	 * @since 1.0.0
	 */
	public static int countDigits(Number number) {
		String str = String.valueOf(number).replace(".", "");
		System.out.println(str);
		return str.startsWith("-") ? str.length() - 1 : str.length();
	}

	/**
	 * Checks if a given number is a palindrome.
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is a palindrome, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isPalindrome(Number number) {
		if (isNonDecimalNumber(number)) {
			long reversed = 0, original = number.longValue(), remainder;
			while (number.longValue() != 0) {
				remainder = number.longValue() % 10;
				reversed = reversed * 10 + remainder;
				number = number.longValue() / 10;
			}
			return original == reversed;
		} else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}

	/**
	 * Calculates the sum of the digits of a number (abs).
	 *
	 * @param number the number to calculate the sum of the digits of
	 * @return the sum of the digits of the given number
	 * @since 1.0.0
	 */
	public static long sumOfDigits(Number number) {
		if (isNonDecimalNumber(number)) {
			long sum = 0;
			number = Math.abs(number.longValue());
			while (number.longValue() != 0) {
				sum += number.longValue() % 10;
				number = number.longValue() / 10;
			}
			return sum;
		} else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}

	/**
	 * Checks if a given number is a perfect number.
	 *
	 * @param number the number to check
	 * @return {@code true} if the number is a perfect number, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isPerfectNumber(Number number) {
		if (isNonDecimalNumber(number)) {
			long sum = 1;
			for (int i = 2; i <= Math.sqrt(number.longValue()); i++) {
				if (number.longValue() % i == 0) {
					if (i == number.longValue() / i) sum += i;
					else sum += i + number.longValue() / i;
				}
			}
			return sum == number.longValue() && number.longValue() != 1;
		} else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}

	/**
	 * Calculates the factorial of a number.
	 * <p>
	 * WARNING: for number under the max Long number (input number > 20) the method return
	 * a long value, else a BigInteger. For decimal number always a BigDecimal.
	 *
	 *
	 * @param number the number to calculate the factorial of
	 * @return the factorial of the given number
	 * @throws IllegalArgumentException if the number is negative
	 * @since 1.0.0
	 */
	public static <T extends Number> Number factorial(T number) {
		if (isNonDecimalNumber(number)) {
			if (number.longValue() < 0) throw new IllegalArgumentException("Number must be non-negative.");
			if (number.longValue() <= 20) {
				long result = 1;
				for (int i = 2; i <= number.longValue(); i++) {
					result *= i;
				}
				return result;
			} else {
				BigInteger result = ONE;
				for (int i = 2; i <= number.longValue(); i++)
					result = result.multiply(BigInteger.valueOf(i));
				return result;
			}
		} else throw new IllegalArgumentException("Unsupported type: " + number.getClass().getName());
	}
}
