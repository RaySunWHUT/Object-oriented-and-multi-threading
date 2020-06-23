package controller.archive;

import java.io.IOException;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DownloadArchiveController extends BaseController {

	@Override
	public void service() {
		
		String title = (String)message.getParameter("title");
		
		try {
			
			Archive archive = archiveService.getArchive(title);
			message.setData(archive);		
			onSuccess();
			sendFile(archive.getAbsolutePath());
			
		} catch (BaseException e) {
			
			onException(e);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
