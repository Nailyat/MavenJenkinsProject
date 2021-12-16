Feature: Search employee

  #@regression1 @sprint4
  #Scenario: search employee by ID
    # Given user is navigated to HRMS
   # And user is logged in with valid admin credentials
    #And user navigates to employee list page
    #And user enters valid employee id
    #Then click on search button


  @contactDetails
  Scenario: Adding employee Contact Details
   # Given user is navigated to HRMS
    And user is logged in with valid admin credentials
    And user navigates to employee list page
    And user enters valid employee id
    And click on search button
    Then user clicks on desired employee name on the result table
    When user clicks on Contact Details on sidebar
    And user clicks on edit button
    And user adds employee contact details
    And user clicks on save button
    Then employee contact details added successfully

