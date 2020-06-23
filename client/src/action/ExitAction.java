package action;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ExitAction extends BaseAction {
	
	public static final String EXIT_TEXT = "退出系统";
	
	
	@Override
	public void execute() {
	
		System.out.println("系统退出, 谢谢使用 ! ");
		System.exit(0);
	
	}

	
	@Override
	public String getText() {
	
		return EXIT_TEXT;
	
	}
	
}
