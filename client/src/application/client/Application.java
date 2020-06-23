package application.client;

import domain.User;
import service.ArchiveService;
import service.DocumentService;
import service.UserService;
import serviceImpl.client.ArchiveServiceClient;
import serviceImpl.client.DocumentServiceClient;
import serviceImpl.client.UserServiceClient;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Application {
	
	public static User currentUser;
	public static UserService userService;
	public static DocumentService documentService;
	public static ArchiveService archiveService;
	
	static {
		
//		UserDao userDao = new UserDaoContainer();
//		UserDao userDao = new UserDaoContainerFile();
//		UserDao userDao = new UserDaoJdbc();
//		userService = new UserServiceImpl();
//		userService.setUserDao(userDao);
		
		userService = new UserServiceClient();
		
		
//		DocumentDao documentDao = new DocumentDaoContainer();
//		DocumentDao documentDao = new DocumentDaoContainerFile();
//		DocumentDao documentDao = new DocumentDaoJdbc();
//		documentService = new DocumentServiceImpl();
//		documentService.setDocumentDao(documentDao);
		
		documentService = new DocumentServiceClient();
	
		
//		ArchiveDao archiveDao = new ArchiveDaoContainer();
//		ArchiveDao archiveDao = new ArchiveDaoContainerFile();
//		ArchiveDao archiveDao = new ArchiveDaoJdbc();
//		archiveService = new ArchiveServiceImpl();
//		archiveService.setArchiveDao(archiveDao);
		
		archiveService = new ArchiveServiceClient();
		
	}

	
	public static void main(String[] args) throws Exception {
		
		System.out.println("请运行Application的子类");
		
	}

}
