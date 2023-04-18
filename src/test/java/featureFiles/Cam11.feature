Feature:  Bank Account Setup


  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully


  Scenario:Add Grade Levels (Positive)

    When Click Setup button Parameters Button and Grade Levels Button
    And Click Grade Levels Add Button
    And Fill Grade Levels the Blanks
    And Click Grade Levels save button
    Then Verify that Grade Levels Element is Visible


  Scenario: Add Grade Levels (Negative)

    When Click Setup button Parameters Button and Grade Levels Button
    And Click Grade Levels Add Button
    And Fill Grade Levels  the Blanks with same data
    And Click Grade Levels save button
    Then Verify that Grade Levels error text

  Scenario: Edit Grade Levels

    When Click Setup button Parameters Button and Grade Levels Button
    And Click Edit Button
    And Fill the Blanks and save
    And Verify that Editable Element is Visible



  Scenario: Delete Grade Levels(Positive)

    When Click Setup button Parameters Button and Grade Levels Button
    And Click Grade Levels first Delete Button
    And Verify Grade Levels Delete


  Scenario: Delete Grade Levels (Negative)

    When Click Setup button Parameters Button and Grade Levels Button
    And Re-enter a deleted data and try to delete First Delete Element
    Then Verify that the first delete key is not visible



