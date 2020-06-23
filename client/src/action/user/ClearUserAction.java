package action.user;

import action.BaseAction;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearUserAction extends BaseAction {
	
	public static final String CLEAR_USERS = "清空用户";

	protected void print() {
		
		System.out.println(CLEAR_USERS + Constants.SUCCESSFUL);
		
	}
	
	@Override
	public void execute() {
		
		try {
			
			userService.clear();
			print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		 
	}
	

	@Override
	public String getText() {

		return CLEAR_USERS;
	
	}
	
}
