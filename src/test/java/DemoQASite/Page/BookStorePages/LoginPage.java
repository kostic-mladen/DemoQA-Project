package DemoQASite.Page.BookStorePages;

import DemoQASite.Base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
}
