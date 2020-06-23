package controller.user;

import controller.BaseController;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearAllUsersController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			userService.clear();
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
