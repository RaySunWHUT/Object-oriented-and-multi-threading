package controller.user;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ChangePasswordController extends BaseController {

	@Override
	public void service() {
		
		String username = (String)message.getParameter("userName");
		String newPassword = (String)message.getParameter("newPassword");
		User user;
		
		try {
			
			user = userService.getUser(username);
			user = userService.changePassword(user, newPassword);
			message.setData(user);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
