package DemoQASite.Page.ElemnetsPages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage extends BaseTest {

    public UploadAndDownloadPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "left-pannel")
    public WebElement leftPanel;
    @FindBy(id = "uploadFile")
    public WebElement uploadButton;

    @FindBy(id = "uploadedFilePath")
    public WebElement messageAfterUpload;

    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    public void uploadFile(){
        uploadButton.sendKeys("C:\\Users\\Administrator\\Desktop\\image.png");
    }

    public void clickOnDownloadButton(){
        downloadButton.click();
    }
}
