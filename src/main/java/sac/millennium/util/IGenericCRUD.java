package sac.millennium.util;

import java.util.List;

public interface IGenericCRUD<T, K> {

	List<T> findAll();

	T create(T obj);

	T update(T obj);

	void delete(K key);

	T findById(K key);
}
