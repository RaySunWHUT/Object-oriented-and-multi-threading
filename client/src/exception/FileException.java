package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class FileException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String FILE_ACCESS_ERROR = "文件访问异常";
	
	public FileException() {
		
		super.message = FILE_ACCESS_ERROR;
		
	}
	
}
