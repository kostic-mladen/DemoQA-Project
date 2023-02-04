package DemoQASite.Test;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.BrokenImagePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrokenImageTest extends BaseTest {

    @BeforeMethod
    public void brokenImagePageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(brokenImageUrl);
        brokenImagePage = new BrokenImagePage();
    }


    @Test
    public void verifyThatLogoOnBrokenImagePageIsPresent() {
        Assert.assertTrue(isDisplayed(brokenImagePage.logoBrokenImagePage));
        Assert.assertEquals(driver.getCurrentUrl(), brokenImageUrl);
    }

    @Test
    public void verifyThatTitleOnBrokenImagePageIsValid() {
        String expectedText = "Broken Links - Images";
        Assert.assertEquals(brokenImagePage.BrokenImageTitle.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), brokenImageUrl);
    }

    @Test
    public void verifyThatValidImageTextIsPresent() {
        Assert.assertTrue(isDisplayed(brokenImagePage.validImageText));
        String expectedText = "Valid image";
        Assert.assertEquals(brokenImagePage.validImageText.getText(), expectedText);
    }

    @Test
    public void verifyThatValidImageIsVisible() {
        Assert.assertTrue(isDisplayed(brokenImagePage.validImage));
    }

    @Test
    public void verifyThatBrokenImageTextIsPresent() {
        String expectedText = "Broken image";
        Assert.assertEquals(brokenImagePage.brokenImageText.getText(), expectedText);
    }

    @Test
    public void verifyThatValidLinkTextIsPresent() {
        String expectedText = "Valid Link";
        Assert.assertEquals(brokenImagePage.validLinkText.getText(), expectedText);
    }

    @Test
    public void verifyThatUserCanClickOnValidLink() {
        scrollToElement(brokenImagePage.clickOnValidLink);
        brokenImagePage.validLinkClick();
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test
    public void verifyThatBrokenLinkTextIsPresent() {
        String expectedText = "Broken Link";
        Assert.assertEquals(brokenImagePage.brokenLinkText.getText(), expectedText);
    }

    @Test
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
