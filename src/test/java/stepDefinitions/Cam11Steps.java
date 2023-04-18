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
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

public class Cam11Steps {
    DialogContent dg = new DialogContent();
    LeftNav ln = new LeftNav();
    String userNAme = "hamdiTosun";
    String iBan = "19283746";

    int randomNumber = (int) (Math.random() * 100000);
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
        dg.sendKeysFunction(dg.nameInput, userNAme);
        dg.sendKeysFunction(dg.shortNameGradeLevel, userNAme);
        dg.sendKeysFunction(dg.orderGradeLevel, "2");


        // TODO Sonraki denemede , Next Grade kismini da daoldur !
    }

    @And("Click Grade Levels save button")
    public void clickGradeLevelsSaveButton() {
        dg.clickFunction(dg.saveButton);
    }

    @Then("Verify that Grade Levels Element is Visible")
    public void verifyThatGradeLevelsElementIsVisible() {
        dg.verifyContainsTextFunction(dg.successText, "successfully");
    }

    @And("Fill Grade Levels  the Blanks with same data")
    public void fillGradeLevelsTheBlanksWithSameData() {
        dg.sendKeysFunction(dg.nameInput, userNAme);
        dg.sendKeysFunction(dg.shortNameGradeLevel, userNAme);
        dg.sendKeysFunction(dg.orderGradeLevel, "2");

    }

    @Then("Verify that Grade Levels error text")
    public void verifyThatGradeLevelsErrorText() {
        dg.verifyContainsTextFunction(dg.alreadyExistText, "exists");
    }

    @And("Click Grade Levels first Delete Button")
    public void clickGradeLevelsFirstDeleteButton() {

        dg.clickFunction(dg.hamdiTosunDeleteButton);
        dg.clickFunction(dg.deleteConfirmButton);
    }

    @And("Verify Grade Levels Delete")
    public void verifyGradeLevelsDelete() {
        dg.verifyContainsTextFunction(dg.successMessage, "success");
    }

    @And("Re-enter a deleted data and try to delete First Delete Element")
    public void reEnterADeletedDataAndTryToDeleteFirstDeleteElement() {

        boolean varMI = false;
        for (WebElement a : dg.gradeLevelsIsimler) {
            if(a.getText().equals("hamdiTosun")){
                varMI=true;
            }
        }
        Assert.assertFalse(varMI);

    }

    @Then("Verify that the first delete key is not visible")
    public void verifyThatTheFirstDeleteKeyIsNotVisible() {
    }

    @And("Click Edit Button")
    public void clickEditButton() {
        dg.clickFunction(dg.hamdiTosunEditButton);
    }

    @And("Fill the Blanks and save")
    public void fillTheBlanksAndSave() {
        dg.sendKeysFunction(dg.orderGradeLevel,"3");
        dg.clickFunction(dg.saveButton);
    }

    @And("Verify that Editable Element is Visible")
    public void verifyThatEditableElementIsVisible() {
        dg.verifyContainsTextFunction(dg.successMessage,"successfully");
    }
}
