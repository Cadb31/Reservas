package com.home.reservas.resources;

import java.io.IOException;
import java.util.Properties;

public class SqlProperties {
	/*fichero properties*/
	/*fichero properties*/
	private String sqlName = "sql.properties";
	
	private Properties properties = null;
	private static SqlProperties instance = null;

	
	public SqlProperties() {
		properties = new Properties();
		try {
			properties.load(SqlProperties.class.getResourceAsStream(sqlName));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}	
	
	public static SqlProperties getInstance(){
		
		if(instance == null){
			instance = new SqlProperties();
		}
		
		return instance;
	}
	
	public String getProperties(String name){
		return properties.getProperty(name);
	}
}
