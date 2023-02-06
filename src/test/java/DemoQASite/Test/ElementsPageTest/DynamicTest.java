package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.DynamicPropertyPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(dynamicUrl);
        dynamicPropertyPage = new DynamicPropertyPage(driver);
    }

    @Test(priority = 10)
    public void verifyThatLogoOnDynamicPropertyPageIsPresent() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.logoDynamic));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test(priority = 20)
    public void verifyThatTitleOnDynamicPropertyPageIsValid() {
        String expectedText = "Dynamic Properties";
        Assert.assertEquals(dynamicPropertyPage.titleDynamic.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test(priority = 30)
    public void verifyThatLeftPanelIsVisible() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.leftPanel));
        dynamicPropertyPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }

    @Test(priority = 40)
    public void verifyThatWillEnabled5secondsButtonIsVisible() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(0)));
    }

    @Test(priority = 50)
    public void verifyThatColorChangeButtonIsPresent() {
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(1)));
    }

    @Test(priority = 60)
    public void verifyThatColorChangeButtonChangeItsColorAfter5s() {
        waitForVisibility(dynamicPropertyPage.buttonAfterColorChange);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.buttonAfterColorChange));
    }

    @Test(priority = 70)
    public void verifyThatColorChangeButtonChangeItsColorAfter6s() throws InterruptedException {
        Thread.sleep(6000);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.visibleAfterButton));
    }


    @Test(priority = 90)
    public void verifyThatVisibleAfter5secondsButtonIsVisible() {
        waitForVisibility(dynamicPropertyPage.buttonAfterColorChange);
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.listOfButtons.get(2)));
    }

    @Test(priority = 100)
    public void verifyThatFooterIsVisibleOnDynamicPropertyPage(){
        Assert.assertTrue(isDisplayed(dynamicPropertyPage.footerDynamicPage));
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }
    @Test(priority = 110)
    public void verifyThatFooterIsValidOnDynamicPropertyPage(){
        String expectedText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(dynamicPropertyPage.footerDynamicPage.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), dynamicUrl);
    }


    @AfterMethod
    public void dynamicPageClosed() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
