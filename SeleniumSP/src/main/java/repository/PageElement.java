package repository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.Initialize;
import browser.BrowseDriver;


public class PageElement {	

	public String getXpaths(String elementName)
	{
		String xpath= Initialize.pro.getProperty(elementName);
		return xpath;
	}
	
	public WebElement getElement(String elementName) {
		String str = getXpaths(elementName);
		WebElement element = BrowseDriver.driver.findElement(By.xpath(str));
		return element;
	}
	
	
}
