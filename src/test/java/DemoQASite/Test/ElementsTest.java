package DemoQASite.Test;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElementsPage;
import DemoQASite.Page.HomePage;
import DemoQASite.Page.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsTest extends BaseTest {

    @BeforeMethod
    public void elementsPageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(elementsUrl);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
    }

    @Test
    public void verifyThatLeftPanelOnElementsPageIsVisible() {
        Assert.assertTrue(isDisplayed(elementsPage.leftPanel));
        elementsPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), elementsUrl);
    }

    @Test
    public void verifyThatTextBoxButtonIsClickable() {
        waitForClickability(elementsPage.textBox);
        elementsPage.clickOnTextBox();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("TextBox", 1, 0));
        String expectedText = "Text Box";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(textBoxPage.fullNameField));
    }

    @Test
    public void verifyThatCheckBoxButtonIsClickable() {
        waitForClickability(elementsPage.checkBox);
        elementsPage.clickOnCheckBox();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("CheckBox", 1, 0));
        String expectedText = "Check Box";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.plusAndMinusOptions));
    }

    @Test
    public void verifyThatRadioButtonIsClickable() {
        waitForClickability(elementsPage.radioButton);
        elementsPage.clickOnRadioButton();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("RadioButton", 1, 0));
        String expectedText = "Radio Button";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.yesRadioButton));
    }

    @Test
    public void verifyThatWebTablesButtonIsClickable() {
        scrollToElement(elementsPage.webTables);
        waitForClickability(elementsPage.webTables);
        elementsPage.clickOnWebTables();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("WebTables", 1, 0));
        String expectedText = "Web Tables";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.addButtonWebTables));
    }

    @Test
    public void verifyThatButtonsButtonIsClickable() {
        scrollToElement(elementsPage.buttons);
        waitForClickability(elementsPage.buttons);
        elementsPage.clickOnButtons();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("Buttons", 1, 0));
        String expectedText = "Buttons";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.doubleClickButton));
    }

    @Test
    public void verifyThatLinksButtonIsClickable() {
        scrollToElement(elementsPage.links);
        waitForClickability(elementsPage.links);
        elementsPage.clickOnLinks();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("Links", 1, 0));
        String expectedText = "Links";
        Assert.assertEquals(elementsPage.elementsTitle.getText(), expectedText);
        Assert.assertTrue(isDisplayed(elementsPage.HomeLink));
    }

    @AfterMethod
    public void closeElementsBrowserDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
