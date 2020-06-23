package controller.document;

import controller.BaseController;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class CreateDocumentController extends BaseController {

	@Override
	public void service() throws BaseException {
		
		Document document = (Document)message.getParameter("document");
		
		try {
			
			document = documentService.createDocument(document);
			message.setData(document);
			onSuccess();
		
		} catch (BaseException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
