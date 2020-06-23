package controller.user;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class GetUserController extends BaseController {

	@Override
	public void service() {
		
		String username = (String)message.getParameter("userName");
		User user;
		
		try {
			
			user = userService.getUser(username);
			message.setData(user);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
