package serviceImpl.client;

import java.util.List;

import common.Constants;
import common.Message;
import domain.User;
import exception.BaseException;
import service.UserService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UserServiceClient extends BaseServiceClient implements UserService {
	
	
	/**
	 * 创建用户
	 */
	public User createUser(User user) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CREATE_USER_CONTROLLER);
		message.setParameter("user", user);
		message = send(message);
		user = (User)message.getData();
		
		return user;
	
	}
	
	
	/**
	 * 删除用户
	 */
	public User deleteUser(String userName) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.DELETE_USER_CONTROLLER);
		message.setParameter("userName", userName);
		message = send(message);
		User user = (User)message.getData();
		
		return user;
		
	}
	
	
	/**
	 * 更新用户信息
	 */
	public User updateUser(User user) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.UPDATE_USER_CONTROLLER);
		message.setParameter("user", user);
		message = send(message);
		user = (User)message.getData();
		
		return user;
		
	}
	
	
	/**
	 * 修改密码
	 */
	public User changePassword(User user, String newPassword) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CHANGE_PASSWORD_CONTROLLER);
		message.setParameter("userName", user.getName());
		message.setParameter("newPassword", newPassword);
		message = send(message);
		user = (User)message.getData();
		
		return user;
	}
	
	
	/**
	 * 获取单个用户
	 */
	public User getUser(String name) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.GET_USER_CONTROLLER);
		message.setParameter("userName", name);
		message = send(message);
		User user = (User)message.getData();
		
		return user;
		
	}
	
	
	/**
	 * 获取所有用户
	 */
	public List<User> getAllUsers() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.GET_ALL_USERS_CONTROLLER);
		message = send(message);
		List<User> users = (List<User>)message.getData();
		
		return users;
		
	}
	
	
	/**
	 * 登录
	 */
	public User login(String username, String password) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.LOGIN_CONTROLLER);
		message.setParameter("userName", username);
		message.setParameter("password", password);
		message = send(message);
		User user = (User)message.getData();
		
		return user;
		
	}
	

    /**
     * 清空
     */
	@Override
	public void clear() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CLEAR_ALL_USERS_CONTROLLER);
		message = send(message);
		
	}
	
}
