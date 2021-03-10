package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig()
	
	{
		File src = new File("./Configuration/config.properties");
		
		try {
		
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		
		}
		catch (Exception e)
		{
			System.out.println("Exception is"+ e.getMessage());
		}
	}

	public String getApplicationURL()
	{
	String url = pro.getProperty("baseURL");	
	return url;
	}

	public String getUserame()
	{
	String Username = pro.getProperty("username");	
	return Username;
	}
	
	public String getPassword()
	{
	String Password = pro.getProperty("password");	
	return Password;
	}
	
	public String getChromepath()
	{
	String chromepath = pro.getProperty("chromepath");	
	return chromepath;
	}
	
	public String getfirefoxpath()
	{
	String firefoxpath = pro.getProperty("firefoxpath");	
	return firefoxpath;
	}
	
	public String getIEpath()
	{
	String IEpath = pro.getProperty("iepath");	
	return IEpath;
	}
	
}


