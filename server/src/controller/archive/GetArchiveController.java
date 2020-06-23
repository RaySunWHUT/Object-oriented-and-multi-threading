package controller.archive;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class GetArchiveController extends BaseController{

	@Override
	public void service() {
		
		String title = (String)message.getParameter("title");
		
		try {
			
			Archive archive = archiveService.getArchive(title);
			message.setData(archive);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
