package DemoQASite.Test.BookStoreTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.BookStorePages.BookStorePage;
import DemoQASite.Page.BookStorePages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookStorePageTest extends BaseTest {

    @BeforeMethod
    public void bookPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(bookStoreUrl);
        loginPage = new LoginPage(driver);
        bookStorePage = new BookStorePage(driver);

    }

    @Test(priority = 10)
    public void goToBookStorePage(){
        Assert.assertTrue(isDisplayed(bookStorePage.titleBookStore));
        Assert.assertTrue(isDisplayed(bookStorePage.loginButton));
        Assert.assertNotEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test(priority = 20)
    public void verifyThatLoginButtonIsPresent(){
        Assert.assertTrue(isDisplayed(bookStorePage.loginButton));
        Assert.assertFalse(isDisplayed(loginPage.usernameField));
    }

    @Test(priority = 30)
    public void verifyLoginButtonOnBookStorePageIsClickable(){
        bookStorePage.loginButton.click();
        String expectedText = "Login";
        Assert.assertEquals(loginPage.titleLogin.getText(), expectedText);
        Assert.assertTrue(isDisplayed(loginPage.usernameField));
        Assert.assertTrue(isDisplayed(loginPage.passwordField));
    }

    @Test(priority = 40)
    public void verifyThatSearchBoxIsPresent(){
        Assert.assertTrue(isDisplayed(bookStorePage.searchBox));
        Assert.assertEquals(driver.getCurrentUrl(), bookStoreUrl);

    }
    @Test(priority = 50)
    public void verifyThatMagnifierIsPresent(){
        Assert.assertTrue(isDisplayed(bookStorePage.magnifier));
        Assert.assertEquals(driver.getCurrentUrl(), bookStoreUrl);
    }

    @Test(priority = 60)
    public void verifyThatUserCanInsertNameOfABookInSearchBox(){
        bookStorePage.searchBox.sendKeys("Git Pocket Guide");
        Assert.assertFalse(isDisplayed(bookStorePage.learningJava));
    }

    @Test(priority = 70)
    public void verifyAllBooksOnBooksStorePage(){
        bookStorePage.allBooksOnBookStorePage();
    }

    @Test(priority = 80)
    public void verifyThatBookStoreAPIButtonIsClickable(){
        scrollToElement(bookStorePage.bookStoreAPIButton);
        bookStorePage.clickOnBookStoriAPIButton();
        String expectedUrl = "https://demoqa.com/swagger/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @AfterMethod
    public void closeBookPageDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
