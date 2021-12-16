Feature: Error validation in login page

  @errorValidation
  Scenario: valid username and invalid password
    When user enters invalid credentials and clicks on login button and verify the error
      | username | password    | errorMessage        |
      | Admin    | Hum@        | Invalid credentials |
      | Admin1   | Hun@nhrm123 | Invalid credentials |


  @errorValidationNewExample
  Scenario Outline: valid username and invalid password
    When user enters invalid "<username>" and "<password>" and clicks on login button and verify the "<errorMessage>"
    Examples:
      | username | password    | errorMessage             |
      | Admin    | Hum@        | Invalid credentials      |
      | Admin1   | Hun@nhrm123 | Invalid credentials      |
      | Admin    |             | Password cannot be empty |
      |          | Hun@nhrm123 | Username cannot be empty |