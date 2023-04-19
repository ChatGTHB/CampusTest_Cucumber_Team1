package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;

public class Cam07Steps {

    DialogContent dc=new DialogContent();
    LeftNav ln=new LeftNav();


    @And("Navigate to Subject Categories page")
    public void navigateToSubjectCategoriesPage() {

        ln.clickFunction(ln.education);
        ln.clickFunction(ln.Setup);
        ln.clickFunction(ln.SubjectCategories);

    }
    @When("Admin add an Subject Categories")
    public void AdminAddAnSubjectCategories() {

        dc.clickFunction(dc.addButton);
        dc.sendKeysFunction(dc.nameInput, "deneme7");
        dc.sendKeysFunction(dc.codeInput, "107");
        dc.clickFunction(dc.saveButton);
    }

    @Then("Subject Categories should be displayed")
    public void SubjectCategoriesShouldBeDisplayed(){

        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"),"success");

    }

    @When("Admin search a Subject Categories")
    public void AdminSearchASubjectCategories(){

        dc.sendKeysFunction(dc.SearchNameInput, "deneme7");
        dc.sendKeysFunction(dc.SearchCodeInput, "107");
        dc.clickFunction(dc.searchButton);

    }
    @Then("Subject Categories should be listed")
    public void SubjectCategoriesShouldBeListed() {

        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"), "success");
    }



    @When("Admin edit an Subject Categories")
    public void AdminEditAnSubjectCategories() {

        dc.editItem("deneme7", "yeni15");
    }

    @Then("Subject Categories successfully updated message is displayed")
    public void SubjectCategoriesSuccessfullyUpdatedMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("success"),"success");
    }

    @When("Admin delete an Subject Categories")
    public void AdminDeleteAnSubjectCategories() {

        dc.deleteSubjectCategoriesItem("yeni15", "107");

    }
    @Then("Subject Categories successfully deleted message is displayed")
    public void SubjectCategoriesSuccessfullyDeletedMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.getWebElement("successMessage"),"success");
    }

    @Then("Subject Categories already exists message is displayed")
    public void SubjectCategoriesAlreadyExistsMessageIsDisplayed() {
        dc.verifyContainsTextFunction(dc.alreadyExist,"already exist");
    }
    @Then("There is no data to show message is displayed")
    public void thereIsNoDataToShowMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*") , 0));
        dc.verifyContainsTextFunction(dc.noDataMessage,"data");
    }

    @And("Enter the Subject Categories will be delete")
    public void enterTheSubjectCategoriesWillBeDelete() {

        dc.sendKeysFunction(dc.getWebElement("searchInput"),"yeni15");
    }

    @And("Clicks on search button")
    public void clicksOnSearchButton() {
        dc.clickFunction(dc.getWebElement("searchButton"));

    }
}

