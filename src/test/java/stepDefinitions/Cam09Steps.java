package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;


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
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", dc.saveButton);
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        js.executeScript("arguments[0].click();", dc.saveButton);

       // dc.clickFunction(dc.saveButton);
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
