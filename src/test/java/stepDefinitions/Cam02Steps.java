package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import pages.LeftNav;

public class Cam02Steps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @When("User clicks on humanResources")
    public void userClicksOnHumanResources() {
        ln.clickFunction(ln.getWebElement("humanResources"));
    }

    @And("Selects setup")
    public void selectsSetup() {
        ln.clickFunction(ln.getWebElement("setupHumanResources"));
    }

    @And("Clicks on position categories")
    public void clicksOnPositionCategories() {
        ln.clickFunction(ln.getWebElement("positionCategories"));
    }

    @And("Clicks on add position categories")
    public void clicksOnAddPositionCategories() {
        dc.clickFunction(dc.getWebElement("addButton"));
    }

    @And("Enters position category")
    public void entersPositionCategory() {
        dc.sendKeysFunction(dc.getWebElement("nameInput"), "Scrum Master");
    }

    @And("Clicks on save button")
    public void clicksOnSaveButton() {
        dc.clickFunction(dc.getWebElement("saveButton"));
    }

    @Then("Position Category successfully created message is displayed")
    public void positionCategorySuccessfullyCreatedMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"), "success");
    }

    @Then("The Position Category already exists message is displayed")
    public void thePositionCategoryAlreadyExistsMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.alreadyExist, "already exist");
    }

    @And("Edit the position category")
    public void editThePositionCategory() {
        dc.editItem("Scrum Master", "Business Analyst");
    }

    @Then("Position Category successfully updated message is displayed")
    public void positionCategorySuccessfullyUpdatedMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"), "success");
    }

    @And("Delete the position category")
    public void deleteThePositionCategory() {
        dc.deleteItem("Business Analyst");
    }

    @Then("Position Category successfully deleted message is displayed")
    public void positionCategorySuccessfullyDeletedMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"), "success");
    }

    @And("Enter the category position will be delete")
    public void enterTheCategoryPositionWillBeDelete() {
        dc.sendKeysFunction(dc.getWebElement("searchInput"), "Business Analyst");
    }

    @And("Clicks on search button at position categories")
    public void clicksOnSearchButtonAtPositionCategories() {
        dc.clickFunction(dc.getWebElement("searchButton"));
    }

    @Then("There is no data to display message is displayed")
    public void thereIsNoDataToDisplayMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("noDataMessage"), "no data");
    }
}
