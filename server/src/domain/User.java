package domain;

import java.io.Serializable;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public abstract class User implements Serializable {
	
	/**
	 * User实例
	 */
	private static final long serialVersionUID = -7733196247428518847L;
	private long id;
	private String name;
	private String password;
	
	
	public long getId() {
		
		return id;
		
	}
	
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	
	public String getName() {
		
		return name;
		
	}
	
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	public String getPassword() {
		
		return password;
		
	}
	
	
	public void setPassword(String password) {
		
		this.password = password;
		
	}
	
	
	@Override
	public String toString() {
		
		return this.getClass() + " [id=" + id + ", name=" + name + ", password=" + password + "]";
		
	}

}
