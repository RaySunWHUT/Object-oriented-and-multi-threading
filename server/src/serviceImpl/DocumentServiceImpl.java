package serviceImpl;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import application.server.Application;
import common.Constants;
import dao.DocumentDao;
import domain.Document;
import exception.BaseException;
import exception.FileException;
import exception.HaveExistException;
import exception.NoObjectException;
import service.DocumentService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DocumentServiceImpl implements DocumentService {
	
	private DocumentDao documentDao;
	
	@Override
	public void setDocumentDao(DocumentDao documentDao) {    // 创建document实例
		
		this.documentDao = documentDao;
		
	}
	
	
	public Document createDocument(Document document) throws BaseException {   
		
		if (documentDao.findBySn(document.getSn()) != null) {
			
			throw new HaveExistException(document.getSn());
			
		}
		
		document.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		return documentDao.insert(document);
		
	}
	
	
	private String uploadFile(String sourcefile) throws BaseException {    // 存在问题
		
		File uploadDirectory = new File(Constants.UPLOAD_PATH);
		
		if (!uploadDirectory.exists()) {   // 对应目录不存在，则创建目录
			
			uploadDirectory.mkdirs();
			
		}
		
		byte[] buffer = new byte[1024];   // 字节数组作为缓冲区
		
		File tempFile =new File(sourcefile.trim());  // 创建对应的源文件实例
		String filename = tempFile.getName();  // 获取文件名, 即获取最后一次出现separator之后的全部字符(此处若存在扩展名则包括扩展名)
		String extName = getExtensionName(filename);   // 获取对应文件的扩展名
		String absolutePath = Constants.UPLOAD_PATH_OF_DOCUMENTS + System.currentTimeMillis() + "." + extName;  // 
		
		try {
			
//		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(Constants.SOURCE_PATH + tempFile));   // 读入到缓冲流
			
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(Constants.SOURCE_PATH + filename));   // 读入到缓冲流
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(absolutePath));   // 写入到绝对路径中

		while (true) {
			
			int byteRead = infile.read(buffer);  // 从文件读数据给字节数组
			
            if (byteRead == -1) {   // 在文件尾，无数据可读
            	
            	 break;   // 跳出循环        
            
		}
            
            targetfile.write(buffer, 0, byteRead);  // 将读到的数据写入目标文件
            
        }
		
		infile.close();
		
		targetfile.close();
		
		} catch (IOException e) {
			
			throw new FileException();
			
		}
		
		return absolutePath;
		
	}
	
	
	public Document uploadDocument(Document document) throws BaseException {
		
		if (documentDao.findBySn(document.getSn()) != null) {   // 若文件已存在，则抛出异常
			
			throw new HaveExistException(document.getSn());
			
		}
		
		if (document.getSourcePath() != null) {    // 若源路径不为空
			
			document.setAbsolutePath(uploadFile(document.getSourcePath()));   // 绝对路径
			document.setName(getFileName(document.getSourcePath()));  // 将获取源路径最后的文件名字符串
			
		}
		
		if (Application.currentUser != null) {   // 填写上传用户
			
			document.setUser(Application.currentUser);
			
		}
		
		document.setSourcePath(null);   // 将文件源置空
		document.setTimestamp(new Timestamp(System.currentTimeMillis()));   // 标记上传时间
		
		return documentDao.insert(document);    // 插入文件
		
	}
	
	
	/**
	 * 下载文件中的过程方法
	 * @param document
	 * @param targetPath
	 * @throws IOException
	 */
	private void downloadFile(Document document, String targetPath) throws IOException {
		
		File downloadDirectory = new File(Constants.DOWNLOAD_PATH);
		
		if (!downloadDirectory.exists()) {    // 目录不存在则创建
			
			downloadDirectory.mkdirs();
			
		}
		
		byte[] buffer = new byte[1024];    // 字节数组
		
		File tempFile = new File(document.getAbsolutePath());   // 获取文件对象的绝对路径，并创建该文件对象
		
		String filename = document.getName();    // 获取文件名
		
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(tempFile));   // 将读取文件流放到读取缓冲流中
		String saveFilePath = targetPath == null ? Constants.DOWNLOAD_PATH_OF_DOCUMENTS + filename : targetPath;
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(saveFilePath)); 

		while (true) {
			
			int byteRead = infile.read(buffer);   // 从文件读数据给字节数组
			
            if (byteRead == -1) {    // 在文件尾，无数据可读
            	
            	break;
            	
            }
              
            targetfile.write(buffer, 0, byteRead);  // 将目标字节数组从0开始到最后，将从中读到的数据写入到目标文件中
            
        }
		
		infile.close();
		
		targetfile.close();
		
	}
	
	
	/**
	 * 下载文件
	 */
	@Override
	public Document downloadDocument(String sn, String targetPath) throws BaseException, IOException {
		
		Document document = documentDao.findBySn(sn);
		
		if (document == null) {   // 文件不存在
			
			throw new NoObjectException(sn);
			
		}
		
		downloadFile(document, targetPath);   // 下载文件
		
		return document;
		
	}
	
	
	/**
	 * 删除文件
	 */
	public Document deleteDocument(String sn) throws BaseException {    
		
		Document document = documentDao.findBySn(sn);
		
		if (document == null) {
			
			throw new NoObjectException(sn);
			
		}
		
		return documentDao.delete(document);
		
	}
	
	
	/**
	 * 得到文件
	 */
	public Document getDocument(String sn) throws BaseException {
		
		Document document = documentDao.findBySn(sn);
		
		if (document == null) {    // 文件不存在
			
			throw new NoObjectException(sn);
			
		}
		
		return document;
		
	}
	
	
	/**
	 * 获取所有文件
	 */
	public List<Document> getAllDocuments() throws BaseException {    
		
		return documentDao.findAllOnes(); 
		
	}
	
	
	/**
	 * 清空文件
	 */
	@Override
	public void clear() throws BaseException {
		
		List<Document> documents = documentDao.findAllOnes();
		
		for (Document document : documents) {
			
			documentDao.delete(document);
			
		}
		
	}

}
