package application.server;

import server.Listener;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ServerApplication extends Application {
	
	public static void main(String[] args) throws Exception {
		
		Listener listener = new Listener();
		listener.init();
		
	}

}
