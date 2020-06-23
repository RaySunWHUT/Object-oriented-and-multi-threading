package action.document;

import action.BaseAction;
import common.Constants;
import domain.Document;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DownloadDocumentAction extends BaseAction {
	
    private String sn;
	
	public static final String DOWNLOAD_DOCUMENT_TEXT = "下载文件";
	
	private void input() {
		
    	System.out.println(DOWNLOAD_DOCUMENT_TEXT);                        
        System.out.println("请输入档案号：");
        sn = in.next();
        
	}
	
	
	protected void print(Document document) {
		
		System.out.println(document);
		System.out.println(DOWNLOAD_DOCUMENT_TEXT + Constants.SUCCESSFUL);
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			Document document = documentService.downloadDocument(sn, null);
			print(document);
			
		} catch (Exception e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return DOWNLOAD_DOCUMENT_TEXT;
		
	}


}
