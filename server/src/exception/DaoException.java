package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DaoException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	
	public static String DAO_ACCESS_ERROR = "数据访问异常";
	
	public DaoException() {
		
		super.message = DAO_ACCESS_ERROR;
		
	}

}
