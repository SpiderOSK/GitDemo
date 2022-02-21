package com.APITestingFramewok.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfiguManager {
	
	private static ConfiguManager manager;
	
	private static final Properties pro = new Properties();
	
	public ConfiguManager() throws IOException {
		
		InputStream inputStream = ConfiguManager.class.getResourceAsStream("C:\\Users\\DELL-PC\\Documents\\RestAssured\\com.APITestingFramewok\\Resources\\config.properties");
		pro.load(inputStream);
	}
	
	public static ConfiguManager getInstance() {
		
		if(manager == null) {
			synchronized (ConfiguManager.class) {
				try {
					manager = new ConfiguManager();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return manager;
	}
	
	public String getString(String key) {
		return System.getProperty(key,pro.getProperty(key));
	}
}
