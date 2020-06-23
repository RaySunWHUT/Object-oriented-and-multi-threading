package domain;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Browser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -465292455052819445L;
	
	private static String[] functionClassNames = {
			
			"action.document.DownloadDocumentAction", 
			"action.document.ListDocumentAction", 
			"action.user.ChangePasswordAction",
			"action.archive.ListArchiveAction",
			"action.archive.DownloadArchiveAction",
			"action.archive.SearchArchiveAction"
			
			};
	
	public String[] getFunctionClassNames() {
		
		return functionClassNames; 
		
	}

}
