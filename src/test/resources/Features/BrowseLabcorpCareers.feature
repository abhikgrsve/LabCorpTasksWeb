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
Feature: Job search and application process on LabCorp website

  Scenario: Search for QA Test Automation Developer position and apply
    Given I open the browser and navigate to the LabCorp website
    When I click on the Careers link
    And I search for the job title "QA Test Automation Developer"
    And I select the job from the list
    Then I should verify the job details:
      | Job Title                     | QA Test Automation Developer |
      | Job Location                  | Bangalore, India             |
      | Job Id                        | 2430746                      |
      | Description Intro Text        | 5-10 years relevant ... 		 |
      | Management Intro Text         | Test Plans ... 		 					 |
      | Confirm Exp         					| 5+ years of experience ... 	 |
      | Contains Intro Text         	| Selenium ... 		 					 	 |
      
    When I click on the Apply Now button
    Then I should verify that the application page displays the same job details:
      | Job Title                     | QA Test Automation Developer |
      | Job Location                  | Bangalore, India             |
      | Job Id                        | 2430746                      |
      | Description Intro Text        | 5-10 years relevant ... 		 |
      | Management Intro Text         | Test Plans ... 		 					 |
      | Confirm Exp         					| 5+ years of experience ... 	 |
      | Contains Intro Text         	| Selenium ... 		 					 	 |
    When I return to the job search
