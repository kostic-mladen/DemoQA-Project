package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "left-pannel")
    public WebElement leftPanel;

    @FindBy(className = "main-header")
    public WebElement checkBoxTitle;

    @FindBy(id = "item-0")
    public WebElement textBox;

    @FindBy(className = "rct-checkbox")
    public List<WebElement> checkBox;

    @FindBy(id = "result")
    public WebElement resultMessage;

    @FindBy(css = ".rct-icon.rct-icon-check")
    public WebElement selectedCheckBox;

    @FindBy(css = ".rct-icon.rct-icon-uncheck")
    public WebElement unSelectedCheckBox;

    @FindBy(css = ".rct-option.rct-option-expand-all")
    public WebElement plusExpandAllButton;

    @FindBy(css = ".rct-option.rct-option-collapse-all")
    public WebElement minusCollapseAllButton;

    @FindBy(xpath = "//span[contains(text(),'Desktop')]")
    public WebElement desktopFolder;
    @FindBy(xpath = "//span[contains(text(),'Documents')]")
    public WebElement documentsFolder;

    @FindBy(xpath = "//span[contains(text(),'Office')]")
    public WebElement officeFolder;

    @FindBy(xpath = "//span[contains(text(),'Downloads')]")
    public WebElement downloadsFolder;

    @FindBy(className = "text-success")
    public List<WebElement> textSuccess;

    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement mainLogo;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerCheckBox;

    public void clickOnHomeCheckbox(){
        for(int i = 0; i < checkBox.size();i++){
            checkBox.get(i).click();
        }
    }


    public void clickOnPlusButton(){
        plusExpandAllButton.click();
    }

    public void clickOnMinusButton(){
        minusCollapseAllButton.click();
    }
}
