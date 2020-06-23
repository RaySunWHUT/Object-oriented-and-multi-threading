package action.user;

import action.BaseAction;
import domain.User;
import exception.BaseException;
import service.UserService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class LoginAction extends BaseAction {
	
	private String userName;
	private String password;
	
	public static final String LOGIN_TEXT = "用户登录";
	
	
	private void input() {
		
		System.out.println(LOGIN_TEXT);
        System.out.print("请输入用户名：");		
        userName = in.next();
        System.out.print("请输入口令：");
        password = in.next();
        
	}
	
	
	public User login() {
		
		User user = null;
		input();
		
		try {
			
			user = userService.login(userName, password);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
		return user;
		
	}

	public String getUsername() {
		
		return userName;
		
	}

	public void setUsername(String userName) {
		
		this.userName = userName;
		
	}
	

	public String getPassword() {
		
		return password;
		
	}

	public void setPassword(String password) {
           
		this.password = password;
		
	}
	
	
	public void setUserService(UserService userService) {
		
		this.userService = userService;
		
	}

	
	@Override
	public void execute() {
		
	}

	
	@Override
	public String getText() {
		
		return LOGIN_TEXT;
		
	}

}
