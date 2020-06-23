package dao;

import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface UserDao extends BaseDao<User> {
	
	User findByName(String name) throws BaseException;

}
