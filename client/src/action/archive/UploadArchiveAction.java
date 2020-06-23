package action.archive;

import action.BaseAction;
import application.client.Application;
import common.Constants;
import domain.Archive;
import domain.SecurityClassfication;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UploadArchiveAction extends BaseAction {

	private Archive archive;
	
	public static final String UPLOAD_ARCHIVE_TEXT = "上传案宗"; 
	
	private void input() {
		
		System.out.println(UPLOAD_ARCHIVE_TEXT);
		
		System.out.println("请输入源文件名：");
	    String fileName = in.next();
	    
	    System.out.println("请输入案宗标题：");
		String title = in.next();
	    
	    System.out.println("请输入关键字：");
		String keyword = in.next();
		
		System.out.println("请输入档案密级：");
		String securityClassfication = in.next();
		
		archive = new Archive();
		archive.setTitle(title);
		archive.setFileName(fileName);
		archive.setKeyword(keyword);
		archive.setSourcePath(fileName);
		archive.setSecurityClassfication(SecurityClassfication.getSecurityClassfication(securityClassfication));
		archive.setUser(Application.currentUser);
		
	}
	
	
	protected void print(Archive archive) {
		
		System.out.println(UPLOAD_ARCHIVE_TEXT + Constants.SUCCESSFUL);
		System.out.println(archive);
		
	}
	
	
	@Override
	public void execute() {
	
		input();
		
		try {
			
			Archive archive0 = archiveService.uploadArchive(archive);
			print(archive0);
			
		} catch (Exception e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return UPLOAD_ARCHIVE_TEXT;
		
	}

}
