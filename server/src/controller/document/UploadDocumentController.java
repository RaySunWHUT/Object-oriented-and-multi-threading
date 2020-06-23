package controller.document;

import java.io.IOException;

import controller.BaseController;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UploadDocumentController extends BaseController {

	@Override
	public void service() {
		
		Document document = (Document)message.getParameter("document");
		
		try {
			
			String tempPath = receiveTempFile(document.getName());
			document.setSourcePath(tempPath);
			document = documentService.uploadDocument(document);
			deleteTempFile(tempPath);
			message.setData(document);		
			onSuccess();
			
		} catch (BaseException e) {
			
			onException(e);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
