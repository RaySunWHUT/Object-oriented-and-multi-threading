package controller.archive;

import java.io.IOException;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UploadArchiveController extends BaseController {

	@Override
	public void service() {
		
		Archive archive = (Archive)message.getParameter("archive");
		
		try {
			
			String tempPath = receiveTempFile(archive.getFileName());
			archive.setSourcePath(tempPath);
			archive = archiveService.uploadArchive(archive);
			deleteTempFile(tempPath);
			message.setData(archive);	
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
