
@HW
Feature: Modifying employees details

  Background:
    And user is logged in with valid admin credentials
    And user clicks on PIM option
    And user navigates to employee list page
    And user enters valid employee id
    And click on search button

  Scenario: Adding a new information to employee file
    And user see employee information is displayed and click on the employee name
    And user click on edit button
    And user adding to employee file all new information
    Then user click on save button

