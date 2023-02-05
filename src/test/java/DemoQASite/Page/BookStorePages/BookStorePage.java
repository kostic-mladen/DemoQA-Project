package DemoQASite.Page.BookStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BookStorePage {

    public BookStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "main-header")
    public WebElement titleBookStore;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    public WebElement goToLoginPageButton;

    @FindBy(xpath = "//span[contains(text(),'Book Store API')]")
    public WebElement bookStoreAPIButton;

    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id = "basic-addon2")
    public WebElement magnifier;

    @FindBy(id = "mr-2")
    public List<WebElement> books;

    @FindBy(id = "see-book-Learning JavaScript Design Patterns")
    public WebElement learningJava;

    public void clickOnBookStoriAPIButton(){
        bookStoreAPIButton.click();

    }

    public void clickOnLogin(){
        goToLoginPageButton.click();
    }

    public void clickOnaBook(){
        for(int i =0; i < books.size();i++){
            books.get(i).click();
        }
    }

    public void allBooksOnBookStorePage(){
        for(int i = 0; i < books.size();i++){
            Assert.assertTrue(books.get(i).isDisplayed());
        }
    }
}

