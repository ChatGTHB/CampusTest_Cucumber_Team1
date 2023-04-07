package pages;

import utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

// POM : Page Object Model
public class DialogContent extends Parent {
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;
    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;
    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    public WebElement textTechnoStudy;
    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    public WebElement addButton;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    public WebElement codeInput;
    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']/input")
    public WebElement shortName;
    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath="//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchInput;
    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;
    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    public WebElement deleteImageButton;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteDialogButton;
    @FindBy(xpath = "//input[@id='ms-text-field-5']")
    private WebElement integrationCode;
    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;
    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleBar;
    @FindBy(xpath="//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;
    @FindBy(xpath="(//mat-option/span)[1]")
    private WebElement academicPeriod1;
    @FindBy(xpath="(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;
    @FindBy(xpath="(//mat-option//span)[2]")
    private WebElement gradeLevel2;

    public WebElement getWebElement(String strButton){

        switch (strButton)
        {
            case "addButton" : return addButton;
            case "saveButton" : return saveButton;
            case "nameInput" : return nameInput;
            case "codeInput" : return codeInput;
            case "integrationCode" : return integrationCode;
            case "priorityCode" : return priorityCode;
            case "toggleBar" : return toggleBar;
            case "academicPeriod" : return academicPeriod;
            case "academicPeriod1" : return academicPeriod1;
            case "gradeLevel" : return gradeLevel;
            case "gradeLevel2" : return gradeLevel2;
        }
        return null;
    }


    public void deleteItem(String searchedText) {
        sendKeysFunction(searchInput, searchedText);
        clickFunction(searchButton);
        // wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        clickFunction(deleteImageButton);
        clickFunction(deleteDialogButton);
    }
}
