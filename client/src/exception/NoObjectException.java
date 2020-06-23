package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class NoObjectException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6934854258189330871L;

	public static final String NO_OBJECT_ERROR = "不存在！";
	
	/**
	 * 实体不存在时抛出异常
	 */
	
	public NoObjectException(String objectId){
		
		super.message = objectId + NO_OBJECT_ERROR;
	
	}	

}
