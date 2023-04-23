Feature: Add- Edit and Delete Functionality for Attestations under Human Resources

  Background:
    Given Navigate to Campus
    When Enter username and password and click button
    Then User should login successfully

  Scenario: Adding an attestation under Human Resources menu(positive test)
    Given User clicks on humanResources
    And Selects setup
    And Click an attestations menu
    And click  Add button on dialog content page
    Then write a name of the attestation in the dialog box and and then click save button
    Then verify the display of the message, Attestation successfully created

  Scenario: trying to add the same attestation which was already added under Human Resources Menu(negative test)
    Given User clicks on humanResources
    And Selects setup
    And Click an attestations menu
    And click  Add button on dialog content page
    Then write a name of the attestation in the dialog box and and then click save button
    Then verify the display of the message, The attestation with name  already exists

  Scenario: edit the name of the attestation already added in test case number CAM_03_TC_01
    Given User clicks on humanResources
    And Selects setup
    And Click an attestations menu
    And Click search inbox and type the name of the attestation already added in the first scenario of this feature and click search button
    And Click edit button and update the name of the attestation appearing in the dialog box and click save button
    Then verify the display of message Attestation successfully updated

  Scenario: delete the name of the attestation edited in the third scenario of this feature(positive test)
    Given User clicks on humanResources
    And Selects setup
    And Click an attestations menu
    And Click search inbox and type the name of the attestation already edited in the third scenario of this feature and click search button
    And Click delete image button and click delete button
    Then verify the display message Attestation successfully deleted

  Scenario: trying the name of the already deleted attestation in previous scenario(negative test)
    Given User clicks on humanResources
    And Selects setup
    And Click an attestations menu
    And Click search inbox and type the name of the attestation already edited in the third scenario of this feature and click search button
    Then There is no data to display message is displayed
