Feature: Cam7

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully


  Scenario: Adding Subject Categories (Positive Test)

    And Navigate to Subject Categories page
    When Admin add an Subject Categories
    Then Success message should be displayed

  Scenario: Adding Subject Categories (Negative Test)

    And Navigate to Subject Categories page
    When Admin add an Subject Categories
    Then Already exist message should be displayed

  Scenario: Edit Subject Categories (Positive Test)

    And Navigate to Subject Categories page
    When Admin edit an Subject Categories
    Then Subject Categories successfully updated message is displayed

  Scenario: Delete Subject Categories (Positive Test)

    And Navigate to Subject Categories page
    When Admin delete an Subject Categories
    Then Subject Categories successfully deleted message is displayed

  Scenario: Delete Subject Categories (Negative Test)

    And Navigate to Subject Categories page
    And Enter the Subject Categories will be delete
    And Clicks on search button
    Then There is no data to show message is displayed




