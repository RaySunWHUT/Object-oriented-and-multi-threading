
package serviceImpl;

import java.util.List;


import dao.UserDao;
import domain.User;
import exception.BaseException;
import exception.HaveExistException;
import exception.NoObjectException;
import exception.PasswordEqualException;
import exception.PasswordErrorException;
import service.UserService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
		
	}
	
	
	public User createUser(User user) throws BaseException {
		
		if (userDao.findByName(user.getName()) != null) {
			
			throw new HaveExistException(user.getName());
			
		}
		
		return userDao.insert(user);
		
	}
	
	
	public User deleteUser(String userName) throws BaseException {
		
		User user = userDao.findByName(userName);
		
		if (user == null) {
			
			throw new NoObjectException(userName);
			
		}
		
		return userDao.delete(user);
		
	}
	
	
	public User updateUser(User user) throws BaseException {
		
		if (userDao.findByName(user.getName()) == null) {  // 通过名字关键字查找
			
			throw new NoObjectException(user.getName());
			
		}
		
		return userDao.update(user);
		
	}
	
	
	public User changePassword(User user, String newPassword) throws BaseException {
		
		if (user == null || userDao.findByName(user.getName()) == null) {   // 用户不存在或user为null
			
			throw new NoObjectException(user.getName());
			
		}		
		
		if (user.getPassword().equals(newPassword)) {  // 新旧密码相同 
			
			throw new PasswordEqualException();
			
		}
		
		user.setPassword(newPassword);
		
		return userDao.update(user);
		
	}
	
	
	public User getUser(String name) throws BaseException {
		
		return userDao.findByName(name);
		
	}
	
	
	public List<User> getAllUsers() throws BaseException {
		
		return userDao.findAllOnes();
		
	}
	
	
	public User login(String username, String password) throws BaseException {
		
		User user = userDao.findByName(username);
		
		if (user == null) {
			
			throw new NoObjectException(username);
			
		} else if (!user.getPassword().equals(password)) {
			
			throw new PasswordErrorException();
			
		}
		
		return user;
		
	}

	
	@Override
	public void clear() throws BaseException {
		
		List<User> users = userDao.findAllOnes();
		
		for (User user : users) {
			
			userDao.delete(user);
			
		}
		
	}

}

