package DemoQASite.Base;

import DemoQASite.Page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;

    public HomePage homePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;

    public ButtonsPage buttonsPage;
    public BrokenImagePage brokenImagePage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertyPage dynamicPropertyPage;

    public LinksPage linksPage;
    public String homeUrl;
    public String elementsUrl;
    public String textBoxUrl;
    public String checkBoxUrl;
    public String radioBoxUrl;
    public String buttonsUrl;
    public String linksUrl;
    public String brokenImageUrl;
    public String brokenLinkUrl;
    public String uploadAndDownloadUrl;
    public String dynamicUrl;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("src/test/java/DemoQASite/TestData.xlsx");
        homeUrl = excelReader.getStringData("URL", 1, 0);
        elementsUrl = excelReader.getStringData("Elements", 1, 0);
        textBoxUrl = excelReader.getStringData("TextBox", 1, 0);
        checkBoxUrl = excelReader.getStringData("CheckBox", 1, 0);
        radioBoxUrl = excelReader.getStringData("RadioButton", 1, 0);
        buttonsUrl = excelReader.getStringData("Buttons", 1, 0);
        linksUrl = excelReader.getStringData("Links", 1, 0);
        brokenImageUrl = excelReader.getStringData("BrokenImage", 1, 0);
        brokenLinkUrl = excelReader.getStringData("BrokenImage", 1, 1);
        uploadAndDownloadUrl = excelReader.getStringData("Upload", 1, 0);
        dynamicUrl = excelReader.getStringData("Dynamic", 1, 0);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

    public void doubleClickOnButton(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", element);
    }

    @FindBy(className = "header-text")
    public List<WebElement> listOfElements;

    public void checkVisibleElements() {
        String elements = "Elements";
        String forms = "Forms";
        String alerts = "Alerts, Frame & Windows";
        String widgets = "Widgets";
        String interactions = "Interactions";
        String bookStore = "Book Store Application";
        Assert.assertEquals(listOfElements.get(0).getText(), elements);
        Assert.assertEquals(listOfElements.get(1).getText(), forms);
        Assert.assertEquals(listOfElements.get(2).getText(), alerts);
        Assert.assertEquals(listOfElements.get(3).getText(), widgets);
        Assert.assertEquals(listOfElements.get(4).getText(), interactions);
        Assert.assertEquals(listOfElements.get(5).getText(), bookStore);
    }

}
