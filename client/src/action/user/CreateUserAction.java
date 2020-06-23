package action.user;

import action.BaseAction;
import common.Constants;
import domain.Administrator;
import domain.Browser;
import domain.Operator;
import domain.User;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class CreateUserAction extends BaseAction {
	
	private User user;
	
	public static final String CREATE_USER_TEXT = "新增用户";
	
	private void input() {
		
    	System.out.println(CREATE_USER_TEXT);
    	
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
		
//		in.close();
		
	}
	
	
	protected void print() {
		
		System.out.println(CREATE_USER_TEXT + Constants.SUCCESSFUL);
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			userService.createUser(user);
			print();
			
		} catch (Exception e) {
			
			output(e.getMessage());
			
		}
		
	}

	@Override
	public String getText() {
		
		return CREATE_USER_TEXT;
		
	}

}
