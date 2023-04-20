package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;

public class Cam10Steps {

    LeftNav ln = new LeftNav();
    DialogContent dg = new DialogContent();

    String userNAme = "Hamdi1";
    String iBan = "19283746";

    int randomNumber = (int) (Math.random() * 100000);
    String rndmNumber = String.valueOf(randomNumber);

    @When("Click Setup button Parameters Button and Bank Accounts Button")
    public void clickSetupButtonParametersButtonAndBankAccountsButton() {
        ln.clickFunction(ln.setup);
        ln.clickFunction(ln.parameters);
        ln.clickFunction(ln.bankAccounts);
    }

    @And("Click Bank Accounts Add Button")
    public void clickBankAccountsAddButton() {
        dg.clickFunction(dg.addButton);
    }

    @And("Fill the Bank Accounts Blanks")
    public void fillTheBankAccountsBlanks() {
        dg.sendKeysFunction(dg.nameInput, userNAme);
        dg.sendKeysFunction(dg.ibanInput, iBan);
        dg.clickFunction(dg.currencyInput);
        dg.clickFunction(dg.EURInput);
        dg.sendKeysFunction(dg.IntegrationCodeInput, "52393");
    }

    @And("Click Bank Accounts save button")
    public void clickBankAccountsSaveButton() {
        dg.clickFunction(dg.saveButton);
    }

    @Then("Verify that Element is Visible")
    public void verifyThatElementIsVisible() {
        dg.verifyContainsTextFunction(dg.bankAccountSuccessfulText, "successfully");
    }

    @And("Fill the Add Blanks with same Data")
    public void fillTheAddBlanksWithSameData() {
        dg.sendKeysFunction(dg.nameInput, userNAme);
        dg.sendKeysFunction(dg.ibanInput, iBan);
        dg.clickFunction(dg.currencyInput);
        dg.clickFunction(dg.EURInput);
        dg.sendKeysFunction(dg.IntegrationCodeInput, "52393");
    }

    @Then("Verify Bank Accounts error")
    public void verifyBankAccountsError() {
        dg.verifyContainsTextFunction(dg.alreadyExist, "already exists");
    }

    @And("Click Bank Accounts DeleteButton")
    public void clickBankAccountsDeleteButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(20));
        dg.sendKeysFunction(dg.searchNameInput, userNAme);
        dg.clickFunction(dg.searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dg.clickFunction(dg.BankAccountsdeleteButton);
        dg.clickFunction(dg.deleteConfirmButton);
    }

    @Then("Verify Bank Accounts delete text")
    public void verifyBankAccountsDeleteText() {
        dg.verifyContainsTextFunction(dg.bankAccountDeletedText, "successfully deleted");
    }

    @And("Re-enter a deleted Bank Accounts data and try to delete it")
    public void reEnterADeletedBankAccountsDataAndTryToDeleteIt() {
        dg.sendKeysFunction(dg.searchNameInput, userNAme);
        dg.clickFunction(dg.searchButton);
    }

    @Then("Verify that the delete key is not visible")
    public void verifyThatTheDeleteKeyIsNotVisible() {
        dg.verifyContainsTextFunction(dg.noDataToDisplayText, "no data");
    }

    @And("Click Bank Accounts Edit Button")
    public void clickBankAccountsEditButton() {
        dg.clickFunction(dg.firstEditButton);
    }

    @And("Fill the Edit Blanks and save")
    public void fillTheEditBlanksAndSave() {
        dg.sendKeysFunction(dg.ibanInput, rndmNumber);
        dg.clickFunction(dg.saveButton);
    }

    @Then("Verify that Edit Element is Visible")
    public void verifyThatEditElementIsVisible() {
        dg.verifyContainsTextFunction(dg.successText, "successfully");
    }
}
