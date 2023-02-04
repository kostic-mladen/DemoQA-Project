package DemoQASite.Test.ElemenetsPageTest;

import DemoQASite.Base.BaseTest;
import DemoQASite.Page.ElemnetsPages.CheckBoxPage;
import DemoQASite.Page.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxTest extends BaseTest {

    @BeforeMethod
    public void checkBoxPageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(checkBoxUrl);
        homePage = new HomePage();
        checkBoxPage = new CheckBoxPage();
    }

    @Test
    public void verifyThatLeftPanelOnCheckBoxIsVisible() {
        Assert.assertTrue(isDisplayed(checkBoxPage.leftPanel));
        checkBoxPage.checkVisibleElements();
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
    }


    @Test
    public void verifyToolsQALogoIsVisibleOnCheckBoxPage() {
        Assert.assertTrue(isDisplayed(checkBoxPage.mainLogo));
    }
    @Test
    public void verifyThatHomeCheckBoxIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnHomeCheckbox();
        Assert.assertTrue(isDisplayed(checkBoxPage.resultMessage));
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
        Assert.assertTrue(isDisplayed(checkBoxPage.selectedCheckBox));
    }

    @Test
    public void verifyThatHomeCheckBoxIsUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        Assert.assertTrue(isDisplayed(checkBoxPage.unSelectedCheckBox));
        Assert.assertTrue(isDisplayed(checkBoxPage.checkBox.get(0)));
    }

    @Test
    public void verifyThatHomeCheckBoxIsUnselectedAfterDoubleClick() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnHomeCheckbox();
        checkBoxPage.clickOnHomeCheckbox();
        waitForVisibility(checkBoxPage.checkBox.get(0));
        Assert.assertTrue(isDisplayed(checkBoxPage.unSelectedCheckBox));
        Assert.assertEquals(driver.getCurrentUrl(), checkBoxUrl);
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test
    public void verifyThatPlusButtonIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        Assert.assertTrue(isDisplayed(checkBoxPage.desktopFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.documentsFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.officeFolder));
        Assert.assertTrue(isDisplayed(checkBoxPage.downloadsFolder));

    }

    @Test
    public void verifyThatMinusButtonIsClickable() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.clickOnMinusButton();
        Assert.assertFalse(isDisplayed(checkBoxPage.desktopFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.documentsFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.officeFolder));
        Assert.assertFalse(isDisplayed(checkBoxPage.downloadsFolder));

    }

    @Test
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

    @Test
    public void verifyThatDesktopCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.checkBox.get(1).click();
        checkBoxPage.checkBox.get(1).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test
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

    @Test
    public void verifyThatDocumentsCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        checkBoxPage.checkBox.get(4).click();
        checkBoxPage.checkBox.get(4).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test
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

    @Test
    public void verifyThatDownloadsCheckBoxCanBeUnSelected() {
        waitForVisibility(checkBoxPage.checkBox.get(0));
        checkBoxPage.clickOnPlusButton();
        scrollToElement(checkBoxPage.checkBox.get(14));
        checkBoxPage.checkBox.get(14).click();
        checkBoxPage.checkBox.get(14).click();
        Assert.assertFalse(isDisplayed(checkBoxPage.resultMessage));
    }

    @Test
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
