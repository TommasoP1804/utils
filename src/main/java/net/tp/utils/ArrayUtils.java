package net.tp.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.*;
import static java.util.stream.IntStream.range;

/**
 * Utility class for arrays.
 *
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public abstract class ArrayUtils {
	/**
	 * An empty array of {@code boolean} objects.
	 */
	public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
	/**
	 * An empty array of {@code Boolean} objects.
	 */
	public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
	/**
	 * An empty array of {@code byte} objects.
	 */
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
	/**
	 * An empty array of {@code Byte} objects.
	 */
	public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
	/**
	 * An empty array of {@code char} objects.
	 */
	public static final char[] EMPTY_CHAR_ARRAY = new char[0];
	/**
	 * An empty array of {@code Character} objects.
	 */
	public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
	/**
	 * An empty array of {@code Class} objects.
	 */
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
	/**
	 * An empty array of {@code double} objects.
	 */
	public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
	/**
	 * An empty array of {@code Double} objects.
	 */
	public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
	/**
	 * An empty array of {@code Field} objects.
	 */
	public static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
	/**
	 * An empty array of {@code float} objects.
	 */
	public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
	/**
	 * An empty array of {@code Float} objects.
	 */
	public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
	/**
	 * An empty array of {@code int} objects.
	 */
	public static final int[] EMPTY_INT_ARRAY = new int[0];
	/**
	 * An empty array of {@code Integer} objects.
	 */
	public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
	/**
	 * An empty array of {@code long} objects.
	 */
	public static final long[] EMPTY_LONG_ARRAY = new long[0];
	/**
	 * An empty array of {@code Long} objects.
	 */
	public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
	/**
	 * An empty array of {@code Method} objects.
	 */
	public static final Method[] EMPTY_METHOD_ARRAY = new Method[0];
	/**
	 * An empty array of {@code Object} objects.
	 */
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
	/**
	 * An empty array of {@code short} objects.
	 */
	public static final short[] EMPTY_SHORT_ARRAY = new short[0];
	/**
	 * An empty array of {@code Short} objects.
	 */
	public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
	/**
	 * An empty array of {@code String} objects.
	 */
	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	/**
	 * An empty array of {@code Throwable} objects.
	 */
	public static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];
	/**
	 * An empty array of {@code Type} objects.
	 */
	public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
	/**
	 * The index value indicating that the element was not found in the array.
	 */
	public static final int INDEX_NOT_FOUND = -1;

	private static ThreadLocalRandom random() {
		return ThreadLocalRandom.current();
	}

	/**
	 * Checks if an array is empty.
	 *
	 * @param array the array to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the array is empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <E> boolean isEmpty(E[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a byte-array is null or empty.
	 *
	 * @param array the byte-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(byte[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a short-array is null or empty.
	 *
	 * @param array the short-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(short[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if an int-array is null or empty.
	 *
	 * @param array the int-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(int[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a long-array is null or empty.
	 *
	 * @param array the long-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(long[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a float-array is null or empty.
	 *
	 * @param array the float-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(float[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a double-array is null or empty.
	 *
	 * @param array the double-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(double[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a char-array is null or empty.
	 *
	 * @param array the char-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(char[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if a boolean-array is null or empty.
	 *
	 * @param array the boolean-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isEmpty(boolean[] array) {
		return requireNonNull(array).length == 0;
	}

	/**
	 * Checks if an array is null or empty.
	 *
	 * @param array the array to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <E> boolean isNullOrEmpty(E[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a byte-array is null or empty.
	 *
	 * @param array the byte-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(byte[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a short-array is null or empty.
	 *
	 * @param array the short-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(short[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if an int-array is null or empty.
	 *
	 * @param array the int-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(int[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a long-array is null or empty.
	 *
	 * @param array the long-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(long[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a float-array is null or empty.
	 *
	 * @param array the float-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(float[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a double-array is null or empty.
	 *
	 * @param array the double-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(double[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a char-array is null or empty.
	 *
	 * @param array the char-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(char[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if a boolean-array is null or empty.
	 *
	 * @param array the boolean-array to check
	 * @return {@code true} if the array is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(boolean[] array) {
		return isNull(array) || array.length == 0;
	}

	/**
	 * Checks if an array is not empty.
	 *
	 * @param array the array to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the array is not empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <E> boolean isNotEmpty(E[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a byte-array is not null or empty.
	 *
	 * @param array the byte-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(byte[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a short-array is not null or empty.
	 *
	 * @param array the short-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(short[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if an int-array is not null or empty.
	 *
	 * @param array the int-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(int[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a long-array is not null or empty.
	 *
	 * @param array the long-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(long[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a float-array is not null or empty.
	 *
	 * @param array the float-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(float[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a double-array is not null or empty.
	 *
	 * @param array the double-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(double[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a char-array is not null or empty.
	 *
	 * @param array the char-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(char[] array) {
		return !isNullOrEmpty(array);
	}

	/**
	 * Checks if a boolean-array is not null or empty.
	 *
	 * @param array the boolean-array to check
	 * @return {@code true} if the array is not null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(boolean[] array) {
		return !isNullOrEmpty(array);
	}

	private static Object copyArrayGrow(Object array, int length, Class<?> newArrayComponentType) {
		if (nonNull(array)) {
			int arrayLenght = Array.getLength(array);
			Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLenght + length);
			System.arraycopy(array, 0, newArray, 0, arrayLenght);
			return newArray;
		}
		else return Array.newInstance(newArrayComponentType, 1);
	}

	/**
	 * Adds elements to the end of an array.
	 *
	 * @param array the array to which the element will be added
	 * @param elements the element to add
	 * @param <E> the type of the elements
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> E[] add(E[] array, E... elements) {
		if (isNull(array)) array = (E[]) Array.newInstance(elements[0].getClass(), 0);
		if (isNull(elements) || elements.length == 0) return array;

		Object newArray = copyArrayGrow(array, elements.length, elements[0].getClass());
		range(0, elements.length).forEach(i -> Array.set(newArray, Array.getLength(newArray) - elements.length + i, elements[i]));

		@SuppressWarnings("unchecked") E[] result = (E[]) newArray;
		return result;
	}

	/**
	 * Adds elements to an array at a specific index.
	 *
	 * @param array the array to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the element to add
	 * @param <E> the type of the elements
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static <E> E[] add(E[] array, int index, List<E> elements) {
		if (isNull(elements) || elements.isEmpty()) return array;

		if (isNull(array)) {
			if (index != 0) throw new IndexOutOfBoundsException("Index: " + index + ", Length: 0");
			Object joinedArray = Array.newInstance(elements.getFirst().getClass(), elements.size());
			range(0, elements.size()).forEach(i -> Array.set(joinedArray, i, elements.get(i)));

			@SuppressWarnings("unchecked") E[] result = (E[]) joinedArray;
			return result;
		} else {
			int length = Array.getLength(array);
			if (index <= length && index >= 0) {
				Object newArray = Array.newInstance(elements.getFirst().getClass(), length + elements.size());
				System.arraycopy(array, 0, newArray, 0, index);
				range(0, elements.size()).forEach(i -> Array.set(newArray, index + i, elements.get(i)));

				if (index < length) System.arraycopy(array, index, newArray, index + elements.size(), length - index);

				@SuppressWarnings("unchecked") E[] result = (E[]) newArray;
				return result;
			} else throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
		}
	}

	/**
	 * Adds an element to an array at a specific index.
	 *
	 * @param array the array to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the element to add
	 * @param <E> the type of the elements
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static <E> E[] add(E[] array, int index, E element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds byte element to an array at a specific index.
	 *
	 * @param array the array of byte to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the byte element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static byte[] add(byte[] array, int index, byte element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds byte elements to an array at a specific index.
	 *
	 * @param array the array of byte to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the byte element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static byte[] add(byte[] array, int index, List<Byte> elements) {
		if (isNull(array)) array = (byte[]) Array.newInstance(byte.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Byte[] arrayWrapper = new Byte[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Byte[] elementsWrapper = new Byte[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		byte[] result = new byte[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds short element to an array at a specific index.
	 *
	 * @param array the array of short to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the short element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static short[] add(short[] array, int index, short element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds short elements to an array at a specific index.
	 *
	 * @param array the array of short to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the short element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static short[] add(short[] array, int index, List<Short> elements) {
		if (isNull(array)) array = (short[]) Array.newInstance(short.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Short[] arrayWrapper = new Short[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Short[] elementsWrapper = new Short[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		short[] result = new short[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds int element to an array at a specific index.
	 *
	 * @param array the array of int to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the int element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static int[] add(int[] array, int index, int element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds int elements to an array at a specific index.
	 *
	 * @param array the array of int to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the int element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static int[] add(int[] array, int index, List<Integer> elements) {
		if (isNull(array)) array = (int[]) Array.newInstance(int.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Integer[] arrayWrapper = new Integer[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Integer[] elementsWrapper = new Integer[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		int[] result = new int[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds long element to an array at a specific index.
	 *
	 * @param array the array of long to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the long element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static long[] add(long[] array, int index, long element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds long elements to an array at a specific index.
	 *
	 * @param array the array of long to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the long element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static long[] add(long[] array, int index, List<Long> elements) {
		if (isNull(array)) array = (long[]) Array.newInstance(long.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Long[] arrayWrapper = new Long[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Long[] elementsWrapper = new Long[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		long[] result = new long[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds float element to an array at a specific index.
	 *
	 * @param array the array of float to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the float element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static float[] add(float[] array, int index, float element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds float elements to the end of an array.
	 *
	 * @param array the array of float to which the element will be added
	 * @param elements the float element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static float[] add(float[] array, float... elements) {
		if (isNull(array)) array = (float[]) Array.newInstance(float.class, 0);
		if (isNull(elements) || elements.length == 0) return array;

		Float[] arrayWrapper = new Float[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Float[] elementsWrapper = new Float[elements.length];
		for (int i = 0; i < elements.length; i++) elementsWrapper[i] = elements[i];

		arrayWrapper = add(arrayWrapper, elementsWrapper);

		float[] result = new float[array.length + elements.length];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds float elements to an array at a specific index.
	 *
	 * @param array the array of float to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the float element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static float[] add(float[] array, int index, List<Float> elements) {
		if (isNull(array)) array = (float[]) Array.newInstance(float.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Float[] arrayWrapper = new Float[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Float[] elementsWrapper = new Float[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		float[] result = new float[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds double elements to the end of an array.
	 *
	 * @param array the array of double to which the element will be added
	 * @param elements the double element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static double[] add(double[] array, double... elements) {
		if (isNull(array)) array = (double[]) Array.newInstance(double.class, 0);
		if (isNull(elements) || elements.length == 0) return array;

		Double[] arrayWrapper = new Double[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Double[] elementsWrapper = new Double[elements.length];
		for (int i = 0; i < elements.length; i++) elementsWrapper[i] = elements[i];

		arrayWrapper = add(arrayWrapper, elementsWrapper);

		double[] result = new double[array.length + elements.length];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds double elements to an array at a specific index.
	 *
	 * @param array the array of double to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the double element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static double[] add(double[] array, int index, List<Double> elements) {
		if (isNull(array)) array = (double[]) Array.newInstance(double.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Double[] arrayWrapper = new Double[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Double[] elementsWrapper = new Double[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		double[] result = new double[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds char element to an array at a specific index.
	 *
	 * @param array the array of char to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the char element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static char[] add(char[] array, int index, char element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds char elements to the end of an array.
	 *
	 * @param array the array of char to which the element will be added
	 * @param elements the char element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static char[] add(char[] array, char... elements) {
		if (isNull(array)) array = (char[]) Array.newInstance(char.class, 0);
		if (isNull(elements) || elements.length == 0) return array;

		Character[] arrayWrapper = new Character[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Character[] elementsWrapper = new Character[elements.length];
		for (int i = 0; i < elements.length; i++) elementsWrapper[i] = elements[i];

		arrayWrapper = add(arrayWrapper, elementsWrapper);

		char[] result = new char[array.length + elements.length];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds char elements to an array at a specific index.
	 *
	 * @param array the array of char to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the char element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static char[] add(char[] array, int index, List<Character> elements) {
		if (isNull(array)) array = (char[]) Array.newInstance(char.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Character[] arrayWrapper = new Character[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Character[] elementsWrapper = new Character[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		char[] result = new char[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds boolean element to an array at a specific index.
	 *
	 * @param array the array of boolean to which the element will be added
	 * @param index the index at which the element will be added
	 * @param element the boolean element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static boolean[] add(boolean[] array, int index, boolean element) {
		return add(array, index, List.of(element));
	}

	/**
	 * Adds boolean elements to the end of an array.
	 *
	 * @param array the array of boolean to which the element will be added
	 * @param elements the boolean element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static boolean[] add(boolean[] array, boolean... elements) {
		if (isNull(array)) array = (boolean[]) Array.newInstance(boolean.class, 0);
		if (isNull(elements) || elements.length == 0) return array;

		Boolean[] arrayWrapper = new Boolean[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Boolean[] elementsWrapper = new Boolean[elements.length];
		for (int i = 0; i < elements.length; i++) elementsWrapper[i] = elements[i];

		arrayWrapper = add(arrayWrapper, elementsWrapper);

		boolean[] result = new boolean[array.length + elements.length];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds boolean elements to an array at a specific index.
	 *
	 * @param array the array of boolean to which the element will be added
	 * @param index the index at which the element will be added
	 * @param elements the boolean element to add
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static boolean[] add(boolean[] array, int index, List<Boolean> elements) {
		if (isNull(array)) array = (boolean[]) Array.newInstance(boolean.class, 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		Boolean[] arrayWrapper = new Boolean[array.length];
		for (int i = 0; i < array.length; i++) arrayWrapper[i] = array[i];
		Boolean[] elementsWrapper = new Boolean[elements.size()];
		for (int i = 0; i < elements.size(); i++) elementsWrapper[i] = elements.get(i);

		arrayWrapper = add(arrayWrapper, index, List.of(elementsWrapper));

		boolean[] result = new boolean[array.length + elements.size()];
		for (int i = 0; i < result.length; i++) result[i] = arrayWrapper[i];
		return result;
	}

	/**
	 * Adds elements to the end of an array.
	 *
	 * @param array the array of String to which the element will be added
	 * @param elements the String element to add
	 * @param <E> the type of the elements
	 * @return the array with the element added
	 * @since 1.0.0
	 */
	public static <E> E[] add(E[]array, List<E> elements) {
		if (isNull(array)) array = (E[]) Array.newInstance(elements.get(0).getClass(), 0);
		if (isNull(elements) || elements.isEmpty()) return array;

		@SuppressWarnings("unchecked") E[] result = (E[]) add(array, elements.toArray());
		return result;
	}

	private static Object remove (Object array, int index) {
		int length = Array.getLength(array);
		if (index >= 0 && index < length) {
			Object result = Array.newInstance(array.getClass().getComponentType(), length - 1);
			System.arraycopy(array, 0, result, 0, index);
			if (index < length - 1) {
				System.arraycopy(array, index + 1, result, index, length - index - 1);
			}

			return result;
		} else {
			throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
		}
	}

	private static Object remove (Object array, int... index) {
		for (int i = 0; i < requireNonNull(index).length; i++)
			array = remove(array, index[i] - i);
		return array;
	}

	/**
	 * Remove the element from the array at the specified index.
	 * @param array the array to remove the element from
	 * @param index the index of the element to remove
	 * @param <E> the type of the array
	 * @return the array with the element removed
	 * @since 1.0.0
	 */
	public static <E> E[] remove(E[] array, int index) {
		if (isNullOrEmpty(array)) return array;

		@SuppressWarnings("unchecked") E[] result = (E[]) remove((Object) array, index);
		return result;
	}

	/**
	 * Remove the element from the array at the specified indexes.
	 * @param array the array to remove the element from
	 * @param index the indexes of the element to remove
	 * @param <E> the type of the array
	 * @return the array with the element removed
	 * @since 1.0.0
	 */
	public static <E> E[] remove(E[] array, int... index) {
		if (isNullOrEmpty(array)) return array;

		@SuppressWarnings("unchecked") E[] result = (E[]) remove((Object) array, index);
		return result;
	}

	/**
	 * Remove all the occurrences of the element from the array.
	 * @param array the array to remove the element from
	 * @param element the element to remove
	 * @param <E> the type of the array
	 * @return the array with the element removed
	 * @since 1.0.0
	 */
	public static <E> E[] remove(E[] array, E element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the array.
	 * @param array the array to remove the element from
	 * @param elements the elements to remove
	 * @param <E> the type of the array
	 * @return the array with the element removed
	 * @since 1.0.0
	 */
	public static <E> E[] remove(E[] array, List<E> elements) {
		if (isNullOrEmpty(array)) return array;
		for (E element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the byte-array at the specified index.
	 * @param array the byte-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the byte-array with the element removed
	 * @since 1.0.0
	 */
	public static byte[] remove(byte[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (byte[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the byte-array at the specified indexes.
	 * @param array the byte-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the byte-array with the element removed
	 * @since 1.0.0
	 */
	public static byte[] remove(byte[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (byte[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the byte-array.
	 * @param array the byte-array to remove the element from
	 * @param element the element to remove
	 * @return the byte-array with the element removed
	 * @since 1.0.0
	 */
	public static byte[] remove(byte[] array, byte element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the byte-array.
	 * @param array the byte-array to remove the element from
	 * @param elements the elements to remove
	 * @return the byte-array with the element removed
	 * @since 1.0.0
	 */
	public static byte[] remove(byte[] array, List<Byte> elements) {
		if (isNullOrEmpty(array)) return array;
		for (byte element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the short-array at the specified index.
	 * @param array the short-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the short-array with the element removed
	 * @since 1.0.0
	 */
	public static short[] remove(short[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (short[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the short-array at the specified indexes.
	 * @param array the short-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the short-array with the element removed
	 * @since 1.0.0
	 */
	public static short[] remove(short[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (short[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the short-array.
	 * @param array the short-array to remove the element from
	 * @param element the element to remove
	 * @return the short-array with the element removed
	 * @since 1.0.0
	 */
	public static short[] remove(short[] array, short element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the short-array.
	 * @param array the short-array to remove the element from
	 * @param elements the elements to remove
	 * @return the short-array with the element removed
	 * @since 1.0.0
	 */
	public static short[] remove(short[] array, List<Short> elements) {
		if (isNullOrEmpty(array)) return array;
		for (short element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the int-array at the specified index.
	 * @param array the int-array to remove the element from
	 * @param i the index of the element to remove (if {@code element} is {@code true}) -- the element to remove (if {@code element} is {@code false})
	 * @param element {@code false} if the {@code i} is the index of the element to remove, {@code true} if {@code i} is the element to remove
	 * @return the int-array with the element removed
	 * @since 1.0.0
	 */
	public static int[] remove(int[] array, int i, boolean element) {
		if (isNullOrEmpty(array)) return array;
		if (!element) return (int[]) remove((Object) array, i);
		else {
			array = remove(array, indexesOf(array, i));
			return array;
		}
	}

	/**
	 * Remove the element from the int-array at the specified indexes.
	 * @param array the int-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the int-array with the element removed
	 * @since 1.0.0
	 */
	public static int[] remove(int[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (int[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the elements from the int-array.
	 * @param array the int-array to remove the element from
	 * @param elements the elements to remove
	 * @return the int-array with the element removed
	 * @since 1.0.0
	 */
	public static int[] remove(int[] array, List<Integer> elements) {
		if (isNullOrEmpty(array)) return array;
		for (int element : elements) array = remove(array, element, true);
		return array;
	}

	/**
	 * Remove the element from the long-array at the specified index.
	 * @param array the long-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the long-array with the element removed
	 * @since 1.0.0
	 */
	public static long[] remove(long[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (long[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the long-array at the specified indexes.
	 * @param array the long-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the long-array with the element removed
	 * @since 1.0.0
	 */
	public static long[] remove(long[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (long[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the long-array.
	 * @param array the long-array to remove the element from
	 * @param element the element to remove
	 * @return the long-array with the element removed
	 * @since 1.0.0
	 */
	public static long[] remove(long[] array, long element) {
		if (isNullOrEmpty(array)) return array;
		int[] index = indexesOf(array, element);
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the long-array.
	 * @param array the long-array to remove the element from
	 * @param elements the elements to remove
	 * @return the long-array with the element removed
	 * @since 1.0.0
	 */
	public static long[] remove(long[] array, List<Long> elements) {
		if (isNullOrEmpty(array)) return array;
		for (long element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the float-array at the specified index.
	 * @param array the float-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the float-array with the element removed
	 * @since 1.0.0
	 */
	public static float[] remove(float[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (float[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the float-array at the specified indexes.
	 * @param array the float-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the float-array with the element removed
	 * @since 1.0.0
	 */
	public static float[] remove(float[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (float[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the float-array.
	 * @param array the float-array to remove the element from
	 * @param element the element to remove
	 * @return the float-array with the element removed
	 * @since 1.0.0
	 */
	public static float[] remove(float[] array, float element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the float-array.
	 * @param array the float-array to remove the element from
	 * @param elements the elements to remove
	 * @return the float-array with the element removed
	 * @since 1.0.0
	 */
	public static float[] remove(float[] array, List<Float> elements) {
		if (isNullOrEmpty(array)) return array;
		for (float element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the double-array at the specified index.
	 * @param array the double-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the double-array with the element removed
	 * @since 1.0.0
	 */
	public static double[] remove(double[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (double[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the double-array at the specified indexes.
	 * @param array the double-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the double-array with the element removed
	 * @since 1.0.0
	 */
	public static double[] remove(double[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (double[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the double-array.
	 * @param array the double-array to remove the element from
	 * @param element the element to remove
	 * @return the double-array with the element removed
	 * @since 1.0.0
	 */
	public static double[] remove(double[] array, double element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the double-array.
	 * @param array the double-array to remove the element from
	 * @param elements the elements to remove
	 * @return the double-array with the element removed
	 * @since 1.0.0
	 */
	public static double[] remove(double[] array, List<Double> elements) {
		if (isNullOrEmpty(array)) return array;
		for (double element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the char-array at the specified index.
	 * @param array the char-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the char-array with the element removed
	 * @since 1.0.0
	 */
	public static char[] remove(char[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (char[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the char-array at the specified indexes.
	 * @param array the char-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the char-array with the element removed
	 * @since 1.0.0
	 */
	public static char[] remove(char[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (char[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the char-array.
	 * @param array the char-array to remove the element from
	 * @param element the element to remove
	 * @return the char-array with the element removed
	 * @since 1.0.0
	 */
	public static char[] remove(char[] array, char element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the char-array.
	 * @param array the char-array to remove the element from
	 * @param elements the elements to remove
	 * @return the char-array with the element removed
	 * @since 1.0.0
	 */
	public static char[] remove(char[] array, char... elements) {
		if (isNullOrEmpty(array)) return array;
		for (char element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the char-array.
	 * @param array the char-array to remove the element from
	 * @param elements the elements to remove
	 * @return the char-array with the element removed
	 * @since 1.0.0
	 */
	public static char[] remove(char[] array, List<Character> elements) {
		if (isNullOrEmpty(array)) return array;
		for (char element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove the element from the boolean-array at the specified index.
	 * @param array the boolean-array to remove the element from
	 * @param index the index of the element to remove
	 * @return the boolean-array with the element removed
	 * @since 1.0.0
	 */
	public static boolean[] remove(boolean[] array, int index) {
		if (isNullOrEmpty(array)) return array;
		return (boolean[]) remove((Object) array, index);
	}

	/**
	 * Remove the element from the boolean-array at the specified indexes.
	 * @param array the boolean-array to remove the element from
	 * @param index the indexes of the element to remove
	 * @return the boolean-array with the element removed
	 * @since 1.0.0
	 */
	public static boolean[] remove(boolean[] array, int... index) {
		if (isNullOrEmpty(array)) return array;
		return (boolean[]) remove((Object) array, index);
	}

	/**
	 * Remove all the occurrences of the element from the boolean-array.
	 * @param array the boolean-array to remove the element from
	 * @param element the element to remove
	 * @return the boolean-array with the element removed
	 * @since 1.0.0
	 */
	public static boolean[] remove(boolean[] array, boolean element) {
		if (isNullOrEmpty(array)) return array;
		array = remove(array, indexesOf(array, element));
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the boolean-array.
	 * @param array the boolean-array to remove the element from
	 * @param elements the elements to remove
	 * @return the boolean-array with the element removed
	 * @since 1.0.0
	 */
	public static boolean[] remove(boolean[] array, boolean... elements) {
		if (isNullOrEmpty(array)) return array;
		for (boolean element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Remove all the occurrences of the elements from the boolean-array.
	 * @param array the boolean-array to remove the element from
	 * @param elements the elements to remove
	 * @return the boolean-array with the element removed
	 * @since 1.0.0
	 */
	public static boolean[] remove(boolean[] array, List<Boolean> elements) {
		if (isNullOrEmpty(array)) return array;
		for (boolean element : elements) array = remove(array, element);
		return array;
	}

	/**
	 * Reverse the array.
	 * @param array the array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @param <E> the type of the array
	 * @since 1.0.0
	 */
	public static <E> void reverse(E[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				Object tmp = array[j];
				array[j] = array[i];
				array[i] = (E) tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the array.
	 * @param array the array to reverse
	 * @param <E> the type of the array
	 */
	public static <E> void reverse(E[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the byte-array.
	 * @param array the byte-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(byte[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				byte tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the byte-array.
	 * @param array the byte-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(byte[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the short-array.
	 * @param array the short-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(short[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				short tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the short-array.
	 * @param array the short-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(short[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the int-array.
	 * @param array the int-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(int[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the int-array.
	 * @param array the int-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(int[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the long-array.
	 * @param array the long-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(long[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				long tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the long-array.
	 * @param array the long-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(long[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the float-array.
	 * @param array the float-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(float[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				float tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the float-array.
	 * @param array the float-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(float[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the double-array.
	 * @param array the double-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(double[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				double tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the double-array.
	 * @param array the double-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(double[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the char-array.
	 * @param array the char-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(char[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				char tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the char-array.
	 * @param array the char-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(char[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Reverse the boolean-array.
	 * @param array the boolean-array to reverse
	 * @param startIndex the index to start reversing from (inclusive)
	 * @param endIndex the index to end reversing at (exclusive)
	 * @since 1.0.0
	 */
	public static void reverse(boolean[] array, int startIndex, int endIndex) {
		if (isNotEmpty(array)) {
			int i = Math.max(startIndex, 0);

			for (int j = Math.min(array.length, endIndex) - 1; j > i; ++i) {
				boolean tmp = array[j];
				array[j] = array[i];
				array[i] = tmp;
				--j;
			}
		}
	}

	/**
	 * Reverse the boolean-array.
	 * @param array the boolean-array to reverse
	 * @since 1.0.0
	 */
	public static void reverse(boolean[] array) {
		reverse(array, 0, array.length);
	}

	/**
	 * Shift the array by the specified offset.
	 * @param array the array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(Object[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the array by the specified offset.
	 * @param array the array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(Object[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the byte-array by the specified offset.
	 * @param array the byte-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(byte[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the byte-array by the specified offset.
	 * @param array the byte-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(byte[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the short-array by the specified offset.
	 * @param array the short-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(short[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the short-array by the specified offset.
	 * @param array the short-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(short[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the int-array by the specified offset.
	 * @param array the int-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(int[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the int-array by the specified offset.
	 * @param array the int-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(int[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}
						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the long-array by the specified offset.
	 * @param array the long-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(long[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the long-array by the specified offset.
	 * @param array the long-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(long[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the float-array by the specified offset.
	 * @param array the float-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(float[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	public static void shift(float[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the double-array by the specified offset.
	 * @param array the double-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(double[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the double-array by the specified offset.
	 * @param array the double-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(double[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while (n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the char-array by the specified offset.
	 * @param array the char-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(char[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the char-array by the specified offset.
	 * @param array the char-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(char[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while(n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shift the boolean-array by the specified offset.
	 * @param array the boolean-array to shift
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(boolean[] array, int offset) {
		if (isNotEmpty(array)) shift(array, 0, array.length, offset);
	}

	/**
	 * Shift the boolean-array by the specified offset.
	 * @param array the boolean-array to shift
	 * @param startIndex the index to start shifting from (inclusive)
	 * @param endIndex the index to end shifting at (exclusive)
	 * @param offset the offset to shift the array by
	 * @since 1.0.0
	 */
	public static void shift(boolean[] array, int startIndex, int endIndex, int offset) {
		if (isNotEmpty(array) && startIndex < array.length - 1 && endIndex > 0) {
			if (startIndex < 0) startIndex = 0;
			if (endIndex >= array.length) endIndex = array.length;

			int n = endIndex - startIndex;
			if (n > 1) {
				offset %= n;
				if (offset < 0) offset += n;

				while(n > 1 && offset > 0) {
					int nOffset = n - offset;
					if (offset > nOffset) {
						swap(array, startIndex, startIndex + n - nOffset, nOffset);
						n = offset;
						offset -= nOffset;
					} else {
						if (offset >= nOffset) {
							swap(array, startIndex, startIndex + nOffset, offset);
							break;
						}

						swap(array, startIndex, startIndex + nOffset, offset);
						startIndex += offset;
						n = nOffset;
					}
				}
			}
		}
	}

	/**
	 * Shuffle the array.
	 * @param array the array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(Object[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the array.
	 * @param array the array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(Object[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the byte-array.
	 * @param array the byte-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(byte[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the byte-array.
	 * @param array the byte-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(byte[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i) {
			swap(array, i - 1, random.nextInt(i), 1);
		}

	}

	/**
	 * Shuffle the short-array.
	 * @param array the short-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(short[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the short-array.
	 * @param array the short-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(short[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the int-array.
	 * @param array the int-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(int[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the int-array.
	 * @param array the int-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(int[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the long-array.
	 * @param array the long-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(long[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the long-array.
	 * @param array the long-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(long[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the float-array.
	 * @param array the float-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(float[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the float-array.
	 * @param array the float-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(float[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the double-array.
	 * @param array the double-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(double[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the double-array.
	 * @param array the double-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(double[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the char-array.
	 * @param array the char-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(char[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the char-array.
	 * @param array the char-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(char[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Shuffle the boolean-array.
	 * @param array the boolean-array to shuffle
	 * @since 1.0.0
	 */
	public static void shuffle(boolean[] array) {
		shuffle(array, random());
	}

	/**
	 * Shuffle the boolean-array.
	 * @param array the boolean-array to shuffle
	 * @param random the random instance to use
	 * @since 1.0.0
	 */
	public static void shuffle(boolean[] array, Random random) {
		for (int i = requireNonNull(array).length; i > 1; --i)
			swap(array, i - 1, random.nextInt(i), 1);
	}

	/**
	 * Creates a new array that is a subarray of this array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param <E> the component type of the array
	 * @param array the array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static <E> E[] subarray(E[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;

		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		@SuppressWarnings("unchecked") Class<E> type = (Class<E>) array.getClass().getComponentType();
		if (newSize <= 0) return (E[]) Array.newInstance(type, 0);

		@SuppressWarnings("unchecked")
		E[] subarray = (E[]) Array.newInstance(type, newSize);
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new byte-array that is a subarray of this byte-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the byte-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static byte[] subarray(byte[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_BYTE_ARRAY;

		byte[] subarray = new byte[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new short-array that is a subarray of this short-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the short-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static short[] subarray(short[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;

		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_SHORT_ARRAY;

		short[] subarray = new short[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new int-array that is a subarray of this int-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the int-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static int[] subarray(int[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_INT_ARRAY;

		int[] subarray = new int[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new long-array that is a subarray of this long-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the long-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static long[] subarray(long[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_LONG_ARRAY;

		long[] subarray = new long[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new float-array that is a subarray of this float-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the float-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static float[] subarray(float[] array, int startIndex, int endIndex) {
		if (array == null) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_FLOAT_ARRAY;

		float[] subarray = new float[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new double-array that is a subarray of this double-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the double-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static double[] subarray(double[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_DOUBLE_ARRAY;

		double[] subarray = new double[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new char-array that is a subarray of this char-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the char-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static char[] subarray(char[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_CHAR_ARRAY;

		char[] subarray = new char[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Creates a new boolean-array that is a subarray of this boolean-array.
	 *
	 * <p>The subarray begins at the specified {@code startIndex} and extends to the element at index
	 * {@code endIndex - 1}.
	 *
	 * <p>This method returns {@code null} if {@code array} is {@code null}.
	 *
	 * @param array the boolean-array to get a subarray of, may be {@code null}
	 * @param startIndex the starting index of the subarray (inclusive)
	 * @param endIndex the ending index of the subarray (exclusive)
	 * @return a new array containing the subarray, {@code null} if null array input
	 * @throws IllegalArgumentException if {@code startIndexInclusive} is greater than {@code endIndexExclusive}
	 * @since 1.0.0
	 */
	public static boolean[] subarray(boolean[] array, int startIndex, int endIndex) {
		if (isNull(array)) return null;

		if (startIndex < 0) startIndex = 0;
		if (endIndex > array.length) endIndex = array.length;

		int newSize = endIndex - startIndex;
		if (newSize <= 0) return EMPTY_BOOLEAN_ARRAY;

		boolean[] subarray = new boolean[newSize];
		System.arraycopy(array, startIndex, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Swaps elements in an array.
	 *
	 * @param array the array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(Object[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in an array.
	 *
	 * @param array the array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(Object[] array, int offset1, int offset2, int len) {
		if (!isEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				Object aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a byte-array.
	 *
	 * @param array the byte-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(byte[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a byte-array.
	 *
	 * @param array the byte-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(byte[] array, int offset1, int offset2, int len) {
		if (!isEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				byte aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a short-array.
	 *
	 * @param array the short-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(short[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a short-array.
	 *
	 * @param array the short-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(short[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			if (offset1 != offset2) {
				len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

				for (int i = 0; i < len; ++offset2) {
					short aux = array[offset1];
					array[offset1] = array[offset2];
					array[offset2] = aux;
					++i;
					++offset1;
				}
			}
		}
	}

	/**
	 * Swaps elements in an int-array.
	 *
	 * @param array the int-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(int[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in an int-array.
	 *
	 * @param array the int-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(int[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				int aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a long-array.
	 *
	 * @param array the long-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(long[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a long-array.
	 *
	 * @param array the long-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(long[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				long aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a float-array.
	 *
	 * @param array the float-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(float[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a float-array.
	 *
	 * @param array the float-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(float[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				float aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a double-array.
	 *
	 * @param array the double-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(double[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a double-array.
	 *
	 * @param array the double-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(double[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				double aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a char-array.
	 *
	 * @param array the char-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(char[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a char-array.
	 *
	 * @param array the char-array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(char[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				char aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Swaps elements in a boolean array.
	 *
	 * @param array the boolean array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @since 1.0.0
	 */
	public static void swap(boolean[] array, int offset1, int offset2) {
		swap(array, offset1, offset2, 1);
	}

	/**
	 * Swaps elements in a boolean array.
	 *
	 * @param array the boolean array in which elements will be swapped
	 * @param offset1 the index of the first element to swap
	 * @param offset2 the index of the second element to swap
	 * @param len the number of elements to swap
	 * @since 1.0.0
	 */
	public static void swap(boolean[] array, int offset1, int offset2, int len) {
		if (isNotEmpty(array) && offset1 < array.length && offset2 < array.length) {
			if (offset1 < 0) offset1 = 0;
			if (offset2 < 0) offset2 = 0;

			len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);

			for (int i = 0; i < len; ++offset2) {
				boolean aux = array[offset1];
				array[offset1] = array[offset2];
				array[offset2] = aux;
				++i;
				++offset1;
			}
		}
	}

	/**
	 * Checks if an array contains an element.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return {@code true} if the array contains the element, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <E> boolean contains(E[] array, E element) {
		if (isNull(array) || isNull(element)) return false;
		for (E e : array) if (element.equals(e)) return true;
		return false;
	}

	/**
	 * Checks if an array does not contain an element.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return {@code true} if the array does not contain the element, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <E> boolean notContains(E[] array, E element) {
		return !contains(array, element);
	}

	/**
	 * Checks if an array contains all the elements.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return {@code true} if the array contains all the elements, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> boolean containsAll(E[] array, E... elements) {
		if (isNull(array) || isNull(elements)) return false;
		for (E e : elements) if (!contains(array, e)) return false;
		return true;
	}

	/**
	 * Checks if an array contains any of the elements.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return {@code true} if the array contains any of the elements, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> boolean containsAny(E[] array, E... elements) {
		if (isNull(array) || isNull(elements)) return false;
		for (E e : elements) if (contains(array, e)) return true;
		return false;
	}

	/**
	 * Checks if an array contains none of the elements.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return {@code true} if the array contains none of the elements, {@code false} otherwise
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> boolean containsNone(E[] array, E... elements) {
		return !containsAny(array, elements);
	}

	/**
	 * Checks if the array contains duplicates.
	 * @param array the array to check
	 * @return {@code true} if the array contains duplicates, otherwise {@code false}
	 * @param <E> the type of the array
	 * @since 1.2.0
	 */
	public static <E> boolean containsDuplicates(E[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(Arrays.asList(array)).size();
	}

	/**
	 * Checks if the byte-array contains duplicates.
	 * @param array the byte-array to check
	 * @return {@code true} if the byte-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(byte[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the short-array contains duplicates.
	 * @param array the short-array to check
	 * @return {@code true} if the short-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(short[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the int-array contains duplicates.
	 * @param array the int-array to check
	 * @return {@code true} if the int-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(int[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the long-array contains duplicates.
	 * @param array the long-array to check
	 * @return {@code true} if the long-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(long[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the float-array contains duplicates.
	 * @param array the float-array to check
	 * @return {@code true} if the float-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(float[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the double-array contains duplicates.
	 * @param array the double-array to check
	 * @return {@code true} if the double-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(double[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the char-array contains duplicates.
	 * @param array the char-array to check
	 * @return {@code true} if the char-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(char[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Checks if the boolean-array contains duplicates.
	 * @param array the boolean-array to check
	 * @return {@code true} if the boolean-array contains duplicates, otherwise {@code false}
	 * @since 1.2.0
	 */
	public static boolean containsDuplicates(boolean[] array) {
		if (isNull(array)) return false;
		return array.length != new HashSet<>(List.of(array)).size();
	}

	/**
	 * Returns the index of the first occurrence of the element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static <E> int indexOf(E[] array, E element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> int[] indexOf(E[] array, E... elements) {
		return indexOf(array, 0, List.of(elements));
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static <E> int[] indexOf(E[] array, List<E> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first byte occurrence of the byte-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(byte[] array, byte element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first byte occurrences of the byte-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(byte[] array, List<Byte> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first short occurrence of the short-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(short[] array, short element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first short occurrences of the short-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(short[] array, List<Short> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first int occurrence of the int-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(int[] array, int element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first int occurrences of the int-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(int[] array, List<Integer> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first long occurrence of the long-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(long[] array, long element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first long occurrences of the long-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(long[] array, List<Long> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first float occurrence of the float-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(float[] array, float element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first float occurrences of the float-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(float[] array, List<Float> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first double occurrence of the double-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(double[] array, double element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first double occurrences of the double-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(double[] array, List<Double> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first char occurrence of the char-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(char[] array, char element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first char occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(char[] array, char... elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.length];
		for (int i = 0; i < elements.length; i++) indexes[i] = indexOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the first char occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(char[] array, List<Character> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first boolean occurrence of the boolean-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(boolean[] array, boolean element) {
		return indexOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the first boolean occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(boolean[] array, boolean... elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.length];
		for (int i = 0; i < elements.length; i++) indexes[i] = indexOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the first boolean occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(boolean[] array, List<Boolean> elements) {
		return indexOf(array, 0, elements);
	}

	/**
	 * Returns the index of the first occurrence of the element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static <E> int indexOf(E[] array, int fromIndex, E element) {
		if (isNull(array) || isNull(element)) return INDEX_NOT_FOUND;
		for (int i = fromIndex; i < array.length; i++) if (element.equals(array[i])) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static <E> int[] indexOf(E[] array, int fromIndex, List<E> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first byte occurrence of the byte-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(byte[] array, int fromIndex, byte element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first byte occurrences of the byte-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(byte[] array, int fromIndex, List<Byte> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first short occurrence of the short-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(short[] array, int fromIndex, short element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first short occurrences of the short-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(short[] array, int fromIndex, List<Short> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first int occurrence of the int-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(int[] array, int fromIndex, int element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first int occurrences of the int-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(int[] array, int fromIndex, List<Integer> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first long occurrence of the long-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(long[] array, int fromIndex, long element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first long occurrences of the long-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(long[] array, int fromIndex, List<Long> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first float occurrence of the float-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(float[] array, int fromIndex, float element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first float occurrences of the float-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(float[] array, int fromIndex, List<Float> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first double occurrence of the double-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(double[] array, int fromIndex, double element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first double occurrences of the double-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(double[] array, int fromIndex, List<Double> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first char occurrence of the char-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(char[] array, int fromIndex, char element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first char occurrences of the char-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(char[] array, int fromIndex, List<Character> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the first boolean occurrence of the boolean-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the index of the first occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int indexOf(boolean[] array, int fromIndex, boolean element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = fromIndex; i < array.length; i++)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the first boolean occurrences of the boolean-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the first occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] indexOf(boolean[] array, int fromIndex, List<Boolean> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last occurrence of the element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static <E> int lastIndexOf(E[] array, E element) {
		if (isNull(array) || isNull(element)) return INDEX_NOT_FOUND;
		for (int i = array.length - 1; i >= 0; i--)
			if (element.equals(array[i])) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> int[] lastIndexOf(E[] array, E... elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.length];
		for (int i = 0; i < elements.length; i++) indexes[i] = lastIndexOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the last occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static <E> int[] lastIndexOf(E[] array, List<E> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last byte occurrence of the byte-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(byte[] array, byte element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last byte occurrences of the byte-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(byte[] array, List<Byte> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last short occurrence of the short-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(short[] array, short element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last short occurrences of the short-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(short[] array, List<Short> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last int occurrence of the int-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(int[] array, int element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last int occurrences of the int-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(int[] array, List<Integer> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last long occurrence of the long-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(long[] array, long element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last long occurrences of the long-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(long[] array, List<Long> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last float occurrence of the float-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(float[] array, float element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last float occurrences of the float-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(float[] array, List<Float> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last double occurrence of the double-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(double[] array, double element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last double occurrences of the double-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(double[] array, List<Double> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last char occurrence of the char-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(char[] array, char element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last char occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(char[] array, char... elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.length];
		for (int i = 0; i < elements.length; i++) indexes[i] = lastIndexOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the last char occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(char[] array, List<Character> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the index of the last boolean occurrence of the boolean-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the index of the last occurrence of the element in the array, or {@code -1} if the element is not present
	 * @since 1.0.0
	 */
	public static int lastIndexOf(boolean[] array, boolean element) {
		if (isNull(array)) return INDEX_NOT_FOUND;

		for (int i = array.length - 1; i >= 0; i--)
			if (element == array[i]) return i;
		return INDEX_NOT_FOUND;
	}

	/**
	 * Returns the indexes of the last boolean occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(boolean[] array, boolean... elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.length];
		for (int i = 0; i < elements.length; i++) indexes[i] = lastIndexOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the last boolean occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the last occurrences of the elements in the array (-1 if not found)
	 * @since 1.0.0
	 */
	public static int[] lastIndexOf(boolean[] array, List<Boolean> elements) {
		if (isNull(array) || isNull(elements)) return new int[0];
		int[] indexes = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) indexes[i] = lastIndexOf(array, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static <E> int[] indexesOf(E[] array, E element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> int[][] indexesOf(E[] array, E... elements) {
		return indexesOf(array, 0, List.of(elements));
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static <E> int[][] indexesOf(E[] array, List<E> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the byte-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(byte[] array, byte element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the byte-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(byte[] array, List<Byte> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the short-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(short[] array, short element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the short-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(short[] array, List<Short> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the int-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(int[] array, int element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the int-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(int[] array, List<Integer> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the long-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(long[] array, long element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the long-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(long[] array, List<Long> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the float-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(float[] array, float element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the float-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(float[] array, List<Float> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the double-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(double[] array, double element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the double-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(double[] array, List<Double> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the char-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(char[] array, char element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(char[] array, char... elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.length][];
		for (int i = 0; i < elements.length; i++) indexes[i] = indexesOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the char-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(char[] array, List<Character> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the boolean-element in the array.
	 *
	 * @param array the array to check
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array
	 * @since 1.0.0
	 */
	public static int[] indexesOf(boolean[] array, boolean element) {
		return indexesOf(array, 0, element);
	}

	/**
	 * Returns the indexes of the occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(boolean[] array, boolean... elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.length][];
		for (int i = 0; i < elements.length; i++) indexes[i] = indexesOf(array, elements[i]);
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the boolean-elements in the array.
	 *
	 * @param array the array to check
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(boolean[] array, List<Boolean> elements) {
		return indexesOf(array, 0, elements);
	}

	/**
	 * Returns the indexes of the occurrences of the element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static <E> int[] indexesOf(E[] array, int fromIndex, E element) {
		if (isNull(array) || isNull(element)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element.equals(array[i])) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @param <E> the type of the array
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static <E> int[][] indexesOf(E[] array, int fromIndex, List<E> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the byte-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(byte[] array, int fromIndex, byte element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the byte-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(byte[] array, int fromIndex, List<Byte> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the short-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(short[] array, int fromIndex, short element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the short-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(short[] array, int fromIndex, List<Short> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the int-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(int[] array, int fromIndex, int element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the int-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(int[] array, int fromIndex, List<Integer> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the long-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(long[] array, int fromIndex, long element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the long-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(long[] array, int fromIndex, List<Long> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the float-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(float[] array, int fromIndex, float element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the float-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(float[] array, int fromIndex, List<Float> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the double-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(double[] array, int fromIndex, double element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the double-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(double[] array, int fromIndex, List<Double> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the char-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(char[] array, int fromIndex, char element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the char-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(char[] array, int fromIndex, List<Character> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**
	 * Returns the indexes of the occurrences of the boolean-element in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param element the element to check
	 * @return the indexes of the occurrences of the element in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[] indexesOf(boolean[] array, int fromIndex, boolean element) {
		if (isNull(array)) return new int[0];
		List<Integer> indexes = new ArrayList<>();
		for (int i = fromIndex; i < array.length; i++) if (element == array[i]) indexes.add(i);
		return indexes.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Returns the indexes of the occurrences of the boolean-elements in the array starting from a specified index.
	 *
	 * @param array the array to check
	 * @param fromIndex the index to start the search from
	 * @param elements the elements to check
	 * @return the indexes of the occurrences of the elements in the array starting from the specified index
	 * @since 1.0.0
	 */
	public static int[][] indexesOf(boolean[] array, int fromIndex, List<Boolean> elements) {
		if (isNull(array) || isNull(elements)) return new int[0][0];
		int[][] indexes = new int[elements.size()][];
		for (int i = 0; i < elements.size(); i++) indexes[i] = indexesOf(array, fromIndex, elements.get(i));
		return indexes;
	}

	/**Inserts an element at the specified index in the array.
	 * @param array the array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the element to insert
	 * @return the array with the element inserted at the specified index
	 * @param <E> the type of the array
	 * @since 1.0.0
	 */
	public static <E> E[] insert(E[] array, int index, E element) {
		return add(array, index, element);
	}

	/**Inserts a byte-element at the specified index in the byte-array.
	 * @param array the byte-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the byte-element to insert
	 * @return the byte-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static byte[] insert(byte[] array, int index, byte element) {
		return add(array, index, element);
	}

	/**Inserts a short-element at the specified index in the short-array.
	 * @param array the short-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the short-element to insert
	 * @return the short-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static short[] insert(short[] array, int index, short element) {
		return add(array, index, element);
	}

	/**Inserts an int-element at the specified index in the int-array.
	 * @param array the int-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the int-element to insert
	 * @return the int-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static int[] insert(int[] array, int index, int element) {
		return add(array, index, element);
	}

	/**Inserts a long-element at the specified index in the long-array.
	 * @param array the long-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the long-element to insert
	 * @return the long-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static long[] insert(long[] array, int index, long element) {
		return add(array, index, element);
	}

	/**Inserts a float-element at the specified index in the float-array.
	 * @param array the float-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the float-element to insert
	 * @return the float-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static float[] insert(float[] array, int index, float element) {
		return add(array, index, element);
	}

	/**Inserts a double-element at the specified index in the double-array.
	 * @param array the double-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the double-element to insert
	 * @return the double-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static double[] insert(double[] array, int index, double element) {
		return add(array, index, element);
	}

	/**Inserts a char-element at the specified index in the char-array.
	 * @param array the char-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the char-element to insert
	 * @return the char-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static char[] insert(char[] array, int index, char element) {
		return add(array, index, element);
	}

	/**Inserts a boolean-element at the specified index in the boolean-array.
	 * @param array the boolean-array to insert the element into
	 * @param index the index to insert the element at
	 * @param element the boolean-element to insert
	 * @return the boolean-array with the element inserted at the specified index
	 * @since 1.0.0
	 */
	public static boolean[] insert(boolean[] array, int index, boolean element) {
		return add(array, index, element);
	}

	/**Transforms a null array into an empty array.
	 * @param array the array to check
	 * @param type the type of the array
	 * @param <E> the type of the array
	 * @return the empty array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static <E> E[] nullToEmpty(E[] array, Class<E> type) {
		if (isNull(array)) {
			@SuppressWarnings("unchecked") E[] result = (E[]) requireNonNull(type).cast(Array.newInstance(type.getComponentType(), 0));
			return result;
		} return array;
	}

	/**Transforms a null byte-array into an empty byte-array.
	 * @param array the byte-array to check
	 * @return the empty byte-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static byte[] nullToEmpty(byte[] array) {
		return isNull(array) ? EMPTY_BYTE_ARRAY : array;
	}

	/**Transforms a null short-array into an empty short-array.
	 * @param array the short-array to check
	 * @return the empty short-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static short[] nullToEmpty(short[] array) {
		return isNull(array) ? EMPTY_SHORT_ARRAY : array;
	}

	/**Transforms a null int-array into an empty int-array.
	 * @param array the int-array to check
	 * @return the empty int-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static int[] nullToEmpty(int[] array) {
		return isNull(array) ? EMPTY_INT_ARRAY : array;
	}

	/**Transforms a null long-array into an empty long-array.
	 * @param array the long-array to check
	 * @return the empty long-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static long[] nullToEmpty(long[] array) {
		return isNull(array) ? EMPTY_LONG_ARRAY : array;
	}

	/**Transforms a null float-array into an empty float-array.
	 * @param array the float-array to check
	 * @return the empty float-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static float[] nullToEmpty(float[] array) {
		return isNull(array) ? EMPTY_FLOAT_ARRAY : array;
	}

	/**Transforms a null double-array into an empty double-array.
	 * @param array the double-array to check
	 * @return the empty double-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static double[] nullToEmpty(double[] array) {
		return isNull(array) ? EMPTY_DOUBLE_ARRAY : array;
	}

	/**Transforms a null char-array into an empty char-array.
	 * @param array the char-array to check
	 * @return the empty char-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static char[] nullToEmpty(char[] array) {
		return isNull(array) ? EMPTY_CHAR_ARRAY : array;
	}

	/**Transforms a null boolean-array into an empty boolean-array.
	 * @param array the boolean-array to check
	 * @return the empty boolean-array if the array is null, otherwise the array itself
	 * @since 1.0.0
	 */
	public static boolean[] nullToEmpty(boolean[] array) {
		return isNull(array) ? EMPTY_BOOLEAN_ARRAY : array;
	}

	/**Transforms an empty array into a null array.
	 * @param array the array to check
	 * @param <E> the type of the array
	 * @return the null array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static <E> E[] emptyToNull(E[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty byte-array into a null byte-array.
	 * @param array the byte-array to check
	 * @return the null byte-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static byte[] emptyToNull(byte[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty short-array into a null short-array.
	 * @param array the short-array to check
	 * @return the null short-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static short[] emptyToNull(short[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty int-array into a null int-array.
	 * @param array the int-array to check
	 * @return the null int-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static int[] emptyToNull(int[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty long-array into a null long-array.
	 * @param array the long-array to check
	 * @return the null long-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static long[] emptyToNull(long[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty float-array into a null float-array.
	 * @param array the float-array to check
	 * @return the null float-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static float[] emptyToNull(float[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty double-array into a null double-array.
	 * @param array the double-array to check
	 * @return the null double-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static double[] emptyToNull(double[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty char-array into a null char-array.
	 * @param array the char-array to check
	 * @return the null char-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static char[] emptyToNull(char[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Transforms an empty boolean-array into a null boolean-array.
	 * @param array the boolean-array to check
	 * @return the null boolean-array if the array is empty, otherwise the array itself
	 * @since 1.0.0
	 */
	public static boolean[] emptyToNull(boolean[] array) {
		return isNullOrEmpty(array) ? null : array;
	}

	/**Returns the parameters as array.
	 * @param items the parameters
	 * @param <E> the type of the parameters
	 * @return the parameters as array
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> E[] toArray(E... items) {return items;}

	/**
	 * Transforms a byte-array into a Byte-array.
	 * @param array the byte-array to transform
	 * @return the Byte-array
	 * @since 1.0.0
	 */
	public static Byte[] toWrapper(byte[] array) {
		if (isNull(array)) return null;
		Byte[] result = new Byte[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a short-array into a Short-array.
	 * @param array the short-array to transform
	 * @return the Short-array
	 * @since 1.0.0
	 */
	public static Short[] toWrapper(short[] array) {
		if (isNull(array)) return null;
		Short[] result = new Short[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms an int-array into an Integer-array.
	 * @param array the int-array to transform
	 * @return the Integer-array
	 * @since 1.0.0
	 */
	public static Integer[] toWrapper(int[] array) {
		if (isNull(array)) return null;
		Integer[] result = new Integer[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a long-array into a Long-array.
	 * @param array the long-array to transform
	 * @return the Long-array
	 * @since 1.0.0
	 */
	public static Long[] toWrapper(long[] array) {
		if (isNull(array)) return null;
		Long[] result = new Long[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a float-array into a Float-array.
	 * @param array the float-array to transform
	 * @return the Float-array
	 * @since 1.0.0
	 */
	public static Float[] toWrapper(float[] array) {
		if (isNull(array)) return null;
		Float[] result = new Float[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a double-array into a Double-array.
	 * @param array the double-array to transform
	 * @return the Double-array
	 * @since 1.0.0
	 */
	public static Double[] toWrapper(double[] array) {
		if (isNull(array)) return null;
		Double[] result = new Double[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a char-array into a Character-array.
	 * @param array the char-array to transform
	 * @return the Character-array
	 * @since 1.0.0
	 */
	public static Character[] toWrapper(char[] array) {
		if (isNull(array)) return null;
		Character[] result = new Character[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a boolean-array into a Boolean-array.
	 * @param array the boolean-array to transform
	 * @return the Boolean-array
	 * @since 1.0.0
	 */
	public static Boolean[] toWrapper(boolean[] array) {
		if (isNull(array)) return null;
		Boolean[] result = new Boolean[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Byte-array into a byte-array.
	 * @param array the Byte-array to transform
	 * @return the byte-array
	 * @since 1.0.0
	 */
	public static byte[] toPrimitive(Byte[] array) {
		if (isNull(array)) return null;
		byte[] result = new byte[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Short-array into a short-array.
	 * @param array the Short-array to transform
	 * @return the short-array
	 * @since 1.0.0
	 */
	public static short[] toPrimitive(Short[] array) {
		if (isNull(array)) return null;
		short[] result = new short[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms an Integer-array into an int-array.
	 * @param array the Integer-array to transform
	 * @return the int-array
	 * @since 1.0.0
	 */
	public static int[] toPrimitive(Integer[] array) {
		if (isNull(array)) return null;
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Long-array into a long-array.
	 * @param array the Long-array to transform
	 * @return the long-array
	 * @since 1.0.0
	 */
	public static long[] toPrimitive(Long[] array) {
		if (isNull(array)) return null;
		long[] result = new long[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Float-array into a float-array.
	 * @param array the Float-array to transform
	 * @return the float-array
	 * @since 1.0.0
	 */
	public static float[] toPrimitive(Float[] array) {
		if (isNull(array)) return null;
		float[] result = new float[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Double-array into a double-array.
	 * @param array the Double-array to transform
	 * @return the double-array
	 * @since 1.0.0
	 */
	public static double[] toPrimitive(Double[] array) {
		if (isNull(array)) return null;
		double[] result = new double[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Character-array into a char-array.
	 * @param array the Character-array to transform
	 * @return the char-array
	 * @since 1.0.0
	 */
	public static char[] toPrimitive(Character[] array) {
		if (isNull(array)) return null;
		char[] result = new char[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms a Boolean-array into a boolean-array.
	 * @param array the Boolean-array to transform
	 * @return the boolean-array
	 * @since 1.0.0
	 */
	public static boolean[] toPrimitive(Boolean[] array) {
		if (isNull(array)) return null;
		boolean[] result = new boolean[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i];
		return result;
	}

	/**
	 * Transforms an array into a string array.
	 * @param array the array to transform
	 * @param <E> the type of the array
	 * @return the string array
	 * @since 1.0.0
	 */
	public static <E> String[] toStringArray(E[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = array[i].toString();
		return result;
	}

	/**
	 * Transforms a byte-array into a string array.
	 * @param array the byte-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(byte[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a short-array into a string array.
	 * @param array the short-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(short[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms an int-array into a string array.
	 * @param array the int-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(int[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a long-array into a string array.
	 * @param array the long-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(long[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a float-array into a string array.
	 * @param array the float-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(float[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a double-array into a string array.
	 * @param array the double-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(double[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a char-array into a string array.
	 * @param array the char-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(char[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}

	/**
	 * Transforms a boolean-array into a string array.
	 * @param array the boolean-array to transform
	 * @return the string array
	 * @since 1.0.0
	 */
	public static String[] toStringArray(boolean[] array) {
		if (isNull(array)) return null;
		String[] result = new String[array.length];
		for (int i = 0; i < array.length; i++) result[i] = String.valueOf(array[i]);
		return result;
	}
}