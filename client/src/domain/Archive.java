package domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Archive implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8781005320460274471L;
	private long id;                // 唯一标识
	private Timestamp timestamp;    // 更新时间
	private String title;           // 标题
	private String keyword;    // 关键字
	private String catalogue;  // 目录
	private SecurityClassfication securityClassfication;   // 档案密级
	private String fileName;     // 文件
	private String absolutePath;   // 附件在后台的绝对路径
	private String sourcePath;   // 前台的绝对路径，不持久化
	private User user;     // 上传用户
	
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	

	public String getTitle() {
		
		return title;
		
	}
	
	
	public void setTitle(String title) {
		
		this.title = title;
		
	}
	
	
	public String getKeyword() {
		
		return keyword;
		
	}
	
	public void setKeyword(String keyword) {
		
		this.keyword = keyword;
		
	}
	
	public String getCatalogue() {
		
		return catalogue;
		
	}
	
	
	public void setCatalogue(String catalogue) {
		
		this.catalogue = catalogue;
		
	}
	
	public SecurityClassfication getSecurityClassfication() {
		
		return securityClassfication;
		
	}
	
	public void setSecurityClassfication(SecurityClassfication securityClassfication) {
		
		this.securityClassfication = securityClassfication;
		
	}
	
	public String getFileName() {
		
		return fileName;
		
	}
	
	public void setFileName(String fileName) {
		
		this.fileName = fileName;
		
	}

	public Timestamp getTimestamp() {
		
		return timestamp;
		
	}
	
	
	public void setTimestamp(Timestamp timestamp) {
		
		this.timestamp = timestamp;
		
	}
	
	
	public String getAbsolutePath() {
		
		return absolutePath;
		
	}
	
	public void setAbsolutePath(String absolutePath) {
		
		this.absolutePath = absolutePath;
		
	}
	
	
	public String getSourcePath() {
		
		return sourcePath;
		
	}
	
	
	public void setSourcePath(String sourcePath) {
		
		this.sourcePath = sourcePath;
		
	}
	
	
	public User getUser() {
		
		return user;
		
	}
	
	public void setUser(User user) {
		
		this.user = user;
		
	}
	
	@Override
	public String toString() {
		
		return "Archive [id=" + id + ", timestamp=" + timestamp + ", title=" + title + ", keyword=" + keyword
				+ ", catalogue=" + catalogue + ", securityClassfication=" + securityClassfication + ", fileName="
				+ fileName + ", absolutePath=" + absolutePath + ", sourcePath=" + sourcePath + ", user=" + user + "]";
	}

}
