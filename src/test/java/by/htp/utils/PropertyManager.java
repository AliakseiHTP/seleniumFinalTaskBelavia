package by.htp.utils;

import java.util.ResourceBundle;

public class PropertyManager {
	 private static final ResourceBundle tc, td;

	    static {
	    	tc = ResourceBundle.getBundle("test-config");
	    	td = ResourceBundle.getBundle("test-data");
	    }

	    public static String getSettingsProperty(String s){
	        return tc.getString(s);
	    }
	    
	    public static String getProperty(String s){
	        return td.getString(s);
	    }
}
