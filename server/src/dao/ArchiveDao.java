package dao;

import domain.Archive;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface ArchiveDao extends BaseDao<Archive> {
	
	Archive findByTitle(String title) throws BaseException;

}
