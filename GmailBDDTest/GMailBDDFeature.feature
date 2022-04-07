#Author: B.Vasudevan
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
Feature: Compose Mail
I am using this to fill up the To, Subject in GMAIL

Background:
Given I am on Gmail login page
When I specify Username and Password
And Click on SignIn button

Scenario: Create new message from data table
When I am on New Email Page
And I specify the following details
| To1 | Subject |
| Person1@email.com | Person1 subject |
| Person2@email.com | Person2 subject |