package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.ElementsPage;
import DemoQASite.Page.HomePage;
import DemoQASite.Page.ElemnetsPages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void textBoxPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
       // driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(textBoxUrl);
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnTextBoxIsVisible() {
        Assert.assertTrue(isDisplayed(textBoxPage.leftPanel));
        textBoxPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), textBoxUrl);
    }

    @Test(priority = 20)
    public void verifyTextBoxFormWithValidInputs(){
        waitForVisibility(textBoxPage.fullNameField);
        textBoxPage.insertFullName("Mladen Kostic");
        textBoxPage.insertEmail("mladja995@gmail.com");
        scrollToElement(textBoxPage.currentAddressField);
        textBoxPage.insertCurrentAddress("Omladinskih brigada 41, Novi Beograd");
        scrollToElement(textBoxPage.permanentAddressField);
        textBoxPage.insertPermanentAddress("Prote Mateje 19, Pirot");
        scrollToElement(textBoxPage.submitButton);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), textBoxUrl);
        Assert.assertTrue(isDisplayed(textBoxPage.outputBox));
    }





    @AfterMethod
    public void closeTextBoxBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
