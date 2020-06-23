package action.document;

import action.BaseAction;
import application.client.Application;
import common.Constants;
import domain.Document;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UploadDocumentAction extends BaseAction {
	
	private Document document;
	
	public static final String UPLOAD_DOCUMENT_TEXT = "上传文件";
	
	private void input() {
		
    	System.out.println(UPLOAD_DOCUMENT_TEXT);                        
        System.out.println("请输入源文件名：");
        String filename = in.next();
        System.out.println("请输入档案号：");
        String sn = in.next();
        System.out.println("请输入档案描述：");
        String description = in.next();
        
        document = new Document();
        document.setSn(sn);
        document.setDescription(description);
        document.setSourcePath(filename);
        document.setUser(Application.currentUser);
        
	}
	
	
	protected void print() {
		
		System.out.println(UPLOAD_DOCUMENT_TEXT + Constants.SUCCESSFUL);
		
	}

	@Override
	public void execute() {
		
		input();
		
		try {
			
			documentService.uploadDocument(document); 
		    print();
			
		} catch (Exception e) {
			
			output(e.getMessage());
			
		}
		
	}

	@Override
	public String getText() {
		
		return UPLOAD_DOCUMENT_TEXT;
		
	}

}
