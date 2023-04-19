package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;

public class Cam03Steps {

    LeftNav ln = new LeftNav();

    DialogContent dc = new DialogContent();

    @And("Click an attestations menu")
    public void clickAnAttestationsMenu() {
        ln.clickFunction(ln.attestations);
    }

    @And("click  Add button on dialog content page")
    public void clickAddButtonOnDialogContentPage() {
        dc.clickFunction(dc.addButton);
    }

    @Then("write a name of the attestation in the dialog box and and then click save button")
    public void writeANameOfTheAttestationInTheDialogBoxAndAndThenClickSaveButton() {
        dc.sendKeysFunction(dc.nameInput, "attestation de residence");
        dc.clickFunction(dc.saveButton);
    }

    @Then("verify the display of the message, Attestation successfully created")
    public void verifyTheDisplayOfTheMessageAttestationSuccessfullyCreated() {
        dc.waitUntilVisible(dc.attestationCreationMessage);
        Assert.assertTrue(dc.attestationCreationMessage.isEnabled());
    }

    @Then("verify the display of the message, The attestation with name  already exists")
    public void verifyTheDisplayOfTheMessageTheAttestationWithNameAlreadyExists() {
        dc.waitUntilVisible(dc.attestationAlreadyExists);
        dc.verifyContainsTextFunction(dc.attestationAlreadyExists, "already exists");
    }

    @And("Click search inbox and type the name of the attestation already added in the first scenario of this feature and click search button")
    public void clickSearchInboxAndTypeTheNameOfTheAttestationAlreadyAddedInTheFirstScenarioOfThisFeatureAndClickSearchButton() {
        dc.sendKeysFunction(dc.searchInput, "attestation de residence");
        dc.clickFunction(dc.searchButton);
    }

    @And("Click edit button and update the name of the attestation appearing in the dialog box and click save button")
    public void clickEditButtonAndUpdateTheNameOfTheAttestationAppearingInTheDialogBoxAndClickSaveButton() {
        dc.waitUntilClickable(dc.searchButton);
        dc.clickFunction(dc.editButton);
        dc.waitUntilClickable(dc.nameInput);
        dc.nameInput.clear();
        dc.sendKeysFunction(dc.nameInput, "attestation du travail");
        dc.clickFunction(dc.saveButton);
    }

    @Then("verify the display of message Attestation successfully updated")
    public void verifyTheDisplayOfMessageAttestationSuccessfullyUpdated() {
        dc.verifyContainsTextFunction(dc.attestationUpdateSuccess, "successfully updated");
    }

    @And("Click search inbox and type the name of the attestation already edited in the third scenario of this feature and click search button")
    public void clickSearchInboxAndTypeTheNameOfTheAttestationAlreadyEditedInTheThirdScenarioOfThisFeatureAndClickSearchButton() {
        dc.sendKeysFunction(dc.searchInput, "attestation du travail");
        dc.clickFunction(dc.searchButton);
    }

    @And("Click delete image button and click delete button")
    public void clickDeleteImageButtonAndClickDeleteButton() {
        dc.waitUntilClickable(dc.searchButton);
        dc.clickFunction(dc.deleteImageButton);
        dc.clickFunction(dc.deleteDialogButton);
    }

    @Then("verify the display message Attestation successfully deleted")
    public void verifyTheDisplayMessageAttestationSuccessfullyDeleted() {
        dc.verifyContainsTextFunction(dc.attestationDeleteSuccess, "successfully deleted");
    }
}
