package utilities;

import org.openqa.selenium.WebDriver;
import page.loginPage;

import java.io.IOException;

public class commonMethods
{
    WebDriver driver;
    public commonMethods(WebDriver driver)
    {
        this.driver = driver;
    }
    public void loginactions(String username, String password) throws IOException {
        loginPage lp = new loginPage(driver);
        lp.enterUserName(username);
        lp.enterpassword(password);
        lp.tosignin();
    }
}
