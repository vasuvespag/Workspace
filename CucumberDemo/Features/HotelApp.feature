Feature: HotelApp Login

Background:
Given I am on HotelApp login page

Scenario: Login successful
    
    When user enters username field
    And user enters in password field
    And user clicks Login button
    Then user gets login successful message