package action.user;

import action.BaseAction;
import common.Constants;
import domain.Administrator;
import domain.Browser;
import domain.Operator;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UpdateUserAction extends BaseAction {
	
	private User user;
	
	public static final String UPDATE_USER_TEXT = "修改用户";
	
	private void input() {
		
    	System.out.println(UPDATE_USER_TEXT);
    	
    	System.out.println("请输入用户名：");
        String name = in.next();
        
        System.out.println("请输入口令：");
        String password = in.next();
        
        System.out.println("请输入角色：");
        String role = in.next();
		
		switch (role.toLowerCase()) {
		
		case "administrator" :
			user = new Administrator();
			break;
			
		case "operator" :
			user = new Operator();
			break;
			
		default :
			user = new Browser();
			
		}
		
		user.setName(name);
		user.setPassword(password);
		
	}
	
	
	@Override
	public void execute() {
		
		try {
			
			input();
			userService.updateUser(user);
			output(UPDATE_USER_TEXT + Constants.SUCCESSFUL);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}
	

	@Override
	public String getText() {
		
		return UPDATE_USER_TEXT;
		
	}
	
}
