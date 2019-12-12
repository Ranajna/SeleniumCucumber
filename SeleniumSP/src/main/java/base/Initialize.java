package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.LogManager;

import org.ini4j.Ini;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.Logger;


public class Initialize {
//	private static final Logger logger = LogManager.getLogger(Initialize.class);
	public static final Properties pro= new Properties();
	public static Ini envConfig= new Ini();
	
	public Initialize()
	{
	try {
//		logger.info("++ Initializing Framework");
//		logger.info("++ Loading Repo Property File");
		File src = new File ("./src/main/resources/repo.property");
		FileInputStream ip= new FileInputStream(src);
		pro.load(ip);
//		logger.info("++ Loading Repo Property File");
//		logger.info("Loading repo from file:"+System.getProperty(pro.getProperty("RunMsg")));
//		logger.info("++ Loading EnvironmentConfig File");
		envConfig.load(new File("./src/test/resources/envtConfigurations/"+System.getProperty("EnvironmentConfig")+".ini"));
		System.out.println("Environment Loaded\n");
	} 
	catch (Exception e) 
	{
		System.out.println("Error message ="+e.getMessage());
	} 
	}
	
	public String getRole (String role,String email) {
		return envConfig.get(role, email);
	}
	
	   
}
