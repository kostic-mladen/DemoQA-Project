package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {

    public TextBoxPage(WebDriver driver) {


        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".border.col-md-12.col-sm-12")
    public WebElement outputBox;

    @FindBy(id = "name")
    public WebElement outputName;

    @FindBy(css = ".mr-sm-2.field-error.form-control")
    public WebElement errorEmailForm;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressText;

    @FindBy(id = "output")
    public WebElement outPutMessage;

    public void insertFullName(String fullname){
        fullNameField.sendKeys(fullname);
    }
    public void insertEmail(String email){
        emailField.sendKeys(email);
    }
    public void insertCurrentAddress(String currentAddress){
        currentAddressField.sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress){
       permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void insertNumericFullName(int fullName){
        fullNameField.sendKeys(String.valueOf(fullName));
    }

}


