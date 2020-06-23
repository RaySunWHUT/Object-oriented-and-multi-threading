package action.archive;

import action.BaseAction;
import common.Constants;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DeleteArchiveAction extends BaseAction {

	private String title;
	
	public static final String DELETE_ARCHIVE = "删除案宗";
	
	
	private void input() {
		
		System.out.println(DELETE_ARCHIVE);
		System.out.println("请输入要删除的案宗标题:");
		title = in.next();
		
	}
	
	
	private void print(Archive archive) {
		
		System.out.println(archive);
		System.out.println(DELETE_ARCHIVE + Constants.SUCCESSFUL);
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			Archive archive = archiveService.deleteArchive(title);
			print(archive);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return DELETE_ARCHIVE;
		
	}

}
