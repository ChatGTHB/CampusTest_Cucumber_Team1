package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.LeftNav;


public class Cam09Steps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to setup page")
    public void navigateToSetupPage() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.schoolSetup);
    }

    @When("click to  departments")
    public void clickToDepartments() {
        ln.clickFunction(ln.departments);
    }

    @And("click  Add button  and save button")
    public void clickAddButtonAndSaveButton() {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput,"Erzurum");
        dc.sendKeysFunction(dc.codeInput,"25");
        dc.clickFunction(dc.saveButton);
    }

    @Then("Success message  should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @Then("Already exist  message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.clickFunction(dc.close);
        dc.verifyContainsTextFunction(dc.already,"already");
    }

    @And("click  Edit  button and save button")
    public void clickEditButtonAndSaveButton() {
        dc.clickFunction(dc.edit);
        dc.sendKeysFunction(dc.nameInput,"Oltu");
        dc.sendKeysFunction(dc.codeInput,"dadas");
        dc.clickFunction(dc.saveButton);
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @And("click Delete button")
    public void clickDeleteButton() {
        dc.clickFunction(dc.deleteImageButton);
        dc.clickFunction(dc.deleteDialogButton);
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @Then("Element should not displayed")
    public void elementShouldNotDisplayed() {
        dc.FoundElement(dc.deletedElement2);
    }
}
