package controller.document;

import controller.BaseController;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DeleteDocumentController extends BaseController {

	
	@Override
	public void service() {
		
		String sn = (String)message.getParameter("sn");
		Document document;
		
		try {
			
			document = documentService.deleteDocument(sn);
			message.setData(document);
			onSuccess();
			
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
		
	}

}
