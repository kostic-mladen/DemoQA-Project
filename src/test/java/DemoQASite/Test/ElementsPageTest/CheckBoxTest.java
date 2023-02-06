package DemoQASite.Test.ElementsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.CheckBoxPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {

    @BeforeMethod
    public void checkBoxPageSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(checkBoxUrl);
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test(priority = 10)
    public void verifyThatLeftPanelOnCheckBoxIsVisible() {
        Assert.assertTrue(isDisplayed(checkBoxPage.leftPanel));
        checkBoxPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
    }


    @Test(priority = 20)
    public void verifyToolsQALogoIsVisibleOnCheckBoxPage() {
        Assert.assertTrue(isDisplayed(checkBoxPage.mainLogo));
    }
    @Test(priority = 30)
    public void verifyThatHomeCheckBoxIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnHomeCheckbox();
        Assert.assertTrue(isDisplayed(checkBoxPage.resultMessage));
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
        Assert.assertTrue(isDisplayed(checkBoxPage.selectedCheckBox));
    }

    @Test(priority = 40)
    public void verifyThatHomeCheckBoxIsUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        Assert.assertTrue(isDisplayed(checkBoxPage.unSelectedCheckBox));
        Assert.assertTrue(isDisplayed(checkBoxPage.checkBox.get(0)));
    }

    @Test(priority = 50)
    public void verifyThatHomeCheckBoxIsUnselectedAfterDoubleClick() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnHomeCheckbox();
        checkBoxPage.clickOnHomeCheckbox();
        waitForVisibility(checkBoxPage.checkBox.get(0));
        Assert.assertTrue(isDisplayed(checkBoxPage.unSelectedCheckBox));
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test(priority = 60)
    public void verifyThatPlusButtonIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        Assert.assertTrue(isDisplayed(checkBoxPage.desktopFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.documentsFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.officeFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.downloadsFolder));

    }

    @Test(priority = 70)
    public void verifyThatMinusButtonIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.clickOnMinusButton();
        Assert.assertFalse(isDisplayed(checkBoxPage.desktopFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.documentsFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.officeFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.downloadsFolder));

    }

    @Test(priority = 80)
    public void verifyThatDesktopCheckBoxIsClickable() throws InterruptedException {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.checkBox.get(1).click();
        scrollToElement(checkBoxPage.resultMessage);
        String successText1 = "desktop";
        String successText2 = "notes";
        String successText3 = "commands";
        Assert.assertEquals(checkBoxPage.textSuccess.get(0).getText(), successText1);
        Assert.assertEquals(checkBoxPage.textSuccess.get(1).getText(), successText2);
        Assert.assertEquals(checkBoxPage.textSuccess.get(2).getText(), successText3);
    }

    @Test(priority = 90)
    public void verifyThatDesktopCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.checkBox.get(1).click();
        checkBoxPage.checkBox.get(1).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test(priority = 100)
    public void verifyThatDocumentsCheckBoxIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        waitForVisibility(checkBoxPage.checkBox.get(4));
        checkBoxPage.checkBox.get(4).click();
        scrollToElement(checkBoxPage.resultMessage);
        String successText1 = "workspace";
        String successText2 = "react";
        String successText3 = "angular";
        String successText4 = "general";
        Assert.assertEquals(checkBoxPage.textSuccess.get(1).getText(), successText1);
        Assert.assertEquals(checkBoxPage.textSuccess.get(2).getText(), successText2);
        Assert.assertEquals(checkBoxPage.textSuccess.get(3).getText(), successText3);
        Assert.assertEquals(checkBoxPage.textSuccess.get(9).getText(), successText4);

    }

    @Test(priority = 110)
    public void verifyThatDocumentsCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.checkBox.get(4).click();
        checkBoxPage.checkBox.get(4).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test(priority = 120)
    public void verifyThatDownloadsCheckBoxIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        scrollToElement(checkBoxPage.checkBox.get(14));
        checkBoxPage.checkBox.get(14).click();
        scrollToElement(checkBoxPage.resultMessage);
        String successText1 = "downloads";
        String successText2 = "wordFile";
        String successText3 = "excelFile";
        Assert.assertEquals(checkBoxPage.textSuccess.get(0).getText(), successText1);
        Assert.assertEquals(checkBoxPage.textSuccess.get(1).getText(), successText2);
        Assert.assertEquals(checkBoxPage.textSuccess.get(2).getText(), successText3);
    }

    @Test(priority = 130)
    public void verifyThatDownloadsCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        scrollToElement(checkBoxPage.checkBox.get(14));
        checkBoxPage.checkBox.get(14).click();
        checkBoxPage.checkBox.get(14).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test(priority = 140)
    public void verifyThatValidFooterIsVisibleOnCheckBoxPage(){
        scrollToElement(checkBoxPage.footerCheckBox);
        String expectedFooter ="© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.";
        Assert.assertEquals(checkBoxPage.footerCheckBox.getText(), expectedFooter);

    }


    @AfterMethod
    public void checkBoxPageClosed(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
