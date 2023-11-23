package DemoQASite.Base;

import DemoQASite.Page.*;
import DemoQASite.Page.BookStorePages.BookStorePage;
import DemoQASite.Page.BookStorePages.LoginPage;
import DemoQASite.Page.BookStorePages.ProfilePage;
import DemoQASite.Page.ElemnetsPages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;

    public HomePage homePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPage radioButtonPage;

    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public BrokenImagePage brokenImagePage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertyPage dynamicPropertyPage;
    public BookStorePage bookStorePage;
    public LoginPage loginPage;

    public ProfilePage profilePage;

    public LinksPage linksPage;
    public String homeUrl;
    public String elementsUrl;
    public String textBoxUrl;
    public String checkBoxUrl;
    public String radioBoxUrl;
    public String webTablesUrl;
    public String buttonsUrl;
    public String linksUrl;
    public String brokenImageUrl;
    public String brokenLinkUrl;
    public String uploadAndDownloadUrl;
    public String dynamicUrl;
    public String loginUrl;
    public String bookStoreUrl;
    public String profileUrl;
    public String registerUrl;


    @BeforeClass
    public void setUp() throws IOException {
        excelReader = new ExcelReader("src/test/java/DemoQASite/TestData.xlsx");
        homeUrl = excelReader.getStringData("HomePage", 1, 0);
        elementsUrl = excelReader.getStringData("Elements", 1, 0);
        textBoxUrl = excelReader.getStringData("Elements", 1, 1);
        checkBoxUrl = excelReader.getStringData("Elements", 1, 2);
        radioBoxUrl = excelReader.getStringData("Elements", 1, 3);
        webTablesUrl = excelReader.getStringData("Elements", 1,4);
        buttonsUrl = excelReader.getStringData("Elements", 1, 5);
        linksUrl = excelReader.getStringData("Elements", 1, 6);
        brokenImageUrl = excelReader.getStringData("Elements", 1, 7);
        brokenLinkUrl = excelReader.getStringData("Elements", 2, 7);
        uploadAndDownloadUrl = excelReader.getStringData("Elements", 1, 8);
        dynamicUrl = excelReader.getStringData("Elements", 1, 9);
        loginUrl = excelReader.getStringData("BookStore",3,0);
        bookStoreUrl = excelReader.getStringData("BookStore",1,0);
        profileUrl = excelReader.getStringData("BookStore", 5,0);
        registerUrl = excelReader.getStringData("BookStore", 7,0);
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForApplicability(WebElement element) {
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
