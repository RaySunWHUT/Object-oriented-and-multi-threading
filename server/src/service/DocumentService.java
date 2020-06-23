package service;

import java.io.IOException;
import java.util.List;

import dao.DocumentDao;
import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface DocumentService {
	
	void setDocumentDao(DocumentDao documentDao);
	
	Document uploadDocument(Document document) throws BaseException;
	
	Document downloadDocument(String sn, String targetPath) throws BaseException, IOException;
	
	Document createDocument(Document document) throws BaseException;
	
	Document deleteDocument(String sn) throws BaseException;
	
	Document getDocument(String sn) throws BaseException;
	
	List<Document> getAllDocuments() throws BaseException;
	
	void clear() throws BaseException;
	
	
    default String getExtensionName(String filename) {    // 获取扩展名
    	
        if ((filename != null) && (filename.length() > 0)) {    // 非空
        	
            int dot = filename.lastIndexOf('.');    // 找到 " . " 最后一次出现的下标位置
            
            if ((dot > -1) && (dot < (filename.length() - 1))) {  
            	
                return filename.substring(dot + 1);   // 获取扩展名
                
            }   
            
        }   
        
        return filename;   
        
    } 
    
    
    default String getFileName(String filename) {     // 获取文件名
    	
        if ((filename != null) && (filename.length() > 0)) {    // filename不为空  
        	
            int split = filename.lastIndexOf('\\');    // 返回指定字符最后一次出现的索引值，如果没有该字符出现则返回-1. 
            
            if (split == -1) {      // 若该字符未出现，则非windows操作系统，而是linux，换用linux分隔符
            	
            	split = filename.lastIndexOf('/'); 
            	
            }
            
            if ((split > -1) && (split < (filename.length() - 1))) {    // 若找到
            	
                return filename.substring(split + 1);   // 则将分隔符最后一次出现的下标位置之后的字段截取并返回
                
            }   
            
        }   
        
        return filename;   // 若为空字符串则直接返回null
        
    }

}
