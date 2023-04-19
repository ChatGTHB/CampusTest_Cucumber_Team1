package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DialogContent;
import utilities.GWD;

import java.time.Duration;
import java.util.List;

public class Cam12Steps {
    DialogContent dc = new DialogContent();
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

    @Then("User delete input from Dialog Content")
    public void userDeleteInputFromDialogContent(DataTable dt) {
        List<String> strButtons = dt.asList(String.class);

        for (String strDeleteText : strButtons) {
            dc.deleteInput(strDeleteText);
        }
    }

    @And("User editing Discount Data")
    public void userEditingDiscountData() {
        dc.clickFunction(dc.getWebElement("searchButton"));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.getWebElement("editButton"));
        dc.sendKeysFunction(dc.getWebElement("description"), "Cam99");
        dc.sendKeysFunction(dc.getWebElement("discountsIntegrationCode"), "44");
        dc.sendKeysFunction(dc.getWebElement("priorityCode"), "54");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        dc.clickFunction(dc.getWebElement("toggleBar"));
        dc.clickFunction(dc.saveButton);

    }


}
