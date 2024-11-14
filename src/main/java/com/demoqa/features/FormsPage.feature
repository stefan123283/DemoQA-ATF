Feature: Form Flow Test Suite

  Background:
    Given The defined url + "" end part is accessed

  @Regression1
  Scenario Outline: Successful form submit with valid data
    When Forms Page is populated with the following data:
      | firstName   | <firstName>   |
      | lastName    | <lastName>    |
      | email       | <email>       |
      | phoneNumber | <phoneNumber> |
    Then The confirmation message is displayed
    Examples:
      | firstName | lastName | email  | phoneNumber |
      | RANDOM    | RANDOM   | RANDOM | RANDOM      |