$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/featureFiles/Sample.feature");
formatter.feature({
  "name": "To perform Automation Assignments",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sample"
    }
  ]
});
formatter.scenario({
  "name": "To Sign and buy a T-shirt",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sample"
    },
    {
      "name": "@placeOrder"
    }
  ]
});
formatter.step({
  "name": "user login to application as \"Ranju\" user",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.loginAsUser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"tshirt\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user hovers over \"product\" and clicks on \"addtocart\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.hoverAndClick(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"cart\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"nextcheckout\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"checkout\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"terms\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"lastcheckout\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"paybywire\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"confirmorder\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user compares expected value \"Your order on My Store is complete.\" is equal to actual element \"ordercomplete\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verifyValueInTwoElements(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user fetches order refrence number \"orderreferenceno\" and saves to \"OrderNumber\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.fetchAndSaveValue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user splits order refrence number key \"OrderNumber\" to capture order number and saves to \"UniqueOrderNumber\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.splitOrderStringAndSaveValue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"myorders\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies expected key value \"UniqueOrderNumber\" is equal to actual element value",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.compareKeyAndActualValue(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"signout\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update Personal Information",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sample"
    },
    {
      "name": "@updatePersonalDetails"
    }
  ]
});
formatter.step({
  "name": "user login to application as \"Ranjana\" user",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.loginAsUser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"myaccount\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"personalinfo\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"autobot\" in \"firstname\" textbox",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.enterValueInTextbox(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"Ranjana\" user\u0027s \"password\" in \"oldpassword\" field",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.enterFromProfile(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"save\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"myaccount\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"personalinfo\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user compares expected value \"autobot\" actual value of element \"firstname\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.compareExpectedAndActualValue(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"signout\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.click(String)"
});
formatter.result({
  "status": "passed"
});
});