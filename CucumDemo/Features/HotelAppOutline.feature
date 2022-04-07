Feature: HotelApp Login
  I want to use this template for my feature file

  Scenario Outline: Login successful.
    Given User is on HotelApp Login Page
    When User enters Username as <"<username>">
    And User enters Password as <"<password>">
    And User Clicks on Login button
    Then Login is successful

    Examples:
      |  username  | password   |
      | Anu56789   | Anus@345   |
      | Deepak2510 | Deepak@2000|
      | Vasuvespag | Vasu1234   |