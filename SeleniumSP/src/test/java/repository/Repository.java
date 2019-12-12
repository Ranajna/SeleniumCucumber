package repository;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.ini4j.Ini;


public class Repository {
	
	static Properties pro;
	static Ini envConfig; 
	public Repository()
	{
	try {
		File src = new File ("./src/test/resources/repo.property");
		FileInputStream ip= new FileInputStream(src);
		pro = new Properties();
		pro.load(ip);
		
		System.out.println(pro.getProperty("RunMsg"));
		
		envConfig = new Ini();
		envConfig.load(new File("./src/test/resources/envtConfigurations/"+System.getProperty("EnvironmentConfig")+".ini"));
		System.out.println("Environment Loaded\n");
	} 
	catch (Exception e) 
	{
		System.out.println("Error message ="+e.getMessage());
	} 
	}
	
	public String getXpaths(String elementName)
	{
		String xpath= pro.getProperty(elementName);
		return xpath;
	}
	
	public String getRole (String role,String email) {
		return envConfig.get(role, email);
	}
	

}
