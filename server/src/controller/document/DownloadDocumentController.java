package controller.document;

import java.io.IOException;

import controller.BaseController;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DownloadDocumentController extends BaseController {

	@Override
	public void service() {
		
		String sn = (String)message.getParameter("sn");
		
		try {
			
			Document document = documentService.getDocument(sn);
			message.setData(document);		
			onSuccess();
			sendFile(document.getAbsolutePath());
			
		} catch (BaseException e) {
			
			onException(e);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
