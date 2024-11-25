package net.tp.utils;

import java.util.*;
import java.util.function.Supplier;

import static net.tp.utils.MethodUtils.noOp;
import static java.util.Objects.*;

/**
 * Utility class for collections.
 *
 * @author Tommaso Pastorelli
 * @since 1.0.0
 */
public abstract class CollectionUtils {
	/**
	 * Checks if a given collection is null or empty.
	 *
	 * @param collection the collection to check
	 * @return {@code true} if the collection is null or empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNullOrEmpty(Collection<?> collection) {
		return isNull(collection) || collection.isEmpty();
	}

	/**
	 * Checks if a given map is not null and not empty.
	 * @param map the map to check
	 * @return {@code true} if the map is not null and not empty, {@code false} otherwise
	 * @since 1.3.0
	 */
	public static boolean isNullOrEmpty(Map<?, ?> map) {
		return isNull(map) || map.isEmpty();
	}

	/**
	 * Checks if a given collection is not null and not empty.
	 *
	 * @param collection the collection to check
	 * @return {@code true} if the collection is not null and not empty, {@code false} otherwise
	 * @since 1.0.0
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isNullOrEmpty(collection);
	}

	/**
	 * Checks if a given map is not null and not empty.
	 * @param map the map to check
	 * @return {@code true} if the map is not null and not empty, {@code false} otherwise
	 * @since 1.3.0
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isNullOrEmpty(map);
	}

	/**
	 * Checks if a given collection is null or empty and throws an exception if it is.
	 *
	 * @param collection the collection to check
	 * @return {@code true} if the collection is not null and not empty
	 * @throws IllegalArgumentException if the collection is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Collection<?>> T requireNonEmpty(T collection) {
		if (isNullOrEmpty(collection)) throw new IllegalArgumentException();
		return collection;
	}

	/**
	 * Checks if a given map is null or empty and throws an exception if it is.
	 *
	 * @param map the map to check
	 * @return {@code true} if the map is not null and not empty
	 * @throws IllegalArgumentException if the map is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Map<?, ?>> T requireNonEmpty(T map) {
		if (isNullOrEmpty(map)) throw new IllegalArgumentException();
		return map;
	}

	/**
	 * Checks if a given collection is null or empty and throws an exception with the given message if it is.
	 *
	 * @param collection the collection to check
	 * @param message the message of the exception
	 * @return {@code true} if the collection is not null and not empty
	 * @throws IllegalArgumentException if the collection is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Collection<?>> T requireNonEmpty(T collection, String message) {
		if (isNullOrEmpty(collection)) throw new IllegalArgumentException(message);
		return collection;
	}

	/**
	 * Checks if a given map is null or empty and throws an exception with the given message if it is.
	 *
	 * @param map the map to check
	 * @param message the message of the exception
	 * @return {@code true} if the map is not null and not empty
	 * @throws IllegalArgumentException if the map is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Map<?, ?>> T requireNonEmpty(T map, String message) {
		if (isNullOrEmpty(map)) throw new IllegalArgumentException(message);
		return map;
	}

	/**
	 * Checks if a given collection is null or empty and returns the given default value if it is.
	 * @param collection the collection to check
	 * @param defaultValue the default value to return
	 * @return the collection if it is not null or empty, the default value otherwise
	 * @param <T> the type of the collection
	 * @since 1.5.1
	 */
	public static <T extends Collection<?>> T requireNonEmptyElse(T collection, T defaultValue) {
		return isNullOrEmpty(collection) ? defaultValue : collection;
	}

	/**
	 * Checks if a given map is null or empty and returns the given default value if it is.
	 * @param map the map to check
	 * @param defaultValue the default value to return
	 * @return the map if it is not null or empty, the default value otherwise
	 * @param <T> the type of the map
	 * @since 1.5.1
	 */
	public static <T extends Map<?, ?>> T requireNonEmptyElse(T map, T defaultValue) {
		return isNullOrEmpty(map) ? defaultValue : map;
	}

