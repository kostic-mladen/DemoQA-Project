package DemoQASite.Page.BookStorePages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement titleProfile;

    @FindBy(id = "submit")
    public List<WebElement> listOfButtons;

    @FindBy(id = "closeSmallModal-ok")
    public WebElement okButton;

    @FindBy(linkText = "login")
    public WebElement login;

    @FindBy(linkText = "register")
    public WebElement register;

    @FindBy(xpath = "//label[@id='notLoggin-label']")
    public WebElement textOnProfilePage;

    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoProfilePage;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerProfilePage;

    public void clickLogin(){
        login.click();
    }

    public void clickRegister(){
        register.click();
    }
}
