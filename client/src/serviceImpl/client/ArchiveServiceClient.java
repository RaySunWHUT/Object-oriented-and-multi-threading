package serviceImpl.client;

import java.io.IOException;
import java.util.List;

import application.client.Application;
import common.Constants;
import common.Message;
import domain.Archive;
import exception.BaseException;
import service.ArchiveService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ArchiveServiceClient extends BaseServiceClient implements ArchiveService {
	
	
	/**
	 * 创建案宗
	 */
	@Override
	public Archive createArchive(Archive archive) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CREATE_ARCHIVE_CONTROLLER); 
		message.setParameter("archive", archive);
		message = send(message);
		archive = (Archive)message.getData();
		
		return archive;
		
	}

	
	/**
	 * 上传文件
	 */
	@Override
	public Archive uploadArchive(Archive archive) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.UPLOAD_ARCHIVE_CONTROLLER);
		
		archive.setFileName(getFileName(archive.getSourcePath()));
	    archive.setUser(Application.currentUser);
	    message.setParameter("archive", archive);
	    message = sendArchive(message);
	    archive = (Archive)message.getData();
	    
	    return archive;
	    
	}

	
	/**
	 * 下载案宗
	 */
	@Override
	public Archive downloadArchive(String title, String targetPath) throws BaseException, IOException {
	
		Message message = new Message();
		message.setController(Constants.DOWNLOAD_ARCHIVE_CONTROLLER);
		message.setParameter("title", title);
		message = receiveArchive(message, targetPath);
		Archive archive = (Archive)message.getData();
	
		return archive;
	
	}

	
	/**
	 * 删除案宗
	 */
	@Override
	public Archive deleteArchive(String title) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.DELETE_ARCHIVE_CONTROLLER);
		message.setParameter("title", title);
		message = send(message);
		Archive archive = (Archive)message.getData();
		
		return archive;
	
	}
	
    
	/**
	 * 获取案宗
	 */
	@Override
	public Archive getArchive(String title) throws BaseException {
	
		Message message = new Message();
		message.setController(Constants.GET_ARCHIVE_CONTROLLER);
		message.setParameter("title", title);
		message = send(message);
		Archive archive = (Archive)message.getData();
		
		return archive;
	
	}

	
	/**
	 * 获取所有案宗
	 */
	@Override
	public List<Archive> getAllArchives() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.GET_ALL_ARCHIVES_CONTROLLER);
		message = send(message);
		List<Archive> archives = (List<Archive>)message.getData();
		
		return archives;
	
	}

	
	/**
	 * 通过标题查找
	 */
	@Override
	public Archive findByTitle(String title) throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.SEARCH_ARCHIVE_CONTROLLER);
		message.setParameter("title", title);
		message = send(message);
		Archive archive = (Archive)message.getData();
		
		return archive;
	
	}

	
	/**
	 * 清空
	 */
	@Override
	public void clear() throws BaseException {
		
		Message message = new Message();
		message.setController(Constants.CLEAR_ALL_ARCHIVES_CONTROLLER);
		message = send(message);		
		
	}

	
	/**
	 * 更新案宗
	 */
	@Override
	public Archive updateArchive(Archive archive) throws BaseException {
	
		Message message = new Message();
		message.setController(Constants.UPDATE_ARCHIVE_CONTROLLER);
		message.setParameter("archive", archive);
		message = send(message);
		archive = (Archive)message.getData();

		return archive;
	
	}

}
