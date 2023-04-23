Feature: Human Resources Setup

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully

  Scenario: Adding "Position Categories" (Positive test)
    When User clicks on humanResources
    And Selects setup
    And Clicks on position categories
    And Clicks on add position categories
    And Enters position category
    And Clicks on save button
    Then Position Category successfully created message is displayed

  Scenario: Adding "Position Categories" (Negative Test)
    When User clicks on humanResources
    And Selects setup
    And Clicks on position categories
    And Clicks on add position categories
    And Enters position category
    And Clicks on save button
    Then The Position Category already exists message is displayed

  Scenario: Editing "Position Categories" (Positive Test)
    When User clicks on humanResources
    And Selects setup
    And Clicks on position categories
    And Edit the position category
    Then Position Category successfully updated message is displayed

  Scenario: Deleted "Position Categories" (Positive Test)
    When User clicks on humanResources
    And Selects setup
    And Clicks on position categories
    And Delete the position category
    Then Position Category successfully deleted message is displayed

  Scenario: Deleted "Position Categories" (Negative Test)
    When User clicks on humanResources
    And Selects setup
    And Clicks on position categories
    And Enter the category position will be delete
    And Clicks on search button at position categories
    Then There is no data to display message is displayed
