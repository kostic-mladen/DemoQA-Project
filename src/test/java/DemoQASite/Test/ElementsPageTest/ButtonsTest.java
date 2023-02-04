package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.ButtonsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonsTest extends BaseTest {

    @BeforeMethod
    public void buttonsPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(buttonsUrl);
        buttonsPage = new ButtonsPage(driver);

    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnButtonsIsVisible() {
        Assert.assertTrue(isDisplayed(buttonsPage.leftPanel));
        buttonsPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
    }

    @Test(priority = 20)
    public void verifyThatLogoImageIsVisibleOnButtonsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
        Assert.assertTrue(isDisplayed(buttonsPage.logoDemoQAButtons));
    }

    @Test(priority = 30)
    public void verityThatTitleButtonsIsValid() {
        String expectedTitle = "Buttons";
        Assert.assertEquals(buttonsPage.titleButtons.getText(), expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
    }


    @Test(priority = 40)
    public void verifyDoubleClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.doubleClickButton);
        doubleClickOnButton(buttonsPage.doubleClickButton);
        Assert.assertTrue(isDisplayed(buttonsPage.doubleClickMessage));
        String expectedText = "You have done a double click";
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedText);
    }

    @Test(priority = 50)
    public void verifyRightClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.rightClickButton);
        Actions a = new Actions(driver);
        a.moveToElement(buttonsPage.rightClickButton).contextClick().build().perform();
        Assert.assertTrue(isDisplayed(buttonsPage.rightClickMessage));
        String expectedText = "You have done a right click";
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), expectedText);
    }

    @Test(priority = 60)
    public void verifyDynamicClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.doubleClickButton);
        scrollToElement(buttonsPage.dynamicClick.get(2));
        buttonsPage.clickOnDynamicClick();
        Assert.assertTrue(isDisplayed(buttonsPage.dynamicClick.get(2)));
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), expectedText);
    }

    @Test(priority = 70)
    public void verifyThatValidFooterIsVisibleOnButtonsPage(){
        scrollToElement(buttonsPage.footerButtons);
        String expectedFooter ="© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(buttonsPage.footerButtons.getText(), expectedFooter);

    }


    @AfterMethod
    public void closeButtonsBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
