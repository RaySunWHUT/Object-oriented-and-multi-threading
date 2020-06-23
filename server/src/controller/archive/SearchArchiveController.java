package controller.archive;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class SearchArchiveController extends BaseController{

	
	@Override
	public void service() {
		
		String title = (String)message.getParameter("title");
		Archive archive;
		
		try {
			
			archive = archiveService.findByTitle(title);
			message.setData(archive);
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
