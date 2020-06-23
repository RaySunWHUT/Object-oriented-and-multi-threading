package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class PasswordEqualException extends BaseException {

	/**
	 * 新旧password相同时抛出异常
	 */
	private static final long serialVersionUID = -8077530677006565701L;
	
	public static final String PASSWORD_ERROR_ERROR = "新旧密码不能相同！";
	
	public PasswordEqualException(){
		
		super.message = PASSWORD_ERROR_ERROR;
		
	}
	
}
