package stepAction;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.Initialize;
import browser.BrowseDriver;
import repository.PageElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepActions {
	private static final Logger logger = LogManager.getLogger(StepActions.class);
	PageElement pagelement = new PageElement();
	Initialize initialize = new Initialize();
	private static final HashMap<String, String> map = new HashMap<>();

		public boolean clicks(String elementName) throws Exception {
		logger.info("++ Clicking on element");
		WebElement element = pagelement.getElement(elementName);
		element.click();
		return true;
	}

	public boolean enterValue(String value, String elementName) throws Exception {
		logger.info("++ Entering Value");
		WebElement textbox = pagelement.getElement(elementName);
		textbox.clear();
		textbox.sendKeys(value);
		return true;
	}
	public boolean openApplication() throws Exception {
		logger.info("++ Opening the application");
		String url = initialize.getRole("applicationURL", "URL");
		BrowseDriver.driver.get(url);
		return true;
	}
	public boolean hoversAndClick(String hoverElement, String clickElement) throws Exception {
		logger.info("++ Hovering the element");
		WebElement hover = pagelement.getElement(hoverElement);
		WebElement clickOn = pagelement.getElement(clickElement);
		Actions action = new Actions(BrowseDriver.driver);
		action.moveToElement(hover).click(clickOn).build().perform();
		return true;
	}

	public void loginAsUser(String role) throws Exception {		
		String email = initialize.getRole(role, "email");
		String password = initialize.getRole(role, "password");
		openApplication();
		logger.info("++ Performing Login to the application");
		clicks("home@signin");
		enterValue(email, "email");
		enterValue(password, "password");
		clicks("signin");

	}

	public boolean compareValue(String expectedValue, String elementName) throws Exception {
		logger.info("++ Comparing expected and actual value");
		WebElement element = pagelement.getElement(elementName);
		String actualValue = element.getAttribute("value");
		System.out.println(actualValue);
		Thread.sleep(1000);			
		if (actualValue.equalsIgnoreCase(expectedValue)) {
			return true;
		} else
			return false;

	}

	public boolean enterTextFromProfile(String user, String profileElement, String elementName) throws Exception {
		String text = initialize.getRole(user, profileElement);
		enterValue(text, elementName);
		return true;
	}

	public boolean comparesEqualityOfTwoStringElementValues(String expectedValue, String elementName) throws Exception {
		logger.info("++ Comparing expected and actual strings");
		WebElement element = pagelement.getElement(elementName);
		String actualValue = element.getText();
		if (expectedValue.equalsIgnoreCase(actualValue)) {
			System.out.println("\nElement " + expectedValue + " is equal to " + actualValue);
			return true;
		}
		return false;
	}

	public boolean fetchAndSaveValueToMap(String elementName, String key) throws Exception {
		logger.info("++ fetching and saving value to map");
		WebElement element = pagelement.getElement(elementName);	
		String actualValue = element.getText();
		map.put(key, actualValue);
//		System.out.println(actualValue);
		return true;
	}

	public boolean splitAndSaveValueToMap(String orderKey, String orderNumberKey) throws Exception {
		logger.info("++ Splitting order details");
		String actualValue = map.get(orderKey);
		String[] arrSplit = actualValue.split("reference ");
		String[] orderValue=arrSplit[1].split(" in the subject");
		map.put(orderNumberKey,orderValue[0]);		        
		System.out.println(orderValue[0]);	
		return true;
	}

	public boolean comparesKeyValueWithActualValue(String keyName) throws Exception {
		logger.info("++ comparing key and actual value");
		boolean flag = false;
		String expectedValue = map.get(keyName);
		List<WebElement> allLinks = BrowseDriver.driver.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
//			System.out.println(link.getText());
			if (link.getText().trim().equalsIgnoreCase(expectedValue)) {
				flag = true;
				return flag;
			}

		}
		return flag;
	}
}
