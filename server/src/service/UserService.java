package service;


import java.util.List;

import dao.UserDao;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface UserService {
	
    void setUserDao(UserDao userDao);
	
	User createUser(User user) throws BaseException;
	
	User deleteUser(String userName) throws BaseException;
	
	User updateUser(User user) throws BaseException;
	
	User changePassword(User user, String newPassword) throws BaseException;
	
	User getUser(String name) throws BaseException;
	
	List<User> getAllUsers() throws BaseException;
	
	User login(String username, String password) throws BaseException;
	
	void clear() throws BaseException;

}
