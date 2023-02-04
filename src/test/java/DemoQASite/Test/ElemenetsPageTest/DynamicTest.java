package DemoQASite.Test.ElemenetsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.DynamicPropertyPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class DynamicTest extends BaseTest {
    @BeforeMethod
    public void dynamicPageSetUp() throws IOException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(dynamicUrl);
        dynamicPropertyPage = new DynamicPropertyPage();
    }

    @Test
    public void verifyThatLogoOnDynamicPropertyPageIsPresent() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.logoDynamic));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test
    public void verifyThatTitleOnDynamicPropertyPageIsValid() {
        String expectedText = "Dynamic Properties";
        Assert.assertEquals(dynamicPropertyPage.titleDynamic.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test
    public void verifyThatLeftPanelIsVisible() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.leftPanel));
        dynamicPropertyPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test
    public void verifyThatWillEnabled5secondsButtonIsVisible() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(0)));
    }

    @Test
    public void verifyThatColorChangeButtonIsPresent() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(1)));
    }

    @Test
    public void verifyThatColorChangeButtonChangeItsColorAfter5s() {
        waitForVisibility(dynamicPropertyPage.buttonAfterColorChange);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.buttonAfterColorChange));
    }

    @Test
    public void verifyThatColorButtonIsNotVisibleBefore5s() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertFalse(isDisplayed(dynamicPropertyPage.buttonAfterColorChange));
    }

    @Test
    public void verifyThatColorChangeButtonChangeItsColorAfter6s() throws InterruptedException {
        Thread.sleep(6000);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.buttonAfterColorChange));
    }


    @Test
    public void verifyThatVisibleAfter5secondsButtonIsVisible() {
        waitForVisibility(dynamicPropertyPage.buttonAfterColorChange);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(2)));
    }

    @Test
    public void verifyThatFooterIsVisibleOnDynamicPropertyPage(){
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.footerDynamicPage));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }
    @Test
    public void verifyThatFooterIsValidOnDynamicPropertyPage(){
        String expectedText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(dynamicPropertyPage.footerDynamicPage.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }


    @AfterMethod
    public void checkBoxPageClosed() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
