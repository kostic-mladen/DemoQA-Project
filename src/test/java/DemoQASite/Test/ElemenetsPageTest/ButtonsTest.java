package DemoQASite.Test.ElemenetsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.ButtonsPage;
import org.openqa.selenium.chrome.ChromeDriver;
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
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(buttonsUrl);
        buttonsPage = new ButtonsPage();

    }

    @Test
    public void verifyThatLeftPanelOnButtonsIsVisible() {
        Assert.assertTrue(isDisplayed(buttonsPage.leftPanel));
        buttonsPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
    }

    @Test
    public void verifyThatLogoImageIsVisibleOnButtonsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
        Assert.assertTrue(isDisplayed(buttonsPage.logoDemoQAButtons));
    }

    @Test
    public void verityThatTitleButtonsIsValid() {
        String expectedTitle = "Buttons";
        Assert.assertEquals(buttonsPage.titleButtons.getText(), expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
    }


    @Test
    public void verifyDoubleClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.doubleClickButton);
        doubleClickOnButton(buttonsPage.doubleClickButton);
        Assert.assertTrue(isDisplayed(buttonsPage.doubleClickMessage));
        String expectedText = "You have done a double click";
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedText);
    }

    @Test
    public void verifyRightClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.rightClickButton);
        Actions a = new Actions(driver);
        a.moveToElement(buttonsPage.rightClickButton).contextClick().build().perform();
        Assert.assertTrue(isDisplayed(buttonsPage.rightClickMessage));
        String expectedText = "You have done a right click";
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), expectedText);
    }

    @Test
    public void verifyDynamicClickOnButtonsPageIsClickable(){
        waitForVisibility(buttonsPage.doubleClickButton);
        scrollToElement(buttonsPage.dynamicClick.get(2));
        buttonsPage.clickOnDynamicClick();
        Assert.assertTrue(isDisplayed(buttonsPage.dynamicClick.get(2)));
        String expectedText = "You have done a dynamic click";
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), expectedText);
    }

    @Test
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
