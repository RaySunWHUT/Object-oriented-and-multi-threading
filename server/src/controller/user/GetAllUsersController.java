package controller.user;

import java.util.List;

import controller.BaseController;
import domain.User;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class GetAllUsersController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			List<User> users = userService.getAllUsers();
			message.setData(users);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
