package action.document;

import action.BaseAction;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearDocumentAction extends BaseAction {

	public static final String CLEAR_DOCUMENTS = "清空文件";

	
	protected void print() {
		
		System.out.println(CLEAR_DOCUMENTS + Constants.SUCCESSFUL);
		
	}
	
	@Override
	public void execute() {
		
		try {
			
			documentService.clear();
			print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return CLEAR_DOCUMENTS;
	
	}
	
}
