package domain;

import java.io.Serializable;

import action.BaseAction;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public class Function implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5881295634773037877L;

	private String name;
	
	transient private BaseAction action;

	public String getName() {
		
		return name;
		
	}

	public void setName(String name) {
		
		this.name = name;
		
	}

	public BaseAction getAction() {
		
		return action;
		
	}
	

	public void setAction(BaseAction action) {
		
		this.action = action;
		
	}

	@Override
	public String toString() {
		
		return "Function [name=" + name + ", action=" + action + "]";
		
	}
	
}
