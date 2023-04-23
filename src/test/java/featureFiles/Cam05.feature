Feature: Add-Edit-Delete Fields under Parameters under Setup Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fields     |

  Scenario: Add Fields (Positive)
    And Click on the element in Dialog
      | addButton |
    And Add name, code and field type
    And Click on the element in Dialog
      | saveButton |
    Then Success message should be displayed on the screen

  Scenario: Add Fields (Negative)
    And Click on the element in Dialog
      | addButton |
    And Add name, code and field type
    And Click on the element in Dialog
      | saveButton |
    Then Already exist message should be displayed on the screen

  Scenario: Edit Fields (Positive)
    When Enter the name of the fields you added in test case one in the name field to edit
    Then Success message should be displayed on the screen

  Scenario: Delete Fields (Positive)
    When Enter the name of the fields you edited in test case three in the name field and press the search button and push delete button
    Then Success message should be displayed on the screen

  Scenario: Delete Fields (Negative)
    When Enter the name of the fields you edited in test case three in the name field
    And Click on the element in Dialog
      | searchButton |
    Then There is no data to display message is displayed on the screen



