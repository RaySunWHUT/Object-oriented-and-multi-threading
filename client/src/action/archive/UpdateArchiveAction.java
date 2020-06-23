package action.archive;

import action.BaseAction;
import common.Constants;
import domain.Archive;
import domain.SecurityClassfication;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UpdateArchiveAction extends BaseAction {

	private Archive archive = new Archive();
	
	public static final String UPDDATE_ARCHVIE_TEXT = "修改案宗";
	
	private void input() {
		
		System.out.println(UPDDATE_ARCHVIE_TEXT);
		
		System.out.println("请输入案宗标题: ");
		String title = in.next();
		
		System.out.println("请输入案宗文件名：");
		String fileName = in.next();
		
		System.out.println("请输入案宗关键字：");
		String keyword = in.next();
		
		System.out.println("请输入案宗密级：");
		String securityClassfication = in.next();
		
		System.out.println("请输入源文件名：");
		String sourcePath = in.next();
		
		archive.setTitle(title);
		archive.setFileName(fileName);
		archive.setKeyword(keyword);
		archive.setSecurityClassfication(SecurityClassfication.getSecurityClassfication(securityClassfication));
		archive.setSourcePath(sourcePath);
		
	}
	
	
	private void print(Archive archive) {
	
		System.out.println(archive);
		System.out.println(UPDDATE_ARCHVIE_TEXT + Constants.SUCCESSFUL);
	}
	
	
	@Override
	public void execute() {
		
		try {
			
			input();
			Archive archive0 = archiveService.updateArchive(archive);
		    print(archive0);
			 
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}
	

	@Override
	public String getText() {
		
		return UPDDATE_ARCHVIE_TEXT;
	
	}

}
