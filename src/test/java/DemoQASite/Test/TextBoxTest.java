package DemoQASite.Test;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElementsPage;
import DemoQASite.Page.HomePage;
import DemoQASite.Page.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest extends BaseTest {

    @BeforeMethod
    public void textBoxPageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(textBoxUrl);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
    }

    @Test
    public void verifyThatLeftPanelOnTextBoxIsVisible() {
        Assert.assertTrue(isDisplayed(textBoxPage.leftPanel));
        textBoxPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), textBoxUrl);
    }

    @Test
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
