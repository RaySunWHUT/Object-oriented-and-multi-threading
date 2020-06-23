package action.archive;

import java.util.List;

import action.BaseAction;
import common.Constants;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ListArchiveAction extends BaseAction {
	
	private List<Archive> archives;
	
	public static final String LIST_ARCHIVE_TEXT = "列出案宗";
	public static final String LIST_ERROR = "案宗库为空, 列出案宗失败！";
	
	private void input() {
		
		System.out.println(LIST_ARCHIVE_TEXT);
		
	}
	
	
	protected void print(List<Archive> archives) {
		
		for (Archive archive: archives) {
			
			System.out.println(archive);
			
		}
		
		if (!archives.isEmpty()) {
			
			System.out.println(LIST_ARCHIVE_TEXT + Constants.SUCCESSFUL);	
			
		} else {
			
			System.out.println(LIST_ERROR);
			
		}
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			archives = archiveService.getAllArchives();
			print(archives);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
		
	}
	

	@Override
	public String getText() {
		
		return LIST_ARCHIVE_TEXT;
	
	}

}
