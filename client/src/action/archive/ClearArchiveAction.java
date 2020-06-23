package action.archive;

import action.BaseAction;
import common.Constants;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearArchiveAction extends BaseAction{
	
	public static final String CLEAR_ARCHIVES = "清空案宗";

	
	protected void print() {
		
		System.out.println(CLEAR_ARCHIVES + Constants.SUCCESSFUL);
		
	}
	
	@Override
	public void execute() {
		
		try {
			
			archiveService.clear();
			print();
			
		} catch (BaseException e) {
			
			output(e.getMessage());
			
		}
		
	}
	

	@Override
	public String getText() {
		
		return CLEAR_ARCHIVES;
	}
	
	
	

}
