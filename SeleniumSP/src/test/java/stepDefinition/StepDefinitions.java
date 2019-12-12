package stepDefinition;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import stepAction.StepActions;


public class StepDefinitions {
	
StepActions sampleStepActions=new StepActions();
  static WebDriver driver;

  public static WebDriver getBrowserDriver()
  {
	return driver;
  }
  
  @Before
   public void beforeScenario() 
  { 
    	sampleStepActions.startUp();	
   }

   @After
   public void afterScenario() 
   {
	   sampleStepActions.tearDown();
   }
   
   @Given("^user waits for \"(.*)\" milli seconds$")
   public void systemWait(Long sec) throws Exception{
	   Thread.sleep(sec);
   }
   
   @When("^user login to application as \"(.*)\" user$")
	public void loginAsUser(String role) throws Exception{
		try {
			sampleStepActions.loginAsUser(role);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new AssertionError("Error while login to application as '"+role+"'"	+"\n"+ex);				
		}
	}
	
   @Given("^user hovers over \"(.*)\" and clicks on \"(.*)\"$")

   public void hoverAndClick(String hoverElement,String clickElement) throws Exception {
          boolean result = sampleStepActions.hoversAndClick(hoverElement, clickElement);
          if(!result) {
                 throw new Exception("Error while hovering  over '"+hoverElement+"' and clicking on '"+clickElement+"'");
          }            
   }

   
	@Given("^application is opened$")
	public void applicationopen() throws Exception {
	   boolean result=sampleStepActions.openApplication();
	   if(!result)
		   throw new Exception("Error while opening application");
	}
	
	@Given("^user enters \"(.*)\" user's \"(.*)\" in \"(.*)\" field$")
	public void enterFromProfile(String user,String profileElement,String elementName ) throws Exception{
		boolean result=sampleStepActions.enterTextFromProfile(user,profileElement,elementName);
		   if(!result)
			   throw new Exception("Error while entering "+profileElement+"from Profile in "+elementName+" textbox");
	}
	
	@Given("^user clicks on \"(.*)\"$")
	public void click(String elementName) throws Exception {
				boolean result=sampleStepActions.clicks(elementName);
		if(!result)
			   throw new Exception("Error while clicking on "+elementName);
	}
	
	@Given("^user enters \"(.*)\" in \"(.*)\" textbox$")
	public void enterValueInTextbox(String value,String textboxName) throws Exception{		
		boolean result = sampleStepActions.enterValue(value,textboxName);
		if(!result) {
			throw new Exception("Error while enterring value:'"+value+"' in textbox '"+textboxName+"'");
		}		
	}
	
	@Given("^user compares expected value and \"(.*)\" actual value of element \"(.*)\"$")
	public void compareExpectedAndActualValue(String expectedValue,String textboxName) throws Exception{		
		boolean result = sampleStepActions.compareValue(expectedValue,textboxName);
		if(!result) {
			throw new Exception("Error while comparing expected value:'"+expectedValue+"' and actual value.'");
		}		
	}
	
	@Given("^user compares expected value \"(.*)\" is equal to actual element \"(.*)\"$")
	public void verifyValueInTwoElements(String expectedVal,String elementName) throws Exception{
	    boolean result=sampleStepActions.comparesEqualityOfTwoStringElementValues(expectedVal,elementName);
	    if(!result) {
	        throw new Exception("Error while verifying '"+expectedVal+"' and '"+elementName+"'");
	    }
	}
	
	@Given("^user fetches order refrence number \"(.*)\" and saves to \"(.*)\"$")
	public void fetchAndSaveValue(String value,String keyName) throws Exception{
		boolean result=sampleStepActions.fetchAndSaveValueToMap(value,keyName);
		Thread.sleep(5000);
        if(!result) {
            throw new Exception("Error while saving '"+value+"' to system");
        }
	}
	
	@Given("^user splits order refrence number key \"(.*)\" to capture order number and saves to \"(.*)\"$")
	public void splitOrderStringAndSaveValue(String orderKeyName,String orderNumberName) throws Exception{
		boolean result=sampleStepActions.splitAndSaveValueToMap(orderKeyName,orderNumberName);
		Thread.sleep(5000);
        if(!result) {
            throw new Exception("Error while saving '"+orderNumberName+"' to system");
        }
	}
        
    	@Given("^user verifies expected key value \"(.*)\" is equal to actual element value \"(.*)\"$")
    	public void compareKeyAndActualValue(String elementName,String variableName) throws Exception{
    	    boolean result=sampleStepActions.comparesKeyValueWithActualValue(elementName,variableName);
    	      if(!result) {
    	        throw new Exception("Error while verifying '"+elementName+"' and '"+variableName+"'");
    	    }
    	}
	
	
	
}
