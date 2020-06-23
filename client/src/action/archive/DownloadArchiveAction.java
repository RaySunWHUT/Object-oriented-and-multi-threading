package action.archive;

import action.BaseAction;
import common.Constants;
import domain.Archive;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DownloadArchiveAction extends BaseAction {

	private String title;
	
	public static final String DOWNLOAD_ARCHIVE_TEXT = "下载案宗";
	
	private void input() {
		
		System.out.println(DOWNLOAD_ARCHIVE_TEXT);
		System.out.println("请输入案宗标题:");
		title = in.next();
		
	}
	
	protected void print(Archive archive) {
		
		System.out.println(archive);
		System.out.println(DOWNLOAD_ARCHIVE_TEXT + Constants.SUCCESSFUL);
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			Archive archive = archiveService.downloadArchive(title, null);
			print(archive);
			
		} catch (Exception e) {
			
			output(e.getMessage());
			
		}
		
	}
	

	@Override
	public String getText() {
		
		return DOWNLOAD_ARCHIVE_TEXT;
	
	}

}
