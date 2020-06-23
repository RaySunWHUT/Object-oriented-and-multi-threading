package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ServerException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String SERVER_EXCEPTION = "服务器: ";
	
	public ServerException(String serverMsg) {
	
		super.message = SERVER_EXCEPTION + serverMsg;
	
	}
	
}
