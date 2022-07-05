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
Feature: FinanceManager Login

Background:
			Given the FinanceManager is on the LoginPage
			
			Scenario Outline: A FinanceManager can Login using their username and password
			When the FinanceManager enters their "<username>" and "<password>" and clicks the login button
			Then the FinanceManager will go to either the FinanceManagerPortal
			
	Examples:
		| username	| password |
    | nameuser 	| wordpass |
