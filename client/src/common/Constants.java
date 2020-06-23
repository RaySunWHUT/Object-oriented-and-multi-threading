package common;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface Constants {
	
	public static final String SUCCESSFUL = "成功！！！";

	// 所有path均需用户自定义，此处仅供参考
	public static final String DOWNLOAD_PATH = "D:\\FileBase\\downloadfile\\";
	public static final String SOURCE_PATH = "D:\\FileBase\\sourcefile\\";

	
	public static final String SERVER_ADDRESS = "localhost";
	public static final int SERVER_LISTEN_PORT = 12345;	
	public static final int SERVER_EXCEPTION_CODE = 500;
	
	public static final String LOGIN_CONTROLLER = "controller.user.LoginController";
	public static final String CHANGE_PASSWORD_CONTROLLER = "controller.user.ChangePasswordController";
	public static final String CREATE_USER_CONTROLLER = "controller.user.CreateUserController";
	public static final String UPDATE_USER_CONTROLLER = "controller.user.UpdateUserController";
	public static final String DELETE_USER_CONTROLLER = "controller.user.DeleteUserController";
	public static final String GET_ALL_USERS_CONTROLLER = "controller.user.GetAllUsersController";
	public static final String GET_USER_CONTROLLER = "controller.user.GetUserController";
	public static final String CLEAR_ALL_USERS_CONTROLLER = "controller.user.ClearAllUsersController";
	
	public static final String UPLOAD_DOCUMENT_CONTROLLER = "controller.document.UploadDocumentController";
	public static final String DOWNLOAD_DOCUMENT_CONTROLLER = "controller.document.DownloadDocumentController";
    public static final String CREATE_DOCUMENT_CONTROLLER = "controller.document.CreateDocumentController";
	public static final String DELETE_DOCUMENT_CONTROLLER = "controller.document.DeleteDocumentController";
	public static final String GET_ALL_DOCUMENTS_CONTROLLER = "controller.document.GetAllDocumentsController";
	public static final String CLEAR_ALL_DOCUMENTS_CONTROLLER = "controller.document.ClearAllDocumentsController";
	public static final String GET_DOCUMENT_CONTROLLER = "controller.document.GetDocumentController";
	
	public static final String UPLOAD_ARCHIVE_CONTROLLER = "controller.archive.UploadArchiveController";
	public static final String DOWNLOAD_ARCHIVE_CONTROLLER = "controller.archive.DownloadArchiveController";
	public static final String CREATE_ARCHIVE_CONTROLLER = "controller.archive.CreateArchiveController";
	public static final String DELETE_ARCHIVE_CONTROLLER = "controller.archive.DeleteArchiveController";
	public static final String GET_ALL_ARCHIVES_CONTROLLER = "controller.archive.GetAllArchivesController";
	public static final String CLEAR_ALL_ARCHIVES_CONTROLLER = "controller.archive.ClearAllArchivesController";
	public static final String GET_ARCHIVE_CONTROLLER = "controller.archive.GetArchiveController";
	public static final String SEARCH_ARCHIVE_CONTROLLER = "controller.archive.SearchArchiveController";
	public static final String UPDATE_ARCHIVE_CONTROLLER = "controller.archive.UpdateArchiveController";
	
	public static final String[] CONTROLLER_CLASSNAMES = {
			
			LOGIN_CONTROLLER,
			CHANGE_PASSWORD_CONTROLLER,
			GET_ALL_USERS_CONTROLLER,
			CLEAR_ALL_USERS_CONTROLLER,
			DELETE_USER_CONTROLLER,
			GET_USER_CONTROLLER,
			CREATE_USER_CONTROLLER,
			UPDATE_USER_CONTROLLER,
			
			UPLOAD_DOCUMENT_CONTROLLER,
			DOWNLOAD_DOCUMENT_CONTROLLER,
			CREATE_DOCUMENT_CONTROLLER,
			DELETE_DOCUMENT_CONTROLLER,
			GET_ALL_DOCUMENTS_CONTROLLER,
			CLEAR_ALL_DOCUMENTS_CONTROLLER,
			GET_DOCUMENT_CONTROLLER,
			
			UPLOAD_ARCHIVE_CONTROLLER,
			DOWNLOAD_ARCHIVE_CONTROLLER,
			CREATE_ARCHIVE_CONTROLLER,
			DELETE_ARCHIVE_CONTROLLER,
			GET_ALL_ARCHIVES_CONTROLLER,
			CLEAR_ALL_ARCHIVES_CONTROLLER,
			GET_ARCHIVE_CONTROLLER,
			SEARCH_ARCHIVE_CONTROLLER,
			UPDATE_ARCHIVE_CONTROLLER
			
	};
	
}
