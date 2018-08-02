package by.htp.utils;

import java.util.ResourceBundle;

public class PropertyManager {
	 private static final ResourceBundle rb;

	    static {
	        rb = ResourceBundle.getBundle("test-config");
	    }

	    public static String getProperty(String s){
	        return rb.getString(s);
	    }
}
