package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class MenuIndexException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String MENU_INPUT_ERROR = "请输入有效的菜单编号！";
	
	public MenuIndexException() {
		
		super.message = MENU_INPUT_ERROR;
		
	}
	
}
