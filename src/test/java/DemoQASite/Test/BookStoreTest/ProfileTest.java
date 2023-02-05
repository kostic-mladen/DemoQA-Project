package DemoQASite.Test.BookStoreTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.BookStorePages.BookStorePage;
import DemoQASite.Page.BookStorePages.LoginPage;
import DemoQASite.Page.BookStorePages.ProfilePage;
import DemoQASite.Page.BookStorePages.RegisterPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends BaseTest {

    @BeforeMethod
    public void loginProfileSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(profileUrl);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        bookStorePage = new BookStorePage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
    }


    @Test(priority = 10)
    public void verifyThatLoginLinkOnProfilePageIsClickable() {
        profilePage.clickLogin();
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
    }

    @Test(priority = 20)
    public void verifyThatRegisterLinkOnProfilePageIsClickable() {
        profilePage.clickRegister();
        Assert.assertTrue(isDisplayed(registerPage.firstNameField));
        Assert.assertTrue(isDisplayed(registerPage.lastNameField));
    }

    @Test(priority = 30)
    public void verifyTextOnProfilePage() {
        String expectedText = "Currently you are not logged into the Book Store application, " +
                "please visit the login page to enter or register page to register yourself.";
        Assert.assertEquals(profilePage.textOnProfilePage.getText(), expectedText);
    }

    @Test(priority = 40)
    public void verifyThatLogoOnProfilePageIsVisible() {
        Assert.assertTrue(isDisplayed(profilePage.logoProfilePage));
        Assert.assertEquals(driver.getCurrentUrl(), profileUrl);
    }

    @Test(priority = 50)
    public void verifyThatFooterOnProfilePageIsPresent() {
        String expectedText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(profilePage.footerProfilePage.getText(), expectedText);
    }

    @AfterMethod
    public void closeProfilePageDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
