package domain;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Administrator extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1066705624276087251L;
	
	private static String[] functionClassNames = {
			
			"action.user.CreateUserAction", 
			"action.user.UpdateUserAction", 
			"action.user.DeleteUserAction", 
			"action.user.ListUserAction", 
			"action.user.ClearUserAction",
			"action.user.ChangePasswordAction",
			"action.document.ListDocumentAction", 
			"action.document.DownloadDocumentAction",
			"action.document.DeleteDocumentAction",
			"action.archive.ListArchiveAction",
			"action.archive.DownloadArchiveAction",
			"action.archive.DeleteArchiveAction",
//			"action.ExitAction"
			
			};
	
	
	public Administrator() {
		
	}
	
	
	public String[] getFunctionClassNames() {
		
		return functionClassNames; 
		
	}

}
