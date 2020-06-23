package application.server;

import dao.ArchiveDao;
import dao.DocumentDao;
import dao.UserDao;
import daoImpl.jdbc.ArchiveDaoJdbc;
import daoImpl.jdbc.DocumentDaoJdbc;
import daoImpl.jdbc.UserDaoJdbc;
import domain.Administrator;
import domain.Archive;
import domain.Browser;
import domain.Document;
import domain.Operator;
import domain.SecurityClassfication;
import domain.User;
import service.ArchiveService;
import service.DocumentService;
import service.UserService;
import serviceImpl.ArchiveServiceImpl;
import serviceImpl.DocumentServiceImpl;
import serviceImpl.UserServiceImpl;


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
		UserDao userDao = new UserDaoJdbc();
		userService = new UserServiceImpl();
		userService.setUserDao(userDao);
		
		
//		DocumentDao documentDao = new DocumentDaoContainer();
//		DocumentDao documentDao = new DocumentDaoContainerFile();
		DocumentDao documentDao = new DocumentDaoJdbc();
		documentService = new DocumentServiceImpl();
		documentService.setDocumentDao(documentDao);
		
		
//		ArchiveDao archiveDao = new ArchiveDaoContainer();
//		ArchiveDao archiveDao = new ArchiveDaoContainerFile();
		ArchiveDao archiveDao = new ArchiveDaoJdbc();
		archiveService = new ArchiveServiceImpl();
		archiveService.setArchiveDao(archiveDao);
		
		
		try {
			
			if (userService.getAllUsers().size() == 0) {
				
				userService.clear();
				createUsers();
				
			}
			if (documentService.getAllDocuments().size() == 0) {
				
				documentService.clear();
				createDocuments();
				
			}
			if (archiveService.getAllArchives().size() == 0) {
				
				archiveService.clear();
				createArchives();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		
		System.out.println("请运行Application的子类");
		
	}
	
	
	protected static void createUsers() throws Exception {
		
		Administrator administrator = new Administrator();

		// 加入三种角色用户
		administrator.setName("Kate");
		administrator.setPassword("123");
		userService.createUser(administrator);
		
		Operator operator = new Operator();
		operator.setName("Jack");
		operator.setPassword("123");
		userService.createUser(operator);
		
		Browser browser = new Browser();
		browser.setName("Rose");
		browser.setPassword("123");
		userService.createUser(browser);
		
	}
	
	
	protected static void createDocuments() throws Exception {
		
		Document document = new Document();

		// 初始化为数据库增添文档doc
		document.setSn("D001");
		document.setName("第一个档案");
		document.setDescription("这是一份很重要的档案");
		document.setUser(userService.getUser("Jack"));

		// 路径自定义
		document.setAbsolutePath("E:\\FileBase\\sourcefile\\first.txt");
		documentService.createDocument(document);
		
	}
	
	
	protected static void createArchives() throws Exception {
		
		Archive archive = new Archive();
		archive.setTitle("Zero");
		archive.setFileName("UFO");
		archive.setKeyword("top-secret");
		archive.setSecurityClassfication(SecurityClassfication.A);   // 绝密
		archive.setUser(userService.getUser("Kate"));
		archive.setAbsolutePath("E:\\FileBase\\sourcefile\\top.txt");
		archiveService.createArchive(archive);
		
	}

}
