package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;
import java.util.List;

public class Cam04Steps {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @Given("Navigate to Campus Page")
    public void navigateToCampusPage() {
        GWD.getDriver().get("https://test.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click Login Button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.sendKeysFunction(dc.username, "turkeyts");
        dc.sendKeysFunction(dc.password, "TechnoStudy123");
        dc.clickFunction(dc.loginButton);
    }

    @Then("Admin should Login succesfully")
    public void adminShouldLoginSuccesfully() {
        dc.verifyContainsTextFunction(dc.textTechnoStudy, "Techno Study");
    }

    @And("Click on the Document Types")
    public void clickOnTheElementInLeftNav(DataTable items) {
        List<String> strButtons = items.asList(String.class);

        for (String strButton : strButtons) {
            WebElement element = ln.getWebElement(strButton);
            ln.clickFunction(element);
        }
    }

    @When("Admin Add New Document Type name as {string} stage as {int}")
    public void adminAddNewDocumentTypeNameAsStageAsStage(String name, int stage) {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput, name);
        dc.clickFunction(dc.stage);
        dc.clickFunction(dc.stageList.get(stage));
        Actions aksiyonlar = new Actions(GWD.getDriver());
        Action aksiyon = aksiyonlar.sendKeys(Keys.ESCAPE).build();
        aksiyon.perform();
    }

    @And("Click save button")
    public void clickSaveButton() {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", dc.saveButton);
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        js.executeScript("arguments[0].click();", dc.saveButton);
    }

    @Then("Document successfully created message should be displayed")
    public void documentSuccessfullyCreatedMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage, "success");
    }

    @When("Admin Edit Document name as {string} stage as {int}")
    public void adminEditDocumentNameAsStageAs(String name, int stage) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.docInputName);
        dc.sendKeysFunction(dc.docInputName, name);
        dc.clickFunction(dc.docInputStage);
        dc.clickFunction(dc.stageList.get(stage));
    }

    @And("Click Search Button")
    public void clickSearchButton() {
        dc.clickFunction(dc.searchButton);
    }

    @And("Click Edit Button")
    public void clickEditButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.edit);
    }

    @And("Change document name as {string}")
    public void changeDocumentNameAs(String newname) {
        dc.sendKeysFunction(dc.nameInput, newname);
        dc.clickFunction(dc.saveButton);
    }

    @Then("Document successfully updated message should be displayed")
    public void documentSuccessfullyUpdatedMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage, "success");
    }

    @When("Admin Delete Document name as {string} stage as {int}")
    public void adminDeleteDocumentNameAsStageAsStage(String name, int stage) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.docInputName);
        dc.sendKeysFunction(dc.docInputName, name);
        dc.clickFunction(dc.docInputStage);
        dc.clickFunction(dc.stageList.get(stage));
    }

    @And("Click Delete button")
    public void clickDeleteButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.docDeleteButton);
        dc.clickFunction(dc.deleteDialogButton);
    }

    @Then("Document successfully deleted message should be displayed")
    public void documentSuccessfullyDeletedMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage, "success");
    }

    @When("Admin again Delete Document name as {string} stage as {int}")
    public void adminAgainDeleteDocumentNameAsStageAsStage(String name, int stage) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.docInputName);
        dc.sendKeysFunction(dc.docInputName, name);
        dc.clickFunction(dc.docInputStage);
        dc.clickFunction(dc.stageList.get(stage));
    }

    @And("Click Search button on Page")
    public void clickSearchButtonOnPage() {
        dc.clickFunction(dc.searchButton);
    }

    @Then("There is no data to display message should be displayed")
    public void thereIsNoDataToDisplayMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        Assert.assertEquals(dc.searchDelete.getText(), "There is no data to display");
    }
}
