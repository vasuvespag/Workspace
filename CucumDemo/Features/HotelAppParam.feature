Feature: HotelApp Login

Scenario: Login Successful

Given User is on HotelApp Login Page
When User enters Username as <"vasuvespag">
And User enters Password as <"Vasu1234">
And User Clicks on Login button
Then Login is successful 