package controller.archive;

import controller.BaseController;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearAllArchivesController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			archiveService.clear();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
