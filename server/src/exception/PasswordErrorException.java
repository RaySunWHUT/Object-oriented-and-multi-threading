package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class PasswordErrorException extends BaseException {

	/**
	 * password错误时抛出异常
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public static final String PASSWORD_ERROR_ERROR = "密码错误！";
	
	public PasswordErrorException() {
		
		super.message = PASSWORD_ERROR_ERROR;
		
	}

}
