@today
Feature: Adding Employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  Scenario: first scenario of adding an employee
    #And user is logged in with valid admin credentials
    #When user clicks on PIM option
    #And user clicks on Add Employee button
    When user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @newtoday
  Scenario: adding an employee from feature file
    When user enters "Wednesday27" "October10" "Fall2021"
    And user clicks on save button
    Then employee added successfully

  Scenario: second scenario of adding an employee
    #And user is logged in with valid admin credentials
    #When user clicks on PIM option
    #And user clicks on Add Employee button
    When user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  Scenario: third scenario of adding an employee
    #And user is logged in with valid admin credentials
    #When user clicks on PIM option
    #And user clicks on Add Employee button
    When user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirm password
    And user clicks on save button
    Then employee added successfully

  @example
  Scenario Outline: adding an employee from feature file
    When user enters "<firstName>" "<middleName>" "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName   | middleName | lastName |
      | Wednesday01 | October01  | Fall01   |
      | Wednesday02 | October02  | Fall02   |
      | Wednesday03 | October03  | Fall03   |

    @newexample
  Scenario: adding an employee using data table
    When user add multiple employees and verify that user has been added successfully
      | firstName   | middleName | lastName |
      | Wednesday06 | October06  | Fall06   |
      | Wednesday07 | October07  | Fall07   |
      | Wednesday08 | October08  | Fall08   |
      | Wednesday09 | October09  | Fall09   |
      | Wednesday10 | October10  | Fall10   |

      # in this case no examples and regular scenario

  @excel
  Scenario: Adding an employee from excel file
    When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee


