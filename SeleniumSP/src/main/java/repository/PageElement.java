package repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.Initialize;
import browser.BrowseDriver;


public class PageElement {
	private static final Logger logger = LogManager.getLogger(Initialize.class);

	public String getXpaths(String elementName)
	{
		logger.info("++ Fetching Xpath from OR");
		String xpath= Initialize.pro.getProperty(elementName);
		return xpath;
	}
	
	public WebElement getElement(String elementName)throws Exception {
		Exception exception = null;
		WebElement element =null;
		try {
			logger.info("++ Attempting to find the element");
			String str = getXpaths(elementName);
			element = BrowseDriver.driver.findElement(By.xpath(str));		
			
		}
		
		catch(Exception ex) {
			logger.info("Exception occured.Trying to recover"+ex.getMessage());
				exception = ex;
		}
		return element;
	}
	
	
}
