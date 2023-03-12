package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.BrokenImagePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrokenImageTest extends BaseTest {

    @BeforeMethod
    public void brokenImagePageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(brokenImageUrl);
        brokenImagePage = new BrokenImagePage(driver);
    }


    @Test(priority = 10)
    public void verifyThatLogoOnBrokenImagePageIsPresent() {
        Assert.assertTrue(isDisplayed(brokenImagePage.logoBrokenImagePage));
        Assert.assertEquals(driver.getCurrentUrl(), brokenImageUrl);
    }

    @Test(priority = 20)
    public void verifyThatTitleOnBrokenImagePageIsValid() {
        String expectedText = "Broken Links - Images";
        Assert.assertEquals(brokenImagePage.BrokenImageTitle.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), brokenImageUrl);
    }

    @Test(priority = 30)
    public void verifyThatValidImageTextIsPresent() {
        Assert.assertTrue(isDisplayed(brokenImagePage.validImageText));
        String expectedText = "Valid image";
        Assert.assertEquals(brokenImagePage.validImageText.getText(), expectedText);
    }

    @Test(priority = 40)
    public void verifyThatValidImageIsVisible() {
        Assert.assertTrue(isDisplayed(brokenImagePage.validImage));
    }

    @Test(priority = 50)
    public void verifyThatBrokenImageTextIsPresent() {
        String expectedText = "Broken image";
        Assert.assertEquals(brokenImagePage.brokenImageText.getText(), expectedText);
    }

    @Test(priority = 60)
    public void verifyThatValidLinkTextIsPresent() {
        String expectedText = "Valid Link";
        Assert.assertEquals(brokenImagePage.validLinkText.getText(), expectedText);
    }

    @Test(priority = 70)
    public void verifyThatUserCanClickOnValidLink() {
        scrollToElement(brokenImagePage.clickOnValidLink);
        brokenImagePage.validLinkClick();
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test(priority = 80)
    public void verifyThatBrokenLinkTextIsPresent() {
        String expectedText = "Broken Link";
        Assert.assertEquals(brokenImagePage.brokenLinkText.getText(), expectedText);
    }

    @Test(priority = 90)
    public void verifyThatUserCanClickOnBrokenLink(){
        scrollToElement(brokenImagePage.clickOnBrokenLink);
        brokenImagePage.brokenLinkClick();
        Assert.assertEquals(driver.getCurrentUrl(), brokenLinkUrl);
        String expectedText = "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        Assert.assertEquals(brokenImagePage.statusCode.getText(), expectedText);

    }


    @AfterMethod
    public void closeBrokenImageBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
