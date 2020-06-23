package action.user;

import action.BaseAction;
import application.client.Application;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ChangePasswordAction extends BaseAction {
	
    private String newPassword;
	
    public static final String CHANGE_PASSWORD_TEXT = "修改本人密码";
	
	private void input() {
		
    	System.out.println(CHANGE_PASSWORD_TEXT);
        System.out.println("请输入口令：");
        newPassword = in.next();
        
	}
	
	
	protected void print() {
		
		System.out.println(CHANGE_PASSWORD_TEXT + Constants.SUCCESSFUL);
		
	}
	

	@Override
	public void execute() {
		
		input();
		
		try {
			
			userService.changePassword(Application.currentUser, newPassword);
	        print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return CHANGE_PASSWORD_TEXT;
		
	}
	
}
