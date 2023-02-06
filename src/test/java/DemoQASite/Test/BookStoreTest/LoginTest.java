package DemoQASite.Test.BookStoreTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.BookStorePages.BookStorePage;
import DemoQASite.Page.BookStorePages.LoginPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @BeforeMethod
    public void loginPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(loginUrl);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        bookStorePage = new BookStorePage(driver);


    }

    public void login() throws InterruptedException {
        waitForVisibility(loginPage.usernameField);
        scrollToElement(loginPage.usernameField);
        String validUsername = excelReader.getStringData("Login", 1, 0);
        loginPage.insertUsername(validUsername);
        waitForVisibility(loginPage.passwordField);
        scrollToElement(loginPage.passwordField);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.insertPassword(validPassword);
        waitForVisibility(loginPage.logInButton);
        loginPage.logInButton.click();
        Thread.sleep(5000);

    }

    @Test(priority = 10)
    public void verifyThatUserCanLogin() throws InterruptedException {
        login();
        Assert.assertEquals(driver.getCurrentUrl(), profileUrl);
        Assert.assertTrue(isDisplayed(loginPage.buttons.get(0)));
        Assert.assertEquals(loginPage.titleLogin.getText(), "Profile");
    }

    @Test(priority = 20)
    public void verifyThatUserCanLogOut() throws InterruptedException {
        login();
        loginPage.buttons.get(0).click();
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
    }

    @Test(priority = 30)
    public void verifyThatUserCanNotLoginWithInvalidUsername() {
        for (int i = 1; i <= excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            loginPage.insertUsername(invalidUsername);
            loginPage.insertPassword(validPassword);
            scrollToElement(loginPage.logInButton);
            loginPage.clickOnLoginButton();
            waitForVisibility(loginPage.usernameField);
            Assert.assertTrue(isDisplayed(loginPage.usernameField));
            Assert.assertTrue(isDisplayed(loginPage.passwordField));
            String expectedText = "Invalid username or password!";
            Assert.assertEquals(loginPage.errorMessage.getText(), expectedText);
        }
    }

    @Test(priority = 40)
    public void verifyThatUserCanNotLoginWithInvalidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            loginPage.insertUsername(validUsername);
            loginPage.insertPassword(invalidPassword);
            scrollToElement(loginPage.logInButton);
            loginPage.clickOnLoginButton();
            waitForVisibility(loginPage.usernameField);
            Assert.assertTrue(isDisplayed(loginPage.usernameField));
            Assert.assertTrue(isDisplayed(loginPage.passwordField));
            String expectedText = "Invalid username or password!";
            Assert.assertEquals(loginPage.errorMessage.getText(), expectedText);
        }
    }

    @Test(priority = 50)
    public void verifyThatUserCanNotLoginWithEmptyUsernameInput() {
        loginPage.usernameField.sendKeys(Keys.NULL);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.insertPassword(validPassword);
        scrollToElement(loginPage.logInButton);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.usernameField);
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
        Assert.assertTrue(isDisplayed(loginPage.emptyUsername));
    }
    @Test(priority = 60)
    public void verifyThatUserCanNotLoginWithEmptyPasswordInput() {
        String validUsername = excelReader.getStringData("Login", 1, 1);
        loginPage.insertPassword(validUsername);
        loginPage.passwordField.sendKeys(Keys.NULL);
        scrollToElement(loginPage.logInButton);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.usernameField);
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
        Assert.assertTrue(isDisplayed(loginPage.emptyPassword));
    }
    @Test(priority = 70)
    public void verifyThatUserCanNotLoginWithEmptyInputs() {
        loginPage.usernameField.sendKeys(Keys.NULL);
        loginPage.passwordField.sendKeys(Keys.NULL);
        scrollToElement(loginPage.logInButton);
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.usernameField);
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
        Assert.assertTrue(isDisplayed(loginPage.emptyUsername));
        Assert.assertTrue(isDisplayed(loginPage.emptyPassword));
    }



    @AfterMethod
    public void closeLoginPageDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
