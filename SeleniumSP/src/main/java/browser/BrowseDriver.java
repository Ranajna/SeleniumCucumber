package browser;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bdd.ScenarionContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrowseDriver {
	  private static final Logger logger = LogManager.getLogger(BrowseDriver.class);
	  public static WebDriver driver;	  
	  public static WebDriver getBrowserDriver()
	  {
		  return driver;
	  }	  
  
	  static {
			
		  	startUp();
//			setWebDriverWaits();	
		}

	   @After
	   public void afterScenario() 
	   {
		   tearDown();
	   }

	private static void startUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.info(" >>>>>>>-------Opening Browser Driver");
			
	}

	public void tearDown() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		logger.info(" >>>>>>>-------Closing Browser Driver");
	}

	private static final Thread FINAL_THREAD = new Thread() {
		@Override
		public void run() {
			driver.quit();
			logger.info(" >>>>>>>-------Closing Browser Driver");
		}
	};

	static {
		Runtime.getRuntime().addShutdownHook(FINAL_THREAD);
	}

	public void closeWindow() {
		driver.close();
		logger.info(" >>>>>>>-------Closing Driver");
	}	

	

}
