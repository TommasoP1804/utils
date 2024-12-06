package net.tp.utils.classes;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * A class for loops.
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public abstract class Loop {
	public interface LoopTypes {}
	public static class Break extends RuntimeException implements LoopTypes {}
	public static class BreakWithValue extends RuntimeException implements LoopTypes {
		public final Object value;
		public BreakWithValue(Object value) {this.value = value;}
	}
	public static class Continue implements LoopTypes {}

	/**
	 * Breaks the current loop.
	 * @see Loop#loop(Runnable)
	 * @since 1.0.0
	 */
	public static void breakLoop() {
		throw new Break();
	}

	/**
	 * Returns the given value and breaks the current loop.
	 * @param value The value to return.
	 * @param <V> The type of the value.
	 * @since 1.0.0
	 */
	public static <V> void breakAndReturn(V value) {
		throw new BreakWithValue(value);
	}

	/**
	 * Loops the given {@link Runnable} until a {@link Break} is thrown.
	 * For throw a {@link Break} use {@link Loop#breakLoop()}.
	 * @param runnable The {@link Runnable} to loop.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loop(Runnable runnable) {
		for (;;) {
			try {
				requireNonNull(runnable, "Runnable is null.").run();
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}


	/**
	 * Executes the given {@link Consumer} a given number of times.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (int i = start; i < start + times * steps; i+= steps) { ... }
	 * }</pre>
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param steps The number of steps to increment the lambda integer.
	 * @param times The number of times to execute the {@link Consumer}.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopI(Consumer<Integer> action, int start, int steps, int times) {
		for (int i = start; i < start + times * steps; i += steps) {
			try {
				requireNonNull(action).accept(i);
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Executes the given {@link Consumer} a given number of times.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (int i = start; i < times; i++) { ... }
	 * }</pre>
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param times The number of times to execute the {@link Consumer}.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopI(Consumer<Integer> action, int start, int times) {
		return loopI(action, start, 1, times);
	}

	/**
	 * Executes the given {@link Consumer} a given number of times.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (int i = 0; i < times; i++) { ... }
	 * }</pre>
	 * @param action The {@link Consumer} to execute.
	 * @param times The number of times to execute the {@link Consumer}.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopI(Consumer<Integer> action, int times) {
		return loopI(action, 0, times);
	}

	/**
	 * Executes the given {@link Consumer} until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *    for (int i = start; i <= end; i += steps) { ... }
	 * }</pre> for closed range, otherwise:
	 * <pre>{@code
	 *   for (int i = start; i < end; i += steps) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param end The final value of the lambda integer.
	 * @param closed If the range is closed.
	 * @param steps The number of steps to increment the lambda integer.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int start, int end, boolean closed, int steps) {
		for (int i = start; closed ? i <= end : i < end; i += steps) {
			try {
				requireNonNull(action).accept(i);
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Executes the given {@link Consumer} until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *    for (int i = 0; i <= end; i += steps) { ... }
	 * }</pre> for 0 range, otherwise:
	 * <pre>{@code
	 *   for (int i = start; i < end; i += steps) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param end The final value of the lambda integer.
	 * @param closed If the range is closed.
	 * @param steps The number of steps to increment the lambda integer.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int end, boolean closed, int steps) {
		return loopRange(action, 0, end, closed, steps);
	}

	/**
	 * Executes the given {@link Consumer} until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *    for (int i = 0; i <= end; i++) { ... }
	 * }</pre> for 0 range, otherwise:
	 * <pre>{@code
	 *   for (int i = start; i < end; i++) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param end The final value of the lambda integer.
	 * @param closed If the range is closed.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int end, boolean closed) {
		return loopRange(action, 0, end, closed, 1);
	}

	/**
	 * Executes the given {@link Consumer} until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *   for (int i = start; i < end; i+= steps) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param end The final value of the lambda integer.
	 * @param steps The number of steps to increment the lambda integer.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int start, int end, int steps) {
		return loopRange(action, start, end, false, steps);
	}

	/**
	 * Executes the given {@link Consumer} a number until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *    for (int i = start; i <= end; i++) { ... }
	 * }</pre> for closed range, otherwise:
	 * <pre>{@code
	 *   for (int i = start; i < end; i++) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param end The final value of the lambda integer.
	 * @param closed If the range is closed.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int start, int end, boolean closed) {
		return loopRange(action, start, end, closed, 1);
	}

	/**
	 * Executes the given {@link Consumer} a number until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *   for (int i = start; i < end; i++) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param start The initial value of the lambda integer.
	 * @param end The final value of the lambda integer.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int start, int end) {
		return loopRange(action, start, end, false, 1);
	}

	/**
	 * Executes the given {@link Consumer} a number until reach {@code end}.
	 *
	 * <p>
	 * An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *   for (int i = 0; i < end; i++) { ... }
	 * }</pre>
	 *
	 * @param action The {@link Consumer} to execute.
	 * @param end The final value of the lambda integer.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loopRange(Consumer<Integer> action, int end) {
		return loopRange(action, 0, end, false, 1);
	}

	/**
	 * Loops the given {@link Runnable} until the given condition is met.
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     while (!condition) {
	 *         ...
	 *     }
	 * }</pre>
	 * @param condition The condition to check.
	 * @param action The {@link Runnable} to loop.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loop(Supplier<Boolean> condition, Runnable action) {
		while (!requireNonNull(condition).get()) {
			try {
				requireNonNull(action).run();
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Loops the given {@link Runnable} until the given condition is met. The first run is always made.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     do {
	 *         ...
	 *     } while (!condition);
	 * }</pre>
	 * @param action The {@link Runnable} to loop.
	 * @param condition The condition to check.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <V> V loop(Runnable action, Supplier<Boolean> condition) {
		do {
			try {
				requireNonNull(action).run();
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		} while (!requireNonNull(condition).get());
		return null;
	}

	/**
	 * Loops the given {@link Runnable} for each element of the given array.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (T element : array) {
	 *         ...
	 *     }
	 * }</pre>
	 * @param array The array to loop.
	 * @param consumer The {@link Runnable} to loop.
	 * @param <T> The type of the array.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <T, V> V loop(Consumer<T> consumer, T[] array) {
		for (T t : requireNonNull(array)) {
			try {
				consumer.accept(t);
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Loops the given {@link Consumer} for each element of the given array.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (int i = 0; i < array.length; i++) {
	 *         ...
	 *     }
	 * }</pre>
	 * @param array The array to loop.
	 * @param action The {@link Consumer} to loop.
	 * @param <T> The type of the array.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <T, V> V loopI(Consumer<Integer> action, T[] array) {
		for (int i = 0; i < requireNonNull(array).length; i++) {
			try {
				action.accept(i);
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Loops the given {@link Consumer} for each element of the given {@link Iterable}.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (T element : iterable) {
	 *         ...
	 *     }
	 * }</pre>
	 * @param iterable The {@link Iterable} to loop.
	 * @param consumer The {@link Consumer} to loop.
	 * @param <T> The type of the {@link Iterable}.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <T, V> V loop(Consumer<T> consumer, Iterable<T> iterable) {
		for (T t : requireNonNull(iterable)) {
			try {
				consumer.accept(t);
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}

	/**
	 * Loops the given {@link Consumer} for each element of the given {@link Map}.
	 *
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *    for (Map.Entry<TK, TV> entry : map.entrySet()) {
	 *        ...
	 *    }
	 * }</pre>
	 *
	 * @param consumer The {@link Consumer} to loop.
	 * @param map The {@link Map} to loop.
	 * @param <TK> The type of the keys.
	 * @param <TV> The type of the values.
	 * @param <V> The type of the value to return.
	 * @return The value returned by {@link #breakAndReturn}.
	 * @since 1.8.0
	 */
	public static <TK, TV, V> V loop(BiConsumer<TK, TV> consumer, Map<TK, TV> map) {
		for (Map.Entry<TK, TV> entry : requireNonNull(map).entrySet()) {
			try {
				consumer.accept(entry.getKey(), entry.getValue());
			} catch (Break e) {
				break;
			} catch (BreakWithValue e) {
				@SuppressWarnings("unchecked")
				V value = (V) e.value;
				return value;
			}
		}
		return null;
	}
}
