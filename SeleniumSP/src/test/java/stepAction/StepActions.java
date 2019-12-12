package stepAction;



import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import repository.Repository;



public class StepActions {

	static Repository repository = new Repository();
	static WebDriver driver;
	private static final HashMap<String,String> map= new HashMap<>();
	
	public void startUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/chromedriver.exe");
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

	public WebElement getElement(String elementName) {
             String str=repository.getXpaths(elementName);
		WebElement element = driver.findElement(By.xpath(str));
		return element;
	}
	
	public boolean openApplication() throws Exception{
		String url= repository.getRole("applicationURL", "URL");
		driver.get(url);
		return true;
	}
	
	public boolean clicks(String elementName) throws Exception{
		WebElement element =getElement(elementName);
		element.click();
		return true;
	}
	

	public boolean enterValue(String value,String elementName) throws Exception {
		WebElement textbox =getElement(elementName);
	    textbox.clear();
		textbox.sendKeys(value);	
		return true;
	}

	public boolean hoversAndClick(String hoverElement, String clickElement) throws Exception{
		
            WebElement hover =getElement(hoverElement);
            WebElement clickOn =getElement(clickElement);
            Actions action = new Actions(driver);
        	action.moveToElement(hover).click(clickOn).build().perform();
        	return true;
	}

	public void loginAsUser(String role) throws Exception{
		
		String email = repository.getRole(role,"email");
		String password =repository.getRole(role,"password");
		openApplication();
		clicks("home@signin");
		enterValue(email,"email");
		enterValue(password,"password");
		clicks("signin");
		
	}
	
	public boolean compareValue(String value, String elementName) throws Exception{		
		WebElement element =getElement(elementName);
		String actualValue= element.getAttribute(value);
		System.out.println(actualValue);
		if(actualValue.equalsIgnoreCase(value)) {
			return true;
		}
		else
			return false;	
		
	}

	public boolean enterTextFromProfile(String user, String profileElement, String elementName  ) throws Exception{
		String text =repository.getRole(user,profileElement);
		enterValue(text, elementName);
		return true;
	}
	
	  public boolean comparesEqualityOfTwoStringElementValues(String expectedValue, String elementNAme) throws Exception{
		  WebElement element=getElement(elementNAme);
		  String actualValue=element.getText();		  		  			
		  if(expectedValue.equalsIgnoreCase(actualValue))
		  {
			  System.out.println("\nElement "+actualValue+" is equal to "+actualValue);
			  return true;
		  }		
		  return false;
	}
	
		public boolean fetchAndSaveValueToMap(String elementName,String key) throws Exception
		   {
		   	WebElement element=getElement(elementName);
		   	String actualValue = element.getText();
		        map.put(key,actualValue);		        
		    	System.out.println(actualValue);
		       return true;
		    }
		
		public boolean splitAndSaveValueToMap(String orderKey,String orderNumberKey) throws Exception
		   {	   	
				String actualValue =map.get(orderKey);
				String[] arrSplit=actualValue.split(" ");				
			    for (int i=0; i < arrSplit.length; i++)
			    {
			      System.out.println(arrSplit[i]);
			    }
//				map.put(orderNumberKey,arrSplit[i]);		        
//		    	System.out.println(arrSplit[i]);
		       return true;
		    }
		
		public boolean comparesKeyValueWithActualValue(String elementName,String keyName) throws Exception {
			boolean flag = false;
			String 	expectedValue=map.get(keyName);
			WebElement element=getElement(elementName);
		    String actualValue = element.getText();
		    if(expectedValue==actualValue)
		    {
		    	System.out.println(elementName+" is verified");
		    	flag=true;
		    	return flag;
		    }		    
		    
			return flag;				 
		}
}
