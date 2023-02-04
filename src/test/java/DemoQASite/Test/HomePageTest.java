package DemoQASite.Test;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElementsPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(homeUrl);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
    }

    @Test
    public void siteCheck() {

    }

    @Test(priority = 9)
    public void verifyThatAllButtonsOnHomePageAreClickable() throws InterruptedException {
        for (int i = 0; i < homePage.listOfElements.size(); i++) {
            scrollToElement(homePage.listOfElements.get(i));
            waitForClickability(homePage.listOfElements.get(i));
            homePage.listOfElements.get(i).click();
            Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
            driver.navigate().back();
        }
    }

    @Test(priority = 10)
    public void verifyElementsButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(0));
        homePage.listOfElements.get(0).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("Elements", 1, 0));
        String expectedText = "Elements";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 20)
    public void verifyFormsButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(1));
        homePage.listOfElements.get(1).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        String expectedText = "Forms";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertFalse(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 30)
    public void verifyAlertsButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(2));
        homePage.listOfElements.get(2).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        String expectedText = "Alerts, Frame & Windows";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertFalse(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 40)
    public void verifyWidgetsButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(3));
        homePage.listOfElements.get(3).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        String expectedText = "Widgets";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertFalse(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 50)
    public void verifyInteractionsButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(4));
        homePage.listOfElements.get(4).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        String expectedText = "Interactions";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertFalse(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 60)
    public void verifyBookStoreButtonIsClickable() {
        scrollToElement(homePage.listOfElements.get(5));
        homePage.listOfElements.get(5).click();
        Assert.assertNotEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        String expectedText = "Book Store";
        Assert.assertEquals(homePage.mainTitle.getText(), expectedText);
        Assert.assertFalse(isDisplayed(elementsPage.textBox));
    }

    @Test(priority = 60)
    public void verifyThatUserCanNotClickBookStoreButtonWithRightClick() {
        scrollToElement(homePage.listOfElements.get(5));
        Actions a = new Actions(driver);
        a.moveToElement(homePage.listOfElements.get(5)).contextClick().build().perform();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        Assert.assertTrue(isDisplayed(homePage.bannerImage));
    }

    @Test(priority = 70)
    public void verifyToolsQALogoIsVisible() {
        Assert.assertTrue(isDisplayed(homePage.mainLogo));
    }

    @Test(priority = 80)
    public void verifyBannerImageIsVisible() {
        Assert.assertTrue(isDisplayed(homePage.bannerImage));
    }

    @Test(priority = 90)
    public void verifyThatBannerImageIsClickableAndTakesUserToToolsQAPage() {
        homePage.clickOnBannerImage();
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("ToolsQA", 1, 0));
    }

    @Test (priority = 100)
    public void verifyThatFooterOnHomePageIsValid(){
        String expectedText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(homePage.footerOnHomePage.getText(), expectedText);
    }

    @AfterMethod
    public void closeDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
