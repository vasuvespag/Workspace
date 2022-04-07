Feature: HotelApp Login

Scenario: Login Successful

Given User is on HotelApp Login Page
When User enters Username  
And User enters Password
And User Clicks on Login button
Then Login is successful 