Feature: : Gestion de login

  As a prospect customer
  I want to register in the Katapult web application
  To access the website

  @RegisterFailed @Plan
  Scenario Outline: New customer registration failed
    Given  Camilo opens the browser in the login home
    When he goes to the registration Home
    And he enters his information
      | Name             | <name>             |
      | Last name        | <last_name>        |
      | Second last name | <second_last_name> |
      | Document type    | <document>         |
      | Document number  | <document_number>  |
      | Email            | <email>            |
      | Phone number     | <phone_number>     |
      | Password         | <password>         |
    And he enters address confirmation
      | Select city         | <city>         |
      | Enters street       | <street>       |
      | Enters number       | <number>       |
      | Enters house number | <house_number> |
    Then he verifies email registration correctly

    Examples:
      | name   | last_name | second_last_name | document | document_number | email              | phone_number | password | city   | street | number | house_number |
      | Carlos | Lopez     | Ruiz             | NIT      | 1081514444      | carlos@hotmail.com | 3131234561   | Asd123.1 | Bogotá | 71     | 73 A   | 44           |

  @RegisterSuccess @Plan
  Scenario Outline: Customer registered before
    Given  Camilo opens the browser in the login home
    When he goes to the registration Home
    And he enters his information
      | Name             | <name>             |
      | Last name        | <last_name>        |
      | Second last name | <second_last_name> |
      | Document type    | <document>         |
      | Document number  | <document_number>  |
      | Email            | <email>            |
      | Phone number     | <phone_number>     |
      | Password         | <password>         |
    And he enters address confirmation
      | Select city         | <city>         |
      | Enters street       | <street>       |
      | Enters number       | <number>       |
      | Enters house number | <house_number> |
    Then he verifies email registration correctly

    Examples:
      | name   | last_name | second_last_name | document             | document_number | email                | phone_number | password  | city   | street | number | house_number |
      | Camilo | Mamian    | Becerra          | Cédula de ciudadanía | 1081515555      | camilomabe@gmail.com | 3131234562   | Kata2022. | Bogotá | 71     | 73 A   | 44           |