package action.user;

import java.util.List;

import action.BaseAction;
import common.Constants;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ListUserAction extends BaseAction {
	
	private List<User> users;
	
	public static final String LIST_USER_TEXT = "列出用户";
	
	private void input() {
		
    	System.out.println(LIST_USER_TEXT);
	
	}
	

	protected void print(List<User> users) {
		
		for (User user : users) {
			
			System.out.println(user);
			
		}
		
		System.out.println(LIST_USER_TEXT + Constants.SUCCESSFUL);
		
	}

	@Override
	public void execute() {
		
		input();
		
		try {
			
			users = userService.getAllUsers();
			print(users);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return LIST_USER_TEXT;
		
	}
	
}
