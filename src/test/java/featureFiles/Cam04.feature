Feature:Document Types  Functionality

  Background:
    Given Navigate to Campus Page
    When  Enter username and password and click Login Button
    Then Admin should Login succesfully
    And Click on the Document Types
      | setup         |
      | parameters    |
      | documentTypes |


  Scenario Outline:Add Document Types
    When Admin Add New Document Type name as "<name>" stage as <stage>
    And Click save button
    Then Document successfully created message should be displayed

    Examples:
      | name     | stage |
      | cambrige | 3     |


  Scenario Outline:Edit Document Type
    When Admin Edit Document name as "<name>" stage as <stage>
    And Click Search Button
    And Click Edit Button
    And Change document name as "<newname>"
    Then Document successfully updated message should be displayed

    Examples:
      | name     | stage | newname    |
      | cambrige | 4     | cambrige10 |


  Scenario Outline:Delete Document Type  (Positive Test)
    When Admin Delete Document name as "<name>" stage as <stage>
    And Click Delete button
    Then Document successfully deleted message should be displayed

    Examples:
      | name       | stage |
      | cambrige10 | 4     |

  Scenario Outline:Delete Document Type (Negative Test)
    When Admin again Delete Document name as "<name>" stage as <stage>
    And Click Search button on Page
    Then There is no data to display message should be displayed

    Examples:
      | name       | stage |
      | cambrige10 | 4     |









