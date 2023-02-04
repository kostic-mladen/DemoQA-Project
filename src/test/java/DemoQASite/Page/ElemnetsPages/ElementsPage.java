package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTest {

    public ElementsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(className = "main-header")
    public WebElement elementsTitle;

    @FindBy(xpath = "//span[contains(text(),'Text Box')]")
    public WebElement textBox;

    @FindBy(xpath = "//span[contains(text(),'Check Box')]")
    public WebElement checkBox;

    @FindBy(className = "rct-options")
    public WebElement plusAndMinusOptions;

    @FindBy(xpath = "//span[contains(text(),'Radio Button')]")
    public WebElement radioButton;

    @FindBy(className = "custom-control-label")
    public WebElement yesRadioButton;

    @FindBy(xpath = "//span[contains(text(),'Web Tables')]")
    public WebElement webTables;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButtonWebTables;

    @FindBy(xpath = "//span[contains(text(),'Buttons')]")
    public WebElement buttons;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/span[1]")
    public WebElement links;

    @FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
    public WebElement brokenLinksImage;

    @FindBy(linkText = "Home")
    public WebElement HomeLink;


    public void clickOnTextBox(){
        textBox.click();
    }

    public void clickOnCheckBox(){
        checkBox.click();
    }

    public void clickOnRadioButton(){
        radioButton.click();
    }

    public void clickOnWebTables(){
        webTables.click();
    }

    public void clickOnButtons(){
        buttons.click();
    }

    public void clickOnLinks(){
        links.click();
    }

    public void clickOnBrokenLinksPage(){
        brokenLinksImage.click();
    }
}
