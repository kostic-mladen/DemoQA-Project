package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.UploadAndDownloadPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadAndDownloadTest extends BaseTest {

    @BeforeMethod
    public void uploadPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(uploadAndDownloadUrl);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnUploadPageIsVisible() {
        Assert.assertTrue(isDisplayed(uploadAndDownloadPage.leftPanel));
        uploadAndDownloadPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), uploadAndDownloadUrl);
    }

    @Test(priority = 20)
    public void verifyThatUserCanUploadAFile() throws InterruptedException {
        uploadAndDownloadPage.uploadFile();
        Assert.assertTrue(isDisplayed(uploadAndDownloadPage.messageAfterUpload));

    }

    @Test(priority = 30)
    public void verifyThatUserCanDownloadUploadedFile() throws InterruptedException {
        uploadAndDownloadPage.uploadFile();
        waitForVisibility(uploadAndDownloadPage.messageAfterUpload);
        uploadAndDownloadPage.clickOnDownloadButton();
        Thread.sleep(5000);

    }


    @AfterMethod
    public void closeBrokenImageBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
