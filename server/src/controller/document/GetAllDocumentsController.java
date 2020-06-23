package controller.document;

import java.util.List;

import controller.BaseController;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class GetAllDocumentsController extends BaseController {

	@Override
	public void service() {
		
		try {
			
			List<Document> documents = documentService.getAllDocuments();
			message.setData(documents);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		}
		
	}

}
