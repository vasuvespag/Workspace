#Author: shubhangi.bharti@capgemini.com

Feature: MunchIT
Background: Customer has already logged in with valid credentials 
and is navigated to place order page.

Scenario: verify if the title is correct
Given Customer is on Welcome to MunchIT page
Then verify the title of the page

Scenario: Verify Successful placing order with all valid inputs
Given Customer is on Welcome to MunchIT page
When Customer enters all valid inputs 
Then It should display successful message on next page

Scenario: Failure in placing order on leaving the Customer Name empty 
Given Customer is on Welcome to MunchIT page
When Customer leaves Customer Name empty
And Clicks the Place Order button
Then Display Alert msg 


Scenario Outline: Validate login with multiple test data 
Given Customer is on Welcome to MunchIT page
When Customer enters customer name  <custname> and address <address>
Then Order should get placed successfully 
Examples:
|custname|address|
|"Virat"|"Delhi"|
|"Dhoni"|"Delhi"|
|"Sachin"|"Mumbai"|


Scenario: Failure in placing order on incorrect Contact no format 
Given Customer is on Welcome to MunchIT page
When Customer enters incorrect mobileNo format and clicks the place order button
|5467983256|
|0900000000|
|7654321111|
|67943|
|98734567854|

Then display alert msg