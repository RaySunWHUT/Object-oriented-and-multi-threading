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
import dao.ArchiveDao;
import domain.Archive;
import exception.BaseException;
import exception.FileException;
import exception.HaveExistException;
import exception.NoObjectException;
import service.ArchiveService;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ArchiveServiceImpl implements ArchiveService {

	private ArchiveDao archiveDao;
	
	@Override
	public void setArchiveDao(ArchiveDao archiveDao) {
		
		this.archiveDao = archiveDao;
		
	}
	
	
	@Override
	public Archive createArchive(Archive archive) throws BaseException {
		
		if (archiveDao.findByTitle(archive.getTitle()) != null) {
			
			throw new HaveExistException(archive.getTitle());
			
		}
		
		archive.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		return archiveDao.insert(archive);
	
	}
	
	
	private String uploadFile(String sourcefile) throws BaseException {
		
		File uploadDirectory = new File(Constants.UPLOAD_PATH);
		
		if (!uploadDirectory.exists()) {
			
			uploadDirectory.mkdirs();
			
		}
		
		byte[] buffer = new byte[1024];
		
		File sourceFile =new File(sourcefile.trim());
		String filename = sourceFile.getName();
		String extName = getExtensionName(filename);
		String absolutePath = Constants.UPLOAD_PATH_OF_ARCHIVES + System.currentTimeMillis() + "." + extName;
		
		try {
			
//		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(Constants.SOURCE_PATH + sourceFile));
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(Constants.SOURCE_PATH + filename));
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(absolutePath)); 

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
	

	@Override
	public Archive uploadArchive(Archive archive) throws BaseException {
		
		if (archiveDao.findById(archive.getId()) != null) {
			
			throw new HaveExistException(archive.getTitle());
			
		}
		
		if (archive.getSourcePath() != null) {
			
			archive.setAbsolutePath(uploadFile(archive.getSourcePath()));
			archive.setFileName(getFileName(archive.getSourcePath()));
			
		}
		
		if (Application.currentUser != null) {
			
			archive.setUser(Application.currentUser);;
			
		}
		
		archive.setSourcePath(null);
		archive.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		return archiveDao.insert(archive);
		
	}
	
	
	@Override
	public Archive downloadArchive(String title, String targetPath) throws BaseException, IOException {
		
		Archive archive = archiveDao.findByTitle(title);
		
		if (archive == null) {
			
			throw new NoObjectException(title);
			
		}
		
		downloadFile(archive, targetPath);
		
		return archive;
	
	}
	

	private void downloadFile(Archive archive, String targetPath) throws IOException {
		
		File downloadDirectory = new File(Constants.DOWNLOAD_PATH);
		
		if (!downloadDirectory.exists()) {
			
			downloadDirectory.mkdirs();
			
		}
		
		byte[] buffer = new byte[1024];
		
		File archiveFile = new File(archive.getAbsolutePath());
		
		String filename = archive.getFileName();
		BufferedInputStream infile = new BufferedInputStream(new FileInputStream(archiveFile));
		String saveFilePath = targetPath == null ? Constants.DOWNLOAD_PATH_OF_ARCHIVES + filename : targetPath;
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(saveFilePath)); 

		while (true) {
			
			int byteRead = infile.read(buffer);   // 从文件读数据给字节数组
			
            if (byteRead == -1) {    // 在文件尾，无数据可读
            	
            	break;
            	
            }
              
            targetfile.write(buffer, 0, byteRead);  //将读到的数据写入目标文件
            
        }
		
		infile.close();
		
		targetfile.close();
		
	}

	
	@Override
	public Archive deleteArchive(String title) throws BaseException {
		
		Archive archive = archiveDao.findByTitle(title);
		
		if (archive == null) {
			
			throw new NoObjectException(title);
			
		}
		
		return archiveDao.delete(archive);
		
	}

	
	@Override
	public Archive getArchive(String title) throws BaseException {
		
		Archive archive = archiveDao.findByTitle(title);
		
		if (archive == null) {
			
			throw new NoObjectException(String.valueOf(title));
			
		}
		
		return archive;
		
	}

	
	@Override
	public List<Archive> getAllArchives() throws BaseException {
		
		return archiveDao.findAllOnes();
		
	}
	

	@Override
	public Archive findByTitle(String title) throws BaseException {
		
		Archive archive = archiveDao.findByTitle(title);
		
		if (archive == null) {
			
			throw new NoObjectException(title);
			
		}
		
		return archive;
	
	}
	
	
	@Override
	public Archive updateArchive(Archive archive) throws BaseException {
		
		if (archiveDao.findByTitle(archive.getTitle()) == null) {
			
			throw new NoObjectException(archive.getTitle());
			
		}
		
		archive = archiveDao.findByTitle(archive.getTitle());
		
		return archiveDao.update(archive);
	
	}

	
	@Override
	public void clear() throws BaseException {
	
        List<Archive> archives = archiveDao.findAllOnes();
		
		for (Archive archive: archives) {
			
			archiveDao.delete(archive);
			
		}
		
	}

}
