Feature: HotelApp Login

Scenario Outline: Login successful
    Given I am on HotelApp login page
    When user enters "<UserName>" in username field
    And user enters "<Password>" in password field
    And user clicks Sign in button
    Then user gets login successful message
    
      