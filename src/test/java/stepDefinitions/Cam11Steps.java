package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

public class Cam11Steps {
    DialogContent dg = new DialogContent();
    LeftNav ln = new LeftNav();
    String userNAme= "hamdiTosun";
    String iBan = "19283746";

    int randomNumber = (int)(Math.random()*100000);
    String rndmNumber = String.valueOf(randomNumber);
    @When("Click Setup button Parameters Button and Grade Levels Button")
    public void clickSetupButtonParametersButtonAndGradeLevelsButton() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.parameters);
        ln.clickFunction(ln.gradeLevels);
    }

    @And("Click Grade Levels Add Button")
    public void clickGradeLevelsAddButton() {
        dg.clickFunction(dg.addButton);
    }

    @And("Fill Grade Levels the Blanks")
    public void fillGradeLevelsTheBlanks() {
        dg.sendKeysFunction(dg.nameInput,userNAme);
        dg.sendKeysFunction(dg.shortNameGradeLevel,userNAme);
        dg.sendKeysFunction(dg.orderGradeLevel,"2");



 // TODO Sonraki denemede , Next Grade kismini da daoldur !
    }

    @And("Click Grade Levels save button")
    public void clickGradeLevelsSaveButton() {
        dg.clickFunction(dg.saveButton);
    }

    @Then("Verify that Grade Levels Element is Visible")
    public void verifyThatGradeLevelsElementIsVisible() {
        dg.verifyContainsTextFunction(dg.successText,"successfully");
    }

    @And("Fill Grade Levels  the Blanks with same data")
    public void fillGradeLevelsTheBlanksWithSameData() {
        dg.sendKeysFunction(dg.nameInput,userNAme);
        dg.sendKeysFunction(dg.shortNameGradeLevel,userNAme);
        dg.sendKeysFunction(dg.orderGradeLevel,"2");

    }

    @Then("Verify that Grade Levels error text")
    public void verifyThatGradeLevelsErrorText() {
        dg.verifyContainsTextFunction(dg.alreadyExistText,"exists");
    }

    @And("Click Grade Levels first Delete Button")
    public void clickGradeLevelsFirstDeleteButton() {

        dg.clickFunction(dg.BankAccountsdeleteButton);
        dg.clickFunction(dg.deleteConfirmButton);


        WebElement hamdiTosunDeleteButton = GWD.getDriver().findElement(By.xpath("//td[text()='hamdiTosun']//following::td[5]//div//ms-delete-button"));
        WebElement hamdiTosunDeleteButton2 = GWD.getDriver().findElement(By.xpath("//td[text()='hamdiTosun']//following::td[5]//div//ms-delete-button//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button mat-button-base mat-warn ng-star-inserted']"));

      //  dg.clickFunction(hamdiTosunDeleteButton2);
        // dg.clickFunction(dg.BankAccountsdeleteButton);
         // dg.clickFunction(dg.deleteConfirmButton);
        //td[text()='hamdiTosun']//following::td[5]//div//ms-delete-button//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button mat-button-base mat-warn ng-star-inserted']


    }

    @And("Verify Grade Levels Delete")
    public void verifyGradeLevelsDelete() {
        dg.verifyContainsTextFunction(dg.successMessage, "success");
    }

    @And("Re-enter a deleted data and try to delete First Delete Element")
    public void reEnterADeletedDataAndTryToDeleteFirstDeleteElement() {




      //  Actions actions = new Actions(GWD.getDriver());
      //  actions.keyDown(Keys.CONTROL).sendKeys("f").keyUp(Keys.CONTROL).build().perform();

    }

    @Then("Verify that the first delete key is not visible")
    public void verifyThatTheFirstDeleteKeyIsNotVisible() {
    }

    @And("Click Grade Levels first element  Edit Button")
    public void clickGradeLevelsFirstElementEditButton() {
    }

    @And("Fill the Grade Levels Blanks and save")
    public void fillTheGradeLevelsBlanksAndSave() {
    }

    @Then("Verify that Grade Levels edited Element  is Visible")
    public void verifyThatGradeLevelsEditedElementIsVisible() {
    }


    @When("denemeKlaroru")
    public void denemeklaroru() {

        dg.clickFunction(dg.addButton);
        for (WebElement a: dg.gradeLevelsIsimler) {
            System.out.println(a.getText());

        }


    }
}
