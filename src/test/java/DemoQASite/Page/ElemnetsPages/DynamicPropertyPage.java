package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DynamicPropertyPage extends BaseTest {

    public DynamicPropertyPage(WebDriver driver) {


        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mt-4.btn.btn-primary")
    public List<WebElement> listOfButtons;

    @FindBy(css = ".mt-4.text-danger.btn.btn-primary")
    public WebElement buttonAfterColorChange;

    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoDynamic;

    @FindBy(className = "main-header")
    public WebElement titleDynamic;

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerDynamicPage;

    @FindBy(id = "visibleAfter")
    public WebElement visibleAfterButton;

}
