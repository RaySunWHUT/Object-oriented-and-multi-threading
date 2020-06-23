package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class NetworkException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String NETWORK_EXCEPTION = "网络访问异常";
	
	public NetworkException(){
		
		super.message = NETWORK_EXCEPTION;
		
	}
	
}
