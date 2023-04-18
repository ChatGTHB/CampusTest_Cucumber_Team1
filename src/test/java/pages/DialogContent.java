package pages;

import utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
    @FindBy(xpath = "(//ms-edit-button)[1]")
    private WebElement editButton;
    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement noDataMessage;
    @FindBy(xpath="//div[@id='mat-select-value-5']")
    public WebElement locationType;
    @FindBy(xpath="(//button[@mattooltipposition='above'])[2]")
    public WebElement edit;
    @FindBy(xpath="//ms-integer-field[@placeholder='GENERAL.FIELD.CAPACITY']/../../../..")
    public WebElement capacity2;
    @FindBy(xpath = "//*[contains(text(),'already')]")
    public WebElement already;
    @FindBy(xpath="//button[@aria-label='Close dialog']")
    public WebElement close;
    @FindBy(xpath = "//tbody//td[text()='Erzurumlu']")
    public WebElement deletedElement;
    @FindBy(xpath = " //tbody//td[text()='Oltu']")
    public WebElement deletedElement2;
    @FindBy(xpath = "//input[@data-placeholder='IBAN']")
    public WebElement ibanInput;
    @FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c76-76']")
    public WebElement currencyInput;
    @FindBy(xpath = "//*[text()='Bank Account successfully created']")
    public WebElement bankAccountSuccessfulText;
    @FindBy(xpath = "//span[text()=' EUR ']")
    public WebElement EURInput;
    @FindBy(xpath = "//input[@data-placeholder='Integration Code']")
    public WebElement IntegrationCodeInput;
    @FindBy(xpath = "//*[contains(text(), 'already exists.')]")
    public WebElement alreadyExistText;
    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button mat-button-base mat-warn ng-star-inserted']")
    public WebElement BankAccountsdeleteButton;
    @FindBy(xpath = "//span[text()=' Delete ']")
    public WebElement deleteConfirmButton;
    @FindBy(xpath = "//*[contains(text(), 'successfully deleted')]")
    public WebElement bankAccountDeletedText;
    @FindBy(xpath = "//input[@data-placeholder='Name']")
    public WebElement searchNameInput;
    @FindBy(xpath = "//*[text()=' There is no data to display ']")
    public WebElement noDataToDisplayText;
    @FindBy(xpath = "(//button[@color='accent'])[2]")
    public WebElement firstEditButton;
    @FindBy(xpath = "//*[contains(text(), 'successfully')]")
    public WebElement successText;

    @FindBy(xpath = "//div[@class='mat-select-value ng-tns-c76-73']")
    public WebElement fieldType;





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
            case "searchInput" : return searchInput;
            case "shortName" : return shortName;
            case "username" : return username;
            case "password" : return password;
            case "gradeLevel2" : return gradeLevel2;
            case "editButton" : return editButton;
            case "successMessage" : return successMessage;
            case "noDataMessage" : return noDataMessage;
            case "searchButton" : return searchButton;
            case "fieldType" : return fieldType;

        }
        return null;
    }
    public void deleteItem(String searchedText) {
        sendKeysFunction(searchInput, searchedText);
        clickFunction(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        clickFunction(deleteImageButton);
        clickFunction(deleteDialogButton);
    }

    public void editItem(String searchedText,String newText) {
        sendKeysFunction(searchInput, searchedText);
        clickFunction(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));
        clickFunction(editButton);
        sendKeysFunction(nameInput, newText);
        clickFunction(saveButton);
    }

    public void FoundElement(WebElement element){
        try {
            element.click();
        }catch (Exception e){
            System.out.println("Bug: Element not found ");
        }
    }

}
