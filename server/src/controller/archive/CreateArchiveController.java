package controller.archive;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class CreateArchiveController extends BaseController {

	@Override
	public void service() {
		
		Archive archive = (Archive)message.getParameter("archive");
		
		try {
			
			archive = archiveService.createArchive(archive);
			message.setData(archive);
			onSuccess();
			 
		} catch (BaseException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
