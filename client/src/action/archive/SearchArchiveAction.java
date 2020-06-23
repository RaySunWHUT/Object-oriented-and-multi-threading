package action.archive;

import action.BaseAction;
import common.Constants;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class SearchArchiveAction extends BaseAction {

	private String title;
	
	public static final String SEARCH_TEXT = "查找案宗";
	
	private void input() {
		
		System.out.println(SEARCH_TEXT);
		System.out.println("请输入案宗标题：");
		title = in.next();
		
	}
	
	
	protected void print(Archive archive) {
		
		System.out.println(archive);
		System.out.println(SEARCH_TEXT + Constants.SUCCESSFUL);
		
	}
	
	
	public Archive search() {
		
		Archive archive = new Archive();
		
		input();
		
		try {
			
			archive = archiveService.findByTitle(title);
			print(archive);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
		return archive;
		
	}
	
	
	
	
	@Override
	public void execute() {
		
		search();
		
	}

	@Override
	public String getText() {
		
		return SEARCH_TEXT;
	
	}

}
