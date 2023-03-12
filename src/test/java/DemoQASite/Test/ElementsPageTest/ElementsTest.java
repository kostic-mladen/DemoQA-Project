package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.BrokenImagePage;
import DemoQASite.Page.ElemnetsPages.ElementsPage;
import DemoQASite.Page.ElemnetsPages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsTest extends BaseTest {

    @BeforeMethod
    public void elementsPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(elementsUrl);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        brokenImagePage = new BrokenImagePage(driver);
    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnElementsPageIsVisible() {
        Assert.assertTrue(isDisplayed(elementsPage.leftPanel));
        elementsPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), elementsUrl);
    }

    @Test(priority = 20)
    public void verifyThatTextBoxButtonIsClickable() {
        waitForClickability(elementsPage.textBox);
        elementsPage.clickOnTextBox();
        Assert.assertEquals(driver.getCurrentUrl(), textBoxUrl);
        String expectedText = "Text Box";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(textBoxPage.fullNameField));
    }

    @Test(priority = 30)
    public void verifyThatCheckBoxButtonIsClickable() {
        waitForClickability(elementsPage.checkBox);
        elementsPage.clickOnCheckBox();
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
        String expectedText = "Check Box";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.plusAndMinusOptions));
    }

    @Test(priority = 40)
    public void verifyThatRadioButtonIsClickable() {
        waitForClickability(elementsPage.radioButton);
        elementsPage.clickOnRadioButton();
        Assert.assertEquals(driver.getCurrentUrl(), radioBoxUrl);
        String expectedText = "Radio Button";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.yesRadioButton));
    }

    @Test(priority = 50)
    public void verifyThatWebTablesButtonIsClickable() {
        scrollToElement(elementsPage.webTables);
        waitForClickability(elementsPage.webTables);
        elementsPage.clickOnWebTables();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("Elements", 1, 4));
        String expectedText = "Web Tables";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.addButtonWebTables));
    }

    @Test(priority = 60)
    public void verifyThatButtonsButtonIsClickable() {
        scrollToElement(elementsPage.buttons);
        waitForClickability(elementsPage.buttons);
        elementsPage.clickOnButtons();
        Assert.assertEquals(driver.getCurrentUrl(), buttonsUrl);
        String expectedText = "Buttons";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.doubleClickButton));
    }

    @Test(priority = 70)
    public void verifyThatLinksButtonIsClickable() {
        scrollToElement(elementsPage.links);
        waitForClickability(elementsPage.links);
        elementsPage.clickOnLinks();
        Assert.assertEquals(driver.getCurrentUrl(), linksUrl);
        String expectedText = "Links";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.HomeLink));
    }
    @Test(priority = 80)
    public void verifyThatBrokenLinkIMageButtonIsClickable() {
        scrollToElement(elementsPage.brokenLinksImage);
        waitForClickability(elementsPage.brokenLinksImage);
        elementsPage.clickOnBrokenLinksPage();
        Assert.assertEquals(driver.getCurrentUrl(), brokenImageUrl);
        String expectedText = "Broken Links - Images";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(brokenImagePage.validImage));
    }

    @AfterMethod
    public void closeElementsBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
