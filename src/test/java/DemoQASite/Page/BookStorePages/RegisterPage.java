package DemoQASite.Page.BookStorePages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseTest {

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement titleRegister;

    @FindBy(xpath = "//h4[contains(text(),'Register to Book Store')]")
    public WebElement headerRegisterTo;

    @FindBy(id = "firstname")
    public WebElement firstNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordFieldd;

    @FindBy(id = "register")
    public WebElement registerButton;

    @FindBy(id = "gotologin")
    public WebElement goToLoginPage;

    @FindBy(xpath = "//div[@id='g-recaptcha']")
    public WebElement recaptcha;

}