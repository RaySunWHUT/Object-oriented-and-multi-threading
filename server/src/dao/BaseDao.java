package dao;

import java.util.List;

import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface BaseDao<T> {
	
	T insert(T object) throws BaseException;

	T update(T object) throws BaseException;

	T delete(T object) throws BaseException;

	T findById(long id) throws BaseException;

	List<T> findAllOnes() throws BaseException;

}
