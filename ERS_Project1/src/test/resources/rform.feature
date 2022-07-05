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
Feature: RequestForm

	Scenario: EventType
			Given an Employee has succesfully logged in and makes a NewRequest
			When they click the drop down menu for EventType 
			Then they select an EventType
			
	Scenario: GradeFormat
			Given an Employee has succesfully logged in and makes a NewRequest
			When they click the drop down menu for GradeFormat 
			Then they select a GradeFormat
