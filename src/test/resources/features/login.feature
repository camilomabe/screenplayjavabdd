Feature: Login in with correct credentials

  As a user of the Katapult web side
  I want to login
  To verify that my credentials are correct or incorrect

  @LoginSuccess @Plan
  Scenario Outline: Login with correct credentials
    Given Camilo opens the browser in the login home
    When he enters his credentials <email> and <pass>
    Then he verifies that he has logged in correctly with his email

    Examples:
      | email                | pass      |
      | camilomabe@gmail.com | Kata2022. |

  @LoginFailed @Plan
  Scenario Outline: Login with incorrect credentials
    Given Camilo opens the browser in the login home
    When he enters his credentials <email> and <pass>
    Then he sees that he entered his credentials incorrectly

    Examples:
      | email              | pass     |
      | carlos@hotmail.com | Asd123.1 |