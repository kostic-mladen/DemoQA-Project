package DemoQASite.Page.BookStorePages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BaseTest {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement titleLogin;

    @FindBy(id = "userName")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login")
    public WebElement logInButton;

    @FindBy(id = "submit")
    public List<WebElement> buttons;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(id = "name")
    public WebElement errorMessage;

    @FindBy(css = ".mr-sm-2.is-invalid.form-control")
    public WebElement emptyUsername;

    @FindBy(css = ".mr-sm-2.is-invalid.form-control")
    public WebElement emptyPassword;

    public void insertUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickOnNewUserButton(){
        newUserButton.click();
    }

    public void clickOnLoginButton(){
        logInButton.click();
    }

}
