package net.tp.utils.classes;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * A class for loops.
 * @author Tommaso Pastorelli
 * @version 1.0.0 (20241110T120347Z)
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
	 * @return The given value.
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
	 * @param action The {@link Consumer} to execute.
	 * @param times The number of times to execute the {@link Consumer}.
	 * @apiNote
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     for (int i = 0; i < times; i++) { ... }
	 * }</pre>
	 */
	public static void loop(Consumer<Integer> action, int times) {
		for (int i = 0; i < times; i++) requireNonNull(action).accept(i);
	}

	/**
	 * Loops the given {@link Runnable} until the given condition is met.
	 * @param condition The condition to check.
	 * @param action The {@link Runnable} to loop.
	 * @apiNote
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     while (!condition) {
	 *         ...
	 *     }
	 * }</pre>
	 * @since 1.0.0
	 */
	public static void loopUntil(Supplier<Boolean> condition, Runnable action) {
		while (!requireNonNull(condition).get()) requireNonNull(action).run();
	}

	/**
	 * Loops the given {@link Runnable} until the given condition is met.
	 * @param action The {@link Runnable} to loop.
	 * @param condition The condition to check.
	 * @apiNote
	 * <p>An equivalent sequence of increasing values can be produced
	 * sequentially using a {@code for} loop as follows:
	 * <pre>{@code
	 *     do {
	 *         ...
	 *     } while (!condition);
	 * }</pre>
	 * @since 1.0.0
	 */
	public static void repeatUntil(Runnable action, Supplier<Boolean> condition) {
		do requireNonNull(action).run(); while (!requireNonNull(condition).get());
	}
}
