package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ButtonsPage extends BaseTest {

    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoDemoQAButtons;

    @FindBy(className = "main-header")
    public WebElement titleButtons;

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> dynamicClick;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerButtons;

    public void clickOnDynamicClick(){
        for(int i = 0; i < dynamicClick.size();i++){
            dynamicClick.get(i).click();
        }
    }


}
