package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;

import DemoQASite.Page.ElemnetsPages.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void radioButtonPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(radioBoxUrl);
        radioButtonPage = new RadioButtonPage(driver);

    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnElementsPageIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.leftPanel));
        radioButtonPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }
    @Test(priority = 20)
    public void verifyThatLogoImageIsVisibleOnRadioButtonPage() {
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
        Assert.assertTrue(isDisplayed(radioButtonPage.logoDemoQARadioB));
    }

    @Test(priority = 30)
    public void verityThatTitleRadioButtonIsValid() {
        String expectedTitle = "Radio Button";
        Assert.assertEquals(radioButtonPage.titleRadioButton.getText(), expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test(priority = 40)
    public void verifyQuestionOnRadioButtonPage() {
        String expectedText = "Do you like the site?";
        Assert.assertEquals(radioButtonPage.infoQuestion.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test(priority = 50)
    public void verifyThatQuestionIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.infoQuestion));
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test(priority = 60)
    public void verifyThatYesRadioButtonIsSelected() {
        waitForVisibility(radioButtonPage.yesButton);
        radioButtonPage.clickOnYesButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.yesButton));
        String expectedText = "Yes";
        Assert.assertEquals(radioButtonPage.yesButton.getText(), expectedText);
    }

    @Test(priority = 70)
    public void verifyThatImpressiveRadioButtonIsSelected() {
        waitForVisibility(radioButtonPage.impressiveButton);
        radioButtonPage.clickOnImpressiveButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.impressiveButton));
        String expectedText = "Impressive";
        Assert.assertEquals(radioButtonPage.impressiveButton.getText(), expectedText);
    }

    @Test(priority = 80)
    public void verifyThatNoButtonIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.noButton));
        Assert.assertTrue(isDisplayed(radioButtonPage.yesButton));
        Assert.assertTrue(isDisplayed(radioButtonPage.impressiveButton));
    }

    @Test(priority = 90)
    public void verifyThatNoButtonIsNotClickable() {
        waitForVisibility(radioButtonPage.noButton);
        radioButtonPage.clickOnNoButton();
        Assert.assertFalse(isDisplayed(radioButtonPage.textSuccess));
    }

    @Test(priority = 100)
    public void verifyThatValidFooterIsVisibleOnRadioButtonPage() {
        scrollToElement(radioButtonPage.footerRadioButton);
        String expectedFooter = "© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertTrue(isDisplayed(radioButtonPage.footerRadioButton));
        Assert.assertEquals(radioButtonPage.footerRadioButton.getText(), expectedFooter);

    }


    @AfterMethod
    public void closeRadioButtonBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
