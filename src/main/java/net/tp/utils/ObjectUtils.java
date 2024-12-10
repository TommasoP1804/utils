package net.tp.utils;

import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

/**
 * A utility class for objects.
 *
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public abstract class ObjectUtils {
	/**
	 * Checks if all the given objects are null.
	 * @param objects the objects to check
	 * @return {@code true} if all the objects are null; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean allNull(Object... objects) {
		if (isNull(objects)) return true;

		for (Object obj : objects) if (!isNull(obj)) return false;
		return true;
	}

	/**
	 * Checks if all the given objects are null.
	 * @param objects the objects to check
	 * @return {@code true} if all the objects are null; {@code false} otherwise
	 * @since 1.9.4
	 */
	public static <T> boolean allNull(Iterable<T> objects) {
		if (isNull(objects)) throw new NullPointerException();
		if (!objects.iterator().hasNext()) throw new IllegalArgumentException();

		for (Object obj : objects) if (!isNull(obj)) return false;
		return true;
	}

	/**
	 * Checks if any of the given objects is null.
	 * @param objects the objects to check
	 * @return {@code true} if any of the objects is null; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean anyNull(Object... objects) {
		if (isNull(objects)) return true;

		for (Object obj : objects) if (isNull(obj)) return true;
		return false;
	}

	/**
	 * Checks if any of the given objects is null.
	 * @param objects the objects to check
	 * @return {@code true} if any of the objects is null; {@code false} otherwise
	 * @since 1.9.4
	 */
	public static <T> boolean anyNull(Iterable<T> objects) {
		if (isNull(objects)) throw new NullPointerException();
		if (!objects.iterator().hasNext()) throw new IllegalArgumentException();

		for (Object obj : objects) if (isNull(obj)) return true;
		return false;
	}

	/**
	 * Checks if all the given objects are not null.
	 * @param objects the objects to check
	 * @return {@code true} if all the objects are not null; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean allNonNull(Object... objects) {
		if (isNull(objects)) return true;

		for (Object obj : objects) if (isNull(obj)) return false;
		return true;
	}

	/**
	 * Checks if all the given objects are not null.
	 * @param objects the objects to check
	 * @return {@code true} if all the objects are not null; {@code false} otherwise
	 * @since 1.9.4
	 */
	public static <T> boolean allNonNull(Iterable<T> objects) {
		if (isNull(objects)) throw new NullPointerException();
		if (!objects.iterator().hasNext()) throw new IllegalArgumentException();

		for (Object obj : objects) if (isNull(obj)) return false;
		return true;
	}

	/**
	 * Checks if any of the given objects is not null.
	 * @param objects the objects to check
	 * @return {@code true} if any of the objects is not null; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean anyNonNull(Object... objects) {
		if (isNull(objects)) return false;

		for (Object obj : objects) if (!isNull(obj)) return true;
		return false;
	}

	/**
	 * Checks if any of the given objects is not null.
	 * @param objects the objects to check
	 * @return {@code true} if any of the objects is not null; {@code false} otherwise
	 * @since 1.0.0
	 */
	public static <T> boolean anyNonNull(Iterable<T> objects) {
		if (isNull(objects)) throw new NullPointerException();
		if (!objects.iterator().hasNext()) throw new IllegalArgumentException();

		for (Object obj : objects) if (!isNull(obj)) return true;
		return false;
	}

	/**
	 * Checks if a given object is null, if it is return null, else another object.<p><p>
	 *
	 * <p>WARNING: do NOT use this method to get element from a {@code null} object.<p>
	 * AVOID THIS:
	 * <pre>{@code
	 * Object obj = null;
	 * Object other = requireNullElse(obj, obj.getElement());
	 * }</pre>
	 * For this, use {@code isNull(obj) ? null : obj.getElement()} instead.
	 * If used for that scoped, this method will throw a {@link NullPointerException}.
	 * <p>Use instead for this:
	 * <pre>{@code
	 * Object obj = null;
	 * Object obj2 = new Object();
	 * Object other = requireNullElse(obj, obj2);
	 * 	}</pre>
	 *
	 * @param obj the object to check and return if null
	 * @param elseObj the object to return if the given object is not null
	 * @param <T1> the type of the object to check
	 * @param <T2> the type of the other object
	 * @return {@code null} if the object is null, the other object otherwise
	 * @throws NullPointerException if {@code obj} is null and {@code elseObj} is a sub-object of {@code obj}
	 * @since 1.0.0
	 */
	public static <T1, T2> T2 requireNullElse(T1 obj, T2 elseObj) {
		return isNull(obj) ? null : elseObj;
	}

	/**
	 * Checks if a given object is null, if it is return null, else return the result of a supplier.
	 *
	 * @param obj the object to check
	 * @param elseSupplier the supplier of the object to return if the given object is not null
	 * @param <T1> the type of the object to check
	 * @param <T2> the type of the object to return
	 * @return {@code null} if the object is null, the object from the supplier otherwise
	 * @since 1.9.3
	 */
	public static <T1, T2> T2 requireNullElseGet(T1 obj, Supplier<T2> elseSupplier) {
		return isNull(obj) ? null : elseSupplier.get();
	}

	/**
	 * Checks if a given object is null, if it is throw a throwable, else return the object.
	 * @param obj the object to check
	 * @param exceptionSupplier the supplier of the throwable to throw
	 * @return the object if it is not null
	 * @param <T> the type of the object
	 * @param <X> the type of the throwable
	 * @throws X if the object is null
	 */
	public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, Supplier<X> exceptionSupplier) throws X {
		if (isNull(obj)) throw requireNonNull(exceptionSupplier).get();
		else return obj;
	}

	/**
	 * Checks if two objects are of the same class.
	 *
	 * @param o1 the first object to check
	 * @param o2 the second object to check
	 * @return {@code true} if both objects are of the same class, {@code false} otherwise
	 * @throws NullPointerException if either object is null
	 * @since 1.0.0
	 */
	public static boolean sameClass(Object o1, Object o2) {
		return requireNonNull(o1).getClass().equals(requireNonNull(o2).getClass());
	}

	/**
	 * Checks if all the objects are equal.
	 *
	 * @param objects the objects to check
	 * @return {@code true} if all the objects are equal, {@code false} otherwise
	 * @since 1.2.0
	 */
	public static boolean equals(Object... objects) {
		if (isNull(objects) || objects.length == 0) return false;
		Object obj = objects[0];
		for (int i = 1; i < objects.length; i++) {
			if (!obj.equals(objects[i])) return false;
		}
		return true;
	}
}
