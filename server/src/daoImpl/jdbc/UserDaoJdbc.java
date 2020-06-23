package daoImpl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import domain.Administrator;
import domain.Browser;
import domain.Operator;
import domain.User;
import exception.BaseException;
import exception.DaoException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class UserDaoJdbc extends BaseDaoJdbc implements UserDao {

	/**
	 * 插入用户
	 */
	@Override
	public User insert(User object) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = getConnection();
			
			pstmt = conn.prepareStatement("insert into userinfo (userName, password, role) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, object.getName());
			pstmt.setString(2, object.getPassword());
			pstmt.setString(3, object.getClass().getName());
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
	 * 更新用户信息
	 */
	@Override
	public User update(User object) throws DaoException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("update userinfo set userName=?, password=?, role=? where userName=?");
			
			pstmt.setString(1, object.getName());
			pstmt.setString(2, object.getPassword());
			pstmt.setString(3, object.getClass().getName());
			pstmt.setString(4, object.getName());
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
	 * 通过ID删除用户
	 */
	@Override
	public User delete(User object) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from userinfo where userId=?");
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
	 * 通过ID查找用户
	 */
	@Override
	public User findById(long id) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		User user = null;

		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from userinfo where userId=?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {

				String role = rs.getString("role").toLowerCase();
				
				if (role.indexOf("administrator") > -1) {
					
					user = new Administrator();
					
				} else if (role.indexOf("operator") > -1) {
					
					user = new Operator();
					
				} else {
					
					user = new Browser();
					
				}
				
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setId(id);
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
		return user;
		
	}

	
	/**
	 * 找到全部用户
	 */
	@Override
	public List<User> findAllOnes() throws BaseException {
		
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from userinfo");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				User user;
				String role = rs.getString("role").toLowerCase();
				
				if (role.indexOf("administrator") > -1) {
					
					user = new Administrator();
					
				} else if (role.indexOf("operator") > -1) {
					
					user = new Operator();
					
				} else {
					
					user = new Browser();
					
				}
				
				user.setId(rs.getLong("userId"));
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				
			}
			
			return users;
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
	}

	
	/**
	 * 通过名字查找
	 */
	@Override
	public User findByName(String name) throws BaseException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		User user = null;

		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from userinfo where userName=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {

				String role = rs.getString("role").toLowerCase();
				
				if (role.indexOf("administrator") > -1) {
					
					user = new Administrator();
					
				} else if (role.indexOf("operator") > -1) {
					
					user = new Operator();
					
				} else {
					
					user = new Browser();
					
				}
				
				user.setName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setId(rs.getLong("userId"));
				
			}
			
		} catch (SQLException exception) {
			
			throw new DaoException();
			
		} finally {
			
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(conn);
			
		}
		
		return user;
		
	}

}
