package DemoQASite.Test.BookStoreTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.BookStorePages.BookStorePage;
import DemoQASite.Page.BookStorePages.LoginPage;
import DemoQASite.Page.BookStorePages.ProfilePage;
import DemoQASite.Page.BookStorePages.RegisterPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*public class RegisterTest extends BaseTest {

    @BeforeMethod
    public void loginRegisterSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        /*driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(registerUrl);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        bookStorePage = new BookStorePage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);

    }

    @Test (priority = 10)
    public void verifyThatUserCanMakeNewAccount() throws InterruptedException {
        registerPage.firstNameField.sendKeys("Mladen");
        registerPage.lastNameField.sendKeys("Kostic");
        registerPage.usernameField.sendKeys("tester007");
        registerPage.passwordFieldd.sendKeys("Testing1@");
        scrollToElement(registerPage.recaptcha);
        registerPage.recaptcha.click();
        Thread.sleep(5000);
        registerPage.registerButton.click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test (priority = 20)
    public void verifyThatCreatedUserCanLogIn() throws InterruptedException {
        scrollToElement(registerPage.goToLoginPage);
        registerPage.goToLoginPage.click();
        loginPage.insertUsername("tester007");
        loginPage.insertPassword("Testing111@");
        loginPage.logInButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(isDisplayed(profilePage.listOfButtons.get(0)));
        Assert.assertFalse(isDisplayed(loginPage.logInButton));
    }
    @Test (priority = 30)
    public void verifyThatCreatedUserCanBeDeleted() throws InterruptedException {
        scrollToElement(registerPage.goToLoginPage);
        registerPage.goToLoginPage.click();
        loginPage.insertUsername("tester007");
        loginPage.insertPassword("Testing111@");
        loginPage.logInButton.click();
        Thread.sleep(5000);
        scrollToElement(profilePage.listOfButtons.get(1));
        profilePage.listOfButtons.get(1).click();
        profilePage.okButton.click();
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeRegisterPageDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
*/