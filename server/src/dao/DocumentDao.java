package dao;

import domain.Document;
import exception.BaseException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public interface DocumentDao extends BaseDao<Document> {
	
	Document findBySn(String sn) throws BaseException;

}