	/**
	 * Checks if a given collection is null or empty and throws an exception.
	 * @param collection the collection to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the collection if it is not null or empty
	 * @param <T> the type of the collection
	 * @param <X> the type of the exception
	 * @throws X if the collection is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Collection<?>, X extends Throwable> T requireNonEmptyElseThrow(T collection, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrEmpty(collection)) throw exceptionSupplier.get();
		return collection;
	}

	/**
	 * Checks if a given map is null or empty and throws an exception.
	 * @param map the map to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the map if it is not null or empty
	 * @param <T> the type of the map
	 * @param <X> the type of the exception
	 * @throws X if the map is null or empty
	 * @since 1.5.1
	 */
	public static <T extends Map<?, ?>, X extends Throwable> T requireNonEmptyElseThrow(T map, Supplier<X> exceptionSupplier) throws X {
		if (isNullOrEmpty(map)) throw exceptionSupplier.get();
		return map;
	}

	/**
	 * Checks if a given collection is null or empty. If false, throws an exception.
	 * @param collection the collection to check
	 * @return the collection if it is null or empty
	 * @param <T> the type of the collection
	 * @throws IllegalArgumentException if the collection is not null or empty
	 * @since 1.5.3
	 */
	public static <T extends Collection<?>> T requireNullOrEmpty(T collection) {
		if (isNotEmpty(collection)) throw new IllegalArgumentException();
		return collection;
	}

	/**
	 * Checks if a given map is null or empty. If false, throws an exception.
	 * @param map the map to check
	 * @return the map if it is null or empty
	 * @param <T> the type of the map
	 * @throws IllegalArgumentException if the map is not null or empty
	 * @since 1.5.3
	 */
	public static <T extends Map<?, ?>> T requireNullOrEmpty(T map) {
		if (isNotEmpty(map)) throw new IllegalArgumentException();
		return map;
	}

	/**
	 * Checks if a given collection is null or empty. If false, throws an exception with the given message.
	 * @param collection the collection to check
	 * @param message the message of the exception
	 * @return the collection if it is null or empty
	 * @param <T> the type of the collection
	 * @throws IllegalArgumentException if the collection is not null or empty
	 */
	public static <T extends Collection<?>> T requireNullOrEmpty(T collection, String message) {
		if (isNotEmpty(collection)) throw new IllegalArgumentException(message);
		return collection;
	}

	/**
	 * Checks if a given map is null or empty. If false, throws an exception with the given message.
	 * @param map the map to check
	 * @param message the message of the exception
	 * @return the map if it is null or empty
	 * @param <T> the type of the map
	 * @throws IllegalArgumentException if the map is not null or empty
	 * @since 1.5.3
	 */
	public static <T extends Map<?, ?>> T requireNullOrEmpty(T map, String message) {
		if (isNotEmpty(map)) throw new IllegalArgumentException(message);
		return map;
	}

	/**
	 * Checks if a given collection is null or empty. If false, returns the given default value.
	 * @param collection the collection to check
	 * @param defaultValue the default value to return
	 * @return the collection if it is null or empty, the default value otherwise
	 * @param <T> the type of the collection
	 * @since 1.5.3
	 */
	public static <T extends Collection<?>> T requireNullOrEmptyElse(T collection, T defaultValue) {
		return isNotEmpty(collection) ? defaultValue : collection;
	}

	/**
	 * Checks if a given map is null or empty. If false, returns the given default value.
	 * @param map the map to check
	 * @param defaultValue the default value to return
	 * @return the map if it is null or empty, the default value otherwise
	 * @param <T> the type of the map
	 * @since 1.5.3
	 */
	public static <T extends Map<?, ?>> T requireNullOrEmptyElse(T map, T defaultValue) {
		return isNotEmpty(map) ? defaultValue : map;
	}

	/**
	 * Checks if a given collection is null or empty. If false, throws an exception.
	 * @param collection the collection to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the collection if it is null or empty
	 * @param <T> the type of the collection
	 * @param <X> the type of the exception
	 * @throws X if the collection is not null or empty
	 * @since 1.5.3
	 */
	public static <T extends Collection<?>, X extends Throwable> T requireNullOrEmptyElseThrow(T collection, Supplier<X> exceptionSupplier) throws X {
		if (isNotEmpty(collection)) throw exceptionSupplier.get();
		return collection;
	}

