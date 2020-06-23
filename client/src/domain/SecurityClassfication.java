package domain;

/**
 * @author sunrui
 * @time 2018.12.18
 */
public enum SecurityClassfication {
	
	A("A", 1), B("B", 2), C("C", 3), D("D", 4);
	
	// 成员变量  
    private String name;  
    private int index;  
    
    // 构造方法
    private SecurityClassfication(String name, int index) {  
    	
        this.name = name;  
        this.index = index;  
        
    }  
    

    // 普遍方法
    public static SecurityClassfication getSecurityClassfication(String name) {  
    	
        for (SecurityClassfication sc : SecurityClassfication.values()) {  
        	
            if (sc.getName().equalsIgnoreCase(name)) {  
            	
                return sc;  
                
            }  
            
        }  
        
        return SecurityClassfication.D;  
        
    }
 
    // get set 方法  
    public String getName() {  
    	
        return name;  
        
    }  
    
    
    public void setName(String name) {  
    	
        this.name = name;  
        
    }  
    
    
    public int getIndex() {  
    	
        return index;  
        
    }  
    
    
    public void setIndex(int index) {  
    	
        this.index = index;  
        
    } 
	
}
