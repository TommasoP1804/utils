package net.tp.utils.classes;

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
	 * Loops the given {@link Runnable} until a {@link Break} is thrown.
	 * For throw a {@link Break} use {@link Loop#breakLoop()}.
	 * @param runnable The {@link Runnable} to loop.
	 * @since 1.0.0
	 */
	public static void loop(Runnable runnable) {
		for (;;) {
			try {
				requireNonNull(runnable, "Runnable is null.").run();
			} catch (Break e) {
				break;
			}
		}
	}

	/**
	 * Returns the given value and breaks the current loop.
	 * @param value The value to return.
	 * @param <V> The type of the value.
	 * @see Loop#loop(Supplier)
	 * @since 1.0.0
	 */
	public static <V> void breakAndReturn(V value) {
		throw new BreakWithValue(value);
	}

	/**
	 * Continue the current loop.
	 * @see Loop#loop(Supplier)
	 * @since 1.0.0
	 */
	public static Continue continueLoop() {
		return new Continue();
	}

	/**
	 * Loops the given {@link Supplier} until a {@link Loop#breakAndReturn(Object)} is returned.
	 * Continue the loop with {@link Loop#continueLoop()}.
	 *
	 * <p>
	 * Always end the loop with:
	 * <pre>{@code
	 * {
	 *     ...
	 *     return continueLoop();
	 * });
	 * }</pre>
	 *
	 * @param supplier The {@link Supplier} to loop.
	 * @param <V> The type of the value to return.
	 * @return The value returned by the {@link Loop#breakAndReturn(Object)}.
	 * @since 1.0.0
	 */
	public static <T extends LoopTypes, V> V loop(Supplier<T> supplier) {
		try {
			for (;;) {
				T result = requireNonNull(supplier, "Supplier is null.").get();
			}
		} catch (BreakWithValue e) {
			@SuppressWarnings("unchecked")
			V value = (V) e.value;
			return value;
		}
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
	 * @since 1.2.0
	 */
	public static void loop(Consumer<Integer> action, int start, int steps, int times) {
		for (int i = start; i < start + times * steps; i += steps) {
			try {
				requireNonNull(action).accept(i);
			} catch (Break e) {
				break;
			}
		}
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
	 * @since 1.2.0
	 */
	public static void loop(Consumer<Integer> action, int start, int times) {
		loop(action, start, 1, times);
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
	 * @since 1.0.0
	 */
	public static void loop(Consumer<Integer> action, int times) {
		loop(action, 0, times);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int start, int end, boolean closed, int steps) {
		for (int i = start; closed ? i <= end : i < end; i += steps) {
			try {
				requireNonNull(action).accept(i);
			} catch (Break e) {
				break;
			}
		}
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int end, boolean closed, int steps) {
		loopRange(action, 0, end, closed, steps);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int end, boolean closed) {
		loopRange(action, 0, end, closed, 1);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int start, int end, int steps) {
		loopRange(action, start, end, false, steps);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int start, int end, boolean closed) {
		loopRange(action, start, end, closed, 1);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int start, int end) {
		loopRange(action, start, end, false, 1);
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
	 * @since 1.2.0
	 */
	public static void loopRange(Consumer<Integer> action, int end) {
		loopRange(action, 0, end, false, 1);
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
	 * @since 1.2.0
	 */
	public static void loop(Supplier<Boolean> condition, Runnable action) {
		while (!requireNonNull(condition).get()) {
			try {
				requireNonNull(action).run();
			} catch (Break e) {
				break;
			}
		}
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
	 * @since 1.2.0
	 */
	public static void loop(Runnable action, Supplier<Boolean> condition) {
		do {
			try {
				requireNonNull(action).run();
			} catch (Break e) {
				break;
			}
		} while (!requireNonNull(condition).get());
	}
}
