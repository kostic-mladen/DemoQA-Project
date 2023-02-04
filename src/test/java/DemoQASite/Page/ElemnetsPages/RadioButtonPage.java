package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class RadioButtonPage extends BaseTest {

    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoDemoQARadioB;

    @FindBy(className = "main-header")
    public WebElement titleRadioButton;

    @FindBy(className = "mb-3")
    public WebElement infoQuestion;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]")
    public WebElement yesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]")
    public WebElement impressiveButton;

    @FindBy(className = "text-success")
    public WebElement textSuccess;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]")
    public WebElement noButton;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]]")
    public WebElement footerRadioButton;

    public void clickOnYesButton(){
        yesButton.click();
    }

    public void clickOnImpressiveButton(){
        impressiveButton.click();
    }

    public void clickOnNoButton(){
        noButton.click();
    }

}
