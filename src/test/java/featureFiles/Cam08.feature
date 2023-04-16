
Feature:School Locations  Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully
    And Navigate to setup page

  Scenario: Create School Location
    When click to  school location
    And  click to Add button and save button
    Then Success message should be displayed

  Scenario: Create School Location 2
    When click to  school location
    And click to Add button and save button
    Then Already exist message should be displayed

  Scenario: Edit School Location
    When click to  school location
    And click to Edit button and save button
    Then Success message should be displayed

  Scenario: Delete School Location
    When click to  school location
    And click to Delete button
    Then Success message should be displayed

  Scenario: Delete School Location 2
    When click to  school location
    Then Element should not be displayed

