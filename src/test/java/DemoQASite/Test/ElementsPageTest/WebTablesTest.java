package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.BrokenImagePage;
import DemoQASite.Page.ElemnetsPages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTablesTest extends BaseTest {


    @BeforeMethod
    public void brokenImagePageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(webTablesUrl);
        webTablesPage = new WebTablesPage(driver);
    }

    @Test(priority = 10)
    public void verifyThatTitleWebTablesIsPresent(){
        String expectedText = "Web Tables";
        Assert.assertEquals(webTablesPage.titleWebTables.getText(),expectedText);
    }

    @Test(priority = 20)
    public void verifyThatAddButtonIsClickable(){
        webTablesPage.clickOnAddButton();
        Assert.assertTrue(isDisplayed(webTablesPage.regForm));
        Assert.assertTrue(isDisplayed(webTablesPage.firstNameField));
        Assert.assertTrue(isDisplayed(webTablesPage.lastNameField));
    }

    @Test (priority = 30)
    public void verifyThatSearchBoxIsPresent(){
        Assert.assertTrue(isDisplayed(webTablesPage.searchBox));
        Assert.assertEquals(driver.getCurrentUrl(), webTablesUrl);
    }





    @AfterMethod
    public void closeBrokenImageBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
