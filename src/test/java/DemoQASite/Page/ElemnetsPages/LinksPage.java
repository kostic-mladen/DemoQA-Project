package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(className = "main-header")
    public WebElement linksTitle;

    @FindBy(xpath = "//header/a[1]/img[1]")
    public WebElement logoDemoQAlinks;

    @FindBy(xpath = "//strong[contains(text(),'Following links will open new tab')]")
    public WebElement newTabMessage;

    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicHomeLink;

    @FindBy(xpath = "//strong[contains(text(),'Following links will send an api call')]")
    public WebElement apiMessage;

    @FindBy(id = "created")
    public WebElement created;

    @FindBy(id = "no-content")
    public WebElement noContent;

    @FindBy(id = "moved")
    public WebElement moved;

    @FindBy(id = "bad-request")
    public WebElement badRequest;

    @FindBy(id = "unauthorized")
    public WebElement unauthorized;

    @FindBy(id = "forbidden")
    public WebElement forbidden;

    @FindBy(id = "invalid-url")
    public WebElement invalidUrl;

    @FindBy(id = "linkResponse")
    public WebElement linkResponse;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerLinks;


    public void clickOnHomeLink() {
        homeLink.click();
    }

    public void clickOnDynamicHomeLink() {
        dynamicHomeLink.click();
    }

    public void clickOnCreated() {
        created.click();
    }

    public void clickOnNoContent() {
        noContent.click();
    }

    public void clickOnMoved() {
        moved.click();
    }

    public void clickOnBadRequest() {
        badRequest.click();
    }

    public void clickOnUnAuthorize() {
        unauthorized.click();
    }

    public void clickOnForbidden() {
        forbidden.click();
    }

    public void clickOnInvalidUrl() {
        invalidUrl.click();
    }
}
