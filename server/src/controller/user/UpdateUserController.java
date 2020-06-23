package controller.user;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UpdateUserController extends BaseController {

	@Override
	public void service() {
		
		User user = (User)message.getParameter("user");
		
		try {
			
			user = userService.updateUser(user);
			message.setData(user);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
