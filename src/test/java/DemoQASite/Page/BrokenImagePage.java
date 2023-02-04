package DemoQASite.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static DemoQASite.Base.BaseTest.driver;

public class BrokenImagePage {

    public BrokenImagePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoBrokenImagePage;

    @FindBy(className = "main-header")
    public WebElement BrokenImageTitle;

    @FindBy(xpath = "//p[contains(text(),'Valid image')]")
    public WebElement validImageText;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/img[1]")
    public WebElement validImage;

    @FindBy(xpath = "//p[contains(text(),'Broken image')]")
    public WebElement brokenImageText;

    @FindBy(xpath = "//p[contains(text(),'Valid Link')]")
    public WebElement validLinkText;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement clickOnValidLink;

    @FindBy(xpath = "//p[contains(text(),'Broken Link')]")
    public WebElement brokenLinkText;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement clickOnBrokenLink;

    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/p[1]")
    public WebElement statusCode;

    @FindBy(linkText = "here")
    public WebElement here;

    public void validLinkClick(){
        clickOnValidLink.click();
    }
    public void brokenLinkClick(){
        clickOnBrokenLink.click();
    }
}
