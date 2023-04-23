package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;

public class Cam06Steps {

    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

    @When("User navigates to Human the Resources page")
    public void userNavigatesToHumanTheResourcesPage() {
        ln.clickFunction(ln.humanResources);
    }

    @And("Click on the Setup option and Positions option")
    public void clickOnTheSetupOptionAndPositionsOption() {
        ln.clickFunction(ln.setupHR);
        ln.clickFunction(ln.positions);
    }

    @And("Click on the Add button and fill in the required fields")
    public void clickOnTheAddButtonAndFillInTheRequiredFields() {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput, "testtechno");
        dc.sendKeysFunction(dc.shortName, "test");
    }

    @And("Click Save button")
    public void clickSaveButton() {
        dc.clickFunction(dc.saveButton);
    }

    @Then("System should display success message")
    public void systemShouldDisplaySuccessMessage() {
        dc.verifyContainsTextFunction(dc.successMessage, "successfully");
    }

    @Then("Already exist message should be displayed on the page")
    public void alreadyExistMessageShouldBeDisplayedOnThePage() {
        dc.verifyContainsTextFunction(dc.alreadyExist, "already exist");
    }

    @And("Enter the necessary information and click on the search button")
    public void enterTheNecessaryInformationAndClickOnTheSearchButton() {
        dc.sendKeysFunction(dc.searchInput, "testtechno");
        dc.sendKeysFunction(dc.shortNameInput, "test");
        dc.clickFunction(dc.searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
    }

    @And("Click the edit button to enter the necessary edit")
    public void clickTheEditButtonToEnterTheNecessaryEdit() throws InterruptedException {
        dc.clickFunction(dc.editButton);
        dc.sendKeysFunction(dc.editName, "technotest");
        dc.sendKeysFunction(dc.editShortName, "techno");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.saveButton);
    }

    @Then("System should display update message")
    public void systemShouldDisplayUpdateMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(dc.successMessage));
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", dc.successMessage);
        js.executeScript("arguments[0].click();", dc.successMessage);
        dc.verifyContainsTextFunction(dc.successMessage, "successfully");
    }

    @And("Click on delete button")
    public void clickOnDeleteButton() {
        dc.clickFunction(dc.deleteImageButton);
        dc.clickFunction(dc.deleteDialogButton);
        dc.verifyContainsTextFunction(dc.successMessage, "successfully");
    }

    @And("Enter name and short name and click on search button")
    public void enterNameAndShortNameAndClickOnSearchButton() {
        dc.sendKeysFunction(dc.searchInput, "technotest");
        dc.sendKeysFunction(dc.shortNameInput, "techno");
        dc.clickFunction(dc.searchButton);
    }

    @Then("System should display no data message")
    public void systemShouldDisplayNoDataMessage() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.searchResult));
        Assert.assertEquals(dc.searchResult.getText(), "There is no data to display");
    }
}


