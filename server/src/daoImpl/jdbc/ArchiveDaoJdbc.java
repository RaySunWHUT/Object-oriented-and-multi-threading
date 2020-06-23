package daoImpl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ArchiveDao;
import domain.Administrator;
import domain.Archive;
import domain.Browser;
import domain.Operator;
import domain.SecurityClassfication;
import domain.User;
import exception.BaseException;
import exception.DaoException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class ArchiveDaoJdbc extends BaseDaoJdbc implements ArchiveDao {

	/**
	 * 插入案宗
	 */
	@Override
	public Archive insert(Archive object) throws BaseException {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println(object);
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(
		         "insert into archiveinfo (title, keyword, fileName, catalogue, securityClassfication, absolutePath, timestamp, userId) values (?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, object.getTitle());
			pstmt.setString(2, object.getKeyword());
			pstmt.setString(3, object.getFileName());
			pstmt.setString(4, object.getCatalogue());
			pstmt.setString(5, String.valueOf(object.getSecurityClassfication()));
			pstmt.setString(6, object.getAbsolutePath());
			pstmt.setTimestamp(7, object.getTimestamp());
			pstmt.setLong(8, object.getUser().getId());
			
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
	 * 更新案宗
	 */
	@Override
	public Archive update(Archive object) throws BaseException {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(
					
				"update archiveinfo set title=?, keyword=?, fileName=?, catalogue=?, securityClassfication=?, absolutePath=?, timestamp=?, userId=? where arId=?");
			
			pstmt.setString(1, object.getTitle());
			pstmt.setString(2, object.getKeyword());
			pstmt.setString(3, object.getFileName());
			pstmt.setString(4, object.getCatalogue());
			pstmt.setString(5, String.valueOf(object.getSecurityClassfication()));
			pstmt.setString(6, object.getAbsolutePath());
			pstmt.setTimestamp(7, object.getTimestamp());
			pstmt.setLong(8, object.getUser().getId());
			pstmt.setLong(9, object.getId());
			
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
	 * 删除案宗
	 */
	@Override
	public Archive delete(Archive object) throws BaseException {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from archiveinfo where arId=?");
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
	 * 通过ID查找案宗
	 */
	@Override
	public Archive findById(long id) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt1 = null;
		ResultSet rs = null, rs1 = null;
		Archive archive = null;

		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from archiveinfo where arId=?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				archive = new Archive();
				archive.setId(rs.getLong("arId"));
				archive.setTitle(rs.getString("title"));
				archive.setKeyword(rs.getString("keyword"));
				archive.setFileName(rs.getString("fileName"));
				archive.setCatalogue(rs.getString("catalogue"));
				archive.setSecurityClassfication(SecurityClassfication.valueOf(rs.getString("securityClassfication")));
				archive.setAbsolutePath(rs.getString("absolutePath"));
				archive.setTimestamp(rs.getTimestamp("timestamp"));
				
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
					archive.setUser(user);
					
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
		
		return archive;
		
	}

	
	/**
	 * 找到所有案宗
	 */
	@Override
	public List<Archive> findAllOnes() throws BaseException {
		
		List<Archive> archives = new ArrayList<Archive>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from archiveinfo");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				long arId = rs.getLong("arId");
				
				Archive archive = this.findById(arId);
				archives.add(archive);
				
			}
			
			return archives;
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}

	
	/**
	 * 通过标题查找案宗
	 */
	@Override
	public Archive findByTitle(String title) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Archive archive = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from archiveinfo where title=?");
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				long arId = rs.getLong("arId");
				archive = this.findById(arId);
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
		return archive;
	
	}

}
