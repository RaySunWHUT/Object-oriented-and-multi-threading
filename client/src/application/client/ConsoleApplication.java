package application.client;

import action.MainAction;
import action.user.LoginAction;
import domain.User;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ConsoleApplication extends Application {
	
	public static void main(String[] args) throws Exception {

		LoginAction loginAction = new LoginAction();

		while (true) {
			
			User user = loginAction.login();
			Application.currentUser = user;
			
			if (user != null) {
				
					MainAction mainAction = new MainAction();
					mainAction.execute();
					
			}
		    
		}
		
	}
	
}
