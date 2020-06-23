package controller.archive;

import java.util.List;

import controller.BaseController;
import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class GetAllArchivesController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			List<Archive> archives = archiveService.getAllArchives();
			message.setData(archives);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}


}
