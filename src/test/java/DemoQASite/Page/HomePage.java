package DemoQASite.Page;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> listOfElements;

    @FindBy(className = "main-header")
    public WebElement mainTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
    public WebElement mainLogo;

    @FindBy(className = "banner-image")
    public WebElement bannerImage;

    @FindBy(xpath = "//span[contains(text(),'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    public WebElement footerOnHomePage;

    public void clickOnBannerImage() {
        bannerImage.click();
    }

}
