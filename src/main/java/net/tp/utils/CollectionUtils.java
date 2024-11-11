package net.tp.utils;

import java.util.*;
import java.util.function.Supplier;

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
	 * @param <T> the type of the elements
	 * @return the subtraction of the collections
	 * @since 1.0.0
	 */
	public static <T> Collection<T> subtract(Collection<T>... collections) {
		Collection<T> result = requireNonNull(collections)[0];
		for (int i = 1; i < collections.length; ++i) {
			result = subtract(result, collections[i]);
		}
		return result;
	}

	public static <E> Map<E, Integer> getCardinalityMap(Collection<E> col) {
		HashMap<E, Integer> count = new HashMap<>();

		for (E obj : requireNonNull(col)) {
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
		if (isNull(it)) throw new NullPointerException("it cannot be null.");
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
	public static <E> boolean containsAll(Collection<E> collection, E... elements) {
		return requireNonNull(collection).containsAll(List.of(requireNonNull(elements)));
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
	 * Checks if a collection contains none of the given elements.
	 *
	 * @param collection the collection to check
	 * @param elements the elements to check
	 * @param <E> the type of the elements
	 * @return {@code true} if the collection contains none of the elements, {@code false} otherwise
	 * @since 1.2.0
	 */
	public static <E> boolean containsNone(Collection<E> collection, E... elements) {
		return intersection(collection, List.of(elements)).isEmpty();
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
