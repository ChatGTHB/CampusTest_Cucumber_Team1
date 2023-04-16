package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import utilities.GWD;

import java.time.Duration;
import java.util.List;

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
     //   Thread.sleep(3000);
        dc.clickFunction(dc.saveButton);
        dc.verifyContainsTextFunction(dc.successMessage,"success");

    }


    @And("click Delete button")
    public void clickDeleteButton() {
        dc.clickFunction(dc.deleteImageButton);
        dc.clickFunction(dc.deleteDialogButton);
        dc.verifyContainsTextFunction(dc.successMessage,"success");
    }


//    @Then("departments name should not be displayed")
//    public void departmentsNameShouldNotBeDisplayed() {
////        System.out.println(dc.nameList.size());
////        for (WebElement e : dc.nameList) {
////            if (e.getText().contains("Oltu")) {
////                System.out.println("test basarisiz");
////                Assert.assertFalse(e.getText().contains("Erzurumlu"));
////            }
////
////        }
//
//
//        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
////        wait.until(ExpectedConditions.elementToBeClickable(dc.locationType));
////        System.out.println(dc.nameList.size());
////
////
////      //  wait.until(ExpectedConditions.visibilityOfAllElements(dc.nameList));
////        Thread.sleep(3000);
////
//        boolean varMi=false;
//        for (int i = 0; i <dc.nameList.size() ; i++) {
//            wait.until(ExpectedConditions.visibilityOf(dc.nameList.get(i)));
//            System.out.println(dc.nameList.get(i).getText());
//            if (dc.nameList.get(i).getText().equals("Oltu")){
//                varMi=true;
//            }
//            Assert.assertFalse(varMi);
//        }
//    }

    @Then("Element should not displayed")
    public void elementShouldNotDisplayed() {
        dc.FoundElement(dc.deletedElement2);
    }
}