	/**
	 * Checks if a given map is null or empty. If false, throws an exception.
	 * @param map the map to check
	 * @param exceptionSupplier the supplier of the exception to throw
	 * @return the map if it is null or empty
	 * @param <T> the type of the map
	 * @param <X> the type of the exception
	 * @throws X if the map is not null or empty
	 * @since 1.5.3
	 */
	public static <T extends Map<?, ?>, X extends Throwable> T requireNullOrEmptyElseThrow(T map, Supplier<X> exceptionSupplier) throws X {
		if (isNotEmpty(map)) throw exceptionSupplier.get();
		return map;
	}

	/**
	 * Adds the given values to the value (collection) of the given key in the given map.
	 *
	 * @param map the map to add the values to
	 * @param collectionSupplier the supplier of the collection to add the values to
	 * @param key the key to add the values to
	 * @param valuesToInsert the values to add to the collection
	 * @param <K> the type of the keys
	 * @param <V> the type of the values (collection of {@code IV})
	 * @param <IV> the type of the values to insert
	 * @return the map with the values added
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <K, V extends Collection<IV>, IV> Map<K, V> addToMapValue(Map<K, V> map, Supplier<V> collectionSupplier, K key, IV... valuesToInsert) {
		if (requireNonNull(map).containsKey(key)) {
			V values = requireNonNull(collectionSupplier).get();
			values.addAll(map.get(key));
			values.addAll(List.of(valuesToInsert));
			map.put(key, values);
		} else {
			V values = requireNonNull(collectionSupplier).get();
			values.addAll(List.of(valuesToInsert));
			map.put(key, values);
		}
		return map;
	}

	/**
	 * Combines multiple collections into a single collection.
	 *
	 * @param collectionSupplier the supplier of the collection to combine the collections into
	 * @param collections the collections to combine
	 * @param <T> the type of the collection
	 * @param <V> the type of the values
	 * @return the combined collection
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <T extends Collection<V>, V> T combine(Supplier<T> collectionSupplier, T... collections) {
		T collection = requireNonNull(collectionSupplier).get();
		Arrays.stream(collections).toList().forEach(collection::addAll);
		return collection;
	}

	/**
	 * Merges two maps, with the values of the recessive map overwriting the values of the dominant map.
	 *
	 * @param dominantMap the dominant map
	 * @param recessiveMap the recessive map
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the merged map
	 * @since 1.0.0
	 */
	public static <K, V> Map<K, V> mergeMaps(Map<K, V> dominantMap, Map<K, V> recessiveMap) {
		if (isNull(dominantMap) && isNull(recessiveMap)) return null;
		if (isNull(dominantMap)) return recessiveMap;
		if (isNull(recessiveMap)) return dominantMap;

		dominantMap = new HashMap<>(dominantMap);
		recessiveMap = new HashMap<>(recessiveMap);

		Set<K> dominantMapKeys = dominantMap.keySet();
		Set<K> recessiveMapKeys = recessiveMap.keySet();
		Collection<K> contributingRecessiveKeys = subtract(recessiveMapKeys, intersection(dominantMapKeys, recessiveMapKeys));
		Map<K, V> result = new HashMap<>(dominantMap);

		for (K key : contributingRecessiveKeys) {
			result.put(key, recessiveMap.get(key));
		}

		return result;
	}

	/**
	 * Merges multiple maps, with the values of the recessive maps overwriting the values of the dominant map.
	 *
	 * @param maps the maps to merge
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the merged map
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <K, V> Map<K, V> mergeMaps(Map<K, V>... maps) {
		Map<K, V> result;
		if (requireNonNull(maps).length == 0) result = null;
		else if (maps.length == 1) result = maps[0];
		else {
			result = mergeMaps(maps[0], maps[1]);
			for (int i = 2; i < maps.length; ++i) {
				result = mergeMaps(result, maps[i]);
			}
		}
		return result;
	}

	/**
	 * Returns the intersection of two collections.
	 *
	 * @param a the first collection
	 * @param b the second collection
	 * @param <E> the type of the elements
	 * @return the intersection of the two collections
	 * @since 1.0.0
	 */
	public static <E> Collection<E> intersection(Collection<E> a, Collection<E> b) {
		ArrayList<E> list = new ArrayList<>();
		Map<E, Integer> mapa = getCardinalityMap(a);
		Map<E, Integer> mapb = getCardinalityMap(b);
		Set<E> elts = new HashSet<>(a);
		elts.addAll(b);

		for (E obj : elts) {
			int i = 0;
			for (int m = Math.min(getFreq(obj, mapa), getFreq(obj, mapb)); i < m; ++i)
				list.add(obj);
		}
		return list;
	}

