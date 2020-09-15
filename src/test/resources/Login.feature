Feature: Login Functionality

  In order to buy something
  As a valid customer
  I want to login successfully

  # Scenario Login Successful
  @Login
  Scenario Outline: Login Successful

    Given User is in the home page of the site
    And go to Sign in page
    When User enter valid <email> and <password>
    Then User should be taken to the My Account page

    Examples:
      | email                      | password          |
      | "luiz.ro.aguiar@gmail.com" | "HGs!F6eDH24k@8Z" |

  # Scenario Login Failed
  @Login
  Scenario Outline: Login Failed

    Given User is in the home page of the site
    And go to Sign in page
    When User enter invalid <email> and <password>
    Then User should receive the error message <message>

    Examples:
      |email                     |password  |message                     |
      |"luiz.ro.aguiar@gmail.com"|"password"|"Authentication failed."    |
      |""                        |""        |"An email address required."|