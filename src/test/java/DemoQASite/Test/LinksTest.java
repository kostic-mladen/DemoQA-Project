package DemoQASite.Test;

import DemoQASite.Base.BaseTest;

import DemoQASite.Page.LinksPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class LinksTest extends BaseTest {

    @BeforeMethod
    public void linksPageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(linksUrl);
        linksPage = new LinksPage();
    }

    @Test
    public void verifyThatLeftPanelOnLinksPageIsVisible() {
        Assert.assertTrue(isDisplayed(linksPage.leftPanel));
        linksPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), linksUrl);
    }

    @Test (priority = 10)
    public void verifyThatLogoIsPresentOnLinksPage() {
        Assert.assertTrue(isDisplayed(linksPage.logoDemoQAlinks));
        Assert.assertEquals(driver.getCurrentUrl(), linksUrl);
    }

    @Test(priority = 20)
    public void verifyThatLinksTitleIsPresent() {
        String expectedText = "Links";
        Assert.assertEquals(linksPage.linksTitle.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), linksUrl);
    }

    @Test(priority = 30)
    public void verifyThatMessageIsVisible() { //Following links will open new tab
        String expectedText = "Following links will open new tab";
        Assert.assertEquals(linksPage.newTabMessage.getText(), expectedText);
    }

    @Test(priority = 40)
    public void verifyThatHomeLinkIsClickable() {
        linksPage.clickOnHomeLink();
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test(priority = 50)
    public void verifyThatDynamicHomeLinkIsClickable() {
        linksPage.clickOnDynamicHomeLink();
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), homeUrl);
    }

    @Test(priority = 60)
    public void verifyThatAPIMessageIsVisible() { //Following links will send an api call
        String expectedText = "Following links will send an api call";
        Assert.assertEquals(linksPage.apiMessage.getText(), expectedText);
    }

    @Test(priority = 70)
    public void verifyThatCreatedButtonIsClickable() {
        waitForVisibility(linksPage.created);
        linksPage.clickOnCreated();
        String expectedText = "Link has responded with staus 201 and status text Created";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 80)
    public void verifyThatNoContentButtonIsClickable() {
        linksPage.clickOnNoContent();
        String expectedText = "Link has responded with staus 204 and status text No Content";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 90)
    public void verifyThatMovedButtonIsClickable() {
        scrollToElement(linksPage.moved);
        linksPage.clickOnMoved();
        String expectedText = "Link has responded with staus 301 and status text Moved Permanently";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 100)
    public void verifyThatBadRequestButtonIsClickable() {
        scrollToElement(linksPage.badRequest);
        linksPage.clickOnBadRequest();
        String expectedText = "Link has responded with staus 400 and status text Bad Request";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 110)
    public void verifyThatUnauthorizedButtonIsClickable() {
        waitForVisibility(linksPage.unauthorized);
        scrollToElement(linksPage.unauthorized);
        linksPage.clickOnUnAuthorize();
        String expectedText = "Link has responded with staus 401 and status text Unauthorized";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 120)
    public void verifyThatForbiddenButtonIsClickable() {
        scrollToElement(linksPage.forbidden);
        linksPage.clickOnForbidden();
        String expectedText = "Link has responded with staus 403 and status text Forbidden";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 130)
    public void verifyThatNotFoundButtonIsClickable() {
        waitForVisibility(linksPage.invalidUrl);
        scrollToElement(linksPage.invalidUrl);
        linksPage.clickOnInvalidUrl();
        String expectedText = "Link has responded with staus 404 and status text Not Found";
        scrollToElement(linksPage.linkResponse);
        Assert.assertEquals(linksPage.linkResponse.getText(), expectedText);
    }

    @Test(priority = 140)
    public void verifyThatFooterIsPresent(){
        scrollToElement(linksPage.footerLinks);
        String expectedText = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(linksPage.footerLinks.getText(), expectedText);
    }


    @AfterMethod
    public void closeLinksBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}