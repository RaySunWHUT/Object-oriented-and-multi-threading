package service;

import java.io.IOException;
import java.util.List;

import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface ArchiveService {
	
	/**
	 * 创建案宗
	 * @param archive
	 * @return
	 * @throws BaseException
	 */
	Archive createArchive(Archive archive) throws BaseException;
	
	/**
	 * 上传案宗
	 * @param archive
	 * @return
	 * @throws BaseException
	 */
	Archive uploadArchive(Archive archive) throws BaseException;
	
	
	/**
	 * 下载案宗
	 * @param id
	 * @param targetPath
	 * @return
	 * @throws BaseException
	 * @throws IOException
	 */
	Archive downloadArchive(String title, String targetPath) throws BaseException, IOException;
	
	
	/**
	 * 删除案宗
	 * @param title
	 * @return
	 * @throws BaseException
	 */
	Archive deleteArchive(String title) throws BaseException;
	
	
	/**
	 * 得到案宗
	 * @param title
	 * @return
	 * @throws BaseException
	 */
	Archive getArchive(String title) throws BaseException;
	
	
	/**
	 * 得到所有案宗
	 * @return
	 * @throws BaseException
	 */
	List<Archive> getAllArchives() throws BaseException;
	
	
	/**
	 * 通过标题查找案宗
	 * @param title
	 * @return
	 * @throws BaseException
	 */
	Archive findByTitle(String title) throws BaseException;
	
	
	/**
	 * 清空所有案宗
	 * @throws BaseException
	 */
	void clear() throws BaseException;

	
	/**
	 * 修改案宗基本信息
	 * @param archive
	 * @return
	 * @throws BaseException
	 */
	Archive updateArchive(Archive archive) throws BaseException;
	
	
    default String getExtensionName(String filename) { 
    	
        if ((filename != null) && (filename.length() > 0)) { 
        	
            int dot = filename.lastIndexOf('.');   
            
            if ((dot > -1) && (dot < (filename.length() - 1))) {  
            	
                return filename.substring(dot + 1);   
                
            }   
            
        }   
        
        return filename;   
        
    } 
    
    
    default String getFileName(String filename) {   
    	
        if ((filename != null) && (filename.length() > 0)) {  
        	
            int split = filename.lastIndexOf('\\');  
            
            if (split == -1) {
            	
            	split = filename.lastIndexOf('/'); 
            }
            
            if ((split > -1) && (split < (filename.length() - 1))) { 
            	
                return filename.substring(split + 1);   
                
            }   
            
        }   
        
        return filename; 
        
    }
	
}
