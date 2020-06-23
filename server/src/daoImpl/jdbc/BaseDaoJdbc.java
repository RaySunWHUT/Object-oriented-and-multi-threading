package daoImpl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Constants;
import exception.DaoException;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public abstract class BaseDaoJdbc {
	
	private String driver = Constants.DB_DRIVER;
	
    private String sConnStr = Constants.DB_CONNECTION;

    private String user = Constants.DB_USER;

    private String password = Constants.DB_PASSWORD;

    /**
     * 获取连接
     * @return
     * @throws SQLException
     * @throws DaoException
     */
    protected Connection getConnection() throws SQLException, DaoException {
    	
    	try {
    		
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
			throw new DaoException();
			
		}
    	
        return DriverManager.getConnection(sConnStr, user, password);
        
    }
    
    
    /**
     * 关闭连接
     * @param conn
     * @throws DaoException
     */
    protected void closeConnection(Connection conn) throws DaoException {
    	
        if (conn != null) {
        	
            try {
            	
                conn.close();
                
            } catch (SQLException e) {
            	
            	throw new DaoException();
            	
            }
            
            conn = null;
            
        }
        
    }

    
    /**
     * 关闭结果集
     * @param rs
     * @throws DaoException
     */
    protected void closeResultSet(ResultSet rs) throws DaoException {
    	
        if (rs != null) {
        	
            try {
            	
                rs.close();
                
            } catch (SQLException e) {
            	
            	throw new DaoException();
            	
            }
            
            rs = null;
            
        }
        
    }
    
    
    /**
     * 关闭语句
     * @param st
     * @throws DaoException
     */
    protected void closeStatement(Statement st) throws DaoException {
    	
        if (st != null) {
        	
            try {
            	
                st.close();
                
            } catch (SQLException e) {
            	
            	throw new DaoException();
            	
            }
            
            st = null;
            
        }
        
    }
    
}