Feature: Login Functionality

  @SmokeTest
  Scenario: Login Functionality

    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully