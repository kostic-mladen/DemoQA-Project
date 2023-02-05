package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BaseTest {
    public WebTablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement titleWebTables;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(className = "modal-content")
    public WebElement regForm;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(className = "searchBox")
    public WebElement searchBox;

    public void clickOnAddButton(){
        addButton.click();
    }
}
