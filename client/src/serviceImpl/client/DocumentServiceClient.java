package serviceImpl.client;

import java.io.IOException;
import java.util.List;

import application.client.Application;
import common.Constants;
import common.Message;
import domain.Document;
import exception.BaseException;
import service.DocumentService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DocumentServiceClient extends BaseServiceClient implements DocumentService {
	
	/**
	 * 上传文件
	 */
	public Document uploadDocument(Document document) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.UPLOAD_DOCUMENT_CONTROLLER);
		
		document.setName(getFileName(document.getSourcePath()));
		document.setUser(Application.currentUser);
		message.setParameter("document", document);
		message = sendDocument(message);
		document = (Document)message.getData();
		
		return document;
		
	}


	/**
	 * 创建文件
	 */
	@Override
	public Document createDocument(Document document) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CREATE_DOCUMENT_CONTROLLER);   // 有问题需修改
		message.setParameter("document", document);
		message = send(message);
		document = (Document)message.getData();
		
		return document;
		
	}

	
	/**
	 * 删除文件
	 */
	@Override
	public Document deleteDocument(String sn) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.DELETE_DOCUMENT_CONTROLLER);
		message.setParameter("sn", sn);
		message = send(message);
		Document document = (Document)message.getData();
		
		return document;
		
		
	}

	
	/**
	 * 获取文件
	 */
	@Override
	public Document getDocument(String sn) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.GET_DOCUMENT_CONTROLLER);
		message.setParameter("sn", sn);
		message = send(message);
		Document document = (Document)message.getData();
		return document;
		
	}

	
	/**
	 * 获取所有文件
	 */
	@Override
	public List<Document> getAllDocuments() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.GET_ALL_DOCUMENTS_CONTROLLER);
		message = send(message);
		List<Document> documents = (List<Document>)message.getData();
		
		return documents;
		
	}

	
	/**
	 * 清空
	 */
	@Override
	public void clear() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CLEAR_ALL_DOCUMENTS_CONTROLLER);
		message = send(message);		
		
	}
	
	
    /**
     * 下载文件
     */
	@Override
	public Document downloadDocument(String sn, String targetPath) throws BaseException, IOException {
		
		Message message = new Message();
		message.setController(Constants.DOWNLOAD_DOCUMENT_CONTROLLER);
		message.setParameter("sn", sn);
		message = receiveDocument(message, targetPath);
		Document document = (Document)message.getData();
		
		return document;
		
	}
	
}
