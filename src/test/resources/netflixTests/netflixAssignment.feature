@testNetflixPublicArea
Feature: Netflix Scenarios to Test

  Background:
  Given a web browser is at the Netflix home page

  Scenario: Netflix Page language
    When the user wants to change the language from PT to EN
    Then Netflix page gets translated to english

  Scenario Outline: Attempt to login with an inexistent account
    When the user wants to log in with an inexistent "<account>"
    Then Netflix page returns an error message
    Examples: inexistent account
      | account               |
      | anderson@cesar.school |
      | anderson@school.cesar |

  Scenario: Netflix plan to choose before tryout of thirty days
    When the user selects Watch Free for Thirty days
    And Wants to see the plans to sign
    Then the following related plans are shown

  Scenario: Get Netflix contact number for Brazil
    When the user clicks on Contact Us
    And Clicks on Call us
    Then Netflix contact number for Brazil is shown

  Scenario Outline: Ways to watch Netflix
    When the user wants to see the the ways to watch Netflix
    Then Netflix display the "<list>" of devices is available
    Examples: list of ways to watch
      | list                    |
      | Streaming Media Players |
      | Smart TVs               |
      | Game Consoles           |
      | Set-top Boxes           |
      | Blu-ray Players         |
      | Smartphones & Tablets   |
      | PCs & Laptops           |