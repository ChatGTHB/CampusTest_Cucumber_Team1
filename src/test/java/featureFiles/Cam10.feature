Feature:  Bank Account Setup


  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully

  Scenario:

    When Click Setup button Parameters Button and Bank Accounts Button
    And Click Bank Accounts Add Button
    And Fill the Bank Accounts Blanks
    And Click Bank Accounts save button
    Then Verify that Element is Visible

  Scenario:


    When Click Setup button Parameters Button and Bank Accounts Button
    And Click Bank Accounts Add Button
    And Fill the Add Blanks with same Data
    And Click Bank Accounts save button
    Then Verify Bank Accounts error

  Scenario:


    When Click Setup button Parameters Button and Bank Accounts Button
    And Click Bank Accounts DeleteButton
    Then Verify Bank Accounts delete text

  Scenario:


    When Click Setup button Parameters Button and Bank Accounts Button
    And Re-enter a deleted Bank Accounts data and try to delete it
    Then  Verify that the delete key is not visible

  Scenario:


    When Click Setup button Parameters Button and Bank Accounts Button
    And Click Bank Accounts Edit Button
    And Fill the Edit Blanks and save
    Then  Verify that Edit Element is Visible

