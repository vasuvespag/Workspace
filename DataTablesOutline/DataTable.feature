#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: DataTable Outline
  Use Data Table for populating Username and Password from the feature file

  @tag1
  Scenario: Sucessful login to HotelApp
    Given I am on HotelApp home page
    When I specify the following details
     
      | username | password |
      | adactin123 | adactin123 |
      | Adaptive234 | Maxx234 |
    Then I am logged in successfully
