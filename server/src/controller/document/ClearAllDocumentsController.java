package controller.document;

import controller.BaseController;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ClearAllDocumentsController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			documentService.clear();
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
