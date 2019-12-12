@sample
Feature: To perform Automation Assignments

  @placeOrder
  Scenario: To Sign and buy a T-shirt
    When user login to application as "Ranjana" user
    And user clicks on "tshirt" 
    And user hovers over "product" and clicks on "addtocart"
    And user clicks on "cart" 
    And user clicks on "nextcheckout"
    And user clicks on "checkout"
    And user clicks on "terms"
    And user clicks on "lastcheckout"
    And user clicks on "paybywire" 
    And user clicks on "confirmorder"
  	And user compares expected value "Your order on My Store is complete." is equal to actual element "ordercomplete"
   	And user fetches order refrence number "orderreferenceno" and saves to "OrderNumber"
    And user splits order refrence number key "OrderNumber" to capture order number and saves to "UniqueOrderNumber"    
    And user clicks on "myorders"
 		And user verifies expected key value "UniqueOrderNumber" is equal to actual element value "(.*)"
  @updatePersonalDetails
  Scenario: Update Personal Information   
  	When user login to application as "Aaron" user
    And user clicks on "myaccount"
    And user clicks on "personalinfo"
    And user enters "autobot" in "firstname" textbox
    And user waits for "500" milli seconds
    And user enters "Aaron" user's "password" in "oldpassword" field
    And user clicks on "save"
    And user clicks on "myaccount"
    And user clicks on "personalinfo" 
    And user compares expected value and "autobot" actual value of element "firstname" 
