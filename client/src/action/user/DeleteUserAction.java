package action.user;

import action.BaseAction;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DeleteUserAction extends BaseAction {
	
    private String userName;
	
	public static final String DELETE_USER_TEXT = "删除用户";
	
	private void input() {
		
    	System.out.println(DELETE_USER_TEXT);
    	System.out.println("请输入用户名：");
    	userName = in.next();
    	
	}

	
	protected void print() {
		
		System.out.println(DELETE_USER_TEXT + Constants.SUCCESSFUL); 
		
	}
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			userService.deleteUser(userName);
			print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}
	

	@Override
	public String getText() {
		
		return DELETE_USER_TEXT;
		
	}
	
	
}
