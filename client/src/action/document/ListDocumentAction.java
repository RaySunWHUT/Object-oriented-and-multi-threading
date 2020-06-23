package action.document;

import java.util.List;

import action.BaseAction;
import common.Constants;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ListDocumentAction extends BaseAction {
	
	private List<Document> documents;
	
	public static final String LIST_DOCUMENT_TEXT = "列出文件";
	public static final String LIST_ERROR = "文件夹为空, 列出文件失败！";
	
	
	private void input() {
		
    	System.out.println(LIST_DOCUMENT_TEXT);
    	
	}
	
	protected void output(List<Document> documents) {
		
		for (Document document : documents) {
			
			System.out.println(document);
			
		}
		
		if (!documents.isEmpty()) {
			
			System.out.println(LIST_DOCUMENT_TEXT + Constants.SUCCESSFUL);	
			
		} else {
			
			System.out.println(LIST_ERROR);
			
		}
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			documents = documentService.getAllDocuments();
			output(documents);
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return LIST_DOCUMENT_TEXT;
	
	}
	
}
