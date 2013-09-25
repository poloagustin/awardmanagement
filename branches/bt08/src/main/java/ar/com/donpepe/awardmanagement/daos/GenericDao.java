package ar.com.donpepe.awardmanagement.daos;

import java.util.List;

public interface GenericDao<T, TId> {
	List<T> getAll();
	T get(TId id);
	TId save(T obj);
	void update(T obj);
	void delete(T obj);
}