	/**
	 * Returns the intersection of multiple collections.
	 *
	 * @param collections the collections
	 * @param <E> the type of the elements
	 * @return the intersection of the collections
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> Collection<E> intersection(Collection<E>... collections) {
		Collection<E> result = requireNonNull(collections)[0];
		for (int i = 1; i < collections.length; ++i) {
			result = intersection(result, collections[i]);
		}
		return result;
	}

	/**
	 * Returns the intersection of two maps.
	 *
	 * @param a the first map
	 * @param b the second map
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the intersection of the two maps
	 * @since 1.3.0
	 */
	public static <K, V> Map<K, V> intersection(Map<K, V> a, Map<K, V> b) {
		Map<K, V> result = new HashMap<>();
		for (Map.Entry<K, V> entry : requireNonNull(a).entrySet()) {
			if (b.containsKey(entry.getKey()) && b.get(entry.getKey()).equals(entry.getValue())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

	/**
	 * Returns the intersection of multiple maps.
	 *
	 * @param maps the maps
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the intersection of the maps
	 * @since 1.3.0
	 */
	@SafeVarargs
	public static <K, V> Map<K, V> intersection(Map<K, V>... maps) {
		Map<K, V> result = requireNonNull(maps)[0];
		for (int i = 1; i < maps.length; ++i) {
			result = intersection(result, maps[i]);
		}
		return result;
	}

	/**
	 * Returns the subtraction of two collections.
	 *
	 * @param a the first collection
	 * @param b the second collection
	 * @param <E> the type of the elements
	 * @return the subtraction of the two collections
	 * @since 1.0.0
	 */
	public static <E> Collection<E> subtract(Collection<E> a, Collection<E> b) {
		ArrayList<E> list = new ArrayList<>(a);
		for (E aB : requireNonNull(b)) list.remove(aB);
		return list;
	}

	/**
	 * Returns the subtraction of multiple collections.
	 *
	 * @param collections the collections
	 * @param <E> the type of the elements
	 * @return the subtraction of the collections
	 * @since 1.0.0
	 */
	@SafeVarargs
	public static <E> Collection<E> subtract(Collection<E>... collections) {
		Collection<E> result = requireNonNull(collections)[0];
		for (int i = 1; i < collections.length; ++i) {
			result = subtract(result, collections[i]);
		}
		return result;
	}

	/**
	 * Returns the subtraction of two maps.
	 *
	 * @param a the first map (minuend)
	 * @param b the second map (subtrahend)
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the subtraction of the two maps
	 * @since 1.3.0
	 */
	public static <K, V> Map<K, V> subtract(Map<K, V> a, Map<K, V> b) {
		Map<K, V> result = new HashMap<>(requireNonNull(a));
		for (Map.Entry<K, V> entry : requireNonNull(b).entrySet()) {
			result.remove(entry.getKey(), entry.getValue());
		}
		return result;
	}

	/**
	 * Returns the subtraction of multiple maps.
	 *
	 * @param maps the maps
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return the subtraction of the maps
	 * @since 1.3.0
	 */
	@SafeVarargs
	public static <K, V> Map<K, V> subtract(Map<K, V>... maps) {
		Map<K, V> result = requireNonNull(maps)[0];
		for (int i = 1; i < maps.length; ++i) {
			result = subtract(result, maps[i]);
		}
		return result;
	}

	/**
	 * Return the cardinality of an object in a collection.
	 *
	 * @param collection the collection
	 * @param <E> the type of the elements
	 * @return the cardinality of the object in the collection
	 * @since 1.0.0
	 */
	public static <E> Map<E, Integer> getCardinalityMap(Collection<E> collection) {
		HashMap<E, Integer> count = new HashMap<>();

		for (E obj : requireNonNull(collection)) {
			Integer c = (Integer) count.get(obj);
			if (isNull(c)) count.put(obj, 1);
			else count.put(obj, c + 1);
		}
		return count;
	}

	/**
	 * Converts an iterator to a list.
	 *
	 * @param it the iterator to convert
	 * @param <E> the type of the elements
	 * @return the list
	 * @since 1.0.0
	 */
	public static <E> List<E> iteratorToList(Iterator<E> it) {
		if (isNull(it)) throw new NullPointerException("Iterator cannot be null.");
		else {
			List<E> list = new ArrayList<>();
			while(it.hasNext()) list.add(it.next());
			return list;
		}
	}

	private static <E> int getFreq(E obj, Map<E, Integer> freqMap) {
		try {
			Integer o = freqMap.get(obj);
			if (nonNull(o)) return o;
		} catch (NoSuchElementException | NullPointerException e) {
			noOp();
		}
		return 0;
	}

	/**
	 * Checks if a collection contains all the given elements.
	 *
	 * @param collection the collection to check
	 * @param elements the elements to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the collection contains all the elements, {@code false} otherwise
	 * @since 1.2.0
	 */
	@SafeVarargs
	public static <E> boolean containsAll(Collection<E> collection, E... elements) {
		return requireNonNull(collection).containsAll(List.of(requireNonNull(elements)));
	}

	/**
	 * Checks if a map contains all the given keys.
	 *
	 * @param map the map to check
	 * @param elements the keys to check
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return {@code true} if the map contains all the keys, {@code false} otherwise
	 * @since 1.3.0
	 */
	@SafeVarargs
	public static <K, V> boolean containsAllKeys(Map<K, V> map, K... elements) {
		return requireNonNull(map).keySet().containsAll(List.of(requireNonNull(elements)));
	}

	/**
	 * Checks if a collection contains any of the given elements.
	 *
	 * @param collection the collection to check
	 * @param elements the elements to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the collection contains any of the elements, {@code false} otherwise
	 * @since 1.2.0
	 */
	@SafeVarargs
	public static <E> boolean containsAny(Collection<E> collection, E... elements) {
		return !intersection(collection, List.of(elements)).isEmpty();
	}

	/**
	 * Checks if a map contains any of the given keys.
	 *
	 * @param map the map to check
	 * @param elements the keys to check
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return {@code true} if the map contains any of the keys, {@code false} otherwise
	 * @since 1.3.0
	 */
	@SafeVarargs
	public static <K, V> boolean containsAnyKeys(Map<K, V> map, K... elements) {
		return !intersection(requireNonNull(map).keySet(), List.of(elements)).isEmpty();
	}

	/**
	 * Checks if a collection contains none of the given elements.
	 *
	 * @param collection the collection to check
	 * @param elements the elements to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the collection contains none of the elements, {@code false} otherwise
	 * @since 1.2.0
	 */
	@SafeVarargs
	public static <E> boolean containsNone(Collection<E> collection, E... elements) {
		return intersection(collection, List.of(elements)).isEmpty();
	}

	/**
	 * Checks if a map contains none of the given keys.
	 *
	 * @param map the map to check
	 * @param elements the keys to check
	 * @param <K> the type of the keys
	 * @param <V> the type of the values
	 * @return {@code true} if the map contains none of the keys, {@code false} otherwise
	 * @since 1.3.0
	 */
	@SafeVarargs
	public static <K, V> boolean containsNoneKeys(Map<K, V> map, K... elements) {
		return intersection(requireNonNull(map).keySet(), List.of(elements)).isEmpty();
	}

	/**
	 * Checks if a collection contains duplicates.
	 *
	 * @param collection the collection to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the collection contains duplicates, {@code false} otherwise
	 * @since 1.2.0
	 */
	public static <E> boolean containsDuplicates(Collection<E> collection) {
		if (isNull(collection)) return false;
		return collection.size() != new HashSet<>(collection).size();
	}
}