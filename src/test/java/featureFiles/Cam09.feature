
Feature:School Departments  Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully
    And Navigate to setup page

  Scenario: Create Departments
    When click to  departments
    And click  Add button  and save button
    Then Success message  should be displayed

  Scenario: Create Departments 2
    When click to  departments
    And click  Add button  and save button
    Then Already exist  message should be displayed

  Scenario: Edit Departments
    When click to  departments
    And click  Edit  button and save button
    Then Success message should be displayed

  Scenario: Delete to Departments
    When click to  departments
    And click Delete button
    Then Success message should be displayed

  Scenario: Delete to Departments 2
    When click to  departments
    Then Element should not displayed






