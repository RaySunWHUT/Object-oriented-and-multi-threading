package exception;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class MenuException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String MENU_INSTANTIATION_ERROR = "功能菜单初始化异常";
	
	public MenuException() {
		
		super.message = MENU_INSTANTIATION_ERROR;
		
	}
	
}
