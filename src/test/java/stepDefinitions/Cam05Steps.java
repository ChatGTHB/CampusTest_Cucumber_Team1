package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;

public class Cam05Steps {

    LeftNav ln = new LeftNav();

    DialogContent dc = new DialogContent();

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(5));

    @And("Add name, code and field type")
    public void addNameCodeAndFieldType() {
        dc.sendKeysFunction(dc.nameInput, "diyarbekir");
        dc.sendKeysFunction(dc.codeInput, "99");

        Actions actions = new Actions(GWD.getDriver());
        Action action = actions.click(dc.fieldType)
                .sendKeys(Keys.ENTER)
                .build();
        action.perform();
    }

    @Then("Success message should be displayed on the screen")
    public void successMessageShouldBeDisplayedOnTheScreen() {
        dc.verifyContainsTextFunction(dc.successMessage, "success");
    }

    @Then("Already exist message should be displayed on the screen")
    public void alreadyExistMessageShouldBeDisplayedOnTheScreen() {
        dc.verifyContainsTextFunction(dc.alreadyExist, "already");
    }

    @When("Enter the name of the fields you added in test case one in the name field to edit")
    public void enterTheNameOfTheFieldsYouAddedInTestCaseOneInTheNameFieldToEdit() {
        dc.editItem("diyarbekir", "diyarbekirYoluna");
    }

    @When("Enter the name of the fields you edited in test case three in the name field and press the search button and push delete button")
    public void enterTheNameOfTheFieldsYouEditedInTestCaseThreeInTheNameFieldAndPressTheSearchButtonAndPushDeleteButton() {
        dc.deleteItem("diyarbekirYoluna");
    }

    @When("Enter the name of the fields you edited in test case three in the name field")
    public void enterTheNameOfTheFieldsYouEditedInTestCaseThreeInTheNameField() {
        dc.sendKeysFunction(dc.searchNameInput, "diyarbekirYoluna");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));

    }

    @Then("There is no data to display message is displayed on the screen")
    public void thereIsNoDataToDisplayMessageIsDisplayedOnTheScreen() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.verifyContainsTextFunction(dc.getWebElement("noDataMessage"), "no data");
    }
}
