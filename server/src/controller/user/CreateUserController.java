package controller.user;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class CreateUserController extends BaseController {

	@Override
	public void service() {
		
		User user = (User)message.getParameter("user");
		
		try {
			
			user = userService.createUser(user);
			message.setData(user);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
