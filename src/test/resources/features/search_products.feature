Feature: Login in with correct credentials

  As a user registered on Katapult application
  I want to search 6 different products
  To add to cart

  @SearchProduct @Plan
  Scenario Outline: Login with correct credentials
    Given Camilo opens the browser in the login home
    When he enters his credentials <email> and <pass>
    And he search <products>
    Then he verifies the text of the products found

    Examples:
      | email                | pass      | products                        |
      | camilomabe@gmail.com | Kata2022. | arroz florhuila x10kg           |
      | camilomabe@gmail.com | Kata2022. | harina de trigo corona x500g    |
      | camilomabe@gmail.com | Kata2022. | azucar blanca manuelita x500g   |
      | camilomabe@gmail.com | Kata2022. | frijol americano zapatoca x500g |