package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import common.Constants;
import common.Message;
import controller.BaseController;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Dispatcher {
	
	private static HashMap<String, BaseController> controllers = new HashMap<String, BaseController>();
	
	static {
		
		for (String controllerClassname : Constants.CONTROLLER_CLASSNAMES) {
			
			BaseController baseController;
			
			try {
				
				baseController = (BaseController) Class.forName(controllerClassname).newInstance();
				controllers.put(baseController.getClass().getName(), baseController);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	
	public static void forward(ObjectInputStream in, ObjectOutputStream out) throws IOException, ClassNotFoundException, BaseException {
		
		Message message = (Message)in.readObject(); // read new message
		BaseController controller = controllers.get(message.getController());
		controller.setOut(out);
		controller.setIn(in);
		controller.setMessage(message);
		System.out.println(controller.getClass().getSimpleName() + " is serving ......");
		controller.service();
		
	}

}
