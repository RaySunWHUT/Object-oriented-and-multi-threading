package domain;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Operator extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4297888953645666305L;
	private static String[] functionClassNames = {
			
			"action.document.UploadDocumentAction", 
			"action.document.DownloadDocumentAction", 
			"action.document.ListDocumentAction", 
			"action.document.DeleteDocumentAction",
			"action.document.ClearDocumentAction",
			"action.user.ChangePasswordAction",
			"action.archive.UploadArchiveAction",   
			"action.archive.DownloadArchiveAction",
			"action.archive.ListArchiveAction",      
			"action.archive.UpdateArchiveAction",
			"action.archive.DeleteArchiveAction",
			"action.archive.SearchArchiveAction",
			"action.archive.ClearArchiveAction",
//			"action.ExitAction"
			
			};
	
	public String[] getFunctionClassNames() {
		
		return functionClassNames; 
		
	}
	
}
