package action.document;

import action.BaseAction;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DeleteDocumentAction extends BaseAction {

	private String sn;
	public static String DELETE_DOCUMENT = "删除文件";
	
	
	private void input() {
		
		System.out.println(DELETE_DOCUMENT);
		System.out.println("请输入要删除文件编号：");
		sn = in.next();
		
	}
	
	
	private void print() {
		
		System.out.println(DELETE_DOCUMENT + Constants.SUCCESSFUL);
		
	}
	
	
	@Override
	public void execute() {
		
		input();
		
		try {
			
			documentService.deleteDocument(sn);
			print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}

	
	@Override
	public String getText() {
		
		return DELETE_DOCUMENT;
	
	}
	
}
