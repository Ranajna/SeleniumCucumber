package browser;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bdd.ScenarionContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BrowseDriver {
	  public static WebDriver driver;	  
	  public static WebDriver getBrowserDriver()
	  {
		  return driver;
	  }
	  
//	  @Before
//	   public void beforeScenario() 
//	  { 
//	    	startUp();	
//	   }
	  
	  static {
			
		  	startUp();
//			setWebDriverWaits();	
		}

	   @After
	   public void afterScenario() 
	   {
		   tearDown();
	   }
	
//	static Repository repository = new Repository();
	   ScenarionContext scenariocontext = new ScenarionContext();

	private static void startUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
	}

	public void tearDown() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

	private static final Thread FINAL_THREAD = new Thread() {
		@Override
		public void run() {
			driver.quit();
		}
	};

	static {
		Runtime.getRuntime().addShutdownHook(FINAL_THREAD);
	}

	public void closeWindow() {
		driver.close();
	}	

	

}
