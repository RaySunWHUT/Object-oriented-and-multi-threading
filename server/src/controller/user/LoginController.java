package controller.user;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class LoginController extends BaseController {

	@Override
	public void service() {
		
		String username = (String)message.getParameter("userName");
		String password = (String)message.getParameter("password");
		User user;
		
		try {
			
			user = userService.login(username, password);
			message.setData(user);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
	}

}
