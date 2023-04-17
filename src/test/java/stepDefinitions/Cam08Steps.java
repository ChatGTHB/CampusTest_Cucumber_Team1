package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;

public class Cam08Steps {
    DialogContent dc = new DialogContent();
    LeftNav ln=new LeftNav();
    @And("Navigate to  setup page")
    public void navigateToSetupPage() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.schoolSetup);
    }

    @When("click to  school location")
    public void clickToSchoolLocation() {
        ln.clickFunction(ln.locations);
    }

    @And("click to Add button and save button")
    public void clickToAddButtonAndSaveButton() {
        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput,"Erzurum");
        dc.sendKeysFunction(dc.shortName,"25");
        Actions aksiyonlar = new Actions(GWD.getDriver());
        Action aksiyon = aksiyonlar.click(dc.locationType).
                sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).
                sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).
                sendKeys(Keys.ENTER).
                build();
        aksiyon.perform();

        aksiyon = aksiyonlar.click(dc.capacity2).
                sendKeys("10").
                sendKeys(Keys.ENTER).
                build();
        aksiyon.perform();


        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", dc.saveButton);
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        js.executeScript("arguments[0].click();", dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.clickFunction(dc.close);
        dc.verifyContainsTextFunction(dc.alreadyExist,"already");
    }

    @And("click to Edit button and save button")
    public void clickToEditButtonAndSaveButton() {
        dc.clickFunction(dc.edit);
        dc.sendKeysFunction(dc.nameInput,"Erzurumlu");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);", dc.saveButton);
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        js.executeScript("arguments[0].click();", dc.saveButton);

        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @And("click to Delete button")
    public void clickToDeleteButton() {
        dc.clickFunction(dc.deleteImageButton);
        dc.clickFunction(dc.deleteDialogButton);
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }

    @Then("Element should not be displayed")
    public void elementShouldNotBeDisplayed() {
           dc.FoundElement(dc.deletedElement);
    }
}
