package action;

import java.util.Scanner;

import application.client.Application;
import service.ArchiveService;
import service.DocumentService;
import service.UserService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public abstract class BaseAction {
	
	protected UserService userService = Application.userService;
	protected DocumentService documentService = Application.documentService;
	protected ArchiveService archiveService = Application.archiveService;
	
	protected Scanner in = new Scanner(System.in);
	
	public abstract void execute();
	
	public abstract String getText();
	
	protected void output(String message) {
		
		System.out.println(message);
		
	}
	
}
