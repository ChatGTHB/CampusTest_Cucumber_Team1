Feature:Human Resources  Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully


  Scenario: Adding a new position  (Positive)
    When User navigates to Human the Resources page
    And Click on the Setup option and Positions option
    And Click on the Add button and fill in the required fields
    And Click Save button
    Then System should display success message


  Scenario: Not being able to add a new position  (Negative)
    When User navigates to Human the Resources page
    And Click on the Setup option and Positions option
    And Click on the Add button and fill in the required fields
    And Click Save button
    Then Already exist message should be displayed on the page


  Scenario: Editing Positions  (Positive)
    When User navigates to Human the Resources page
    And Click on the Setup option and Positions option
    And Enter the necessary information and click on the search button
    And Click the edit button to enter the necessary edit
    Then System should display update message


  Scenario: Deleting Positions  (Positive)
    When User navigates to Human the Resources page
    And Click on the Setup option and Positions option
    And Click on delete button
    Then System should display success message


  Scenario: Not being able to delete Positions  (Negative)
    When User navigates to Human the Resources page
    And Click on the Setup option and Positions option
    And Enter name and short name and click on search button
    Then System should display no data message





