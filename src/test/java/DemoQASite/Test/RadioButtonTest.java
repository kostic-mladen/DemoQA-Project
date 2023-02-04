package DemoQASite.Test;

import DemoQASite.Base.BaseTest;

import DemoQASite.Page.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void radioButtonPageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(radioBoxUrl);
        radioButtonPage = new RadioButtonPage();

    }

    @Test
    public void verifyThatLeftPanelOnElementsPageIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.leftPanel));
        radioButtonPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }
    @Test
    public void verifyThatLogoImageIsVisibleOnRadioButtonPage() {
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
        Assert.assertTrue(isDisplayed(radioButtonPage.logoDemoQARadioB));
    }

    @Test
    public void verityThatTitleRadioButtonIsValid() {
        String expectedTitle = "Radio Button";
        Assert.assertEquals(radioButtonPage.titleRadioButton.getText(), expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test
    public void verifyQuestionOnRadioButtonPage() {
        String expectedText = "Do you like the site?";
        Assert.assertEquals(radioButtonPage.infoQuestion.getText(), expectedText);
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test
    public void verifyThatQuestionIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.infoQuestion));
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
    }

    @Test
    public void verifyThatYesRadioButtonIsSelected() {
        waitForVisibility(radioButtonPage.yesButton);
        radioButtonPage.clickOnYesButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.yesButton));
        String expectedText = "Yes";
        Assert.assertEquals(radioButtonPage.yesButton.getText(), expectedText);
    }

    @Test
    public void verifyThatImpressiveRadioButtonIsSelected() {
        waitForVisibility(radioButtonPage.impressiveButton);
        radioButtonPage.clickOnImpressiveButton();
        Assert.assertTrue(isDisplayed(radioButtonPage.impressiveButton));
        String expectedText = "Impressive";
        Assert.assertEquals(radioButtonPage.impressiveButton.getText(), expectedText);
    }

    @Test
    public void verifyThatNoButtonIsVisible() {
        Assert.assertTrue(isDisplayed(radioButtonPage.noButton));
        ;
        Assert.assertTrue(isDisplayed(radioButtonPage.yesButton));
        Assert.assertTrue(isDisplayed(radioButtonPage.impressiveButton));
    }

    @Test
    public void verifyThatNoButtonIsNotClickable() {
        waitForVisibility(radioButtonPage.noButton);
        radioButtonPage.clickOnNoButton();
        Assert.assertFalse(isDisplayed(radioButtonPage.textSuccess));
    }

    @Test
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
