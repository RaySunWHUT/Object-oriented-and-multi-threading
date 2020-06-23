package daoImpl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DocumentDao;
import domain.Administrator;
import domain.Browser;
import domain.Document;
import domain.Operator;
import domain.User;
import exception.BaseException;
import exception.DaoException;


/**
 * @author sunrui
 * @time 2018.12.18
 */
public class DocumentDaoJdbc extends BaseDaoJdbc implements DocumentDao {
	
	/**
	 * 插入文件
	 */
	@Override
	public Document insert(Document object) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(
		         "insert into documentinfo (sn, fileName, timestamp, description, absolutePath, userId) values (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, object.getSn());
			pstmt.setString(2, object.getName());
			pstmt.setTimestamp(3, object.getTimestamp());
			pstmt.setString(4, object.getDescription());
			pstmt.setString(5, object.getAbsolutePath());
			pstmt.setLong(6, object.getUser().getId());
			
			int rt = pstmt.executeUpdate();
			
			if (rt > 0) {
				
				rs = pstmt.getGeneratedKeys();
				
				if (rs.next()) {
					
					object.setId(rs.getInt(1));
					
				}
				
			}
			
			return object;
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}

	
	/**
	 * 更新文件
	 */
	@Override
	public Document update(Document object) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(
					
				"update documentinfo set sn=?, fileName=?, timestamp=?, description=?, absolutePath=?, userId=? where docId=?");
			
			pstmt.setString(1, object.getSn());
			pstmt.setString(2, object.getName());
			pstmt.setTimestamp(3, object.getTimestamp());
			pstmt.setString(4, object.getDescription());
			pstmt.setString(5, object.getAbsolutePath());
			pstmt.setLong(6, object.getUser().getId());
			pstmt.setLong(7, object.getId());
			int rt = pstmt.executeUpdate();
			
			if (rt > 0) {
				
				return object;
				
			} else {
				
				return null;
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}


	/**
	 * 删除文件操作
	 */
	@Override
	public Document delete(Document object) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from documentinfo where docId=?");
			pstmt.setLong(1, object.getId());
			int rt = pstmt.executeUpdate();
			
			if (rt > 0) {
				
				return object;
				
			} else {
				
				return null;
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}
	

	/**
	 * 通过ID查找文件
	 */
	@Override
	public Document findById(long id) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		ResultSet rs = null, rs1 = null;

		Document document = null;

		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from documentinfo where docId=?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				document = new Document();
				document.setId(rs.getLong("docId"));
				document.setSn(rs.getString("sn"));
				document.setName(rs.getString("fileName"));
				document.setTimestamp(rs.getTimestamp("timestamp"));
				document.setDescription(rs.getString("description"));
				document.setAbsolutePath(rs.getString("absolutePath"));

				pstmt1 = conn.prepareStatement("select * from userinfo where userId=?");
				pstmt1.setLong(1, rs.getLong("userId"));
				rs1 = pstmt1.executeQuery();
				
				if (rs1.next()) {
					
					User user;
					String role = rs1.getString("role").toLowerCase();
					
					if (role.indexOf("administrator") > -1) {
						
						user = new Administrator();
						
					} else if (role.indexOf("operator") > -1) {
						
						user = new Operator();
						
					} else {
						
						user = new Browser();
						
					}
					
					user.setName(rs1.getString("userName"));
					user.setPassword(rs1.getString("password"));
					user.setId(rs1.getLong("userId"));
					document.setUser(user);
					
				}
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeResultSet(rs1);
			closeStatement(pstmt1);
			closeConnection(conn);
			
		}
		
		return document;
		
	}

	
	/**
	 * 找到所有文件
	 */
	@Override
	public List<Document> findAllOnes() throws BaseException {
		
		List<Document> documents = new ArrayList<Document>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from documentinfo");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				long docId = rs.getLong("docId");
				Document document = this.findById(docId);
				documents.add(document);
				
			}
			
			return documents;
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}
	

	/**
	 * 通过编号查找文件
	 */
	@Override
	public Document findBySn(String sn) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Document document = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from documentinfo where sn=?");
			pstmt.setString(1, sn);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				long docId = rs.getLong("docId");
				document = this.findById(docId);
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
		return document;
		
	}

}
