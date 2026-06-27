package com.loader;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
public class PropertyLoader {		
	 public static final String DRIVER;
	    public static final String URL;
	    public static final String USER;
	    public static final String PASSWORD;
	    static {
	        Properties properties = new Properties();
	        try {    // Load a file and set the Properties in to Propertied object
	            properties.load(new FileInputStream("resources/DB.properties"));
	        } catch (IOException e) {
	           e.printStackTrace(); 
	        }
	        DRIVER = properties.getProperty("DB.driver");
	        URL = properties.getProperty("DB.url");
	        USER = properties.getProperty("DB.user");
	        PASSWORD = properties.getProperty("DB.password");

           }


}
